function callGetMsgWithParam( param )
{
     $.ajax({
          type: "GET",
          url: $.session.get('backendServerVar') + "/rest/getMsg",
          data: "param=" + param,
          success: function(msg){
        	  $('.greeting-content2').append(msg);
          	 }
     });
}
