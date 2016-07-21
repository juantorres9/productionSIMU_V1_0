package web;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatchServ
 */
@WebServlet("/DispatchServ")
public class DispatchServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//PARAMETRES
	public static final String ID_PAGE="idpage";
	public static final String ID_NOM="idnom";
	//JSP
	public static final String ACCUEIL="/accueil.jsp";
	
	//SERVLETS
	public static final String FORMULAIRE="/WEB-INF/formulaire.jsp";
	
    public DispatchServ() {
        super();
        // TODO Auto-generated constructor stub
    }


	public void init() throws ServletException {
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(ACCUEIL).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Etape0:recuperation de parametres de la requete : idPage et idNom
		String id=request.getParameter(ID_PAGE);
		String nom=request.getParameter(ID_NOM);
		//Etape1: Choix de la page JSP a redirectioner selon l'Identifiant  
		if(id.equals("validation")){
			response.sendRedirect(request.getContextPath()+ACCUEIL);
		}else if (id.equals("machine1")){
			//Recuperation de parametres depuis JSP : accueil.jsp pour son envoie au formulaire 
			request.setAttribute("nom", nom);
			this.getServletContext().getRequestDispatcher(FORMULAIRE).forward(request, response);
		}else{
			this.getServletContext().getRequestDispatcher(ACCUEIL).forward(request, response);
		}
	}

}
