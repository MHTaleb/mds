$(document).ready(function() {

    $(document).on('click', '#companySettingsLink', function(ev) {
        ev.preventDefault();
        console.log('company settings click ')
        const link = "http://" + document.location.host + "/facturation/html/paramettre/coordoneEntrepriseForm";

        const action = function() {
            // request all tva from server
            get_all_tva();

            //setting submit action
            submit_action();

        };

        $('#overlay').load(link, action);
        $('#overlay').css("display", "block");
    });
});

function submit_action() {
    var form = $('#settingsForm');
    form.submit(function(ev) {
        ev.preventDefault();
        console.log(form);
        $.ajax({
            type: form.attr('method'),
            url: form.attr('action'),
            data: form.serialize(),
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
    });
};

function get_all_tva() {
    var form = new FormData();
	var settings = {
		"async" : true,
		"crossDomain" : true,
		"url" : "http://"+document.location.host+"/facturation/tva/api",
		"method" : "GET",
		"headers" : {
			"cache-control" : "no-cache"
		},
		"processData" : false,
		"contentType" : false,
		"mimeType" : "multipart/form-data",
		"data" : form
	}

	$.ajax(settings).done(function(response) {
		console.log(response);
		var datas = JSON.parse(response);
		
		displayTVA(datas);
		
	});
};


const selectTvaItem = (value,display) => `<option value="${value}">${display}</option>`;

function displayTVA(datas){

	var content = '';
	for (var i = 	datas.length - 1; i >= 0; i--) {
	 	content += [{value:datas[i].value,display:datas[i].display}].map(selectTvaItem).join('');
	}
	content+=`<option id="edit_tva">ajouter/modifier</option>`;
	$('#tva_defaut').html(content);
}




























