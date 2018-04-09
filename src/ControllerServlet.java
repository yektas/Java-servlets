
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.derby.vti.ForwardingVTI;

@WebServlet(name = "ControllerSevlet", urlPatterns = { "/show-cars", "/add-car", "/delete-car", "/edit-car", "/detail", "/sort" })
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControllerServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pattern = ServletUtilities.getURLPatternFromRequest(request);
		HttpSession session = request.getSession();
		String forwardTo = "";
		if (pattern.equals("add-car"))
			forwardTo = "WEB-INF/add-car.jsp";
		else if (pattern.equals("show-cars")) {
			session.setAttribute("cars", DataAccess.getCars());
			forwardTo = "WEB-INF/car-list.jsp";
		} else if (pattern.equals("detail")) {
			String id = request.getParameter("id");
			request.setAttribute("car", DataAccess.getCarById(Integer.parseInt(id)));
			forwardTo = "WEB-INF/car-detail.jsp";
		} else if (pattern.equals("delete-car")) {
			String id = request.getParameter("id");
			DataAccess.deleteCar(Integer.parseInt(id));
			session.setAttribute("cars", DataAccess.getCars());
			forwardTo = "WEB-INF/car-list.jsp";
		} else if (pattern.equals("edit-car")) {
			String id = request.getParameter("id");
			session.setAttribute("car", DataAccess.getCarById(Integer.parseInt(id)));
			forwardTo = "WEB-INF/edit-car.jsp";
		} else if (pattern.equals("sort")) {
			String sortOption = request.getParameter("by");
			session.setAttribute("cars", DataAccess.getCarsInOrder(sortOption));
			forwardTo = "WEB-INF/car-list.jsp";
		}

		RequestDispatcher rd = request.getRequestDispatcher(forwardTo);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pattern = ServletUtilities.getURLPatternFromRequest(request);
		HttpSession session = request.getSession();

		String forwardTo = "";
		boolean displayForm = false;
		String errorManufacturer = "", errorModel = "", errorYear = "", errorDescription = "", errorExpireDate = "";

		if (pattern.equals("add-car")) {
			String id = request.getParameter("id");
			String manufacturer = request.getParameter("manufacturer");
			String model = request.getParameter("model");
			String year = request.getParameter("year");
			String description = request.getParameter("description");
			String expireDate = request.getParameter("expire_date");

			List<String> fields = Arrays.asList(manufacturer, model, year, description, expireDate);

			int maxLength = 0;
			for (String field : fields) {
				if (ValidationUtilities.isNullOrEmpty(field)) {
					if (field.equals(manufacturer)) {
						errorManufacturer = "Please enter the manufacturer";
						displayForm = true;
					}
					if (field.equals(model)) {
						errorModel = "Please enter the model";
						displayForm = true;
					}
					if (field.equals(year)) {
						errorYear = "Please enter the year";
						displayForm = true;
					}
					if (field.equals(description)) {
						errorDescription = "Please enter the description";
						displayForm = true;
					}
					if (field.equals(expireDate)) {
						errorExpireDate = "Please enter the expire date";
						displayForm = true;
					}
				} else if (field.equals(manufacturer)) {
					maxLength = 50;
					if (ValidationUtilities.checkStringLength(field, maxLength)) {
						errorManufacturer = " Max. " + maxLength + " characters allowed.";
						displayForm = true;
					}
				} else if (field.equals(model)) {
					maxLength = 100;
					if (ValidationUtilities.checkStringLength(field, maxLength)) {
						errorModel = " Max. " + maxLength + " characters allowed.";
						displayForm = true;
					}
				} else if (field.equals(year)) {
					if (!ValidationUtilities.isValidYear(field)) {
						errorYear = "Year must be between 1900 and 2018!";
						displayForm = true;
					}
				} else if (field.equals(description)) {
					maxLength = 255;
					if (ValidationUtilities.checkStringLength(field, maxLength)) {
						errorDescription = " Max. " + maxLength + " characters allowed.";
						displayForm = true;
					}
				}
			}
			if (displayForm) {
				forwardTo = "WEB-INF/add-car.jsp";
				request.setAttribute("errorManufacturer", errorManufacturer);
				request.setAttribute("errorModel", errorModel);
				request.setAttribute("errorDescription", errorDescription);
				request.setAttribute("errorYear", errorYear);
				request.setAttribute("errorExpireDate", errorExpireDate);
			}

			else {

				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
				Car newCar = new Car();
				newCar.setManufacturer(manufacturer);
				newCar.setModel(model);
				newCar.setModelYear(Integer.parseInt(year));
				newCar.setDescription(description);
				try {
					newCar.setExpireDate(formatter.parse(expireDate));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				if (id == null) {
					DataAccess.saveCar(newCar);
					request.setAttribute("message", "Your car is added to the shop!");
				} else {
					newCar.setId(Integer.parseInt(id));
					request.setAttribute("message", "Car information is updated!");
					DataAccess.updateCar(newCar);
				}
				session.setAttribute("car", newCar);
				forwardTo = "WEB-INF/result.jsp";

			}
		}

		RequestDispatcher rd = request.getRequestDispatcher(forwardTo);
		rd.forward(request, response);

	}

}
