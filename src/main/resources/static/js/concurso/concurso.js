	//INITIALIZE
	$(document).ready(function(){
		dropdownLoterias('#loteriasLstID');
		getLoteriaSelect();
		checkFields();
		searchConcursos();
	});
	
	/**
	 *
	 */
	function loadConcursos(){
		
		$.ajax({
		    type: 'GET',
		    url: 'http://localhost:8080/concursos/load',
		    success: function(concursos){ 
		    	buildTable(concursos);
		    },
		    error: {},
		    contentType: "application/json",
		    dataType: 'json'
		});
	}
	
	
	
	function searchConcursos(){
		$('#btnSearchConcID').click(function(){
			var loteria  = $('#loteriasLstID').find(":selected").val();
			var concInit = $('#concInitID').val();
			var concEnd  = $('#concEndID').val();
			loadConcursos(loteria, concInit, concEnd);
		});
	}
	
	/**
	 * Efetua a busca por concursos 
	 */
	function loadConcursos(loteria, concInit, concEnd){
		
		$.ajax({
			type: 'GET',
			url: 'http://localhost:8080/concursos/loteria/'+loteria+'/concinit/'+concInit+'/concend/'+concEnd,
			success: function(concursos){ 
				buildTable(concursos);
			},
			error: {},
			contentType: "application/json",
			dataType: 'json'
		});
	}
	
	/**
	 *
	 */
	function buildTable(concursos){
		$('#concursosTableID tbody > tr').remove();
		
		concursos.forEach(function(conc){ 	
			
			var check = conc.ativo == true ? '<img class="svg-icon" src="/img/svg/check-square.svg"/>' : '<img class="svg-icon" src="/img/svg/square.svg"/>';
			
			var $tr = $('<tr>').append(
			               $('<td>').text(conc.loteria),
			           	   $('<td>').text(conc.numero),
			               $('<td>').text(conc.dezenas),
			               $('<td>').text(conc.data),
			               $('<td>').html($('<a href="#"></a>').prepend(check)),
			               $('<td>').html($('<a href="#"></a>').prepend('<img class="svg-icon" src="/img/svg/edit.svg"/>')),
			               $('<td>').html($('<a href="#"></a>').prepend('<img class="svg-icon" src="/img/svg/search.svg"/>'))
		           	  );
			 	
			$('#concursosTableID').append($tr);
			
		});
	}
	
	/**
	 * 
	 */
	function getLoteriaSelect(){
		$('#loteriasLstID').on('change', function(){
			var id   = $(this).find(":selected").val();
			var name = $(this).find(":selected").text();
			var init = $('#concInitID').val();
			var end  = $('#concEndID').val();
			var enable = id > 0 && init > 0 && end > 0;
			
			if(enable){
				$('#btnSearchConcID').prop("disabled",false);
			}else {
				$('#btnSearchConcID').prop("disabled",true);
			}
		});
	}
	
	/**
	 * 
	 */
	function checkFields(){
		
		$('#concInitID').on("input", function(){
			var init = $(this).val();
			var end  = $('#concEndID').val();
			var sel  = $('#loteriasLstID').find(":selected").val();
			var enable = init > 0 && end > 0 && sel > 0;
			
			if(enable){
				$('#btnSearchConcID').prop("disabled",false);
			}else {
				$('#btnSearchConcID').prop("disabled",true);
			}
		});
		
		$('#concEndID').on("input", function(){
			var init = $('#concInitID').val();
			var end  = $(this).val();
			var sel  = $('#loteriasLstID').find(":selected").val();
			var enable = init > 0 && end > 0 && sel > 0;
			
			if(enable){
				$('#btnSearchConcID').prop("disabled",false);
			}else {
				$('#btnSearchConcID').prop("disabled",true);
			}
		});
	}