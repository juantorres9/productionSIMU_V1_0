package metier;

import javax.servlet.http.HttpServletRequest;

public class GenerateurBean {
	//CLASS AUXILIAIRES
	 private Calculateur calcul= new Calculateur();
	 private CycleBean bean=new CycleBean();
	//CONSTANTES de PARAMETRES du FORMULAIRE
	public static final String DATE="date";
	public static final String REF_TC="ref_tc";//Reference et Temps de Cycle tramsmis  dans la meme requet 
	public static final String NOM="nom";

	public static final String TR_START="tr_start";
	public static final String TR_STOP="tr_stop";
	

	public static final String ARRET1_TOTAL="arret1_total";
	public static final String ARRET2_TOTAL="arret2_total";
	public static final String ARRET3_TOTAL="arret3_total";
	public static final String ARRET4_TOTAL="arret4_total";
	//fin Addition 11/07/2016
	
	public static final String NB="nb";
	public static final String NR="nr";
	
	//******************************************************************************************************************************************	
	//CREER BEAN  du premier ligne du tableau1 Base de données avec tous les types de columns selon SQL OK
	 public CycleBean	creerCycleBean (HttpServletRequest request){
		 this.fixerDATE(request,DATE);
		 this.fixerREF_TC(request, REF_TC);
		 this.fixerNOM(request, NOM);
		 this.fixerTR(request, TR_STOP, TR_START);
		 try {
			this.fixerARRET(request, ARRET1_TOTAL);
			this.fixerARRET(request, ARRET2_TOTAL);
			this.fixerARRET(request, ARRET3_TOTAL);
			this.fixerARRET(request, ARRET4_TOTAL);
		} catch (Exception e) {
			e.printStackTrace();
		} 	
		 this.fixerNB(request, NB);
		 this.fixerNR(request, NR);
		 //POST-CALCUL de indicateurs 
		 this.fixerTnet(bean.getNb(), bean.getNr(), bean.getReference(), bean.getTempsCycle());
		 this.fixerTu(bean.getNb(), bean.getReference(), bean.getTempsCycle());
		 
	
		 return bean;
	 }	 
/*******************************************************************************************************************************************/
//******************************************************************************************************************************************	 
//CALCULER LA DATE EN format SQL String  et l'enregistrer sur le BEAN 
	 public void fixerDATE(HttpServletRequest request,String date){
		 String dateSQL=null;
		 String  dateUnix= calcul.obtenirParam(request, date);
		 dateSQL=calcul.formaterUnixTime(Long.parseLong(dateUnix));
		 bean.setDatetimes(dateSQL);
	 }
//CALCULER LA REFERENCE  et le TEMPSCYCLE du formulaire   et l'enregistrer sur le BEAN 
	 public void fixerREF_TC(HttpServletRequest request,String ref_tc){
		String reftcParam;
		String [] reftc;
		String ref=null;
		double tc=0;
		reftcParam=calcul.obtenirParam(request, ref_tc);
		 try {
			reftc=calcul.separerString(reftcParam);
			ref=reftc[0];
			tc=Double.parseDouble(reftc[1]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//Assignation de BEAN
		 bean.setReference(ref);
		 bean.setTempsCycle(tc);		 
	 }
//OBTENIR LE NOM et l'enregistrer dans le BEAN 
	 public void fixerNOM(HttpServletRequest request,String nom){
		 String nomBean;
		 nomBean=calcul.obtenirParam(request, nom);
		 bean.setNom(nomBean);
	 }
//CALCULER le  TR en DOUBLE et l'enregistrer sur le BEAN 
	 public void fixerTR(HttpServletRequest request,String tr_stop, String tr_start){
		 double tr;
		 String tr_stopPara=calcul.obtenirParam(request, tr_stop);
		 String tr_startPara=calcul.obtenirParam(request, tr_start);
		 tr=calcul.calculStringDif(tr_stopPara, tr_startPara);
		 bean.setTr(tr);
	 }		
//Addition 11/07/2016
//DEFINIR  FIXER LE TEMPS D'ARRET  EN FORMAT  DOUBLE   en UTILISANT UN PARAMETRE STRING Depuis Requette HTTP OK
	public void fixerARRET(HttpServletRequest request,String arret_total) throws Exception{
		double arret;
		String arret_totalPara=calcul.obtenirParam(request, arret_total);
		arret=calcul.calculStringDirectDif(arret_totalPara);
		if(arret_total.equals(ARRET1_TOTAL)){
			bean.setArret1(arret);
		}else if(arret_total.equals(ARRET2_TOTAL)) {
			bean.setArret2(arret);
		}else if(arret_total.equals(ARRET3_TOTAL)){
			bean.setArret3(arret);
		}else if(arret_total.equals(ARRET4_TOTAL)){
			bean.setArret4(arret);
		}else{
			throw new Exception ("Erreur :Acune paramettre HTTP  d'ARRET_TOTAL a été recu qui correspond  au  CONSTANTS ");
		}
		}
//OBTENIR  pieces NB en INT et l'enregistrer sur le Bean.
	public void fixerNB(HttpServletRequest request, String nb){
		int nbBean;
		String nbPara=calcul.obtenirParam(request, nb);
		nbBean =Integer.parseInt(nbPara);
		bean.setNb(nbBean);
	}
//OBTENIR  pieces NR en INT et l'enregistrer sur le Bean.
	public void fixerNR(HttpServletRequest request, String nr){
		int nrBean;
		String nrPara=calcul.obtenirParam(request, nr);
		nrBean =Integer.parseInt(nrPara);
		bean.setNr(nrBean);
		}
//CALCULER  temp Tnet  en DOUBLE et l'enregistrer sur le bean 
	public void fixerTnet(int nb , int nr ,String ref ,double tc ){
		double tnet =calcul.calculTnet(nb, nr, ref, tc);
		bean.setTnet(tnet);
	}
//CALCULER  temp Tu  en DOUBLE et l'enregistrer sur le bean 
	public void fixerTu(int nb,String ref ,double tc ){
		double tu =calcul.calculTu(nb, ref, tc);
		bean.setTu(tu);
	}
	 
}
