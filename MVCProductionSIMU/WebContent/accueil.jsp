<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/accueilStyle.css"/>
<title>SIMU-ERP</title>
</head> 
<body> 
<h1 class="titre0" >SIMU-ERP</h1>
<form method="post" action="dispatch" id="idForm0">
	<p class="center1"><button type="submit"><input type="image" src="images/formbutton.jpg" ></button></p>
	<p class="center1">Machine
		<select  name="idpage" form="idForm0" required>
 			<option value="">Choisir</option>
  			<option value="machine1">Bobineuse1</option>
		</select>
	</p>
	<p class="center1">Collaborateur:
		<select name="idnom" form="idForm0" required>
  			<option value="">Choisir</option>
  			<option value="Antoine">Antoine</option>
  			<option value="Louis">Louis</option>
  			<option value="Marie">Marie</option>
		</select>
	</p>
	
</form>

</body>
</html>