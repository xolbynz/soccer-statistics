package P3_DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import P0_사용법.OracleURL;
import P4_DTO.PlayerContestDTO;
import P4_DTO.Player_FootballDTO;

public class Player_ContestDAO {
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

	public int joinPlayer(PlayerContestDTO dto) { // DTO로 받으면 값을 넣지 않으면 null이기때문에 db에 자동으로 null이 들어감
		con();
		// 정말 끔직하지만 꼭 insert문을 할때는 원래는 생략하였던 컬럼며을 다 기업하여 줄것, 반드시 전체 컬럼의 값을 insert하는 경우는
		// 드물기 때문이다.
		sql = "INSERT INTO PLAYER_CONTEST(Player_CONTEST_Code,Player_Code,Group_Code,Player_Contest_TITLE,"
				+ "Player_Contest_CONTENT,Player_Contest_RESULT,Player_Contest_SHOT,Player_Contest_EFFECTIVESHOT,"
				+ "Player_Contest_GOAL,Player_Contest_ASSIST,Player_Contest_RUNNINGTIME)"
				+ " VALUES(PLAYER_CONTEST_SEQUENCE.nextval,?,?,?,?,?,?,?,?,?,?)";

		try {
			pst = conn.prepareStatement(sql);

			pst.setInt(1, dto.getPlayer_Code());
			pst.setInt(2, dto.getGroup_Code());
			pst.setString(3, dto.getPlayer_Contest_Title());
			pst.setString(4, dto.getPlayer_Contest_Content());
			pst.setString(5, dto.getPlayer_Contest_Result());
			pst.setInt(6, dto.getPlayer_Contest_Shot());
			pst.setInt(7, dto.getPlayer_Contest_EffectiveShot());
			pst.setInt(8, dto.getPlayer_Contest_Goal());
			pst.setInt(9, dto.getPlayer_Contest_Assist());
			pst.setInt(10, dto.getPlayer_Contest_RunningTime());
			cnt = pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		close();

		return cnt;
	}

	// 이름 조회
	public ArrayList<PlayerContestDTO> SelectPlayer(int player_code) {
		con();

		sql = "select * from Player_contest where Player_Code= ? ORDER BY PLAYER_CONTEST_CODE desc";
		ArrayList<PlayerContestDTO> plist = new ArrayList<PlayerContestDTO>();

		try {
			pst = conn.prepareStatement(sql);

			pst.setInt(1, player_code);

			rs = pst.executeQuery();
			while (rs.next()) {
				plist.add(new PlayerContestDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10),
						rs.getInt(11)));

			}
			close();
			return plist;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// 전체 조회
	public ArrayList<PlayerContestDTO> selectallPlayer() {
		con();

		sql = "select * from Player_contest";
		ArrayList<PlayerContestDTO> aplist = new ArrayList<PlayerContestDTO>();

		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				aplist.add(new PlayerContestDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10),
						rs.getInt(11)));
			}
			close();
			return aplist;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<PlayerContestDTO> selectAllGroup(int group_Code) {
		con();

		sql = "select * from Player_contest where group_Code= ?";
		ArrayList<PlayerContestDTO> plist = new ArrayList<PlayerContestDTO>();

		try {
			pst = conn.prepareStatement(sql);

			pst.setInt(1, group_Code);

			rs = pst.executeQuery();
			while (rs.next()) {
				plist.add(new PlayerContestDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10),
						rs.getInt(11)));

			}
			close();
			return plist;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
