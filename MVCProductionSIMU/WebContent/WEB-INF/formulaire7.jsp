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
<h2>Bonjour,Formulaire de Bobineuse 1</h2>


<script src="js/validation.js">  </script>
<script src="js/fonction1.js">  </script>


<form action="control" id="idForm1">

<p>Reference:
<select  name="nameDrop1" form="idForm1" required>
  <option value="">Choisir</option>
  <option value="Ref1">Reference1</option>
  <option value="Ref2">Reference2</option>
  <option value="ref3">Reference3</option>
</select>
</p>

<p>Collaborateur:
<select name="nameDrop2" form="idForm1" required>
  <option value="">Choisir</option>
  <option value="Carlos">Carlos</option>
  <option value="Louis">Louis</option>
  <option value="Marie">Marie</option>
</select>
</p>
PiecesBonnes:  <input type ="number" name="nbonne" required>
PiecesNQualité:<input type ="number" name="nrebut" required>


<p id=idP1>Temps Requis : 
<label class="label1">Start1</label><input id="idInput1" type ="text" value="0" readonly>
<label class="label1">Stop1</label><input id="idInput2" type ="text" value="0" readonly>
</p>
<p id=idP2>Temps Panne: 
<button id="idButton3" onclick="setTimeUnix('idInput3')" type="button">Start2</button><input id="idInput3" type ="text" value="0" readonly>
<button id="idButton4" onclick="setTimeUnix('idInput4')" type="button">Stop2 </button><input id="idInput4" type ="text" value="0" >
</p>

<p id="idPx"><button type="submit" onclick="setTimeUnix3('idInput2')" value="valider">VALIDER</button></p>

</form>
<script>
//Evenement cahrgé au debut du page 
window.onload=setTimeUnix('idInput1')
var a = document.getElementById('idpdx');
a.addEventListener('click',setTimeUnix2('idnull'),false);
</script>
</body>
</html>



