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
<h2>Votre formulaire à bien ete enregistrée </h2>

les informations enregistrées sont le suivantes :
<p>Datetimes: ${cycle.datetimes}</p>
<p>Reference : ${cycle.reference}</p>
<p>Nom : ${cycle.nom}</p>
<p>tr : ${cycle.tr}</p>
<p>arret1 : ${cycle.arret1}</p>
<p>arret2 : ${cycle.arret2}</p>
<p>nb : ${cycle.nb}</p>
<p>nr : ${cycle.nr}</p>
<p>tnet: ${cycle.tnet}</p>
<p>tu: ${cycle.tu}</p>
<p>tempsCycle: ${cycle.tempsCycle}</p>
<h1></h1>

<form method="get" action="dispatch" id="idForm2">
	<input name="idpage" type ="hidden" value="validation" >
	<p class="p2"><button type="submit"><input type="image" src="images/retourbouton.jpg" ></button></p>
</form>

</body>
</html>


