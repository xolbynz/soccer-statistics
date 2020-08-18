package P2_View;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import P3_DAO.PlayerDAO;
import P4_DTO.listAllDTO;
import P4_DTO.loginDTO;
import P7_Util.TeamName;

public class Btn1_Button1 extends JPanel {
	private JTextField textField;
	private JTable table;
	private loginDTO dto;
	private JFrame frame;
	private PlayerDAO dao = new PlayerDAO();

	/**
	 * Create the panel.
	 */
	public Btn1_Button1(JFrame frame, loginDTO dto) {
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
			public void mouseClicked(MouseEvent arg0) {
				if (select() > 0) {
					JPanel Stn0_Button0 = new Lobby(frame, dto);
					frame.getContentPane().removeAll();
					frame.getContentPane().add(Stn0_Button0);
					frame.revalidate();
					frame.repaint();
				}
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
		lblNewLabel_1.setIcon(new ImageIcon(Btn1_Button1.class.getResource("/P5_Img/icons8_exit_32px.png")));
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
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<listAllDTO> list = null;
				if (dto.getView_Power() == 2) {
					System.out.println("vip");
					list = dao.VIPsearchGudanPlayerAbility(textField.getText());
				} else {
					list = dao.searchGudanPlayerAbility(dto.getGroup_Code(), textField.getText());
				}

				String column[] = { "선수번호", "이름", "스피드", "슛", "패스", "드리볼", "수비", "성별", "나이", "키", "몸무게", "왼발", "오른발",
						"팀명" };
				Object[][] content = new Object[list.size()][column.length];

				for (int i = 0; i < content.length; i++) {
					content[i][0] = list.get(i).getPlayer_Code();
					content[i][1] = list.get(i).getPlayer_Name();
					content[i][2] = list.get(i).getPlayer_Football_Speed();
					content[i][3] = list.get(i).getPlayer_Football_Shoot();
					content[i][4] = list.get(i).getPlayer_Football_Pass();
					content[i][5] = list.get(i).getPlayer_Football_Dribol();
					content[i][6] = list.get(i).getPlayer_Football_Defense();
					content[i][7] = list.get(i).getPlayer_Physical_Sex();
					content[i][8] = list.get(i).getPlayer_Physical_Age();
					content[i][9] = list.get(i).getPlayer_Physical_Height();
					content[i][10] = list.get(i).getPlayer_Physical_Weight();
					content[i][11] = list.get(i).getPlayer_Physical_LeftFoot();
					content[i][12] = list.get(i).getPlayer_Physical_RightFoot();
					content[i][13] = TeamName.getTeamName(list.get(i).getPlayer_Code());
				}

				for (int i = 0; i < content.length - 2; i++) {
					for (int j = i + 1; j < content.length - 1; j++) {
						int a = (int) content[i][2] + (int) content[i][3] + (int) content[i][4] + (int) content[i][5]
								+ (int) content[i][6] - (int) content[i][8] + (int) content[i][9]
								- (int) content[i][10];
						int b = (int) content[j][2] + (int) content[j][3] + (int) content[j][4] + (int) content[j][5]
								+ (int) content[j][6] - (int) content[j][8] + (int) content[j][9]
								- (int) content[j][10];

						if (a < b) {
							Object[] temp = content[i];
							content[i] = content[j];
							content[j] = temp;
						}
					}
				}

				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);

				table.setModel(new DefaultTableModel(content, column) {
					@Override
					public Class<?> getColumnClass(int column) {
						return column == 1 ? Integer.class : String.class;
					}

					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}
				});

				if (content.length > 1) {
					table.setRowSelectionInterval(0, 0); // 시작과 동시 첫번째 행을 선택하게 하기
				}
			}
		});
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setFocusPainted(false);
		button.setOpaque(false);
		button.setBounds(0, 0, 59, 34);
		SearchIconPanel.add(button);
		label.setBounds(0, 0, 32, 32);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(Btn1_Button1.class.getResource("/P5_Img/icons8_search_32px.png")));

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
				JPanel Stn1_Button2 = new Btn2_Button1(frame, dto);
				frame.getContentPane().removeAll();
				frame.getContentPane().add(Stn1_Button2);
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
				JPanel Stn1_Button3 = new Btn3_Button1(frame, dto);
				frame.getContentPane().removeAll();
				frame.getContentPane().add(Stn1_Button3);
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
				JPanel Stn1_Button4 = new Btn4_Button1(frame, dto);
				frame.getContentPane().removeAll();
				frame.getContentPane().add(Stn1_Button4);
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
		AllPlayerButton.setBackground(new Color(255, 255, 255, 60));
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

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 98, 220, 7);
		AllPlayerButton.add(panel_2);

		JPanel PlayerStatButton = new JPanel();
		PlayerStatButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		PlayerStatButton.setBackground(new Color(71, 120, 197));
		PlayerStatButton.setBounds(350, 0, 220, 105);
		PlayerButtonPanel.add(PlayerStatButton);
		PlayerStatButton.setLayout(new CardLayout(0, 0));

		JLabel lbl_PlayerStatButton = new JLabel("\uC120\uC218\uC2A4\uD0EF");
		lbl_PlayerStatButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (select() > 0) {
					JPanel Stn1_Button2 = new Btn1_Button2(frame, dto, select());
					frame.getContentPane().removeAll();
					frame.getContentPane().add(Stn1_Button2);
					frame.revalidate();
					frame.repaint();
				}
			}
		});
		lbl_PlayerStatButton.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_PlayerStatButton.setForeground(Color.WHITE);
		lbl_PlayerStatButton.setFont(new Font("KBIZ한마음고딕 H", Font.PLAIN, 20));
		lbl_PlayerStatButton.setBackground(Color.WHITE);
		PlayerStatButton.add(lbl_PlayerStatButton, "name_3773337336300");

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
				if (select() > 0) {
					JPanel Stn1_Button3 = new Btn1_Button3(frame, dto, select());
					frame.getContentPane().removeAll();
					frame.getContentPane().add(Stn1_Button3);
					frame.revalidate();
					frame.repaint();
				}
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
				if (select() > 0) {
					JPanel Stn1_Button4 = new Btn1_Button4(frame, dto, select());
					frame.getContentPane().removeAll();
					frame.getContentPane().add(Stn1_Button4);
					frame.revalidate();
					frame.repaint();
				}
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
				JPanel Stn1_Button5 = new Btn1_Button5(frame, dto, select());
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

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(280, 104, 1320, 796);
		Lobby_Panel.add(panel);
		panel.setLayout(null);

		ArrayList<listAllDTO> list;

		if (dto.getView_Power() == 2) {
			System.out.println("vip");
			list = dao.VIPsearchGudanPlayerAbility(textField.getText());
		} else {
			list = dao.searchGudanPlayerAbility(dto.getGroup_Code(), textField.getText());
		}

		String column[] = { "선수번호", "이름", "스피드", "슛", "패스", "드리볼", "수비", "성별", "나이", "키", "몸무게", "왼발", "오른발", "팀명" };
		Object[][] content = new Object[list.size()][column.length];

		for (int i = 0; i < content.length; i++) {
			content[i][0] = list.get(i).getPlayer_Code();
			content[i][1] = list.get(i).getPlayer_Name();
			content[i][2] = list.get(i).getPlayer_Football_Speed();
			content[i][3] = list.get(i).getPlayer_Football_Shoot();
			content[i][4] = list.get(i).getPlayer_Football_Pass();
			content[i][5] = list.get(i).getPlayer_Football_Dribol();
			content[i][6] = list.get(i).getPlayer_Football_Defense();
			content[i][7] = list.get(i).getPlayer_Physical_Sex();
			content[i][8] = list.get(i).getPlayer_Physical_Age();
			content[i][9] = list.get(i).getPlayer_Physical_Height();
			content[i][10] = list.get(i).getPlayer_Physical_Weight();
			content[i][11] = list.get(i).getPlayer_Physical_LeftFoot();
			content[i][12] = list.get(i).getPlayer_Physical_RightFoot();
			content[i][13] = TeamName.getTeamName(list.get(i).getPlayer_Code());
		}

		for (int i = 0; i < content.length - 2; i++) {
			for (int j = i + 1; j < content.length - 1; j++) {
				int a = (int) content[i][2] + (int) content[i][3] + (int) content[i][4] + (int) content[i][5]
						+ (int) content[i][6] - (int) content[i][8] + (int) content[i][9] - (int) content[i][10];
				int b = (int) content[j][2] + (int) content[j][3] + (int) content[j][4] + (int) content[j][5]
						+ (int) content[j][6] - (int) content[j][8] + (int) content[j][9] - (int) content[j][10];

				if (a < b) {
					Object[] temp = content[i];
					content[i] = content[j];
					content[j] = temp;
				}
			}
		}

		table = new JTable();
		table.setShowVerticalLines(false);
		table.setBorder(null);
		table.setRowHeight(40);
		table.setGridColor(Color.BLACK);
		table.setModel(new DefaultTableModel(content, column) {
			@Override
			public Class<?> getColumnClass(int column) {
				return column == 1 ? Integer.class : String.class;
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		table.getTableHeader().setBackground(new Color(120, 168, 252));
		table.getTableHeader().setForeground(new Color(255, 255, 255));
		table.setSelectionBackground(new Color(232, 57, 95));
		table.setBounds(35, 10, 1189, 738);
		if (content.length > 1) {
			table.setRowSelectionInterval(0, 0); // 시작과 동시 첫번째 행을 선택하게 하기
		}
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JTable t = (JTable) e.getSource();
				if (e.getClickCount() == 2) {
					TableModel m = t.getModel();
					Point pt = e.getPoint();
					int i = t.rowAtPoint(pt);
					if (i >= 0) {
						int row = t.convertRowIndexToModel(i);
//                        String s = String.format("%s (%s)", m.getValueAt(row, 0), m.getValueAt(row, 1));
//                        JOptionPane.showMessageDialog(t, s, "title", JOptionPane.INFORMATION_MESSAGE);

						System.out.println("=======================" + m.getValueAt(row, 0));

						JPanel Stn1_Button2 = new Btn1_Button2(frame, dto, (int) m.getValueAt(row, 0));
						frame.getContentPane().removeAll();
						frame.getContentPane().add(Stn1_Button2);
						frame.revalidate();
						frame.repaint();
					}
				}
			}
		});

		DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcmSchedule = table.getColumnModel();
		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
			tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 10, 1296, 738);
		panel.add(scrollPane);

	}

	public int select() {
		System.out.println(table.getRowCount());
		if (table.getRowCount() > 0) {
			return (int) table.getValueAt(table.getSelectedRow(), 0);
		}
		return 0;
	}
}
