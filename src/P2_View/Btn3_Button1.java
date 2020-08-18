package P2_View;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import P3_DAO.GroupsDAO;
import P3_DAO.PlayerDAO;
import P3_DAO.Player_FootballDAO;
import P4_DTO.GroupsDTO;
import P4_DTO.Player_FootballDTO;
import P4_DTO.loginDTO;

import javax.swing.JScrollPane;
import java.awt.Cursor;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Btn3_Button1 extends JPanel implements FocusListener {
	private JTextField textField;
	private JFrame frame;
	private loginDTO dto;

	
	private GroupsDAO g_dao = new GroupsDAO();
	

	/**
	 * Create the panel.
	 */
	public Btn3_Button1(JFrame frame, loginDTO dto) {
		this.frame = frame;
		this.dto = dto;
		
				
		
		setLayout(new CardLayout(0, 0));

		JPanel Lobby_Panel = new JPanel();
		add(Lobby_Panel, "name_858723623119300");
		Lobby_Panel.setLayout(null);

		JPanel LeftLobbyPanel = new JPanel();
		LeftLobbyPanel.setBackground(new Color(41, 57, 80));
		LeftLobbyPanel.setBounds(0, 0, 280, 900);
		Lobby_Panel.add(LeftLobbyPanel);
		LeftLobbyPanel.setLayout(null);

		JPanel ProgramNamePanel = new JPanel();
		ProgramNamePanel.setBackground(new Color(41, 57, 80));
		ProgramNamePanel.setBounds(0, 0, 280, 34);
		LeftLobbyPanel.add(ProgramNamePanel);
		ProgramNamePanel.setLayout(new CardLayout(0, 0));

		JLabel lbl_program_name = new JLabel(
				"\uC720\uC18C\uB144\uCD95\uAD6C \uC131\uC7A5\uAD00\uB9AC \uD504\uB85C\uADF8\uB7A8");
		lbl_program_name.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		lbl_program_name.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					JPanel Stn0_Button0 = new Lobby(frame, dto);
					frame.getContentPane().removeAll();
					frame.getContentPane().add(Stn0_Button0);
					frame.revalidate();
					frame.repaint();
			}
		});
		
		lbl_program_name.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_program_name.setFont(new Font("°í¾çÃ¼", Font.PLAIN, 20));
		lbl_program_name.setForeground(new Color(255, 255, 255));
		ProgramNamePanel.add(lbl_program_name, "name_53851796879200");
		
		JPanel ProfilePanel = new JPanel();
		ProfilePanel.setBackground(new Color(71, 120, 197));
		ProfilePanel.setBounds(0, 158, 280, 100);
		LeftLobbyPanel.add(ProfilePanel);
		ProfilePanel.setLayout(null);

		JPanel Profile_ImagePanel = new JPanel();
		Profile_ImagePanel.setBackground(new Color(84, 125, 206));
		Profile_ImagePanel.setBounds(0, 0, 100, 100);
		ProfilePanel.add(Profile_ImagePanel);
		Profile_ImagePanel.setLayout(new CardLayout(0, 0));

		JLabel lbl_profileImg = new JLabel(new ImageIcon(dto.getMember_ResizeImg(100, 100)));
		lbl_profileImg.setHorizontalAlignment(SwingConstants.CENTER);
		Profile_ImagePanel.add(lbl_profileImg, "name_54594167799700");

		JPanel Profile_Nickname = new JPanel();
		Profile_Nickname.setBackground(new Color(84, 125, 206));
		Profile_Nickname.setBounds(100, 0, 180, 100);
		ProfilePanel.add(Profile_Nickname);
		Profile_Nickname.setLayout(null);

		JLabel label_1 = new JLabel(dto.getMember_Nickname());
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("KBIZÇÑ¸¶À½°íµñ B", Font.PLAIN, 16));
		label_1.setBounds(30, 38, 100, 25);
		Profile_Nickname.add(label_1);
		
		JPanel btn_1 = new JPanel();
		btn_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_1.setBackground(new Color(41, 57, 80));
		btn_1.setBounds(0, 361, 300, 80);
		LeftLobbyPanel.add(btn_1);
		btn_1.setLayout(null);
		
		JLabel lbl_btn1 = new JLabel("\uC120\uC218\uAD00\uB9AC");
		lbl_btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel Stn1_Button1 = new Btn1_Button1(frame,dto);	
				frame.getContentPane().removeAll();	
				frame.getContentPane().add(Stn1_Button1);
				frame.revalidate();
				frame.repaint();	
			}
		});
		lbl_btn1.setBounds(87, 30, 87, 24);
		lbl_btn1.setFont(new Font("KBIZÇÑ¸¶À½°íµñ H", Font.PLAIN, 20));
		lbl_btn1.setForeground(new Color(255, 255, 255));
		btn_1.add(lbl_btn1);
		
		JPanel ExitPanel = new JPanel();
		ExitPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ExitPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		ExitPanel.setBackground(new Color(41, 57, 80));
		ExitPanel.setBounds(0, 820, 300, 80);
		LeftLobbyPanel.add(ExitPanel);
		ExitPanel.setLayout(null);
		
		JPanel ExitIconPanel = new JPanel();
		ExitIconPanel.setBackground(new Color(41, 57, 80));
		ExitIconPanel.setBounds(0, 0, 76, 80);
		ExitPanel.add(ExitIconPanel);
		ExitIconPanel.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(Btn3_Button1.class.getResource("/P5_Img/icons8_exit_32px.png")));
		ExitIconPanel.add(lblNewLabel_1, "name_58332631504300");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(41, 57, 80));
		panel_1.setBounds(74, 0, 226, 80);
		ExitPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("\uB098\uAC00\uAE30");
		lblNewLabel_2.setBounds(0, 10, 111, 60);
		lblNewLabel_2.setFont(new Font("KBIZÇÑ¸¶À½°íµñ B", Font.BOLD, 20));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_2);
		
		JPanel SearchPanel = new JPanel();
		SearchPanel.setBackground(new Color(41,57,80));
		SearchPanel.setBounds(0, 59, 300, 54);
		LeftLobbyPanel.add(SearchPanel);
		SearchPanel.setLayout(null);
		
		JPanel SearchIconPanel = new JPanel();
		SearchIconPanel.setBounds(12, 10, 32, 32);
		SearchIconPanel.setBackground(new Color(41,57,80));
		SearchPanel.add(SearchIconPanel);
		SearchIconPanel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 32, 32);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(Btn3_Button1.class.getResource("/P5_Img/icons8_search_32px.png")));
		
		SearchIconPanel.add(label);
		
		JPanel SearchTxtPanel = new JPanel();
		SearchTxtPanel.setBounds(46, 0, 254, 68);
		SearchTxtPanel.setBackground(new Color(41,57,80));
		SearchPanel.add(SearchTxtPanel);
		SearchTxtPanel.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("KBIZÇÑ¸¶À½°íµñ B", Font.PLAIN, 14));
		textField.setForeground(new Color(255, 255, 255));
		textField.setBorder(null);
		textField.setBackground(new Color(41, 57, 80));
		textField.setBounds(12, 10, 210, 28);
		SearchTxtPanel.add(textField);
		textField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		separator.setBounds(12, 49, 210, 2);
		SearchTxtPanel.add(separator);
		
		JPanel btn_2 = new JPanel();
		btn_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel Stn2_Button1 = new Btn2_Button1(frame,dto);
				frame.getContentPane().removeAll();
				frame.getContentPane().add(Stn2_Button1);
				frame.revalidate();
				frame.repaint();
			}
		});
		btn_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_2.setLayout(null);
		btn_2.setBackground(new Color(41, 57, 80));
		btn_2.setBounds(0, 439, 300, 80);
		LeftLobbyPanel.add(btn_2);
		
		JLabel lbl_btn2 = new JLabel("\uAD6C\uB2E8\uAD00\uB9AC");
		lbl_btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel Stn2_Button1 = new Btn2_Button1(frame,dto);	
				frame.getContentPane().removeAll();	
				frame.getContentPane().add(Stn2_Button1);
				frame.revalidate();
				frame.repaint();	
			}
		});
		lbl_btn2.setForeground(Color.WHITE);
		lbl_btn2.setFont(new Font("KBIZÇÑ¸¶À½°íµñ H", Font.PLAIN, 20));
		lbl_btn2.setBounds(87, 30, 87, 24);
		btn_2.add(lbl_btn2);
		
		JPanel btn_3 = new JPanel();
		btn_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_3.setLayout(null);
		btn_3.setBackground(new Color(255,255,255,20));
		btn_3.setBounds(0, 517, 300, 80);
		LeftLobbyPanel.add(btn_3);
		
		JLabel lbl_btn3 = new JLabel("\uAD6C\uB2E8\uBAA9\uB85D");
		lbl_btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel Stn3_Button1 = new Btn3_Button1(frame,dto);	
				frame.getContentPane().removeAll();	
				frame.getContentPane().add(Stn3_Button1);
				frame.revalidate();
				frame.repaint();	
			}
		});
		lbl_btn3.setForeground(Color.WHITE);
		lbl_btn3.setFont(new Font("KBIZÇÑ¸¶À½°íµñ H", Font.PLAIN, 20));
		lbl_btn3.setBounds(87, 30, 87, 24);
		btn_3.add(lbl_btn3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 5, 80);
		btn_3.add(panel_2);
		panel_2.setBackground(Color.WHITE);
		
		JPanel btn4 = new JPanel();
		btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel Stn4_Button1 = new Btn4_Button1(frame,dto);	
				frame.getContentPane().removeAll();	
				frame.getContentPane().add(Stn4_Button1);
				frame.revalidate();
				frame.repaint();	
			}
		});
		btn4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn4.setLayout(null);
		btn4.setBackground(new Color(41, 57, 80));
		btn4.setBounds(0, 595, 300, 80);
		LeftLobbyPanel.add(btn4);
		
		JLabel lbl_btn4 = new JLabel("\uAC1C\uC778\uC124\uC815");
		lbl_btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JPanel Stn4_Button1 = new Btn4_Button1(frame,dto);	
				frame.getContentPane().removeAll();	
				frame.getContentPane().add(Stn4_Button1);
				frame.revalidate();
				frame.repaint();	
			}
		});
		lbl_btn4.setForeground(Color.WHITE);
		lbl_btn4.setFont(new Font("KBIZÇÑ¸¶À½°íµñ H", Font.PLAIN, 20));
		lbl_btn4.setBounds(87, 30, 87, 24);
		btn4.add(lbl_btn4);
		
		JPanel GudanPanel = new JPanel();
		GudanPanel.setBackground(new Color(71, 120, 197));
		GudanPanel.setBounds(280, 0, 1320, 105);
		Lobby_Panel.add(GudanPanel);
		GudanPanel.setLayout(null);
		
		JPanel LogoPanel = new JPanel();
		LogoPanel.setBackground(new Color(71, 120, 197));
		LogoPanel.setBounds(42, 0, 111, 105);
		GudanPanel.add(LogoPanel);
		LogoPanel.setLayout(new CardLayout(0, 0));
		
		JLabel lbl_logo = new JLabel("");
		lbl_logo.setIcon(new ImageIcon(Btn3_Button1.class.getResource("/P5_Img/icons8_uefa_euro_trophy_64px.png")));
		lbl_logo.setHorizontalAlignment(SwingConstants.CENTER);
		LogoPanel.add(lbl_logo, "name_60328911748400");
		
		JPanel GudanName = new JPanel();
		GudanName.setBackground(new Color(71, 120, 197));
		GudanName.setBounds(153, 0, 118, 105);
		GudanPanel.add(GudanName);
		GudanName.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC6CC\uB9AC\uC5B4\uC988");
		lblNewLabel.setBounds(0, 31, 146, 34);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("KBIZÇÑ¸¶À½°íµñ H", Font.PLAIN, 25));
		GudanName.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(280, 105, 1320, 796);
		Lobby_Panel.add(panel_3);
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(255, 255, 255));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(100, 100, 100, 100);
		panel_3.add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		
		
		ArrayList<GroupsDTO> group = new ArrayList<GroupsDTO>();
		GroupsDAO gdao = new GroupsDAO();
		//group = gdao.SearchGroups(Group_Name)
		
	
		JLabel lblNewLabel_4 = new JLabel(new ImageIcon(g_dao.selectAllGroups().get(0).getGroup_ResizeImg(100, 100)));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_4, "name_198922903194058");
		

		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(230, 100, 300, 100);
		panel_3.add(panel_4);
		panel_4.setLayout(new CardLayout(0, 0));
		
		
		
		
		JLabel lblNewLabel_3 = new JLabel();
		lblNewLabel_3.setFont(new Font("KBIZÇÑ¸¶À½°íµñ B", Font.PLAIN, 30));
		lblNewLabel_3.setText(g_dao.selectAllGroups().get(0).getGroup_Name());
		panel_4.add(lblNewLabel_3, "name_15321846016200");
	
		
		
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(230, 230, 250));
		panel_5.setBounds(100, 282, 100, 100);
		panel_3.add(panel_5);
		panel_5.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel_5 = new JLabel(new ImageIcon(g_dao.selectAllGroups().get(2).getGroup_ResizeImg(100, 100)));
		panel_5.add(lblNewLabel_5, "name_198961159649177");
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 255));
		panel_6.setBounds(230, 282, 300, 100);
		panel_3.add(panel_6);
		panel_6.setLayout(new CardLayout(0, 0));
		
		JLabel label_2 = new JLabel("\uB9AC\uBC84\uD480");
		label_2.setFont(new Font("KBIZÇÑ¸¶À½°íµñ B", Font.PLAIN, 30));
		label_2.setText(g_dao.selectAllGroups().get(2).getGroup_Name());
		panel_6.add(label_2, "name_15459494065600");
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(230, 230, 250));
		panel_7.setBounds(100, 463, 100, 100);
		panel_3.add(panel_7);
		panel_7.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel_8 = new JLabel(new ImageIcon(g_dao.selectAllGroups().get(4).getGroup_ResizeImg(100, 100)));
		panel_7.add(lblNewLabel_8, "name_198980439524340");
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 255, 255));
		panel_8.setBounds(230, 463, 300, 100);
		panel_3.add(panel_8);
		panel_8.setLayout(new CardLayout(0, 0));
		
		JLabel label_3 = new JLabel();
		label_3.setFont(new Font("KBIZÇÑ¸¶À½°íµñ B", Font.PLAIN, 30));
		label_3.setText(g_dao.selectAllGroups().get(4).getGroup_Name());
		panel_8.add(label_3, "name_15460350012500");
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(230, 230, 250));
		panel_9.setBounds(100, 644, 100, 100);
		panel_3.add(panel_9);
		panel_9.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel_10 = new JLabel(new ImageIcon(g_dao.selectAllGroups().get(6).getGroup_ResizeImg(100, 100)));
		panel_9.add(lblNewLabel_10, "name_198990007706746");
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(255, 255, 255));
		panel_10.setBounds(230, 644, 300, 100);
		panel_3.add(panel_10);
		panel_10.setLayout(new CardLayout(0, 0));
		
		JLabel label_4 = new JLabel("\uB9AC\uBC84\uD480");
		label_4.setFont(new Font("KBIZÇÑ¸¶À½°íµñ B", Font.PLAIN, 30));
		label_4.setText(g_dao.selectAllGroups().get(6).getGroup_Name());
		panel_10.add(label_4, "name_15461086020500");
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(230, 230, 250));
		panel_11.setBounds(684, 100, 100, 100);
		panel_3.add(panel_11);
		panel_11.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel_6 = new JLabel(new ImageIcon(g_dao.selectAllGroups().get(1).getGroup_ResizeImg(100, 100)));
		panel_11.add(lblNewLabel_6, "name_198966831618368");
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(new Color(255, 255, 255));
		panel_12.setBounds(814, 100, 300, 100);
		panel_3.add(panel_12);
		panel_12.setLayout(new CardLayout(0, 0));
		
		JLabel label_8 = new JLabel();
		label_8.setFont(new Font("KBIZÇÑ¸¶À½°íµñ B", Font.PLAIN, 30));
		label_8.setText(g_dao.selectAllGroups().get(1).getGroup_Name());
		panel_12.add(label_8, "name_15463829951800");
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(230, 230, 250));
		panel_13.setBounds(684, 282, 100, 100);
		panel_3.add(panel_13);
		panel_13.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel_7 = new JLabel(new ImageIcon(g_dao.selectAllGroups().get(3).getGroup_ResizeImg(100, 100)));
		panel_13.add(lblNewLabel_7, "name_198972239452148");
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(new Color(255, 255, 255));
		panel_14.setBounds(814, 282, 300, 100);
		panel_3.add(panel_14);
		panel_14.setLayout(new CardLayout(0, 0));
		
		JLabel label_7 = new JLabel("\uB9AC\uBC84\uD480");
		label_7.setFont(new Font("KBIZÇÑ¸¶À½°íµñ B", Font.PLAIN, 30));
		label_7.setText(g_dao.selectAllGroups().get(3).getGroup_Name());
		panel_14.add(label_7, "name_15463119296900");
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(new Color(230, 230, 250));
		panel_15.setBounds(684, 463, 100, 100);
		panel_3.add(panel_15);
		panel_15.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel_9 = new JLabel(new ImageIcon(g_dao.selectAllGroups().get(5).getGroup_ResizeImg(100, 100)));
		panel_15.add(lblNewLabel_9, "name_198986631736185");
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(new Color(255, 255, 255));
		panel_16.setBounds(814, 463, 300, 100);
		panel_3.add(panel_16);
		panel_16.setLayout(new CardLayout(0, 0));
		
		JLabel label_6 = new JLabel("\uB9AC\uBC84\uD480");
		label_6.setFont(new Font("KBIZÇÑ¸¶À½°íµñ B", Font.PLAIN, 30));
		label_6.setText(g_dao.selectAllGroups().get(5).getGroup_Name());
		panel_16.add(label_6, "name_15462460089200");
		
		JPanel panel_17 = new JPanel();
		panel_17.setBackground(new Color(230, 230, 250));
		panel_17.setBounds(684, 644, 100, 100);
		panel_3.add(panel_17);
		panel_17.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel_11 = new JLabel(new ImageIcon(g_dao.selectAllGroups().get(7).getGroup_ResizeImg(100, 100)));
		panel_17.add(lblNewLabel_11, "name_198993887574627");
		
		JPanel panel_18 = new JPanel();
		panel_18.setBackground(new Color(255, 255, 255));
		panel_18.setBounds(814, 644, 300, 100);
		panel_3.add(panel_18);
		panel_18.setLayout(new CardLayout(0, 0));
		
		JLabel label_5 = new JLabel("\uB9AC\uBC84\uD480");
		label_5.setFont(new Font("KBIZÇÑ¸¶À½°íµñ B", Font.PLAIN, 30));
		label_5.setText(g_dao.selectAllGroups().get(7).getGroup_Name());
		panel_18.add(label_5, "name_15461774006600");
		

	}

	@Override
	public void focusGained(FocusEvent e) {
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
}
