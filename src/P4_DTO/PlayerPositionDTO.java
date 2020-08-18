package P4_DTO;

public class PlayerPositionDTO {
	private int Player_Position_Code;
	private int Player_Code;
	private int Group_Code;
	private String Player_Position_Name;

	public PlayerPositionDTO(int player_Position_Code, int player_Code, int group_Code, String player_Position_Name) {
		super();
		Player_Position_Code = player_Position_Code;
		Player_Code = player_Code;
		Group_Code = group_Code;
		Player_Position_Name = player_Position_Name;
	}

	public int getPlayer_Position_Code() {
		return Player_Position_Code;
	}

	public void setPlayer_Position_Code(int player_Position_Code) {
		Player_Position_Code = player_Position_Code;
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

	public String getPlayer_Position_Name() {
		if (Player_Position_Name.equals("0")) {
			return "포지션 없음";
		}
		return Player_Position_Name;
	}

	public void setPlayer_Position_Name(String player_Position_Name) {
		if (player_Position_Name.equals("0")) {
			Player_Position_Name = "포지션 없음";
		} else {
			Player_Position_Name = player_Position_Name;
		}
	}

	@Override
	public String toString() {
		return "PlyaerPositionDTO [Player_Position_Code=" + Player_Position_Code + ", Player_Code=" + Player_Code
				+ ", Group_Code=" + Group_Code + ", Player_Position_Name=" + Player_Position_Name + "]";
	}

}
