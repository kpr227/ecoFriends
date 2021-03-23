<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<div id="uploadDiv"></div>
	<input type="file" id="uploadFile" name="uploadFile" multiple="multiple"> 
	<button id="uploadBtn">등록</button> 
<script> 
$(document).ready(function(){
	
	$('#uploadBtn').on('click', function(e){
		var formData = new FormData();
		
		var inputFile = $('input[name="uploadFile"]');
		
		var files = inputFile[0].files;
		
		for(var i = 0; i < files.length; i++){
			formData.append("uploadFile", files[i]);
		}
		
		$.ajax({
			url : '/goods/rest/1390/form/upload/images/thumb',
			processData: false,
			contentType: false,
			data: formData,
			type: 'POST',
			success: function(result){
				alert('uploaded');
			}
		});
	});
});


</script>
</body>
</html>