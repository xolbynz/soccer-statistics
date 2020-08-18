package P6_Temp;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import P3_DAO.loginDAO;
import P3_DAO.testDAO;
import P4_DTO.loginDTO;
import P4_DTO.testDTO;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class testMain_Fram {

	private JFrame frame;
	private JTextField txt_id;
	private JTextField txt_pw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testMain_Fram window = new testMain_Fram();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public testMain_Fram() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 580, 392);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel label = new JLabel("");
		label.setBounds(219, 0, 345, 344);

		frame.getContentPane().setLayout(null);

		label.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(label);

		txt_id = new JTextField();
		txt_id.setBounds(52, 39, 155, 21);
		frame.getContentPane().add(txt_id);
		txt_id.setColumns(10);

		JLabel lblId = new JLabel("ID");
		lblId.setBounds(29, 42, 57, 15);
		frame.getContentPane().add(lblId);

		txt_pw = new JTextField();
		txt_pw.setBounds(52, 70, 155, 21);
		frame.getContentPane().add(txt_pw);
		txt_pw.setColumns(10);

		JLabel lblNewLabel = new JLabel("PW");
		lblNewLabel.setBounds(29, 73, 57, 15);
		frame.getContentPane().add(lblNewLabel);

		JButton button = new JButton("\uB85C\uADF8\uC778");
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				loginDAO dao = new loginDAO();

				loginDTO dto = dao
						.Login(new loginDTO(txt_id.getText(), 0, null, txt_pw.getText(), null, 1, null, null, 0));

				if (dto == null) {
					System.out.println("로그인실패");
				} else {
					System.out.println("로그인성공");
					label.setIcon(new ImageIcon(dto.getMember_ResizeImg(345, 344)));
				}
			}
		});
		button.setBounds(78, 101, 97, 23);
		frame.getContentPane().add(button);
	}
}
