package P3_DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import P0_����.OracleURL;
import P4_DTO.MemberDTO;

public class MemberDAO {
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

	public ArrayList<MemberDTO> selectAllMember() {
		con();

		sql = "select * from MEMBER ORDER BY GROUP_CODE DESC";

		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();

		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				MemberDTO result_dto = new MemberDTO();
				result_dto.setMember_Email(rs.getString(1));
				result_dto.setGroup_Code(rs.getInt(2));
				result_dto.setMember_Nickname(rs.getString(3));
				result_dto.setMember_Pw(rs.getString(4));
				result_dto.setMember_Tel(rs.getString(5));
				result_dto.setMember_LocalCode(rs.getInt(6));
				result_dto.setMember_Address(rs.getString(7));
				result_dto.setMember_Img_bytes(rs.getBytes(8));
				result_dto.setView_Power(rs.getInt(9));

				list.add(result_dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		close();
		return list;
	}

//	GroupsDTO gdto = new GroupsDTO(group_Code, group_Name, group_Tel, group_Img, group_LocalCode, group_Address, group_HomePage)
	public void deleteMember(MemberDTO mdto) {
		con();
		sql = "delete from member where member_email = ? ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, mdto.getMember_Email());
			int cnt = pst.executeUpdate();
			if (cnt > 0) {
				System.out.println("delete ����");
			} else {
				System.out.println("delete ����");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public int joinMember(MemberDTO mdto) { // DTO�� ������ ���� ����
											// ������ null�̱⶧���� db��
											// �ڵ����� null�� ��
		con();
		// ���� ���������� �� insert���� �Ҷ��� ������ �����Ͽ��� �÷����� �� ����Ͽ� �ٰ�, �ݵ�� ��ü �÷��� ���� insert�ϴ� ����
		// �幰�� �����̴�.
		sql = "INSERT INTO Member(Member_Email,Group_Code,Member_Nickname,Member_Pw,Member_Tel,Member_LocalCode,Member_Address,Member_Img,View_Power)"
				+ " VALUES(?, ?, ?, ?, ?, ?, ?,?,?)";

		try {
			pst = conn.prepareStatement(sql);

			pst.setString(1, mdto.getMember_Email());
			pst.setInt(2, mdto.getGroup_Code());
			pst.setString(3, mdto.getMember_Nickname());
			pst.setString(4, mdto.getMember_Pw());
			pst.setString(5, mdto.getMember_Tel());
			pst.setInt(6, mdto.getMember_LocalCode());
			pst.setString(7, mdto.getMember_Address());
			pst.setBytes(8, mdto.getMember_Img());
			pst.setInt(9, mdto.getView_Power());
			cnt = pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		close();

		return cnt;
	}

	public void updateGroups(MemberDTO mdto) {
		deleteMember(mdto);
		joinMember(mdto);

	}

}
