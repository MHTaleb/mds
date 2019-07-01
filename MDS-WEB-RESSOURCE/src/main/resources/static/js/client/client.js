const clientTabDetail = (client) => `
<div style="padding: 20px 40px;">
    <h1>Fiche Client </h1>
    <p style="padding-left: 30px;"><strong>R&eacute;ference&nbsp; : </strong>${client.codeExterne}</p>
    <p style="padding-left: 30px;"><strong>Identifiant :&nbsp;</strong>${client.identifiant}</p>
    <p style="padding-left: 30px;"><strong>Type :&nbsp;</strong>${client.clientType==0?"Particulier":"Entreprise"}</p>
    <p style="padding-left: 30px;"><strong>Etat :&nbsp;</strong>${client.clientEtat==0?"Gelé":"Active"}</p>
    <p style="padding-left: 30px;"><strong>Nom Compl&eacute;t :&nbsp;</strong>${client.contacts[0]!= null?client.contacts[0].nom+' '+client.contacts[0].prenom:""}</p>
    <p style="padding-left: 30px;"><strong>T&eacute;l&eacute;phone&nbsp; :&nbsp;</strong>${client.contacts[0]!=null?client.contacts[0].telephonePortable:""}</p>
    <p style="padding-left: 30px;"><strong>Fixe :&nbsp;</strong>${client.clientPhone}</p>
    <p style="padding-left: 30px;"><strong>Adresse :&nbsp;</strong>${client.adresses[0]!=null?client.adresses[0].adress:""}</p>
    <p style="padding-left: 30px;"><strong>Ville :&nbsp;</strong>${client.adresses[0]!=null?client.adresses[0].ville:""}</p>
    <div id="menu0-func1-menu1" class="menu-H" style="margin:auto;">
        <ul class="menu-H-functions">
            <li class="menu-H-func menu-H-func-large " id="menu1-func0">
                <div class="menu-H-func-icon menu-H-func-icon-large "  style="background-image: url(http://localhost:9999/MDS-WEB-RESSOURCE/graphics/edit.svg);"></div>
                <span class="menu-H-func-title menu-H-func-title-large ">Modifier</span>
            </li>
            <li class="menu-H-func menu-H-func-large" id="menu1-func2">
                <div class="menu-H-func-icon menu-H-func-icon-large " style="background-image: url(http://localhost:9999/MDS-WEB-RESSOURCE/graphics/delete.svg);"></div>
                <span class="menu-H-func-title menu-H-func-title-large">Supprimer</span>
            </li>
        </ul>
    </div>
    
</div>
`;
const RefCliElement = ({
    client,
    index
}) => `
<div id="cl${index}" onclick="setSelectedClient('${client.codeExterne}')" class="row">
    <div class="column right" style="width: 50px;">${client.codeExterne}</div>
    <div class="column left dynamic" style="width: 180px; display: none;">${client.identifiant}</div>
    <div class="column left" style="width: 50%;">${client.contacts[0]!= null?client.contacts[0].nom+' '+client.contacts[0].prenom:""}</div>
    <div class="column left dynamic" style="width: 180px; display: none;">${client.adresses[0]!=null?client.adresses[0].adress:""}</div>
    <div class="column left dynamic" style="width: 180px; display: none;">${client.adresses[0]!=null?client.adresses[0].ville:""}</div>
    <div class="column left dynamic" style="width: 120px; display: none;">${client.contacts[0]!=null?client.contacts[0].telephonePortable:""}</div>
    <div class="column left dynamic" style="width: 120px; display: none;">${client.clientPhone}</div>
    <div class="column left" style="width: 50%;">${client.email}</div>
    <div class="column right dynamic" style="width: 120px; display: none;">0,00 DZD</div>
</div>`;

var selectedClient;

var printData = [];

$(document).ready(

    // init clients controller here
    function() {
            console.log("client.js is loaded");
        $(document).on('click', '#menu0-func1-menu0-func0', function() {

            showClientForm();

        });

        $(document).on('click', '#menu0-func1-menu0-func1', function() {

            printPdfClient();
        });

        $(document).on('click', '#menu0-func1-menu0-func1', function() {

            printXLSClient();
        });

        $(document).on('keyup', '#search-client', function(ev) {
            displayList();
        });

        $(document).on('click', '#menu0-func1-menu0-func3', function() {
            quickClientPrint();
        });

        $(document).on('click', '#menu1-func0', function(ev) {
            updateClient();
        });

        $(document).on('click', '#menu1-func1', function(ev) {
            deleteClient();
        });
        //-------------------------------------------

    }
);

function showClientFrom() {
    $('#overlay').css("display", "block");
    $('#form-container').load("http://" + document.location.host + "/facturation/html/refclient/clientForm",
        function() {
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
                            closeBtn: true,
                            theme: "dark-theme", // default | dark-theme
                            autoHide: false
                        });
                    }
                });
            });
        });
};

function displayList() {
    console.log("click");
    if (console.log($('#search-client').val())) {
        console.log($('#search-client').val().toLowerCase());
    }
    var as = clientsData.filter((n, i, a) => {
        return (
            n.email.toLowerCase().indexOf($('#search-client').val().toLowerCase()) >= 0 ||
            n.contacts[0].nom.toLowerCase().indexOf($('#search-client').val().toLowerCase()) >= 0 ||
            n.contacts[0].prenom.toLowerCase().indexOf($('#search-client').val().toLowerCase()) >= 0 ||
            n.adresses[0].ville.toLowerCase().indexOf($('#search-client').val().toLowerCase()) >= 0 ||
            n.contacts[0].telephonePortable.toLowerCase().indexOf($('#search-client').val().toLowerCase()) >= 0)
    });
    var html = ' ';
    console.log(as.length);
    printData = [];
    for (var i = 0; i < as.length; i++) {
        var ClientJsonDto = as[i];
        html += [{
            client: as[i],
            index: i
        }].map(RefCliElement).join('');
        printData.push(ClientJsonDto);
    }

    console.log(JSON.stringify(printData));
    $('#clientList').html(html);
    console.log(html);

}

function setSelectedClient(codeExterne) {

    var index;
    for (index = 0; codeExterne != clientsData[index].codeExterne; index++);
    var html = [clientsData[index]].map(clientTabDetail).join('');


    $('#container-func1-tab0').html(html);
    selectedClient = clientsData[index];
    console.log(selectedClient);
}

function refreshForm() {
    $('#overlay').css("display", "block");
    $('#addClient').css("display", "block");
    $("#addClient").trigger("reset");
    $("#addClient").prop("method", "post");
}

function updateClient() {

    //refresh form
    refreshForm();

    $('#form-container').load("http://" + document.location.host + "/facturation/html/refclient/clientForm",
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

function printPdfClient() {
    var req = new XMLHttpRequest();
    req.open("POST", "http://" + document.location.host + "/facturation/print/client", true);
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
        link.download = "rapport_client_" + new Date() + ".pdf";
        link.click();
    };
    req.send(JSON.stringify(printData));
}

function quickClientPrint() {
    $("#clientList").printThis({
        importCSS: false, // import parent page css
        loadCSS: ["http://localhost:9999/MDS-WEB-RESSOURCE/css/main.css", "http://localhost:9999/MDS-WEB-RESSOURCE/css/facturation.css", "http://localhost:9999/MDS-WEB-RESSOURCE/css/print.css"], // path to additional css file - use an array [] for multiple
        pageTitle: "Liste des Client" // add title to print page
    });
}

function printXLSClient() {
    $(document).on('click', '#menu0-func1-menu0-func1', function() {

        var req = new XMLHttpRequest();
        req.open("POST", "http://" + document.location.host + "/facturation/print/client/xls", true);
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
            link.download = "rapport_client_" + new Date() + ".pdf";
            link.click();
        };
        req.send(JSON.stringify(printData));
    });
}

function deleteClient() {
    var form = {
        id: selectedClient.codeInterne
    };
    var settings = {
        "async": true,
        "crossDomain": true,
        "url": document.location.protocol + "://" + document.location.host + "/facturation/client",
        "method": "DELETE",
        "headers": {
            "cache-control": "no-cache",
            [$('meta[name="csrf-token-name"]').attr('content')]: $('meta[name="csrf-token-value"]').attr('content')
        },
        "processData": false,
        "contentType": false,
        "mimeType": "application/json",
        "data": form
    }
    $.ajax(settings).done(function(data) {

        notify({
            type: "success", // alert | success | error | warning | info
            title: data,
            overlay: true,
            closeBtn: false,
            theme: "dark-theme", // default | dark-theme
            autoHide: true
        });
    });
}