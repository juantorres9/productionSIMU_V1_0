package metier;

import javax.servlet.http.HttpServletRequest;

public class GenerateurBean {
	//CONSTANTES de PARAMETRES du FORMULAIRE
	public static final String DATE="date";
	public static final String REF_TC="ref_tc";//Reference et Temps de Cycle tramsmis  dans la meme requet 
	public static final String NOM="date";
	public static final String TR="tr";

	public static final String ARRET1_D="arret1";
	public static final String ARRET2_F="arret2";
	
	
	
	
	
	//Creer Bean du premier ligne du tableau1 Base de données avec tous les types de columns selon SQL OK
	 public CycleBean	creerCycleBean (HttpServletRequest request){
		 Calculateur calcul= new Calculateur();
		 CycleBean bean=new CycleBean();
		 //Recuperation de parametres
	
		 return bean;
	 }
}
