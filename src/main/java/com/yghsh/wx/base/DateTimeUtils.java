package com.yghsh.wx.base;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class DateTimeUtils {

	// 求当日的第二日的日期且返回的类型精确到分秒
	public static String toDaySecond(Date date) {
		SimpleDateFormat sft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		String nextDate = sft.format(calendar.getTime());
		return nextDate;
	}
	
    public static String covertDateToString(Date date, String format)
    {
        if (date == null)
        {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static Date addTimeByDays(Date currentDate, int days)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(currentDate.getTime());
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }
	// 求当日的第二日的日期且返回的类型精确到分秒
	/**
	 * 将20090402103531 转换成 yyyy-MM-dd HH:mm:ss形式输出
	 * 
	 * @return
	 */
	public static String strToDatestr(String datetime) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sss = null;
		try {
			sss = sdf2.format(sdf.parse(datetime));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return sss;
	}

	// 求当日的第二日的日期且返回的类型精确到分秒
	public static String toDaySecond2(Date date) {
		SimpleDateFormat sft = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		String nextDate = sft.format(calendar.getTime());
		return nextDate;
	}

	// 求当日的第二日的日期且返回的类型精确到当天并且用汉字表示
	public static String toDayDateChinese(Date date) {
		SimpleDateFormat sft = new SimpleDateFormat("yy年MM月dd日零时");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		String nextDate = null;
		nextDate = sft.format(calendar.getTime());
		return nextDate;
	}

	/**
	 * @Title: getNowTime
	 * @Description: (获取当前时间)
	 * @param format
	 * @return
	 */
	public static String getNowTime(String format) {
		SimpleDateFormat df = new SimpleDateFormat(format);// 设置日期格式
		return df.format(new Date());
	}

	// 求精确到当天并且精确到时分秒(计算保险起期)
	public static String plyStrTime(Date date) {
		SimpleDateFormat sft = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		String nextDate = null;
		nextDate = sft.format(calendar.getTime());
		return nextDate;
	}

	// 求精确到当天并且精确到时分秒(计算保险止期)
	public static String plyEndTime(Date date, int period, int unit) {
		SimpleDateFormat sft = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		if (unit == 1) {
			calendar.add(Calendar.YEAR, 1);
		}
		if (unit == 2) {
			calendar.add(Calendar.MONTH, 1);
		}
		if (unit == 3) {
			calendar.add(Calendar.DAY_OF_MONTH, 1);
		}
		String nextDate = null;
		nextDate = sft.format(calendar.getTime());
		return nextDate;
	}

	// 求当日的第二日的日期且返回的类型精确到分秒
	public static String convertDaySecond(Date date) {
		SimpleDateFormat sft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String nowTime = sft.format(date);
		return nowTime;
	}

	public static String getIpAddr(HttpServletRequest request) {

		String ip = request.getHeader("x-forwarded-for");

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {

			ip = request.getHeader("Proxy-Client-IP");

		}

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {

			ip = request.getHeader("WL-Proxy-Client-IP");

		}

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {

			ip = request.getRemoteAddr();

		}

		return ip;

	}

	// 活动活动锁定日期（阳光理财8.8活动）
	public static String lockedEndTime(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Calendar now = Calendar.getInstance();
		now.set(Calendar.DATE, now.get(Calendar.DATE) + 90);
		return sdf.format(now.getTime());
	}

	/**
	 * @Title: timeFormat
	 * @param date
	 *            时间字符串
	 * @param format1
	 *            字符串的格式
	 * @param format2
	 *            想要的时间格式
	 * @return
	 */
	public static String timeFormat(String date, String format1, String format2) {
		SimpleDateFormat sdf1 = new SimpleDateFormat(format1);
		SimpleDateFormat sdf2 = new SimpleDateFormat(format2);
		String s = null;
		try {
			s = sdf2.format(sdf1.parse(date));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		return s;
	}

	/**
	 * 比较时间大小
	 * 
	 * @param DATE1
	 * @param DATE2
	 * @return
	 */
	public static int compare_date(String DATE1, String DATE2) {

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dt1 = df.parse(DATE1);
			Date dt2 = df.parse(DATE2);
			if (dt1.getTime() > dt2.getTime()) {
				// System.out.println("dt1 在dt2前");
				return 1;
			} else if (dt1.getTime() < dt2.getTime()) {
				// System.out.println("dt1在dt2后");
				return -1;
			} else {
				return 0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}

	public static int compare_date1(String DATE1, String DATE2) {

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (DATE1.length() == 19 && DATE2.length() == 19) {
			try {
				Date dt1 = df.parse(DATE1);
				Date dt2 = df.parse(DATE2);
				if (dt1.getTime() > dt2.getTime()) {
					// System.out.println("dt1 在dt2前");
					return 1;
				} else if (dt1.getTime() < dt2.getTime()) {
					// System.out.println("dt1在dt2后");
					return -1;
				} else {
					return 0;
				}
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		//SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar now = Calendar.getInstance();
		now.set(Calendar.DATE, now.get(Calendar.DATE) + 1);
		System.out.println(toDaySecond(new Date()));
		// Double d = Double.parseDouble("20150423092509");
		String str = "2015-04-22 14:00:30";
		System.out.println(str.length());
		// Date date=new Date();
		// System.out.println(toDaySecond(date));
		// System.out.println(compare_date("2015-04-23 09:31:14",DateTimeUtils.getNowTime("yyyy-MM-dd HH:mm:ss")));

	}
	
	/**
     * 为当前时间增加年.
     * 
     * @param currentDate the current date
     * @param years the years
     * @return the date
     */
    public static Date addTimeByYears(Date currentDate, int years)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(currentDate.getTime());
        calendar.add(Calendar.YEAR, years);
        return calendar.getTime();
    }
}
