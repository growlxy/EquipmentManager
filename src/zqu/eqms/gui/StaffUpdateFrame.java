package zqu.eqms.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.border.MatteBorder;

import zqu.eqms.dao.UpdateDao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class StaffUpdateFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffUpdateFrame frame = new StaffUpdateFrame(null, null, null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StaffUpdateFrame(Object id, Object name, Object tel, Object dep) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		setResizable(false);
		setTitle("修改信息");
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((d.width - 193) / 2, (d.height - 202) / 2, 193, 202);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(3, 0, 0, 0));

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("姓名");
		lblNewLabel.setBounds(10, 19, 70, 19);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		panel_2.add(lblNewLabel);

		textField = new JTextField(String.valueOf(name));
		textField.setBounds(79, 15, 98, 28);
		panel_2.add(textField);
		textField.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("手机号码");
		lblNewLabel_1.setBounds(10, 19, 70, 19);
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		panel_3.add(lblNewLabel_1);

		textField_1 = new JTextField(String.valueOf(tel));
		textField_1.setBounds(79, 15, 98, 28);
		panel_3.add(textField_1);
		textField_1.setColumns(10);

		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("部门");
		lblNewLabel_2.setBounds(10, 19, 70, 19);
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 14));
		panel_4.add(lblNewLabel_2);

		textField_2 = new JTextField(String.valueOf(dep));
		textField_2.setBounds(79, 15, 98, 28);
		panel_4.add(textField_2);
		textField_2.setColumns(10);

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setVgap(10);
		panel_1.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		contentPane.add(panel_1, BorderLayout.SOUTH);

		JButton btnNewButton = new JButton("更新");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = { "确定", "取消" };
				int sel = JOptionPane.showOptionDialog(null, "确定要修改吗？", "确定？", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				if (sel == JOptionPane.YES_OPTION) {
					Update(String.valueOf(id), textField.getText(), textField_1.getText(), textField_2.getText());
				}
			}
		});
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel_1.add(btnNewButton_1);
	}

	public void Update(String id, String name, String tel, String dep) {
		if (name.equals("") || tel.equals("") || dep.equals("")) {
			JOptionPane.showMessageDialog(null, "信息不完整！", "提示", JOptionPane.INFORMATION_MESSAGE);
		} else {
			if (tel.length() == 11) {
				if (UpdateDao.StaffUpdate(id, name, tel, dep) != 0) {
					JOptionPane.showMessageDialog(null, "修改成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}
			} else {
				JOptionPane.showMessageDialog(null, "手机号码不正确！", "提示", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}
