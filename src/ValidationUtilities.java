public class ValidationUtilities {
	public static boolean isNullOrEmpty(String param) {
		if(param == null) //is null?
			return true;
		else if (param.length() < 1) //is empty?
			return true;
		else
			return false;
	}
	
	public static boolean isValidYear(String param) {
		
		int year = Integer.parseInt(param);
		if ( year >= 1900 && year <= 2018 )
			return true;
		else
			return false;
	}
	
	public static boolean checkStringLength(String param, int maxLength) {
		return param.length() > maxLength ? true : false;
	}
}