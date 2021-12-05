package zqu.eqms.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import zqu.eqms.dao.LoginDao;
import zqu.eqms.domain.StaffDomain;

public class LoginFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField textField_1;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setTitle("用户登录");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		textField = new JTextField();
		textField.setBounds(168, 39, 105, 21);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("<html><u>注册</u><html>");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				RegisterFrame rf = new RegisterFrame();
				rf.setVisible(true);
			}
		});
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(283, 40, 72, 19);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("帐    号： ");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(92, 40, 78, 21);
		panel_2.add(lblNewLabel_1);
		panel_2.add(textField);
		panel_2.add(lblNewLabel_2);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("密    码： ");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(92, 12, 78, 21);
		panel_3.add(lblNewLabel_3);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(168, 10, 105, 21);
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("忘记密码？");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(283, 12, 72, 19);
		panel_3.add(lblNewLabel_4);
		
		rdbtnNewRadioButton = new JRadioButton("管理员登录");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("宋体", Font.PLAIN, 13));
		rdbtnNewRadioButton.setBounds(111, 52, 121, 23);
		panel_3.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("用户登录");
		rdbtnNewRadioButton_1.setSelected(true);
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setFont(new Font("宋体", Font.PLAIN, 13));
		rdbtnNewRadioButton_1.setBounds(229, 52, 121, 23);
		panel_3.add(rdbtnNewRadioButton_1);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setVgap(15);
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("登录");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = textField.getText();
				String pw = new String(textField_1.getPassword());
				login(user, pw);
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
		
		JButton btnNewButton_2 = new JButton("退出");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		panel_1.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("高 校 设 备 管 理 系 统");
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
	}
	
	public void login(String user, String pw) {
		if(user.equals("") || pw.equals("")) {
			JOptionPane.showMessageDialog(null, "帐号和密码不能为空", "提示", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			StaffDomain sd = LoginDao.validate(user).get(0);
			if(sd.getId() != "") {
				if(rdbtnNewRadioButton.isSelected()) {
					if(sd.isIsmanager()) {
						if(user.equals(sd.getId()) && pw.equals(sd.getPassword())) {
							JOptionPane.showMessageDialog(null, "登录成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, "帐号或密码错误！", "提示", JOptionPane.INFORMATION_MESSAGE);
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "您不是管理员！", "提示", JOptionPane.INFORMATION_MESSAGE);
					}
				};
				if(rdbtnNewRadioButton_1.isSelected()) {
					if(user.equals(sd.getId()) && pw.equals(sd.getPassword())) {
						JOptionPane.showMessageDialog(null, "登录成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "帐号或密码错误！", "提示", JOptionPane.INFORMATION_MESSAGE);
					}
				};
			}
			else {
				JOptionPane.showMessageDialog(null, "用户不存在！", "提示", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	public void clear() {
		textField.setText("");
		textField_1.setText("");
		rdbtnNewRadioButton_1.setSelected(true);
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
