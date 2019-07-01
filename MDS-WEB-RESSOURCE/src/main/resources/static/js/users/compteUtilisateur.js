$(document).ready(

    function() {

        setupForm();
    }

);

function setupForm() {
    Form frm = $('#userForm');
    frm.submit(function(ev) {
        ev.preventDefault();
        if (passwordValid()) {
            $.ajax({
                type: frm.attr('method'),
                url: frm.attr('action'),
                data: frm.serialize(),
                success: function(data) {

                    $('#overlay').css("display", "none");

                    notify({
                        type: "success", // alert | success | error | warning | info
                        title: data,
                        overlay: true,
                        closeBtn: true,
                        theme: "dark-theme", // default | dark-theme
                        autoHide: false
                    });
                }
            });
        } else {
        	notify({
                        type: "error", // alert | success | error | warning | info
                        title: "mot de passe invalide",
                        overlay: true,
                        closeBtn: true,
                        theme: "dark-theme", // default | dark-theme
                        autoHide: false
                    });
        }

    });

};

function passwordValid(){
	return $('#').value() === $('#').value();
}