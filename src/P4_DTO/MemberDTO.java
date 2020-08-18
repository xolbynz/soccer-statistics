package P4_DTO;

import java.util.Arrays;

import P7_Util.ImgToByte;

public class MemberDTO {
	private String Member_Email;
	private int Group_Code;
	private String Member_Nickname;
	private String Member_Pw;
	private String Member_Tel;
	private int Member_LocalCode;
	private String Member_Address;
	private String Member_Img;
	private byte[] Member_Img_bytes;
	private int View_Power;

	public MemberDTO(String member_Email, int group_Code, String member_Nickname, String member_Pw, String member_Tel,
			String member_Address, int member_LocalCode, int view_Power, String member_Img, byte[] member_Img_bytes) {
		super();
		Member_Email = member_Email;
		Group_Code = group_Code;
		Member_Nickname = member_Nickname;
		Member_Pw = member_Pw;
		Member_Tel = member_Tel;
		Member_Address = member_Address;
		Member_LocalCode = member_LocalCode;
		View_Power = view_Power;
		Member_Img = member_Img;
		Member_Img_bytes = member_Img_bytes;
	}

	public MemberDTO() {
		// TODO Auto-generated constructor stub
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
		return Member_Pw;
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

	public String getMember_Address() {
		return Member_Address;
	}

	public void setMember_Address(String member_Address) {
		Member_Address = member_Address;
	}

	public int getMember_LocalCode() {
		return Member_LocalCode;
	}

	public void setMember_LocalCode(int member_LocalCode) {
		Member_LocalCode = member_LocalCode;
	}

	public int getView_Power() {
		return View_Power;
	}

	public void setView_Power(int view_Power) {
		View_Power = view_Power;
	}

	public byte[] getMember_Img() {
		if (Member_Img != null) {
			Member_Img_bytes = ImgToByte.getByte(Member_Img);
		}
		return Member_Img_bytes ;
	}

	public void setMember_Img(String member_Img) {
		Member_Img = member_Img;
	}

	public byte[] getMember_Img_bytes() {
		return Member_Img_bytes;
	}

	public void setMember_Img_bytes(byte[] member_Img_bytes) {
		Member_Img_bytes = member_Img_bytes;
	}

	@Override
	public String toString() {
		return "MemberDTO [Member_Email=" + Member_Email + ", Group_Code=" + Group_Code + ", Member_Nickname="
				+ Member_Nickname + ", Member_Pw=" + Member_Pw + ", Member_Tel=" + Member_Tel + ", Member_Address="
				+ Member_Address + ", Member_LocalCode=" + Member_LocalCode + ", View_Power=" + View_Power
				+ ", Member_Img=" + Member_Img + ", Member_Img_bytes=" + Arrays.toString(Member_Img_bytes) + "]";
	}

}
