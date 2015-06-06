<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	
</head>
<body>

	<div id="id01"></div>
	<script type="text/javascript">
	var listaLatitudes = [];	
	var listaLongitudes = [];
	var latitude;
	
		var xmlhttp = new XMLHttpRequest();
		var url = "latitude.txt";
		
	
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			   var myArr = JSON.parse(xmlhttp.responseText);
	   	    	for (i = 0 ; i < myArr.length ; i++){
			    		listaLatitudes.push(myArr[i]);
			    }
	   	    	latitude = myArr[0];
		    }
			
		}
		xmlhttp.open("GET", url, true);
		xmlhttp.send();
		
		
		
		var xmlhttp2 = new XMLHttpRequest();
		var url2 = "longitude.txt";
		
	
		xmlhttp2.onreadystatechange = function() {
			if (xmlhttp2.readyState == 4 && xmlhttp2.status == 200) {
			    var myArr2 = JSON.parse(xmlhttp2.responseText);
			    
			    for (i = 0 ; i < myArr2.length ; i++){
			    	listaLongitudes.push(myArr2[i]);
			    }
		    }
		}
	
		xmlhttp2.open("GET", url2, true);
		xmlhttp2.send();


		console.log(listaLatitudes);
		console.log(listaLongitudes);
		
	</script>
</body>
</html>