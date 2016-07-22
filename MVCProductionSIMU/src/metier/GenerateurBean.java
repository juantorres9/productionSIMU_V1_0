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
	
	/**DEPRECATED ARRETFIX: 21/07/2016
	public static final String ARRET1_START="arret1_start";
	public static final String ARRET1_STOP="arret1_stop";
	*/
	public static final String ARRET1_TOTAL="arret1_total";
	
	/**DEPRECATED ARRETFIX: 21/07/2016
	public static final String ARRET2_START="arret2_start";
	public static final String ARRET2_STOP="arret2_stop";
	*/
	public static final String ARRET2_TOTAL="arret2_total";
	//Addition 11/07/2016
	/**DEPRECATED VERSION MASTER: 22/07/2016
	public static final String ARRET3_START="arret3_start";
	public static final String ARRET3_STOP="arret3_stop";
	*/
	public static final String ARRET3_TOTAL="arret3_total";
	/**DEPRECATED VERSION MASTER: 22/07/2016
	public static final String ARRET4_START="arret4_start";
	public static final String ARRET4_STOP="arret4_stop";
	*/
	
	public static final String ARRET4_TOTAL="arret4_total";
	//fin Addition 11/07/2016
	
	public static final String NB="nb";
	public static final String NR="nr";
	
	//******************************************************************************************************************************************	
	//CREER BEAN  du premier ligne du tableau1 Base de donn�es avec tous les types de columns selon SQL OK
	 public CycleBean	creerCycleBean (HttpServletRequest request){
		 this.fixerDATE(request,DATE);
		 this.fixerREF_TC(request, REF_TC);
		 this.fixerNOM(request, NOM);
		 this.fixerTR(request, TR_STOP, TR_START);
		/**DEPRECATED VERSION ARRETFIX : 21/07/2016 
		 this.fixerARRET1(request, ARRET1_STOP, ARRET1_START);
		 **/
		 //VERSION ARRETFIX : 21/07/2016
		 this.fixerARRET1(request, ARRET1_TOTAL);
		 /**DEPRECATED VERSION ARRETFIX : 21/07/2016 
		 this.fixerARRET2(request, ARRET2_STOP, ARRET2_START);
		 **/
		 this.fixerARRET2(request, ARRET2_TOTAL);
		 //Addition 11/07/2016
		 /**DEPRECATED VERSION MASTER : 22/07/2016 
		 this.fixerARRET3(request, ARRET3_STOP, ARRET3_START);
		 */
		 try {
			this.fixerARRET(request, ARRET3_TOTAL);
			this.fixerARRET(request, ARRET4_TOTAL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		
		//fin Addition 11/07/2016
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
//CALCULER l'  ARRET1  en DOUBLE  et l'enregistrer sur le BEAN 
	/** DEPRECATED ARRETFIX: 21/07/2016
	public void fixerARRET1(HttpServletRequest request,String arret1_stop, String arret1_start){
	double arret1;
	String arret1_stopPara=calcul.obtenirParam(request, arret1_stop);
	String arret1_startPara=calcul.obtenirParam(request, arret1_start);
	arret1=calcul.calculStringDif(arret1_stopPara, arret1_startPara);
	bean.setArret1(arret1);
	}
	*/
//VERSION ARRETFIX :21/07/2016  FORMATAGE ET ENREGISTREMENT Direct de la  Difference d'ARRET provenant de la REQUETE HTTP
	public void fixerARRET1(HttpServletRequest request,String arret1_total){
		double arret1;
		String arret1_totalPara=calcul.obtenirParam(request, ARRET1_TOTAL);
		arret1=calcul.calculStringDirectDif(arret1_totalPara);
		bean.setArret1(arret1);	
	}
//CALCULER l'  ARRET2  en DOUBLE  et l'enregistrer sur le BEAN 
	/** DEPRECATED ARRETFIX: 21/07/2016
	public void fixerARRET2(HttpServletRequest request,String arret2_stop,String arret2_start){
		double arret2;
		String arret2_stopPara=calcul.obtenirParam(request, arret2_stop);
		String arret2_startPara=calcul.obtenirParam(request, arret2_start);
		arret2=calcul.calculStringDif(arret2_stopPara, arret2_startPara);
		bean.setArret2(arret2);
		}
	*/
//VERSION ARRETFIX :21/07/2016  FORMATAGE ET ENREGISTREMENT Direct de la  Difference d'ARRET provenant de la REQUETE HTTP
	public void fixerARRET2(HttpServletRequest request,String arret2_total){
		double arret2;
		String arret2_totalPara=calcul.obtenirParam(request, ARRET2_TOTAL);
		arret2=calcul.calculStringDirectDif(arret2_totalPara);
		bean.setArret2(arret2);	
		}		
//Addition 11/07/2016
//CALCULER l'ARRET3  en DOUBLE  et l'enregistrer sur le BEAN 
	/** DEPRECATED VERSION MASTER : 22/07/2016
	public void fixerARRET3(HttpServletRequest request,String arret3_stop,String arret3_start){
		double arret3;
		String arret3_stopPara=calcul.obtenirParam(request, arret3_stop);
		String arret3_startPara=calcul.obtenirParam(request, arret3_start);
		arret3=calcul.calculStringDif(arret3_stopPara, arret3_startPara);
			bean.setArret3(arret3);
		}
		*/
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
			throw new Exception ("Erreur :Acune paramettre HTTP  d'ARRET_TOTAL a �t� recu qui correspond  au  CONSTANTS ");
		}
		}
			
//CALCULER l'ARRET4  en DOUBLE  et l'enregistrer sur le BEAN 
	public void fixerARRET4(HttpServletRequest request,String arret4_stop,String arret4_start){
		double arret4;
		String arret4_stopPara=calcul.obtenirParam(request, arret4_stop);
		String arret4_startPara=calcul.obtenirParam(request, arret4_start);
		arret4=calcul.calculStringDif(arret4_stopPara, arret4_startPara);
		bean.setArret4(arret4);
		}	
//fin Addition 11/07/2016
	
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
