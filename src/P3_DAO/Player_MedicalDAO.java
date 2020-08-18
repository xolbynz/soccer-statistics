package P3_DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import P0_����.OracleURL;
import P4_DTO.PlayerMedicalDTO;

public class Player_MedicalDAO {
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

	public int joinPlayer(PlayerMedicalDTO dto) { // DTO�� ������ ���� ���� ������ null�̱⶧���� db�� �ڵ����� null�� ��
		con();

		sql = "INSERT INTO PLAYER_MEDICAL(PLAYER_MEDICAL_CODE, PLAYER_CODE, GROUP_CODE, PLAYER_MEDICAL_PERIOD, PLAYER_MEDICAL_TITLE, PLAYER_MEDICAL_CONTENT) VALUES(PLAYER_MEDICAL_SEQUENCE.nextval, ?, ?, ?, ?, ?)";

		try {
			pst = conn.prepareStatement(sql);

			pst.setInt(1, dto.getPlayer_Code());
			pst.setInt(2, dto.getGroup_Code());
			pst.setInt(3, dto.getPlayer_Medical_Period());
			pst.setString(4, dto.getPlayer_Medical_Title());
			pst.setString(5, dto.getPlayer_Medical_Content());

			cnt = pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		close();

		return cnt;
	}

	// �̸� ��ȸ
	public ArrayList<PlayerMedicalDTO> SelectPlayer(int player_code) {
		con();

		sql = "select * from Player_Medical where Player_Code= ? ORDER BY PLAYER_MEDICAL_CODE desc";
		ArrayList<PlayerMedicalDTO> plist = new ArrayList<PlayerMedicalDTO>();

		try {
			pst = conn.prepareStatement(sql);

			pst.setInt(1, player_code);

			rs = pst.executeQuery();

			while (rs.next()) {
				plist.add(new PlayerMedicalDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5),
						rs.getString(6)));

			}
			close();
			return plist;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// ��ü ��ȸ
	public ArrayList<PlayerMedicalDTO> selectallPlayer() {
		con();

		sql = "select * from Player_Medical ORDER BY PLAYER_MEDICAL_CODE desc";
		ArrayList<PlayerMedicalDTO> aplist = new ArrayList<PlayerMedicalDTO>();

		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				aplist.add(new PlayerMedicalDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5),
						rs.getString(6)));
			}
			close();
			return aplist;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
