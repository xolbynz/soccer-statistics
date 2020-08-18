package P6_Temp;

import P3_DAO.testDAO;
import P4_DTO.testDTO;

public class testMain {

	public static void main(String[] args) {
		testDAO dao = new testDAO();

		// 메일, 소속코드, 이름, 비밀번호, 집전화, **지역코드 걍 1을 광주라고 생각함, 주소, 이미지경로, 뷰 등급 1은 다른 구단도 검색가능
		testDTO dto = new testDTO("odd03@naver.com", 1, "오대근", "1234", "062112", 1, "광주 남구 서문대로",
				"C:\\Users\\pc-22\\Desktop\\수정이미지\\프로필.jpg", 0);

		int cnt = 0;

		if (dao.isEmailJoin(dto.getMember_Email())) {
			System.out.println("중복된 email입니다.");
		} else {
			System.out.println("중복되지 않은 email입니다.");
			cnt = dao.join(dto);
		}

		if (cnt > 0) {
			System.out.println("회원가입 성공");
		} else {
			System.out.println("회원가입 실패");
		}

	}

}
