package P6_Temp;

import P3_DAO.testDAO;
import P4_DTO.testDTO;

public class testMain {

	public static void main(String[] args) {
		testDAO dao = new testDAO();

		// ����, �Ҽ��ڵ�, �̸�, ��й�ȣ, ����ȭ, **�����ڵ� �� 1�� ���ֶ�� ������, �ּ�, �̹������, �� ��� 1�� �ٸ� ���ܵ� �˻�����
		testDTO dto = new testDTO("odd03@naver.com", 1, "�����", "1234", "062112", 1, "���� ���� �������",
				"C:\\Users\\pc-22\\Desktop\\�����̹���\\������.jpg", 0);

		int cnt = 0;

		if (dao.isEmailJoin(dto.getMember_Email())) {
			System.out.println("�ߺ��� email�Դϴ�.");
		} else {
			System.out.println("�ߺ����� ���� email�Դϴ�.");
			cnt = dao.join(dto);
		}

		if (cnt > 0) {
			System.out.println("ȸ������ ����");
		} else {
			System.out.println("ȸ������ ����");
		}

	}

}
