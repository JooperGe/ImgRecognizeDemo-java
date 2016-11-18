package img;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;

import javax.imageio.ImageIO;

/**
 * 获取某张图片各点的像素值
 *
 * @author Jooper
 * @2016年11月15日 下午5:54:34
 */
public class GetPixel {

	public static void main(String[] args) {

		getImagePixel("G:/Desktop/otsuDemo/suanfa/jooper3_gray.jpg");
	}

	/**
	 * 读取一张图片的RGB值
	 * 
	 * @throws Exception
	 */
	public static int[] getImagePixel(String path) {

		int[] nImageData = null;

		try {
			int[] rgb = new int[3];
			File file = new File(path);
			BufferedImage bi = null;
			try {
				bi = ImageIO.read(file);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Raster ra = bi.getRaster();
			Rectangle rect = ra.getBounds();
			int nWidth = ra.getMinX();
			nImageData = new int[rect.height * rect.width];
			int nTemp[] = new int[rect.height * rect.width];

			nImageData = ra.getPixels(0, 0, rect.width, rect.height, nTemp);
			// int width = bi.getWidth();
			// int height = bi.getHeight();
			// int minx = bi.getMinX();
			// int miny = bi.getMinY();
			//
			// result = new int[width * height];
			//
			// for (int i = minx; i < width; i++) {
			// for (int j = miny; j < height; j++) {
			// int pixel = bi.getRGB(i, j); // 下面三行代码将一个数字转换为RGB数字
			// // rgb[0] = (pixel & 0xff0000) >> 16;
			// // rgb[1] = (pixel & 0xff00) >> 8;
			// // rgb[2] = (pixel & 0xff);
			// // System.out.println("i=" + i + ",j=" + j + ":(" + rgb[0] +
			// // ","
			// // + rgb[1] + "," + rgb[2] + ")");
			// System.out.println("pixel：" + pixel);
			//
			// result[(j + i * j)] = pixel;
			// }
			// }
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			return nImageData;
		}
	}
}