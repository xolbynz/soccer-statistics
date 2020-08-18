package P7_Util;

public class Emailcheck {
	public  boolean Emailcheck(String Email) {
		
		if (Email.contains("@")&&Email.contains(".")) {
			return false; //이메일 형태면 펄스
		}else if (Email.contains(",")&&Email.contains("?")&&Email.contains("<")&&Email.contains(">")&&Email.contains(";")&&Email.contains(":")&&Email.contains("'")&&Email.contains("!")&&Email.contains("$")&&Email.contains("@")&&Email.contains("^")&&Email.contains("&")&&Email.contains("*")&&Email.contains("(")&&Email.contains(")")) {
			return true;
		}
		
		return true; //이메일 형태 아니면 투루 
		
	}
}
