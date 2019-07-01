$(document).ready(function() {
	
	$("#profile-btn").click(function () {
		event.stopPropagation();
		if ($("#profile-area").css('display') == 'none') {
			$("#apps-area").fadeOut();
			$("#profile-area").fadeIn();
		} else {
			$("#profile-area").fadeOut();
		}
	});
	
	$("#apps-btn").click(function () {
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
});