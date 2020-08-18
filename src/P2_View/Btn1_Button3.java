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

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import P3_DAO.ChartDAO;
import P3_DAO.PlayerDAO;
import P3_DAO.Player_FootballDAO;
import P3_DAO.Player_PositionDAO;
import P4_DTO.PlayerDTO;
import P4_DTO.Player_FootballDTO;
import P4_DTO.loginDTO;

public class Btn1_Button3 extends JPanel {
	private JTextField textField;
	private loginDTO dto;
	private JFrame frame;
	private int PLAYER_CODE;
	private PlayerDTO p_dto;
	private PlayerDAO p_dao = new PlayerDAO();
	private ChartPanel CP_overall_1;

	/**
	 * Create the panel.
	 */
	public Btn1_Button3(JFrame frame, loginDTO dto, int PLAYER_CODE) {
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
		btn_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel Stn1_Button1 = new Btn1_Button1(frame, dto);
				frame.getContentPane().removeAll();
				frame.getContentPane().add(Stn1_Button1);
				frame.revalidate();
				frame.repaint();
			}
		});
		btn_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_1.setBackground(new Color(255, 255, 255, 20));
		btn_1.setBounds(0, 361, 300, 80);
		LeftLobbyPanel.add(btn_1);
		btn_1.setLayout(null);

		JLabel lbl_btn1 = new JLabel("\uC120\uC218\uAD00\uB9AC");
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
		lblNewLabel_1.setIcon(new ImageIcon(Btn1_Button3.class.getResource("/P5_Img/icons8_exit_32px.png")));
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
		label.setIcon(new ImageIcon(Btn1_Button3.class.getResource("/P5_Img/icons8_search_32px.png")));

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
		btn_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel Stn3_Button1 = new Btn3_Button1(frame, dto);
				frame.getContentPane().removeAll();
				frame.getContentPane().add(Stn3_Button1);
				frame.revalidate();
				frame.repaint();
			}
		});
		btn_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_3.setLayout(null);
		btn_3.setBackground(new Color(41, 57, 80));
		btn_3.setBounds(0, 517, 300, 80);
		LeftLobbyPanel.add(btn_3);

		JLabel lbl_btn3 = new JLabel("\uAD6C\uB2E8\uBAA9\uB85D");
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
		PlayerStatButton.setBackground(new Color(71, 120, 197));
		PlayerStatButton.setBounds(350, 0, 220, 105);
		PlayerButtonPanel.add(PlayerStatButton);
		PlayerStatButton.setLayout(null);

		JLabel lbl_PlayerStatButton = new JLabel("\uC120\uC218\uC2A4\uD0EF");
		lbl_PlayerStatButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel Stn1_Button2 = new Btn1_Button2(frame, dto, PLAYER_CODE);
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

		JPanel PlayerChart = new JPanel();
		PlayerChart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		PlayerChart.setBackground(new Color(255, 255, 255, 60));
		PlayerChart.setBounds(570, 0, 220, 105);
		PlayerButtonPanel.add(PlayerChart);
		PlayerChart.setLayout(null);

		JLabel lbl_PlayerChart = new JLabel("\uCC28\uD2B8\uBCF4\uAE30");
		lbl_PlayerChart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel Stn1_Button3 = new Btn1_Button3(frame, dto, 0);
				frame.getContentPane().removeAll();
				frame.getContentPane().add(Stn1_Button3);
				frame.revalidate();
				frame.repaint();
			}
		});

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
				JPanel Stn1_Button5 = new Btn1_Button5(frame, dto,PLAYER_CODE);
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

		lbl_PlayerChart.setBounds(0, 0, 220, 105);
		lbl_PlayerChart.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_PlayerChart.setForeground(Color.WHITE);
		lbl_PlayerChart.setFont(new Font("KBIZ한마음고딕 H", Font.PLAIN, 20));
		lbl_PlayerChart.setBackground(Color.WHITE);
		PlayerChart.add(lbl_PlayerChart);

		JPanel panel = new JPanel();
		panel.setBounds(0, 98, 220, 7);
		PlayerChart.add(panel);

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
				JPanel Stn1_Button4 = new Btn1_Button4(frame, dto,PLAYER_CODE);
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

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(280, 104, 1320, 796);
		Lobby_Panel.add(panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(90, 50, 180, 180);
		panel_2.add(panel_3);
		panel_3.setLayout(new CardLayout(0, 0));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon(p_dto.getPlayer_ResizeImg(180, 180)));
		panel_3.add(lblNewLabel, "name_4633110137300");

		JPanel overallPane = new JPanel();
		overallPane.setBackground(new Color(255, 255, 255));
		overallPane.setBounds(356, 50, 468, 230);
		panel_2.add(overallPane);
		overallPane.setLayout(new CardLayout(0, 0));

		JPanel footballPane = new JPanel();
		footballPane.setBackground(new Color(255, 255, 255));
		footballPane.setBounds(90, 362, 486, 334);
		panel_2.add(footballPane);
		footballPane.setLayout(new CardLayout(0, 0));

		ArrFootball = fdao.SelectPlayer_Football(PLAYER_CODE); // 풋볼코드를 안에 값으로 수정해야함!!!
		JFreeChart chart = cdao.getChart_Football(ArrFootball);
		ChartPanel CP = new ChartPanel(chart);
		CP.setBackground(new Color(255, 255, 255));
		footballPane.add(CP);
		footballPane.validate();

		ArrFootball = fdao.SelectPlayer_Football_Recent(PLAYER_CODE); // 풋볼코드를 안에 값으로 수정해야함!!!
		JFreeChart chart_overall = cdao.getChart_Overall(ArrFootball);
		ChartPanel CP_overall = new ChartPanel(chart_overall);
		CP_overall.setBackground(new Color(255, 255, 255));
		overallPane.add(CP_overall);
		overallPane.validate();

		JLabel label_15 = new JLabel(p_dto.getPlayer_Name());
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		label_15.setForeground(Color.BLACK);
		label_15.setFont(new Font("만화진흥원체", Font.PLAIN, 25));
		label_15.setBounds(90, 240, 180, 45);
		panel_2.add(label_15);

		JLabel label_16 = new JLabel(new Player_PositionDAO().selectPlayer_Football(PLAYER_CODE).get(0).getPlayer_Position_Name());
		label_16.setHorizontalAlignment(SwingConstants.CENTER);
		label_16.setForeground(Color.BLACK);
		label_16.setFont(new Font("만화진흥원체", Font.PLAIN, 16));
		label_16.setBounds(90, 287, 180, 19);
		panel_2.add(label_16);

		JPanel RecentPane = new JPanel();
		RecentPane.setBackground(new Color(255, 255, 255));
		RecentPane.setBounds(704, 362, 486, 334);
		panel_2.add(RecentPane);

		ArrFootball = fdao.SelectPlayer_Football_Recent(PLAYER_CODE);
		JFreeChart chart_recent = cdao.getChart_Recent(ArrFootball);
		RecentPane.setLayout(new CardLayout(0, 0));
		ChartPanel CP_recent = new ChartPanel(chart_recent);
		CP_recent.setBackground(new Color(255, 255, 255));
		RecentPane.add(CP_recent, "name_91179911607000");
		CP_recent.setLayout(new CardLayout(0, 0));
		RecentPane.validate();

		JPanel rador_panel = new JPanel();
		ArrFootball = fdao.SelectPlayer_Football(PLAYER_CODE); 
		rador_panel.setBackground(Color.WHITE);
		rador_panel.setBounds(886, 50, 300, 300);
		panel_2.add(rador_panel);
		rador_panel.setLayout(new CardLayout(0, 0));
		ChartPanel CP_rador;
		JFreeChart radorChart = cdao.getRadorChart(ArrFootball);
		CP_rador = new ChartPanel(radorChart);
		CP_rador.setMouseZoomable(false);
		rador_panel.setBackground(new Color(255, 255, 255));
		rador_panel.add(CP_rador);
	}
}
