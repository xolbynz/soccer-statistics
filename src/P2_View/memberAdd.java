package P2_View;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import P3_DAO.testDAO;
import P7_Util.fileExtension;

import P7_Util.passwordCheck;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Choice;


public class memberAdd implements FocusListener {

	public JFrame frame;
	public JTextField textID;
	public JTextField textPW;
	public JLabel lbl_IDCheck;
	public testDAO dao = new testDAO();
	private JTextField textField;
	private JTextField textField_1;
	public JPasswordField tf_pw;
	public JLabel lbl_pwcheck;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					memberAdd window = new memberAdd();
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
	public memberAdd() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 590);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);

		JLabel lbl_Image = new JLabel("-");
		frame.getContentPane().add(lbl_Image);

		JButton btn_Image = new JButton("\uD30C\uC77C \uCC3E\uAE30");
		springLayout.putConstraint(SpringLayout.NORTH, lbl_Image, 4, SpringLayout.NORTH, btn_Image);
		springLayout.putConstraint(SpringLayout.EAST, btn_Image, -83, SpringLayout.EAST, frame.getContentPane());
		
		btn_Image.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				FileNameExtensionFilter ExtenseFilter =new FileNameExtensionFilter("jpg & GIF IMAGES", "jpg","gif");
				jfc.setFileFilter(ExtenseFilter);
				int returnValue = jfc.showOpenDialog(null);
				// int returnValue = jfc.showSaveDialog(null);

				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = jfc.getSelectedFile();
					System.out.println(selectedFile.getAbsolutePath());
					
					boolean ExtensionOfFile = fileExtension.getfileExtension(selectedFile.getAbsolutePath());
					System.out.println(ExtensionOfFile);
					if (ExtensionOfFile) {
						lbl_Image.setText(selectedFile.getAbsolutePath());
						JOptionPane.showMessageDialog(null,"업로드완료" );
						
					}else {
						JOptionPane.showMessageDialog(null,"그림만 넣어!" );
						
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null,"파일을 선택하지 않았습니다","경고",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		frame.getContentPane().add(btn_Image);

		JLabel label_Id = new JLabel("\uC544\uC774\uB514");
		springLayout.putConstraint(SpringLayout.WEST, label_Id, 76, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(label_Id);

		textID = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, lbl_Image, 0, SpringLayout.WEST, textID);
		springLayout.putConstraint(SpringLayout.EAST, lbl_Image, 0, SpringLayout.EAST, textID);
		springLayout.putConstraint(SpringLayout.WEST, textID, 25, SpringLayout.EAST, label_Id);
		springLayout.putConstraint(SpringLayout.SOUTH, textID, 0, SpringLayout.SOUTH, label_Id);
		textID.addFocusListener(this);
		frame.getContentPane().add(textID);
		textID.setColumns(10);

		lbl_IDCheck = new JLabel("\uD544\uC218\uC785\uB825");
		lbl_IDCheck.setForeground(Color.RED);
		springLayout.putConstraint(SpringLayout.NORTH, lbl_IDCheck, 0, SpringLayout.NORTH, label_Id);
		springLayout.putConstraint(SpringLayout.WEST, lbl_IDCheck, 31, SpringLayout.EAST, textID);
		frame.getContentPane().add(lbl_IDCheck);

		textPW = new JTextField();
		textPW.addFocusListener(this);
		frame.getContentPane().add(textPW);
		textPW.setColumns(10);

		JLabel lbl_pw = new JLabel("\uBE44\uBC00\uBC88\uD638");
		springLayout.putConstraint(SpringLayout.NORTH, lbl_pw, 349, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, label_Id, -6, SpringLayout.NORTH, lbl_pw);
		frame.getContentPane().add(lbl_pw);

		 lbl_pwcheck = new JLabel("\uD544\uC218\uC785\uB825");
		springLayout.putConstraint(SpringLayout.NORTH, lbl_pwcheck, 12, SpringLayout.SOUTH, lbl_IDCheck);
		springLayout.putConstraint(SpringLayout.WEST, lbl_pwcheck, 275, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lbl_pw, -165, SpringLayout.WEST, lbl_pwcheck);
		springLayout.putConstraint(SpringLayout.EAST, textPW, 0, SpringLayout.EAST, lbl_pwcheck);
		springLayout.putConstraint(SpringLayout.NORTH, btn_Image, 16, SpringLayout.SOUTH, lbl_pwcheck);
		lbl_pwcheck.setForeground(Color.RED);
		frame.getContentPane().add(lbl_pwcheck);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, textID);
		springLayout.putConstraint(SpringLayout.SOUTH, textField, -99, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lbl_name = new JLabel("\uB2C8\uD06C\uB124\uC784");
		springLayout.putConstraint(SpringLayout.NORTH, lbl_name, 432, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lbl_name, 0, SpringLayout.WEST, lbl_pw);
		frame.getContentPane().add(lbl_name);
		
		JLabel lbl_tel = new JLabel("\uC5F0\uB77D\uCC98");
		springLayout.putConstraint(SpringLayout.NORTH, lbl_tel, 475, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lbl_tel, 0, SpringLayout.EAST, label_Id);
		frame.getContentPane().add(lbl_tel);
		
		textField_1 = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, textField_1, -62, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textField_1, 0, SpringLayout.WEST, textID);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label = new JLabel("\uC774\uBBF8\uC9C0");
		springLayout.putConstraint(SpringLayout.EAST, label, -348, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, label, 22, SpringLayout.SOUTH, lbl_pw);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\uC9C0\uC5ED");
		springLayout.putConstraint(SpringLayout.WEST, label_1, 0, SpringLayout.WEST, label_Id);
		springLayout.putConstraint(SpringLayout.SOUTH, label_1, -104, SpringLayout.NORTH, label_Id);
		frame.getContentPane().add(label_1);
		
		JButton btnNewButton = new JButton("\uC9C0\uC5ED\uCC3E\uAE30");
		springLayout.putConstraint(SpringLayout.NORTH, textPW, 36, SpringLayout.SOUTH, btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, -4, SpringLayout.NORTH, label_1);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 298, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("---");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, label_1);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -86, SpringLayout.WEST, btnNewButton);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lbl_imageIcon = new JLabel("New label");
		springLayout.putConstraint(SpringLayout.NORTH, lbl_imageIcon, 55, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lbl_imageIcon, 96, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lbl_imageIcon, 146, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lbl_imageIcon, 0, SpringLayout.EAST, lblNewLabel);
		frame.getContentPane().add(lbl_imageIcon);
		
		tf_pw = new JPasswordField();     
		springLayout.putConstraint(SpringLayout.NORTH, tf_pw, -3, SpringLayout.NORTH, lbl_pw);
		springLayout.putConstraint(SpringLayout.WEST, tf_pw, 0, SpringLayout.WEST, lbl_Image);
		springLayout.putConstraint(SpringLayout.EAST, tf_pw, -31, SpringLayout.EAST, lbl_Image);
		frame.getContentPane().add(tf_pw);
		tf_pw.addFocusListener(this);

	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == textID) {
			System.out.println(textID.getText());
			System.out.println(dao.isEmailJoin(textID.getText()));
			System.out.println("중복값 확인할 아이디 : odd03@naver.com");
		
				if (dao.isEmailJoin(textID.getText())) {
					lbl_IDCheck.setForeground(Color.RED);
					
					lbl_IDCheck.setText("이미 사용중인 아이디입니다. ");

				} else if (!dao.isEmailJoin(textID.getText())) {
					lbl_IDCheck.setForeground(Color.green);
					;
					lbl_IDCheck.setText("멋진아이디네요!!");
				}
			}
		System.out.println(tf_pw);
		System.out.println();
		 
//		  
//		 tf_pw.setEchoChar('*');
		  
		//tf_pw 필드에서 패스워드를 얻어옴, char[] 배열에 저장
		if (e.getSource()==tf_pw) {
		
			String textpassword=String.valueOf(tf_pw.getPassword());
			passwordCheck pwCheck = new passwordCheck();
			System.out.println(textpassword);
			boolean pwCheckMessege=pwCheck.checkPw(textpassword);
			
			System.out.println(pwCheckMessege);
			
		}
		
	}
}
