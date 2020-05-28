	/*---------------------------------------------------------------------------------------------------------------
	 * 	FUNCOES COMUNS DE JAVASCRIPT
	 *--------------------------------------------------------------------------------------------------------------/

	/**
	 * Não permite a entrada de caracteres nao numericos.
	 * é necessario entrar utilizar no evento ONINPUT
	 * @param input
	 * @returns
	 */
	function onlyNumer(input){
		input.value = input.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');
	}
	
	/**
	 * 
	 **/
	function onkeyUpCurrency(valor) {
		
		var oValor = $(valor).val();
	
		if( oValor != '' ){
		
			var v = valor.value.replace(/\D/g,'');
			v = (v/100).toFixed(2) + '';
			v = v.replace(".", ",");
			v = v.replace(/(\d)(\d{3})(\d{3}),/g, "$1.$2.$3,");
			v = v.replace(/(\d)(\d{3}),/g, "$1.$2,");
			valor.value = v;
		}
	}
	
	
	/**
	 * Inicializa um array
	 * @param size
	 * @returns
	 */
	function NewArray(size) {
	    var x = [];
	    for (var i = 0; i < size; ++i) {
	        x[i] = i;
	        return x;
	    }
	}
	
