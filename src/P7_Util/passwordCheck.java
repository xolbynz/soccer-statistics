package P7_Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class passwordCheck {
	public static boolean checkPw(String inputPw) {

		if (inputPw == null || inputPw.equals(""))
			return true;// 널값일때
		if (inputPw.length() > 16)
			return true;//16이상일때
		if (inputPw.length() < 8)
			return true;//8이하일때

		return false;
	}
}
