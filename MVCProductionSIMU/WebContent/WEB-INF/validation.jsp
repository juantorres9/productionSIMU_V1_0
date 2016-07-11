<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/styleFeuille.css"/>
</head>
<body >
<h2 class="mainTitre2">Votre formulaire à bien été enregistré </h2>
<h3 class="info">Les paramètres enregistrées sont le suivantes : </h3>

<p class="result">Datetimes: ${cycle.datetimes}</p>
<p class="result">Reference : ${cycle.reference}</p>
<p class="result">Nom : ${cycle.nom}</p>
<p class="result">tr : ${cycle.tr}</p>
<p class="result">Arret1 : ${cycle.arret1}</p>
<p class="result">Arret2 : ${cycle.arret2}</p>
<!-- Addition arret3 et arret4  11/07/2016-->
<p class="result">Arret3 : ${cycle.arret3}</p>
<p class="result">Arret4 : ${cycle.arret4}</p>
<!-- Fin-->
<p class="result">nb : ${cycle.nb}</p>
<p class="result">nr : ${cycle.nr}</p>
<p class="result">tnet: ${cycle.tnet}</p>
<p class="result">tu: ${cycle.tu}</p>
<p class="result">tempsCycle: ${cycle.tempsCycle}</p>


<form method="get" action="dispatch" id="idForm2">
	<input name="idpage" type ="hidden" value="validation" >
	<p><button type="submit"><input type="image" src="images/retourbouton.jpg" ></button></p>
</form>

</body>
</html>



