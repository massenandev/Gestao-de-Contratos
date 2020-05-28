
/**
 * Carrega a modal
 * @param modalID 			- ID da modal
 * @param btnOpen			- botao que abre a modal
 * @param btnExcuteClose	- botao/null de efetua uma operacao e fecha a modal
 * @param btnCancelClose	- botao/null que fecha a modal
 * @param width				- largura da modal
 * @param arrayClearFields	- array de inputs/null que devem ser limpos
 * @returns
 */
function cpModal(modalID, btnOpen, btnExcuteClose, btnCancelClose, width, arrayClearFields){
	
	$('.cp-modal-content').css('width', width);
	var modal 		= $(modalID);
	var open  		= $(btnOpen);
	var cancelClose = $(btnCancelClose);
	var createClose = btnExcuteClose != null ? $(btnExcuteClose) : null;
	var span  		= $('.cp-modal-close')[0];
	var fields      = arrayClearFields != null ? arrayClearFields : null;

	$(open).click(function(){
		$(modal).css('display','block');
	});
	
	$(cancelClose).click(function(){
		clearFields(fields);
		$(modal).css('display','none');
	});

	if(createClose != null){
		$(createClose).click(function(){
			clearFields(fields);
			$(modal).css('display','none');
		});
	}
	
	$(span).click(function(){
		clearFields(fields);
		$(modal).css('display','none');
	});
}

/**
 * 
 * @param modalID
 * @returns
 */
function cpCloseModal(modalID){
	$(modalID).css('display','none');
}

/**
 * PRIVATE
 * @param array
 * @returns
 */
function clearFields(array){
	array.forEach(function(item){
		$(item).val('');
	});
}

