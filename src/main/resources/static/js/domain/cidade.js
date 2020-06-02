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
				showMessageError('#msgCadCidade', 'Ocorreu um erro no cadastro.');
				console.error('Ocorreu um erro. ' + ex);
			},
		}
	});
}

function cadastrar(){
	$('#cadastraCidadeID').click(function(){
		if( validar() != null ){
			var cidade = validar();
			cadastrarCidadeAjax(cidade);
		}
	});
}


//-------------------------------------------------------------------------------------------------------------------------------
//	PRIVATE FUNCTIONS
//-------------------------------------------------------------------------------------------------------------------------------
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
			},
			500: function(ex){
				console.error('Ocorreu um erro. ' + ex);
			}
		}
	});
}

function initModalCadastro(){
	var modalObject = {'modal':'#modalCadastroID','width':'16%', 'open':'#btnAbrirModalID', 'close':'.cp-modal-close', 'cancel':'#cancelaCidadeID'};
	var fields      = ['#cidadeID','#ufID'];
	cpModal(modalObject, fields);
}

function validar(){
	var cidade = $('#cidadeID').val();
	var uf     = $('#ufID').val();
	
	if(cidade == '' & uf == ''){
		showMessageWarning('#msgCadCidade', 'Informe todos os campos.');
		return null;
	}else {
		return '{"id":"'+null+'","nome":"'+cidade+'","uf":"'+uf+'"}';
		
	}
}

function buildTable(cidades){
	$('#tbCidadesID tbody > tr').remove();
	
	cidades.forEach(function(cid){
			var $tr = $('<tr>').append(
				$('<td style="display:none;">').text(cid.id),
				$('<td>').text(cid.nome),
				$('<td>').text(cid.uf),
			);
		
			$('#tblCidadesID').append($tr);
	})
}
