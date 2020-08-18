package P2_View;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import P3_DAO.loginDAO;
import P4_DTO.loginDTO;
import javazoom.jl.player.MP3Player;
import java.awt.Cursor;

public class LoginWindow extends JPanel {
	private JTextField txt_id;
	private JPasswordField pwField;
	private MP3Player mp3 = new MP3Player();
	private loginDAO dao = new loginDAO();
	private JFrame frame;

	/**
	 * Create the panel.
	 * 
	 * @param frame
	 */

	public LoginWindow(JFrame frame) {
		this.frame = frame;

		mp3.play("src/P7_Util/Champions_league.mp3");

		setLayout(new CardLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, "name_849222918453700");
		panel.setLayout(null);

		JPanel panel_back_left = new JPanel();
		panel_back_left.setBounds(0, 0, 1053, 900);
		panel.add(panel_back_left);
		panel_back_left.setLayout(null);

		JLabel lbl_img = new JLabel("");
		lbl_img.setBounds(-368, -151, 1730, 1051);
		panel_back_left.add(lbl_img);
		lbl_img.setIcon(new ImageIcon(LoginWindow.class.getResource("/P5_Img/uefa.jpg")));

		JPanel panel_back_right = new JPanel();
		panel_back_right.setBounds(1052, 0, 548, 900);
		panel.add(panel_back_right);
		panel_back_right.setBackground(new Color(23, 35, 51));
		panel_back_right.setLayout(null);

		JLabel lbl_id = new JLabel("\uC544\uC774\uB514");
		lbl_id.setFont(new Font("KBIZ한마음고딕 B", Font.PLAIN, 16));
		lbl_id.setForeground(new Color(255, 255, 255));
		lbl_id.setBounds(116, 227, 57, 15);
		panel_back_right.add(lbl_id);

		txt_id = new JTextField();
		txt_id.setBorder(null);
		txt_id.setText("");
		txt_id.setFont(new Font("KBIZ한마음고딕 M", Font.PLAIN, 16));
		txt_id.setForeground(new Color(255, 255, 255));
		txt_id.setBackground(new Color(23, 35, 51));
		txt_id.setBounds(116, 261, 316, 21);
		panel_back_right.add(txt_id);
		txt_id.setColumns(10);

		JSeparator id_separator = new JSeparator();
		id_separator.setBounds(116, 292, 316, 2);
		panel_back_right.add(id_separator);

		JSeparator pw_separator = new JSeparator();
		pw_separator.setBounds(116, 432, 316, 2);
		panel_back_right.add(pw_separator);

		JLabel lbl_pw = new JLabel("\uD328\uC2A4\uC6CC\uB4DC");
		lbl_pw.setForeground(Color.WHITE);
		lbl_pw.setFont(new Font("KBIZ한마음고딕 B", Font.PLAIN, 16));
		lbl_pw.setBounds(116, 357, 75, 15);
		panel_back_right.add(lbl_pw);

		pwField = new JPasswordField();
		pwField.setFont(new Font("굴림", Font.PLAIN, 16));
		pwField.setBorder(null);
		pwField.setForeground(Color.WHITE);
		pwField.setBackground(new Color(23, 35, 51));
		pwField.setBounds(116, 401, 316, 21);
		panel_back_right.add(pwField);

		Button btn_sign_in = new Button("\uB85C\uADF8\uC778");
		btn_sign_in.setFont(new Font("KBIZ한마음고딕 B", Font.BOLD, 16));
		btn_sign_in.setForeground(new Color(255, 255, 255));
		btn_sign_in.setBackground(new Color(71, 120, 197));
		btn_sign_in.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loginDTO dto = dao.Login(new loginDTO(txt_id.getText(), 1, null, String.valueOf(pwField.getPassword()),
						null, 1, null, null, 1));

				if (dto == null) {
					JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 존재하지 않습니다.", "로그인 실패", JOptionPane.ERROR_MESSAGE);
				} else {
					if (mp3.isPlaying()) {
						mp3.stop();
					}
					// 이동할 판넬 생성과 판넬에게 전달해 줄 frame과 데이터
					JPanel lobby = new Lobby(frame, dto);

					// 프레임속 기존의 판넬을 삭제
					frame.getContentPane().removeAll();
					// 새로운 로비 판넬 삽입
					frame.getContentPane().add(lobby);
					// 그뒤 필요한 먼가의 과정
					frame.revalidate();
					frame.repaint();
				}

			}
		});

		btn_sign_in.setBounds(116, 501, 316, 60);
		panel_back_right.add(btn_sign_in);

		JLabel lbl_sign_up_intro = new JLabel("\uC544\uC9C1 \uD68C\uC6D0\uC774 \uC544\uB2C8\uC2E0\uAC00\uC694?");
		lbl_sign_up_intro.setForeground(Color.WHITE);
		lbl_sign_up_intro.setFont(new Font("KBIZ한마음고딕 M", Font.PLAIN, 14));
		lbl_sign_up_intro.setBounds(116, 581, 143, 15);
		panel_back_right.add(lbl_sign_up_intro);

		JLabel lbl_X = new JLabel("X");
		lbl_X.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lbl_X.setForeground(Color.WHITE);
		lbl_X.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lbl_X.setBounds(515, 10, 21, 15);
		panel_back_right.add(lbl_X);

		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		lblNewLabel.setFont(new Font("KBIZ한마음고딕 B", Font.PLAIN, 14));
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				{
					if (mp3.isPlaying()) {
						mp3.stop();
					}
					// 이동할 판넬 생성과 판넬에게 전달해 줄 frame과 데이터
					JPanel SignUpWindow = new SignUpWindow(frame);

					// 프레임속 기존의 판넬을 삭제
					frame.getContentPane().removeAll();
					// 새로운 로비 판넬 삽입
					frame.getContentPane().add(SignUpWindow);
					// 그뒤 필요한 먼가의 과정
					frame.revalidate();
					frame.repaint();
				}
				
			}
		});
		lblNewLabel.setForeground(new Color(120, 168, 252));
		lblNewLabel.setBounds(292, 582, 57, 15);
		panel_back_right.add(lblNewLabel);

	}
}
