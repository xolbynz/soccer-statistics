package P2_View;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import P3_DAO.ChartDAO;
import P3_DAO.GroupsDAO;
import P3_DAO.Player_ContestDAO;
import P3_DAO.Player_FootballDAO;
import P4_DTO.GroupsDTO;
import P4_DTO.PlayerContestDTO;
import P4_DTO.Player_FootballDTO;
import P4_DTO.loginDTO;

import javax.swing.JScrollPane;
import java.awt.Cursor;

public class Lobby extends JPanel {
	private JTextField textField;

	JFrame frame;
	loginDTO dto;
	PlayerContestDTO condto;
	Player_ContestDAO condao = new Player_ContestDAO();
	GroupsDTO gdto;
	GroupsDAO gdao = new GroupsDAO();
	public Lobby(JFrame frame, loginDTO dto) {
		this.frame = frame;
		this.dto = dto;
		
		ArrayList<PlayerContestDTO> arr_contest = new ArrayList<>();
		ArrayList<GroupsDTO> arr_group = new ArrayList<>();
		arr_group= gdao.selectAllGroups_Groupcode(dto.getGroup_Code());
		
		arr_contest = condao.selectAllGroup(dto.getGroup_Code()); // 풋볼코드를 안에 값으로 수정해야함!!!
		int data[][] = new int[arr_contest.size()][5];
		for (int i = 0; i < data.length; i++) {
			data[i][0] = arr_contest.get(i).getPlayer_Contest_Shot();
			data[i][1] = arr_contest.get(i).getPlayer_Contest_EffectiveShot();
			data[i][2] = arr_contest.get(i).getPlayer_Contest_Goal();
			data[i][3] = arr_contest.get(i).getPlayer_Contest_Assist();
			data[i][4] = arr_contest.get(i).getPlayer_Contest_RunningTime();
		}
		
		int[] sum = new int[5];
		
		for (int i = 0; i < sum.length; i++) {
			for (int j = 0; j < arr_contest.size(); j++) {
				sum[i] += data[j][i];
			}
		}
		ChartDAO cdao = new ChartDAO();

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
		lbl_program_name.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_program_name.setFont(new Font("고양체", Font.PLAIN, 20));
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
		label_1.setFont(new Font("KBIZ한마음고딕 B", Font.PLAIN, 16));
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
			public void mouseClicked(MouseEvent arg0) {
				JPanel Stn1_Button1 = new Btn1_Button1(frame, dto);
				frame.getContentPane().removeAll();
				frame.getContentPane().add(Stn1_Button1);
				frame.revalidate();
				frame.repaint();

			}
		});
		lbl_btn1.setBounds(87, 30, 87, 24);
		lbl_btn1.setFont(new Font("KBIZ한마음고딕 H", Font.PLAIN, 20));
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
		lblNewLabel_1.setIcon(new ImageIcon(Lobby.class.getResource("/P5_Img/icons8_exit_32px.png")));
		ExitIconPanel.add(lblNewLabel_1, "name_58332631504300");

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(41, 57, 80));
		panel_1.setBounds(74, 0, 226, 80);
		ExitPanel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("\uB098\uAC00\uAE30");
		lblNewLabel_2.setBounds(0, 10, 111, 60);
		lblNewLabel_2.setFont(new Font("KBIZ한마음고딕 B", Font.BOLD, 20));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_2);

		JPanel SearchPanel = new JPanel();
		SearchPanel.setBackground(new Color(41, 57, 80));
		SearchPanel.setBounds(0, 59, 300, 54);
		LeftLobbyPanel.add(SearchPanel);
		SearchPanel.setLayout(null);

		JPanel SearchIconPanel = new JPanel();
		SearchIconPanel.setBounds(12, 10, 32, 32);
		SearchIconPanel.setBackground(new Color(41, 57, 80));
		SearchPanel.add(SearchIconPanel);
		SearchIconPanel.setLayout(null);

		JLabel label = new JLabel("");
		label.setBounds(0, 0, 32, 32);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(Lobby.class.getResource("/P5_Img/icons8_search_32px.png")));

		SearchIconPanel.add(label);

		JPanel SearchTxtPanel = new JPanel();
		SearchTxtPanel.setBounds(46, 0, 254, 68);
		SearchTxtPanel.setBackground(new Color(41, 57, 80));
		SearchPanel.add(SearchTxtPanel);
		SearchTxtPanel.setLayout(null);

		textField = new JTextField();
		textField.setFont(new Font("KBIZ한마음고딕 B", Font.PLAIN, 14));
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
		btn_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_2.setLayout(null);
		btn_2.setBackground(new Color(41, 57, 80));
		btn_2.setBounds(0, 439, 300, 80);
		LeftLobbyPanel.add(btn_2);

		JLabel lbl_btn2 = new JLabel("\uAD6C\uB2E8\uAD00\uB9AC");
		lbl_btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel Stn2_Button1 = new Btn2_Button1(frame, dto);
				frame.getContentPane().removeAll();
				frame.getContentPane().add(Stn2_Button1);
				frame.revalidate();
				frame.repaint();
			}
		});
		lbl_btn2.setForeground(Color.WHITE);
		lbl_btn2.setFont(new Font("KBIZ한마음고딕 H", Font.PLAIN, 20));
		lbl_btn2.setBounds(87, 30, 87, 24);
		btn_2.add(lbl_btn2);

		JPanel btn_3 = new JPanel();
		btn_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_3.setLayout(null);
		btn_3.setBackground(new Color(41, 57, 80));
		btn_3.setBounds(0, 517, 300, 80);
		LeftLobbyPanel.add(btn_3);

		JLabel lbl_btn3 = new JLabel("\uAD6C\uB2E8\uBAA9\uB85D");
		lbl_btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel Stn3_Button1 = new Btn3_Button1(frame, dto);
				frame.getContentPane().removeAll();
				frame.getContentPane().add(Stn3_Button1);
				frame.revalidate();
				frame.repaint();
			}
		});
		lbl_btn3.setForeground(Color.WHITE);
		lbl_btn3.setFont(new Font("KBIZ한마음고딕 H", Font.PLAIN, 20));
		lbl_btn3.setBounds(87, 30, 87, 24);
		btn_3.add(lbl_btn3);

		JPanel btn4 = new JPanel();
		btn4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn4.setLayout(null);
		btn4.setBackground(new Color(41, 57, 80));
		btn4.setBounds(0, 595, 300, 80);
		LeftLobbyPanel.add(btn4);

		JLabel lbl_btn4 = new JLabel("\uAC1C\uC778\uC124\uC815");
		lbl_btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel Stn4_Button1 = new Btn4_Button1(frame, dto);
				frame.getContentPane().removeAll();
				frame.getContentPane().add(Stn4_Button1);
				frame.revalidate();
				frame.repaint();

			}
		});
		lbl_btn4.setForeground(Color.WHITE);
		lbl_btn4.setFont(new Font("KBIZ한마음고딕 H", Font.PLAIN, 20));
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

		JPanel GudanName = new JPanel();
		GudanName.setBackground(new Color(71, 120, 197));
		GudanName.setBounds(153, 0, 651, 105);
		GudanPanel.add(GudanName);
		GudanName.setLayout(null);

		JLabel lblNewLabel = new JLabel("\uC6CC\uB9AC\uC5B4\uC988");
		lblNewLabel.setBounds(0, 22, 420, 61);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("KBIZ한마음고딕 H", Font.PLAIN, 35));
		lblNewLabel.setText(arr_group.get(0).getGroup_Name());
		GudanName.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(280, 104, 1320, 796);
		Lobby_Panel.add(panel);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(90, 50, 180, 180);
		panel.add(panel_2);
		panel_2.setLayout(new CardLayout(0, 0));
		
		JLabel lbl_image = new JLabel();
		panel_2.add(lbl_image, "name_29978528592830");
		lbl_image.setIcon(new ImageIcon(arr_group.get(0).getGroup_ResizeImg(180, 180)));
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(411, 39, 572, 231);
		panel.add(panel_4);

		JLabel label_4 = new JLabel("\uAD6C\uB2E8\uC774\uB984");
		label_4.setForeground(new Color(153, 153, 153));
		label_4.setFont(new Font("만화진흥원체", Font.PLAIN, 16));
		label_4.setBounds(12, 10, 71, 32);
		panel_4.add(label_4);

		JLabel label_5 = new JLabel("\uC6CC\uB9AC\uC5B4\uC988");
		
		label_5.setForeground(new Color(189, 178, 137));
		label_5.setFont(new Font("만화진흥원체", Font.PLAIN, 35));
		label_5.setBounds(12, 52, 410, 40);
		label_5.setText(arr_group.get(0).getGroup_Name());
		panel_4.add(label_5);

		JLabel label_6 = new JLabel("\uC9C0\uC5ED");
		label_6.setForeground(new Color(153, 153, 153));
		label_6.setFont(new Font("만화진흥원체", Font.PLAIN, 16));
		label_6.setBounds(436, 10, 48, 32);
		panel_4.add(label_6);

		JLabel label_2 = new JLabel("\uC8FC\uC18C");
		label_2.setForeground(new Color(153, 153, 153));
		label_2.setFont(new Font("만화진흥원체", Font.PLAIN, 16));
		label_2.setBounds(12, 141, 60, 32);
		panel_4.add(label_2);

		JLabel label_3 = new JLabel(
				"\uAD11\uC8FC\uAD11\uC5ED\uC2DC \uB0A8\uAD6C \uC1A1\uC554\uB85C 60 \uAD11\uC8FC CGI \uC13C\uD130");
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("만화진흥원체", Font.PLAIN, 16));
		label_3.setBounds(12, 183, 548, 19);
		label_3.setText(arr_group.get(0).getGroup_Address());
		panel_4.add(label_3);

		JLabel label_17 = new JLabel("\uAD6C\uB2E8 \uC2A4\uD0EF");
		label_17.setForeground(Color.BLACK);
		label_17.setFont(new Font("만화진흥원체", Font.PLAIN, 35));
		label_17.setBounds(90, 317, 192, 45);
		panel.add(label_17);

		JLabel label_29 = new JLabel("\uB300\uD68C \uC131\uC801");
		label_29.setForeground(Color.BLACK);
		label_29.setFont(new Font("만화진흥원체", Font.PLAIN, 25));
		label_29.setBounds(118, 400, 139, 45);
		panel.add(label_29);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(229, 229, 229));
		separator_2.setBounds(118, 455, 449, 10);
		panel.add(separator_2);

		JLabel label_30 = new JLabel("");
		label_30.setForeground(new Color(189, 178, 137));
		label_30.setFont(new Font("만화진흥원체", Font.PLAIN, 35));
		label_30.setBounds(153, 475, 92, 32);
		label_30.setText(sum[2]+"");
		panel.add(label_30);

		JLabel label_31 = new JLabel("\uACE8");
		label_31.setForeground(new Color(153, 153, 153));
		label_31.setFont(new Font("만화진흥원체", Font.PLAIN, 16));
		label_31.setBounds(153, 517, 48, 32);
		panel.add(label_31);

		JLabel label_32 = new JLabel("");
		label_32.setForeground(new Color(189, 178, 137));
		label_32.setFont(new Font("만화진흥원체", Font.PLAIN, 35));
		label_32.setBounds(316, 475, 78, 32);
		label_32.setText(sum[3]+"");
		panel.add(label_32);

		JLabel label_33 = new JLabel("\uC5B4\uC2DC\uC2A4\uD2B8");
		label_33.setForeground(new Color(153, 153, 153));
		label_33.setFont(new Font("만화진흥원체", Font.PLAIN, 16));
		label_33.setBounds(316, 517, 104, 32);
		panel.add(label_33);

		JLabel label_34 = new JLabel("");
		label_34.setForeground(new Color(189, 178, 137));
		label_34.setFont(new Font("만화진흥원체", Font.PLAIN, 35));
		label_34.setBounds(316, 594, 92, 32);
		label_34.setText(sum[1]+"");
		panel.add(label_34);

		JLabel label_35 = new JLabel("\uC720\uD6A8\uC29B");
		label_35.setForeground(new Color(153, 153, 153));
		label_35.setFont(new Font("만화진흥원체", Font.PLAIN, 16));
		label_35.setBounds(316, 636, 48, 32);
		panel.add(label_35);

		JLabel label_36 = new JLabel("");
		label_36.setForeground(new Color(189, 178, 137));
		label_36.setFont(new Font("만화진흥원체", Font.PLAIN, 35));
		label_36.setBounds(153, 594, 104, 32);
		label_36.setText(sum[0]+"");
		panel.add(label_36);

		JLabel label_37 = new JLabel("\uC29B");
		label_37.setForeground(new Color(153, 153, 153));
		label_37.setFont(new Font("만화진흥원체", Font.PLAIN, 16));
		label_37.setBounds(153, 636, 48, 32);
		panel.add(label_37);

		JLabel label_38 = new JLabel("");
		label_38.setForeground(new Color(189, 178, 137));
		label_38.setFont(new Font("만화진흥원체", Font.PLAIN, 35));
		label_38.setBounds(460, 479, 92, 32);
		label_38.setText(sum[4]+"");
		panel.add(label_38);

		JLabel label_39 = new JLabel("\uD65C\uB3D9\uB7C9");
		label_39.setForeground(new Color(153, 153, 153));
		label_39.setFont(new Font("만화진흥원체", Font.PLAIN, 16));
		label_39.setBounds(460, 521, 48, 32);
		panel.add(label_39);

		System.out.println(arr_contest.size());
		JFreeChart bar_chart = cdao.getChart_Contest(arr_contest);
		ChartPanel CP_contest = new ChartPanel(bar_chart);
		CP_contest.setBackground(new Color(255, 255, 255));
		
		JPanel barchart_panel = new JPanel();
		barchart_panel.setBackground(Color.WHITE);
		barchart_panel.setBounds(685, 400, 500, 320);
		panel.add(barchart_panel);
		barchart_panel.setLayout(new CardLayout(0, 0));
		barchart_panel.add(CP_contest, "name_101100506765300");
		CP_contest.setLayout(new CardLayout(0, 0));
		barchart_panel.validate();
		
		JLabel label_7 = new JLabel("\uAD11\uC8FC\uAD11\uC5ED\uC2DC");
		label_7.setForeground(new Color(189, 178, 137));
		label_7.setFont(new Font("만화진흥원체", Font.PLAIN, 35));
		label_7.setBounds(434, 52, 157, 40);
		String local = arr_group.get(0).getGroup_Address();
		label_7.setText(local.substring(0, 2));
		panel_4.add(label_7);
	}
}