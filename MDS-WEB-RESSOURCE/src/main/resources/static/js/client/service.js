
$(document).ready(
    function() {

    console.log("client service.js is loaded");
        loadAllClients();
    }
);

function loadAllClients(){
    var form = new FormData();
    var settings = {
        "async": true,
        "crossDomain": true,
        "url": "http://" + document.location.host + "/facturation/client/api",
        "method": "GET",
        "headers": {
            "cache-control": "no-cache"
        },
        "processData": false,
        "contentType": false,
        "mimeType": "multipart/form-data",
        "data": form
    }
    $.ajax(settings).done(function(response) {
        console.log(response);
        var datas = JSON.parse(response);
        clientsData = datas;
        displayList();

    });
}


var clientsData = [{
    "codeInterne": 45,
    "clientName": "TalcorpDZ",
    "clientPhone": "+213778217469",
    "codeExterne": "CLI201801",
    "email": "talcorpdz@gmail.com",
    "clientType": 0,
    "clientEtat": 1,
    "identifiant": "TalcorpDZ",
    "contacts": [{
        "nom": "Taleb",
        "prenom": "Mohammed Housseyn",
        "telephonePortable": "04330256699",
        "email": null
    }],
    "adresses": [{
        "adress": "Batiments des enseignants Mohammed Khemisti",
        "ville": "Maghnia"
    }]
}, {
    "codeInterne": 64,
    "clientName": "lkjhgf",
    "clientPhone": "+213778217469",
    "codeExterne": "dfghjk",
    "email": "talcorpdz@gmail.com",
    "clientType": 1,
    "clientEtat": 1,
    "identifiant": "lkjhgf",
    "contacts": [{
        "nom": "Taleb",
        "prenom": "Mohammed",
        "telephonePortable": "02354649",
        "email": "talcorpdz@gmail.com"
    }],
    "adresses": [{
        "adress": "Batiments des enseignants Mohammed Khemist",
        "ville": "Maghnia"
    }]
}, {
    "codeInterne": 51,
    "clientName": "KJBMKUGPHMSDF",
    "clientPhone": "13216465432",
    "codeExterne": "GIUYDSKFJG",
    "email": "JHSDF@KGDSFHFK.COM",
    "clientType": 1,
    "clientEtat": 1,
    "identifiant": "KJBMKUGPHMSDF",
    "contacts": [{
        "nom": "LKSDFS",
        "prenom": "KJHSDF",
        "telephonePortable": "12313546516",
        "email": "JHSDF@KGDSFHFK.COM"
    }],
    "adresses": [{
        "adress": "FKUYFLSDFSFJHFOY",
        "ville": "KJHGKJHVLUY"
    }]
}, {
    "codeInterne": 50,
    "clientName": "KJBMKUGPHM",
    "clientPhone": "13216465432",
    "codeExterne": "GIUYG.",
    "email": "JHGJ@KGHFK.COM",
    "clientType": 1,
    "clientEtat": 1,
    "identifiant": "KJBMKUGPHM",
    "contacts": [{
        "nom": "LKJ?NBKT",
        "prenom": "KJHV?N",
        "telephonePortable": "12313546516",
        "email": "JHGJ@KGHFK.COM"
    }],
    "adresses": [{
        "adress": "FKUYFLJ.JHFOY",
        "ville": "KJHGKJHVLUY"
    }]
}, {
    "codeInterne": 53,
    "clientName": "jdhgfjkhkg",
    "clientPhone": "654654321",
    "codeExterne": "gkdjsgfkjhg",
    "email": "jhgdfk@djf.com",
    "clientType": 1,
    "clientEtat": 1,
    "identifiant": "jdhgfjkhkg",
    "contacts": [{
        "nom": "kjdhgfieup",
        "prenom": "jhdkfhb",
        "telephonePortable": "3213546454",
        "email": "jhgdfk@djf.com"
    }],
    "adresses": [{
        "adress": "dhfgkhfg",
        "ville": "hjgdsfk"
    }]
}, {
    "codeInterne": 59,
    "clientName": "lkjhldkjfh",
    "clientPhone": "6543215",
    "codeExterne": "iuefhlkjh",
    "email": "jdsl@dkf.com",
    "clientType": 1,
    "clientEtat": 1,
    "identifiant": "lkjhldkjfh",
    "contacts": [{
        "nom": "\tflkjdshfkjh",
        "prenom": "lkjdhf",
        "telephonePortable": "3216548",
        "email": "jdsl@dkf.com"
    }],
    "adresses": [{
        "adress": "dskfhkjhg",
        "ville": "ljdfjb"
    }]
}, {
    "codeInterne": 60,
    "clientName": "kjgkdsjgfjkhgk",
    "clientPhone": "026546498",
    "codeExterne": "kjdskfjg",
    "email": "jdshgf@gm.com",
    "clientType": 1,
    "clientEtat": 1,
    "identifiant": "kjgkdsjgfjkhgk",
    "contacts": [{
        "nom": "uuuuu",
        "prenom": "uuuuu",
        "telephonePortable": "35465465",
        "email": "jdshgf@gm.com"
    }],
    "adresses": [{
        "adress": "test",
        "ville": "vill"
    }]
}, {
    "codeInterne": 46,
    "clientName": "IDE001",
    "clientPhone": "05 55 55 55 55",
    "codeExterne": "REF001",
    "email": "mail@gmail.com",
    "clientType": 0,
    "clientEtat": 0,
    "identifiant": "IDE001",
    "contacts": [{
        "nom": "NOM",
        "prenom": "PRENOM",
        "telephonePortable": "07 77 77 77 77",
        "email": "mail@gmail.com"
    }],
    "adresses": [{
        "adress": "adresse limit 50",
        "ville": "ville"
    }]
}, {
    "codeInterne": 47,
    "clientName": "ID002",
    "clientPhone": "0565486415",
    "codeExterne": "REF002",
    "email": "test@test.com",
    "clientType": 0,
    "clientEtat": 1,
    "identifiant": "ID002",
    "contacts": [{
        "nom": "azerty",
        "prenom": "azerty",
        "telephonePortable": "0321546213",
        "email": "test@test.com"
    }],
    "adresses": [{
        "adress": "ad",
        "ville": "vil"
    }]
}, {
    "codeInterne": 48,
    "clientName": "ID003",
    "clientPhone": "05 5555555",
    "codeExterne": "REF003",
    "email": "EMAIL@Mail.com",
    "clientType": 1,
    "clientEtat": 1,
    "identifiant": "ID003",
    "contacts": [{
        "nom": "NOM 033",
        "prenom": "PRENOM 0333",
        "telephonePortable": "07 7777777",
        "email": "EMAIL@Mail.com"
    }],
    "adresses": [{
        "adress": "ADresse 3",
        "ville": "ville 3"
    }]
}, {
    "codeInterne": 49,
    "clientName": "ID08",
    "clientPhone": "0564654865",
    "codeExterne": "REF08",
    "email": "EMAIL@MAIL.COM",
    "clientType": 1,
    "clientEtat": 1,
    "identifiant": "ID08",
    "contacts": [{
        "nom": "NOM08",
        "prenom": "PRENOM08",
        "telephonePortable": "0765984353",
        "email": "EMAIL@MAIL.COM"
    }],
    "adresses": [{
        "adress": "ADREE",
        "ville": "VILLEE"
    }]
}, {
    "codeInterne": 52,
    "clientName": "IDENTIFIA007",
    "clientPhone": "0777",
    "codeExterne": "REF89",
    "email": "JB@007.com",
    "clientType": 1,
    "clientEtat": 1,
    "identifiant": "IDENTIFIA007",
    "contacts": [{
        "nom": "JAmes",
        "prenom": "Bond",
        "telephonePortable": "07777",
        "email": "JB@007.com"
    }],
    "adresses": [{
        "adress": "not defined",
        "ville": "unknown"
    }]
}, {
    "codeInterne": 67,
    "clientName": "sdfsdfsdf",
    "clientPhone": "0778217469",
    "codeExterne": "sdsdf",
    "email": "talcorpdz@gmail.com",
    "clientType": 1,
    "clientEtat": 1,
    "identifiant": "sdfsdfsdf",
    "contacts": [{
        "nom": "housseyn",
        "prenom": "Taleb",
        "telephonePortable": "+213778217469",
        "email": "talcorpdz@gmail.com"
    }],
    "adresses": [{
        "adress": "Batiments des enseignants",
        "ville": "Maghnia"
    }]
}, {
    "codeInterne": 44,
    "clientName": "sqdsqd",
    "clientPhone": "+213778217469",
    "codeExterne": "sdsqdqs",
    "email": "talcorpdz@gmail.com",
    "clientType": 1,
    "clientEtat": 1,
    "identifiant": "sqdsqd",
    "contacts": [{
        "nom": "Taleb",
        "prenom": "Mohammed",
        "telephonePortable": "+213778217469",
        "email": null
    }],
    "adresses": [{
        "adress": "Batiments des enseignants ",
        "ville": "Maghnia"
    }]
}, {
    "codeInterne": 68,
    "clientName": "cytughb",
    "clientPhone": "+213778217469",
    "codeExterne": "xcghbjnokl",
    "email": "talcorpdz@gmail.com",
    "clientType": 1,
    "clientEtat": 1,
    "identifiant": "cytughb",
    "contacts": [{
        "nom": "Taleb",
        "prenom": "Mohammed",
        "telephonePortable": "+213778217469",
        "email": "talcorpdz@gmail.com"
    }],
    "adresses": [{
        "adress": "Batiments des Khemisti Maghnia",
        "ville": "Maghnia"
    }]
}, {
    "codeInterne": 63,
    "clientName": "yiouhpkjl",
    "clientPhone": "026546498",
    "codeExterne": "ytiusdof",
    "email": "jdshgf@gm.com",
    "clientType": 1,
    "clientEtat": 1,
    "identifiant": "yiouhpkjl",
    "contacts": [{
        "nom": "uuuuu",
        "prenom": "uuuuu",
        "telephonePortable": "35465465",
        "email": "jdshgf@gm.com"
    }],
    "adresses": [{
        "adress": "test",
        "ville": "vill"
    }]
}];

