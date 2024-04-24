package calendario;

import java.util.Calendar;
import java.util.Date;

public class Prueba {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
	    cal.setTime(new Date(2024-1900, 3, 1));
	    System.out.println(new Date(2024-1900, 3, 1));
	    System.out.println(cal.get(Calendar.DAY_OF_WEEK));
	}
}

