package P7_Util;

import java.security.MessageDigest;
/**
 * 
 * @author	: �����
 * @date	: 2019. 5. 9.
 * @time	: ���� 2:15:22
 * @content	: �⺻ SHA256 ��ȯŸ��
 *
 */
public class SHA256 {
	private static String SALT = ""; // �ұݰ� (�⺻���� ����)

	public static String getChangeHash(String before) {
		StringBuffer after = new StringBuffer(); // ����� ���� ��Ƽ� ������ ��, StringBuffer�� ����ϴ� ������ �Ʒ��� ����

		before += SALT; // ���κ��� ���̺� ���� ��� ���� ��Ʈ�� ��ϴ�. 

		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256"); // SHA-256�� ��ȯ�غ�

			md.update(before.getBytes()); // ��ȯ �� before�� ������ bytesȭ �Ͽ� ������Ʈ(md��ü�� ������ ����Ʈ ���·� ��ǲ �ƿ�ǲ �Ѵ�.)

			byte bytes[] = md.digest(); // ��ȯ �� ���� ����Ʈ�� ������(�ƿ�ǲ�� ����Ʈ�̱� ������)

			for (int i = 0; i < bytes.length; i++) {
				after.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1)); // ����Ʈ Ÿ������ ������ �Ǿ��� ������ ����
																							// ���ھ� ��ȯ�Ͽ� StringBuffer��
																							// �־���(append�� ���ھ� �ٿ��ֱ�)
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return after.toString();
	}

	public void setSALT(String sALT) { // �ұݰ� ����
		SALT = sALT;
	}
}
