var m1="hola",m3="nulll gobale";

function maFonction(s){
	alert("message: "+s);
}
function maFonction2(){
	alert(m1);
}
function maFonction3(){
var m3="au revoir et Bon appetit";
this.m3=m3;
}

function maFonction4(a,b){
	alert(a);
	alert(b);	
}


/*maFonction4(prompt("etes-vous celibataire?"),prompt("pourquoi?"));*/

function maFonction5(age, validate){
alert(typeof age);
if (typeof age ==="number"){
	alert("bravo vous etes un nombre");
	validate=true;
}else{
	alert("vous n'etes pas un nombre");
	validate=false;
}
alert(validate);

}



function maFonction6(name){
	alert(name);	
	var id =document.getElementById(name);
	alert(id);
}


function maFonction7(names){
	alert(names);
	
	var elements =document.getElementsByTagName(names);
	
	for(var i =0;i<elements.length;i++){
		alert("valeur "+i+"égal ="+elements[i]);
    }
}



function add(type) {

	//Create an input type dynamically.
	var element = document.createElement("input");

	//Assign different attributes to the element.
	element.setAttribute("type", type);
	element.setAttribute("value", type);
	element.setAttribute("name", type);


	var foo = document.getElementById("fooBar");

	//Append the element in page (in span).
	foo.appendChild(element);

}


	