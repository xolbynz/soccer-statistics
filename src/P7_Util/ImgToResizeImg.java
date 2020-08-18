package P7_Util;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 * 
 * @author : �����
 * @date : 2019. 5. 15.
 * @time : ���� 9:36:05
 * @content : �̹����� ����� �����ؾ��� �� ��(�ַ� ������ �̹���) ByteToImg.getImg�� ���� �޾ƿ� ���� ���ϴ�
 *          ���̿� ���̸� �Է��ϸ� ���ϵ�
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
