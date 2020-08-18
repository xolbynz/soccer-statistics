package P6_Temp;

import java.util.ArrayList;

import P3_DAO.GroupsDAO;
import P3_DAO.PlayerDAO;
import P4_DTO.GroupsDTO;
import P4_DTO.PlayerDTO;

public class testmain2 {

	public static void main(String[] args) {
		PlayerDAO pdao = new PlayerDAO();
		GroupsDAO gdao = new GroupsDAO();
		ArrayList<GroupsDTO> list = new ArrayList<>();
//		pdao.joinPlayer(new PlayerDTO(-1, 1, "Drogba", "062-112", "C:\\Users\\USER\\Desktop\\ryan.jpg", "Drogba@chelsea.fb.club", 1, "°æºÏ ¿ï¸ª±º ¿ï¸ªÀ¾ µ¶µµ¸®"));

//		System.out.println(gdao.SelectGroups("Á¤µ¿À±ÆÀ"));
//		for(int i=0; i<list.size();i++) {
//			System.out.println(list.get(i).toString());

//	
//		}

		gdao.updateGroups(new GroupsDTO(999, "¹®µµ", "999-999", "C:\\Users\\USER\\Desktop\\246x0w.jpg", 1, "¼­¿ï", "naver.com"));

	}
}
