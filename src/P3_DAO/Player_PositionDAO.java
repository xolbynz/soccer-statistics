package P3_DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import P0_사용법.OracleURL;
import P4_DTO.PlayerPositionDTO;



public class Player_PositionDAO {
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
	
	public int joinPlayer_Position(PlayerPositionDTO PlayerPositionDTO) {
		con();

		sql = "INSERT INTO Player_Position(Player_Position_Code, Player_Code, Group_Code, Player_Position_Name) "
				+ "VALUES(PLAYER_POSITION_SEQUENCE.nextval, ?, ?, ?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, PlayerPositionDTO.getPlayer_Code());
			pst.setInt(2, PlayerPositionDTO.getGroup_Code());
			pst.setString(3, PlayerPositionDTO.getPlayer_Position_Name());
			
			int cnt = pst.executeUpdate();
			close();
			return cnt;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
//	//업데이트용
//	public int joinPlayer_Position_noreturn(PlayerPositionDTO PlayerPositionDTO) {
//		con();
//
//		sql = "INSERT INTO Player_Position(insert into player_football( Player_Code, Group_Code, Player_Position_Name)"
//				+ "VALUES(?,?,?);";
//		try {
//			pst = conn.prepareStatement(sql);
//			pst.setInt(1, PlayerPositionDTO.getPlayer_Code());
//			pst.setInt(2, PlayerPositionDTO.getGroup_Code());
//			pst.setString(3, PlayerPositionDTO.getPlayer_Position_Name());
//			
//			int cnt = pst.executeUpdate();
//			close();
//			return cnt;
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return -1;
//	}
//	
//	
	
	public ArrayList<PlayerPositionDTO> selectPlayer_Football(int PLAYER_CODE) {
		con();
		sql = "select * from Player_Position where PLAYER_CODE = ? ORDER by PLAYER_POSITION_CODE desc";
		ArrayList<PlayerPositionDTO> plist = new ArrayList<>();

		try {
			pst = conn.prepareStatement(sql);

			pst.setInt(1, PLAYER_CODE);

			rs = pst.executeQuery();

			while (rs.next()) {
				plist.add(new PlayerPositionDTO(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4)));
			}
			close();
			return plist;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	public void deletePlayerPosition(PlayerPositionDTO pdto) {
		con();
		sql = "delete from Player_Position where Player_Position_Code = ? ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, pdto.getPlayer_Position_Code());
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
	

}
