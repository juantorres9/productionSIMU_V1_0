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
import metier.GenerateurBean;

public class ControleurApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//Variables statiques de VUES
	public static final String FORMUlAIRE="/WEB-INF/formulaire.jsp";
	public static final String VALIDATION="/WEB-INF/validation.jsp";
	//classes metier
	private CycleBean bean;
	private GenerateurBean generateur;
	private Calculateur calcul;
	//classes Modeles
	private InterfaceTableaux base;


    public ControleurApp() {
    }


	public void init() throws ServletException {	
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	this.getServletContext().getRequestDispatcher(FORMUlAIRE).forward(request, response);
	
	}
		
		

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Etape0: Instantiation des Objet 
		bean=new CycleBean();
		generateur= new GenerateurBean();
		calcul=new Calculateur();
		base= new ImpleTableaux();
		//Etape1: envoie de requete pour generation d' Objet  Bean rempli.
		bean=generateur.creerCycleBean(request);
		//Etape2: enregistrement de Bean recuperé  dans la base de Données  creation tableau1
		base.creerTableau1(bean);
		//Etape3: creation tableau2
		try {
			base.creerTableau2();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//Etape4: creation tableau3
	
		//Etape5 envoi de Bean enregistrer vers page validation
		request.setAttribute("cycle", bean);
		
		//Forward avec Attribute  vers page VALIDATION 
		this.getServletContext().getRequestDispatcher(VALIDATION ).forward(request, response);
		}
		
	}


