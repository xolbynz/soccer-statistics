package P2_View;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import P3_DAO.ChartDAO;
import P3_DAO.PlayerDAO;
import P3_DAO.Player_ContestDAO;
import P3_DAO.Player_FootballDAO;
import P3_DAO.Player_MedicalDAO;
import P3_DAO.Player_PhysicalDAO;
import P3_DAO.Player_PositionDAO;
import P4_DTO.PlayerContestDTO;
import P4_DTO.PlayerDTO;
import P4_DTO.PlayerMedicalDTO;
import P4_DTO.PlayerPhysicalDTO;
import P4_DTO.Player_FootballDTO;
import P4_DTO.loginDTO;

public class Btn1_Button2 extends JPanel {
	private JTextField textField;
	private loginDTO dto;
	private JFrame frame;
	private int PLAYER_CODE;
	private PlayerDTO p_dto;
	private PlayerDAO p_dao = new PlayerDAO();

	/**
	 * Create the panel.
	 */
	public Btn1_Button2(JFrame frame, loginDTO dto, int PLAYER_CODE) {
		this.frame = frame;
		this.dto = dto;
		this.PLAYER_CODE = PLAYER_CODE;
		p_dto = p_dao.SelectPlayer(PLAYER_CODE);
		ArrayList<Player_FootballDTO> ArrFootball = new ArrayList<>();
		Player_FootballDAO fdao = new Player_FootballDAO();
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
		btn_1.setBackground(new Color(255, 255, 255, 20));
		btn_1.setBounds(0, 361, 300, 80);
		LeftLobbyPanel.add(btn_1);
		btn_1.setLayout(null);

		JLabel lbl_btn1 = new JLabel("\uC120\uC218\uAD00\uB9AC");
		lbl_btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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

		JPanel btn4_deco = new JPanel();
		btn4_deco.setBounds(0, 0, 5, 80);
		btn_1.add(btn4_deco);
		btn4_deco.setBackground(Color.WHITE);

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
		lblNewLabel_1.setIcon(new ImageIcon(Btn1_Button2.class.getResource("/P5_Img/icons8_exit_32px.png")));
		ExitIconPanel.add(lblNewLabel_1, "name_58332631504300");

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(41, 57, 80));
		panel_1.setBounds(74, 0, 226, 80);
		ExitPanel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("\uB098\uAC00\uAE30");
		lblNewLabel_2.setBounds(0, 10, 111, 60);
		lblNewLabel_2.setFont(new Font("KBIZ한마음고딕 H", Font.BOLD, 20));
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
		label.setIcon(new ImageIcon(Btn1_Button2.class.getResource("/P5_Img/icons8_search_32px.png")));

		SearchIconPanel.add(label);

		JPanel SearchTxtPanel = new JPanel();
		SearchTxtPanel.setBounds(46, 0, 254, 68);
		SearchTxtPanel.setBackground(new Color(41, 57, 80));
		SearchPanel.add(SearchTxtPanel);
		SearchTxtPanel.setLayout(null);

		textField = new JTextField();
		textField.setFont(new Font("KBIZ한마음고딕 H", Font.PLAIN, 14));
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
		btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel Stn4_Button1 = new Btn4_Button1(frame, dto);
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
		lbl_btn4.setForeground(Color.WHITE);
		lbl_btn4.setFont(new Font("KBIZ한마음고딕 H", Font.PLAIN, 20));
		lbl_btn4.setBounds(87, 30, 87, 24);
		btn4.add(lbl_btn4);

		JPanel PlayerButtonPanel = new JPanel();
		PlayerButtonPanel.setBackground(new Color(71, 120, 197));
		PlayerButtonPanel.setBounds(280, 0, 1320, 105);
		Lobby_Panel.add(PlayerButtonPanel);
		PlayerButtonPanel.setLayout(null);

		JPanel AllPlayerButton = new JPanel();
		AllPlayerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		AllPlayerButton.setBackground(new Color(71, 120, 197));
		AllPlayerButton.setBounds(130, 0, 220, 105);
		PlayerButtonPanel.add(AllPlayerButton);
		AllPlayerButton.setLayout(null);

		JLabel lbl_AllPlayerButton = new JLabel("\uC804\uCCB4\uBCF4\uAE30");
		lbl_AllPlayerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel Stn1_Button1 = new Btn1_Button1(frame, dto);
				frame.getContentPane().removeAll();
				frame.getContentPane().add(Stn1_Button1);
				frame.revalidate();
				frame.repaint();
			}
		});
		lbl_AllPlayerButton.setBounds(0, 0, 220, 105);
		lbl_AllPlayerButton.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_AllPlayerButton.setForeground(new Color(255, 255, 255));
		lbl_AllPlayerButton.setFont(new Font("KBIZ한마음고딕 H", Font.PLAIN, 20));
		lbl_AllPlayerButton.setBackground(new Color(255, 255, 255));
		AllPlayerButton.add(lbl_AllPlayerButton);

		JPanel PlayerStatButton = new JPanel();
		PlayerStatButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		PlayerStatButton.setBackground(new Color(255, 255, 255, 60));
		PlayerStatButton.setBounds(350, 0, 220, 105);
		PlayerButtonPanel.add(PlayerStatButton);
		PlayerStatButton.setLayout(null);

		JLabel lbl_PlayerStatButton = new JLabel("\uC120\uC218\uC2A4\uD0EF");
		lbl_PlayerStatButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel Stn1_Button2 = new Btn1_Button2(frame, dto, 0);
				frame.getContentPane().removeAll();
				frame.getContentPane().add(Stn1_Button2);
				frame.revalidate();
				frame.repaint();
			}
		});
		lbl_PlayerStatButton.setBounds(0, 0, 220, 105);
		lbl_PlayerStatButton.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_PlayerStatButton.setForeground(Color.WHITE);
		lbl_PlayerStatButton.setFont(new Font("KBIZ한마음고딕 H", Font.PLAIN, 20));
		lbl_PlayerStatButton.setBackground(Color.WHITE);
		PlayerStatButton.add(lbl_PlayerStatButton);

		JPanel panel = new JPanel();
		panel.setBounds(0, 98, 220, 7);
		PlayerStatButton.add(panel);

		JPanel PlayerChart = new JPanel();
		PlayerChart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		PlayerChart.setBackground(new Color(71, 120, 197));
		PlayerChart.setBounds(570, 0, 220, 105);
		PlayerButtonPanel.add(PlayerChart);
		PlayerChart.setLayout(new CardLayout(0, 0));

		JLabel lbl_PlayerChart = new JLabel("\uCC28\uD2B8\uBCF4\uAE30");
		lbl_PlayerChart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel Stn1_Button3 = new Btn1_Button3(frame, dto, PLAYER_CODE);
				frame.getContentPane().removeAll();
				frame.getContentPane().add(Stn1_Button3);
				frame.revalidate();
				frame.repaint();
			}
		});
		lbl_PlayerChart.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_PlayerChart.setForeground(Color.WHITE);
		lbl_PlayerChart.setFont(new Font("KBIZ한마음고딕 H", Font.PLAIN, 20));
		lbl_PlayerChart.setBackground(Color.WHITE);
		PlayerChart.add(lbl_PlayerChart, "name_3777310714400");

		JPanel PlayerMemoPanel = new JPanel();
		PlayerMemoPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		PlayerMemoPanel.setBackground(new Color(71, 120, 197));
		PlayerMemoPanel.setBounds(790, 0, 220, 105);
		PlayerButtonPanel.add(PlayerMemoPanel);
		PlayerMemoPanel.setLayout(new CardLayout(0, 0));

		JLabel lbl_PlayerMemo = new JLabel("\uD3C9\uAC00\uBA54\uBAA8");
		lbl_PlayerMemo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel Stn1_Button4 = new Btn1_Button4(frame, dto, PLAYER_CODE);
				frame.getContentPane().removeAll();
				frame.getContentPane().add(Stn1_Button4);
				frame.revalidate();
				frame.repaint();
			}
		});
		PlayerMemoPanel.add(lbl_PlayerMemo, "name_3775184187700");
		lbl_PlayerMemo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_PlayerMemo.setForeground(Color.WHITE);
		lbl_PlayerMemo.setFont(new Font("KBIZ한마음고딕 H", Font.PLAIN, 20));
		lbl_PlayerMemo.setBackground(Color.WHITE);

		JPanel SetStatPanel = new JPanel();
		SetStatPanel.setBackground(new Color(71, 120, 197));
		SetStatPanel.setBounds(1010, 0, 220, 105);
		PlayerButtonPanel.add(SetStatPanel);
		SetStatPanel.setLayout(new CardLayout(0, 0));

		JLabel lbl_SetStat = new JLabel("\uC2A4\uD0EF\uB4F1\uB85D");
		lbl_SetStat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_SetStat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel Stn1_Button5 = new Btn1_Button5(frame, dto, PLAYER_CODE);
				frame.getContentPane().removeAll();
				frame.getContentPane().add(Stn1_Button5);
				frame.revalidate();
				frame.repaint();
			}
		});
		lbl_SetStat.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SetStat.setForeground(Color.WHITE);
		lbl_SetStat.setFont(new Font("KBIZ한마음고딕 H", Font.PLAIN, 20));
		lbl_SetStat.setBackground(Color.WHITE);
		SetStatPanel.add(lbl_SetStat, "name_10588236113000");

		JPanel StatViewPanel = new JPanel();
		StatViewPanel.setBackground(new Color(255, 255, 255));
		StatViewPanel.setBounds(280, 104, 1320, 796);
		Lobby_Panel.add(StatViewPanel);
		StatViewPanel.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(90, 50, 180, 180);
		StatViewPanel.add(panel_2);
		panel_2.setLayout(new CardLayout(0, 0));

		JLabel lbl_image = new JLabel(new ImageIcon(p_dto.getPlayer_ResizeImg(180, 180)));
		lbl_image.setBackground(Color.WHITE);
		lbl_image.setIcon(new ImageIcon(p_dto.getPlayer_ResizeImg(180, 180)));
		lbl_image.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lbl_image, "name_5083844218100");

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(338, 76, 468, 230);
		StatViewPanel.add(panel_3);
		panel_3.setLayout(null);

		ArrayList<Player_FootballDTO> ArrFootball_stat = new ArrayList<Player_FootballDTO>();
		ArrFootball_stat = fdao.SelectPlayer_Football(PLAYER_CODE);

		ArrayList<PlayerContestDTO> ArrFootball_conte = new ArrayList<PlayerContestDTO>();
		Player_ContestDAO contest_dao = new Player_ContestDAO();
		ArrFootball_conte = contest_dao.SelectPlayer(PLAYER_CODE);

		ArrayList<PlayerPhysicalDTO> ArrFootball_phy = new ArrayList<PlayerPhysicalDTO>();
		Player_PhysicalDAO pdao = new Player_PhysicalDAO();
		ArrFootball_phy = pdao.SelectPlayer(PLAYER_CODE);

		ArrayList<PlayerMedicalDTO> ArrFootball_med = new ArrayList<PlayerMedicalDTO>();
		Player_MedicalDAO mdao = new Player_MedicalDAO();
		ArrFootball_med = mdao.SelectPlayer(PLAYER_CODE);

		JLabel lblNewLabel_3 = new JLabel("\uB098\uC774");
		lblNewLabel_3.setForeground(new Color(153, 153, 153));
		lblNewLabel_3.setFont(new Font("만화진흥원체", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(12, 10, 48, 32);
		panel_3.add(lblNewLabel_3);

		JLabel lblAge = new JLabel();
		lblAge.setForeground(new Color(189, 178, 137));
		lblAge.setFont(new Font("만화진흥원체", Font.PLAIN, 35));
		lblAge.setBounds(12, 52, 48, 32);
		lblAge.setText(ArrFootball_phy.get(0).getPlayer_Physical_Age() + "");
		panel_3.add(lblAge);

		JLabel label_3 = new JLabel("\uD0A4");
		label_3.setForeground(new Color(153, 153, 153));
		label_3.setFont(new Font("만화진흥원체", Font.PLAIN, 16));
		label_3.setBounds(84, 10, 48, 32);
		panel_3.add(label_3);

		JLabel lblCm = new JLabel();
		lblCm.setForeground(new Color(189, 178, 137));
		lblCm.setFont(new Font("만화진흥원체", Font.PLAIN, 35));
		lblCm.setBounds(84, 52, 73, 32);
		lblCm.setText(ArrFootball_phy.get(0).getPlayer_Physical_Height() + "");
		panel_3.add(lblCm);

		JLabel label_4 = new JLabel("\uBAB8\uBB34\uAC8C");
		label_4.setForeground(new Color(153, 153, 153));
		label_4.setFont(new Font("만화진흥원체", Font.PLAIN, 16));
		label_4.setBounds(250, 10, 48, 32);
		panel_3.add(label_4);

		JLabel lblkg = new JLabel();
		lblkg.setForeground(new Color(189, 178, 137));
		lblkg.setFont(new Font("만화진흥원체", Font.PLAIN, 35));
		lblkg.setBounds(250, 52, 97, 32);
		lblkg.setText(ArrFootball_phy.get(0).getPlayer_Physical_Weight() + "");
		panel_3.add(lblkg);

		JLabel label_5 = new JLabel("\uC67C\uBC1C");
		label_5.setForeground(new Color(153, 153, 153));
		label_5.setFont(new Font("만화진흥원체", Font.PLAIN, 16));
		label_5.setBounds(359, 10, 48, 32);
		panel_3.add(label_5);

		JLabel label_6 = new JLabel("\uC624\uB978\uBC1C");
		label_6.setForeground(new Color(153, 153, 153));
		label_6.setFont(new Font("만화진흥원체", Font.PLAIN, 16));
		label_6.setBounds(419, 10, 48, 32);
		panel_3.add(label_6);

		JLabel lblLeft = new JLabel();
		lblLeft.setForeground(new Color(189, 178, 137));
		lblLeft.setFont(new Font("만화진흥원체", Font.PLAIN, 35));
		lblLeft.setBounds(359, 52, 48, 32);
		lblLeft.setText(ArrFootball_phy.get(0).getPlayer_Physical_LeftFoot() + "");
		panel_3.add(lblLeft);

		JLabel lblRight = new JLabel();
		lblRight.setForeground(new Color(189, 178, 137));
		lblRight.setFont(new Font("만화진흥원체", Font.PLAIN, 35));
		lblRight.setBounds(419, 52, 48, 32);
		lblRight.setText(ArrFootball_phy.get(0).getPlayer_Physical_RightFoot() + "");
		panel_3.add(lblRight);

		JLabel label_34 = new JLabel("\uBD80\uC0C1\uAE30\uAC04");
		label_34.setForeground(new Color(153, 153, 153));
		label_34.setFont(new Font("만화진흥원체", Font.PLAIN, 16));
		label_34.setBounds(12, 112, 107, 32);
		panel_3.add(label_34);

		JLabel lbl_Period = new JLabel();
		lbl_Period.setForeground(Color.BLACK);
		lbl_Period.setFont(new Font("만화진흥원체", Font.PLAIN, 16));
		lbl_Period.setBounds(12, 154, 48, 19);
		lbl_Period.setText(ArrFootball_med.get(0).getPlayer_Medical_Period() + "");
		panel_3.add(lbl_Period);

		JLabel lbl_Title = new JLabel();
		lbl_Title.setForeground(Color.BLACK);
		lbl_Title.setFont(new Font("만화진흥원체", Font.PLAIN, 16));
		lbl_Title.setBounds(87, 154, 367, 19);
		lbl_Title.setText(ArrFootball_med.get(0).getPlayer_Medical_Title());
		panel_3.add(lbl_Title);
		
		JLabel label_2 = new JLabel("CM");
		label_2.setForeground(new Color(189, 178, 137));
		label_2.setFont(new Font("만화진흥원체", Font.PLAIN, 35));
		label_2.setBounds(153, 52, 53, 32);
		panel_3.add(label_2);
		
		JLabel lblKg = new JLabel("KG");
		lblKg.setForeground(new Color(189, 178, 137));
		lblKg.setFont(new Font("만화진흥원체", Font.PLAIN, 35));
		lblKg.setBounds(294, 52, 53, 32);
		panel_3.add(lblKg);

		JLabel label_9 = new JLabel(p_dto.getPlayer_Name());
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setFont(new Font("만화진흥원체", Font.PLAIN, 25));
		label_9.setBounds(90, 240, 180, 45);
		StatViewPanel.add(label_9);

		JLabel label_11 = new JLabel(new Player_PositionDAO().selectPlayer_Football(PLAYER_CODE).get(0).getPlayer_Position_Name());
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setForeground(Color.BLACK);
		label_11.setFont(new Font("만화진흥원체", Font.PLAIN, 16));
		label_11.setBounds(90, 287, 180, 19);
		StatViewPanel.add(label_11);

		JLabel label_10 = new JLabel("\uC120\uC218 \uC2A4\uD0EF");
		label_10.setForeground(new Color(0, 0, 0));
		label_10.setFont(new Font("만화진흥원체", Font.PLAIN, 35));
		label_10.setBounds(90, 337, 160, 45);
		StatViewPanel.add(label_10);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(229, 229, 229));
		separator_1.setBounds(90, 460, 994, 10);
		StatViewPanel.add(separator_1);

		JLabel label_12 = new JLabel("\uCD95\uAD6C \uB2A5\uB825");
		label_12.setForeground(Color.BLACK);
		label_12.setFont(new Font("만화진흥원체", Font.PLAIN, 25));
		label_12.setBounds(90, 405, 139, 45);
		StatViewPanel.add(label_12);

		JLabel label_13 = new JLabel("\uC2A4\uD53C\uB4DC");
		label_13.setForeground(new Color(153, 153, 153));
		label_13.setFont(new Font("만화진흥원체", Font.PLAIN, 16));
		label_13.setBounds(125, 522, 48, 32);
		StatViewPanel.add(label_13);

		JLabel lbl_speed = new JLabel();
		lbl_speed.setForeground(new Color(189, 178, 137));
		lbl_speed.setFont(new Font("만화진흥원체", Font.PLAIN, 35));
		lbl_speed.setBounds(125, 480, 48, 32);
		lbl_speed.setText(ArrFootball_stat.get(0).getPlayer_Football_Speed() + "");
		StatViewPanel.add(lbl_speed);

		JLabel lbl_shoot = new JLabel();
		lbl_shoot.setForeground(new Color(189, 178, 137));
		lbl_shoot.setFont(new Font("만화진흥원체", Font.PLAIN, 35));
		lbl_shoot.setBounds(288, 480, 48, 32);
		lbl_shoot.setText(ArrFootball_stat.get(0).getPlayer_Football_Shoot() + "");
		StatViewPanel.add(lbl_shoot);

		JLabel label_16 = new JLabel("\uC29B");
		label_16.setForeground(new Color(153, 153, 153));
		label_16.setFont(new Font("만화진흥원체", Font.PLAIN, 16));
		label_16.setBounds(288, 522, 48, 32);
		StatViewPanel.add(label_16);

		JLabel lbl_pass = new JLabel();
		lbl_pass.setForeground(new Color(189, 178, 137));
		lbl_pass.setFont(new Font("만화진흥원체", Font.PLAIN, 35));
		lbl_pass.setBounds(471, 480, 48, 32);
		lbl_pass.setText(ArrFootball_stat.get(0).getPlayer_Football_Pass() + "");
		StatViewPanel.add(lbl_pass);

		JLabel label_18 = new JLabel("\uD328\uC2A4");
		label_18.setForeground(new Color(153, 153, 153));
		label_18.setFont(new Font("만화진흥원체", Font.PLAIN, 16));
		label_18.setBounds(471, 522, 48, 32);
		StatViewPanel.add(label_18);

		JLabel lbl_dribol = new JLabel();
		lbl_dribol.setForeground(new Color(189, 178, 137));
		lbl_dribol.setFont(new Font("만화진흥원체", Font.PLAIN, 35));
		lbl_dribol.setBounds(677, 480, 48, 32);
		lbl_dribol.setText(ArrFootball_stat.get(0).getPlayer_Football_Dribol() + "");
		StatViewPanel.add(lbl_dribol);

		JLabel label_20 = new JLabel("\uB4DC\uB9AC\uBE14");
		label_20.setForeground(new Color(153, 153, 153));
		label_20.setFont(new Font("만화진흥원체", Font.PLAIN, 16));
		label_20.setBounds(677, 522, 48, 32);
		StatViewPanel.add(label_20);

		JLabel lbl_defense = new JLabel();
		lbl_defense.setForeground(new Color(189, 178, 137));
		lbl_defense.setFont(new Font("만화진흥원체", Font.PLAIN, 35));
		lbl_defense.setBounds(879, 480, 48, 32);
		lbl_defense.setText(ArrFootball_stat.get(0).getPlayer_Football_Defense() + "");
		StatViewPanel.add(lbl_defense);

		JLabel label_22 = new JLabel("\uC218\uBE44");
		label_22.setForeground(new Color(153, 153, 153));
		label_22.setFont(new Font("만화진흥원체", Font.PLAIN, 16));
		label_22.setBounds(879, 522, 48, 32);
		StatViewPanel.add(label_22);

		JLabel label_23 = new JLabel("\uB300\uD68C \uC131\uC801");
		label_23.setForeground(Color.BLACK);
		label_23.setFont(new Font("만화진흥원체", Font.PLAIN, 25));
		label_23.setBounds(90, 581, 139, 45);
		StatViewPanel.add(label_23);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(229, 229, 229));
		separator_2.setBounds(90, 636, 994, 10);
		StatViewPanel.add(separator_2);

		JLabel lbl_goal = new JLabel();
		lbl_goal.setForeground(new Color(189, 178, 137));
		lbl_goal.setFont(new Font("만화진흥원체", Font.PLAIN, 35));
		lbl_goal.setBounds(125, 656, 48, 32);
		lbl_goal.setText(ArrFootball_conte.get(0).getPlayer_Contest_Goal() + "");
		StatViewPanel.add(lbl_goal);

		JLabel label_25 = new JLabel("\uACE8");
		label_25.setForeground(new Color(153, 153, 153));
		label_25.setFont(new Font("만화진흥원체", Font.PLAIN, 16));
		label_25.setBounds(125, 698, 48, 32);
		StatViewPanel.add(label_25);

		JLabel lbl_assist = new JLabel();
		lbl_assist.setForeground(new Color(189, 178, 137));
		lbl_assist.setFont(new Font("만화진흥원체", Font.PLAIN, 35));
		lbl_assist.setText(ArrFootball_conte.get(0).getPlayer_Contest_Assist() + "");
		lbl_assist.setBounds(288, 656, 48, 32);
		StatViewPanel.add(lbl_assist);

		JLabel label_27 = new JLabel("\uC5B4\uC2DC\uC2A4\uD2B8");
		label_27.setForeground(new Color(153, 153, 153));
		label_27.setFont(new Font("만화진흥원체", Font.PLAIN, 16));
		label_27.setBounds(288, 698, 98, 32);
		StatViewPanel.add(label_27);

		JLabel lbl_effective = new JLabel();
		lbl_effective.setForeground(new Color(189, 178, 137));
		lbl_effective.setFont(new Font("만화진흥원체", Font.PLAIN, 35));
		lbl_effective.setBounds(471, 656, 48, 32);
		lbl_effective.setText(ArrFootball_conte.get(0).getPlayer_Contest_EffectiveShot() + "");
		StatViewPanel.add(lbl_effective);

		JLabel label_29 = new JLabel("\uC720\uD6A8\uC29B");
		label_29.setForeground(new Color(153, 153, 153));
		label_29.setFont(new Font("만화진흥원체", Font.PLAIN, 16));
		label_29.setBounds(471, 698, 48, 32);
		StatViewPanel.add(label_29);

		JLabel lbl_shot = new JLabel();
		lbl_shot.setForeground(new Color(189, 178, 137));
		lbl_shot.setFont(new Font("만화진흥원체", Font.PLAIN, 35));
		lbl_shot.setBounds(677, 656, 48, 32);
		lbl_shot.setText(ArrFootball_conte.get(0).getPlayer_Contest_Shot() + "");
		StatViewPanel.add(lbl_shot);

		JLabel label_31 = new JLabel("\uC29B");
		label_31.setForeground(new Color(153, 153, 153));
		label_31.setFont(new Font("만화진흥원체", Font.PLAIN, 16));
		label_31.setBounds(677, 698, 48, 32);
		StatViewPanel.add(label_31);

		JLabel lbl_RunningTime = new JLabel("25");
		lbl_RunningTime.setForeground(new Color(189, 178, 137));
		lbl_RunningTime.setFont(new Font("만화진흥원체", Font.PLAIN, 35));
		lbl_RunningTime.setBounds(879, 656, 48, 32);
		lbl_RunningTime.setText(ArrFootball_conte.get(0).getPlayer_Contest_RunningTime() + "");
		StatViewPanel.add(lbl_RunningTime);

		JLabel label_33 = new JLabel("\uD65C\uB3D9\uB7C9");
		label_33.setForeground(new Color(153, 153, 153));
		label_33.setFont(new Font("만화진흥원체", Font.PLAIN, 16));
		label_33.setBounds(879, 698, 48, 32);
		StatViewPanel.add(label_33);
		
		JPanel rador_panel = new JPanel();
		ArrFootball = fdao.SelectPlayer_Football(PLAYER_CODE); 
		rador_panel.setBackground(Color.WHITE);
		rador_panel.setBounds(886, 50, 300, 300);
		StatViewPanel.add(rador_panel);
		rador_panel.setLayout(new CardLayout(0, 0));
		
		ChartPanel CP_rador;
		JFreeChart radorChart = cdao.getRadorChart(ArrFootball);
		CP_rador = new ChartPanel(radorChart);
		CP_rador.setMouseZoomable(false);
		rador_panel.setBackground(new Color(255, 255, 255));
		rador_panel.add(CP_rador);
		

	}
	
}
