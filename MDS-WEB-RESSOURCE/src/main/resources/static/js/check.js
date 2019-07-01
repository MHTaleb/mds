$(document).ready(function() {	
	$(document).on('change', '.checkbox', function(ev){
		if ($(this).hasClass('checkbox all')){
			$(this).parent().find("input").prop( "checked", $(this).children("input").prop('checked') );
		} else 
			if (!$(this).children("input").prop('checked')){
				$(this).parent().find(".all").children("input").prop('checked', false);
			} else if ($(this).parent().find(".checkbox:not(.all)").children("input").not(':checked').length == 0){
					$(this).parent().find(".all").children("input").prop('checked', true);
				}
	});
});