package P7_Util;

public class fileExtension {

	public static boolean getfileExtension(String realFileName) {
		String []Extension={"jpg","jpeg","gif","png","tif","raw","jpe"};
//			realFileName = "green.apple.jpg"; 
		  String splitData [] = realFileName.split("\\.");
		  String fileType = splitData [(splitData .length)-1];
		
		  for (int j = 0; j < Extension.length; j++) {
			  if (fileType.equals(Extension[j])) {
				  return true;
			  }
		}
		 return false;
		
	}
	
	
}
