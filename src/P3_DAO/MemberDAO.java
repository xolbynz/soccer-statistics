package P3_DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import P0_사용법.OracleURL;
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
				System.out.println("delete 성공");
			} else {
				System.out.println("delete 실패");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public int joinMember(MemberDTO mdto) { // DTO로 받으면 값을 넣지
											// 않으면 null이기때문에 db에
											// 자동으로 null이 들어감
		con();
		// 정말 끔직하지만 꼭 insert문을 할때는 원래는 생략하였던 컬럼며을 다 기업하여 줄것, 반드시 전체 컬럼의 값을 insert하는 경우는
		// 드물기 때문이다.
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
