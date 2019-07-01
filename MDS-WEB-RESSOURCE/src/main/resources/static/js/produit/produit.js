var dProducts = $.Deferred();
var productsDatas;
var printData;

$(document).ready(
    function() {


        getProducts(dProducts, productsDatas);

        $.when(dProducts).done(
            function(products) {
                //init var here
                productsDatas = products;
                //call asynch behaviour
                displayProducts();

            }
        );

        $(document).on('click', '#search-produit-form', function(ev) {
            search();
        });

        $(document).on('click', '#menu0-func3-menu0-func0', function(ev) {
            showAddForm();
        });

        $(document).on('click', '#menu0-func3-menu0-func1', function(ev) {
            printPdf();
        });

        $(document).on('click', '#menu0-func3-menu0-func2', function(ev) {
            printExcel();
        });

        $(document).on('click', '#menu0-func3-menu0-func3', function(ev) {
            quickPrint();
        });
        $(document).on('click', '#edit-product', function(ev) {
            editProduct();
        });
        $(document).on('click', '#delete-product', function(ev) {
            deleteProcut();
        });
    }

);


function getProducts() {

    var form = new FormData();
    var settings = {
        "async": true,
        "crossDomain": true,
        "url": "http://" + document.location.host + "/facturation/produit/api",
        "method": "GET",
        "headers": {
            "cache-control": "no-cache"
        },
        "processData": false,
        "contentType": false,
        "mimeType": "multipart/form-data",
        "data": form
    };
    $.ajax(settings).done(function(response) {
        console.log(response);
        productsDatas = JSON.parse(response)
        printData = datas;
        dProducts.resolve(datas);
    });
};


function search() {
    displayProducts();
};

function showAddForm() {
    $('#overlay').css("display", "block");
    $('#form-container').load("http://" + document.location.host + "/facturation/html/produit/produitEdit",
        function() {
            var frm = $('#produitEdit');
            frm.submit(function(ev) {
                ev.preventDefault();
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
            });
        });
};

function printPdf() {

    var req = new XMLHttpRequest();
    req.open("POST", "http://" + document.location.host + "/facturation/print/product", true);
    req.responseType = "blob";
    req.setRequestHeader("cache-control", "no-cache");
    req.setRequestHeader("Content-Type", "application/json");
    req.setRequestHeader("dataType", "text");
    req.setRequestHeader($('meta[name="csrf-token-name"]').attr('content'), $('meta[name="csrf-token-value"]').attr('content'));

    req.onload = function(event) {
        var blob = req.response;
        console.log(blob.size);
        var link = document.createElement('a');
        link.href = window.URL.createObjectURL(blob);
        link.download = "rapport_produit_" + new Date() + ".pdf";
        link.click();
    };
    req.send(JSON.stringify(printData));

};

function printExcel() {
    var req = new XMLHttpRequest();
    req.open("POST", "http://" + document.location.host + "/facturation/print/product/xls", true);
    req.responseType = "blob";
    req.setRequestHeader("cache-control", "no-cache");
    req.setRequestHeader("Content-Type", "application/json");
    req.setRequestHeader("dataType", "text");
    req.setRequestHeader($('meta[name="csrf-token-name"]').attr('content'), $('meta[name="csrf-token-value"]').attr('content'));

    req.onload = function(event) {
        var blob = req.response;
        console.log(blob.size);
        var link = document.createElement('a');
        link.href = window.URL.createObjectURL(blob);
        link.download = "rapport_produit_" + new Date() + ".pdf";
        link.click();
    };
    req.send(JSON.stringify(printData));
};

function quickPrint() {
    $(document).on('click', '#menu0-func3-menu0-func3', function() {
        $("#productsList").printThis({
            importCSS: false, // import parent page css
            loadCSS: ["http://localhost:9999/MDS-WEB-RESSOURCE/css/main.css", "http://localhost:9999/MDS-WEB-RESSOURCE/css/facturation.css", "http://localhost:9999/MDS-WEB-RESSOURCE/css/print.css"], // path to additional css file - use an array [] for multiple
            pageTitle: "Liste des produits" // add title to print page
        });
    });
};

var currentProduct;

const produitElement = (produit, index) => `
		<div id="ft${index}" class="row" onclick="function setSelectedProduct(${produit.id});" >
			<div class="column right Static" style="width: 50px;">${produit.id}</div>
			<div class="column left" style="width: 50%;">${produit.label}</div>
			<div class="column left Static" style="width: 180px; display: none;">${produit.pa}</div>
			<div class="column left Static" style="width: 180px; display: none;">${produit.tva}</div>
			<div class="column left Static" style="width: 120px; display: none;">${produit.pv}</div>
		</div>`;


function displayProducts() {
    console.log("click");
    if (console.log($('#search-produit').val())) {
        console.log($('#search-produit').val().toLowerCase());
    }
    var as = productsDatas.filter((n, i, a) => {
        return (
            n.email.toLowerCase().indexOf($('#search-produit').val().toLowerCase()) >= 0 ||
            n.contacts[0].nom.toLowerCase().indexOf($('#search-produit').val().toLowerCase()) >= 0)
    });
    var html = ' ';
    console.log(as.length);
    printData = [];
    for (var i = 0; i < as.length; i++) {
        var ProduitJsonDto = as[i];
        html += [{
            produit: as[i],
            index: i
        }].map(produitElement).join('');
        printData.push(ProduitJsonDto);
    }

    console.log(JSON.stringify(printData));
    $('#produitList').html(html);
    console.log(html);

};

const productTabDetail = (product) => `
<div style="padding: 20px 40px;"> 
    <h1>Fiche Produit: </h1>
    <p style="padding-left: 30px;"><strong>R&eacute;ference&nbsp; : </strong>${product.codeExterne}</p>
    <p style="padding-left: 30px;"><strong>Adresse :&nbsp;</strong>${product.tab[0]!=null?product.tab[0].adress:""}</p>    
    
    <div id="menu0-func1-menu1" class="menu-H" style="margin:auto;">
        <ul class="menu-H-functions">
            <li class="menu-H-func menu-H-func-large " id="edit-product">
                <div class="menu-H-func-icon menu-H-func-icon-large "  style="background-image: url(http://localhost:9999/MDS-WEB-RESSOURCE/graphics/edit.svg);"></div>
                <span class="menu-H-func-title menu-H-func-title-large ">Modifier</span>
            </li>
            <li class="menu-H-func menu-H-func-large" id="delete-product">
                <div class="menu-H-func-icon menu-H-func-icon-large " style="background-image: url(http://localhost:9999/MDS-WEB-RESSOURCE/graphics/delete.svg);"></div>
                <span class="menu-H-func-title menu-H-func-title-large">Supprimer</span>
            </li>
        </ul>
    </div>

</div>
`;

function setSelectedProduct(id) {

    var index;
    for (index = 0; id != productsDatas[index].id; index++);
    var html = [productsDatas[index]].map(productTabDetail).join('');


    $('#container-func1-tab0').html(html);
    selectedClient = productsDatas[index];
    console.log(selectedClient);

};

function editProduct(){
    refreshForm();

    $('#form-container').load("http://" + document.location.host + "/facturation/html/refproduit/produitEdit",
        function() {
            $("#addClient").trigger("reset");
            console.log("clicked");
            $('#overlay').css("display", "block");
            $('#addClient').css("display", "block");
            $("#addClient").prop("method", "put");
            var form = $('#addClient');
            populateForm(form, selectedClient);

            var frm = $('#addClient');
            frm.submit(function(ev) {
                ev.preventDefault();
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
                            closeBtn: false,
                            theme: "dark-theme", // default | dark-theme
                            autoHide: true
                        });
                    }
                });
            });
        });

}

function deleteProcut(){

}