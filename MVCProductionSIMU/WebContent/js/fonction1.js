//functiones auxiliaires 
function getConfirmation(){
	var retVal = confirm("Voulez-vous envoyer le Formulaire?");
	if( retVal == true ){       
		return true;}
	else{        	
        return false;
		}}
/*************************************FONCTIONS EN OPERATION**********************************************************/
//OBTENIR le temps Unix  lors de l'appele du fonctionne  RETOUR VOID 
function getUnixTime(){
	var date = new Date();
	var unixTime= date.getTime();	
	var datepack=[unixTime,date];
	return datepack;
	}
//OBTENIR le temps Unix  lors de l'appele du fonction  RETOUR VOID 
function setTimeUnix(elementId){
	var result;
	//recuperer le temps Unix en milliseconds
	var datepack=getUnixTime();
	//ecrire date sur l'attribut value  
	var element=document.getElementById(elementId);
	//modifier la valeur de la PROPIETE
	element.value=datepack[0];
	return true;
}
//SET le temps Unix de 2 field INPUT au meme temps
function setTimeUnix2(elementId1,elementId2,elementId3){
	//recupere le temp unix en milliseconds
	var datepack=getUnixTime();
	//Identifier les deux elements A MODIFIER 
	var element1=document.getElementById(elementId1);
	var element2=document.getElementById(elementId2);
	var element3=document.getElementById(elementId3);
	//MODIFIER la Propiete  avec la valeur  DU TEMPS UNIX 
	element1.value=datepack[0]; //date Unix 
	element2.value=datepack[0];
	element3.value=datepack[1]; //date String 
}
//VALIDER QUE LE TEMPS D'ARRET SOIT POSITIVES 
function validerFonctionne(elementId){
	var f1=setTimeUnix(elementId);
	var f2=getConfirmation();
	var f3=validerArret('arret1_stop','arret1_start','span2');
	var f4=validerArret('arret2_stop','arret2_start','span3');
	var result;
	if(f1 && f2 && f3 && f4){
		result=true;
	}else{
		result= false;
	}
	   alert( "result vaut" +typeof result +" ="+ result+ "\n f1 vaut" +typeof f1 +" ="+ f1  + "\n f2 vaut" +typeof f2 +" ="+ f2 + "\n f3 vaut" +typeof f3 +" ="+ f3+ "\n f4 vaut" +typeof f4 +" ="+ f4);
	return result;
	
}
/*********************************************************VALIDATION************************************************************/
function validerArret(idStop,idStart,idSpan){
	var stop=document.getElementById(idStop);
	var start=document.getElementById(idStart);
	var stopVal=parseInt(stop.value);
	var startVal=parseInt(start.value);
	var result1 =(stopVal>=startVal);
	if(result1){
		if(stopVal!=0 && startVal==0){
			myFunction(idSpan,'START ne peut pas valoir 0 si le temps de STOP existe',true);
			return false;
		}else{
			myFunction(idSpan,'Bon',false);
			return true;}		
	}else{
		myFunction(idSpan,'le temps STOP doit etre POSTERIEUR au temps START',true);
		return false;
	}
	}

function myFunction(spanId, message,isShown) {
    var spantip=document.getElementById(spanId);
    if(isShown){
    	spantip.innerHTML=message;
    	spantip.className='correct';
    }else {
    	
    	spantip.className='hide';
    }
}

