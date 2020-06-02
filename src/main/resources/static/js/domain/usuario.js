$(document).ready(function(){
	listaUsuarios();

});


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
           	   $('<td>').html(getBooleanIcon(usr.ativo)),
           	   $('<td>').html(getIcon(2))
	        );
		 	
		$('#tblUsuariosID').append($tr);
	});
}