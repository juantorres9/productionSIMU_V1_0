package base;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import metier.CycleBean;

public class ImpleTableaux implements InterfaceTableaux{
	//PROCEDURE GENERAL
	private String REF;
	public static final String PROGEN="pro_ligne_t2";
	//PROCEDURE REF1 TABLEAU2
	public static final String PROA1="pro1_ref1_t2";
	public static final String PROA2="pro2_ref1_t2";
	//PROCEDURE REF2 TABLEAU2
	public static final String PROB1="pro1_ref2_t2";
	public static final String PROB2="pro2_ref2_t2";
	//PROCEDURE REF3 TABLEAU2
	public static final String PROC1="pro1_ref3_t2";
	public static final String PROC2="pro2_ref3_t2";
	
	
	@Override
	public void creerTableau1(CycleBean cycle) {
		String datetimes =cycle.getDatetimes();
		String ref=cycle.getReference();
		String nom=cycle.getNom();
		double tr=cycle.getTr();
		double arret1=cycle.getArret1();
		double arret2=cycle.getArret2();
		int nb=cycle.getNb();
		int nr=cycle.getNr();
		double tnet=cycle.getTnet();
		double tu=cycle.getTu();
		insertCycleSQL(datetimes, ref, nom, tr, arret1, arret2, nb, nr, tnet, tu);
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
	//
		
	//

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
	public void insertCycleSQL(String datetimes,String ref ,String nom,double tr,double arret1,double arret2,int nb,int nr ,double tnet,double tu ){
		Connection conn=SingletonConnection.getConnection();
		try{
			PreparedStatement ps=conn.prepareStatement("INSERT INTO tableau1(id,datetimes,reference,nom,tr,arret1,arret2,nb,nr,tnet,tu)"
					+ "VALUES(NULL,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, datetimes);
			ps.setString(2, ref);
			ps.setString(3, nom);
			ps.setDouble(4, tr);
			ps.setDouble(5, arret1);
			ps.setDouble(6, arret2);
			ps.setInt(7, nb);
			ps.setInt(8, nr);
			ps.setDouble(9, tnet);
			ps.setDouble(10, tu);
			
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
	
}
