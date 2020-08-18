package P4_DTO;

public class PlayerTeacherDTO {
	private int Player_Teacher_Code;
	private int Player_Code;
	private int Group_Code;
	private String Player_Teacher_Title;
	private String Player_Teacher_Content;

	public PlayerTeacherDTO(int player_Teacher_Code, int player_Code, int group_Code, String player_Teacher_Title,
			String player_Teacher_Content) {
		super();
		Player_Teacher_Code = player_Teacher_Code;
		Player_Code = player_Code;
		Group_Code = group_Code;
		Player_Teacher_Title = player_Teacher_Title;
		Player_Teacher_Content = player_Teacher_Content;
	}

	public int getPlayer_Teacher_Code() {
		return Player_Teacher_Code;
	}

	public void setPlayer_Teacher_Code(int player_Teacher_Code) {
		Player_Teacher_Code = player_Teacher_Code;
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

	public String getPlayer_Teacher_Title() {
		return Player_Teacher_Title;
	}

	public void setPlayer_Teacher_Title(String player_Teacher_Title) {
		Player_Teacher_Title = player_Teacher_Title;
	}

	public String getPlayer_Teacher_Content() {
		return Player_Teacher_Content;
	}

	public void setPlayer_Teacher_Content(String player_Teacher_Content) {
		Player_Teacher_Content = player_Teacher_Content;
	}

	@Override
	public String toString() {
		return "PlayerTeacherDTO [Player_Teacher_Code=" + Player_Teacher_Code + ", Player_Code=" + Player_Code
				+ ", Group_Code=" + Group_Code + ", Player_Teacher_Title=" + Player_Teacher_Title
				+ ", Player_Teacher_Content=" + Player_Teacher_Content + "]";
	}

}
