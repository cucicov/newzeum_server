// call service at page load
$(document).ready(function() {
	//init server location
	$.session.set('backendServerVar', 'http://localhost:8080/newzeum');
	
    $.ajax({
        url: $.session.get('backendServerVar') + "/rest/getMuseumList",
    }).then(function(data) {
    	jQuery.each( data.museumList, function( i, val ) {
    		
    		$('.museum-list').append( 
    				"<li>"+
    	    		"<a id= '"+val.id+"' href='museum.html'>"+
	    	    		"<div class='image-wrap'>"+
	    	    			"<img src='images/"+val.imageUrl+"'>"+
	    	    		"</div>"+
    	    		"<span>"+val.name+"</span>"+
    	    		"</a>"+
    	    		"</li>"
    			);
    		
    		$( "#"+val.id ).bind( "click", function() {
    			$.session.set('selectedMuseumId', val.id);
    		});
    		
    	});
    });
    
});