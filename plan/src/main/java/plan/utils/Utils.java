package plan.utils;


public class Utils {
	
	/**
	 * rundet einen double auf 2 Stellen hinter dem Komma
	 * @param d zu rundender double
	 * @return auf 2 Stellen gerundet
	 */
	public static double runden(double d) {
		return ((double)(int)(d*100))/100;
	}
	
	/**
	 * Datum to String nach DD.MM.YYYY Format
	 * @param Date
	 * @return String nach DD.MM.YYYY Format
	 */
	public static String dateToString(LastDayOfMonth Date) {
		StringBuilder result = new StringBuilder();
		result.append(Date.getDay());
		result.append(".");
		result.append(Date.getMonth());
		result.append(".");
		result.append(Date.getYear());
		return result.toString();
	}
}
