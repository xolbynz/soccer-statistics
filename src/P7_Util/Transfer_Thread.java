package P7_Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;

import P0_사용법.OracleURL;
import P2_View.Btn2_Button1;
import P4_DTO.loginDTO;

public class Transfer_Thread extends Thread {
	private String sql;
	private int cnt;
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	private JFrame frame;
	private loginDTO dto;

	int count1;
	int count1_2;
	int count2;
	int count2_2;

	int Group_Code;

	boolean go = true;

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

	public void close() {
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
			if (go != false) {
				go = false;
				System.out.print("쓰레드해제->");
			}
			System.out.println("클로즈끝");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Transfer_Thread(JFrame frame, loginDTO dto) {
		this.Group_Code = dto.getGroup_Code();
		this.frame = frame;
		this.dto = dto;

		con();
		try {
			sql = "select count(NOW_GROUP_CODE) t1, count(TRANSFER_GROUP_CODE) t2 from PLAYER_TRANSFER where (NOW_GROUP_CODE = ? or TRANSFER_GROUP_CODE = ?) and PLAYER_TRANSFER_STATE = 0";

			pst = conn.prepareStatement(sql);
			pst.setInt(1, Group_Code);
			pst.setInt(2, Group_Code);

			rs = pst.executeQuery();

			while (rs.next()) {
				count1 = rs.getInt(1);
				count2 = rs.getInt(2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (go) {
			try {
				Thread.sleep(5000);

				sql = "select count(NOW_GROUP_CODE) t1, count(TRANSFER_GROUP_CODE)t2 from PLAYER_TRANSFER where NOW_GROUP_CODE = ? or TRANSFER_GROUP_CODE = ?";

				pst = conn.prepareStatement(sql);
				pst.setInt(1, Group_Code);
				pst.setInt(2, Group_Code);

				rs = pst.executeQuery();

				while (rs.next()) {
					count1_2 = rs.getInt(1);
					count2_2 = rs.getInt(2);
				}

				if (count1 != count1_2 || count2 != count2_2) {
					count1 = count1_2;
					count2 = count2_2;
					
					JPanel Stn1_Button2 = new Btn2_Button1(frame, dto);
					frame.getContentPane().removeAll();
					frame.getContentPane().add(Stn1_Button2);
					frame.revalidate();
					frame.repaint();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
