import java.util.Calendar;

public class CopyOfPhoneNumCheck {

	public static void main(String[] args) {

		analiy("04月26日");
		getCalender();
	}

	enum Color {
		Red, Green;
	}

	static void analiy(String str) {

		str = str.replaceAll("月", ".");
		System.out.println(str);
		str = str.replaceAll("日", "");
		System.out.println(str);

		System.out.println(Double.valueOf(str));

		System.out.println(String.valueOf(4.25).replace(".", "月") + "日");

	}

	static void getCalender() {

		int year, month, day, hour, minute;
		Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		/**
		 * 月份从0开始计算
		 */
		for (int i = 0; i < 7; i++) {

			c = Calendar.getInstance();
			c.add(Calendar.DAY_OF_MONTH, 0 - (7 - i));

			month = c.get(Calendar.MONTH);
			day = c.get(Calendar.DAY_OF_MONTH);
			System.out.println(month + "-" + day);

		}
		hour = c.get(Calendar.HOUR_OF_DAY);
		minute = c.get(Calendar.MINUTE);

		// System.out.println(year + "-" + month + "-" + day + "-" + hour + "-"
		// + minute);
	}
}
