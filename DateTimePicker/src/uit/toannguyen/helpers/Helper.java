package uit.toannguyen.helpers;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import android.widget.DatePicker;
import android.widget.TimePicker;

/**
 * @author tnguyen364
 * 
 */
public class Helper {

	public static final String FULL_FORMAT = "E, MMMM dd, yyyy hh:mm a";
	public static final String NORMAL_DAY_OF_WEEK_FORMAT = "E, MMMM dd, yyyy";
	public static final String NORMAL_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String SHORT_FORMAT = "yyyy-MM-dd";

	/**
	 * Convert String date to Date type
	 * 
	 * @param date
	 *            String date
	 * @param format
	 *            date format
	 * @return Date
	 */
	public static Date stringToDate(String date, String format) {
		if (date == null)
			return null;
		ParsePosition pos = new ParsePosition(0);
		SimpleDateFormat simpledateformat = new SimpleDateFormat(format);
		Date stringDate = simpledateformat.parse(date, pos);
		return stringDate;

	}

	/**
	 * Convert Date to String
	 * 
	 * @param date
	 *            date
	 * @param format
	 *            format
	 * @return
	 */
	public static String dateToString(Date date, String format) {
		String strDate = "";
		SimpleDateFormat simpledateformat = new SimpleDateFormat(format);
		strDate = simpledateformat.format(date);
		return strDate;
	}

	/**
	 * get datetime
	 */
	public String getDateTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss", Locale.getDefault());
		Date date = new Date();
		return dateFormat.format(date);
	}

	/**
	 * Get Date from DatePicker
	 * 
	 * @param datePicker
	 * @return a java.util.Date
	 */
	public static Date getDateFromDatePicket(DatePicker datePicker) {
		int day = datePicker.getDayOfMonth();
		int month = datePicker.getMonth();
		int year = datePicker.getYear();

		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, day);

		return calendar.getTime();
	}

	/**
	 * Get time from TimePicker
	 * 
	 * @param timePicker
	 * @return time string
	 */
	public static String getStringTimeFromTimePicker(TimePicker timePicker) {
		String time = "";
		int hour = timePicker.getCurrentHour();
		int minute = timePicker.getCurrentMinute();
		time = getStringTimeFromTime(hour, minute);
		return time;
	}
	

	public static String getStringTimeFromTime(int hourofday, int minute) {
		String time = "";
		String AM_PM = "";
		if (hourofday < 12) {
			AM_PM = "AM";
		} else {
			hourofday -= 12;
			AM_PM = "PM";
		}
		time = hourofday + ":" + minute + " " + AM_PM;
		return time;
	}
	/**
	 * Check if date1 is after date2 or not
	 * @return true if date1 after date 2, otherwise false.
	 */
	public static boolean isAfter(Date date1, Date date2){
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);
		
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		
		if(cal1.get(Calendar.YEAR) > cal2.get(Calendar.YEAR)){
			return true;
		} else if(cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) && cal1.get(Calendar.MONTH) > cal2.get(Calendar.MONTH)){
			return true;
		} else if(cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH) &&
				cal1.get(Calendar.DAY_OF_MONTH) > cal2.get(Calendar.DAY_OF_MONTH)){
			return true;
		}
		
		return false;
	}
	
	/**
	 * Check if date1 is after date2 or not
	 * @return true if date1 after date 2, otherwise false.
	 */
	public static boolean isBefore(Date date1, Date date2){
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);
		
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		
		if(cal1.get(Calendar.YEAR) < cal2.get(Calendar.YEAR)){
			return true;
		} else if(cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) && cal1.get(Calendar.MONTH) < cal2.get(Calendar.MONTH)){
			return true;
		} else if(cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH) &&
				cal1.get(Calendar.DAY_OF_MONTH) < cal2.get(Calendar.DAY_OF_MONTH)){
			return true;
		}
		
		return false;
	}
}
