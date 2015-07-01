<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>DangerZone</title>
	<link rel="stylesheet" type="text/css" href="bower_components/bootstrap/dist/css/bootstrap.min.css" media="screen"> 
    <link rel="stylesheet" type="text/css" href="bower_components/bootstrap-material-design/dist/css/material.min.css" media="screen"> 
    <link rel="stylesheet" type="text/css" href="css/mine.css" media="screen">
  </head>
  
  <body>
	<div class="row">
	  <div class="col-sm-3" id="panel">
	    <div class="sidebar-nav">
	      <div class="navbar navbar-default" role="navigation">
	        <div class="navbar-header">
	          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-navbar-collapse">
	            <span class="sr-only">Toggle navigation</span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	          </button>
	          <span class="visible-xs navbar-brand">Menu Principal</span>
	        </div>
	        <div class="navbar-collapse collapse sidebar-navbar-collapse">
	
	          <ul class="nav navbar-nav">
	
	            <li class="active">
	            <li class="dropdown">
	              <a href="#" class="dropdown-toggle" data-toggle="dropdown">Ações do Mapa <b class="caret"></b></a>
	              <ul class="dropdown-menu">
	                <li><a onclick="toggleHeatmap()">Toggle Heatmap</a></li>
	                <li><a onclick="changeGradient()">Change gradient</a></li>
	                <li><a onclick="changeRadius()">Change radius</a></li>
	                <li><a onclick="changeOpacity()">Change opacity</a></li>
	              </ul>
	            </li>
	            <li><a href="#">Menu Item 2</a></li>
	            <li><a href="#">Menu Item 3</a></li>
	            <li><a href="#">Menu Item 4</a></li>
	            <li><a href="#">Menu Item 5</a></li>
	            <li><a href="#">Reviews <span class="badge">1,118</span></a></li>
	          </ul>
	        </div><!--/.nav-collapse -->
	      </div>
	    </div>
	  </div>
	
	</div>
	
	<div id="map-canvas"></div>
	
	
	
	    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&signed_in=true&libraries=visualization"></script>
	
		<script type="text/javascript">  
		var xmlhttp = new XMLHttpRequest();
		var url = "latitude.txt";
		var listaLatitudes = [];	
	
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			   var myArr = JSON.parse(xmlhttp.responseText);
	   	    for (i = 0 ; i < myArr.length ; i++){
			    	listaLatitudes.push(myArr[i]);
			    }
		    }
		}
		xmlhttp.open("GET", url, true);
		xmlhttp.send();
		
		console.log(listaLatitudes[0]);
		
		var xmlhttp2 = new XMLHttpRequest();
		var url2 = "longitude.txt";
		var listaLongitudes = [];
	
		xmlhttp2.onreadystatechange = function() {
			if (xmlhttp2.readyState == 4 && xmlhttp2.status == 200) {
			    var myArr2 = JSON.parse(xmlhttp2.responseText);
			    
			    for (i = 0 ; i < myArr2.length ; i++){
			    	listaLongitudes.push(myArr2[i]);
			    }
		    
		    }
		}
	
		console.log(listaLongitudes);
		xmlhttp2.open("GET", url2, true);
		xmlhttp2.send();
		
		
		console.log(listaLatitudes[0],listaLongitudes[0]);
		
			var map, pointarray, heatmap;
		
		    var taxiData = [
		      /*Define os pontos de ocorrencia e com o peso de cada tipo de ocorrencia para gerar um mapa de calor de áreas mais perigosas*/
		      
		    ];
		
		    taxiData.push({location: new google.maps.LatLng(listaLatitudes[0],listaLongitudes[0]), weight:10.0},
				      new google.maps.LatLng(listaLatitudes[0],listaLongitudes[0]));
		    
		    function initialize() {
		      var mapOptions = {
		        zoom: 16,
		        center: new google.maps.LatLng(-7.9950632,-34.8655503),
		        mapTypeId: google.maps.MapTypeId.SATELLITE
		      };
		
		      map = new google.maps.Map(document.getElementById('map-canvas'),
		          mapOptions);
		
		      var pointArray = new google.maps.MVCArray(taxiData);
		
		      heatmap = new google.maps.visualization.HeatmapLayer({
		        data: pointArray
		      });
		
		      heatmap.setMap(map);
		    }
		
		    function toggleHeatmap() {
		      heatmap.setMap(heatmap.getMap() ? null : map);
		    }
		
		    function changeGradient() {
		      var gradient = [
		        'rgba(0, 255, 255, 0)',
		        'rgba(0, 255, 255, 1)',
		        'rgba(0, 191, 255, 1)',
		        'rgba(0, 127, 255, 1)',
		        'rgba(0, 63, 255, 1)',
		        'rgba(0, 0, 255, 1)',
		        'rgba(0, 0, 223, 1)',
		        'rgba(0, 0, 191, 1)',
		        'rgba(0, 0, 159, 1)',
		        'rgba(0, 0, 127, 1)',
		        'rgba(63, 0, 91, 1)',
		        'rgba(127, 0, 63, 1)',
		        'rgba(191, 0, 31, 1)',
		        'rgba(255, 0, 0, 1)'
		      ]
		      heatmap.set('gradient', heatmap.get('gradient') ? null : gradient);
		    }
		
		    function changeRadius() {
		      heatmap.set('radius', heatmap.get('radius') ? null : 20);
		    }
		
		    function changeOpacity() {
		      heatmap.set('opacity', heatmap.get('opacity') ? null : 0.2);
		    }
		
			google.maps.event.addDomListener(window, 'load', initialize);
		</script>    
	    
	    <script type="text/javascript">
			function createMenu(result){
		   		console.log(result);
		   	}
		
		
		   	$.get("/olinda/dados.json", function (result){
		   		console.log("lkdfjlksjdfljdslj");
		   	});
	
		</script>
		
		<script type="text/javascript" src="bower_components/angular/angular.min.js"></script>
		
	    <script type="text/javascript" src="bower_components/jquery/dist/jquery.min.js"></script>
	    
	    <script type="text/javascript" src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	    
	    
  </body>
</html>