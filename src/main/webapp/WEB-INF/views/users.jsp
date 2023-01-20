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

		<input type="hidden" id="userid">
		Name: <input type="text"  id="name" required="required" name="username"><br>
		Pword: <input type="text" id="pword" required="required" name="pword"><br>
		Email: <input type="email" id="email" required="required" name="email"><br>
		<button onclick="submit();">Submit</button>
        <button onclick="excel();">SubmitEXCEL</button>
        <button onclick="pdf();">SubmitPDF</button>
       <button onclick="uploadexcel();">ExcelUpload</button>
       
		<table id="table" border=1>
			<tr> <th> Name </th> <th> Pword </th> <th> Email </th> <th> Edit </th> <th> Delete </th> </tr>
		
		</table>
	<form>
 <input type="button" value="Go back!" onclick="history.go(-2)"><br><br>
 <br>
 <a href="/SpringMVC17/gatecheck/page">MOM</a><br>
 
 
 
 <a href="/SpringMVC17/project/page">PROJECT</a>
</form>
	<script type="text/javascript">
	data = "";
	submit = function(){
		 
			$.ajax({
				url:'saveOrUpdate',
				type:'POST',
				data:{userid:$("#userid").val(),username:$('#name').val(),password:$('#pword').val(),email:$('#email').val()},
				success: function(response){
						alert(response.message);
						load();		
				}				
			});			
	}
	
	

	
	
	
		excel = function(){
			
			var today = new Date();
			var datetime = today.getFullYear()+'_'+(today.getMonth()+1)+'_'+today.getDate()+'_'+today.getHours() + "_" + today.getMinutes() + "_" + today.getSeconds()+'_'+today.getMilliseconds();
			
			/* document.getElementById("successPopBtnD").click(); */
		    // Use XMLHttpRequest instead of Jquery $ajax
		    xhttp = new XMLHttpRequest();
		    xhttp.onreadystatechange = function() {
		        var a;
		        if (xhttp.readyState === 4 && xhttp.status === 200) {
		            // Trick for making downloadable link
		            a = document.createElement('a');
		            a.href = window.URL.createObjectURL(xhttp.response);
		            // Give filename you wish to download
		            a.download = "USers_"+datetime+".xlsx";
		            a.style.display = 'none';
		            document.body.appendChild(a);
		            a.click();
		            alert("Successfully Downloaded!");
		           
		        }
		    };
		    // Post data to URL which handles post request
		    xhttp.open("GET", '/SpringMVC17/users/downloadUSerExcel',true);
		    xhttp.setRequestHeader("Content-Type", "application/json");
		    // You should set responseType as blob for binary responses
		    xhttp.responseType = 'blob';
		    xhttp.send();
			
		}
			
		

		pdf = function(){
 			
 			var today = new Date();
 			var datetime = today.getFullYear()+'_'+(today.getMonth()+1)+'_'+today.getDate()+'_'+today.getHours() + "_" + today.getMinutes() + "_" + today.getSeconds()+'_'+today.getMilliseconds();

			    	// Use XMLHttpRequest instead of Jquery $ajax
				    xhttp = new XMLHttpRequest();
				    xhttp.onreadystatechange = function() {
				        var a;
				        if (xhttp.readyState === 4 && xhttp.status === 200) {
				            // Trick for making downloadable link
				            a = document.createElement('a');
				            a.href = window.URL.createObjectURL(xhttp.response);
				            // Give filename you wish to download
				            a.download = "USers_"+datetime+".pdf";
				            a.style.display = 'none';
				            document.body.appendChild(a);
				            a.click();
				            alert("Successfully Downloaded!");
				           
				        }
				    };
				    // Post data to URL which handles post request
				    xhttp.open("GET", '/SpringMVC17/users/downloadsUserPDF',true);
				    xhttp.setRequestHeader("Content-Type", "application/json");
				    // You should set responseType as blob for binary responses
				    xhttp.responseType = 'blob';
				    xhttp.send();
				
				
 		}

		uploadexcel = function()
		{ 
			$.ajax({
				url:'uploadUSerExcel',
				type:'POST',
				data:{userid:$("#userid").val(),username:$('#name').val(),password:$('#pword').val(),email:$('#email').val()},
				success: function(response)
				{
					if(response.Status == 200){
						
					}else{
						alert('Error');
					}
					
				}				
			});			
	}
	

  
	delete_ = function(id){		 
		 $.ajax({
			url:'delete',
			type:'POST',
			data:{userid:id},
			success: function(response){
					alert(response.message);
					load();
			}				
		});
}
	

	edit = function (index){
		$("#userid").val(data[index].userid);
		$("#name").val(data[index].username);
		$("#pword").val(data[index].password);
		$("#email").val(data[index].email);
		
	}
	
	 
 load = function(){	
		$.ajax({
			url:'list',
			type:'POST',
			success: function(response){
					data = response.data;
					$('.tr').remove();
					for(i=0; i<response.data.length; i++){					
						$("#table").append("<tr class='tr'> <td> "+response.data[i].username+" </td> <td> "+response.data[i].password+" </td> <td> "+response.data[i].email+" </td> <td> <a href='#' onclick= edit("+i+");> Edit </a>  </td> </td> <td> <a href='#' onclick='delete_("+response.data[i].userid+");'> Delete </a>  </td> </tr>");
					}			
			}				
		});
	}
   
	</script>
	<!-- <script type="text/javascript"> 
 {
   var len=history.length;   
   history.go(-len); 
   window.location.href=page url to redirect
 
 } 
</script> -->
</body>
</html>