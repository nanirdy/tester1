<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" class="no-focus">
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Distance</title>
	<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
</head>
<body >
		
		<h1>Location</h1>
		<button onclick="getlocation();">Get Location</button>
		
		<div id="output"></div>
		
		<script type="text/javascript">
		var x= document.getElementById('output');
		
		
		function getLocation(){
		if(navigator.geolocation){
		navigator.geolocation.getCurrentPosition(showPosition)
		}else{
		x.innerHTML = "Browser not Supporting";
		
		}
		}
		
		function showPosition(position){
			x.innerHTML = "latitude = " + position.coords.latitude;
			x.innerHTML += "</br>"
			x.innerHTML += "longitude = " + position.coords.longitude;
		}
		
	

		
		</script>
		
</body>
</html>