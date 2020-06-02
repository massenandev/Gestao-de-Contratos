
/**
 * Define objeto JSON
 * @param modalObject
 * @returns
 */
function cpModal(modalObject, fields){	
	$('.cp-modal-content').css('width', modalObject.width);
	var modal 	= $(modalObject.modal);
	var open  	= $(modalObject.open);
	var cancel  = $(modalObject.cancel);
	var span  	= $(modalObject.close)[0];

	$(open).click(function(){
		$(modal).css('display','block');
	});
	
	$(cancel).click(function(){
		clearFields(fields);
		$(modal).css('display','none');
	});
	
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