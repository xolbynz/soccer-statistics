package P3_DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import P0_사용법.OracleURL;
import P4_DTO.Player_FootballDTO;

public class Player_FootballDAO {
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

	public int joinPlayer_Football(Player_FootballDTO Player_FootballDTO) {
		con();

		sql = "INSERT INTO Player_Football(player_football_code, PLAYER_CODE, GROUP_CODE,PLAYER_FOOTBALL_SPEED,PLAYER_FOOTBALL_SHOOT, PLAYER_FOOTBALL_PASS, PLAYER_FOOTBALL_DRIBOL, PLAYER_FOOTBALL_DEFENSE) "
				+ "VALUES(PLAYER_FOOTBALL_SEQUENCE.nextval,?,?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, Player_FootballDTO.getPlayer_Code());
			pst.setInt(2, Player_FootballDTO.getGroup_Code());
			pst.setInt(3, Player_FootballDTO.getPlayer_Football_Speed());
			pst.setInt(4, Player_FootballDTO.getPlayer_Football_Shoot());
			pst.setInt(5, Player_FootballDTO.getPlayer_Football_Pass());
			pst.setInt(6, Player_FootballDTO.getPlayer_Football_Dribol());
			pst.setInt(7, Player_FootballDTO.getPlayer_Football_Defense());
			int cnt = pst.executeUpdate();
			close();
			return cnt;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	
//	// 시퀀스 값 을 제외한 인설트 해오기 업데이트용
//	public void joinPlayer_Football_noreturn(Player_FootballDTO Player_FootballDTO) { // DTO로 받으면 값을 넣지
//	
//		con();
//
//		sql = "INSERT INTO Player_Football(insert into player_football(player_football_code, PLAYER_CODE, GROUP_CODE,PLAYER_FOOTBALL_SPEED,PLAYER_FOOTBALL_SHOOT, PLAYER_FOOTBALL_PASS, PLAYER_FOOTBALL_DRIBOL, PLAYER_FOOTBALL_DEFENSE)"
//				+" ?,?,?,?,?,?,?);";
//		try {
//			pst = conn.prepareStatement(sql);
//
//		
//			pst.setInt(1, Player_FootballDTO.getPlayer_Code());
//			pst.setInt(2, Player_FootballDTO.getGroup_Code());
//			pst.setInt(3, Player_FootballDTO.getPlayer_Football_Speed());
//			pst.setInt(4, Player_FootballDTO.getPlayer_Football_Shoot());
//			pst.setInt(5, Player_FootballDTO.getPlayer_Football_Pass());
//			pst.setInt(6, Player_FootballDTO.getPlayer_Football_Dribol());
//			pst.setInt(7, Player_FootballDTO.getPlayer_Football_Defense());
//			cnt = pst.executeUpdate();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		close();
//
//		
//	}

	public ArrayList<Player_FootballDTO> SelectPlayer_Football(int Player_Code) {
		con();
		sql = "select * from Player_Football where Player_Code= ? ORDER BY PLAYER_FOOTBALL_CODE desc";
		ArrayList<Player_FootballDTO> plist = new ArrayList<>();

		try {
			pst = conn.prepareStatement(sql);

			pst.setInt(1, Player_Code);

			rs = pst.executeQuery();

			while (rs.next()) {
				plist.add(new Player_FootballDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8)));
			}
			close();
			return plist;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public ArrayList<Player_FootballDTO> SelectPlayer_Football_Recent(int Player_Code) {
		con();
		sql = "select * from Player_Football where Player_Code= ? and rownum <= 5 ORDER BY Player_Football_Code DESC";
		ArrayList<Player_FootballDTO> plist = new ArrayList<>();

		try {
			pst = conn.prepareStatement(sql);

			pst.setInt(1, Player_Code);

			rs = pst.executeQuery();

			while (rs.next()) {
				plist.add(new Player_FootballDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8)));
			}
			close();
			return plist;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public void deletePlayerFootball(Player_FootballDTO pdto) {
		con();
		sql = "delete from Player_Football where Player_code = ? ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, pdto.getPlayer_Code());
			int cnt = pst.executeUpdate();
			if (cnt > 0) {
				System.out.println("delete 성공");
			} else {
				System.out.println("delete 실패");
			}
			close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

//	public void updatePlayer_Football(Player_FootballDTO Player_FootballDTO) {
//		deletePlayerFootball(Player_FootballDTO);
//		joinPlayer_Football_noreturn(Player_FootballDTO);
//
//	}

}
