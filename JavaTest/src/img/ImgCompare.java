package img;

/**
 * 图片比较：根据两张图片的特征值图(直方图)得到的像素矩阵逐点比较
 *
 * @author Jooper
 * @2016年11月15日 下午5:59:42
 */
public class ImgCompare {

	public static void main(String[] args) {

		// compare("G:/Desktop/otsuDemo/suanfa/jooper.jpg",
		// "G:/Desktop/otsuDemo/suanfa/jooper3.jpg");
		compare("G:/Desktop/otsuDemo/suanfa/nutsBoltscopy0_hist.png",
				"G:/Desktop/otsuDemo/suanfa/jooper3_gray_hist.png");// 0.71121097
		// compare("G:/Desktop/otsuDemo/suanfa/jooper_gray_hist.png",
		// "G:/Desktop/otsuDemo/suanfa/jooper2_gray_hist.png");// 0.98898435
	}

	public static void compare(String path1, String path2) {

		int[] first, second;

		first = GetPixel.getImagePixel(path1);
		second = GetPixel.getImagePixel(path2);

		if (null == first || null == second) {

			System.out.println("有空值：" + first + " -  " + second);
			return;
		}
		if (first.length != second.length) {

			System.out
					.println("长度不一致：" + first.length + " -  " + second.length);
			return;
		}
		int diffNum = 0;
		for (int i = 0; i < first.length; i++) {

			// System.out.println("******** " + first[i] + " - " + second[i]);
			if (first[i] != second[i]) {

				diffNum++;
				System.out.println("******** " + first[i] + " - " + second[i]);
			}
		}
		System.out.println("similitary："
				+ (1f - Float.valueOf(diffNum) / Float.valueOf(first.length))
				+ "\n" + "diffNum：" + diffNum + "\n" + "first.length："
				+ first.length);
	}
}