package P7_Util;

public class AddressToLocalCode {
	private static String[] code = { "����", "�λ�", "����", "�뱸", "����", "���", "��õ" ,"����"};

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
