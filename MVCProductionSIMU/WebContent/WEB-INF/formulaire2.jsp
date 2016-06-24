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
<script> 
//maFonction("coucou"); 
//maFonction2();
//maFonction3();
//alert(m3);
//maFonction4(4,5);

//maFonction5("read");


</script>


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



<p>Temps Requis: 
<button type="button" name=nameButton1 >TrStart</button>
<button type="button" name=nameButton1 >TrStop</button>
</p>
<p>Temps Arret1: 
<button type="button" name=nameButton1 >A1Start</button>
<button type="button" name=nameButton1 >A1Stop</button>
</p>

<p>Temps Arret2: 
<button type="button" name=nameButton1 >A2Start</button>
<button type="button" name=nameButton1 >A2Stop</button>
<script>add(String);</script>
</p>






<p><input type="submit" value="VALIDER"></p>


<script>
//maFonction6("idForm1");
//maFonction7("option");
</script>
</form>

<p>Temps Arret2: 
<button name=nameButton1 >A2Start</button>
<button name=nameButton1 >A2Stop</button>
<script>add(String);</script>
</p>








</body>
</html>



