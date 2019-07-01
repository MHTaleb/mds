$(document).ready(function getAllNotifications() {

    var form = new FormData();
    var ajaxCallSettings = {
        "async": true,
        "crossDomain": true,
        "url": "http://" + document.location.host + "/facturation/notif",
        "method": "GET",
        "headers": {
            "cache-control": "no-cache"
        },
        "processData": false,
        "contentType": false,
        "mimeType": "multipart/form-data",
        "data": form,
        failure: function(response) {
            console.log(response);
        }

    }
    $.ajax(ajaxCallSettings).done(function(data) {
        console.log("notifications fetched from server" + data);
        var notifications = JSON.parse(data);
        for (i = 0; i < notifications.length; i++) {
            var notifType = "info";
            switch (notifications[i].clinotgra) {
                case 0:
                    notifType = "alert";
                    break;
                case 1:
                    notifType = "success";
                    break;
                case 2:
                    notifType = "error";
                    break;
                case 3:
                    notifType = "warning";
                    break;
                default:
                    notifType = "info";
                    break;
            }

            var notifyConfig = {
                parent: "#notification-panel-accueil",
                type: notifType,
                title: notifications[i].clinotttr,
                message: notifications[i].clinotdesc
            }
            notify(notifyConfig);
        }
    });

});