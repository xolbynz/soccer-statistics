package P2_View;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import P3_DAO.GroupsDAO;
import P3_DAO.Player_TransferDAO;
import P4_DTO.GroupsDTO;
import P4_DTO.PlayerDTO;
import P4_DTO.PlayerPhysicalDTO;
import P4_DTO.Player_TransferDTO;
import P4_DTO.SignUpDTO;
import P4_DTO.loginDTO;
import P7_Util.AddressToLocalCode;
import P7_Util.TeamName;
import P7_Util.Transfer_Thread;
import P7_Util.fileExtension;

import javax.swing.JScrollPane;
import java.awt.Cursor;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.awt.Component;
import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Btn2_Button1 extends JPanel implements FocusListener {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textname;
	private JTextField textaddress;
	private JTextField texthomepage;
	private JTextField texttel;
	private JFrame frame;
	private loginDTO dto;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private GroupsDAO gdao = new GroupsDAO();
	private GroupsDTO gdto = new GroupsDTO();
	private Player_TransferDAO transdao = new Player_TransferDAO();
	private Player_TransferDTO transdto = new Player_TransferDTO();
	private ArrayList<GroupsDTO> glist;
	private JLabel lbl_image;
	private DefaultTableModel model2;
	private Transfer_Thread thread;

	/**
	 * Create the panel.
	 */
	public Btn2_Button1(JFrame frame, loginDTO dto) {
		this.frame = frame;
		this.dto = dto;
		ArrayList<GroupsDTO> arr_group = new ArrayList<>();
		arr_group = gdao.selectAllGroups_Groupcode(dto.getGroup_Code());

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
				thread.close();
				thread.interrupt();

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
		lbl_profileImg.setIcon(new ImageIcon(dto.getMember_ResizeImg(100, 100)));

		JPanel Profile_Nickname = new JPanel();
		Profile_Nickname.setBackground(new Color(84, 125, 206));
		Profile_Nickname.setBounds(100, 0, 180, 100);
		ProfilePanel.add(Profile_Nickname);
		Profile_Nickname.setLayout(null);

		JLabel lbl_profile_Nickname = new JLabel(dto.getMember_Nickname());
		lbl_profile_Nickname.setForeground(Color.WHITE);
		lbl_profile_Nickname.setFont(new Font("KBIZ한마음고딕 B", Font.PLAIN, 16));
		lbl_profile_Nickname.setBounds(30, 38, 100, 25);
		Profile_Nickname.add(lbl_profile_Nickname);
		lbl_profile_Nickname.setText(dto.getMember_Nickname());

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
				thread.close();
				thread.interrupt();

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
				thread.close();
				thread.interrupt();

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
		lblNewLabel_1.setIcon(new ImageIcon(Btn2_Button1.class.getResource("/P5_Img/icons8_exit_32px.png")));
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
		label.setIcon(new ImageIcon(Btn2_Button1.class.getResource("/P5_Img/icons8_search_32px.png")));

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
		btn_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btn_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_2.setLayout(null);
		btn_2.setBackground(new Color(255, 255, 255, 20));
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

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 0, 5, 80);
		btn_2.add(panel_2);

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
				thread.close();
				thread.interrupt();

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

		});
		btn4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn4.setLayout(null);
		btn4.setBackground(new Color(41, 57, 80));
		btn4.setBounds(0, 595, 300, 80);
		LeftLobbyPanel.add(btn4);

		JLabel lbl_btn4 = new JLabel("\uAC1C\uC778\uC124\uC815");
		lbl_btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				thread.close();
				thread.interrupt();

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

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(280, 103, 1320, 796);
		Lobby_Panel.add(panel_3);
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(23, 35, 51));

		textField_1 = new JTextField();
		textField_1.setText("");
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("KBIZ한마음고딕 H", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBackground(new Color(23, 35, 51));
		textField_1.setBounds(-48, 84, 0, 0);
		panel_3.add(textField_1);

		textname = new JTextField();
		textname.setText("\uBCC0\uACBD\uD560 \uAD6C\uB2E8 \uC774\uB984");
		textname.setForeground(Color.WHITE);
		textname.setFont(new Font("KBIZ한마음고딕 B", Font.PLAIN, 14));
		textname.setColumns(10);
		textname.setBorder(null);
		textname.setBackground(new Color(23, 35, 51));
		textname.setBounds(885, 341, 316, 21);
		textname.addFocusListener(this);
		panel_3.add(textname);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(885, 372, 316, 2);
		panel_3.add(separator_1);

		JLabel label_2 = new JLabel("");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("KBIZ한마음고딕 B", Font.PLAIN, 14));
		label_2.setBounds(885, 384, 265, 15);
		panel_3.add(label_2);

		textaddress = new JTextField();
		textaddress.setText("\uBCC0\uACBD\uD560 \uAD6C\uB2E8 \uC8FC\uC18C");
		textaddress.setForeground(Color.WHITE);
		textaddress.setFont(new Font("KBIZ한마음고딕 B", Font.PLAIN, 14));
		textaddress.setColumns(10);
		textaddress.setBorder(null);
		textaddress.setBackground(new Color(23, 35, 51));
		textaddress.setBounds(885, 409, 316, 21);
		panel_3.add(textaddress);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(885, 440, 316, 2);
		panel_3.add(separator_4);

		texthomepage = new JTextField();
		texthomepage.setText("\uBCC0\uACBD\uD560 \uAD6C\uB2E8 \uD648\uD398\uC774\uC9C0 \uC8FC\uC18C");
		texthomepage.setForeground(Color.WHITE);
		texthomepage.setFont(new Font("KBIZ한마음고딕 B", Font.PLAIN, 14));
		texthomepage.setColumns(10);
		texthomepage.setBorder(null);
		texthomepage.setBackground(new Color(23, 35, 51));
		texthomepage.setBounds(885, 460, 316, 21);
		panel_3.add(texthomepage);

		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(885, 491, 316, 2);
		panel_3.add(separator_5);

		JLabel label_8 = new JLabel("\uAD6C\uB2E8 \uC815\uBCF4\uBCC0\uACBD");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("만화진흥원체", Font.PLAIN, 25));
		label_8.setBounds(885, 96, 139, 45);
		panel_3.add(label_8);

		texttel = new JTextField();
		texttel.setText("\uBCC0\uACBD\uD560 \uAD6C\uB2E8 \uC5F0\uB77D\uCC98\r\n");
		texttel.setForeground(Color.WHITE);
		texttel.setFont(new Font("KBIZ한마음고딕 H", Font.PLAIN, 14));
		texttel.setColumns(10);
		texttel.setBorder(null);
		texttel.setBackground(new Color(23, 35, 51));
		texttel.setBounds(885, 516, 316, 21);
		panel_3.add(texttel);

		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(885, 547, 316, 2);
		panel_3.add(separator_6);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(240, 240, 240));
		panel_4.setBounds(885, 176, 100, 100);
		panel_3.add(panel_4);
		SpringLayout sl_panel_4 = new SpringLayout();
		panel_4.setLayout(sl_panel_4);

		lbl_image = new JLabel("");
		sl_panel_4.putConstraint(SpringLayout.NORTH, lbl_image, 0, SpringLayout.NORTH, panel_4);
		sl_panel_4.putConstraint(SpringLayout.WEST, lbl_image, 0, SpringLayout.WEST, panel_4);
		sl_panel_4.putConstraint(SpringLayout.SOUTH, lbl_image, 100, SpringLayout.NORTH, panel_4);
		sl_panel_4.putConstraint(SpringLayout.EAST, lbl_image, 100, SpringLayout.WEST, panel_4);
		panel_4.add(lbl_image);

		JButton button_1 = new JButton("\uC0AC\uC9C4\uCC3E\uAE30");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				FileNameExtensionFilter ExtenseFilter = new FileNameExtensionFilter("이미지파일 ", "jpg", "gif", "png");

				jfc.setFileFilter(ExtenseFilter);
				int returnValue = jfc.showOpenDialog(null);
				// int returnValue = jfc.showSaveDialog(null);

				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = jfc.getSelectedFile();

					boolean ExtensionOfFile = fileExtension.getfileExtension(selectedFile.getAbsolutePath());
					System.out.println(ExtensionOfFile);
					if (ExtensionOfFile) {

						JOptionPane.showMessageDialog(null, "업로드완료");
						String jPath = selectedFile.getAbsolutePath();

						gdto.setGroup_Img(jPath);
						gdto.getGroup_Img();

						lbl_image.setIcon(new ImageIcon(gdto.getGroup_ResizeImg(100, 100)));

					} else {
						JOptionPane.showMessageDialog(null, "이미지 확장자를 넣어주세요 ");

					}

				} else {
					JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다", "경고", JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("KBIZ한마음고딕 B", Font.PLAIN, 12));
		button_1.setBackground(new Color(71, 120, 197));
		button_1.setBounds(997, 253, 89, 23);
		panel_3.add(button_1);

		JButton button_2 = new JButton("\uBCC0\uACBD");
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("KBIZ한마음고딕 B", Font.PLAIN, 12));
		button_2.setBackground(new Color(71, 120, 197));
		button_2.setBounds(1121, 553, 80, 35);
		panel_3.add(button_2);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(229, 229, 229));
		separator_2.setBounds(116, 151, 500, 10);
		panel_3.add(separator_2);

		JLabel label_3 = new JLabel("\uC774\uC801 \uB9AC\uC2A4\uD2B8");
		label_3.setForeground(new Color(255, 255, 255));
		label_3.setFont(new Font("만화진흥원체", Font.PLAIN, 25));
		label_3.setBounds(116, 96, 139, 45);
		panel_3.add(label_3);

		JPanel panel = new JPanel();
		panel.setFont(new Font("KBIZ한마음고딕 M", Font.PLAIN, 14));
		panel.setBounds(116, 171, 500, 200);
		panel_3.add(panel);

		ArrayList<PlayerDTO> translist1 = transdao.transferTo(dto.getGroup_Code());

		String[] columnNames1 = { "선수코드", "이적팀명", "선수명", "선수전화번호", "선수이메일" };
		String[][] data1 = new String[translist1.size()][columnNames1.length];
		for (int i = 0; i < data1.length; i++) {
			data1[i][0] = String.valueOf(translist1.get(i).getPlayer_Code());
			data1[i][1] = TeamName.getTransferTeamName(translist1.get(i).getPlayer_Code());
			data1[i][2] = translist1.get(i).getPlayer_Name();
			data1[i][3] = translist1.get(i).getPlayer_Tel();
			data1[i][4] = translist1.get(i).getPlayer_Email();
		}

		table = new JTable();
		table.setFont(new Font("KBIZ한마음고딕 M", Font.PLAIN, 14));
		table.setShowVerticalLines(false);
		table.setBorder(null);
		table.setRowHeight(40);
		table.setGridColor(Color.BLACK);
		table.setModel(new DefaultTableModel(data1, columnNames1) {
			@Override
			public Class<?> getColumnClass(int column) {
				return column == 1 ? Integer.class : String.class;
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(122);
		table.getColumnModel().getColumn(1).setPreferredWidth(194);
		table.getTableHeader().setBackground(new Color(120, 168, 252));
		table.getTableHeader().setForeground(new Color(255, 255, 255));
		table.setSelectionBackground(new Color(232, 57, 95));
		panel.setLayout(new CardLayout(0, 0));
		table.setBounds(12, 29, 500, 259);

		DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcmSchedule = table.getColumnModel();
		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
			tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}

		panel_3.add(table);

		JScrollPane scrollPane_trans = new JScrollPane(table);
		scrollPane_trans.setFont(new Font("KBIZ한마음고딕 M", Font.PLAIN, 14));
		scrollPane_trans.setBounds(12, 10, 1296, 738);
		panel.add(scrollPane_trans, "name_8186182004900");

		ArrayList<PlayerDTO> translist2 = transdao.transferFrome(dto.getGroup_Code());

		String[] columnNames2 = { "선수코드1", "현재소속팀명", "선수명", "선수전화번호", "선수이메일" };
		String[][] data2 = new String[translist2.size()][columnNames2.length];
		for (int i = 0; i < data2.length; i++) {
			data2[i][0] = String.valueOf(translist2.get(i).getPlayer_Code());

			data2[i][1] = TeamName.getNowTeamName(translist2.get(i).getPlayer_Code());

			data2[i][2] = translist2.get(i).getPlayer_Name();

			data2[i][3] = translist2.get(i).getPlayer_Tel();

			data2[i][4] = translist2.get(i).getPlayer_Email();
		}

		table_3 = new JTable();
		table_3.setFont(new Font("KBIZ한마음고딕 M", Font.PLAIN, 14));
		table_3.setShowVerticalLines(false);
		table_3.setBorder(null);
		table_3.setRowHeight(40);
		table_3.setGridColor(Color.BLACK);
		table_3.setModel(new DefaultTableModel(data2, columnNames2) {
			@Override
			public Class<?> getColumnClass(int column) {
				return column == 1 ? Integer.class : String.class;
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		table_3.getColumnModel().getColumn(0).setPreferredWidth(149);
		table_3.getColumnModel().getColumn(1).setPreferredWidth(194);
		table_3.getTableHeader().setBackground(new Color(120, 168, 252));
		table_3.getTableHeader().setForeground(new Color(255, 255, 255));
		table_3.setSelectionBackground(new Color(232, 57, 95));
		table_3.setBounds(45, 479, 480, 240);

		DefaultTableCellRenderer tScheduleCellRenderer2 = new DefaultTableCellRenderer();
		tScheduleCellRenderer2.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcmSchedule2 = table_3.getColumnModel();
		for (int i = 0; i < tcmSchedule2.getColumnCount(); i++) {
			tcmSchedule2.getColumn(i).setCellRenderer(tScheduleCellRenderer2);
		}

		panel_3.add(table_3);
//		Object tablevalue=table.getValueAt(table.getSelectedRow(), table.getSelectedColumn());

		JScrollPane scrollPane_trans_waiting = new JScrollPane(table_3);
		scrollPane_trans_waiting.setFont(new Font("KBIZ한마음고딕 M", Font.PLAIN, 14));
		scrollPane_trans_waiting.setBounds(116, 473, 524, 200);
		panel_3.add(scrollPane_trans_waiting);

		JButton button = new JButton("\uC774\uC801 \uC2B9\uC778");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int result = JOptionPane.showConfirmDialog(null, "확인을 누르면 선수를 영입됩니다.", "선수영입",
						JOptionPane.OK_CANCEL_OPTION);
				if (result == 0) {
					thread.close();
					thread.interrupt();

					int a = Integer.valueOf((String) select());
					new Player_TransferDAO().transferOk(a, dto.getGroup_Code());

					JPanel Stn2_Button1 = new Btn2_Button1(frame, dto);
					frame.getContentPane().removeAll();
					frame.getContentPane().add(Stn2_Button1);
					frame.revalidate();
					frame.repaint();
				}
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("KBIZ한마음고딕 B", Font.PLAIN, 12));
		button.setBackground(new Color(71, 120, 197));
		button.setBounds(662, 474, 80, 35);
		panel_3.add(button);

		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setForeground(new Color(255, 255, 255));
		separator_3.setBounds(795, 96, 2, 625);
		panel_3.add(separator_3);

		int Group_Code = dto.getGroup_Code();

		gdao.selectAllGroups_Groupcode(Group_Code);

//		System.out.println("====== 이적 수락 대기중인 선수 ======");
//		
//		for (int i = 0; i < translist2.size(); i++) {
//			translist2.get(i);
//		}
//		

		ArrayList<GroupsDTO> list = gdao.selectAllGroups_Groupcode(Group_Code);

		BufferedImage image = list.get(0).getGroup_ResizeImg(100, 100);

		textname.setText(list.get(0).getGroup_Name());
		textaddress.setText(list.get(0).getGroup_Address());
		texthomepage.setText(list.get(0).getGroup_HomePage());
		texttel.setText(list.get(0).getGroup_Tel());
		lbl_image.setIcon(new ImageIcon(image));

		JButton button_3 = new JButton("\uC774\uC801 \uAC70\uBD80");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thread.close();
				thread.interrupt();

				int result = JOptionPane.showConfirmDialog(null, "확인을 누르면 선수를 영입이 거부됩니다.", "선수영입 거부",
						JOptionPane.OK_CANCEL_OPTION);
				if (result == 0) {
					int a = Integer.valueOf((String) select());
					new Player_TransferDAO().transferX(a, dto.getGroup_Code());

					JPanel Stn2_Button1 = new Btn2_Button1(frame, dto);
					frame.getContentPane().removeAll();
					frame.getContentPane().add(Stn2_Button1);
					frame.revalidate();
					frame.repaint();
				}
			}
		});
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("KBIZ한마음고딕 B", Font.PLAIN, 12));
		button_3.setBackground(new Color(71, 120, 197));
		button_3.setBounds(662, 531, 80, 35);
		panel_3.add(button_3);

		JLabel label_1 = new JLabel("\uC601\uC785 \uB9AC\uC2A4\uD2B8");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("만화진흥원체", Font.PLAIN, 25));
		label_1.setBounds(116, 397, 139, 45);
		panel_3.add(label_1);

		JSeparator separator_7 = new JSeparator();
		separator_7.setForeground(new Color(229, 229, 229));
		separator_7.setBounds(116, 453, 500, 10);
		panel_3.add(separator_7);

		JSeparator separator_8 = new JSeparator();
		separator_8.setForeground(new Color(229, 229, 229));
		separator_8.setBounds(885, 152, 316, 10);
		panel_3.add(separator_8);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(71, 120, 197));
		panel_5.setBounds(280, 0, 1320, 105);
		Lobby_Panel.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(71, 120, 197));
		panel_6.setBounds(0, 0, 1320, 105);
		panel_5.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(71, 120, 197));
		panel_7.setBounds(42, 0, 111, 105);
		panel_6.add(panel_7);
		panel_7.setLayout(new CardLayout(0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBackground(new Color(71, 120, 197));
		panel_8.setBounds(153, 0, 651, 105);
		panel_6.add(panel_8);
		
		JLabel label_4 = new JLabel((String) null);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("KBIZ한마음고딕 H", Font.PLAIN, 35));
		label_4.setBounds(0, 22, 420, 61);
		label_4.setText(arr_group.get(0).getGroup_Name());
		panel_8.add(label_4);

		ArrayList<PlayerDTO> translist = new ArrayList<PlayerDTO>();
		translist = transdao.transferTo(Group_Code);
		for (int i = 0; i < translist.size(); i++) {
			System.out.println(translist.get(i) + "234234");
		}

		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				thread.close();
				thread.interrupt();

				AddressToLocalCode L_Code = new AddressToLocalCode();
				int g_LocalCode = L_Code.getLocalCode(textaddress.getText());

				gdto.setGroup_Code(dto.getGroup_Code());
				gdto.setGroup_Address(textaddress.getText());
				gdto.setGroup_HomePage(texthomepage.getText());
				gdto.setGroup_LocalCode(g_LocalCode);
				gdto.setGroup_Name(textname.getText());
				gdto.setGroup_Tel(texttel.getText());

				if (gdto.getGroup_Img() == null) {
					gdto.setGroup_Img_Bytes(list.get(0).getGroup_Img());
				}

				boolean chheck = gdao.update(gdto);

				if (chheck) {
					System.out.println("변경성공");
				} else {
					System.out.println("변경실패");
				}

			}
		});

		thread = new Transfer_Thread(this.frame, this.dto);
		thread.start();
	}

	@Override
	public void focusGained(FocusEvent e) {
		if (e.getSource() == textname) {
			textname.setText("");
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub

	}

	public Object select() {
		return table_3.getValueAt(table_3.getSelectedRow(), 0);
	}
	
	
}
