package zqu.eqms.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import zqu.eqms.dao.ForgetPwDao;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Font;

public class ForgetPwFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	
	private ForgetPwNextFrame fpn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgetPwFrame frame = new ForgetPwFrame();
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
	public ForgetPwFrame() {
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
		setTitle("忘记密码");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((d.width-341)/2, (d.height-300)/2, 341, 300);
		
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
		panel.setLayout(new GridLayout(3, 0, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("帐号");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(65, 23, 72, 21);
		panel_2.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(147, 23, 105, 26);
//		textField.setToolTipText("Please enter your full name!");
		panel_2.add(textField);
		textField.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("手机号验证");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(65, 23, 72, 21);
		panel_3.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(147, 23, 105, 26);
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("姓名验证");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(65, 23, 72, 21);
		panel_4.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(147, 23, 105, 26);
		panel_4.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setVgap(15);
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("下一步");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = textField.getText();
				String tel = textField_1.getText();
				String name = textField_2.getText();
				forgerPw(user, tel, name);
			}
		});
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("重  置");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		panel_1.add(btnNewButton_1);
	}
	
	public class ForgetPwNextFrame extends JFrame{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public ForgetPwNextFrame() {
			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
			setTitle("忘记密码");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds((d.width-341)/2, (d.height-236)/2, 341, 236);
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
			panel.setLayout(new GridLayout(2, 0, 0, 0));
			
			JPanel panel_2 = new JPanel();
			panel.add(panel_2);
			panel_2.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("新密码");
			lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
			lblNewLabel.setBounds(65, 23, 72, 21);
			panel_2.add(lblNewLabel);
			
			
			passwordField = new JPasswordField();
			passwordField.setBounds(147, 23, 105, 26);
			panel_2.add(passwordField);
			passwordField.setColumns(10);
			
			JPanel panel_3 = new JPanel();
			panel.add(panel_3);
			panel_3.setLayout(null);
			
			JLabel lblNewLabel_1 = new JLabel("再次输入");
			lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(65, 23, 72, 21);
			panel_3.add(lblNewLabel_1);
			
			passwordField_1 = new JPasswordField();
			passwordField_1.setBounds(147, 23, 105, 26);
			panel_3.add(passwordField_1);
			passwordField_1.setColumns(10);
			
			JPanel panel_1 = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
			flowLayout.setVgap(15);
			contentPane.add(panel_1, BorderLayout.SOUTH);
			
			JButton btnNewButton = new JButton("提  交");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String user = textField.getText();
					String pw = new String(passwordField.getPassword());
					String pwR = new String(passwordField_1.getPassword());
					forgerPwNext(user, pw, pwR);
				}
			});
			panel_1.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("重  置");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					clearNext();
				}
			});
			panel_1.add(btnNewButton_1);
			
			JButton btnNewButton_2 = new JButton("上一步");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					ForgetPwFrame fp = new ForgetPwFrame();
					fp.setVisible(true);
				}
			});
			panel_1.add(btnNewButton_2);
		}
	}
	
	public void forgerPw(String user, String tel, String name) {
		if(user.equals("")) {
			JOptionPane.showMessageDialog(null, "帐号不能为空！", "提示", JOptionPane.INFORMATION_MESSAGE);
			clear();
		}
		else {
			if(ForgetPwDao.validate(user) != null) {
				if(ForgetPwDao.validate(user).isIsmanager() == false) {
					if(tel.equals("") || name.equals("")) {
						JOptionPane.showMessageDialog(null, "验证信息不完整！", "提示", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						if(tel.equals(ForgetPwDao.validate(user).getTel()) && name.equals(ForgetPwDao.validate(user).getName())) {
							JOptionPane.showMessageDialog(null, "验证成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
							dispose();
							fpn = new ForgetPwNextFrame();
							fpn.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "验证错误，请重新输入！", "提示", JOptionPane.INFORMATION_MESSAGE);
							clear();
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "管理员请通过后台修改密码！", "提示", JOptionPane.INFORMATION_MESSAGE);
					clear();
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "用户不存在！", "提示", JOptionPane.INFORMATION_MESSAGE);
				clear();
			}
		}
	}

	public void clear() {
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
	}
	
	public void exit() {
		Object[] options = {"确定", "取消"};
		int sel = JOptionPane.showOptionDialog(null, "真的要结束吗？", "确定？", JOptionPane.YES_NO_OPTION, 
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if(sel == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	public void forgerPwNext(String user, String pw, String pwR) {
		if(pw.equals("") || pwR.equals("")) {
			JOptionPane.showMessageDialog(null, "输入不完整！", "提示", JOptionPane.INFORMATION_MESSAGE);
			clearNext();
		}
		else {
			if(pw.length()>=8 && pw.length()<=20) {
				if(pw.equals(pwR)) {
					if(ForgetPwDao.samePassword(user, pw) == false) {
						if(ForgetPwDao.passwordUpdate(user, pw)!=0) {
							JOptionPane.showMessageDialog(null, "修改密码成功，返回！", "提示", JOptionPane.INFORMATION_MESSAGE);
							fpn.dispose();
							LoginFrame frame = new LoginFrame();
							frame.setVisible(true);
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "新密码不能和原密码一样！", "提示", JOptionPane.INFORMATION_MESSAGE);
						clearNext();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "两次输入的密码不一致！", "提示", JOptionPane.INFORMATION_MESSAGE);
					clearNext();
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "密码长度不符合要求！", "提示", JOptionPane.INFORMATION_MESSAGE);
				clearNext();
			}
		}
	}
	
	public void clearNext() {
		passwordField.setText("");
		passwordField_1.setText("");
	}
}
