package P7_Util;

public class Emailcheck {
	public  boolean Emailcheck(String Email) {
		
		if (Email.contains("@")&&Email.contains(".")) {
			return false; //�̸��� ���¸� �޽�
		}else if (Email.contains(",")&&Email.contains("?")&&Email.contains("<")&&Email.contains(">")&&Email.contains(";")&&Email.contains(":")&&Email.contains("'")&&Email.contains("!")&&Email.contains("$")&&Email.contains("@")&&Email.contains("^")&&Email.contains("&")&&Email.contains("*")&&Email.contains("(")&&Email.contains(")")) {
			return true;
		}
		
		return true; //�̸��� ���� �ƴϸ� ���� 
		
	}
}
