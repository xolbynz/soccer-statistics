package P3_DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import P0_����.OracleURL;
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
				System.out.print("���Ἲ��->");
			} else {
				System.out.println("�������->");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void close() {
		try {
			if (rs != null) {
				rs.close();
				System.out.print("rs����->");
			}
			if (pst != null) {
				pst.close();
				System.out.print("pst����->");
			}
			if (conn != null) {
				conn.close();
				System.out.print("conn����->");
			}
			System.out.println("Ŭ���");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int joinPlayer(PlayerContestDTO dto) { // DTO�� ������ ���� ���� ������ null�̱⶧���� db�� �ڵ����� null�� ��
		con();
		// ���� ���������� �� insert���� �Ҷ��� ������ �����Ͽ��� �÷����� �� ����Ͽ� �ٰ�, �ݵ�� ��ü �÷��� ���� insert�ϴ� ����
		// �幰�� �����̴�.
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

	// �̸� ��ȸ
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

	// ��ü ��ȸ
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
