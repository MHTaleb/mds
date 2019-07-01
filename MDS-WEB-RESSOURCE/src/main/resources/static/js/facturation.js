$(document).ready(function () {


    $(document).on('click', '#menu0-func1', function () {
    	
        displayList();
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

});


$(document).ready(function () {

	
	

	



	$(document).on ('click', "#facture-filter-btn", function (event) {
		event.stopPropagation();
		if ($("#facture-filter-area").css('display') == 'none') {
			$(".popup").fadeOut();
			$("#facture-filter-area").fadeIn();
		} else {
			$(".popup").fadeOut();
		}
	});

	
});

