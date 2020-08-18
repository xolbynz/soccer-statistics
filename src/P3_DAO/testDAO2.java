package P3_DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import P0_사용법.OracleURL;
import P4_DTO.testDTO;

/**
 * 
 * @author : 오대근
 * @date : 2019. 5. 15.
 * @time : 오후 7:48:35
 * @content : 멤버테이블을 모델로 테스트 DAO작성 private String sql부터 closs() 까지는 꼭 똑같이 하며, 각
 *          메서드의 시작과 끝은 꼭 con()과 closs()를 넣을것
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

		if (result2 != null) { // 될수 있으면 리턴은 밖에서 해주자. 안그러면 close가 안되서 고민을 해봐야함
			return true; // 중복된 값이 있을때 true
		} else {
			return false; // 중복된 값이 있을때 false
		}
	}

	public int join(testDTO testDTO) { // DTO로 받으면 값을 넣지 않으면 null이기때문에 db에 자동으로 null이 들어감
		con();
		// 정말 끔직하지만 꼭 insert문을 할때는 원래는 생략하였던 컬럼며을 다 기업하여 줄것, 반드시 전체 컬럼의 값을 insert하는 경우는
		// 드물기 때문이다.
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
			pst.setBytes(8, testDTO.getMember_Img()); // 이미지는 byte배열이기 때문에 Bytes
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
