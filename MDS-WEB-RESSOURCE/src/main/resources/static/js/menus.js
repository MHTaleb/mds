$(document).ready(function() {	
	$(document).on('click', '.menu-V-func', function(){
		$(".main-panel").css("display", "none");
		$("#"+$(this).attr("id")+"-panel").css("display", "block");
		
		$(".menu-V-func").attr('class', 'menu-V-func');
		$(this).attr('class', 'menu-V-func menu-V-func-selected');
		
		$(".menu-V-func-icon").attr('class', 'menu-V-func-icon');
		$(this).children("div").attr('class', 'menu-V-func-icon menu-V-func-icon-selected');
	});
});