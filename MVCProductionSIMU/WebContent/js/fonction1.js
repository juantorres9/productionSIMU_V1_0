//functiones auxiliaires 
function getConfirmation(){
               var retVal = confirm("Voulez-vous envoyer le Formulaire?");
               if( retVal == true ){
            
                  return true;
               }
               else{
            	
                  return false;
               }
            }
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
	var element3=document.getElementById(elementId3)
	//MODIFIER la Propiete  avec la valeur  DU TEMPS UNIX 
	element1.value=datepack[0]; //date Unix 
	element2.value=datepack[0];
	element3.value=datepack[1]; //date String 
}
//VALIDER QUE LE TEMPS D'ARRET SOIT POSITIVES 
function validerFonctionne(elementId){
	var f1=setTimeUnix(elementId);
	var f2=getConfirmation();
	var result;
	if(f1 && f2){
		result=true;
	}else{
		result= false;
	}
	   alert( "result vaut" +typeof result +" ="+ result+ "\n f1 vaut" +typeof f1 +" ="+ f1  + "\n f2 vaut" +typeof f2 +" ="+ f2);
	return result;
	
}


