import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test2 {

	public static void main(String[] args) {

		// testArrayList();
		// testSplit();
		// testSplit2();

		// System.out
		// .println(getVertifyCode("【乐简系统】您正在申请注册，验证码为：906，请在30000分钟内完成验证。"));
		// testefficient();
		// testsanmu();
		// testBoolean();
		// System.out.println(testReturn());
		// testIntFormat();
		testSplit3();
	}

	private static void testSplit() {

		System.out.println("北京/南京【】东京==西京".split("【】")[0]);
	}

	private static String getVertifyCode(String str) {

		/**
		 * efficiency
		 */
		StringBuilder sBuilder = new StringBuilder();

		for (int i = 0; i < str.codePointCount(0, str.length()); i++) {

			int codePoint = str.codePointAt(str.offsetByCodePoints(0, i));
			if (!Character.isSupplementaryCodePoint(codePoint)) {

				if (Character.isDigit(codePoint)) {

					sBuilder.append((char) codePoint);
				} else {

					if (sBuilder.length() >= 4) {

						return sBuilder.toString();
					} else {

						sBuilder.delete(0, sBuilder.length());
					}
				}
			}
		}
		return null;
	}

	private static void testSplit1() {

		String str = "【乐简系统】您正在申请注册，验证码为：9050，请在30分钟内完成验证。";

		boolean isNumeric = false;
		for (int i = 0; i < str.codePointCount(0, str.length()); i++) {

			int index = str.offsetByCodePoints(0, i);
			int cp = str.codePointAt(index);
			if (!Character.isSupplementaryCodePoint(cp)) {

				if (Character.isDigit(cp)) {

					System.out.println("数字：" + (char) cp);
				} else {

					System.out.println("---非数字：" + (char) cp);
				}
				// System.out.println("1：" + (char) cp);
			} else {
				// System.out.println("2：" + cp);
			}
		}
	}

	private static void testSplit2() {

		StringBuilder sBuilder = new StringBuilder("1");
		System.out.println(sBuilder.toString());
	}

	private static void testArrayList() {

		final List<Entity> mList = new ArrayList<Test2.Entity>();

		Entity tempEntity = null;
		for (int i = 0; i < 10; i++) {

			tempEntity = new Entity("n" + i, 23);
			mList.add(tempEntity);
		}

		Iterator<Entity> miIterator = mList.iterator();
		while (miIterator.hasNext()) {

			Entity mEntity = miIterator.next();
			if (mEntity.getName().equals("n3")) {

				miIterator.remove();
			}
		}
	}

	static class Entity {

		public Entity() {
			super();
		}

		public Entity(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}

		String name;
		int age;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
	}

	/**
	 * 
	 * @param
	 * 
	 * @author Jooper
	 * @2016年10月24日 下午1:11:09
	 */
	private static void testefficient() {

		int a = 2, b = 1;
		// if (a > 0)
		// b += 2;
		// else
		// b += 1;

		b += 1 + (a >> 1);
		System.out.println(b);
	}

	private static void testsanmu() {

		String str = null;
		System.out.println((null == str || str.isEmpty()) ? "舒服" : str);
	}

	private static void testBoolean() {

		System.out.println(0 == 1);
	}

	private static String testReturn() {

		try {
			return "try";
		} catch (Exception e) {

			e.printStackTrace();
			return "exception";
		} finally {

			return "finally";
		}
	}

	private static void testIntFormat() {

		System.out.println(Double.valueOf("-10"));
	}

	private static void testSplit3() {

		String str = "1,23,4,5,6";
		String[] result = str.split(",");
		String newName = "";
		for (int i = 1; i < result.length - 1; i++) {

			newName += result[i];
		}
		System.out.println(newName);
	}
}