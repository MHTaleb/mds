$(document).ready(function() {	

	// should be mooved to facture controller
	$(document).on ('click', "#facture-filter-btn", function (event) {
		event.stopPropagation();
		if ($("#facture-filter-area").css('display') == 'none') {
			$(".popup").fadeOut();
			$("#facture-filter-area").fadeIn();
		} else {
			$(".popup").fadeOut();
		}
	});



    $(document).on('click', '#close-overlay', function () {
    	
    	$('#overlay').css("display", "none");
        $('#addClient').css("display", "none");
    })

    $(document).on('click', ".extend-arrow", 
    		
        function () {
        	console.log("click");
            if ($(this).hasClass(
                    'extend-arrow extend-arrow-right')) {
                $(this).attr('class',
                    'extend-arrow extend-arrow-left');
                $(this).parent().parent().animate({
                    width: "100%"
                }, 300);
                $(this).parent().parent().parent().children(
                    ".detail-panel").css("display",
                    "none");
                $(".dynamic").css("display", "block")
            } else if ($(this).hasClass(
                    'extend-arrow extend-arrow-left')) {
                $(this).attr('class',
                    'extend-arrow extend-arrow-right');
                $(".dynamic").css("display", "none")
                $(this).parent().parent().animate({
                    width: "50%"
                }, {
                    complete: function () {
                        $(this).parent().children(
                            ".detail-panel")
                            .css("display",
                            "block");
                    }
                });

            }
        });


	$(document).on("click", "#profile-btn", function (event) {
		event.stopPropagation();
		if ($("#profile-area").css('display') == 'none') {
			$(".popup").fadeOut();
			$("#profile-area").fadeIn();
		} else {
			$(".popup").fadeOut();
		}
	});
	
	$(document).on("click", "#apps-btn", function (event) {
		event.stopPropagation();
		if ($("#apps-area").css('display') == 'none') {
			$(".popup").fadeOut();
			$("#apps-area").fadeIn();
		} else {
			$(".popup").fadeOut();
		}
	});
	
	$(window).on("click", function() {
		$(".popup").fadeOut();
	});
	
	$(document).on("click", ".popup", function(event) {
		event.stopPropagation();
	});
	
////////////// for select
	
	$(document).on("change", "select", function() {
		if ($(this).parent().find(".select-edit").width()=='32'){
			if($(this).find(":selected").text() != ""){
				$(this).parent().find(".btn1-edit").css("background-image", "url('graphics/edit.svg')");
			} else {
				$(this).parent().find(".btn1-edit").css("background-image", "url('graphics/new.svg')");
			}
		}
		$(this).parent().find(".edit").val($(this).find(":selected").text());
	});
	
	$(document).on("click", ".btn1-edit", function() {
		if ($(this).parent().width()=='32'){
			$(this).parent().animate({
				width: "100%"
			}, {
				duration: 800,
				complete: function () {
					$(this).children("input[type='text']").prop('disabled', false);
					$(this).children("input[type='text']").focus();	
				}
			});
			$(this).parent().children(".btn1-edit").css("background-image", "url('graphics/undo.svg')");
			$(this).parent().children(".btn2-edit").fadeIn();
		} else {
			$(this).parent().children(".btn2-edit").fadeOut();
			$(this).parent().animate({
				width: "32px"
			}, {
				duration: 800,
				complete: function () {
					$(this).children("input[type='text']").prop('disabled', true);
				}
			});
			if($(this).parent().parent().find(":selected").text() != ""){
				$(this).parent().children(".btn1-edit").css("background-image", "url('graphics/edit.svg')");
			} else {
				$(this).parent().children(".btn1-edit").css("background-image", "url('graphics/new.svg')");
			}
		}
	});
	
	$(document).on("click", ".btn2-edit", function() {
		if ($(this).parent().find(".edit").val() == ""){
			if ($(this).parent().parent().find(":selected").text() != ""){				
				alert('delete');
			}
		} else {
			if ($(this).parent().parent().find(":selected").text() != ""){				
				alert('edit');
			}else{				
				alert('save new');
			}
		}
		$(this).parent().children(".btn2-edit").fadeOut();
		$(this).parent().animate({
			width: "32px"
		}, {
			duration: 800,
			complete: function () {
				$(this).children("input[type='text']").focus();
				if($(this).parent().find(":selected").text() != ""){
					$(this).children(".btn1-edit").css("background-image", "url('graphics/edit.svg')");
				} else {
					$(this).children(".btn1-edit").css("background-image", "url('graphics/new.svg')");
				}
			}
		});
		$(this).parent().find(".edit").prop('disabled', false);
		$(this).parent().find(".edit").val("");
	});
});