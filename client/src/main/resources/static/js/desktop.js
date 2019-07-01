$(document).ready(function() {
   
	$('input:text:first').focus();
	
	$("#button-back").click(function(){
		if ($("#menu-V").css('marginLeft') == '0px') {
			$("#menu-V").animate({marginLeft: "-250px"});
		} else {
			$("#menu-V").animate({marginLeft: "0px"});
		}		
	});
	
	$(".shortcut-icon").click(function(){
		if ($(this).children().attr('xlink:href') == '#push-pin') {
			$(this).html('<use xlink:href="#pushed-pin">');
		} else {
			$(this).html('<use xlink:href="#push-pin">');
		}
				
	});
});