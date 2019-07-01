$(document).ready(function() {
   
	$('input:text:first').focus();
	
	$("#profile-btn").click(function () {
		event.stopPropagation();
		if ($("#profile-area").css('display') == 'none') {
			$("#apps-area").fadeOut();
			$("#profile-area").fadeIn();
		} else {
			$("#profile-area").fadeOut();
		}
	});
	
	$("#apps").click(function () {
		event.stopPropagation();
		if ($("#apps-area").css('display') == 'none') {
			$("#profile-area").fadeOut();
			$("#apps-area").fadeIn();
		} else {
			$("#apps-area").fadeOut();
		}
	});
	
	$(window).click(function() {
		$("#apps-area").fadeOut();
		$("#profile-area").fadeOut();
	});
	
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