$(document).ready(function() {
	$(document).on("click", ".tab", function(){
		$("#container-"+$(this).attr("id")).parent().children().css("display", "none");
		$("#container-"+$(this).attr("id")).css("display", "block");
		
		$(this).parent().children().attr('class', 'tab');
		$(this).attr('class', 'tab tab-selected');
	});
});