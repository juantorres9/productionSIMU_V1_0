package base;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import metier.CycleBean;

public class ImpleTableaux implements InterfaceTableaux{
	//PROCEDURE GENERAL
	private String REF;
	//Modification de nom procedure pour  appeler procedure   avec 4  arrets  11/07/2016
	public static final String PROGEN="pro_ligne_t2_a";
	public static final String PROGEN_T3="pro_ligne_t3_a";
	//PROCEDURE REF1 TABLEAU2
	public static final String PROA1="pro1_ref1_t2_a";
	public static final String PROA2="pro2_ref1_t2_a";
	//PROCEDURE REF2 TABLEAU2
	public static final String PROB1="pro1_ref2_t2_a";
	public static final String PROB2="pro2_ref2_t2_a";
	//PROCEDURE REF3 TABLEAU2
	public static final String PROC1="pro1_ref3_t2_a";
	public static final String PROC2="pro2_ref3_t2_a";
	//PROCEDURE REFTOTALE TABLEAU3
	public static final String PROA1_T3="pro1_reftotal_t3_a";
	public static final String PROA2_T3="pro2_reftotal_t3_a";
	
	@Override
	public void creerTableau1(CycleBean cycle) {
		String datetimes =cycle.getDatetimes();
		String ref=cycle.getReference();
		String nom=cycle.getNom();
		double tr=cycle.getTr();
		double arret1=cycle.getArret1();
		double arret2=cycle.getArret2();
		//Addition 11/07/2016
		double arret3=cycle.getArret3();
		double arret4=cycle.getArret4();
		//fin Addition 11/07/2016
		int nb=cycle.getNb();
		int nr=cycle.getNr();
		double tnet=cycle.getTnet();
		double tu=cycle.getTu();
		//Addition 11/07/2016
		insertCycleSQL(datetimes, ref, nom, tr, arret1, arret2,arret3,arret4, nb, nr, tnet, tu);
		//fin Addition 11/07/2016
		//Assignation de Reference de Tri
		REF=ref;
	}

	@Override
	public void creerTableau2() throws Exception{
		
		switch(REF.toLowerCase()) {
			case "ref1":
				//Remplissage Totale  T2 ref1
				creerRef1_T2();
				break;
				//Remplissage Totale  T2 ref2
			case "ref2":
				creerRef2_T2();
				break;
				//Remplissage Totale  T2 ref3
			case "ref3":
				creerRef3_T2();
				break;
			default:
				throw new Exception("ImpleTableau échoué  AUCUNE REFERENCE ref Recuperé depuis le  Bean");
				}
		}

	@Override
	public void creerTableau3() {
		creerRefTotal_T3();
	}
	
//********************Methodes Auxiliaires*******************************************
    //Methode REQUETE SQL pour appeler l'execution d'un procedure
	public void executerProSQL(String procedure) {
		Connection conn=SingletonConnection.getConnection();//Creation Connection 
		String pro="{CALL "+procedure+"()}";
		try {
			
			CallableStatement  cs =conn.prepareCall(pro);
			cs.execute();
			cs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}		
	}
	//Addition arret34 et nom de tableau1 à tableau1_a  11/07/2016
	public void insertCycleSQL(String datetimes,String ref,String nom,double tr,double arret1,double arret2,double arret3,double arret4,int nb,int nr,double tnet,double tu){
		Connection conn=SingletonConnection.getConnection();
		try{
			PreparedStatement ps=conn.prepareStatement("INSERT INTO tableau1_a(id,datetimes,reference,nom,tr,arret1,arret2,arret3,arret4,nb,nr,tnet,tu)"
					+ "VALUES(NULL,?,?,?,?,?,?,?,?,?,?,?,?)");
	//fin Addition 11/07/2016
			ps.setString(1, datetimes);
			ps.setString(2, ref);
			ps.setString(3, nom);
			ps.setDouble(4, tr);
			ps.setDouble(5, arret1);
			ps.setDouble(6, arret2);
			//Addition 11/07/2016
			ps.setDouble(7, arret3);
			ps.setDouble(8, arret4);
			//fin Addition 11/07/2016
			ps.setInt(9, nb);
			ps.setInt(10, nr);
			ps.setDouble(11, tnet);
			ps.setDouble(12, tu);
			
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public void creerRef1_T2(){
		//Creation de Lignes vides
		executerProSQL(PROGEN);
		//premier calcul T2
		executerProSQL(PROA1);
		//Deuxieme calcul T2
		executerProSQL(PROA2);
	}
	
	public void creerRef2_T2(){
		//Creation de Lignes vides
		executerProSQL(PROGEN);
		//premier calcul T2
		executerProSQL(PROB1);
		//Deuxieme calcul T2
		executerProSQL(PROB2);
	}
	
	public void creerRef3_T2(){
		//Creation de Lignes vides
		executerProSQL(PROGEN);
		//premier calcul T2
		executerProSQL(PROC1);
		//Deuxieme calcul T2
		executerProSQL(PROC2);
	}
	
	//Additio creation données totales tableau3
	public void creerRefTotal_T3(){
		//Creation de Lignes vides tableau3
		executerProSQL(PROGEN_T3);
		//premier calcul T2
		executerProSQL(PROA1_T3);
		//Deuxieme calcul T2
		executerProSQL(PROA2_T3);
	}

	
}
