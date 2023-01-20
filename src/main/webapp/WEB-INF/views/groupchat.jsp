<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
</head>
<body onload="load();">

       <h1>UsersList</h1>
		
		<select id="usermesser" name="usermesser" multiple ="multiple" placeholder="Select user..." >
			
		</select>
		<button onclick="myFunction()" >Start chat</button>
	<p id="demo"></p>
	
	<div id="chatlist"></div>
	
		<script>
		
		var sel = '';
		
function myFunction() {
  
	selected = '';
    for (var option of document.getElementById('usermesser').options)
    {
        if (option.selected) {
           
        	if (selected == '') {
        		selected = option.value;
			}else {
				selected = selected+',,'+option.value;
			}
        	//selected.push(option.value);
        }
    }
    alert(selected);
	
    sel = selected;
    
	//var x = document.getElementById("usermesser").value;
  document.getElementById("demo").innerHTML = "You selected: " + selected;
  retrieveChat();
}

</script>
		
		
		
		<input type="hidden" id="userlistid" name="userlistid">
		<input type="hidden" id="mesid" name="mesid">
		
	<script type="text/javascript">
	  retrieve=function()
	  {
	 	   alert('retrieve method');
	 		$.ajax({
	 			 url:'retrieve',
	 			 type:'POST',
	 			 data:{userid:id},
	 				success: function(response)
	 				{
	 						alert(response.message);	
	 				}				
	 			});				
	 	}    
 
	  retrieveChat=function() {
	 		
		  $("#chatlist").html('');
		  
		  $.ajax({
	 			 url:'retrieve1',
	 			 type:'POST',
	 			 data:{
	 				 senderid : sessionStorage.getItem("user_id"),
	 				 receiverid : document.getElementById('usermesser').value,
	 			 },
	 			 success: function(response){
	 				 
	 				 if (response.status == '200') {
	 					var user_dta = '';
	 					 user_dta += '<table>';
	 					 for (var i = 0; i < response.data.length; i++) {
							
							
							
							if (response.data[i].senderid == sessionStorage.getItem("user_id")) {
								user_dta += '<tr>';
								user_dta += '<td></td>';
								user_dta += '<td>'+response.data[i].message+'</td>';
								user_dta += '</tr>';
							}else {
								user_dta += '<tr>';
								user_dta += '<td>'+response.data[i].message+'</td>';
								user_dta += '<td></td>';
								user_dta += '</tr>';
								
							}
		 				 }
	 					 
	 					user_dta += '<tr>';
						user_dta += '<td><input type="text" id="sendmessage" name="sendmessage"></td><td><button onclick="send();">send</button></td></tr></table>';
						
						$("#chatlist").html(user_dta);
		 				
						$("#mesid").val(response.data[0].mesid);
						
					}else {
						
						var user_dta = '';
						
						user_dta += '<table><tr><td colspan="1"><input type="text" id="sendmessage" name="sendmessage"></td><td><button onclick="send();">send</button></td></tr></table>';
						
						$("#chatlist").html(user_dta);
						
						$("#mesid").val('NA');
					}
	 			 }				
	 		});				
	 	}    
 
	send=function() {
			$.ajax({
				 url:'send',
				 type:'POST',
				 data:{
					// messageid : $("#id").val(),
					 message : $('#sendmessage').val(),
					 senderid : sessionStorage.getItem("user_id"),
					 receiverid : sel,
					 mesid:$("#mesid").val(),
				 },
				 success: function(response){
					 alert(response.message);
					 retrieveChat();
				 }				
				
			});				
		}     
	
	
	
	
  load = function(){	
		$.ajax({
			url:'list',
			type:'POST',
			success: function(response){
					usersdata = response.data;
					$('.tr').remove();
					
					var user = '';
					var user_data = '';
					
					for(i=0; i<response.data.length; i++){					
						
						if (sessionStorage.getItem("user_id") == response.data[i].userid) {
							
						}else {
						
							 user_data += '<option value="'+response.data[i].userid+'">'+response.data[i].username+'</option> ';
						}
					}	
					
					$('#usermesser').html(user_data);
					
			}				
		});
	}
  
	</script>
</body>
</html>