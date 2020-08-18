package P3_DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import P0_����.OracleURL;
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

	public int joinPlayer(PlayerPhysicalDTO PlayerPhysicalDTO) { // DTO�� ������ ���� ���� ������ null�̱⶧���� db�� �ڵ����� null�� ��
		con();
		// ���� ���������� �� insert���� �Ҷ��� ������ �����Ͽ��� �÷����� �� ����Ͽ� �ٰ�, �ݵ�� ��ü �÷��� ���� insert�ϴ� ����
		// �幰�� �����̴�.
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

	// �̸� ��ȸ
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

	// ��ü ��ȸ
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
