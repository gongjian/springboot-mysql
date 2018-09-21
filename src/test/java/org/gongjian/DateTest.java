package org.gongjian;

import java.util.Calendar;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH)+1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 10);
		cal.set(Calendar.SECOND, 0);
		
		System.out.println(cal.getTime());
		System.out.println(new Date());
		
		System.out.println(cal.getTime().getTime());
		System.out.println(cal.getTimeInMillis());
	}
}
