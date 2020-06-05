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
				messagePanelSuccess('Cidade cadastrada com sucesso.');
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
		if( validar() != null ){
			var cidade = validar();
			cadastrarCidadeAjax(cidade);
			cpCloseModal('#modalCadCidadeID');
		}
	});
}


function alterarCidade(id){
	console.log(id);
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
			},
			500: function(ex){
				console.error('Ocorreu um erro. ' + ex);
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
	var modal  = {'modal':'#modalCadCidadeID','width':'16%','open':'#btnAbrirModalID', 'cancel':'#cancelaCidadeID','fields':fields};
	cpModal(modal);
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
			$('<td onclick="alterarCidade('+cid.id+')">').html($('<a href="#"></a>').prepend(getIcon(2)))
		);
		
	    $('#tblCidadesID').append($tr);
	})
}
