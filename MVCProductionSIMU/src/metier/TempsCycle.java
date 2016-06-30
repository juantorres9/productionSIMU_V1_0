package metier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class TempsCycle {
private double   DMH1=160;//H35=160  
private double   DMH2=170;//H40=170
private double   DMH3=175;//H55=175
private List<HashMap<String,Double>> machine1= new ArrayList<HashMap<String,Double>>();


private HashMap<String, Double> tc_HEURE=new HashMap<String,Double>();
private HashMap<String, Double> tc_MINUTE=new HashMap<String,Double>();
private HashMap<String, Double> tc_SECONDE=new HashMap<String,Double>();
//Objet Unique 
private static TempsCycle tc = new TempsCycle();

//Constructeur Pas Instanciable Unique  utilisation 
private TempsCycle(){
	
	
}



//Method pour refrechir tous les  valeurs de temps de cycle  selon les NOUVEAUX valeurs de constantes DMH
private void setAllTc(){
	tc_SECONDE.put("ref1", (DMH1*3600)/10000);
	tc_SECONDE.put("ref2", (DMH2*3600)/10000); 
	tc_SECONDE.put("ref3", (DMH3*3600)/10000);
	machine1.add(tc_SECONDE);	

	tc_MINUTE.put("ref1", (DMH1*60)/10000);
	tc_MINUTE.put("ref2", (DMH2*60)/10000); 
	tc_MINUTE.put("ref3", (DMH3*60)/10000);
	machine1.add(tc_MINUTE);
	
	tc_HEURE.put("ref1", DMH1/10000);
	tc_HEURE.put("ref1", DMH1/10000);
	tc_HEURE.put("ref2", DMH2/10000); 
	tc_HEURE.put("ref3", DMH3/10000);
	machine1.add(tc_HEURE);
}

//Accesseurs pour modifier constantes 
public double getDMH1() {
	return DMH1;
}

public void setDMH1(double dMH1) {
	DMH1 = dMH1;
}

public double getDMH2() {
	return DMH2;
}

public void setDMH2(double dMH2) {
	DMH2 = dMH2;
}

public double getDMH3() {
	return DMH3;
}

public void setDMH3(double dMH3) {
	DMH3 = dMH3;
}
public String getDMHs(){
	String DMHs= "le DHM1 ="+DMH1+" DMH2 ="+DMH2+" DMH3 ="+DMH3;
	return DMHs;
}

//Obtenir la List contenu dans le Machine c.à.d tous les HashMap enregistrées sur le Machine . 
public List<HashMap<String, Double>> getMachine1() {
	tc.setAllTc();
	return machine1;
}
//Obtenir l'object Unique 
public static TempsCycle getTcObjet(){
		return tc;
}
	
}
