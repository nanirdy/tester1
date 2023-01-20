<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>project</title>
<style>
table, th, td {
  border: 1px solid black;
    border-collapse: collapse;
  
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
</head>
<body onload="loadAssetDocuments();">
 <div class="block-content block-content-full border-t border-3x py-0" style="box-shadow:-5px 0 5px -5px rgba(7,7,7,.4);">
	
	<form id="asstDocumentsFilesUpload" action="" method="" enctype="multipart/form-data" autocomplete="off">
													
	<input type="hidden" id="projectid">
		<label style="color:red">Details:</label> <br>
		<input type="text" id="details" required="required" name="details">
		<input type="text" id="details1" required="required" name="details1"><br>
		<input type="text" id="details2" required="required" name="details2">
		<input type="text" id="details3" required="required" name="details3"><br>
		<input type="text" id="details4" required="required" name="details4">
		<input type="text" id="details5" required="required" name="details5"><br>
		<label style="color:blue">HighLights:</label><br>
	<select class="highlights1" id="highlights1" name="highlights1">
	    <option>Hall</option>
	    <option>Cabin</option>
	    <option>Confernece</option>
	</select>
	<label for="highlights1">choose highlight:</label>
	
	
	<input type="text" id="highlights2" required="required" name="highlights2"> <br>
	
	<select class="highlights3" id="highlights3" name="highlights3">
	    <option>Hall</option>
	    <option>Cabin</option>
	    <option>Confernece</option>
	</select>
	<label for="highlights3">choose highlight:</label>
	
	<input type="text" id="highlights4" required="required" name="highlights4"><br>
													<label style="color:red">Documents:</label><br>
													<div class="row"> 
														<div class="col-md-6 col-sm-6 col-12 col-xl-6">
							                            	<div class="form-material floating input-group"> 
							                            		<input type="text" class="form-control" id="asstdocument1name" name="asstdocument1name">
		                                         				<label for="asstdocument1name">Enter Document1 Name<sup class="text-danger fa-lg">*</sup></label>
							                            	</div> 
														</div>
														<div class="col-md-6 col-sm-6 col-12 col-xl-6">
							                            	<div class="form-material input-group"> 
							                            		<input type="file" id="asstdocument1" name="asstdocument1">
							                            	</div> 
														</div>
														
														<div class="col-md-6 col-sm-6 col-12 col-xl-6">
							                            	<div class="form-material floating input-group"> 
							                            		<input type="text" class="form-control" id="asstdocument2name" name="asstdocument2name">
		                                         				<label for="asstdocument2name">Enter Document2 Name<sup class="text-danger fa-lg">*</sup></label>
							                            	</div> 
														</div>
														<div class="col-md-6 col-sm-6 col-12 col-xl-6">
							                            	<div class="form-material input-group"> 
							                            		<input type="file" id="asstdocument2" name="asstdocument2">
							                            	</div> 
														</div>
														<div class="col-md-6 col-sm-6 col-12 col-xl-6">
							                            	<div class="form-material floating input-group"> 
							                            		<input type="text" class="form-control" id="asstdocument3name" name="asstdocument3name">
		                                         				<label for="asstdocument3name">Enter Document3 Name<sup class="text-danger fa-lg">*</sup></label>
							                            	</div> 
														</div>
														<div class="col-md-6 col-sm-6 col-12 col-xl-6">
							                            	<div class="form-material input-group"> 
							                            		<input type="file" id="asstdocument3" name="asstdocument3">
							                            	</div> 
														</div>
														<div class="col-md-6 col-sm-6 col-12 col-xl-6">
							                            	<div class="form-material floating input-group"> 
							                            		<input type="text" class="form-control" id="asstdocument4name" name="asstdocument4name">
		                                         				<label for="asstdocument4name">Enter Document4 Name<sup class="text-danger fa-lg">*</sup></label>
							                            	</div> 
														</div>
														<div class="col-md-6 col-sm-6 col-12 col-xl-6">
							                            	<div class="form-material input-group"> 
							                            		<input type="file" id="asstdocument4" name="asstdocument4">
							                            	</div> 
														</div>
														<div class="col-md-6 col-sm-6 col-12 col-xl-6">
							                            	<div class="form-material floating input-group"> 
							                            		<input type="text" class="form-control" id="asstdocument5name" name="asstdocument5name">
		                                         				<label for="asstdocument5name">Enter Document5 Name<sup class="text-danger fa-lg">*</sup></label>
							                            	</div> 
														</div>
														<div class="col-md-6 col-sm-6 col-12 col-xl-6">
							                            	<div class="form-material input-group"> 
							                            		<input type="file" id="asstdocument5" name="asstdocument5">
							                            	</div> 
														</div>
														<div class="col-md-12 col-sm-12 col-12 col-xl-12 text-center">
							                            	<div class="form-material floating input-group"> 
							                            		<button type="button" class="btn btn-rounded btn-lg bg-gd-aqua btn-center" id="saveAsstDocuments">
                                                    				<i class="si si-user-follow mr-5"></i>Save Files
                                               	 				</button> 
							                            	</div> 
														</div>
													</div>
													</form>
												</div> <br>
												
												 <div id="documentsviewlist"></div>
 
		
	<script type="text/javascript">
	$(function() {
    	  $('#saveAsstDocuments').click(function(e) {
    	    e.preventDefault();
    	    //Disable submit button
    	    $(this).prop('disabled',true);
    	   
    	    var form = document.getElementById("asstDocumentsFilesUpload");
    	    var formData = new FormData(form);
    	    
    	    var file1 = document.getElementById("asstdocument1");
    	  	var file2 = document.getElementById("asstdocument2");
    		var file3 = document.getElementById("asstdocument3");
    		var file4 = document.getElementById("asstdocument4");
    		var file5 = document.getElementById("asstdocument5");
    	    var forTrue = false,forTrue1 = false,forTrue2 = false,forTrue3 = false,forTrue4 = false;
    	    
    	    //alert(Math.round(file1.files.item(0).size/1024) +' KB'); 
    	    
    	    if (file1.value.length > 0) {
    	    	if ($('#asstdocument1name').val().length > 0) {
    	    		forTrue = true;
				}else {
					forTrue = false;
				} 
			}else {
				forTrue = true;
			}
    	    
    	  	if (file2.value.length > 0) {
    	    	if ($('#asstdocument2name').val().length > 0) {
    	    		forTrue1 = true;
				}else {
					forTrue1 = false;
				}
			}else {
				forTrue1 = true;
			}
    	    
    	  	if (file3.value.length > 0) {
    	    	if ($('#asstdocument3name').val().length > 0) {
    	    		forTrue2 = true;
				}else {
					forTrue2 = false;
				}
			}else {
				forTrue2 = true;
			}
    	  	
    	  	if (file4.value.length > 0) {
    	    	if ($('#asstdocument4name').val().length > 0) {
    	    		forTrue3 = true;
				}else {
					forTrue3 = false;
				}
			}else {
				forTrue3 = true;
			}
    	  	if (file5.value.length > 0) {
    	    	if ($('#asstdocument5name').val().length > 0) {
    	    		forTrue4 = true;
				}else {
					forTrue4 = false;
				}
			}else {
				forTrue4 = true; 
			}
    	  	
    	    if (forTrue && forTrue1 && forTrue2 && forTrue3 && forTrue4) {
    	   // Ajax call for file uploaling
        	    var ajaxReq = $.ajax({
        	      url : '/SpringMVC17/project/uploadDocuments',
        	      type : 'POST',
        	      data : formData,
        	      cache : false,
        	      contentType : false,
        	      processData : false,
        	      xhr: function(){
        	        //Get XmlHttpRequest object
        	         var xhr = $.ajaxSettings.xhr() ;
        	        
        	        //Set onprogress event handler 
        	         xhr.upload.onprogress = function(event){
        	          	var perc = Math.round((event.loaded / event.total) * 100);
        	         };
        	         return xhr ;
        	    	},
        	    	beforeSend: function( xhr ) {
        	    	}
        	    });
    	   
        	// Called on success of file upload
	      	    ajaxReq.done(function(msg) {
	      	     // $('#schalertMsg').text(msg);
	      	      $('input[type=file]').val('');
	      	      $('input[type=text]').val('');
	      	      $('input[type=select]').val('');
	      	      $('button[type=button]').prop('disabled',false);
	      	      
		 
		    	    alert('Successfully Uploaded!.'); 
		    	    loadAssetDocuments();
	      	    });
	      	    
	      	    // Called on failure of file upload
	      	    ajaxReq.fail(function(jqXHR) {
	      	      $('button[type=button]').prop('disabled',false);
	      	    });
			}else {
				alert('Please enter all required fields!.'); 
				$('button[type=button]').prop('disabled',false);
			}
    	  });
    });
	
	 delete_= function(id){		 
		 $.ajax({
			url:'delete',
			type:'POST',
			data:{projectid:id},
			success: function(response){
					alert(response.message);
					loadAssetDocuments();
			}				
		});
} 
	

	 edit = function (index){
		  /*  var det = $("#details").val() +'&&'+$("#details1").val()+'&&'+$("#details2").val()+'&&'+$("#details3").val()+'&&'+$("#details4").val()+'&&'+$("#details5").val();
			var hig = $("#highlights").val() +'&&'+$("#highlights2").val();
			var hig1 = $("#highlights1").val() +'&&'+$("#highlights3").val();
			 *///hi&&hi&&hi&&
				$("#projectid").val(alldocuments[index].projectid);
			// alldocuments[index].details.split("&&")[0]
			 //alldocuments[index].highlights.split("&&")[0]
			 //alldocuments[index].highlights1.split("&&")[0]
			 
		
			 
			 var detData = alldocuments[index].details.split(" ");
			// alert(detData.length);
			 for(i = 0; i < detData.length;i++){
				 if(i == 0){
					 $("#details").val(detData[i]);
				 }else{
					 $("#details"+i).val(detData[i]);
				 }
			 }
			 
			 var hig=alldocuments[index].highlights.split(" ");
			// alert(hig.length);
			 for(i=0;i<hig.length;i++)
				 {
				if(i==0)
					{
					$("#highlights").val(hig[i]);
					}
				else
					{
					$("#highlights"+i).val(hig[i]);
					}
	             }
			 
			 var hig1=alldocuments[index].highlights1.split(" ");
			// alert(hig1.length);
			 for(i = 0; i < hig1.length;i++)
				 {
				if(i == 0)
					{
					$("#highlights1").val(hig1[i]);
					}
				else
					{
					$("#highlights1"+i).val(hig1[i]);
					}
	             }
			/* $("#highlights").val(alldocuments[index].highlights); */
		/* 	$("#highlights1").val(alldocuments[index].highlights1); */
			$("asstdocument1name").val(alldocuments[index].asstdocument1name);
			$("asstdocument2name").val(alldocuments[index].asstdocument2name);
			$("asstdocument3name").val(alldocuments[index].asstdocument3name);
			$("asstdocument4name").val(alldocuments[index].asstdocument4name);
			$("asstdocument5name").val(alldocuments[index].asstdocument5name);
			$("asstdocument5name").val(alldocuments[index].asstdocument5name);
		}
	 
	  loadAssetDocuments = function(){
								
					        	datavalues = {
					        			
					        			uniqueId : '',
					  			}
					  			
					        	var json_data=JSON.stringify(datavalues);
					        	$.ajax({
					  				url : '/SpringMVC17/project/listdocuments',
					  				type : 'POST',
					  				data :json_data,
					  		        dataType: 'json',
					  				contentType: 'application/json',
					  				success : function(response){
					  					
					  					var project='';
					  					
					  					project += '<div class="table-responsive">';
					  					project += '<table class="table table-striped table-bordered" id="tableDataDisplay">';
					  					project += '<thead>';
					  					project  += '<tr>';
					  					project += '<th style="color:red">Details</th>';
					  					project  += '<th style="color:red">HighLights</th>';
					  					project  += '<th style="color:red">Highlights1</th>';
					  					project  += '<th style="color:red">AsstDocument1</th>';
					  					project += '<th style="color:red">AsstDocument2</th>';
					  					project  += '<th style="color:red">AsstDocument3</th>';
					  					project += '<th style="color:blue">AsstDocument4</th>';
					  					project  += '<th style="color:blue">AsstDocument5</th>';
					  					project += '<th style="color:blue">AsstDocument1Name</th>';
					  					project += '<th style="color:blue">AsstDocument2Name</th>';
					  					project += '<th style="color:blue">AsstDocument3Name</th>';
					  					project += '<th style="color:blue">AsstDocument4Name</th>';
					  					project += '<th style="color:blue">AsstDocument5Name</th>';
					  					project  += '<th class="text-center">Edit</th>';
					  					project += '<th class="text-center">Delete</th>';
					  					project  += '</tr>';
					  					project += '</thead>';
					  					project  += '<tbody>';
										
					  					if (response.status == '200') {
											
					  						alldocuments = response.data;
					  						
					  						for (var i = 0; i < response.data.length; i++) {
											
					  									    project += '<tr>';
					  										project += '<td>'+response.data[i].details+'</td>';
					  										project += '<td>'+response.data[i].highlights+'</td>';
					  										project += '<td>'+response.data[i].highlights1+'</td>';
					  										project += '<td>'+response.data[i].asstdocument1+'</td>';
					  										project += '<td>'+response.data[i].asstdocument2+'</td>';
					  										project += '<td>'+response.data[i].asstdocument3+'</td>';
					  										project += '<td>'+response.data[i].asstdocument4+'</td>';
					  										project += '<td>'+response.data[i].asstdocument5+'</td>';
					  										project += '<td>'+response.data[i].asstdocument1name+'</td>';
					  										project += '<td>'+response.data[i].asstdocument2name+'</td>';
					  										project += '<td>'+response.data[i].asstdocument3name+'</td>';
					  										project += '<td>'+response.data[i].asstdocument4name+'</td>';
					  										project += '<td>'+response.data[i].asstdocument5name+'</td>';
					  										/* project += '<td><button type="button" class="project" data-toggle="modal" data-target="#" onclick="editDocuments(\'project\',\''+i+'\');"><i class="fa fa-edit mr-5"></i>Edit</button></td>';
															project += '<td><button type="button" class="project" id="project'+i+'" onclick="deleteDocuments(\'project\',\''+i+'\');"><i class="fa fa-trash mr-5"></i>Delete</button></td>';  */
															/* project += <td> <a href='#' onclick= edit("+i+");> Edit </a>  </td>;  */
															/* project += <td> <a href='#' onclick='delete_("+response.data[i].userid+");'> Delete </a>  </td>; */
															 project += '<td><button onclick="edit('+i+')">Edit</button></td>';
															 project += '<td><button onclick="delete_('+response.data[i].projectid+')">Delete</button></td>';
															project += '</tr>';
															
						
														
														
														

											}
										}else {
											alldocuments = 'NA';
										}
					  					
					  					project += '</tbody>';
					  					project += '</table>';
					  					project += '</div>';
					  					
					  					 $('#documentsviewlist').html(project); 
					  						
					  				}
					  			});
	  }
	
	</script>
</body>
</html>