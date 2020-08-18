package P4_DTO;

public class PlayerPhysicalDTO {
	private int Player_Physical_Code;
	private int Player_Code;
	private int Group_Code;
	private int Player_Physical_Sex;
	private int Player_Physical_Age;
	private int Player_Physical_Height;
	private int Player_Physical_Weight;
	private int Player_Physical_LeftFoot;
	private int Player_Physical_RightFoot;
	
	public PlayerPhysicalDTO(int player_Code, int group_Code, int player_Physical_Code, int player_Physical_Sex,
			int player_Physical_Age, int player_Physical_Height, int player_Physical_Weight,
			int player_Physical_LeftFoot, int player_Physical_RightFoot) {
		super();
		Player_Code = player_Code;
		Group_Code = group_Code;
		Player_Physical_Code = player_Physical_Code;
		Player_Physical_Sex = player_Physical_Sex;
		Player_Physical_Age = player_Physical_Age;
		Player_Physical_Height = player_Physical_Height;
		Player_Physical_Weight = player_Physical_Weight;
		Player_Physical_LeftFoot = player_Physical_LeftFoot;
		Player_Physical_RightFoot = player_Physical_RightFoot;
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
	public int getPlayer_Physical_Code() {
		return Player_Physical_Code;
	}
	public void setPlayer_Physical_Code(int player_Physical_Code) {
		Player_Physical_Code = player_Physical_Code;
	}
	public int getPlayer_Physical_Sex() {
		return Player_Physical_Sex;
	}
	public void setPlayer_Physical_Sex(int player_Physical_Sex) {
		Player_Physical_Sex = player_Physical_Sex;
	}
	public int getPlayer_Physical_Age() {
		return Player_Physical_Age;
	}
	public void setPlayer_Physical_Age(int player_Physical_Age) {
		Player_Physical_Age = player_Physical_Age;
	}
	public int getPlayer_Physical_Height() {
		return Player_Physical_Height;
	}
	public void setPlayer_Physical_Height(int player_Physical_Height) {
		Player_Physical_Height = player_Physical_Height;
	}
	public int getPlayer_Physical_Weight() {
		return Player_Physical_Weight;
	}
	public void setPlayer_Physical_Weight(int player_Physical_Weight) {
		Player_Physical_Weight = player_Physical_Weight;
	}
	public int getPlayer_Physical_LeftFoot() {
		return Player_Physical_LeftFoot;
	}
	public void setPlayer_Physical_LeftFoot(int player_Physical_LeftFoot) {
		Player_Physical_LeftFoot = player_Physical_LeftFoot;
	}
	public int getPlayer_Physical_RightFoot() {
		return Player_Physical_RightFoot;
	}
	public void setPlayer_Physical_RightFoot(int player_Physical_RightFoot) {
		Player_Physical_RightFoot = player_Physical_RightFoot;
	}
	@Override
	public String toString() {
		return "PlayerPhysicalDTO [Player_Code=" + Player_Code + ", Group_Code=" + Group_Code
				+ ", Player_Physical_Code=" + Player_Physical_Code + ", Player_Physical_Sex=" + Player_Physical_Sex
				+ ", Player_Physical_Age=" + Player_Physical_Age + ", Player_Physical_Height=" + Player_Physical_Height
				+ ", Player_Physical_Weight=" + Player_Physical_Weight + ", Player_Physical_LeftFoot="
				+ Player_Physical_LeftFoot + ", Player_Physical_RightFoot=" + Player_Physical_RightFoot + "]";
	}

	
}
