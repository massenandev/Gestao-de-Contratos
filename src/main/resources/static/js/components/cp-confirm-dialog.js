
function cpInitDialog(dialogObject){	
	$('.cp-modal-content').css('width', dialogObject.width);
	var modal 	= $(dialogObject.modal);
	var cancel  = $(dialogObject.cancel);
	var span  	= $(dialogObject.close)[0];
	
	$(cancel).click(function(){
		$(modal).css('display','none');
	});
	
	$(span).click(function(){
		$(modal).css('display','none');
	});
}

/**
 * 
 * @param dialogObject
 * @returns
 */
function cpDialog(dialogObject){	
	$('.cp-modal-content').css('width', dialogObject.width);
	var modal 	= $(dialogObject.modal);
	var open  	= $(dialogObject.open);
	var cancel  = $(dialogObject.cancel);
	var span  	= $(dialogObject.close)[0];

	$(open).click(function(){
		$(modal).css('display','block');
	});
	
	$(cancel).click(function(){
		$(modal).css('display','none');
	});
	
	$(span).click(function(){
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

function cpOpenModal(modalID){
	$(modalID).css('display','block');
}