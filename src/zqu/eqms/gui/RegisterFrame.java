package zqu.eqms.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.border.MatteBorder;

import zqu.eqms.dao.RegisterDao;
import zqu.eqms.domain.DepartmentDomain;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JPasswordField;

public class RegisterFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JComboBox<Object> comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterFrame frame = new RegisterFrame();
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
	public RegisterFrame() {
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }catch(Exception e) {
        	e.printStackTrace();
        }
		
		setResizable(false);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setTitle("注册");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((d.width-341)/2, (d.height-458)/2, 341, 458);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("选择");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("返回登录");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginFrame frame = new LoginFrame();
				frame.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("退出");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(5, 0, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("帐    号");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(67, 24, 57, 18);
		panel_2.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setToolTipText("帐号应为员工编号");
		textField.setBounds(149, 21, 105, 26);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(1, 0, 0, 0, (Color) Color.GRAY));
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("密    码");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(67, 24, 57, 18);
		panel_3.add(lblNewLabel_1);
		
		textField_1 = new JPasswordField();
		textField_1.setToolTipText("密码应为8-20的英文、数字或符号组合");
		textField_1.setBounds(149, 21, 105, 26);
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new MatteBorder(1, 0, 0, 0, (Color) Color.GRAY));
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("姓    名");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(67, 24, 57, 18);
		panel_4.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(149, 21, 105, 26);
		panel_4.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new MatteBorder(1, 0, 0, 0, (Color) Color.GRAY));
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("手机号码");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(67, 24, 57, 18);
		panel_5.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("11位手机号码");
		textField_3.setBounds(149, 21, 105, 26);
		panel_5.add(textField_3);
		textField_3.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new MatteBorder(1, 0, 1, 0, (Color) Color.GRAY));
		panel.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("所属部门");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(67, 24, 57, 18);
		panel_6.add(lblNewLabel_4);

		comboBox = new JComboBox<Object>();
		comboBox.setFont(new Font("宋体", Font.PLAIN, 12));
		comboBox.setBounds(149, 21, 105, 26);
		comboBox.addItem("请选择部门");
		int i = 0;
		String[] dno = new String[RegisterDao.displayDepartmentName().size()];
		for(DepartmentDomain dd:RegisterDao.displayDepartmentName()) {
			comboBox.addItem(dd.getName());
			dno[i] = dd.getId();
			i++;
		}
		panel_6.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setVgap(15);
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("注册");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				String password = new String(textField_1.getPassword());
				String name = textField_2.getText();
				String tel = textField_3.getText();
				String depid = "0";
				if(comboBox.getSelectedIndex()!=0) depid = dno[comboBox.getSelectedIndex()-1];		
				if(id.isEmpty() || password.isEmpty() || name.isEmpty() || tel.isEmpty()) {
					JOptionPane.showMessageDialog(null, "注册信息不完整！", "提示", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					register(id, password, name, tel, depid);
				}	
			}
		});
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		panel_1.add(btnNewButton_1);
	}
	
	public void register(String id, String password, String name, String tel, String depid) {
		if(RegisterDao.notExisting(id)) {
			if(password.length()>=8 && password.length()<=20) {
				if(tel.length()==11) {
					if(depid!="0") {
						if(RegisterDao.registerUpdate(id, password, name, tel, depid)!=0) {
							JOptionPane.showMessageDialog(null, "注册成功，返回！", "提示", JOptionPane.INFORMATION_MESSAGE);
							dispose();
							LoginFrame frame = new LoginFrame();
							frame.setVisible(true);
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "您还没有选择部门！", "提示", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "手机号码不符合要求！", "提示", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "密码长度不符合要求！", "提示", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "该用户已存在！", "提示", JOptionPane.INFORMATION_MESSAGE);
			clear();
		}
	}
	
	public void clear() {
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		comboBox.setSelectedIndex(0);
	}
	
	public void exit() {
		Object[] options = {"确定", "取消"};
		int sel = JOptionPane.showOptionDialog(null, "真的要结束吗？", "确定？", JOptionPane.YES_NO_OPTION, 
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if(sel == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
}
