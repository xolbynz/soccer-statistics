package P2_View;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

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
import javax.swing.table.DefaultTableModel;

import P3_DAO.GroupsDAO;
import P3_DAO.SignUpDAO;
import P3_DAO.loginDAO;
import P4_DTO.GroupsDTO;
import P4_DTO.SignUpDTO;
import P4_DTO.loginDTO;
import P7_Util.AddressToLocalCode;
import P7_Util.Emailcheck;
import P7_Util.fileExtension;
import P7_Util.passwordCheck;

import javax.swing.JScrollPane;
import java.awt.Cursor;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Btn4_Button1 extends JPanel implements FocusListener {
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textname;
	private JTextField textadress;
	private JTextField texttel;
	private JTextField textGrop;
	private JLabel label_id_check;
	private JLabel label_pw_check;
	private JLabel label_pw_re_check;
	private JLabel label_name_check;
	private JFrame frame;
	private loginDTO dto;
	public String jPath;
	private loginDAO dao = new loginDAO();
	private GroupsDTO gdto;
	private GroupsDAO gdao = new GroupsDAO();

	/**
	 * Create the panel.
	 */
	public Btn4_Button1(JFrame frame, loginDTO dto) {
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
		lblNewLabel_1.setIcon(new ImageIcon(Btn4_Button1.class.getResource("/P5_Img/icons8_exit_32px.png")));
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
		label.setIcon(new ImageIcon(Btn4_Button1.class.getResource("/P5_Img/icons8_search_32px.png")));

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
		btn4.setBackground(new Color(255, 255, 255, 20));
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

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 5, 80);
		btn4.add(panel_2);
		panel_2.setBackground(Color.WHITE);

		JPanel GudanPanel = new JPanel();
		GudanPanel.setBackground(new Color(71, 120, 197));
		GudanPanel.setBounds(280, 0, 1320, 105);
		Lobby_Panel.add(GudanPanel);
		GudanPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(71, 120, 197));
		panel.setBounds(0, 0, 1320, 105);
		GudanPanel.add(panel);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(71, 120, 197));
		panel_5.setBounds(42, 0, 111, 105);
		panel.add(panel_5);
		panel_5.setLayout(new CardLayout(0, 0));

		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(71, 120, 197));
		panel_6.setBounds(153, 0, 651, 105);
		panel.add(panel_6);

		JLabel label_1 = new JLabel((String) null);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("KBIZ한마음고딕 H", Font.PLAIN, 35));
		label_1.setBounds(0, 22, 420, 61);
		label_1.setText(arr_group.get(0).getGroup_Name());

		panel_6.add(label_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(280, 104, 1320, 796);
		Lobby_Panel.add(panel_3);
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(23, 35, 51));

		textField_1 = new JTextField();
		textField_1.setText("");
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("나눔고딕", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBackground(new Color(23, 35, 51));
		textField_1.setBounds(0, 0, 0, 0);
		panel_3.add(textField_1);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(100, 311, 316, 2);
		panel_3.add(separator_1);

		label_id_check = new JLabel("\uC774\uBBF8 \uC874\uC7AC\uD558\uB294 \uC774\uBA54\uC77C\uC785\uB2C8\uB2E4.");
		label_id_check.setForeground(Color.GRAY);
		label_id_check.setFont(new Font("KBIZ한마음고딕 M", Font.PLAIN, 16));
		label_id_check.setBounds(100, 286, 265, 15);
		panel_3.add(label_id_check);

		passwordField = new JPasswordField();
		passwordField.setForeground(Color.WHITE);
		passwordField.setFont(new Font("KBIZ한마음고딕 M", Font.PLAIN, 16));
		passwordField.setBorder(null);
		passwordField.setBackground(new Color(23, 35, 51));
		passwordField.setBounds(100, 356, 316, 21);
		passwordField.addFocusListener(this);
		passwordField.setEchoChar((char)0); 
		passwordField.setText("비밀번호");
		panel_3.add(passwordField);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(100, 387, 316, 2);
		panel_3.add(separator_2);

		label_pw_check = new JLabel("");
		label_pw_check.setForeground(Color.RED);
		label_pw_check.setFont(new Font("나눔고딕", Font.PLAIN, 14));
		label_pw_check.setBounds(100, 399, 265, 15);
		panel_3.add(label_pw_check);

		passwordField_1 = new JPasswordField();
		passwordField_1.setForeground(Color.WHITE);
		passwordField_1.setFont(new Font("KBIZ한마음고딕 M", Font.PLAIN, 16));
		passwordField_1.setBorder(null);
		passwordField_1.setBackground(new Color(23, 35, 51));
		passwordField_1.setBounds(100, 434, 316, 21);
		passwordField_1.addFocusListener(this);
		passwordField_1.setEchoChar((char)0); 
		passwordField_1.setText("비밀번호 확인");
		panel_3.add(passwordField_1);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(100, 465, 316, 2);
		panel_3.add(separator_3);

		label_pw_re_check = new JLabel("");
		label_pw_re_check.setForeground(Color.RED);
		label_pw_re_check.setFont(new Font("나눔고딕", Font.PLAIN, 14));
		label_pw_re_check.setBounds(100, 477, 265, 15);
		panel_3.add(label_pw_re_check);

		textname = new JTextField();
		textname.setText("\uB2C9\uB124\uC784");
		textname.setForeground(Color.WHITE);
		textname.setFont(new Font("KBIZ한마음고딕 M", Font.PLAIN, 16));
		textname.setColumns(10);
		textname.setBorder(null);
		textname.setBackground(new Color(23, 35, 51));
		textname.setBounds(100, 518, 316, 21);
		textname.addFocusListener(this);
		panel_3.add(textname);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(100, 549, 316, 2);
		panel_3.add(separator_4);

		label_name_check = new JLabel("");
		label_name_check.setForeground(Color.RED);
		label_name_check.setFont(new Font("나눔고딕", Font.PLAIN, 14));
		label_name_check.setBounds(100, 561, 265, 15);
		panel_3.add(label_name_check);

		textadress = new JTextField();
		textadress.setText("\uC8FC\uC18C");
		textadress.setForeground(Color.WHITE);
		textadress.setFont(new Font("KBIZ한마음고딕 M", Font.PLAIN, 16));
		textadress.setColumns(10);
		textadress.setBorder(null);
		textadress.setBackground(new Color(23, 35, 51));
		textadress.setBounds(463, 280, 316, 21);
		textadress.addFocusListener(this);
		panel_3.add(textadress);

		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(463, 311, 316, 2);
		panel_3.add(separator_5);

		IntegerDocument id = new IntegerDocument();

		texttel = new JTextField();
		texttel.setForeground(Color.WHITE);
		texttel.setFont(new Font("KBIZ한마음고딕 M", Font.PLAIN, 16));
		texttel.setColumns(10);
		texttel.setBorder(null);
		texttel.setBackground(new Color(23, 35, 51));
		texttel.setBounds(463, 336, 316, 21);
		texttel.addFocusListener(this);
		texttel.setDocument(id);
		panel_3.add(texttel);

		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(463, 367, 316, 2);
		panel_3.add(separator_6);

		textGrop = new JTextField();
		textGrop.setForeground(Color.WHITE);
		textGrop.setFont(new Font("KBIZ한마음고딕 M", Font.PLAIN, 16));
		textGrop.setColumns(10);
		textGrop.setBorder(null);
		textGrop.setBackground(new Color(23, 35, 51));
		textGrop.setBounds(463, 409, 316, 21);
		textGrop.setText(arr_group.get(0).getGroup_Name());
		textGrop.addFocusListener(this);
		panel_3.add(textGrop);

		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(463, 440, 316, 2);
		panel_3.add(separator_7);

		JButton button = new JButton("\uAD6C\uB2E8\uCC3E\uAE30");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		button.setBackground(new Color(71, 120, 197));
		button.setBounds(791, 407, 89, 23);
		panel_3.add(button);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(240, 240, 240));
		panel_4.setBounds(100, 100, 100, 100);
		panel_3.add(panel_4);
		SpringLayout sl_panel_4 = new SpringLayout();
		panel_4.setLayout(sl_panel_4);

		JLabel label_Image = new JLabel("New label");
		sl_panel_4.putConstraint(SpringLayout.NORTH, label_Image, 0, SpringLayout.NORTH, panel_4);
		sl_panel_4.putConstraint(SpringLayout.WEST, label_Image, 0, SpringLayout.WEST, panel_4);
		sl_panel_4.putConstraint(SpringLayout.SOUTH, label_Image, 100, SpringLayout.NORTH, panel_4);
		sl_panel_4.putConstraint(SpringLayout.EAST, label_Image, 100, SpringLayout.WEST, panel_4);
		panel_4.add(label_Image);
		label_Image.setIcon(new ImageIcon(dto.getMember_ResizeImg(100, 100)));

		JButton button_1 = new JButton("\uC0AC\uC9C4\uCC3E\uAE30");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

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
						jPath = selectedFile.getAbsolutePath();

						SignUpDTO dto = new SignUpDTO();

						dto.setMember_Img(jPath);
						dto.getMember_Img();

						label_Image.setIcon(new ImageIcon(dto.getMember_ResizeImg(100, 100)));

					} else {
						JOptionPane.showMessageDialog(null, "이미지 확장자를 넣어주세요 ");

					}

				} else {
					JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다", "경고", JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		button_1.setBackground(new Color(71, 120, 197));
		button_1.setBounds(212, 177, 89, 23);
		panel_3.add(button_1);
		label_id_check.setText(dto.getMember_Email());
		textname.setText(dto.getMember_Nickname());
		textadress.setText(dto.getMember_Address());
		texttel.setText(dto.getMember_Tel());

		JButton button_2 = new JButton("\uBCC0\uACBD");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				AddressToLocalCode L_Code = new AddressToLocalCode();
				int member_LocalCode = L_Code.getLocalCode(textadress.getText());
				String textpassword = String.valueOf(passwordField.getPassword());
				System.out.println(textpassword);
				int View_power = dto.getView_Power();
				System.out.println("뷰포인트>>" + View_power);

				dto.setMember_Pw(textpassword);
				dto.setMember_Nickname(textname.getText());
				dto.setMember_Tel(texttel.getText());
				dto.setMember_Address(textadress.getText());
				dto.setMember_LocalCode(member_LocalCode);
				dto.setMember_Img(jPath);

				System.out.println("pw  " + dto.getMember_Pw());
				System.out.println("nic  " + dto.getMember_Nickname());
				System.out.println("tel  " + dto.getMember_Tel());
				System.out.println("add  " + dto.getMember_Address());
				System.out.println("local  " + dto.getMember_LocalCode());
				System.out.println("img  " + dto.getMember_Img());

				boolean chheck = dao.update(dto);
				if (chheck) {
					System.out.println("변경성공");
				} else {
					System.out.println("변경실패");
				}

				JOptionPane.showMessageDialog(null, "정보 변경했습니다. 잘 기억해주세요", "성공", JOptionPane.PLAIN_MESSAGE);
			}
		});
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		button_2.setBackground(new Color(71, 120, 197));
		button_2.setBounds(574, 510, 80, 35);
		panel_3.add(button_2);

	}

	@Override
	public void focusGained(FocusEvent e) {
	}

	@Override
	public void focusLost(FocusEvent e) {

	}
}
