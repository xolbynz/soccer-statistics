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


import P3_DAO.GroupsDAO;
import P3_DAO.PlayerDAO;
import P3_DAO.Player_PositionDAO;
import P4_DTO.GroupsDTO;
import P4_DTO.PlayerDTO;
import P4_DTO.PlayerPositionDTO;
import P4_DTO.loginDTO;


public class ModifyPosiDialog extends JDialog implements FocusListener {

	private final JPanel contentPanel = new JPanel();
	private static JDialog dialog = new JDialog();
	private static Point point = new Point();
	private JTextField txtDummy;
	private JTextField txt_Name;
	private JTextField txt_Phone;
	public String jPath;
	private static Point point1 = new Point();
	public JFrame frame;
	public loginDTO dto;
	public int PLAYER_CODE;


	/**
	 * Create the dialog.
	 * 
	 * @param result
	 */
	public ModifyPosiDialog(loginDTO dto, JFrame frame, int PLAYER_CODE) {
		this.frame = frame;
		this.dto = dto;
		this.PLAYER_CODE = PLAYER_CODE;
		initialize();

		IntegerDocument id = new IntegerDocument();

		setBounds(800, 450, 264, 155);
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
				int result = JOptionPane.showConfirmDialog(null, "확인을 누르면 포지션이 입력됩니다.", "포지션등록",
						JOptionPane.OK_CANCEL_OPTION);

				if (result == 0) {
					new Player_PositionDAO().joinPlayer_Position(new PlayerPositionDTO(0, PLAYER_CODE, dto.getGroup_Code(), txt_Name.getText()));
					reSet();
					setVisible(false);
				}
			}
		});
		btn_accept.setForeground(Color.WHITE);
		btn_accept.setBackground(new Color(71, 120, 197));
		btn_accept.setFont(new Font("BM_DOHYEON", Font.BOLD, 12));
		btn_accept.setBounds(26, 86, 70, 30);
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
		btn_cancel.setBounds(153, 84, 70, 30);
		contentPanel.add(btn_cancel);

		txt_Name = new JTextField();
		txt_Name.setText("\uD3EC\uC9C0\uC158\uBA85");
		txt_Name.setForeground(Color.WHITE);
		txt_Name.setFont(new Font("KBIZ한마음고딕 M", Font.PLAIN, 14));
		txt_Name.setColumns(10);
		txt_Name.setBorder(null);
		txt_Name.setBackground(new Color(23, 35, 51));
		txt_Name.setBounds(37, 23, 145, 21);
		txt_Name.addFocusListener(this);
		contentPanel.add(txt_Name);

		JSeparator separator = new JSeparator();
		separator.setBounds(37, 54, 145, 2);
		contentPanel.add(separator);

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

	}

	@Override
	public void focusGained(FocusEvent e) {
		if (e.getSource() == txt_Name) {
			txt_Name.setText("");
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
		JPanel Btn1_Button5 = new Btn1_Button5(frame, dto, PLAYER_CODE);

		frame.getContentPane().removeAll();
		frame.getContentPane().add(Btn1_Button5);
		frame.revalidate();
		frame.repaint();
	}

}