$(document).ready(function() {

	$('.inp').click(
    	    function(){
    	        $(this).val('');
    	    });
    
    $( ".inp" ).blur(function() {
    	if ($( ".inp" ).val() == ''){
    		$( ".inp" ).val('Codul Exponatului');
    	}
    });
    
    $('.popup-background').hide();
	
	$('.backButton').click(
		    function(){
		    	window.location.replace("index.html");
		    }
	);
	
	$('.sub').click(
		    function(){
		    	$.ajax({
		            url: $.session.get('backendServerVar') + "/rest/getItemInfo",
		            data: "id="+$(".inp").val()+"&museumId="+$.session.get('selectedMuseumId'),
		        }).then(function(data) {
		        	
		        	if (data.id != null){
			        	$('.popup-wrapper').append(
				        	"<div class='popup'>"+
								"<img id='exh-image' src='images/"+data.imageUrl+"'>"+
								"<audio class='audio' controls>"+
							  		"<source src='audio/"+data.audioUrl+"' type='audio/mpeg'>"+
									"Your browser does not support the audio element."+
								"</audio>"+
								"<h3>"+data.name+"</h3>"+
								"<p>"+data.description+"</p>"+
							"</div>"
						);
			        	
			        	$("html, body").animate({ scrollTop: 0 }, "quick");
				    	$('.popup-background').show();
		        	}
		    		
		        });
		    });
	
    $.ajax({
        url: $.session.get('backendServerVar') + "/rest/getMuseumInfo",
        data: "id="+$.session.get('selectedMuseumId'),
    }).then(function(data) {
   	        	
    			$('.header').append(
    					"<h1>"+data.shortName+"</h1>"
    					);
    	
   	        	$('.content').append( 
   	    				"<h2>"+
   	    				data.name+
   		    	    	"</h2>"+
   		    	    	"<p>"+
   		    	    		data.description+
   	    	    		"</p>"
   	    			);
   	        	
   	        	$('.image-slider').append(
   	        			"<img src=images/"+data.imageUrl+">"		
   	        	);
   	        	
   	        	jQuery.each( data.items, function( i, val ) {
   	     		
   	        		$('#imaginiExponate').append(
	   	        		"<li><a id = '"+val.id+"'>"+
		   					"<img src='images/"+val.imageUrl+"'>"+
		   				"</a></li>");
   	        		
   	        		$('#'+val.id).click(
   	        			    function(){
   	        			    	$.ajax({
   	        			            url: $.session.get('backendServerVar') + "/rest/getItemInfo",
   	        			            data: "id="+val.id+"&museumId="+$.session.get('selectedMuseumId'),
   	        			        }).then(function(data) {
   	        			        	
   	        			        	$('.popup-wrapper').append(
   	        				        	"<div class='popup'>"+
   	        								"<img id='exh-image' src='images/"+data.imageUrl+"'>"+
   	        								"<audio class='audio' controls>"+
	   	        						  		"<source src='audio/"+data.audioUrl+"' type='audio/mpeg'>"+
	   	        								"Your browser does not support the audio element."+
	   	        							"</audio>"+
   	        								"<h3>"+data.name+"</h3>"+
   	        								"<p>"+data.description+"</p>"+
   	        							"</div>"
   	        						);
   	        			    		
   	        			        });
   	        			    	
   	        			    	$("html, body").animate({ scrollTop: 0 }, "quick");
   	        			    	$('.popup-background').show();
   	        		 }); 
	   	     		
	   	     	});
    		
    		});
	
});