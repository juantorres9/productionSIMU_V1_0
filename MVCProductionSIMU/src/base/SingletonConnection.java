package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {	
	//Parametres de connection  , Plusieurs  utilisateurs connect�es avec le mme  compte ROOT possible 
	private static  String url="jdbc:mysql://localhost:3306/base_production";  //Url du serveur � se connecter + la base de donn�es
	private static String user="root";
	private  static String motpasse="root";	
	//Variable de  connection unique
	private  static  Connection connection;

static{
	try {
		Class.forName("com.mysql.jdbc.Driver");//charger Driver JDBC Jar
		connection=DriverManager.getConnection(url, user,motpasse);//se connecter avec URL base de donnes 
	} catch (Exception e) {
		e.printStackTrace();
	}
}
//ACCESESSEUR
public static Connection getConnection() {
	return connection;
}
}
