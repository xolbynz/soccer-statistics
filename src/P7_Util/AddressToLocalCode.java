package P7_Util;

public class AddressToLocalCode {
	private static String[] code = { "서울", "부산", "광주", "대구", "대전", "울산", "인천" ,"제주"};

	public static int getLocalCode(String address) {
		int result = -1;

		for (int i = 0; i < code.length; i++) {
			if (address.contains(code[i])) {
				result = i;
				break;
			}
		}

		return result;
	}
}
