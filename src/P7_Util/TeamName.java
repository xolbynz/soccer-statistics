package P7_Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import P0_����.OracleURL;

public class TeamName {
	private static String sql;
	private static int cnt;
	private static Connection conn;
	private static PreparedStatement pst;
	private static ResultSet rs;

	private static void con() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = OracleURL.url;
			String user = OracleURL.id;
			String password = OracleURL.pw;


			conn = DriverManager.getConnection(url, user, password);

			if (conn != null) {
				System.out.print("���Ἲ��->");
			} else {
				System.out.println("�������->");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void close() {
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
				System.out.print("conn����->");
			}
			System.out.println("Ŭ���");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getTeamName(int playerCode) {
		con();
		
		String result = "";
		
		try {
			sql = "select GROUP_NAME from GROUPS where GROUP_CODE = (select GROUP_CODE from PLAYER where PLAYER_CODE = ?)";
			
			pst = conn.prepareStatement(sql);
			pst.setInt(1, playerCode);
			
			rs = pst.executeQuery();
			
			while (rs.next()) {
				result = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		close();
		
		return result;
	}
	
	public static String getTransferTeamName(int playerCode) {
		con();
		
		String result = "";
		
		try {
			sql = "select GROUP_NAME from GROUPS where GROUP_CODE = (select TRANSFER_GROUP_CODE from PLAYER_TRANSFER where PLAYER_CODE = ? and PLAYER_TRANSFER_STATE = 0)";
			
			pst = conn.prepareStatement(sql);
			pst.setInt(1, playerCode);
			
			rs = pst.executeQuery();
			
			while (rs.next()) {
				result = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		close();
		
		return result;
	}
	
	public static String getNowTeamName(int playerCode) {
		con();
		
		String result = "";
		
		try {
			sql = "select GROUP_NAME from GROUPS where GROUP_CODE = (select NOW_GROUP_CODE from PLAYER_TRANSFER where PLAYER_CODE = ? and PLAYER_TRANSFER_STATE = 0)";
			
			pst = conn.prepareStatement(sql);
			pst.setInt(1, playerCode);
			
			rs = pst.executeQuery();
			
			while (rs.next()) {
				result = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		close();
		
		return result;
	}

}
