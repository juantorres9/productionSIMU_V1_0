package web;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ControleurApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//Variables statiques de VUES
	public static final String FORMUlAIRE="/WEB-INF/formulaire.jsp";
	public static final String VALIDATION="/WEB-INF/validationFeuille.jsp";


    public ControleurApp() {
  
    }


	public void init() throws ServletException {

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a=request.getParameter("idInput2");
		String b=request.getParameter("nameDrop2");
		if(a==null){
			this.getServletContext().getRequestDispatcher(FORMUlAIRE).forward(request, response);
		}else{
			a+=" vous avez bien enregistre votre application ";
			request.setAttribute("tempFinal", a);
			request.setAttribute("nom", b);
			this.getServletContext().getRequestDispatcher(VALIDATION).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(FORMUlAIRE).forward(request, response);
		
	}

}
