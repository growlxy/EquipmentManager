package zqu.eqms.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import zqu.eqms.domain.EquipmentDomain;
import zqu.eqms.dao.AllEquipmentDao;
import zqu.eqms.dao.EquipmentDateDao;
import zqu.eqms.dao.EquipmentLocDao;
import zqu.eqms.dao.EquipmentManaDao;
import zqu.eqms.dao.EquipmentNameDao;

import javax.swing.JButton;
import javax.swing.JTextField;

public class UserFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTable table_4;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private String[] columns = { "编号", "名称", "规格", "价格", "购入日期", "存放位置", "设备负责人" };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserFrame frame = new UserFrame("123");
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
	public UserFrame(String user) {
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

		setTitle("用户界面");
		setResizable(false);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((d.width - 606) / 2, (d.height - 445) / 2, 606, 445);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("文件");
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

		JMenu mnNewMenu_1 = new JMenu("帮助");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("关于作者");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "软件作者：growlxy", "提示", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("总览", null, scrollPane, null);

		int cnt = AllEquipmentDao.displayAllEquipment().size();
		int i = 0;
		String[][] data = new String[cnt][7];
		for (EquipmentDomain ed : AllEquipmentDao.displayAllEquipment()) {
			data[i][0] = ed.getId();
			data[i][1] = ed.getName();
			data[i][2] = ed.getSpec();
			data[i][3] = String.valueOf(ed.getPrice());
			data[i][4] = String.valueOf(ed.getDate());
			data[i][5] = ed.getLoc();
			data[i][6] = ed.getManager();
			i++;
		}

		table = new JTable();
		table.setModel(new DefaultTableModel(data, columns));
		scrollPane.setViewportView(table);
		table.getSelectedColumn();

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("按名称查找", null, panel_2, null);
		panel_2.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		flowLayout_1.setVgap(7);
		panel_2.add(panel_1, BorderLayout.NORTH);

		JLabel lblNewLabel_2 = new JLabel("请输入要查找的名称： ");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_2);

		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(26);

		JLabel lblNewLabel_1 = new JLabel(" ");
		panel_1.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("查  找");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = textField.getText();
				table_1.setModel(new DefaultTableModel(fillTable(EquipmentNameDao.displayEquipment(item)), columns));
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 13));
		panel_1.add(btnNewButton);

		JScrollPane scrollPane_1 = new JScrollPane();
		panel_2.add(scrollPane_1, BorderLayout.CENTER);

		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(new Object[][] {}, columns));
		scrollPane_1.setViewportView(table_1);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("按日期查找", null, panel_3, null);
		panel_3.setLayout(new BorderLayout(0, 0));

		JPanel panel_8 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_8.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		flowLayout_4.setVgap(7);
		panel_3.add(panel_8, BorderLayout.NORTH);

		JLabel lblNewLabel_7 = new JLabel("起始");
		lblNewLabel_7.setFont(new Font("宋体", Font.PLAIN, 14));
		panel_8.add(lblNewLabel_7);

		textField_3 = new JTextField();
		textField_3.setToolTipText("4位数字");
		panel_8.add(textField_3);
		textField_3.setColumns(3);

		JLabel lblNewLabel_13 = new JLabel("年");
		lblNewLabel_13.setFont(new Font("宋体", Font.PLAIN, 14));
		panel_8.add(lblNewLabel_13);

		textField_4 = new JTextField();
		textField_4.setToolTipText("2位数字");
		panel_8.add(textField_4);
		textField_4.setColumns(3);

		JLabel lblNewLabel_8 = new JLabel("月");
		lblNewLabel_8.setFont(new Font("宋体", Font.PLAIN, 14));
		panel_8.add(lblNewLabel_8);

		textField_5 = new JTextField();
		textField_5.setToolTipText("2位数字");
		panel_8.add(textField_5);
		textField_5.setColumns(3);

		JLabel lblNewLabel_9 = new JLabel("日 ");
		lblNewLabel_9.setFont(new Font("宋体", Font.PLAIN, 14));
		panel_8.add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("截止");
		lblNewLabel_10.setFont(new Font("宋体", Font.PLAIN, 14));
		panel_8.add(lblNewLabel_10);

		textField_6 = new JTextField();
		textField_6.setToolTipText("4位数字");
		panel_8.add(textField_6);
		textField_6.setColumns(3);

		JLabel lblNewLabel_14 = new JLabel("年");
		lblNewLabel_14.setFont(new Font("宋体", Font.PLAIN, 14));
		panel_8.add(lblNewLabel_14);

		textField_7 = new JTextField();
		textField_7.setToolTipText("2位数字");
		panel_8.add(textField_7);
		textField_7.setColumns(3);

		JLabel lblNewLabel_11 = new JLabel("月");
		lblNewLabel_11.setFont(new Font("宋体", Font.PLAIN, 14));
		panel_8.add(lblNewLabel_11);

		textField_8 = new JTextField();
		textField_8.setToolTipText("2位数字");
		panel_8.add(textField_8);
		textField_8.setColumns(3);

		JButton btnNewButton_3 = new JButton("查  找");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String beginDateYear = textField_3.getText();
				String beginDateMonth = textField_4.getText();
				String beginDateDay = textField_5.getText();
				String lastDateYear = textField_6.getText();
				String lastDateMonth = textField_7.getText();
				String lastDateDay = textField_8.getText();
				ArrayList<EquipmentDomain> data = cheakDate(beginDateYear, beginDateMonth, beginDateDay, lastDateYear,
						lastDateMonth, lastDateDay);
				if (data == null) {
					table_4.setModel(new DefaultTableModel(new Object[][] {}, columns));
				} else {
					table_4.setModel(new DefaultTableModel(fillTable(data), columns));
				}
			}
		});

		JLabel lblNewLabel_12 = new JLabel("日");
		lblNewLabel_12.setFont(new Font("宋体", Font.PLAIN, 14));
		panel_8.add(lblNewLabel_12);
		btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 13));
		panel_8.add(btnNewButton_3);

		JScrollPane scrollPane_4 = new JScrollPane();
		panel_3.add(scrollPane_4, BorderLayout.CENTER);

		table_4 = new JTable();
		table_4.setModel(new DefaultTableModel(new Object[][] {}, columns));
		scrollPane_4.setViewportView(table_4);

		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("按存放位置查找", null, panel_4, null);
		panel_4.setLayout(new BorderLayout(0, 0));

		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_6.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		flowLayout_2.setVgap(7);
		panel_4.add(panel_6, BorderLayout.NORTH);

		JLabel lblNewLabel_3 = new JLabel("请输入要查找的存放位置：");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 14));
		panel_6.add(lblNewLabel_3);

		textField_1 = new JTextField();
		panel_6.add(textField_1);
		textField_1.setColumns(26);

		JButton btnNewButton_1 = new JButton("查  找");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = textField_1.getText();
				table_2.setModel(new DefaultTableModel(fillTable(EquipmentLocDao.displayEquipment(item)), columns));
			}
		});

		JLabel lblNewLabel_6 = new JLabel(" ");
		panel_6.add(lblNewLabel_6);
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 13));
		panel_6.add(btnNewButton_1);

		JScrollPane scrollPane_2 = new JScrollPane();
		panel_4.add(scrollPane_2, BorderLayout.CENTER);

		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(new Object[][] {}, columns));
		scrollPane_2.setViewportView(table_2);

		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("按负责人查找", null, panel_5, null);
		panel_5.setLayout(new BorderLayout(0, 0));

		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_7.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		flowLayout_3.setVgap(7);
		panel_5.add(panel_7, BorderLayout.NORTH);

		JLabel lblNewLabel_4 = new JLabel("请输入要查找的负责人： ");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 14));
		panel_7.add(lblNewLabel_4);

		textField_2 = new JTextField();
		panel_7.add(textField_2);
		textField_2.setColumns(26);

		JButton btnNewButton_2 = new JButton("查  找");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = textField_2.getText();
				table_3.setModel(new DefaultTableModel(fillTable(EquipmentManaDao.displayEquipment(item)), columns));
			}
		});

		JLabel lblNewLabel_5 = new JLabel(" ");
		panel_7.add(lblNewLabel_5);
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 13));
		panel_7.add(btnNewButton_2);

		JScrollPane scrollPane_3 = new JScrollPane();
		panel_5.add(scrollPane_3, BorderLayout.CENTER);

		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(new Object[][] {}, columns));
		scrollPane_3.setViewportView(table_3);

		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(10);
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("用户" + user + "，请选择您需要的功能");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		panel.add(lblNewLabel);
	}

	public String[][] fillTable(ArrayList<EquipmentDomain> al) {
		int cnt = al.size();
		int i = 0;
		String[][] data = new String[cnt][7];
		for (EquipmentDomain ed : al) {
			data[i][0] = ed.getId();
			data[i][1] = ed.getName();
			data[i][2] = ed.getSpec();
			data[i][3] = String.valueOf(ed.getPrice());
			data[i][4] = String.valueOf(ed.getDate());
			data[i][5] = ed.getLoc();
			data[i][6] = ed.getManager();
			i++;
		}
		return data;
	}

	public ArrayList<EquipmentDomain> cheakDate(String beginDateYear, String beginDateMonth, String beginDateDay,
			String lastDateYear, String lastDateMonth, String lastDateDay) {
		String beginDate = beginDateYear + beginDateMonth + beginDateDay;
		String lastDate = lastDateYear + lastDateMonth + lastDateDay;
		ArrayList<EquipmentDomain> al = null;
		if (beginDateYear.length() == 4 && beginDateMonth.length() == 2 && beginDateDay.length() == 2
				&& lastDateYear.length() == 4 && lastDateMonth.length() == 2 && lastDateDay.length() == 2) {
			al = EquipmentDateDao.displayEquipment(beginDate, lastDate);
		} else {
			JOptionPane.showMessageDialog(null, "您输入的信息不正确！", "提示", JOptionPane.INFORMATION_MESSAGE);
		}
		return al;
	}

	public void exit() {
		Object[] options = { "确定", "取消" };
		int sel = JOptionPane.showOptionDialog(null, "真的要结束吗？", "确定？", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if (sel == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
}
