package P4_DTO;

public class listAllDTO {
	private int Player_Code;
	private String Player_Name;
	private int Player_Football_Speed;
	private int Player_Football_Shoot;
	private int Player_Football_Pass;
	private int Player_Football_Dribol;
	private int Player_Football_Defense;
	private int Player_Physical_Sex;
	private int Player_Physical_Age;
	private int Player_Physical_Height;
	private int Player_Physical_Weight;
	private int Player_Physical_LeftFoot;
	private int Player_Physical_RightFoot;

	public listAllDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public listAllDTO(int player_Code, String player_Name, int player_Football_Speed, int player_Football_Shoot,
			int player_Football_Pass, int player_Football_Dribol, int player_Football_Defense, int player_Physical_Sex,
			int player_Physical_Age, int player_Physical_Height, int player_Physical_Weight,
			int player_Physical_LeftFoot, int player_Physical_RightFoot) {
		super();
		Player_Code = player_Code;
		Player_Name = player_Name;
		Player_Football_Speed = player_Football_Speed;
		Player_Football_Shoot = player_Football_Shoot;
		Player_Football_Pass = player_Football_Pass;
		Player_Football_Dribol = player_Football_Dribol;
		Player_Football_Defense = player_Football_Defense;
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

	public String getPlayer_Name() {
		return Player_Name;
	}

	public void setPlayer_Name(String player_Name) {
		Player_Name = player_Name;
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

	public String getPlayer_Physical_Sex() {
		if (Player_Physical_Sex == 0)
			return "남자";
		else
			return "여자";
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
		return "listAllDTO [Player_Code=" + Player_Code + ", Player_Football_Speed=" + Player_Football_Speed
				+ ", Player_Football_Shoot=" + Player_Football_Shoot + ", Player_Football_Pass=" + Player_Football_Pass
				+ ", Player_Football_Dribol=" + Player_Football_Dribol + ", Player_Football_Defense="
				+ Player_Football_Defense + ", Player_Physical_Sex=" + Player_Physical_Sex + ", Player_Physical_Age="
				+ Player_Physical_Age + ", Player_Physical_Height=" + Player_Physical_Height
				+ ", Player_Physical_Weight=" + Player_Physical_Weight + ", Player_Physical_LeftFoot="
				+ Player_Physical_LeftFoot + ", Player_Physical_RightFoot=" + Player_Physical_RightFoot + "]";
	}

}
