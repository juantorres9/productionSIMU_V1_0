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




function getUnixTime(){
	var date = new Date();
	var unixTime= date.getTime();	
	var datepack=[unixTime,date];
	return datepack;
	}

function setTimeUnix(elementId){
	//recupere le temp unix en milliseconds
	var datepack=getUnixTime();
	
   //ecrire date sur l'attribut value  
	var element=document.getElementById(elementId);
	
//	var value=element.getAttribute("value");
	//element.setAttribute("value",datepack[0]);
	element.value=datepack[0];
}



function setTimeUnix2(elementId){
	//recupere le temp unix en milliseconds
	var datepack=getUnixTime();
	
   //ecrire date sur l'attribut value  
	var element=document.getElementById(elementId);	
	//element.disabled=true;
	//element.setAttribute("value",datepack[0]);
    //element.disabled=false;
	element.value=datepack[0];
}

//avec correction temps OKK
function setTimeUnix3(elementId){
	//recupere le temp unix en milliseconds
	var datepack=getUnixTime();	
   //ecrire date sur l'attribut value  
	var element=document.getElementById(elementId);	
	element.value=datepack[0]-60000;
}
