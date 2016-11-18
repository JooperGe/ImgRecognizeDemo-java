//package zhifangtu;
//
//import java.awt.image.BufferedImage;
//
///**
// * 获取图像源直方图数据
// *
// * @author Jooper
// * @2016年11月16日 上午11:27:17
// */
//public class GetHistogram {
//
//	public int greenBins, blueBins;
//
//	public void setGreenBinCount(int greenBinCount) {
//		this.greenBins = greenBinCount;
//	}
//
//	public void setBlueBinCount(int blueBinCount) {
//		this.blueBins = blueBinCount;
//	}
//
//	public float[] filter(BufferedImage src, BufferedImage dest) {
//		int width = src.getWidth();
//		int height = src.getHeight();
//
//		int[] inPixels = new int[width * height];
//		float[] histogramData = new float[redBins * greenBins * blueBins];
//		getRGB(src, 0, 0, width, height, inPixels);
//		int index = 0;
//		int redIdx = 0, greenIdx = 0, blueIdx = 0;
//		int singleIndex = 0;
//		float total = 0;
//		for (int row = 0; row < height; row++) {
//			int ta = 0, tr = 0, tg = 0, tb = 0;
//			for (int col = 0; col < width; col++) {
//				index = row * width + col;
//				ta = (inPixels[index] >> 24) & 0xff;
//				tr = (inPixels[index] >> 16) & 0xff;
//				tg = (inPixels[index] >> 8) & 0xff;
//				tb = inPixels[index] & 0xff;
//				redIdx = (int) getBinIndex(redBins, tr, 255);
//				greenIdx = (int) getBinIndex(greenBins, tg, 255);
//				blueIdx = (int) getBinIndex(blueBins, tb, 255);
//				singleIndex = redIdx + greenIdx * redBins + blueIdx * redBins
//						* greenBins;
//				histogramData[singleIndex] += 1;
//				total += 1;
//			}
//		}
//
//		// start to normalize the histogram data
//		for (int i = 0; i < histogramData.length; i++) {
//			histogramData[i] = histogramData[i] / total;
//		}
//
//		return histogramData;
//	}
//}