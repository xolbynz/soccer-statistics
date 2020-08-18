package P6_Temp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

import P3_DAO.PlayerDAO;
import P4_DTO.PlayerDTO;
import P7_Util.AddressToLocalCode;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class testMain2_Frame {

	private JFrame frame;
	private JTextField txt_Player_Name;
	private JTextField txt_Player_Tel;
	private JTextField txt_Player_Email;
	private JTextField txt_Player_Address;
	private JLabel lblNewLabel_4;
	private JLabel label_1;
	private JTextField txt_Player_Img;
	private PlayerDAO pdao = new PlayerDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testMain2_Frame window = new testMain2_Frame();
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
	public testMain2_Frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 636, 270);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(12, 10, 57, 15);
		frame.getContentPane().add(lblNewLabel);

		txt_Player_Name = new JTextField();
		txt_Player_Name.setBounds(77, 30, 116, 21);
		frame.getContentPane().add(txt_Player_Name);
		txt_Player_Name.setColumns(10);

		txt_Player_Tel = new JTextField();
		txt_Player_Tel.setBounds(77, 56, 116, 21);
		frame.getContentPane().add(txt_Player_Tel);
		txt_Player_Tel.setColumns(10);

		txt_Player_Email = new JTextField();
		txt_Player_Email.setBounds(77, 81, 116, 21);
		frame.getContentPane().add(txt_Player_Email);
		txt_Player_Email.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\uC120\uC218\uC774\uB984");
		lblNewLabel_1.setBounds(12, 35, 57, 15);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\uC5F0\uB77D\uCC98");
		lblNewLabel_2.setBounds(12, 59, 57, 15);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\uC774\uBA54\uC77C");
		lblNewLabel_3.setBounds(12, 84, 57, 15);
		frame.getContentPane().add(lblNewLabel_3);

		JButton butt_FileSearch = new JButton("\uD30C\uC77C \uCC3E\uAE30");
		butt_FileSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

				int returnValue = jfc.showOpenDialog(null);

				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = jfc.getSelectedFile();
					txt_Player_Img.setText(selectedFile.getAbsolutePath());
				}
			}
		});
		butt_FileSearch.setBounds(194, 116, 102, 15);
		frame.getContentPane().add(butt_FileSearch);

		txt_Player_Address = new JTextField();
		txt_Player_Address.setBounds(77, 138, 116, 21);
		frame.getContentPane().add(txt_Player_Address);
		txt_Player_Address.setColumns(10);

		lblNewLabel_4 = new JLabel("\uC120\uC218\uC774\uBBF8\uC9C0");
		lblNewLabel_4.setBounds(12, 116, 76, 15);
		frame.getContentPane().add(lblNewLabel_4);

		label_1 = new JLabel("\uC8FC\uC18C");
		label_1.setBounds(12, 141, 57, 15);
		frame.getContentPane().add(label_1);

		JButton button = new JButton("\uC120\uC218\uB4F1\uB85D");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int cnt = pdao.joinPlayer(new PlayerDTO(1, 1, txt_Player_Name.getText(), txt_Player_Tel.getText(),
						txt_Player_Img.getText(), txt_Player_Email.getText(),
						AddressToLocalCode.getLocalCode(txt_Player_Address.getText()), txt_Player_Address.getText()));
			}
		});
		button.setBounds(87, 169, 97, 23);
		frame.getContentPane().add(button);

		txt_Player_Img = new JTextField();
		txt_Player_Img.setEditable(false);
		txt_Player_Img.setBounds(77, 113, 116, 21);
		frame.getContentPane().add(txt_Player_Img);
		txt_Player_Img.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBounds(306, 10, 302, 211);
		frame.getContentPane().add(panel);
		panel.setLayout(new CardLayout(0, 0));

		JLabel image_Label = new JLabel("");
		panel.add(image_Label, "name_59568161012900");
	}
}
