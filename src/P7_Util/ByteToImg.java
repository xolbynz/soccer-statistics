package P7_Util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;

import javax.imageio.ImageIO;
/**
 * 
 * @author	: �����
 * @date	: 2019. 5. 15.
 * @time	: ���� 9:30:50
 * @content	: DB���� �޾ƿ� �̹��� ������ �ٽ� �̹����� �����ϴ� ���
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
