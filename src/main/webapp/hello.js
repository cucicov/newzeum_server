// call service at page load
$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/newzeum/rest/getJson"
    }).then(function(data) {
       $('.getJson-content').append(data.prop);
    });
});