package P3_DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import P0_사용법.OracleURL;
import P4_DTO.PlayerPhysicalDTO;

public class Player_PhysicalDAO {
	private String sql;
	private String sql2;
	private int cnt;
	private Connection conn;
	private PreparedStatement pst;
	private PreparedStatement pst2;
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

	public int joinPlayer(PlayerPhysicalDTO PlayerPhysicalDTO) { // DTO로 받으면 값을 넣지 않으면 null이기때문에 db에 자동으로 null이 들어감
		con();
		// 정말 끔직하지만 꼭 insert문을 할때는 원래는 생략하였던 컬럼며을 다 기업하여 줄것, 반드시 전체 컬럼의 값을 insert하는 경우는
		// 드물기 때문이다.
		sql = "INSERT INTO PLAYER_PHYSICAL(Player_Physical_Code,Player_Code,Group_Code,Player_Physical_Sex,Player_Physical_Age,Player_Physical_Height,Player_Physical_Weight,Player_Physical_LeftFoot,Player_Physical_RightFoot)"
				+ " VALUES(PLAYER_PHYSICAL_SEQUENCE.nextval,?,?,?,?,?,?,?,?)";

		try {
			pst = conn.prepareStatement(sql);

			pst.setInt(1, PlayerPhysicalDTO.getPlayer_Code());
			pst.setInt(2, PlayerPhysicalDTO.getGroup_Code());
			pst.setInt(3, PlayerPhysicalDTO.getPlayer_Physical_Sex());
			pst.setInt(4, PlayerPhysicalDTO.getPlayer_Physical_Age());
			pst.setInt(5, PlayerPhysicalDTO.getPlayer_Physical_Height());
			pst.setInt(6, PlayerPhysicalDTO.getPlayer_Physical_Weight());
			pst.setInt(7, PlayerPhysicalDTO.getPlayer_Physical_LeftFoot());
			pst.setInt(8, PlayerPhysicalDTO.getPlayer_Physical_RightFoot());

			cnt = pst.executeUpdate();
			System.out.println(cnt);

		} catch (Exception e) {
			e.printStackTrace();
		}

		
		close();

		return cnt;
	}

	// 이름 조회
	public ArrayList<PlayerPhysicalDTO> SelectPlayer(int player_code) {
		con();

		sql = "select * from Player_Physical where Player_Code= ? ORDER BY PLAYER_PHYSICAL_CODE desc";
		ArrayList<PlayerPhysicalDTO> plist = new ArrayList<PlayerPhysicalDTO>();

		try {
			pst = conn.prepareStatement(sql);

			pst.setInt(1, player_code);

			rs = pst.executeQuery();

			while (rs.next()) {
				plist.add(new PlayerPhysicalDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9)));

			}
			close();
			return plist;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// 전체 조회
	public ArrayList<PlayerPhysicalDTO> selectallPlayer() {
		con();

		sql = "select * from Player_Physical ORDER BY PLAYER_PHYSICAL_CODE desc";
		ArrayList<PlayerPhysicalDTO> aplist = new ArrayList<PlayerPhysicalDTO>();

		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				aplist.add(new PlayerPhysicalDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9)));
			}
			close();
			return aplist;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
