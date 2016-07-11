package metier;

public class CycleBean {

	//Variables de tableau1 
	private String datetimes;//Conversion d'UnixTime à format :2013-07-19 00:00:00 = YY-MM
    private String reference;
    private String nom;
    private double tr;
    private double arret1;
    private double arret2;
    //Addition 11/07/2016
    private double arret3;
    private double arret4;
    //fin Addition 11/07/2016
    private int nb;
    private int nr;
    //Variables derivées.
    private double tnet;
    private double tu ;
    //variable auxiliaire
    private double tempsCycle;
    
    
    
    
    //Accesseurs 
	public String getDatetimes() {
		return datetimes;
	}
	public void setDatetimes(String datetimes) {
		this.datetimes = datetimes;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getTr() {
		return tr;
	}
	public void setTr(double tr) {
		this.tr = tr;
	}
	public double getArret1() {
		return arret1;
	}
	public void setArret1(double arret1) {
		this.arret1 = arret1;
	}
	public double getArret2() {
		return arret2;
	}
	public void setArret2(double arret2) {
		this.arret2 = arret2;
	}
	//Addition 11/07/2016
	public double getArret3() {
		return arret3;
	}
	public void setArret3(double arret3) {
		this.arret3 = arret3;
	}
	public double getArret4() {
		return arret4;
	}
	public void setArret4(double arret4) {
		this.arret4 = arret4;
	}
	//fin Addition 11/07/2016
	public int getNb() {
		return nb;
	}
	public void setNb(int nb) {
		this.nb = nb;
	}
	public int getNr() {
		return nr;
	}
	public void setNr(int nr) {
		this.nr = nr;
	}
	public double getTnet() {
		return tnet;
	}
	public void setTnet(double tnet) {
		this.tnet = tnet;
	}
	public double getTu() {
		return tu;
	}
	public void setTu(double tu) {
		this.tu = tu;
	}
	public double getTempsCycle() {
		return tempsCycle;
	}
	public void setTempsCycle(double tempsCycle) {
		this.tempsCycle = tempsCycle;
	}   
}
