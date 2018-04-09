import javax.servlet.http.HttpServletRequest;

public class ServletUtilities {
	
	public static String getURLPatternFromRequest(HttpServletRequest request){
		//Get request URI to extract desired action
		//URI format: /appname/pattern
		String uri = request.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String pattern = uri.substring(lastIndex + 1);
		
		return pattern;
	}
}