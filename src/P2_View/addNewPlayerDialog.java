package P2_View;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import P3_DAO.GroupsDAO;
import P3_DAO.PlayerDAO;
import P4_DTO.GroupsDTO;
import P4_DTO.PlayerDTO;
import P4_DTO.SignUpDTO;
import P4_DTO.loginDTO;
import P7_Util.AddressToLocalCode;
import P7_Util.fileExtension;

public class addNewPlayerDialog extends JDialog implements FocusListener {

	private final JPanel contentPanel = new JPanel();
	private static JDialog dialog = new JDialog();
	private static Point point = new Point();
	private JTextField txtDummy;
	private GroupsDAO dao = new GroupsDAO();
	private GroupsDTO result;
	private ArrayList<GroupsDTO> list;
	private JTextField txt_Name;
	private JTextField txt_Phone;
	private JTextField txt_Email;
	private JTextField txt_address;
	private JLabel Phone_label;
	private PlayerDTO pdto;
	private PlayerDAO pdao = new PlayerDAO();
	public String jPath;
	private static Point point1 = new Point();
	public JFrame frame;
	public loginDTO dto;
	public SignUpDTO s_dto;

	/**
	 * Create the dialog.
	 * 
	 * @param result
	 */
	public addNewPlayerDialog(loginDTO dto, JFrame frame) {
		this.frame = frame;
		this.dto = dto;
		initialize();

		IntegerDocument id = new IntegerDocument();

		setBounds(100, 100, 800, 450);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(23, 35, 51));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			{
				txtDummy = new JTextField();
				txtDummy.setBounds(0, 0, 0, 0);
				contentPanel.add(txtDummy);
				txtDummy.setColumns(10);
			}
		}

		JButton btn_accept = new JButton("확인");
		btn_accept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddressToLocalCode L_Code = new AddressToLocalCode();

				int LocalCode = L_Code.getLocalCode(txt_address.getText());
				int cnt = pdao.joinPlayer(new PlayerDTO(0, dto.getGroup_Code(), txt_Name.getText(), txt_Phone.getText(),
						s_dto.getMember_Img(), txt_Email.getText(), LocalCode, txt_address.getText()));

				if (cnt > 0) {
					JOptionPane.showMessageDialog(null, "선수를 성공적으로 추가했습니다.", "선수추가 성공", JOptionPane.PLAIN_MESSAGE);
					reSet();
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "입력된 정보를 확인해 주세요", "선수추가 실패", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btn_accept.setForeground(Color.WHITE);
		btn_accept.setBackground(new Color(71, 120, 197));
		btn_accept.setFont(new Font("BM_DOHYEON", Font.BOLD, 12));
		btn_accept.setBounds(200, 360, 70, 30);
		contentPanel.add(btn_accept);

		JButton btn_cancel = new JButton("취소");
		btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btn_cancel.setForeground(Color.WHITE);
		btn_cancel.setBackground(new Color(71, 120, 197));
		btn_cancel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btn_cancel.setBounds(350, 360, 70, 30);
		contentPanel.add(btn_cancel);

		txt_Name = new JTextField();
		txt_Name.setText("\uC774\uB984");
		txt_Name.setForeground(Color.WHITE);
		txt_Name.setFont(new Font("KBIZ한마음고딕 M", Font.PLAIN, 14));
		txt_Name.setColumns(10);
		txt_Name.setBorder(null);
		txt_Name.setBackground(new Color(23, 35, 51));
		txt_Name.setBounds(124, 207, 145, 21);
		txt_Name.addFocusListener(this);
		contentPanel.add(txt_Name);

		JSeparator separator = new JSeparator();
		separator.setBounds(124, 238, 145, 2);
		contentPanel.add(separator);

		Phone_label = new JLabel("\uC5F0\uB77D\uCC98");
		Phone_label.setForeground(Color.WHITE);
		Phone_label.setFont(new Font("KBIZ한마음고딕 M", Font.PLAIN, 14));
		Phone_label.setBounds(124, 256, 102, 15);
		contentPanel.add(Phone_label);

		txt_Phone = new JTextField();
		txt_Phone.setText("\uC5F0\uB77D\uCC98");
		txt_Phone.setForeground(Color.WHITE);
		txt_Phone.setFont(new Font("KBIZ한마음고딕 M", Font.PLAIN, 14));
		txt_Phone.setColumns(10);
		txt_Phone.setBorder(null);
		txt_Phone.setBackground(new Color(23, 35, 51));
		txt_Phone.setBounds(124, 254, 145, 21);
		txt_Phone.setDocument(id);
		txt_Phone.addFocusListener(this);
		contentPanel.add(txt_Phone);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(124, 285, 145, 2);
		contentPanel.add(separator_1);

		txt_Email = new JTextField();
		txt_Email.setText("\uC774\uBA54\uC77C");
		txt_Email.setForeground(Color.WHITE);
		txt_Email.setFont(new Font("KBIZ한마음고딕 M", Font.PLAIN, 14));
		txt_Email.setColumns(10);
		txt_Email.setBorder(null);
		txt_Email.setBackground(new Color(23, 35, 51));
		txt_Email.setBounds(350, 207, 145, 21);
		txt_Email.addFocusListener(this);
		contentPanel.add(txt_Email);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(350, 238, 145, 2);
		contentPanel.add(separator_2);

		txt_address = new JTextField();
		txt_address.setText("\uC8FC\uC18C");
		txt_address.setForeground(Color.WHITE);
		txt_address.setFont(new Font("KBIZ한마음고딕 M", Font.PLAIN, 14));
		txt_address.setColumns(10);
		txt_address.setBorder(null);
		txt_address.setBackground(new Color(23, 35, 51));
		txt_address.setBounds(350, 254, 145, 21);
		txt_address.addFocusListener(this);
		contentPanel.add(txt_address);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(350, 285, 145, 2);
		contentPanel.add(separator_3);

		JPanel picturePanel = new JPanel();
		picturePanel.setBackground(Color.WHITE);
		picturePanel.setBounds(124, 56, 100, 100);
		contentPanel.add(picturePanel);
		picturePanel.setLayout(new CardLayout(0, 0));

		JLabel lbl_icon = new JLabel("");
		picturePanel.add(lbl_icon, "name_115422094258500");

		JButton btn_findPicture = new JButton("\uC0AC\uC9C4\uCC3E\uAE30");
		btn_findPicture.addActionListener(new ActionListener() {
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
						jPath = selectedFile.getAbsolutePath();

						s_dto = new SignUpDTO();

						s_dto.setMember_Img(jPath);
						s_dto.getMember_Img();

						lbl_icon.setIcon(new ImageIcon(s_dto.getMember_ResizeImg(100, 100)));

					} else {
						JOptionPane.showMessageDialog(null, "이미지 확장자를 넣어주세요 ");

					}

				} else {
					JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다", "경고", JOptionPane.WARNING_MESSAGE);
				}
			}

		});
		btn_findPicture.setForeground(Color.WHITE);
		btn_findPicture.setFont(new Font("KBIZ한마음고딕 M", Font.PLAIN, 12));
		btn_findPicture.setBackground(new Color(71, 120, 197));
		btn_findPicture.setBounds(236, 131, 90, 25);
		contentPanel.add(btn_findPicture);

	}

	@Override
	public void focusGained(FocusEvent e) {
		if (e.getSource() == txt_Name) {
			txt_Name.setText("");
		} else if (e.getSource() == txt_Phone) {
			Phone_label.setText("");
		} else if (e.getSource() == txt_Email) {
			txt_Email.setText("");
		} else if (e.getSource() == txt_address) {
			txt_address.setText("");
		}
	}

	@Override
	public void focusLost(FocusEvent e) {

	}

	private void initialize() {
		dialog.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				point1.x = e.getX();
				point1.y = e.getY();
			}
		});
		dialog.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point p = dialog.getLocation();
				dialog.setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
			}
		});

//		JPanel panel = new LoginWindow(dialog);
//		frame.getContentPane().add(panel, "name_846404528803000");
	}
	
	public void reSet() {
		JPanel Btn1_Button5 = new Btn1_Button5(frame, dto, new PlayerDAO().getStatusPlayerCode());
		System.out.println(frame);
		System.out.println(dto);
		System.out.println(new PlayerDAO().getStatusPlayerCode());
		System.out.println(Btn1_Button5);
		frame.getContentPane().removeAll();
		frame.getContentPane().add(Btn1_Button5);
		frame.revalidate();
		frame.repaint();
	}

}