package sasf.net.sri2;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); 
        return cal.getTime();
    }
	public static Date subDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, -days); 
        return cal.getTime();
    }
}
