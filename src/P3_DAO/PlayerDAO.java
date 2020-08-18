package P3_DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import P0_사용법.OracleURL;
import P4_DTO.PlayerDTO;
import P4_DTO.listAllDTO;

public class PlayerDAO {
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

	public int joinPlayer(PlayerDTO PlayerDTO) { // DTO로 받으면 값을 넣지 않으면 null이기때문에 db에 자동으로 null이 들어감
		con();
		// 정말 끔직하지만 꼭 insert문을 할때는 원래는 생략하였던 컬럼며을 다 기업하여 줄것, 반드시 전체 컬럼의 값을 insert하는 경우는
		// 드물기 때문이다.
		sql = "INSERT ALL "
				+ "INTO player(player_code, Group_code, player_name, player_tel, player_img, player_Email, player_localCode, player_address) VALUES(PLAYER_SEQUENCE.nextval, ?, ?, ?, ?, ?, ?, ?) "
				+ "INTO PLAYER_POSITION(PLAYER_POSITION_CODE, PLAYER_CODE, GROUP_CODE, PLAYER_POSITION_NAME) VALUES(PLAYER_POSITION_SEQUENCE.nextval, PLAYER_SEQUENCE.currval, ?, 0) "
				+ "INTO Player_Football(Player_Football_Code, Player_Code, Group_Code, Player_Football_Speed, Player_Football_Shoot, Player_Football_Pass, Player_Football_Dribol, Player_Football_Defense) VALUES(PLAYER_FOOTBALL_SEQUENCE.nextval, PLAYER_SEQUENCE.currval, ?, 0, 0, 0, 0, 0) "
				+ "INTO PLAYER_PHYSICAL(PLAYER_PHYSICAL_CODE, PLAYER_CODE, GROUP_CODE, PLAYER_PHYSICAL_SEX, PLAYER_PHYSICAL_AGE, PLAYER_PHYSICAL_HEIGHT, PLAYER_PHYSICAL_WEIGHT, PLAYER_PHYSICAL_LEFTFOOT, PLAYER_PHYSICAL_RIGHTFOOT) VALUES(PLAYER_PHYSICAL_SEQUENCE.nextval, PLAYER_SEQUENCE.currval, ?, 0, 0, 0, 0, 0, 0) "
				+ "INTO PLAYER_MEDICAL(PLAYER_MEDICAL_CODE, PLAYER_CODE, GROUP_CODE, PLAYER_MEDICAL_PERIOD, PLAYER_MEDICAL_TITLE, PLAYER_MEDICAL_CONTENT) VALUES(PLAYER_MEDICAL_SEQUENCE.nextval, PLAYER_SEQUENCE.currval, ?, 0, ' ', ' ') "
				+ "INTO PLAYER_CONTEST(PLAYER_CONTEST_CODE, PLAYER_CODE, GROUP_CODE, PLAYER_CONTEST_TITLE, PLAYER_CONTEST_CONTENT, PLAYER_CONTEST_RESULT, PLAYER_CONTEST_SHOT, PLAYER_CONTEST_EFFECTIVESHOT, PLAYER_CONTEST_GOAL, PLAYER_CONTEST_ASSIST, PLAYER_CONTEST_RUNNINGTIME) VALUES(PLAYER_CONTEST_SEQUENCE.nextval, PLAYER_SEQUENCE.currval, ?, ' ', ' ', ' ', 0, 0, 0, 0, 0) "
				+ "SELECT * FROM DUAL";

		try {
			pst = conn.prepareStatement(sql);

			pst.setInt(1, PlayerDTO.getGroup_Code());
			pst.setString(2, PlayerDTO.getPlayer_Name());
			pst.setString(3, PlayerDTO.getPlayer_Tel());
			pst.setBytes(4, PlayerDTO.getPlayer_Img());
			pst.setString(5, PlayerDTO.getPlayer_Email());
			pst.setInt(6, PlayerDTO.getPlayer_LocalCode());
			pst.setString(7, PlayerDTO.getPlayer_Address());
			pst.setInt(8, PlayerDTO.getGroup_Code());
			pst.setInt(9, PlayerDTO.getGroup_Code());
			pst.setInt(10, PlayerDTO.getGroup_Code());
			pst.setInt(11, PlayerDTO.getGroup_Code());
			pst.setInt(12, PlayerDTO.getGroup_Code());

			cnt = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		close();

		return cnt;
	}

	// 라이크~ 키워드 조회
	public ArrayList<PlayerDTO> SearchPlayer(String player_name) {
		con();

		sql = "select * from player where player_name like  '%' || ? || '%' ORDER BY PLAYER_CODE desc";
		ArrayList<PlayerDTO> lplist = new ArrayList<PlayerDTO>();

		try {
			pst = conn.prepareStatement(sql);

			pst.setString(1, player_name);

			rs = pst.executeQuery();

			while (rs.next()) {
				lplist.add(new PlayerDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getBytes(5),
						rs.getString(6), rs.getInt(7), rs.getString(8)));

			}
			close();
			return lplist;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// 이름 조회
	public PlayerDTO SelectPlayer(int player_code) {
		con();

		sql = "select * from Player where Player_Code= ? ORDER BY PLAYER_CODE desc";
		PlayerDTO result = null;

		try {
			pst = conn.prepareStatement(sql);

			pst.setInt(1, player_code);

			rs = pst.executeQuery();

			while (rs.next()) {
				result = new PlayerDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getBytes(5),
						rs.getString(6), rs.getInt(7), rs.getString(8));

			}
			close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	// 전체 조회
	public ArrayList<PlayerDTO> selectallPlayer() {
		con();

		sql = "select * from Player ORDER BY PLAYER_CODE desc";
		ArrayList<PlayerDTO> aplist = new ArrayList<PlayerDTO>();

		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				aplist.add(new PlayerDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getBytes(5),
						rs.getString(6), rs.getInt(7), rs.getString(8)));
			}
			close();
			return aplist;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<PlayerDTO> selectGudanPlayera(int Group_Code) {
		con();
		sql = "select * from Player where Group_Code = ? ORDER BY PLAYER_CODE DESC";
		ArrayList<PlayerDTO> aplist = new ArrayList<PlayerDTO>();

		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, Group_Code);

			rs = pst.executeQuery();
			while (rs.next()) {
				aplist.add(new PlayerDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getBytes(5),
						rs.getString(6), rs.getInt(7), rs.getString(8)));
			}
			close();
			return aplist;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<listAllDTO> selectGudanPlayerAbility(int Group_Code) {
		ArrayList<PlayerDTO> list = selectGudanPlayera(Group_Code);

		ArrayList<listAllDTO> result = new ArrayList<listAllDTO>();

		for (int i = 0; i < list.size(); i++) {
			con();

			try {
				sql = "select a.Player_Code, c.PLAYER_NAME, a.Player_Football_Speed, a.Player_Football_Shoot, a.Player_Football_Pass, a.Player_Football_Dribol, a.Player_Football_Defense, b.Player_Physical_Sex, b.Player_Physical_Age, b.Player_Physical_Height, b.Player_Physical_Weight, b.Player_Physical_LeftFoot, b.Player_Physical_RightFoot from "
						+ "(select * from Player_Football where PLAYER_CODE = ? and 1 = ROWNUM ORDER BY PLAYER_FOOTBALL_CODE desc) a, "
						+ "(select * from Player_Physical where PLAYER_CODE = ? and 1 = ROWNUM ORDER BY PLAYER_PHYSICAL_CODE desc) b, "
						+ "(select * from PLAYER where PLAYER_CODE = ?) c";

				pst = conn.prepareStatement(sql);

				pst.setInt(1, list.get(i).getPlayer_Code());
				pst.setInt(2, list.get(i).getPlayer_Code());
				pst.setInt(3, list.get(i).getPlayer_Code());

				rs = pst.executeQuery();

				while (rs.next()) {
					result.add(new listAllDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
							rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11),
							rs.getInt(12), rs.getInt(13)));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			close();
		}

		return result;
	}

	public ArrayList<PlayerDTO> searchGudanPlayera(String name) {
		con();
		sql = "select * from Player where player_name LIKE '%' || ? || '%' or PLAYER_CODE LIKE '%' || ? || '%' or GROUP_CODE = (select GROUP_CODE from GROUPS where GROUP_NAME LIKE '%' || ? || '%' and 1 = ROWNUM) ORDER BY PLAYER_CODE DESC";
		ArrayList<PlayerDTO> aplist = new ArrayList<PlayerDTO>();

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, name);
			pst.setString(3, name);

			rs = pst.executeQuery();
			while (rs.next()) {
				aplist.add(new PlayerDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getBytes(5),
						rs.getString(6), rs.getInt(7), rs.getString(8)));
			}
			close();
			return aplist;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<listAllDTO> searchGudanPlayerAbility(int Group_Code, String name) {
		ArrayList<PlayerDTO> list = searchGudanPlayera(name);

		ArrayList<listAllDTO> result = new ArrayList<listAllDTO>();

		for (int i = 0; i < list.size(); i++) {
			con();

			try {
				sql = "select a.Player_Code, c.PLAYER_NAME, a.Player_Football_Speed, a.Player_Football_Shoot, a.Player_Football_Pass, a.Player_Football_Dribol, a.Player_Football_Defense, b.Player_Physical_Sex, b.Player_Physical_Age, b.Player_Physical_Height, b.Player_Physical_Weight, b.Player_Physical_LeftFoot, b.Player_Physical_RightFoot from "
						+ "(select * from Player_Football where PLAYER_CODE = ? and  Group_Code = ? and 1 = ROWNUM ORDER BY PLAYER_FOOTBALL_CODE desc) a, "
						+ "(select * from Player_Physical where PLAYER_CODE = ? and  Group_Code = ? and 1 = ROWNUM ORDER BY PLAYER_PHYSICAL_CODE desc) b, "
						+ "(select * from PLAYER where PLAYER_CODE = ? and  Group_Code = ?) c";

				pst = conn.prepareStatement(sql);

				pst.setInt(1, list.get(i).getPlayer_Code());
				pst.setInt(2, Group_Code);
				pst.setInt(3, list.get(i).getPlayer_Code());
				pst.setInt(4, Group_Code);
				pst.setInt(5, list.get(i).getPlayer_Code());
				pst.setInt(6, Group_Code);
				rs = pst.executeQuery();

				while (rs.next()) {
					result.add(new listAllDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
							rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11),
							rs.getInt(12), rs.getInt(13)));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			close();
		}

		return result;
	}

	public ArrayList<listAllDTO> VIPsearchGudanPlayerAbility(String name) {
		ArrayList<PlayerDTO> list = searchGudanPlayera(name);

		ArrayList<listAllDTO> result = new ArrayList<listAllDTO>();

		for (int i = 0; i < list.size(); i++) {
			con();

			try {
				sql = "select a.Player_Code, c.PLAYER_NAME, a.Player_Football_Speed, a.Player_Football_Shoot, a.Player_Football_Pass, a.Player_Football_Dribol, a.Player_Football_Defense, b.Player_Physical_Sex, b.Player_Physical_Age, b.Player_Physical_Height, b.Player_Physical_Weight, b.Player_Physical_LeftFoot, b.Player_Physical_RightFoot from "
						+ "(select * from Player_Football where PLAYER_CODE = ? and 1 = ROWNUM ORDER BY PLAYER_FOOTBALL_CODE desc) a, "
						+ "(select * from Player_Physical where PLAYER_CODE = ? and 1 = ROWNUM ORDER BY PLAYER_PHYSICAL_CODE desc) b, "
						+ "(select * from PLAYER where PLAYER_CODE = ?) c";

				pst = conn.prepareStatement(sql);

				pst.setInt(1, list.get(i).getPlayer_Code());
				pst.setInt(2, list.get(i).getPlayer_Code());
				pst.setInt(3, list.get(i).getPlayer_Code());

				rs = pst.executeQuery();

				while (rs.next()) {
					result.add(new listAllDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
							rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11),
							rs.getInt(12), rs.getInt(13)));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			close();
		}

		return result;
	}

	public int getStatusPlayerCode() {
		con();

		int result = 0;

		try {
			sql = "select PLAYER_CODE from PLAYER where 1 = ROWNUM ORDER BY PLAYER_CODE desc";

			pst = conn.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) {
				result = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		close();
		return result;
	}

}
