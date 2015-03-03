$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/newzeum/rest/getJson"
    }).then(function(data) {
       $('.greeting-content').append(data.prop);
    });
});