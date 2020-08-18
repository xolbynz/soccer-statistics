package P7_Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 
 * @author	: 오대근
 * @date	: 2019. 5. 15.
 * @time	: 오후 9:32:39
 * @content	: 이미지 경로를 받아서, 경로에 있는 이미지를 byte배열로 만들어 주는 기능
 *
 */
public class ImgToByte {
	public static byte[] getByte(String Member_Img) {
		byte[] Member_Img_byte = null;
		InputStream is = null;
		File file = new File(Member_Img);

		try {
			is = new FileInputStream(file);

			int fileSize = (int) file.length();

			Member_Img_byte = new byte[fileSize];

			is.read(Member_Img_byte);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Member_Img_byte;
	}
}
