package P4_DTO;

import java.awt.image.BufferedImage;

import P7_Util.ByteToImg;
import P7_Util.ImgToByte;
import P7_Util.ImgToResizeImg;
import P7_Util.SHA256Salt;

/**
 * 
 * @author : �����
 * @date : 2019. 5. 15.
 * @time : ���� 7:51:50
 * @content : �����ڴ� �� �Ʒ��� ���� 2���� �ϸ�, �ڵ��������� ������� ����, �׸��� ���� �ʴ��� toString�� �����Ұ�,
 *          �� �ʿ信 ���� �߰��� ������ �����Ӱ� �Ұ�
 *
 */
public class SignUpDTO {
	private String Member_Email;
	private int Group_Code;
	private String Member_Nickname;
	private String Member_Pw; // ���� ��й�ȣ
	private String Member_Pw_SHA256; // ��ȣȭ�� ��й�ȣ , getMember_Pw�� setMember_Pw �� �ߺ��Ѱ�
	private String Member_Tel;
	private int Member_LocalCode;
	private String Member_Address;
	private String Member_Img; // dto�� �ִ°� �̹��� ��η�
	private byte[] Member_Img_bytes; // ���°� �̹�� byteȭ ������ db�� �������� ����Ʈȭ�� getMember_Img()�� setMember_Img�� �ڼ��� ����
	private int View_Power;

	public SignUpDTO() {
		// �� �ƹ��͵� �ȵ��͵� ������ �Ǵ� �޼��带 ���� ��
	}

	public SignUpDTO(String member_Email, int group_Code, String member_Nickname, String member_Pw, String member_Tel,
			int member_LocalCode, String member_Address, String member_Img, int view_Power) {
		Member_Email = member_Email;
		Group_Code = group_Code;
		Member_Nickname = member_Nickname;
		Member_Pw = member_Pw;
		Member_Tel = member_Tel;
		Member_LocalCode = member_LocalCode;
		Member_Address = member_Address;
		Member_Img = member_Img;
		View_Power = view_Power;
	}

	public String getMember_Email() {
		return Member_Email;
	}

	public void setMember_Email(String member_Email) {
		Member_Email = member_Email;
	}

	public int getGroup_Code() {
		return Group_Code;
	}

	public void setGroup_Code(int group_Code) {
		Group_Code = group_Code;
	}

	public String getMember_Nickname() {
		return Member_Nickname;
	}

	public void setMember_Nickname(String member_Nickname) {
		Member_Nickname = member_Nickname;
	}

	public String getMember_Pw() {
		Member_Pw_SHA256 = SHA256Salt.getChangeHash(Member_Pw); // Ŭ���� �������� ����� �� �ִ� �ش� �޼��尡 static�̿���, P7_Util�� ����
		return Member_Pw_SHA256;
	}

	public void setMember_Pw(String member_Pw) {
		Member_Pw = member_Pw;
	}

	public String getMember_Tel() {
		return Member_Tel;
	}

	public void setMember_Tel(String member_Tel) {
		Member_Tel = member_Tel;
	}

	public int getMember_LocalCode() {
		return Member_LocalCode;
	}

	public void setMember_LocalCode(int member_LocalCode) {
		Member_LocalCode = member_LocalCode;
	}

	public String getMember_Address() {
		return Member_Address;
	}

	public void setMember_Address(String member_Address) {
		Member_Address = member_Address;
	}

	public byte[] getMember_Img() { // DB�� �����ϱ� ���� �̹��� ��θ� �޾Ƽ� ��ο� �̹��� ������ byte�迭�� ��ȯ
		if (Member_Img != null) {
			Member_Img_bytes = ImgToByte.getByte(Member_Img); // Ŭ���� �������� ����� �� �ִ� �ش� �޼��尡 static�̿���, P7_Util�� ����
		}
		return Member_Img_bytes;
	}

	public void setMember_Img(String member_Img) {
		Member_Img = member_Img;
	}

	public BufferedImage getMember_Img_bytes() { // DB���� byte�� ����� �̹����� �ҷ��ͼ� ���̺� ����� �� �ְ� ��ȯ
		if (Member_Img_bytes != null) {
			BufferedImage img = ByteToImg.getImg(Member_Img_bytes);
			return img;
		}
		return null;
	}

	public BufferedImage getMember_ResizeImg(int height, int width) { // getMember_Img_bytes�� ���������� ����� �����ϴ� ����� ����
		if (Member_Img_bytes != null) {
			BufferedImage img = ImgToResizeImg.getResizeImg(ByteToImg.getImg(Member_Img_bytes), height, width);
			return img;
		}
		return null;
	}

	public void setMember_Img_bytes(byte[] member_Img_bytes) { // DB���� �̹��� �����͸� �������� �� �� �޼ҵ带 ����ؾ���
		Member_Img_bytes = member_Img_bytes;
	}

	public int getView_Power() {
		return View_Power;
	}

	public void setView_Power(int view_Power) {
		View_Power = view_Power;
	}

	@Override
	public String toString() {
		return "SignUpDTO [Member_Email=" + Member_Email + ", Group_Code=" + Group_Code + ", Member_Nickname="
				+ Member_Nickname + ", Member_Pw=" + Member_Pw + ", Member_Tel=" + Member_Tel + ", Member_LocalCode="
				+ Member_LocalCode + ", Member_Address=" + Member_Address + ", Member_Img=" + Member_Img
				+ ", View_Power=" + View_Power + "]";
	}

}
