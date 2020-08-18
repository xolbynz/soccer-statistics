package P7_Util;

import java.security.MessageDigest;
/**
 * 
 * @author	: 오대근
 * @date	: 2019. 5. 9.
 * @time	: 오후 2:15:22
 * @content	: 기본 SHA256 변환타입
 *
 */
public class SHA256 {
	private static String SALT = ""; // 소금값 (기본값음 없음)

	public static String getChangeHash(String before) {
		StringBuffer after = new StringBuffer(); // 변경된 값을 담아서 리턴할 변, StringBuffer를 사용하는 이유는 아래서 설명

		before += SALT; // 레인보우 테이블 공격 대비를 위한 솔트값 삽니다. 

		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256"); // SHA-256로 변환준비

			md.update(before.getBytes()); // 변환 전 before의 내용을 bytes화 하여 업데이트(md객체가 이유는 바이트 형태로 인풋 아웃풋 한다.)

			byte bytes[] = md.digest(); // 변환 된 값을 바이트로 저장함(아웃풋이 바이트이기 때문에)

			for (int i = 0; i < bytes.length; i++) {
				after.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1)); // 바이트 타입으로 리턴이 되었기 때문에 한자
																							// 한자씩 변환하여 StringBuffer에
																							// 넣어줌(append는 한자씩 붙여넣기)
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return after.toString();
	}

	public void setSALT(String sALT) { // 소금값 설정
		SALT = sALT;
	}
}
