package base;

import java.sql.Connection;
import java.sql.PreparedStatement;

import metier.CycleBean;

public class ImpleTableaux implements InterfaceTableaux{

	@Override
	public void creerTableau1(CycleBean cycle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void creerTableau2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void creerTableau3() {
		// TODO Auto-generated method stub
		
	}
	
//********************Methodes Auxiliaires*******************************************
    //Methode REQUETE SQL pour appeler l'execution d'un procedure
	public void executerProSQL(String procedure) {
		Connection conn=SingletonConnection.getConnection();//Creation Connection 
			
		try {
			PreparedStatement  ps =conn.prepareStatement("CALL'"+nomEtagere+"' AND vide>0");
			 
				
			ps.executeUpdate();//Executer la requete
				ps.close();
			
			} catch (SQLException e) {
			
				e.printStackTrace();
			}		
	}
	
	

}
