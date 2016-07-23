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
<!-- ADDITION LIBRAIRIES  -->
<h2 class="mainTitre">Bonjour,Formulaire de Bobineuse 1</h2>
<script src="js/validation.js">  </script>
<script src="js/fonction1.js">  </script>

<!-- ******************************************************************************************** -->
<!-- DEBUT DU FORMULAIRE -->
<form id="idForm1" onsubmit="return validerFonctionne('tr_stop')" method="post" action="control" >

<!-- DATE -->
<h3 class="titre">Date:
<input id="date" name="date" value=0  type="hidden" >
<input id="dates" name="dates" value=0  disabled="disabled" readonly>
</h3>

<!-- REFERENCE -->
<p class="titre">Réference:
<select class="dropdown"  name="ref_tc" form="idForm1" required>
  <option value="">Choisir</option>
  <option value="ref1-0.96">H35(ref1)</option>
  <option value="ref2-1.02">H40(ref2)</option>
  <option value="ref3-1.05">H55(ref3)</option>
</select>
</p>

<!-- COLLABORATEUR -->
<p class="titre" >Collaborateur:
<input id="nom" name="nom" value="${nom}" readonly>
</p>

<!-- NB bonnes  et NR rebutées -->
<span class="bonne">Pieces bonnes:  <input type ="number" name="nb" required></span>
<span class="mauvais">Pieces NQualité:<input type ="number" name="nr" required></span>

<!-- TEMPS REQUIS -->
<p class="titre">Temps requis : 
<label class="label1">Start1</label><input id="tr_start" name="tr_start" type ="text" value="0" readonly>
<label class="label1">Stop1</label><input id="tr_stop"  name="tr_stop" type ="text" value="0" readonly>
</p>

<!-- ARRET1 -->
<p class="titre">Arret1(réglage): 
<button id="idButton1Start" onclick="setTimeUnix('arret1_start')" type="button">Start2</button><input id="arret1_start" name="arret1_start" type ="text" value="0" readonly>
<button id="idButton1Stop" onclick="calculerDif('arret1_stop','arret1_start','arret1_total')" type="button">Stop2 </button><input id="arret1_stop" name="arret1_stop" type ="text" value="0" readonly >
<!-- SOMME accumulée des ARRRET1 -->
Total1:<input id="arret1_total" name="arret1_total" type ="text" value="0" readonly >
<span id="span1" class="hide">vide</span>
</p>

<!-- ARRET2 -->
<p class="titre">Arret2(panne): 
<button id="idButton2Start" onclick="setTimeUnix('arret2_start')" type="button">Start2</button><input id="arret2_start" name="arret2_start" type ="text" value="0" readonly>
<button id="idButton2Stop" onclick="calculerDif('arret2_stop','arret2_start','arret2_total')" type="button">Stop2 </button><input id="arret2_stop" name="arret2_stop" type ="text" value="0" readonly>
<!-- SOMME accumulée des ARRRET2 -->
Total2:<input id="arret2_total" name="arret2_total" type ="text" value="0" readonly>
<span id="span2" class="hide">vide</span>
</p>

<!-- ARRET3 -->
<p class="titre">Arret3(changement serie): 
<button id="idButton3Start" onclick="setTimeUnix('arret3_start')" type="button">Start3</button><input id="arret3_start" name="arret3_start" type ="text" value="0" readonly>
<button id="idButton3Stop" onclick="calculerDif('arret3_stop','arret3_start','arret3_total')" type="button">Stop3</button><input id="arret3_stop" name="arret3_stop" type ="text" value="0" readonly>
<!-- SOMME accumulée des ARRRET3 -->
Total3:<input id="arret3_total" name="arret3_total" type ="text" value="0" readonly>
<span id="span3" class="hide">vide</span>
</p>

<!-- ARRET4 -->
<p class="titre">Arret4(controle machine): 
<button id="idButton4Start" onclick="setTimeUnix('arret4_start')" type="button">Start4</button><input id="arret4_start" name="arret4_start" type ="text" value="0" readonly>
<button id="idButton4Stop" onclick="calculerDif('arret4_stop','arret4_start','arret4_total')" type="button">Stop4</button><input id="arret4_stop" name="arret4_stop" type ="text" value="0" readonly>
<!-- SOMME accumulée des ARRRET4 -->
Total4:<input id="arret4_total" name="arret4_total" type ="text" value="0" readonly>
<span id="span4" class="hide">vide</span>

</p>
<button type="submit" value ="valider" >VALIDER</button>
</form>
<!-- *************************************************************************************************** -->
<script>
<!--TEMPS REQUIS START -->
//Evenement chargé au debut du page 
window.onload=setTimeUnix2('tr_start',"date","dates");
</script>

</body>
</html>



