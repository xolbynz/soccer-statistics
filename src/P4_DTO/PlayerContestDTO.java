package P4_DTO;

public class PlayerContestDTO {
	private int Player_Contest_Code;
	private int Player_Code;
	private int Group_Code;
	private String Player_Contest_Title;
	private String Player_Contest_Content;
	private String Player_Contest_Result;
	private int Player_Contest_Shot;
	private int Player_Contest_EffectiveShot;
	private int Player_Contest_Goal;
	private int Player_Contest_Assist;
	private int Player_Contest_RunningTime;
	public PlayerContestDTO(int player_Contest_Code, int player_Code, int group_Code, String player_Contest_Title,
			String player_Contest_Content, String player_Contest_Result, int player_Contest_Shot,
			int player_Contest_EffectiveShot, int player_Contest_Goal, int player_Contest_Assist,
			int player_Contest_RunningTime) {
		super();
		Player_Contest_Code = player_Contest_Code;
		Player_Code = player_Code;
		Group_Code = group_Code;
		Player_Contest_Title = player_Contest_Title;
		Player_Contest_Content = player_Contest_Content;
		Player_Contest_Result = player_Contest_Result;
		Player_Contest_Shot = player_Contest_Shot;
		Player_Contest_EffectiveShot = player_Contest_EffectiveShot;
		Player_Contest_Goal = player_Contest_Goal;
		Player_Contest_Assist = player_Contest_Assist;
		Player_Contest_RunningTime = player_Contest_RunningTime;
	}
	public int getPlayer_Contest_Code() {
		return Player_Contest_Code;
	}
	public void setPlayer_Contest_Code(int player_Contest_Code) {
		Player_Contest_Code = player_Contest_Code;
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
	public String getPlayer_Contest_Title() {
		return Player_Contest_Title;
	}
	public void setPlayer_Contest_Title(String player_Contest_Title) {
		Player_Contest_Title = player_Contest_Title;
	}
	public String getPlayer_Contest_Content() {
		return Player_Contest_Content;
	}
	public void setPlayer_Contest_Content(String player_Contest_Content) {
		Player_Contest_Content = player_Contest_Content;
	}
	public String getPlayer_Contest_Result() {
		return Player_Contest_Result;
	}
	public void setPlayer_Contest_Result(String player_Contest_Result) {
		Player_Contest_Result = player_Contest_Result;
	}
	public int getPlayer_Contest_Shot() {
		return Player_Contest_Shot;
	}
	public void setPlayer_Contest_Shot(int player_Contest_Shot) {
		Player_Contest_Shot = player_Contest_Shot;
	}
	public int getPlayer_Contest_EffectiveShot() {
		return Player_Contest_EffectiveShot;
	}
	public void setPlayer_Contest_EffectiveShot(int player_Contest_EffectiveShot) {
		Player_Contest_EffectiveShot = player_Contest_EffectiveShot;
	}
	public int getPlayer_Contest_Goal() {
		return Player_Contest_Goal;
	}
	public void setPlayer_Contest_Goal(int player_Contest_Goal) {
		Player_Contest_Goal = player_Contest_Goal;
	}
	public int getPlayer_Contest_Assist() {
		return Player_Contest_Assist;
	}
	public void setPlayer_Contest_Assist(int player_Contest_Assist) {
		Player_Contest_Assist = player_Contest_Assist;
	}
	public int getPlayer_Contest_RunningTime() {
		return Player_Contest_RunningTime;
	}
	public void setPlayer_Contest_RunningTime(int player_Contest_RunningTime) {
		Player_Contest_RunningTime = player_Contest_RunningTime;
	}
	@Override
	public String toString() {
		return "PlayerContestDTO [Player_Contest_Code=" + Player_Contest_Code + ", Player_Code=" + Player_Code
				+ ", Group_Code=" + Group_Code + ", Player_Contest_Title=" + Player_Contest_Title
				+ ", Player_Contest_Content=" + Player_Contest_Content + ", Player_Contest_Result="
				+ Player_Contest_Result + ", Player_Contest_Shot=" + Player_Contest_Shot
				+ ", Player_Contest_EffectiveShot=" + Player_Contest_EffectiveShot + ", Player_Contest_Goal="
				+ Player_Contest_Goal + ", Player_Contest_Assist=" + Player_Contest_Assist
				+ ", Player_Contest_RunningTime=" + Player_Contest_RunningTime + "]";
	}

	
	
}