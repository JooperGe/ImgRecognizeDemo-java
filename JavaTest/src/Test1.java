import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {

	public static void main(String[] args) {

		// test(3);
		// testArray();
		// testPlus();
		// for (int i = 0; i < 9; i++) {
		//
		// testInt(i);
		// }

		// testInt(3);
		// 0-3 4-7
		// test1(6);
		// test2();
		test3(" + 8618 515   58 19 11 " + "");

		testSplit();

		zz11();

		zz12();

		System.out.println("71701:" + "\"");

		zz13();

		zz14("2016-07-19 16:08:02");

		zz15();
		zz16();
	}

	private static void test(int num) {

		System.out.println("" + num % 4);
	}

	private static void testArray() {

		String[][] array1 = { { "10", "11", "12" } };

		System.out.println(array1[0][1]);
	}

	private static void testPlus() {

		int a = 0;

		System.out.println(a++);

		int b = 0;
		System.out.println(++b);
	}

	private static void testInt(int i) {

		for (int j = 0; j < 9; j++) {

			if (j != 0 && (j + 1) % 4 == 0) {

				System.out.println((j + 1) / 4);
			} else {

				System.out.println(((j + 1) + 4 - ((j + 1) % 4)) / 4);
			}
		}
	}

	private static void test1(int i) {

		System.out.println(i / 4);
	}

	private static void test2() {

		Calendar c = Calendar.getInstance();
		System.out.println(c.get(Calendar.HOUR_OF_DAY));
	}

	private static void test3(String num) {

		String resultStr = null;
		num = num.replaceAll(" ", "").trim();
		if (num.contains("+86")) {

			resultStr = num.substring(3);
		} else {

			resultStr = num;
		}
		System.out.println(resultStr);
	}

	private static void testSplit() {

		System.out.println("7月11期".split("月")[0] + " - "
				+ "7月11期".split("月")[1].split("期")[0]);
	}

	private static void zz11() {

		Pattern p = Pattern
				.compile("^((13[0-9])|(15[^4,\\D])|(17[0-9])|(18[0,5-9]))\\d{8}$");
		Pattern p1 = Pattern.compile("^(\\d{11})$");
		System.out.println(p1.matcher("10406070910").find());
	}

	private static void zz12() {

		Pattern p = Pattern.compile("^[0-9]*$");
		Pattern p1 = Pattern.compile("^(\\d{11})$");
		System.out.println("two：" + "10406070910".matches("^[0-9]*$"));
	}

	private static void zz13() {

		Date date = new Date(System.currentTimeMillis());
		String strs = "";

		// yyyy表示年MM表示月dd表示日
		// yyyy-MM-dd是日期的格式，比如2015-12-12如果你要得到2015年12月12日就换成yyyy年MM月dd日
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		// 进行格式化
		strs = sdf.format(date);

		System.out.println("three：" + strs);
	}

	private static void zz14(String time) {

		String newTim = time.split(" ")[0];

		String[] times = newTim.split("-");

		System.out.println("four：" + times[0] + "年" + times[1] + "月" + times[2]
				+ "日");
	}

	private static void zz15() {

		// Pattern p = Pattern
		// .compile("^((13[0-9])|(15[^4,\\D])|(18[^4,\\D]))\\d{8}$");
		// Pattern p = Pattern
		// .compile("(^((13[0-9])|(15[^4,\\D])|(18[^4,\\D]))\\d{8}$)||(^(((09[0-9]))\\d{7})$)");/*(13[0-9])*/
		Pattern p1 = Pattern
				.compile("^((09[0-2])|(15[^4,\\D])|(18[^4,\\D]))\\d{8}$");
		Pattern p2 = Pattern.compile("0{2}");
		Pattern p3 = Pattern.compile("^(\\d{9}|\\d{11})$");
		Pattern p = Pattern
				.compile("(^((13[0-9])|(15[^4,\\D])|(18[^4,\\D]))\\d{8}$)||(^(((09[0-9]))\\d{7})$)||(^(((9[0-9]))\\d{7})$)");
		Matcher m = p.matcher("912345670");

		System.out.println("mobiles：" + m.matches());
	}

	private static void zz16() {

		String a = null;
		String b = null;
		String c = null;
		String d = null;
		String test ="," + "," +  ","+1;
		System.out.println("zz16：" + test.split(",").length);
	}
}