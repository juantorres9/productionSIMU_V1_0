package web;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.ImpleTableaux;
import base.InterfaceTableaux;
import metier.Calculateur;
import metier.CycleBean;

public class ControleurApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//Variables statiques de VUES
	public static final String FORMUlAIRE="/WEB-INF/formulaire.jsp";
	public static final String VALIDATION="/WEB-INF/validationFeuille.jsp";
	//classes metier
	private Calculateur calcul;
	//classes modele
	private InterfaceTableaux base;


    public ControleurApp() {
  
    }


	public void init() throws ServletException {
		//Instantiation Classes metier
		
		
	
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(FORMUlAIRE).forward(request, response);
		}
		
		

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Etape1: envoie de requete pour traitement et recuperation de Bean rempli.
		calcul=new Calculateur();
		CycleBean bean=	calcul.creerCycleBean(request);
		//Etape2: enregistrement de Bean recuperé  dans la base de Données
		base= new ImpleTableaux();
		//Etape3: creation tableau1
		base.creerTableau1(bean);
		//Etape4: creation tableau2
		base.creerTableau2();
		
		
			this.getServletContext().getRequestDispatcher(FORMUlAIRE).forward(request, response);
		}
		
	}


