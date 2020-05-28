	//INITIALIZE
	$(document).ready(function(){
		initModal();
		create();
		load();		
	});
		
	function create(){
		$('#cadastrarID').click(function(){
			
			//if(validate()){
				cpCloseModal('#modalUserCreateID');
				insert();
				load();
				clearFieldsModal();
			//}
		});
	}
	

	function load(){
		
		$.ajax({
		    type: 'GET',
		    url: 'http://localhost:8080/users/list',
		    cache: false,
	        timeout: 600000,
	        contentType: "application/json",
	        dataType: 'json',
		    success: function(data){
		    	buildTable(data);
		    },
		    error: function(ex){
		    	console.error('[ERROR]: Ocorreu erro ao consultar usuarios: '+JSON.parse(ex.status));
		    }
		});
	}
	
	
	function insert(){
		var username 	 = $('#usernameID').val();
		var password 	 = $('#passwordID').val();
		var confPassword = $('#confPasswordID').val();
		var json         = '{"email":"'+username+'","password":"'+password+'","active":"'+true+'"}';
				
		$.ajax({
		    type: 'POST',
		    url: 'http://localhost:8080/users/create',
		    data: json,
		    cache: false,
	        timeout: 600000,
	        contentType: "application/json; charset=utf-8",
	        dataType: 'json',
		    statusCode: {
		    	403: function() {
		    	      alert('400 status code! user error');
	    	    },
	    	    500: function() {
	    	      showMessageError('#messageID', 'Ocorreu um erro no sistema, tente mais tarde.');
	    	    },
	    	    200: function(data){
	    	    	buildTable(data);
			    	showMessageSuccess('#messageID', 'Usuário cadastrado com sucesso.');
	    	    }
		    }
		});
	}
		
		
	function buildTable(users){
		$('#usersTableID tbody > tr').remove();
		
		users.forEach(function(usr){ 	
			
			var checkAt = usr.active   == true ? '<img class="svg-icon" src="/img/svg/check-square.svg"/>' : '<img class="svg-icon" src="/img/svg/square.svg"/>';
			
			var $tr = $('<tr>').append(
			               $('<td>').text(usr.id),
			           	   $('<td>').text(usr.alias),
			           	   $('<td>').text(usr.name),
			           	   $('<td>').text(usr.createDate),
			           	   $('<td>').text(usr.updateDate),
			           	   $('<td>').html($('<a href="#"></a>').prepend(checkAt)),
			               $('<td>').html($('<a href="#"></a>').prepend('<img class="svg-icon" src="/img/svg/edit.svg"/>')),
		           	  );
			 	
			$('#usersTableID').append($tr);
			
		});
	}
	
	function validate(){
		var username = $('#usernameID').val();
		var password = $('#senhaID').val();
		var confpass = $('#confSenhaID').val();
		var valid    = username != '' && password != '' && confpass;
		
		if(valid){
			return true;
		}else {
			showMessageError('#redAlertID', 'Campos são obrigatórios.');
			return false;
		}
	}
	
	function clearFieldsModal(){
		$('#usernameID').val('');
		$('#senhaID').val('');
		$('#confSenhaID').val('');
	}
	
	function initModal(){
		var fields = ['#usernameID','#senhaID','#confSenhaID'];
		cpModal('#modalUserCreateID', '#openModalBtnID', null, '#closeModalBtnID', '14%', fields);
	}