function DoAction( param )
{
     $.ajax({
          type: "GET",
          url: "http://localhost:8080/newzeum/rest/getMsg",
          data: "param=" + param,
          success: function(msg){
        	  $('.greeting-content2').append(msg);
          	 }
     });
}