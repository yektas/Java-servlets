

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/setup-database")
public class SetupDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SetupDatabase() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean result = DataAccess.createDb();
		String title="";
		String message="";
		if(result){
			title = "Success";
			message = "Database created.";
		}
		else{
			title = "Error";
			message = "An error occured during database creation!";
		}
		request.setAttribute("title", title);
		request.setAttribute("message", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/setup-db.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
