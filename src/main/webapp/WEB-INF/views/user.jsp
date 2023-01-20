<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
</head>
<body>
<!-- <form>
<fieldset>
<legend align="center">User Login form</legend> -->
	Username: <input type="text"  id="name" required="required" name="username"><br>
	Password: <input type="text" id="pword" required="required" name="password"><br>
	<button onclick="login();">Login</button>
	<!-- </fieldset>
	</form> -->
	<script type="text/javascript">
	data = "";
		login = function(){
			        $.ajax({
			                url: 'validateUser', 
			                type: 'POST',
			                data: {username:$('#name').val(),password:$('#pword').val()},
			                 success: function(response)
			                	 {
			 						alert(response.message+' '+$('#name').val());
			 						

			 						if (response.status == '200') {
			 							sessionStorage.setItem("user_id",response.data[0].userid);
			 							sessionStorage.setItem("usrname",response.data[0].username);
			 							
			 							window.location.href= "/SpringMVC17/chat/page";
									}else {
										
									}
			                	 
			                	 } 
			               });

			           }
	</script>
	
</body>
</html>