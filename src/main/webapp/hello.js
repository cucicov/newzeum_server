// call service at page load
$(document).ready(function() {
	//init server location
	$.session.set('backendServerVar', 'http://localhost:8080/newzeum');
	
    $.ajax({
        url: $.session.get('backendServerVar') + "/rest/getJson",
    }).then(function(data) {
       $('.getJson-content').append(data.prop);
    });
});