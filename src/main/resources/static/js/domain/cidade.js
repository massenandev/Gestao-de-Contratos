$(document).ready(function(){
	listarCidades();
});

function listarCidades(){
	$.ajax({
		type: 'GET',
		url: 'http://localhost:8080/api/cidades/listar',
		cache: false,
		timeOut: 600000,
		contentType: 'json',
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
		
