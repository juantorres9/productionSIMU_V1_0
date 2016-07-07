//GLOBAL variables

function setTextBox(elementName,value1){
	var element=document.getElementById(elementName);
	var value=element.getAttribute("value");
	alert(value);
	element.setAttribute("value",value1);
}


function getHTML(elementID){
	var element= document.getElementById(elementID);
	var code= element.innerHTML;
	alert(code);							
}





function setHTML(elementID){
	
	document.getElementById(elementID).innerHTML="<button id='idButton2' type='button' name=nameButton1 >TrStop</button>temps:<input id='idInput2' type ='text' name='finA1' value='' required>";
	
}


function setHTML2(elementID,code){
	
	document.getElementById(elementID).innerHTML=c;
	
}



function createButton(typeChild,idChild,textChild,idElement){
	var button1= document.createElement('button');
	button1.type=typeChild;
	button1.id=idChild;
	button1.innerHTML=textChild;
	document.getElementById(idElement).appendChild(button1);
}

function createInput(idChild,valueChild,idElement){
	var input1= document.createElement('input');

	input1.id=idChild;
	input1.value=valueChild;
	document.getElementById(idElement).appendChild(input1);
}
function testAlert2(){
	var result=confirm("envoyer le formulaire?");
	if(result){
		return true;
	}else{
		return false;
	}
	return true;
}

//OBTENIR le temps Unix AVEC UN DELAI INDUIT lors de l'appelle de la fonction  RETOUR VOID
function setTimeUnix3(elementId){
	//recupere le temp unix en milliseconds
	var datepack=getUnixTime();	
   //ecrire date sur l'attribut value  
	var element=document.getElementById(elementId);	
	element.value=datepack[0]-60000;
}


/*************************************FONCTIONS EN OPERATION**********************************************************/
//OBTENIR le temps Unix  lors de l'appele du fonction  RETOUR VOID 
function getUnixTime(){
	var date = new Date();
	var unixTime= date.getTime();	
	var datepack=[unixTime,date];
	return datepack;
	}
//OBTENIR le temps Unix  lors de l'appele du fonction  RETOUR VOID 
function setTimeUnix(elementId){
	//recuperer le temps Unix en milliseconds
	var datepack=getUnixTime();
	//ecrire date sur l'attribut value  
	var element=document.getElementById(elementId);
	//modifier la valeur de la PROPIETE
	element.value=datepack[0];
}
//SET le temps Unix de 2 field INPUT au meme temps
function setTimeUnix2(elementId1,elementId2,elementId3){
	//recupere le temp unix en milliseconds
	var datepack=getUnixTime();
	//Identifier les deux elements A MODIFIER 
	var element1=document.getElementById(elementId1);
	var element2=document.getElementById(elementId2);
	var element3=document.getElementById(elementId3)
	//MODIFIER la Propiete  avec la valeur  DU TEMPS UNIX 
	element1.value=datepack[0]; //date Unix 
	element2.value=datepack[0];
	element3.value=datepack[1]; //date String 
}

function validerFonctionne(elementId){
	var f1=setTimeUnix(elementId);
	var f2=testAlert2();
	var result;
	if(f1 && f2){
		result=true;
	}else{
		result= false;
	}
	return result;
	
}
//VALIDER QUE LE TEMPS D'ARRET SOIT POSITIVES 

