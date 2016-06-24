<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> bonjour</h2>


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
PiecesBonnes:<input type ="text" name="nbonne" required>
PiecesNQualité:<input type ="text" name="nrebut" required>



<p id=idP1>Temps Requis: 
<button id="idButton1" onclick="setTextBox('idInput1',45)" type="button" name=nameButton1 >TrStart</button>temps:<input id="idInput1" type ="text" name="debutTR" value="0" readonly>
<button id="idButton2" type="button" name=nameButton1 >TrStop</button>temps:<input id="idInput2" type ="text" name="finA1" value="0" readonly>
</p>
<p>Temps Arret1: 
<button type="button" onclick="setHTML('idP2')" name=nameButton1 >A1Start</button>
<button type="button" onclick="createButton('button','1','arret1','idP2');createInput('2','30','idP2');"name=nameButton1 >A1Stop</button>
</p>




<p id=idP2></p>




<p><input type="submit" value="VALIDER"></p>


<script>
var date= new Date();
var TrStart=date.getTime();
setTextBox('idInput2',TrStart);
setTextBox('idInput1',date);
</script>
</form>

</body>
</html>



