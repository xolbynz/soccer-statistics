package P3_DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import P0_사용법.OracleURL;
import P4_DTO.SignUpDTO;

public class SignUpDAO {
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

	// 회원가입전에 중복검사를 하는것이니 is+검사명+중복검사가 필요한 메서드명으로 작명하자
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

		if (result2 != null) { //될수 있으면 리턴은 밖에서 해주자. 안그러면 close가 안되서 고민을 해봐야함
			return true; // 중복된 값이 있을때 true
		} else {
			return false; // 중복된 값이 있을때 false
		}
	}

	public int join(SignUpDTO SignUpDTO) { // DTO로 받으면 값을 넣지 않으면 null이기때문에 db에 자동으로 null이 들어감
		con();
		// 정말 끔직하지만 꼭 insert문을 할때는 원래는 생략하였던 컬럼며을 다 기업하여 줄것, 반드시 전체 컬럼의 값을 insert하는 경우는
		// 드물기 때문이다.
		sql = "INSERT INTO Member(Member_Email, Group_Code, Member_Nickname, Member_Pw, Member_Tel, Member_LocalCode, Member_Address, Member_Img, View_Power) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			pst = conn.prepareStatement(sql);

			pst.setString(1, SignUpDTO.getMember_Email());
			pst.setInt(2, SignUpDTO.getGroup_Code());
			pst.setString(3, SignUpDTO.getMember_Nickname());
			pst.setString(4, SignUpDTO.getMember_Pw());
			pst.setString(5, SignUpDTO.getMember_Tel());
			pst.setInt(6, SignUpDTO.getMember_LocalCode());
			pst.setString(7, SignUpDTO.getMember_Address());
			pst.setBytes(8, SignUpDTO.getMember_Img()); // 이미지는 byte배열이기 때문에 Bytes
			pst.setInt(9, SignUpDTO.getView_Power());

			cnt = pst.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		close();

		return cnt;
	}

	public boolean delete(String Email) {
		con();
		try {
			
			String sql="delete from Member where Member_Email=? ";
			pst=conn.prepareStatement(sql);
			pst.setString(1,Email);
			int cnt = pst.executeUpdate();

			if (cnt > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	

}
