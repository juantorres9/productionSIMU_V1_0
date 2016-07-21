<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SIMU-ERP</title>
<link type="text/css" rel="stylesheet" href="css/styleFeuille.css"/>
</head>
<body>

<h2 class="mainTitre">Bonjour, Formulaire de Bobineuse 1</h2>
<script src="js/validation.js">  </script>
<script src="js/fonction1.js">  </script>

<form id="idForm1" onsubmit="return validerFonctionne('tr_stop')" method="post" action="control" >
<h3 class="titre">Date:
<input id="date" name="date" value=0  type="hidden" >
<input id="dates" name="dates" value=0  disabled="disabled" readonly>
</h3>

<p class="titre">Réference:
<select class="dropdown"  name="ref_tc" form="idForm1" required>
  <option value="">Choisir</option>
  <option value="ref1-0.96">H35(ref1)</option>
  <option value="ref2-1.02">H40(ref2)</option>
  <option value="ref3-1.05">H55(ref3)</option>
</select>
</p>

<p class="titre" >Collaborateur:
<select name="nom" form="idForm1" required>
  <option value="">Choisir</option>
  <option value="Carlos">Carlos</option>
  <option value="Louis">Louis</option>
  <option value="Marie">Marie</option>
</select>
</p>

<span class="bonne">Pieces bonnes:  <input type ="number" name="nb" required></span>
<span class="mauvais">Pieces NQualité:<input type ="number" name="nr" required></span>

<p class="titre">Temps requis : 
<label class="label1">Start1</label><input id="tr_start" name="tr_start" type ="text" value="0" readonly>
<label class="label1">Stop1</label><input id="tr_stop"  name="tr_stop" type ="text" value="0" readonly>
</p>

<p class="titre">Arret1(changement serie): 
<button id="idButton1Start" onclick="setTimeUnix('arret1_start')" type="button">Start2</button><input id="arret1_start" name="arret1_start" type ="text" value="0" readonly>
<button id="idButton1Stop" onclick="setTimeUnix('arret1_stop')" type="button">Stop2 </button><input id="arret1_stop" name="arret1_stop" type ="text" value="0" readonly >
<span id="span1" class="hide">vide</span>
</p>

<p class="titre">Arret2(panne): 
<button id="idButton2Start" onclick="setTimeUnix('arret2_start')" type="button">Start2</button><input id="arret2_start" name="arret2_start" type ="text" value="0" readonly>
<button id="idButton2Stop" onclick="setTimeUnix('arret2_stop')" type="button">Stop2 </button><input id="arret2_stop" name="arret2_stop" type ="text" value="0" readonly>
<span id="span2" class="hide">vide</span>
</p>

<!-- Addition arret3 + arret4  11/07/2016 -->
<p class="titre">Arret3(réglage): 
<button id="idButton3Start" onclick="setTimeUnix('arret3_start')" type="button">Start3</button><input id="arret3_start" name="arret3_start" type ="text" value="0" readonly>
<button id="idButton3Stop" onclick="setTimeUnix('arret3_stop')" type="button">Stop3</button><input id="arret3_stop" name="arret3_stop" type ="text" value="0" readonly >
<span id="span3" class="hide">vide</span>
</p>

<p class="titre">Arret4(controle machine): 
<button id="idButton4Start" onclick="setTimeUnix('arret4_start')" type="button">Start4</button><input id="arret4_start" name="arret4_start" type ="text" value="0" readonly>
<button id="idButton4Stop" onclick="setTimeUnix('arret4_stop')" type="button">Stop4</button><input id="arret4_stop" name="arret4_stop" type ="text" value="0" readonly>
<span id="span4" class="hide">vide</span>
</p>

<button type="submit" value ="valider" >VALIDER</button>
</form>

<script>
//Evenement chargé au debut du page 
window.onload=setTimeUnix2('tr_start',"date","dates");
</script>

</body>
</html>



