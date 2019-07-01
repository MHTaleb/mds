

const selectOptionTemplate = {id,displayValue} => `<option value="$(id)"> $(displayValue)</option>`;

function populateSelection(datas,SelectId){
    htmlContent ="";
 datas.for (var i = 0; i < datas.length; i++) {
     htmlContent+= [{datas[i].id,datas[i].value}].map(selectOptionTemplate).join('');
 };
}

var produitType,uniteStock,uniteFacturation,tva;
//-------------------------------------------------------------------------------------------------------------//
$(document).ready(function () {
    


    // get list of produit Type
    var form = new FormData();
    var settings = {
        "async" : true,
        "crossDomain" : true,
        "url" : "http://"+document.location.host+"/facturation/produit/api/type",
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
        produitType = datas;        
    });
        //populate product List Selection
        populateSelection(produitType,"#produitType");


    // get list of unite stock
        var settings = {
        "async" : true,
        "crossDomain" : true,
        "url" : "http://"+document.location.host+"/facturation/produit/api/unite/stock",
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
        uniteStock = datas;        
    });
        //populate unite stock Selection
        populateSelection(produitType,"#produitType");

    // get list of unite facturation
        var settings = {
        "async" : true,
        "crossDomain" : true,
        "url" : "http://"+document.location.host+"/facturation/produit/api/unite/facturation",
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
        uniteFacturation = datas;        
    });
        //populate tva selection
        populateSelection(produitType,"#produitType");


    // get list of TVA
        var settings = {
        "async" : true,
        "crossDomain" : true,
        "url" : "http://"+document.location.host+"/facturation/produit/api/tva",
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
        tva = datas;        
    });
    //populate product List TVA


    var frm = $('#produitEditForm');
    frm.submit(function (ev) {
        ev.preventDefault();
        $.ajax({
            type: frm.attr('method'),
            url: frm.attr('action'),
            data: frm.serialize(),
            success: function (data) {

                $('#overlay').css("display", "none");

                notify({
                    type: "success", // alert | success | error | warning | info
                    title: data,
                    overlay: true,
                    closeBtn: false,
                    theme: "dark-theme", // default | dark-theme
                    autoHide: true
                });
            }
        });

    });
});