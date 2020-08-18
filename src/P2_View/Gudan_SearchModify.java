package P2_View;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import P3_DAO.GroupsDAO;
import P4_DTO.GroupsDTO;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gudan_SearchModify extends JDialog implements FocusListener {

	private final JPanel contentPanel = new JPanel();
	private static JDialog dialog;
	private static Point point = new Point();
	private JTextField txt_gudan;
	private JTextField textField;
	private JTable table;
	private GroupsDAO dao = new GroupsDAO();
	private GroupsDTO result;
	private ArrayList<GroupsDTO> list;
	
	/**
	 * Create the dialog.
	 * @param result 
	 */
	public Gudan_SearchModify(JTextField textField_1, GroupsDTO result) {
		setBounds(100, 100, 678, 466);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(23, 35, 51));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			txt_gudan = new JTextField();
			txt_gudan.setText("\uAD6C\uB2E8 \uC774\uB984\uC73C\uB85C \uCC3E\uAE30");
			txt_gudan.setForeground(Color.WHITE);
			txt_gudan.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
			txt_gudan.setColumns(10);
			txt_gudan.setBorder(null);
			txt_gudan.setBackground(new Color(23, 35, 51));
			txt_gudan.setBounds(173, 48, 316, 21);
			txt_gudan.addFocusListener(this);
			{
				textField = new JTextField();
				textField.setBounds(0, 0, 0, 0);
				contentPanel.add(textField);
				textField.setColumns(10);
			}

			JButton button = new JButton("\uAC80\uC0C9");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String name = txt_gudan.getText();
					if (name == null) {
						name = "";
					}

					list = dao.SearchGroups(name);

					String column[] = { "번호", "구단명", "구단연락처", "주소", "홈페이지" };
					Object[][] content = new Object[list.size()][column.length];

					for (int i = 0; i < content.length; i++) {
						content[i][0] = list.get(i).getGroup_Code();
						content[i][1] = list.get(i).getGroup_Name();
						content[i][2] = list.get(i).getGroup_Tel();
						content[i][3] = list.get(i).getGroup_Address();
						content[i][4] = list.get(i).getGroup_HomePage();
					}

					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);

					table.setModel(new DefaultTableModel(content, column));
				}
			});
			button.setForeground(Color.WHITE);
			button.setFont(new Font("Dialog", Font.BOLD, 12));
			button.setBackground(new Color(71, 120, 197));
			button.setBounds(501, 45, 70, 32);
			contentPanel.add(button);
			contentPanel.add(txt_gudan);
		}
		{
			JSeparator gudan_separator = new JSeparator();
			gudan_separator.setBounds(173, 79, 316, 2);
			contentPanel.add(gudan_separator);
		}

		list = dao.selectAllGroups();

		String column[] = { "번호", "구단명", "구단연락처", "주소", "홈페이지" };
		Object[][] content = new Object[list.size()][column.length];

		for (int i = 0; i < content.length; i++) {
			content[i][0] = list.get(i).getGroup_Code();
			content[i][1] = list.get(i).getGroup_Name();
			content[i][2] = list.get(i).getGroup_Tel();
			content[i][3] = list.get(i).getGroup_Address();
			content[i][4] = list.get(i).getGroup_HomePage();
		}

		table = new JTable();
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
		table.setBounds(42, 117, 576, 214);
		table.getTableHeader().setBackground(new Color(120, 168, 252));
		table.getTableHeader().setForeground(new Color(255, 255, 255));
		table.setSelectionBackground(new Color(232, 57, 95));
		table.setRowHeight(20);
		table.setRowSelectionInterval(0, 0); // 시작과 동시 첫번째 행을 선택하게 하기

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(81, 123, 500, 180);
		contentPanel.add(scrollPane);

		JButton btn_accept = new JButton("확인");
		btn_accept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRow() > -1) {
					result.setResult(list.get(table.getSelectedRow()));
					textField_1.setText(list.get(table.getSelectedRow()).getGroup_Name());
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "구단을 선택하여 주세요.", "선택 실패", JOptionPane.ERROR_MESSAGE);
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

	}

	@Override
	public void focusGained(FocusEvent e) {
		if (e.getSource() == txt_gudan) {
			txt_gudan.setText("");
		}
	}

	@Override
	public void focusLost(FocusEvent e) {

	}
}