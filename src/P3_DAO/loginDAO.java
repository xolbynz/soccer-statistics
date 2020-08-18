package P3_DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import P0_����.OracleURL;
import P4_DTO.loginDTO;
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
public class loginDAO {
	private String sql;
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
				System.out.print("��������->");
			}
			System.out.println("Ŭ���");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public loginDTO Login(loginDTO loginDTO) {
		con();

		sql = "select * from Member where Member_Email = ? and Member_Pw = ?";

		loginDTO result_dto = null;

		try {
			pst = conn.prepareStatement(sql);

			pst.setString(1, loginDTO.getMember_Email());
			pst.setString(2, loginDTO.getMember_Pw());

			rs = pst.executeQuery();

			while (rs.next()) {
				result_dto = new loginDTO();
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
	
	
	
	public boolean update(loginDTO loginDTO) {
		con();
		try {
			String sql="update member set member_nickname=?, member_pw=?, member_tel=?, member_localcode=?, member_address=?, member_img=? "
					+ "where member_email=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1,loginDTO.getMember_Nickname());
			pst.setString(2,loginDTO.getMember_Pw());
			pst.setString(3, loginDTO.getMember_Tel());
			pst.setInt(4, loginDTO.getMember_LocalCode());
			pst.setString(5,loginDTO.getMember_Address() );
			pst.setBytes(6, loginDTO.getMember_Img());
			pst.setString(7, loginDTO.getMember_Email());
			
			int cnt= pst.executeUpdate();
			
			if (cnt>0) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}

}
