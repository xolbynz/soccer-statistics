package P7_Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class passwordCheck {
	public static boolean checkPw(String inputPw) {

		if (inputPw == null || inputPw.equals(""))
			return true;// �ΰ��϶�
		if (inputPw.length() > 16)
			return true;//16�̻��϶�
		if (inputPw.length() < 8)
			return true;//8�����϶�

		return false;
	}
}
