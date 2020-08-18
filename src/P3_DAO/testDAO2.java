package P3_DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import P0_����.OracleURL;
import P4_DTO.testDTO;

/**
 * 
 * @author : �����
 * @date : 2019. 5. 15.
 * @time : ���� 7:48:35
 * @content : ������̺��� �𵨷� �׽�Ʈ DAO�ۼ� private String sql���� closs() ������ �� �Ȱ��� �ϸ�, ��
 *          �޼����� ���۰� ���� �� con()�� closs()�� ������
 * 
 */
public class testDAO2 {
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

	// ȸ���������� �ߺ��˻縦 �ϴ°��̴� is+�˻��+�ߺ��˻簡 �ʿ��� �޼�������� �۸�����
	public boolean isEmailJoin(String Member_Email) {
		con();

		sql = "select Member_Email from Member where Member_Email = ?";

		String result2 = null;

		try {
			pst = conn.prepareStatement(sql);

			pst.setString(1, Member_Email);

			rs = pst.executeQuery();

			while (rs.next()) {
				result2 = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		close();

		if (result2 != null) { // �ɼ� ������ ������ �ۿ��� ������. �ȱ׷��� close�� �ȵǼ� ����� �غ�����
			return true; // �ߺ��� ���� ������ true
		} else {
			return false; // �ߺ��� ���� ������ false
		}
	}

	public int join(testDTO testDTO) { // DTO�� ������ ���� ���� ������ null�̱⶧���� db�� �ڵ����� null�� ��
		con();
		// ���� ���������� �� insert���� �Ҷ��� ������ �����Ͽ��� �÷����� �� ����Ͽ� �ٰ�, �ݵ�� ��ü �÷��� ���� insert�ϴ� ����
		// �幰�� �����̴�.
		sql = "INSERT INTO Member(Member_Email, Group_Code, Member_Nickname, Member_Pw, Member_Tel, Member_LocalCode, Member_Address, Member_Img, View_Power) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			pst = conn.prepareStatement(sql);

			pst.setString(1, testDTO.getMember_Email());
			pst.setInt(2, testDTO.getGroup_Code());
			pst.setString(3, testDTO.getMember_Nickname());
			pst.setString(4, testDTO.getMember_Pw());
			pst.setString(5, testDTO.getMember_Tel());
			pst.setInt(6, testDTO.getMember_LocalCode());
			pst.setString(7, testDTO.getMember_Address());
			pst.setBytes(8, testDTO.getMember_Img()); // �̹����� byte�迭�̱� ������ Bytes
			pst.setInt(9, testDTO.getView_Power());

			cnt = pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		close();

		return cnt;
	}

	public testDTO Login(testDTO testDTO) {
		con();

		sql = "select * from Member where Member_Email = ? and Member_Pw = ?";

		testDTO result_dto = new testDTO();

		try {
			pst = conn.prepareStatement(sql);

			pst.setString(1, testDTO.getMember_Email());
			pst.setString(2, testDTO.getMember_Pw());

			rs = pst.executeQuery();

			while (rs.next()) {
				result_dto.setMember_Email(rs.getString(1));
				result_dto.setGroup_Code(rs.getInt(2));
				result_dto.setMember_Nickname(rs.getString(3));
				result_dto.setMember_Pw(rs.getString(4));
				result_dto.setMember_Tel(rs.getString(5));
				result_dto.setMember_LocalCode(rs.getInt(6));
				result_dto.setMember_Address(rs.getString(7));
				result_dto.setMember_Img_bytes(rs.getBytes(8));
				result_dto.setView_Power(rs.getInt(9));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		close();

		return result_dto;
	}

}
