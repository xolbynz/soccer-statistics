package P4_DTO;

import java.awt.image.BufferedImage;

import P7_Util.ByteToImg;
import P7_Util.ImgToByte;
import P7_Util.ImgToResizeImg;

public class PlayerDTO {
	private int Player_Code;
	private int Group_Code;
	private String Player_Name;
	private String Player_Tel;
	private String Player_Img;
	private byte[] Player_Img_bytes;
	private String Player_Email;
	private int Player_LocalCode;
	private String Player_Address;

	public PlayerDTO() {

	}

	public PlayerDTO(int player_Code, int group_Code, String player_Name, String player_Tel, String player_Img,
			String player_Email, int player_LocalCode, String player_Address) {
		Player_Code = player_Code;
		Group_Code = group_Code;
		Player_Name = player_Name;
		Player_Tel = player_Tel;
		Player_Img = player_Img;
		Player_Email = player_Email;
		Player_LocalCode = player_LocalCode;
		Player_Address = player_Address;
	}

	public PlayerDTO(int player_Code, int group_Code, String player_Name, String player_Tel, byte[] player_Img_bytes,
			String player_Email, int player_LocalCode, String player_Address) {
		super();
		Player_Code = player_Code;
		Group_Code = group_Code;
		Player_Name = player_Name;
		Player_Tel = player_Tel;
		Player_Img_bytes = player_Img_bytes;
		Player_Email = player_Email;
		Player_LocalCode = player_LocalCode;
		Player_Address = player_Address;
	}

	public int getPlayer_Code() {
		return Player_Code;
	}

	public void setPlayer_Code(int player_Code) {
		Player_Code = player_Code;
	}

	public int getGroup_Code() {
		return Group_Code;
	}

	public void setGroup_Code(int group_Code) {
		Group_Code = group_Code;
	}

	public String getPlayer_Name() {
		return Player_Name;
	}

	public void setPlayer_Name(String player_Name) {
		Player_Name = player_Name;
	}

	public String getPlayer_Tel() {
		return Player_Tel;
	}

	public void setPlayer_Tel(String player_Tel) {
		Player_Tel = player_Tel;
	}

	public byte[] getPlayer_Img() {
		if (Player_Img != null) {
			Player_Img_bytes = ImgToByte.getByte(Player_Img);
		}
		return Player_Img_bytes;
	}

	public void setPlayer_Img(String player_Img) {
		Player_Img = player_Img;
	}

	public BufferedImage getPlayer_Img_Bytes() {
		if (Player_Img_bytes != null) {
			BufferedImage img = ByteToImg.getImg(Player_Img_bytes);
			return img;
		}
		return null;
	}

	public BufferedImage getPlayer_ResizeImg(int height, int width) {
		if (Player_Img_bytes != null) {
			BufferedImage img = ImgToResizeImg.getResizeImg(ByteToImg.getImg(Player_Img_bytes), height, width);
			return img;
		}
		return null;
	}

	public void setPlayer_Img_Bytes(byte[] Player_Img_bytes) {
		this.Player_Img_bytes = Player_Img_bytes;
	}

	public String getPlayer_Email() {
		return Player_Email;
	}

	public void setPlayer_Email(String player_Email) {
		Player_Email = player_Email;
	}

	public int getPlayer_LocalCode() {
		return Player_LocalCode;
	}

	public void setPlayer_LocalCode(int player_LocalCode) {
		Player_LocalCode = player_LocalCode;
	}

	public String getPlayer_Address() {
		return Player_Address;
	}

	public void setPlayer_Address(String player_Address) {
		Player_Address = player_Address;
	}

	@Override
	public String toString() {
		return "PlayerDTO [Player_Code=" + Player_Code + ", Group_Code=" + Group_Code + ", Player_Name=" + Player_Name
				+ ", Player_Tel=" + Player_Tel + ", Player_Img=" + Player_Img + ", Player_Email=" + Player_Email
				+ ", Player_LocalCode=" + Player_LocalCode + ", Player_Address=" + Player_Address + "]";
	}

}
