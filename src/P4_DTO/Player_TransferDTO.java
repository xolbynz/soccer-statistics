package P4_DTO;

public class Player_TransferDTO {
	private int Player_Transfer_Code;
	private int Player_Code;
	private int Now_Group_Code;
	private int Transfer_Group_Code;
	private int Player_Transfer_State;

	public Player_TransferDTO(int player_Transfer_Code, int player_Code, int now_Group_Code, int transfer_Group_Code,
			int player_Transfer_State) {
		super();
		Player_Transfer_Code = player_Transfer_Code;
		Player_Code = player_Code;
		Now_Group_Code = now_Group_Code;
		Transfer_Group_Code = transfer_Group_Code;
		Player_Transfer_State = player_Transfer_State;
	}

	public Player_TransferDTO() {

	}

	public int getPlayer_Transfer_Code() {
		return Player_Transfer_Code;
	}

	public void setPlayer_Transfer_Code(int player_Transfer_Code) {
		Player_Transfer_Code = player_Transfer_Code;
	}

	public int getPlayer_Code() {
		return Player_Code;
	}

	public void setPlayer_Code(int player_Code) {
		Player_Code = player_Code;
	}

	public int getNow_Group_Code() {
		return Now_Group_Code;
	}

	public void setNow_Group_Code(int now_Group_Code) {
		Now_Group_Code = now_Group_Code;
	}

	public int getTransfer_Group_Code() {
		return Transfer_Group_Code;
	}

	public void setTransfer_Group_Code(int transfer_Group_Code) {
		Transfer_Group_Code = transfer_Group_Code;
	}

	public int getPlayer_Transfer_State() {
		return Player_Transfer_State;
	}

	public void setPlayer_Transfer_State(int player_Transfer_State) {
		Player_Transfer_State = player_Transfer_State;
	}

	@Override
	public String toString() {
		return "Player_TransferDTO [Player_Transfer_Code=" + Player_Transfer_Code + ", Now_Group_Code=" + Now_Group_Code
				+ ", Transfer_Group_Code=" + Transfer_Group_Code + ", Player_Transfer_State=" + Player_Transfer_State
				+ "]";
	}

}
