$(document).ready(function(){
	listarPessoass();
	initModalCadPessoa();
	cadPessoa();
});

function listarPessoas(){
	$.ajax({
		type: 'GET',
		url: 'http://localhost:8080/api/pessoas/listar',
		cache: false,
		timeOut: 600000,
		contentType: "application/json; charset=utf-8",
		statusCode: {
			200: function(data){
				buildTable(data);
			},
			500: function(ex){
				showMessageError('#msgCadPessoa', 'Ocorreu um erro no cadastro.');
				console.error('Ocorreu um erro. ' + ex);
			},
		}
	});
}

function cadPessoa(){
	$('#cadastraPessoaID').click(function(){
		if( validar() != null ){
			var pessoa = validar();
			cadastrarPessoaAjax(pessoa);
		}
	});
}


//-------------------------------------------------------------------------------------------------------------------------------
//	PRIVATE FUNCTIONS
//-------------------------------------------------------------------------------------------------------------------------------
function cadastrarPessoaAjax(pessoa){
	$.ajax({
		type: 'POST',
		url: 'http://localhost:8080/api/pessoas/criar',
		data: pessoa,
		cache: false,
		timeOut: 600000,
		contentType: "application/json; charset=utf-8",
		statusCode: {
			200: function(pessoas){
				buildTable(pessoas);
			},
			500: function(ex){
				console.error('Ocorreu um erro. ' + ex);
			}
		}
	});
}

function initModalCadPessoa(){
	var modalObject = {'modal':'#modalCadastroID','width':'16%', 'open':'#btnAbrirModalID', 'close':'.cp-modal-close', 'cancel':'#cancelaPessoaID'};
	var fields      = ['#nomeID,'#perfilID','#dtNascimID', '#cpfID', '#telResidID', 
						'#telPrinID', '#celularID', '#emailID', '#usrCadastrouID', '#ativoID'];
	cpModal(modalObject, fields);
}

function validar(){
	var nome = $('#nomeID').val();
	var perfil = $('#perfilID').val();
	var dtNascim     = $('#dtNascimID').val();
	var cpf     = $('#cpfID').val();
	var telResid     = $('#telResidID').val();
	var telPrin     = $('#telPrinID').val();
	var celular     = $('#celularID').val();
	var email     = $('#emailID').val();
	var usuario     = $('#usrCadastrouID').val();
	var ativo     = $('#ativoID').val();
	
	if(nome == '' & perfil == '' & dtNascim == '' & cpf == '' & 
			telPrin == '' & email == '' & usuario == '' & ativo == ''){
		showMessageWarning('#msgCadPessoa', 'Informe todos os campos.');
		return null;
	}else {
		return '{"id":"'+null+'","nome":"'+nome+'","perfil":"'+perfil+'", 
		"dtNascim":"'+dtNascim+'","cpf":"'+cpf+'","telResid":"'+telResidencial+'",
		"telPrin":"'+telPrincipal+'","celular":"'+celular+'", "email":"'+email+'",
		"usuario":"'+usuario+'","ativo":"'+ativo+'"}';
		
	}
}

function buildTable(pessoas){
	$('#tbPessoasID tbody > tr').remove();
	
	pessoas.forEach(function(pes){
			var $tr = $('<tr>').append(
				$('<td style="display:none;">').text(pes.id),
				$('<td>').text(pes.nome),
				$('<td>').text(pes.perfil),
				$('<td>').text(pes.dtNascim),
				$('<td>').text(pes.cpf),
				$('<td>').text(pes.telResid),
				$('<td>').text(pes.telPrin),
				$('<td>').text(pes.celular),
				$('<td>').text(pes.email),
				$('<td>').text(pes.usuario),
				$('<td>').text(pes.ativo),
			);
		
			$('#tblPessoasID').append($tr);
	})
}
