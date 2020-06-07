//INITIALIZE
$(document).ready(function(){
	listaUsuarios();
	initModalCadastro();
	initDialogStatus();
	cadastrar();
	alterarStatus();
	listaPerfis();
	initModalAtualizar();
	confirmarAtualizacao();
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

function confirmarAtualizacao(){
	$('#atualizaUsuarioID').click(function(){
		var selected = $('#perfilAtlzrID option:selected').text();
		if(validaPerfil(selected)){
			alterarUsuario();
		}
	});
}

function alterarUsuario(){
	var perfil = $('#perfilAtlzrID option:selected').text();
	var id 	   = PARAMS;
	atualizarPerfilUsuarioAjax(perfil, id);
	cpCloseModal('#modalAtualizaUsuarioID');
}

function validaPerfil(selected){
	if(selected == 'Selecione'){
		showMessageWarning('#msgAtualizaUsuario', 'Informe o perfil.');
		return false;
	} else {
		return true;
	}
}

function cadastrar(){
	$('#cadastraUsuarioID').click(function(){
		if(validarCadastro()){
			var perfil   = $('#perfilCadID option:selected').text();
			var username = $('#usrnameCadID').val();
			var usuario  = '{"perfil":"'+perfil+'","senha":"123456","username":"'+username+'"}';
			cadastrarUsuarioAjax(usuario);
			cpCloseModal('#modalCadUsuarioID');
		}
	});
}

function validarCadastro(){
	var perfil   = $('#perfilCadID option:selected').text();
	var username = $('#usrnameCadID').val();
	
	if(perfil == 'Selecione' | username == ''){
		showMessageWarning('#msgCadUsuario', 'Informe todos os campos.');
		return false;
	} else {
		return true;
	}
}

function exibirMdUsuario(line){
	var values = getLineTable(line);
	PARAMS 	   = values[0];
	cpOpenModal('#modalAtualizaUsuarioID');
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

function atualizarPerfilUsuarioAjax(perfil, id){
	$.ajax({
		type: 'PUT',
		url: 'http://localhost:8080/api/usuarios/atualizarperfil/'+perfil+'/id/'+id,
		cache: false,
		timeOut: 600000,
		contentType: "text/html; charset=utf-8",
		statusCode: {
			200: function(usuarios){
				buildTable(usuarios);
				messagePanelSuccess('Perfil de usuário atualizado com sucesso.');
			},
			500: function(ex){
				messagePanelError('Ocorreu um erro no cadastro. Tente mais tarde.');
				console.error('Ocorreu um erro. ' + ex.status);
			}
		}
	});
}

function initModalCadastro(){
	var fields = ['#usrnameCadID'];
	var modal  = {'modal':'#modalCadUsuarioID','width':'16%','open':'#btnAbrirModalID','cancel':'#cancelaUsuarioID','fields':fields};
	cpModal(modal);
}

function initModalAtualizar(){
	var modal  = {'modal':'#modalAtualizaUsuarioID','width':'16%','open':'#btnAbrirModalID','cancel':'#cancelaAtualizaUsuarioID','fields':null};
	cpModalInit(modal);
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
           	   $('<td onclick="exibirMdUsuario(this)">').html($('<a href="#"></a>').prepend(getIcon(2)))
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
		$('#perfilCadID').append( new Option(p, cont++) );
		$('#perfilAtlzrID').append( new Option(p, cont++) );
	});
}