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
			200: function(lista){
				console.log('lista ' + JSON.stringify(lista));
			},
			500: function(ex){
				console.error('Ocorreu um erro.' + ex);
			}
		}
	});
}