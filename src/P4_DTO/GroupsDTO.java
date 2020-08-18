package P4_DTO;

import java.awt.image.BufferedImage;

import P7_Util.ByteToImg;
import P7_Util.ImgToByte;
import P7_Util.ImgToResizeImg;

public class GroupsDTO {
	private int Group_Code;
	private String Group_Name;
	private String Group_Tel;
	private String Group_Img;
	private byte[] Group_Img_bytes;
	private int Group_LocalCode;
	private String Group_Address;
	private String Group_HomePage;

	

	public GroupsDTO(int group_Code, String group_Name, String group_Tel, byte[] group_Img_bytes, int group_LocalCode,
			String group_Address, String group_HomePage) {
		super();
		Group_Code = group_Code;
		Group_Name = group_Name;
		Group_Tel = group_Tel;
		Group_Img_bytes = group_Img_bytes;
		Group_LocalCode = group_LocalCode;
		Group_Address = group_Address;
		Group_HomePage = group_HomePage;
	}

	public GroupsDTO(int group_Code, String group_Name, String group_Tel, String group_Img, int group_LocalCode,
			String group_Address, String group_HomePage) {
		Group_Code = group_Code;
		Group_Name = group_Name;
		Group_Tel = group_Tel;
		Group_Img = group_Img;
		Group_LocalCode = group_LocalCode;
		Group_Address = group_Address;
		Group_HomePage = group_HomePage;
	}
	
	public GroupsDTO() {

	}

	public int getGroup_Code() {
		return Group_Code;
	}

	public void setGroup_Code(int group_Code) {
		Group_Code = group_Code;
	}

	public String getGroup_Name() {
		return Group_Name;
	}

	public void setGroup_Name(String group_Name) {
		Group_Name = group_Name;
	}

	public String getGroup_Tel() {
		return Group_Tel;
	}

	public void setGroup_Tel(String group_Tel) {
		Group_Tel = group_Tel;
	}

	public byte[] getGroup_Img() {
		if (Group_Img != null) {
			Group_Img_bytes = ImgToByte.getByte(Group_Img);
		}
		return Group_Img_bytes;
	}

	public void setGroup_Img(String group_Img) {
		Group_Img = group_Img;
	}

	public BufferedImage getGroup_Img_Bytes() {
		if (Group_Img_bytes != null) {
			BufferedImage img = ByteToImg.getImg(Group_Img_bytes);
			return img;
		}
		return null;
	}

	public BufferedImage getGroup_ResizeImg(int height, int width) {
		if (Group_Img_bytes != null) {
			BufferedImage img = ImgToResizeImg.getResizeImg(ByteToImg.getImg(Group_Img_bytes), height, width);
			return img;
		}
		return null;
	}

	public void setGroup_Img_Bytes(byte[] Group_Img_Bytes) {
		this.Group_Img_bytes = Group_Img_Bytes;
	}

	public int getGroup_LocalCode() {
		return Group_LocalCode;
	}

	public void setGroup_LocalCode(int group_LocalCode) {
		Group_LocalCode = group_LocalCode;
	}

	public String getGroup_Address() {
		return Group_Address;
	}

	public void setGroup_Address(String group_Address) {
		Group_Address = group_Address;
	}

	public String getGroup_HomePage() {
		return Group_HomePage;
	}

	public void setGroup_HomePage(String group_HomePage) {
		Group_HomePage = group_HomePage;
	}

	@Override
	public String toString() {
		return "GroupsDTO [Group_Code=" + Group_Code + ", Group_Name=" + Group_Name + ", Group_Tel=" + Group_Tel
				+ ", Group_Img=" + Group_Img + ", Group_LocalCode=" + Group_LocalCode + ", Group_Address="
				+ Group_Address + ", Group_HomePage=" + Group_HomePage + "]";
	}
	
	public void setResult(GroupsDTO dto) {
		setGroup_Code(dto.getGroup_Code());
		setGroup_Name(dto.getGroup_Name());
		setGroup_Tel(dto.getGroup_Tel());
		setGroup_Img_Bytes(dto.getGroup_Img());
		setGroup_LocalCode(dto.getGroup_LocalCode());
		setGroup_Address(dto.getGroup_Address());
		setGroup_HomePage(dto.getGroup_HomePage());
	}

}
