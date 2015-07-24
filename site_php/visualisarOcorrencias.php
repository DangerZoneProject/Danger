<?php
  include('conexao/conexao.php');
?>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <link rel="stylesheet" href="bootstrap/css/style.css" type="text/css">
    <meta charset="utf-8">
    <title>DangerZone - Visualizar Ocorrência</title>
	<link rel="icon" href="image/danger.png">
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" type="text/css">
	<link rel="stylesheet" href="bootstrap/css/style.css" type="text/css">

	<script type="text/javascript" src="bootstrap/js/jquery-2.1.4.min.js"></script>
	
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script> 
	
	<!-- Custom CSS -->
    <link href="bootstrap/css/logo-nav.css" rel="stylesheet">
	
	<link href="bootstrap/css/estilo.css" type="text/css" rel="stylesheet" />	
	
	<script type="text/javascript" src="bootstrap/js/jquery-2.1.4.min.js"></script>

	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>

	<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&signed_in=true&libraries=visualization"></script>

	
  </head>
  
  <body> 
      <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">
                    <img style=" max-width: 50%;" class="img-responsive center-block" src="image/logo.png" alt="logo DangerZone">
                </a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="index.php">Home</a>
                    </li>
                    <li>
                        <a href="visualisarOcorrencias.php">Mapa do Crime</a>
                    </li>
					<li>
                        <a href="cadastrarOcorrencia.php">Cadastrar Ocorrência</a>
					</li>                    
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav> 
    <div class="row">
		<div class="col-lg-3">
					<br>
					<h1>Digite um endereço pra visualizar o Mapa de Ocorrências</h1>
					<br>				
						
					<div class="campos">										
					<input type="text" class="form-control" placeholder="Endereço da Ocorrência" id="txtEndereco" name="txtEndereco">
					<input type="hidden" id="txtLatitude" name="txtLatitude" value=“”/>
					<input type="hidden" id="txtLongitude" name="txtLongitude" value=“”/>	
					</div>
					</div>
		
		<div class="col-lg-9">	
			<div id="mapa" style="  width: 100%;
									height: 400px;									
									margin-top: 50px;"></div>
		</div>    	
	

	<script type="text/javascript">  

	var taxiData = [];

	<?php
	  $consulta = " SELECT * FROM ocorrenciaweb";

	  $res = mysql_query($consulta) or die(mysql_error());

	  // pega o número de linhas que a query retornou
	  $num_reg = mysql_num_rows($res);

	  // faz um loop de 0 até o numero de linhas encontradas
	  for($i=0;$i<$num_reg;$i++) {
	  
		 // busca os campos da query
		 $campo = mysql_fetch_array($res);
	  
		 // armazena cada campo do banco em uma variável
		 $endereco = $campo["id"];
		 $latitude = $campo["latitude"];
		 $longitude= $campo["longitude"];
		 $tipo     = $campo["tipoOcorrencia"];
	  
		 echo ("addOcorrencia(".$latitude.",".$longitude.",".$tipo.") ;");

	}
	?>

	var map, pointarray, heatmap;
	var geocoder;


	function initialize() {
	  var mapOptions = {
		zoom: 16,
		center: new google.maps.LatLng(-8.0580855,-34.883022),
		mapTypeId: google.maps.MapTypeId.ROADMAP
	  };

	  map = new google.maps.Map(document.getElementById('mapa'),
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
	  heatmap.set('radius', heatmap.get('radius') ? null : 40);
	}

	function changeOpacity() {
	  heatmap.set('opacity', heatmap.get('opacity') ? null : 0.2);
	}

	function addOcorrencia(latitude, longitude, pontuacao){
	  taxiData.push(
		{
		  location: new google.maps.LatLng(latitude, longitude), 
		  weight: pontuacao
		});
	}

	google.maps.event.addDomListener(window, 'load', initialize);
	
	
$(document).ready(function () {


	
	function carregarNoMapa(endereco) {
		geocoder.geocode({ 'address': endereco + ', Brasil', 'region': 'BR' }, function (results, status) {
			if (status == google.maps.GeocoderStatus.OK) {
				if (results[0]) {
					var latitude = results[0].geometry.location.lat();
					var longitude = results[0].geometry.location.lng();
		
					$('#txtEndereco').val(results[0].formatted_address);
					$('#txtLatitude').val(latitude);
                   	$('#txtLongitude').val(longitude);
		
					var location = new google.maps.LatLng(latitude, longitude);
					marker.setPosition(location);
					map.setCenter(location);
					map.setZoom(16);
				}
			}
		})
	}
	
	$("#btnEndereco").click(function() {
		if($(this).val() != "")
			carregarNoMapa($("#txtEndereco").val());
	})
	
	$("#txtEndereco").blur(function() {
		if($(this).val() != "")
			carregarNoMapa($(this).val());
	})
	
	$("#txtEndereco").autocomplete({
		source: function (request, response) {
			geocoder.geocode({ 'address': request.term + ', Brasil', 'region': 'BR' }, function (results, status) {
				response($.map(results, function (item) {
					return {
						label: item.formatted_address,
						value: item.formatted_address,
						latitude: item.geometry.location.lat(),
          				longitude: item.geometry.location.lng()
					}
				}));
			})
		},
		select: function (event, ui) {
			$("#txtLatitude").val(ui.item.latitude);
    		$("#txtLongitude").val(ui.item.longitude);
			var location = new google.maps.LatLng(ui.item.latitude, ui.item.longitude);
			marker.setPosition(location);
			map.setCenter(location);
			map.setZoom(16);
		}
	});
	});
	
	</script>    

	<script type="text/javascript">
	  function createMenu(result){
		  console.log(result);
		}

		$.get("/olinda/dados.json", function (result){
		  console.log("lkdfjlksjdfljdslj");
		});
	  
	</script>  
	</body>
</html>