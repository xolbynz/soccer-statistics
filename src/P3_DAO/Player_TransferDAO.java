package P3_DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import P0_사용법.OracleURL;
import P4_DTO.PlayerDTO;
import P4_DTO.Player_TransferDTO;

public class Player_TransferDAO {
	private String sql;
	private int cnt;
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	private void con() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = OracleURL.url;
			String user = OracleURL.id;
			String password = OracleURL.pw;


			this.conn = DriverManager.getConnection(url, user, password);

			if (this.conn != null) {
				System.out.print("연결성공->");
			} else {
				System.out.println("연결실패->");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void close() {
		try {
			if (rs != null) {
				rs.close();
				System.out.print("rs해제->");
			}
			if (pst != null) {
				pst.close();
				System.out.print("pst해제->");
			}
			if (conn != null) {
				conn.close();
				System.out.print("conn해제->");
			}
			System.out.println("클로즈끝");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 신청
	public int transferJoin(Player_TransferDTO dto) {
		con();

		sql = "insert into PLAYER_TRANSFER(Player_Transfer_Code, Player_Code, Now_Group_Code, Transfer_Group_Code, Player_Transfer_State) VALUES (PLAYER_TRANSFER_SEQUENCE.nextval, ?, ?, ?, 0)";

		try {
			pst = conn.prepareStatement(sql);

			pst.setInt(1, dto.getPlayer_Code());
			pst.setInt(2, dto.getNow_Group_Code());
			pst.setInt(3, dto.getTransfer_Group_Code());

			cnt = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		close();

		return cnt;
	}

	// 수락
	public int transferOk(int Player_Code, int Group_Code) {
		con();

		try {
			sql = "update PLAYER_TRANSFER set PLAYER_TRANSFER_STATE = 1 where PLAYER_CODE = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, Player_Code);
			cnt = pst.executeUpdate();

			if (cnt == 0) {
				return cnt;
			} else {
				close();
				con();
			}

			sql = "UPDATE PLAYER SET GROUP_CODE = ? WHERE PLAYER_CODE = ?";
			pst = conn.prepareStatement(sql);

			pst.setInt(1, Group_Code);
			pst.setInt(2, Player_Code);

			cnt = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		close();
		return cnt;
	}

	// 거부
	public int transferX(int Player_Code, int Group_Code) {
		con();

		try {
			sql = "update PLAYER_TRANSFER set PLAYER_TRANSFER_STATE = 1 where PLAYER_CODE = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, Player_Code);
			cnt = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		close();
		return cnt;
	}

	// 이적 신청 대기중 선수목록
	public ArrayList<PlayerDTO> transferTo(int GROUP_CODE) {
		con();

		ArrayList<PlayerDTO> list = new ArrayList<PlayerDTO>();

		try {
			sql = "select * from PLAYER where PLAYER_CODE = (select PLAYER_CODE from PLAYER_TRANSFER where NOW_GROUP_CODE = ? and PLAYER_TRANSFER_STATE = 0)";

			pst = conn.prepareStatement(sql);
			pst.setInt(1, GROUP_CODE);

			rs = pst.executeQuery();

			while (rs.next()) {
				list.add(new PlayerDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getBytes(5),
						rs.getString(6), rs.getInt(7), rs.getString(8)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		close();
		return list;
	}

	// 이적 수락 대기중 선수목록
	public ArrayList<PlayerDTO> transferFrome(int GROUP_CODE) {
		con();

		ArrayList<PlayerDTO> list = new ArrayList<PlayerDTO>();

		try {
			sql = "select * from PLAYER where PLAYER_CODE = (select PLAYER_CODE from PLAYER_TRANSFER where TRANSFER_GROUP_CODE = ? and PLAYER_TRANSFER_STATE = 0)";

			pst = conn.prepareStatement(sql);
			pst.setInt(1, GROUP_CODE);

			rs = pst.executeQuery();

			while (rs.next()) {
				list.add(new PlayerDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getBytes(5),
						rs.getString(6), rs.getInt(7), rs.getString(8)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		close();
		return list;
	}

}
