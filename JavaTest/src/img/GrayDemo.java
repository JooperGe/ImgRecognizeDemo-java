package img;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 生成灰度图像
 *
 * @author Jooper
 * @2016年11月14日 下午6:24:43
 */
public class GrayDemo {

	private final static String imgPath = "G:/Desktop/otsuDemo/suanfa/white/blackreverse.jpg";
	private final static String imgPath_gray = "G:/Desktop/otsuDemo/suanfa/white/blackreverse_gray.jpg";

	private static int colorToRGB(int alpha, int red, int green, int blue) {

		int newPixel = 0;
		newPixel += alpha;
		newPixel = newPixel << 8;
		newPixel += red;
		newPixel = newPixel << 8;
		newPixel += green;
		newPixel = newPixel << 8;
		newPixel += blue;

		return newPixel;

	}

	public static void main(String[] args) throws IOException {

		// ------------------method 1 start------------------
		// // BufferedImage bufferedImage = ImageIO.read(new File(System
		// // .getProperty("user.dir" + "/test.jpg")));
		// BufferedImage bufferedImage = ImageIO.read(new File(
		// "G:/Desktop/otsuDemo/suanfa/img2.jpg"));
		// // BufferedImage grayImage = new
		// BufferedImage(bufferedImage.getWidth(),
		// // bufferedImage.getHeight(), bufferedImage.getType());
		// BufferedImage grayImage = new BufferedImage(bufferedImage.getWidth(),
		// bufferedImage.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
		//
		// for (int i = 0; i < bufferedImage.getWidth(); i++) {
		// for (int j = 0; j < bufferedImage.getHeight(); j++) {
		// final int color = bufferedImage.getRGB(i, j);
		//
		// // -----------
		// final int r = (color >> 16) & 0xff;
		// final int g = (color >> 8) & 0xff;
		// final int b = color & 0xff;
		// // -----------
		//
		// int gray = (int) (0.3 * r + 0.59 * g + 0.11 * b);
		// System.out.println(i + " : " + j + " " + gray);
		// int newPixel = colorToRGB(255, gray, gray, gray);
		// // grayImage.setRGB(i, j, newPixel);
		// grayImage.setRGB(i, j, newPixel);
		// }
		// }
		// File newFile = new File("G:/Desktop/otsuDemo/suanfa/img2_gray.jpg");
		// ImageIO.write(grayImage, "jpg", newFile);
		// ------------------method 1 end------------------

		// ------------------method 2 start------------------
		grayImage();
		// ------------------method 2 end------------------
	}

	/**
	 * 效果较差的转换算法
	 * 
	 * @throws IOException
	 * @param
	 * 
	 * @author Jooper
	 * @2016年11月14日 下午6:32:58
	 */
	public static void grayImage() throws IOException {
		File file = new File(imgPath);
		BufferedImage image = ImageIO.read(file);

		int width = image.getWidth();
		int height = image.getHeight();

		BufferedImage grayImage = new BufferedImage(width, height,
				BufferedImage.TYPE_BYTE_GRAY);
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				int rgb = image.getRGB(i, j);
				grayImage.setRGB(i, j, rgb);
			}
		}
		File newFile = new File(imgPath_gray);
		ImageIO.write(grayImage, "jpg", newFile);
	}
}