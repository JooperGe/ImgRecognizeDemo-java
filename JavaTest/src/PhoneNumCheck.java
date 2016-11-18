import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumCheck {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		System.out.println(numCheck("18515581911"));

		String str_test = " 185  15581911";

		System.out.println(str_test.trim());
		System.out.println(str_test.replaceAll(" ", "").trim());

		System.out.println("test:" + "+8618515581911".substring(3));

		System.out.println("testRandom:"
				+ (int) (1 + Math.random() * (10 - 1 + 1)));

		Random mRandom = new Random();
		System.out.println("testRandom1:"
				+ (mRandom.nextDouble() * (0.8 - 0.3) + 0.3));

		System.out.println("double-int:" + (int) 1.8);

		System.out.println("两位小数"
				+ new java.text.DecimalFormat("#.00").format(3.1415926));

		Date now = new Date();
		DateFormat df = DateFormat.getDateInstance();
		System.out.println("哈哈：" + df.format(now));

		initDateStr("2016-04-21 14:25:41");

		SimpleDateFormat sFormat = new SimpleDateFormat("HH:mm");
		Calendar c2 = Calendar.getInstance();

		String temp = sFormat.format(c2.getTime());
		System.out.println("嘿嘿：" + temp);

		// Date dNow = new Date(1463627652565L);
		// Date dNow = new Date(1467193435000L);
		Date dNow = new Date(System.currentTimeMillis());// 与上一个long值差1000倍【秒】

		System.out.println("哼哼：" + (dNow.getMonth() + 1) + "月" + dNow.getDate()
				+ "日" + " - " + dNow.getHours() + ":" + dNow.getMinutes());

		System.out.println("24:"
				+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dNow));

		string2Date(System.currentTimeMillis() + "", null);

	}

	private static boolean numCheck(String num) {

		String regExp = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";

		Pattern p = Pattern.compile(regExp);

		Matcher m = p.matcher(num);

		return m.find();
	}

	static void initDateStr(String time) {

		// [2016-04-21, 14:25:41]
		String month = "";
		String day = "";
		month = time.split(" ")[0].split("-")[1];
		day = time.split(" ")[0].split("-")[2];
		if (month.length() > 1 && month.substring(0, 1).equals("0")) {

			month = month.substring(1);
		}
		if (day.length() > 1 && day.substring(0, 1).equals("0")) {

			day = day.substring(1);
		}
	}

	public static Date string2Date(String dateString, String formatString) {
		if (formatString == null) {
			formatString = "yyyy-MM-dd HH:mm:ss";
		}
		DateFormat dd = new SimpleDateFormat(formatString);
		Date date = null;
		try {
			date = dd.parse(dateString);
		} catch (ParseException e) {
		}
		return date;
	}
}
