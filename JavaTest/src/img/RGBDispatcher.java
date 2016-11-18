package img;

import java.util.ArrayList;

/**
 * 分离图片源的像素
 * 
 * 得到的像素数组中，key为0的表示黑色，其中0越少代表图像源中有某一种颜色占有绝大部分的面积
 *
 * @author Jooper
 * @2016年11月15日 下午6:54:53
 */
public class RGBDispatcher {

	public static void main(String[] args) {

		// dispatch("G:/Desktop/otsuDemo/suanfa/nutsBoltscopy0_hist.png");
		// dispatch("G:/Desktop/otsuDemo/suanfa/jooper2_gray_hist.png");
		// dispatch("G:/Desktop/otsuDemo/suanfa/jooper_gray_hist.png");
		dispatch("G:/Desktop/otsuDemo/suanfa/th_gray_hist.png");
	}

	public static void dispatch(String path) {

		int[] first;

		first = GetPixel.getImagePixel(path);

		long num = 0;
		ArrayList<Long> list = new ArrayList<Long>();
		for (int i = 0; i < first.length; i++) {

			num = first[i];
			if (i == 0) {

				list.add(Long.valueOf(first[i]));
			}
			if (i != 0 && !list.contains(num)) {

				list.add(num);
			}
		}

		for (int i = 0; i < list.size(); i++) {

			int num1 = 0;
			for (int j = 0; j < first.length; j++) {

				if (Math.abs(Long.valueOf(first[j])) == Math.abs(list.get(i))) {

					num1++;
				}
			}
			System.out.println("dispatch：" + list.get(i) + " - " + num1);
			// System.out.println("dispatch：" + list.get(i) + " - ");
		}
		System.out.println("dispatch total：" + first.length);
	}
}