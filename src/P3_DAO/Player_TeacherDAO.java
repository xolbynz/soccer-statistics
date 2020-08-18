package P3_DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import P0_사용법.OracleURL;
import P4_DTO.PlayerTeacherDTO;
import P4_DTO.loginDTO;

public class Player_TeacherDAO {
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

	public int insertMemo(loginDTO dto, int PLAYER_CODE, String memo) { // DTO로 받으면 값을 넣지 않으면 null이기때문에 db에 자동으로 null이 들어감
		con();
		// 정말 끔직하지만 꼭 insert문을 할때는 원래는 생략하였던 컬럼며을 다 기업하여 줄것, 반드시 전체 컬럼의 값을 insert하는 경우는
		// 드물기 때문이다.
		sql = "INSERT INTO PLAYER_Teacher(Player_Teacher_Code, Player_Code, Group_Code, Player_Teacher_Title, Player_Teacher_Content)"
				+ " VALUES(PLAYER_Teacher_SEQUENCE.nextval, ?, ?, ?, ?)";

		try {
			pst = conn.prepareStatement(sql);

			pst.setInt(1, PLAYER_CODE);
			pst.setInt(2, dto.getGroup_Code());
			pst.setString(3, dto.getMember_Nickname());
			pst.setString(4, memo);

			cnt = pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		close();

		return cnt;
	}

	// 이름 조회
	public ArrayList<PlayerTeacherDTO> SelectPlayer(int player_code) {
		con();

		sql = "select * from Player_Teacher where Player_Code= ? ORDER BY PLAYER_TEACHER_CODE desc";
		ArrayList<PlayerTeacherDTO> plist = new ArrayList<PlayerTeacherDTO>();

		try {
			pst = conn.prepareStatement(sql);

			pst.setInt(1, player_code);

			rs = pst.executeQuery();

			while (rs.next()) {
				plist.add(new PlayerTeacherDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4),
						rs.getString(5)));

			}
			close();
			return plist;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// 전체 조회
	public ArrayList<PlayerTeacherDTO> selectallPlayer() {
		con();

		sql = "select * from Player_Teacher ORDER BY PLAYER_TEACHER_CODE desc";
		ArrayList<PlayerTeacherDTO> aplist = new ArrayList<PlayerTeacherDTO>();

		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				aplist.add(new PlayerTeacherDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4),
						rs.getString(5)));
			}
			close();
			return aplist;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
