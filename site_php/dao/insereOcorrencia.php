<head>
<meta charset="UTF-8">
</head>
<?php

echo"<script>verificaCampo();</script>";

include('../conexao/conexao.php');

$txtEndereco = $_POST ['txtEndereco'];
$txtLatitude = $_POST ['txtLatitude'];
$txtLongitude = $_POST ['txtLongitude'];
$TipoOcorrencia = $_POST ['TipoOcorrencia'];

$dados = array('endereco' => $txtEndereco , 'latitude' =>$txtLatitude , 'longitude' => $txtLongitude,'tipoOcorrencia'=>$TipoOcorrencia);
foreach ($dados as $key => $value){ 
	$keys[] = $key;
	$insertvalues[] = '\'' . $value . '\'';} 
	
	$keys = implode(',', $keys);
	$insertvalues = implode(',', $insertvalues);
	
	$sql = "INSERT INTO ocorrenciaweb ($keys) VALUES ($insertvalues)";

mysql_query($sql) or die (mysql_error());

echo "<meta HTTP-EQUIV='Refresh' CONTENT='0;URL=http://danger-zone.orgfree.com/cadastrarOcorrencia.php'>";

?>


<script>
alert("Ocorrencia Cadastrada com sucesso!");
</script>