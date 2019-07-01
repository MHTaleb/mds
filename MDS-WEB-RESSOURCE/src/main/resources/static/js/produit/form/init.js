var pedit_tvas;
var pedit_selected_tva;

$(document).ready(
    // init form here
    function() {
        getAllMesureUnits();

        getAllTva();

        setupTarifBehaviour();
    }
);

function getAllMesureUnits() {

};

function getAllTva() {

};

function setupTarifBehaviour() {

    $(document).on('change', 'input[name=product_p_ttc]', function(ev) {
        if (!this.disabled) {

        }
    });

    $(document).on('change', 'input[name=product_p_ht]', function(ev) {
        if (!this.disabled) {

        }
    });

    $(document).on('click', '#pttc', function(ev) {
        bind_pttc();
    });
    $(document).on('click', '#pht', function(ev) {
        bind_pht();
    });
};

function bind_pttc() {
    $('input[name=product_p_ttc]').disbled = false;
    $('input[name=product_p_ht]').disbled = true;
};

function bind_pht() {
    $('input[name=product_p_ttc]').disbled = true;
    $('input[name=product_p_ht]').disbled = false;
};