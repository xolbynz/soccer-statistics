package P4_DTO;

public class PlayerMedicalDTO {
	private int Player_Medical_Code;
	private int Player_Code;
	private int Group_Code;
	private int Player_Medical_Period;
	private String Player_Medical_Title;
	private String Player_Medical_Content;

	@Override
	public String toString() {
		return "PlayerMedicalDTO [Player_Code=" + Player_Code + ", Group_Code=" + Group_Code + ", Player_Medical_Code="
				+ Player_Medical_Code + ", Player_Medical_Period=" + Player_Medical_Period + ", Player_Medical_Title="
				+ Player_Medical_Title + ", Player_Medical_Content=" + Player_Medical_Content + "]";
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

	public int getPlayer_Medical_Code() {
		return Player_Medical_Code;
	}

	public void setPlayer_Medical_Code(int player_Medical_Code) {
		Player_Medical_Code = player_Medical_Code;
	}

	public int getPlayer_Medical_Period() {
		return Player_Medical_Period;
	}

	public void setPlayer_Medical_Period(int player_Medical_Period) {
		Player_Medical_Period = player_Medical_Period;
	}

	public String getPlayer_Medical_Title() {
		return Player_Medical_Title;
	}

	public void setPlayer_Medical_Title(String player_Medical_Title) {
		Player_Medical_Title = player_Medical_Title;
	}

	public String getPlayer_Medical_Content() {
		return Player_Medical_Content;
	}

	public void setPlayer_Medical_Content(String player_Medical_Content) {
		Player_Medical_Content = player_Medical_Content;
	}

	public PlayerMedicalDTO(int player_Medical_Code, int player_Code, int group_Code, int player_Medical_Period,
			String player_Medical_Title, String player_Medical_Content) {
		super();
		Player_Medical_Code = player_Medical_Code;
		Player_Code = player_Code;
		Group_Code = group_Code;
		Player_Medical_Period = player_Medical_Period;
		Player_Medical_Title = player_Medical_Title;
		Player_Medical_Content = player_Medical_Content;
	}

	

}
