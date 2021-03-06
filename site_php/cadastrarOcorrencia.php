<!DOCTYPE html>
<html lang="en">
  <head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <link rel="stylesheet" href="bootstrap/css/style.css" type="text/css">
    <meta charset="utf-8">
    <title>DangerZone - Cadastrar Ocorrência</title>
	<link rel="icon" href="image/danger.png">
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" type="text/css">
	<link rel="stylesheet" href="bootstrap/css/style.css" type="text/css">

	<script type="text/javascript" src="bootstrap/js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
  
	<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?v=3.exp&libraries=places,visualization&sensor=false"></script>
	<script type="text/javascript" src="bootstrap/js/google_dynamic_map.js"></script>
	
	    <!-- Custom CSS -->
    <link href="bootstrap/css/logo-nav.css" rel="stylesheet">
	
    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&signed_in=true&libraries=places"></script>	
	
	<link href="bootstrap/css/estilo.css" type="text/css" rel="stylesheet" />

	<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
	<script type="text/javascript" src="bootstrap/js/jquery.min.js"></script>
	<script type="text/javascript" src="bootstrap/js/mapa.js"></script>
	<script type="text/javascript" src="bootstrap/js/jquery-ui.custom.min.js"></script>
	
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
				<h1>Preencha os campos abaixo pra cadastrar uma ocorrência</h1>
				<br>
				<br>				
				
			   <form action="dao/insereOcorrencia.php" method="POST">
					
				<div class="campos">	
					<p>Digite o endereço da Ocorrência:</p>
					<input type="text" class="form-control" placeholder="Endereço da Ocorrência" id="txtEndereco" name="txtEndereco">
					
					<br>		
					<p>Selecione o tipo de Ocorrência:</p>
					<select id="TipoOcorrencia" name="TipoOcorrencia" class="form-control">
						<option value="1" catOcorrencia="Dano" >Dano</option>
						<option value="1" catOcorrencia="Desacato">Desacato</option> 1
						<option value="1" catOcorrencia="Esbulho possessório">Esbulho possessório</option> 1
						<option value="3" catOcorrencia="Furto">Furto</option> 3
						<option value="3" catOcorrencia="Roubo">Roubo</option> 3
						<option value="5" catOcorrencia="Homicídio">Homicídio</option> 5
						<option value="4" catOcorrencia="Lesão corporal">Lesão corporal</option> 4
						<option value="4" catOcorrencia="Tentativa d homicídio">Tentativa de homicídio</option> 4
						<option value="3" catOcorrencia="Violência doméstica">Violência doméstica</option> 3
						<option value="2" catOcorrencia="Atentado violento ao pudor">Atentado violento ao pudor</option> 2
						<option value="3" catOcorrencia="Corrupção de menor">Corrupção de menor</option> 3
						<option value="4" catOcorrencia="Estupro">Estupro</option> 4
						<option value="1" catOcorrencia="Embriaguez">Embriaguez</option> 1
						<option value="2" catOcorrencia="Porte de arma branca">Porte de arma branca</option> 2
						<option value="3" catOcorrencia="Porte ilegal de armas de fogo">Porte ilegal de armas de fogo</option> 3
					</select>
				</div>								
				<input type="hidden" id="txtLatitude" name="txtLatitude" value=“”/>
				<input type="hidden" id="txtLongitude" name="txtLongitude" value=“”/>					
				<input type="submit" class="btn btn-primary center-block" value="Enviar" name="btnEnviar"/>	
				<br>
            </form>			
			
		</div>
		<div class="col-lg-9">
			<div class="center" id="map-canvas" style="  width: 100%;
									height: 400px;
									margin-top: 50px; 
									margin-left: -10px;
									border: 10px solid #ccc;"></div>
		</div>
	</div>		
  </body>
</html>