$(document).ready(function() {
   
	$('input:text:first').focus();
		
	$("#id").keyup(function(event){
		if(event.keyCode == 13){
			$("#pw").focus();
		}
	});
		
	$("#pw").keyup(function(event){
		if(event.keyCode == 13){
			$("#connect").click();
		}
	});
	
	$("#showHidePW").click(function () {
		var change = "";
		if ($(this).css('opacity') == 0.33) {
			$(this).fadeTo( "slow", 1 );
			change = "text";
		} else {
			$(this).fadeTo( "slow", 0.33 );
			change = "password";
		}
		$("#pw").prop("type", change);
	});
});