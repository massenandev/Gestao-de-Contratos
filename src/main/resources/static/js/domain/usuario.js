//INITIALIZE
$(document).ready(function(){
	listaUsuarios();
	initModalCadastro();
	initDialogStatus();
	cadastrar();
	alterarStatus();
	listaPerfis();
});

// [ PUBLIC FUNCTION ] -------------------------------------------------------------------------------//

var PARAMS = null;

function listaUsuarios(){
	$.ajax({
		type:'GET',
		url: 'http://localhost:8080/api/usuarios/listar',
		cache: false,
		timeOut: 600000,
		contentType: 'json',
		statusCode: {
			200: function(usuarios){
				buildTable(usuarios);
			},
			500: function(ex){
				console.error('Ocorreu um erro.' + ex);
			}
		}
	});
}

function listaPerfis(){
	$.ajax({
		type:'GET',
		url: 'http://localhost:8080/api/usuarios/listarperfil',
		cache: false,
		timeOut: 600000,
		contentType: 'json',
		statusCode: {
			200: function(perfils){
				montaListaPerfil(perfils);
			},
			500: function(ex){
				messagePanelError('Ocorreu um erro no sistema, tente mais tarde.');
				console.error('Ocorreu um erro.' + ex.status);
			}
		}
	});
}

function cadastrar(){
	$('#cadastraUsuarioID').click(function(){
		if( validar(null) != null ){
			var id = $('#hiddenID').val();
			
			if(id == ''){//cadastrar
				var usuario = validar(null);
				cadastrarUsuarioAjax(usuario);
				cpCloseModal('#modalCadUsuarioID');
				configBotaoLabel(null);
				
			}else {//atualizar
				var usuario = validar(id);
				atualizarUsuarioAjax(usuario);
				cpCloseModal('#modalCadUsuarioID');
				configBotaoLabel(null);
			}
			
		}
	});
}

function alterarUsuario(line){
	var values = getLineTable(line);
	$('#usrnameID').val(values[2]);
	$('#hiddenID').val(values[0]);
	configBotaoLabel(values[0]);
	cpOpenModal('#modalCadUsuarioID');
}

function alterarStatus(){
	$('#confirmarAtivoID').click(function(){
		var status = PARAMS[1] ? false : true;
		atualizarStatus(PARAMS[0], status);
		cpConfirmCloseDialog('#dialogStatusID');
	});
}

function exibirDialogStatus(obj, ativo){
	var valores = getLineTable(obj);
	var msg     = ativo ? 'Deseja desativar o usuario?' : 'Deseja ativar o usuario?';  
	PARAMS      = [];
	
	PARAMS.push(Number(valores[0]));
	PARAMS.push(ativo);
	$('#questionID').text(msg);
	cpConfirmOpenDialog('#dialogStatusID');
}


// [ PRIVATE FUNCTIONS ] -------------------------------------------------------------------------------------------/
function atualizarStatus(id, status){
	$.ajax({
		type:'PUT',
		url: 'http://localhost:8080/api/usuarios/status/'+status+'/id/'+id,
		cache: false,
		timeOut: 600000,
		contentType: "text/html; charset=utf-8",
		statusCode: {
			200: function(usuarios){
				buildTable(usuarios);
				var msg = status ? 'Usuario ativado com sucesso.' : 'Usuario desativado com sucesso';
				messagePanelSuccess(msg);
			},
			500: function(ex){
				messagePanelError('Ocorreu um erro no sistema, tente mais tarde.');
				console.error('Ocorreu um erro no sistema.' + ex.status);
			}
		}
	});
}

function atualizarPerfil(id, perfil){
	$.ajax({
		type:'PUT',
		url: 'http://localhost:8080/api/usuarios/atualizarperfil/'+perfil+'/id/'+id,
		cache: false,
		timeOut: 600000,
		contentType: "text/html; charset=utf-8",
		statusCode: {
			200: function(usuarios){
				buildTable(usuarios);
				messagePanelSuccess('Perfil do usuario atualizado com sucesso.');
			},
			500: function(ex){
				messagePanelError('Ocorreu um erro no sistema, tente mais tarde.');
				console.error('Ocorreu um erro no sistema.' + ex.status);
			}
		}
	});
}


function cadastrarUsuarioAjax(usuario){
	$.ajax({
		type: 'POST',
		url: 'http://localhost:8080/api/usuarios/criar',
		data: usuario,
		cache: false,
		timeOut: 600000,
		contentType: "application/json; charset=utf-8",
		statusCode: {
			200: function(usuarios){
				buildTable(usuarios);
				messagePanelSuccess('Usuário cadastrado com sucesso.');
			},
			500: function(ex){
				messagePanelError('Ocorreu um erro no cadastro. Tente mais tarde.');
				console.error('Ocorreu um erro. ' + ex);
			}
		}
	});
}

function atualizarUsuarioAjax(usuario){
	$.ajax({
		type: 'PUT',
		url: 'http://localhost:8080/api/usuarios/atualizar',
		data: usuario,
		cache: false,
		timeOut: 600000,
		contentType: "application/json; charset=utf-8",
		statusCode: {
			200: function(usuarios){
				buildTable(usuarios);
				messagePanelSuccess('Usuário atualizado com sucesso.');
			},
			500: function(ex){
				messagePanelError('Ocorreu um erro no cadastro. Tente mais tarde.');
				console.error('Ocorreu um erro. ' + ex.status);
			}
		}
	});
}

function initModalCadastro(){
	var fields = ['#usrnameID'];
	var modal  = {'modal':'#modalCadUsuarioID','width':'16%','open':'#btnAbrirModalID','cancel':'#cancelaUsuarioID','fields':fields};
	cpModal(modal);
}

function initDialogStatus(){
	var obj = {'modal':'#dialogStatusID','width':'14%','cancel':'#closeAtivoID'};
	cpConfirmDialogInit(obj);
}


/**
 * Valida o cadastro da cidade
 * @returns
 */
function validar(id){
	var username = $('#usrnameID').val();
	
	if(username	 == ''){
		showMessageWarning('#msgCadUsuario', 'Informe todos os campos.');
		return null;
	}else {
		return '{"id":"'+id+'","username":"'+username+'"}';
		
	}
}
/**
 * Monta a tabela de usuarios
 * @param usuarios
 * @returns
 */

function buildTable(usuarios){
	$('#tblUsuariosID tbody > tr').remove();
	
	usuarios.forEach(function(usr){ 	
			var $tr = $('<tr>').append(
               $('<td style="display:none;">').text(usr.id),
               $('<td>').text(usr.perfil),
               $('<td>').text(usr.username),
           	   $('<td>').html(getBooleanIcon(usr.pendente)),
           	   $('<td>').text(formatShortDate(usr.dtCadastro)),
           	   $('<td>').text(formatShortDate(usr.dtUltAlt)),
           	   $('<td onclick="exibirDialogStatus(this, '+usr.ativo+')">').html($('<a href="#"></a>').append(getBooleanIcon(usr.ativo))),
           	   $('<td onclick="alterarUsuario(this)">').html($('<a href="#"></a>').prepend(getIcon(2)))
	        );
		 	
		$('#tblUsuariosID').append($tr);
	});
}

function configBotaoLabel(id){
	if(id != '' && id != null){
		$('#cadastraUsuarioID').text('Atualizar');
	}else {
		$('#cadastraUsuarioID').text('Cadastrar');
	}
}

function montaListaPerfil(perfis){
	var cont = 1;
	perfis.forEach(function(p){
		console.log(p);
		$('#perfilID').append( new Option(p, cont++) );
	});
}