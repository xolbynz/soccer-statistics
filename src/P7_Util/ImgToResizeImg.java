package P7_Util;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 * 
 * @author : 오대근
 * @date : 2019. 5. 15.
 * @time : 오후 9:36:05
 * @content : 이미지의 사이즈를 조정해야할 때 씀(주로 프로필 이미지) ByteToImg.getImg를 통해 받아온 값과 원하는
 *          높이와 넓이를 입력하면 리턴됨
 *
 */

public class ImgToResizeImg {
	public static BufferedImage getResizeImg(BufferedImage img, int height, int width) {

		Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = resized.createGraphics();

		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();

		return resized;
	}
}
