$(document).ready(function(){
	listarCidades();
	initModalCadastro();
	cadastrar();
});

function listarCidades(){
	$.ajax({
		type: 'GET',
		url: 'http://localhost:8080/api/cidades/listar',
		cache: false,
		timeOut: 600000,
		contentType: "application/json; charset=utf-8",
		statusCode: {
			200: function(data){
				buildTable(data);
			},
			500: function(ex){
				messagePanelError('Ocorreu um erro no cadastro. Tente mais tarde.');
				console.error('Ocorreu um erro. ' + ex);
			},
		}
	});
}

function cadastrar(){
	$('#cadastraCidadeID').click(function(){
		if( validar(null) != null ){
			var id = $('#hiddenID').val();
			
			if(id == ''){//cadastrar
				var cidade = validar(null);
				cadastrarCidadeAjax(cidade);
				cpCloseModal('#modalCadCidadeID');
				configBotaoLabel(null);
				
			}else {//atualizar
				var cidade = validar(id);
				atualizarCidadeAjax(cidade);
				cpCloseModal('#modalCadCidadeID');
				configBotaoLabel(null);
			}
			
		}
	});
}


function alterarCidade(line){
	var values = getLineTable(line);
	$('#cidadeID').val(values[1]);
	$('#ufID').val(values[2]);
	$('#hiddenID').val(values[0]);
	configBotaoLabel(values[0]);
	cpOpenModal('#modalCadCidadeID');
}



//-----------------------------------------------------------------------------------------------------------------------------------------
//	 PRIVATE METHODS HELERS
//-----------------------------------------------------------------------------------------------------------------------------------------
function cadastrarCidadeAjax(cidade){
	$.ajax({
		type: 'POST',
		url: 'http://localhost:8080/api/cidades/criar',
		data: cidade,
		cache: false,
		timeOut: 600000,
		contentType: "application/json; charset=utf-8",
		statusCode: {
			200: function(cidades){
				buildTable(cidades);
				messagePanelSuccess('Cidade cadastrada com sucesso.');
			},
			500: function(ex){
				messagePanelError('Ocorreu um erro no cadastro. Tente mais tarde.');
				console.error('Ocorreu um erro. ' + ex);
			}
		}
	});
}

function atualizarCidadeAjax(cidade){
	$.ajax({
		type: 'PUT',
		url: 'http://localhost:8080/api/cidades/atualizar',
		data: cidade,
		cache: false,
		timeOut: 600000,
		contentType: "application/json; charset=utf-8",
		statusCode: {
			200: function(cidades){
				buildTable(cidades);
				messagePanelSuccess('Cidade atualizada com sucesso.');
			},
			500: function(ex){
				messagePanelError('Ocorreu um erro no cadastro. Tente mais tarde.');
				console.error('Ocorreu um erro. ' + ex.status);
			}
		}
	});
}

/**
 * Prepara/executa a modal de cadastro
 * @returns
 */
function initModalCadastro(){
	var fields = ['#cidadeID','#ufID'];
	var modal  = {'modal':'#modalCadCidadeID','width':'16%','open':'#btnAbrirModalID','cancel':'#cancelaCidadeID','fields':fields};
	cpModal(modal);
}

/**
 * Valida o cadastro da cidade
 * @returns
 */
function validar(id){
	var cidade = $('#cidadeID').val();
	var uf     = $('#ufID').val();
	
	if(cidade == '' & uf == ''){
		showMessageWarning('#msgCadCidade', 'Informe todos os campos.');
		return null;
	}else {
		return '{"id":"'+id+'","nome":"'+cidade+'","uf":"'+uf+'"}';
		
	}
}

/**
 * Monta a tabela de cidades
 * @param cidades
 * @returns
 */
function buildTable(cidades){
	$('#tblCidadesID tbody > tr').remove();
	
	cidades.forEach(function(cid){
		var $tr = $('<tr>').append(
			$('<td style="display:none;">').text(cid.id),
			$('<td>').text(cid.nome),
			$('<td>').text(cid.uf),
			$('<td onclick="alterarCidade(this)">').html($('<a href="#"></a>').prepend(getIcon(2)))
		);
		
	    $('#tblCidadesID').append($tr);
	})
}

function configBotaoLabel(id){
	if(id != '' && id != null){
		$('#cadastraCidadeID').text('Atualizar');
	}else {
		$('#cadastraCidadeID').text('Cadastrar');
	}
}