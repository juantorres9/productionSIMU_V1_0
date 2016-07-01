package metier;

import javax.servlet.http.HttpServletRequest;

public class GenerateurBean {
	//CLASS AUXILIAIRES
	 private Calculateur calcul= new Calculateur();
	 private CycleBean bean=new CycleBean();
	//CONSTANTES de PARAMETRES du FORMULAIRE
	public static final String DATE="date";
	public static final String REF_TC="ref_tc";//Reference et Temps de Cycle tramsmis  dans la meme requet 
	public static final String NOM="date";

	public static final String TR_START="tr_start";
	public static final String TR_STOP="tr_stop";

	public static final String ARRET1_START="arret1_start";
	public static final String ARRET1_STOP="arret1_stop";
	
	public static final String ARRET2_START="arret2_start";
	public static final String ARRET2_STOP="arret2_stop";
	
	public static final String NB="nb";
	public static final String NR="nr";
	
	//******************************************************************************************************************************************	
	//CREER BEAN  du premier ligne du tableau1 Base de données avec tous les types de columns selon SQL OK
	 public CycleBean	creerCycleBean (HttpServletRequest request){

		 //Recuperation de parametres
	
		 return bean;
	 }	 
/*******************************************************************************************************************************************/
//******************************************************************************************************************************************	 
	 public void fixerDATE(HttpServletRequest request,String date){
		 String dateSQL=null;
		 String  dateUnix= calcul.obtenirParam(request, DATE);
		 dateSQL=calcul.formaterUnixTime(Long.parseLong(dateUnix));
		 bean.setDatetimes(dateSQL);
	 }
	 
	 
}
