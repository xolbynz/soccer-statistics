package P4_DTO;

public class Player_FootballDTO {
	private int Player_Football_Code;
	private int Player_Code;
	private int Group_Code;
	private int Player_Football_Speed;
	private int Player_Football_Shoot;
	private int Player_Football_Pass;
	private int Player_Football_Dribol;
	private int Player_Football_Defense;

	public Player_FootballDTO(int player_Football_Code, int player_Code, int group_Code, int player_Football_Speed,
			int player_Football_Shoot, int player_Football_Pass, int player_Football_Dribol,
			int player_Football_Defense) {
		Player_Football_Code = player_Football_Code;
		Player_Code = player_Code;
		Group_Code = group_Code;
		Player_Football_Speed = player_Football_Speed;
		Player_Football_Shoot = player_Football_Shoot;
		Player_Football_Pass = player_Football_Pass;
		Player_Football_Dribol = player_Football_Dribol;
		Player_Football_Defense = player_Football_Defense;

	}

	public int getPlayer_Football_Code() {
		return Player_Football_Code;
	}

	public void setPlayer_Football_Code(int player_Football_Code) {
		Player_Football_Code = player_Football_Code;
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

	public int getPlayer_Football_Speed() {
		return Player_Football_Speed;
	}

	public void setPlayer_Football_Speed(int player_Football_Speed) {
		Player_Football_Speed = player_Football_Speed;
	}

	public int getPlayer_Football_Shoot() {
		return Player_Football_Shoot;
	}

	public void setPlayer_Football_Shoot(int player_Football_Shoot) {
		Player_Football_Shoot = player_Football_Shoot;
	}

	public int getPlayer_Football_Pass() {
		return Player_Football_Pass;
	}

	public void setPlayer_Football_Pass(int player_Football_Pass) {
		Player_Football_Pass = player_Football_Pass;
	}

	public int getPlayer_Football_Dribol() {
		return Player_Football_Dribol;
	}

	public void setPlayer_Football_Dribol(int player_Football_Dribol) {
		Player_Football_Dribol = player_Football_Dribol;
	}

	public int getPlayer_Football_Defense() {
		return Player_Football_Defense;
	}

	public void setPlayer_Football_Defense(int player_Football_Defense) {
		Player_Football_Defense = player_Football_Defense;
	}
	
	
	
	
	
	
	
	
	
	
	

}
