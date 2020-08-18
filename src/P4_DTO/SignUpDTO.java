package P4_DTO;

import java.awt.image.BufferedImage;

import P7_Util.ByteToImg;
import P7_Util.ImgToByte;
import P7_Util.ImgToResizeImg;
import P7_Util.SHA256Salt;

/**
 * 
 * @author : 오대근
 * @date : 2019. 5. 15.
 * @time : 오후 7:51:50
 * @content : 생성자는 꼭 아래와 같이 2개로 하며, 자동생성으로 만들것을 권장, 그리고 쓰지 않더라도 toString도 정의할것,
 *          단 필요에 따라서 추가나 수정은 자유롭게 할것
 *
 */
public class SignUpDTO {
	private String Member_Email;
	private int Group_Code;
	private String Member_Nickname;
	private String Member_Pw; // 원래 비밀번호
	private String Member_Pw_SHA256; // 암호화된 비밀번호 , getMember_Pw와 setMember_Pw 꼭 잘봐둘것
	private String Member_Tel;
	private int Member_LocalCode;
	private String Member_Address;
	private String Member_Img; // dto에 넣는건 이미지 경로로
	private byte[] Member_Img_bytes; // 빼는건 이미즈를 byte화 이유는 db에 넣으려면 바이트화함 getMember_Img()과 setMember_Img을 자세히 볼것
	private int View_Power;

	public SignUpDTO() {
		// 꼭 아무것도 안들어와도 생성이 되는 메서드를 만들 것
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
		Member_Pw_SHA256 = SHA256Salt.getChangeHash(Member_Pw); // 클래스 생성없이 사용할 수 있는 해당 메서드가 static이여서, P7_Util에 있음
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

	public byte[] getMember_Img() { // DB로 저장하기 위해 이미지 경로를 받아서 경로에 이미지 파일을 byte배열로 변환
		if (Member_Img != null) {
			Member_Img_bytes = ImgToByte.getByte(Member_Img); // 클래스 생성없이 사용할 수 있는 해당 메서드가 static이여서, P7_Util에 있음
		}
		return Member_Img_bytes;
	}

	public void setMember_Img(String member_Img) {
		Member_Img = member_Img;
	}

	public BufferedImage getMember_Img_bytes() { // DB에서 byte로 저장된 이미지를 불러와서 레이블에 사용할 수 있게 변환
		if (Member_Img_bytes != null) {
			BufferedImage img = ByteToImg.getImg(Member_Img_bytes);
			return img;
		}
		return null;
	}

	public BufferedImage getMember_ResizeImg(int height, int width) { // getMember_Img_bytes와 동일하지만 사이즈를 조정하는 기능이 있음
		if (Member_Img_bytes != null) {
			BufferedImage img = ImgToResizeImg.getResizeImg(ByteToImg.getImg(Member_Img_bytes), height, width);
			return img;
		}
		return null;
	}

	public void setMember_Img_bytes(byte[] member_Img_bytes) { // DB에서 이미지 데이터를 받을때는 꼭 이 메소드를 사용해야함
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
