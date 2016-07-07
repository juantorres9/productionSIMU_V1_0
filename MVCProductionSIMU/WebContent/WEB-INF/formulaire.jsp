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

<form id="idForm1" onsubmit="return validerFonctionne('tr_stop')" method="post" action="control" >

<h3>Date:
<input id="date" name="date" value=0  type="hidden" >
<input id="dates" name="dates" value=0  disabled="disabled" readonly>
</h3>

<p>Reference:
<select  name="ref_tc" form="idForm1" required>
  <option value="">Choisir</option>
  <option value="ref1-0.96">Reference1</option>
  <option value="ref2-1.02">Reference2</option>
  <option value="ref3-1.05">Reference3</option>
</select>
</p>

<p>Collaborateur:
<select name="nom" form="idForm1" required>
  <option value="">Choisir</option>
  <option value="Carlos">Carlos</option>
  <option value="Louis">Louis</option>
  <option value="Marie">Marie</option>
</select>
</p>

PiecesBonnes:  <input type ="number" name="nb" required>
PiecesNQualité:<input type ="number" name="nr" required>

<p id=idP1>Temps Requis : 
<label class="label1">Start1</label><input id="tr_start" name="tr_start" type ="text" value="0" readonly>
<label class="label1">Stop1</label><input id="tr_stop"  name="tr_stop" type ="text" value="0" readonly>
</p>

<p id=idP2>Arret1(Changement Serie): 
<button id="idButton3" onclick="setTimeUnix('arret1_start')" type="button">Start2</button><input id="arret1_start" name="arret1_start" type ="text" value="0" readonly>
<button id="idButton4" onclick="setTimeUnix('arret1_stop')" type="button">Stop2 </button><input id="arret1_stop" name="arret1_stop" type ="text" value="0" >
</p>

<p id=idP3>Arret2(Reglage): 
<button id="idButton3" onclick="setTimeUnix('arret2_start')" type="button">Start2</button><input id="arret2_start" name="arret2_start" type ="text" value="0" readonly>
<button id="idButton4" onclick="setTimeUnix('arret2_stop')" type="button">Stop2 </button><input id="arret2_stop" name="arret2_stop" type ="text" value="0" >
</p>

<button type="submit" value ="valider" >VALIDER</button>
<!--script>
//Evenement chargé a la fin du page 
setTimeUnix2('tr_start',"date","dates");
</script>-->
</form>

<script>
//Evenement chargé au debut du page 
window.onload=setTimeUnix2('tr_start',"date","dates");
</script>

</body>
</html>



