package P7_Util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;

import javax.imageio.ImageIO;
/**
 * 
 * @author	: 오대근
 * @date	: 2019. 5. 15.
 * @time	: 오후 9:30:50
 * @content	: DB에서 받아온 이미지 정보를 다시 이미지로 구성하는 기능
 *
 */
public class ByteToImg {
	public static BufferedImage getImg(byte[] imageByte) {
		ByteArrayInputStream inputStream = null;
		BufferedImage bufferedImage = null;

		try {
			inputStream = new ByteArrayInputStream(imageByte);
			bufferedImage = ImageIO.read(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bufferedImage;
	}
}
