<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GateMan</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
</head>
<body onload="load();">

		DiscussionPoint: <input type="text" id="discussion" required="required" name="discussion"><br>
		CommentsOfIMPOF: <input type="text" id="comments" required="required" name="Comments"><br>
		Scope: <input type="text" id="scope" required="required" name="scope"><br>
		Status: <input type="text" id="status" required="required" name="status"><br>
		<button onclick="submit();">Submit</button>
       
		<table id="table" border=1>
		<tr> 
			<th>DiscussionPoint</th> 
			<th>CommentsOfIMPOF</th> 
			<th>Scope</th> 
			<th>Status</th>
			<th>RaisedBy</th> 
			<th>RaisedMobileno</th>
			<th>Review</th> 
			<!-- <th>Approved</th> 
			<th>Date</th>  -->
	   </tr>
	    <tbody id="tbody"></tbody> 
		
		</table>
	<form>
 <input type="button" value="Go back!" onclick="history.go(-1)">
 
</form>
	<script type="text/javascript">
	data = "";
	submit=function() {
		$.ajax({
			 url:'saveOrUpdate1',
			 type:'POST',
			 data:{
				 discussionPoint:$('#discussion').val(),
				 commentsOfIMPOF:$('#comments').val(),
				 scope:$('#scope').val(),
				 status:$('#status').val(),
				 raisedBy:sessionStorage.getItem("usrname"),
				 raisedMobileno:sessionStorage.getItem("user_id"),
			 },
			 success: function(response){
				 alert(response.message);
				 load();
			 }				
			
		});				
	}   
	
	
	
	review=function(index) {
		$.ajax({
			 url:'Update',
			 type:'POST',
			 data:{
				 reviewBy:sessionStorage.getItem("usrname"),
				 reviewStatus:'reviewed',
				 id:data[index].id,
				
			 },
			 success: function(response){
				 alert(response.message);
				
			 }				
			
		});				
	}     
	
	 approve = function(index){
		 
		$.ajax({
			url:'Update1',
			type:'POST',
			data:{
				approvedBy:sessionStorage.getItem("usrname"),
				approvedStatus:'approved',
				id:data[index].id,},
			success: function(response){
					alert(response.message);
					load();		
			}				
		});			
}
	 
	 date = function(index){
		 
			$.ajax({
				url:'Update2',
				type:'POST',
				data:{savingDate:new Date(parseInt(localStorage.getItem('time'))),
					dateTime:new Date(parseInt(localStorage.getItem('time'))),
				    raisedDateTime:new Date(parseInt(localStorage.getItem('time'))),
				    reviewDateTime:new Date(parseInt(localStorage.getItem('time'))),
				    approvedDateTime:new Date(parseInt(localStorage.getItem('time'))),},
				success: function(response){
						alert(response.message);
						load();		
				}				
			});			
	}
		 
	
	
 load = function(){	
		$.ajax({
			url:'list1',
			type:'POST',
			success: function(response){
					data = response.data;
					var gate_check= '';
					for(i=0; i<response.data.length; i++){					
					gate_check += '<tr>';
						gate_check += '<td>'+response.data[i].discussionPoint+'</td>';
						gate_check += '<td>'+response.data[i].commentsOfIMPOF+'</td>';
						gate_check += '<td>'+response.data[i].scope+'</td>';
						gate_check += '<td>'+response.data[i].status+'</td>';
						gate_check += '<td>'+response.data[i].raisedBy+'</td>';
						gate_check += '<td>'+response.data[i].raisedMobileno+'</td>';
						
						if (response.data[i].approvedStatus == 'approved') {
							gate_check += '<td>'+response.data[i].approvedBy+'</td>';
						}else {
							if (response.data[i].reviewStatus == 'reviewed') {
								gate_check += '<td><button onclick="approve('+i+');">Approve</button></td>';
							}else {
								gate_check += '<td><button onclick="review('+i+');">Review</button></td>';
							}
						}
						
						gate_check += '</tr>';
					}	
					 $('#tbody').html(gate_check); 
			}				
		});
	}
   
	</script>
</body>
</html>