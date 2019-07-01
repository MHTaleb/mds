$(document).ready(
    function() {

        $(document).on('click', '#FactureLink', function(ev) {
            openFactureForm();
        });

        $(document).on('click', '#DevisLink', function(ev) {
            openDevisForm();
        });
    }
);

function openFactureForm() {
    link = 'http://' + document.location.host + 'facturation/html/param_facture_form_content/factureForm.html';
    $('#param_facture_form_content').load(link);
};

function openDevisForm() {
    link = 'http://' + document.location.host + 'facturation/html/param_facture_form_content/DevisForm.html';
    $('#param_facture_form_content').load(link);
};