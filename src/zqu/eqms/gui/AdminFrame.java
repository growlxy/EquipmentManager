package zqu.eqms.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import zqu.eqms.dao.AllDepartmentDao;
import zqu.eqms.dao.AllEquipmentDao;
import zqu.eqms.dao.AllStaffDao;
import zqu.eqms.dao.CreateDao;
import zqu.eqms.dao.DeleteDao;
import zqu.eqms.dao.DepNameDao;
import zqu.eqms.dao.EquipmentDateDao;
import zqu.eqms.dao.EquipmentLocDao;
import zqu.eqms.dao.EquipmentManaDao;
import zqu.eqms.dao.EquipmentNameDao;
import zqu.eqms.dao.RegisterDao;
import zqu.eqms.dao.StaffDepDao;
import zqu.eqms.dao.StaffNameDao;
import zqu.eqms.dao.StaffTelDao;
import zqu.eqms.dao.UpdateDao;
import zqu.eqms.domain.DepartmentDomain;
import zqu.eqms.domain.EquipmentDomain;
import zqu.eqms.domain.StaffDomain;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.border.BevelBorder;
import javax.swing.JPasswordField;

public class AdminFrame extends JFrame {

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
	private JTable table_5;
	private JTable table_6;
	private JTable table_7;
	private JTable table_8;
	private JTable table_9;
	private JTable table_10;
	private JTable table_11;
	private JTable table_12;
	private JTable table_13;
	private JTable table_14;
	private JTable table_15;
	private JTable table_16;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JPasswordField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JComboBox<Object> comboBox;
	private JComboBox<Object> comboBox_1;
	private String[] depColumns = { "编号", "名称", "部门主管" };
	private String[] staffColumns = { "编号", "姓名", "联络电话", "是否为管理员", "部门" };
	private String[] equipColumns = { "编号", "名称", "规格", "价格", "购入日期", "存放位置", "设备负责人" };
	private boolean depUp;
	private boolean staffUp;
	private boolean equipUp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminFrame frame = new AdminFrame("123");
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
	public AdminFrame(String user) {
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

		setTitle("管理员界面");
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

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane_1, BorderLayout.CENTER);

		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tabbedPane_3.getSelectedIndex() == 0) {
					table_5.setModel(
							new DefaultTableModel(fillDepTable(AllDepartmentDao.displayAllDepartment()), depColumns));
				}
				if (tabbedPane_3.getSelectedIndex() == 2) {
					table_5.setModel(
							new DefaultTableModel(fillDepTable(AllDepartmentDao.displayAllDepartment()), depColumns));
				}
			}
		});
		tabbedPane_1.addTab("关于部门", null, tabbedPane_3, null);

		JPanel panel_9 = new JPanel();
		tabbedPane_3.addTab("总览", null, panel_9, null);
		panel_9.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_5 = new JScrollPane();
		panel_9.add(scrollPane_5, BorderLayout.CENTER);

		table_5 = new JTable();
		table_5.setModel(new DefaultTableModel(fillDepTable(AllDepartmentDao.displayAllDepartment()), depColumns));
		scrollPane_5.setViewportView(table_5);

		JPanel panel_13 = new JPanel();
		tabbedPane_3.addTab("修改信息", null, panel_13, null);
		panel_13.setLayout(new BorderLayout(0, 0));

		JPanel panel_29 = new JPanel();
		FlowLayout flowLayout_10 = (FlowLayout) panel_29.getLayout();
		flowLayout_10.setAlignment(FlowLayout.LEFT);
		flowLayout_10.setVgap(7);
		panel_13.add(panel_29, BorderLayout.NORTH);

		JLabel lblNewLabel_25 = new JLabel("请输入要查找的名称： ");
		lblNewLabel_25.setFont(new Font("宋体", Font.PLAIN, 14));
		panel_29.add(lblNewLabel_25);

		textField_14 = new JTextField();
		panel_29.add(textField_14);
		textField_14.setColumns(26);

		JLabel lblNewLabel_26 = new JLabel(" ");
		panel_29.add(lblNewLabel_26);

		JButton btnNewButton_9 = new JButton("查  找");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = textField_14.getText();
				table_12.setModel(new DefaultTableModel(fillDepTable(DepNameDao.displayDepartment(item)), depColumns));
			}
		});
		btnNewButton_9.setFont(new Font("宋体", Font.PLAIN, 13));
		panel_29.add(btnNewButton_9);

		JScrollPane scrollPane_12 = new JScrollPane();
		panel_13.add(scrollPane_12, BorderLayout.CENTER);

		table_12 = new JTable();
		table_12.setModel(new DefaultTableModel(new Object[][] {}, depColumns));
		table_12.addMouseListener(new MouseAdapter() {
			private DepUpdateFrame duf;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (depUp) {
					duf.dispose();
				}
				int sel = table_12.getSelectedRow();
				duf = new DepUpdateFrame(table_12.getValueAt(sel, 0), table_12.getValueAt(sel, 1),
						table_12.getValueAt(sel, 2));
				duf.setVisible(true);
				depUp = true;
			}
		});
		scrollPane_12.setViewportView(table_12);

		JPanel panel_14 = new JPanel();
		tabbedPane_3.addTab("增加部门", null, panel_14, null);
		panel_14.setLayout(new BorderLayout(0, 0));

		JPanel panel_50 = new JPanel();
		panel_50.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		FlowLayout flowLayout_17 = (FlowLayout) panel_50.getLayout();
		flowLayout_17.setVgap(10);
		panel_14.add(panel_50, BorderLayout.SOUTH);

		JButton btnNewButton_18 = new JButton("添  加");
		btnNewButton_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createDep(textField_29.getText(), textField_30.getText(), textField_31.getText());
			}
		});
		panel_50.add(btnNewButton_18);

		JLabel lblNewLabel_49 = new JLabel("           ");
		panel_50.add(lblNewLabel_49);

		JButton btnNewButton_19 = new JButton("重  置");
		btnNewButton_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		panel_50.add(btnNewButton_19);

		JPanel panel_51 = new JPanel();
		panel_14.add(panel_51, BorderLayout.CENTER);
		panel_51.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel_52 = new JPanel();
		panel_51.add(panel_52);
		panel_52.setLayout(new GridLayout(3, 0, 0, 0));

		JPanel panel_55 = new JPanel();
		panel_52.add(panel_55);
		panel_55.setLayout(null);

		JLabel lblNewLabel_50 = new JLabel("编号");
		lblNewLabel_50.setBounds(47, 38, 70, 16);
		lblNewLabel_50.setFont(new Font("宋体", Font.PLAIN, 14));
		panel_55.add(lblNewLabel_50);

		textField_29 = new JTextField();
		textField_29.setBounds(127, 33, 122, 27);
		panel_55.add(textField_29);
		textField_29.setColumns(10);

		JPanel panel_54 = new JPanel();
		panel_52.add(panel_54);
		panel_54.setLayout(null);

		JLabel lblNewLabel_51 = new JLabel("名称");
		lblNewLabel_51.setBounds(47, 38, 70, 16);
		lblNewLabel_51.setFont(new Font("宋体", Font.PLAIN, 14));
		panel_54.add(lblNewLabel_51);

		textField_30 = new JTextField();
		textField_30.setBounds(127, 33, 122, 27);
		panel_54.add(textField_30);
		textField_30.setColumns(10);

		JPanel panel_56 = new JPanel();
		panel_52.add(panel_56);
		panel_56.setLayout(null);

		JLabel lblNewLabel_52 = new JLabel("部门主管");
		lblNewLabel_52.setBounds(47, 38, 70, 16);
		lblNewLabel_52.setFont(new Font("宋体", Font.PLAIN, 14));
		panel_56.add(lblNewLabel_52);

		textField_31 = new JTextField();
		textField_31.setBounds(127, 33, 122, 27);
		panel_56.add(textField_31);
		textField_31.setColumns(10);

		JPanel panel_53 = new JPanel();
		panel_51.add(panel_53);
		panel_53.setLayout(null);

		JPanel panel_57 = new JPanel();
		panel_57.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_57.setBackground(Color.GRAY);
		panel_57.setBounds(25, 25, 61, 61);
		panel_53.add(panel_57);

		JPanel panel_59 = new JPanel();
		panel_59.setBackground(Color.DARK_GRAY);
		panel_59.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_59.setBounds(100, 84, 143, 143);
		panel_53.add(panel_59);

		JPanel panel_58 = new JPanel();
		panel_58.setBackground(Color.WHITE);
		panel_58.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_58.setBounds(70, 61, 35, 36);
		panel_53.add(panel_58);

		JPanel panel_60 = new JPanel();
		panel_60.setBackground(Color.LIGHT_GRAY);
		panel_60.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_60.setBounds(45, 163, 23, 23);
		panel_53.add(panel_60);

		JPanel panel_61 = new JPanel();
		panel_61.setBackground(Color.GRAY);
		panel_61.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_61.setBounds(170, 20, 10, 10);
		panel_53.add(panel_61);

		JPanel panel_62 = new JPanel();
		panel_62.setBackground(Color.GRAY);
		panel_62.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_62.setBounds(191, 43, 10, 10);
		panel_53.add(panel_62);

		JPanel panel_15 = new JPanel();
		tabbedPane_3.addTab("删除部门", null, panel_15, null);
		panel_15.setLayout(new BorderLayout(0, 0));

		JPanel panel_32 = new JPanel();
		FlowLayout flowLayout_13 = (FlowLayout) panel_32.getLayout();
		flowLayout_13.setAlignment(FlowLayout.LEFT);
		flowLayout_13.setVgap(7);
		panel_15.add(panel_32, BorderLayout.NORTH);

		JLabel lblNewLabel_31 = new JLabel("请输入要查找的名称： ");
		lblNewLabel_31.setFont(new Font("宋体", Font.PLAIN, 14));
		panel_32.add(lblNewLabel_31);

		textField_17 = new JTextField();
		panel_32.add(textField_17);
		textField_17.setColumns(26);

		JLabel lblNewLabel_32 = new JLabel(" ");
		panel_32.add(lblNewLabel_32);

		JButton btnNewButton_12 = new JButton("查  找");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = textField_17.getText();
				table_15.setModel(new DefaultTableModel(fillDepTable(DepNameDao.displayDepartment(item)), depColumns));
			}
		});
		btnNewButton_12.setFont(new Font("宋体", Font.PLAIN, 13));
		panel_32.add(btnNewButton_12);

		JScrollPane scrollPane_15 = new JScrollPane();
		panel_15.add(scrollPane_15, BorderLayout.CENTER);

		table_15 = new JTable();
		table_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Delete(table_15.getValueAt(table_15.getSelectedRow(), 0), user, 0);
			}
		});
		table_15.setModel(new DefaultTableModel(new Object[][] {}, depColumns));
		scrollPane_15.setViewportView(table_15);

		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tabbedPane_2.getSelectedIndex() == 0) {
					table_6.setModel(
							new DefaultTableModel(fillStaffTable(AllStaffDao.displayAllStaff()), staffColumns));
				}
				if (tabbedPane_2.getSelectedIndex() == 5) {
					clear();
				}
			}
		});
		tabbedPane_1.addTab("关于员工", null, tabbedPane_2, null);

		JPanel panel_16 = new JPanel();
		tabbedPane_2.addTab("总览", null, panel_16, null);
		panel_16.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_6 = new JScrollPane();
		panel_16.add(scrollPane_6, BorderLayout.CENTER);

		table_6 = new JTable();
		table_6.setModel(new DefaultTableModel(fillStaffTable(AllStaffDao.displayAllStaff()), staffColumns));
		scrollPane_6.setViewportView(table_6);

		JPanel panel_17 = new JPanel();
		tabbedPane_2.addTab("按姓名查找", null, panel_17, null);
		panel_17.setLayout(new BorderLayout(0, 0));

		JPanel panel_24 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_24.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		flowLayout_5.setVgap(7);
		panel_17.add(panel_24, BorderLayout.NORTH);

		JLabel lblNewLabel_15 = new JLabel("请输入要查找的姓名： ");
		lblNewLabel_15.setFont(new Font("宋体", Font.PLAIN, 14));
		panel_24.add(lblNewLabel_15);

		textField_9 = new JTextField();
		panel_24.add(textField_9);
		textField_9.setColumns(26);

		JLabel lblNewLabel_16 = new JLabel(" ");
		panel_24.add(lblNewLabel_16);

		JButton btnNewButton_4 = new JButton("查  找");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = textField_9.getText();
				table_7.setModel(new DefaultTableModel(fillStaffTable(StaffNameDao.displayStaff(item)), staffColumns));
			}
		});
		btnNewButton_4.setFont(new Font("宋体", Font.PLAIN, 13));
		panel_24.add(btnNewButton_4);

		JScrollPane scrollPane_7 = new JScrollPane();
		panel_17.add(scrollPane_7, BorderLayout.CENTER);

		table_7 = new JTable();
		table_7.setModel(new DefaultTableModel(new Object[][] {}, staffColumns));
		scrollPane_7.setViewportView(table_7);

		JPanel panel_18 = new JPanel();
		tabbedPane_2.addTab("按电话号码查找", null, panel_18, null);
		panel_18.setLayout(new BorderLayout(0, 0));

		JPanel panel_25 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_25.getLayout();
		flowLayout_6.setAlignment(FlowLayout.LEFT);
		flowLayout_6.setVgap(7);
		panel_18.add(panel_25, BorderLayout.NORTH);

		JLabel lblNewLabel_17 = new JLabel("请输入要查找的号码： ");
		lblNewLabel_17.setFont(new Font("宋体", Font.PLAIN, 14));
		panel_25.add(lblNewLabel_17);

		textField_10 = new JTextField();
		panel_25.add(textField_10);
		textField_10.setColumns(26);

		JLabel lblNewLabel_18 = new JLabel(" ");
		panel_25.add(lblNewLabel_18);

		JButton btnNewButton_5 = new JButton("查  找");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = textField_10.getText();
				table_8.setModel(new DefaultTableModel(fillStaffTable(StaffTelDao.displayStaff(item)), staffColumns));
			}
		});
		btnNewButton_5.setFont(new Font("宋体", Font.PLAIN, 13));
		panel_25.add(btnNewButton_5);

		JScrollPane scrollPane_8 = new JScrollPane();
		panel_18.add(scrollPane_8, BorderLayout.CENTER);

		table_8 = new JTable();
		table_8.setModel(new DefaultTableModel(new Object[][] {}, staffColumns));
		scrollPane_8.setViewportView(table_8);

		JPanel panel_19 = new JPanel();
		tabbedPane_2.addTab("按部门查找", null, panel_19, null);
		panel_19.setLayout(new BorderLayout(0, 0));

		JPanel panel_26 = new JPanel();
		FlowLayout flowLayout_7 = (FlowLayout) panel_26.getLayout();
		flowLayout_7.setVgap(7);
		flowLayout_7.setAlignment(FlowLayout.LEFT);
		panel_19.add(panel_26, BorderLayout.NORTH);

		JLabel lblNewLabel_19 = new JLabel("请输入要查找的部门： ");
		lblNewLabel_19.setFont(new Font("宋体", Font.PLAIN, 14));
		panel_26.add(lblNewLabel_19);

		textField_11 = new JTextField();
		panel_26.add(textField_11);
		textField_11.setColumns(26);

		JLabel lblNewLabel_20 = new JLabel(" ");
		panel_26.add(lblNewLabel_20);

		JButton btnNewButton_6 = new JButton("查  找");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = textField_11.getText();
				table_9.setModel(new DefaultTableModel(fillStaffTable(StaffDepDao.displayStaff(item)), staffColumns));
			}
		});
		btnNewButton_6.setFont(new Font("宋体", Font.PLAIN, 13));
		panel_26.add(btnNewButton_6);

		JScrollPane scrollPane_9 = new JScrollPane();
		panel_19.add(scrollPane_9, BorderLayout.CENTER);

		table_9 = new JTable();
		table_9.setModel(new DefaultTableModel(new Object[][] {}, staffColumns));
		scrollPane_9.setViewportView(table_9);

		JPanel panel_20 = new JPanel();
		tabbedPane_2.addTab("修改信息", null, panel_20, null);
		panel_20.setLayout(new BorderLayout(0, 0));

		JPanel panel_28 = new JPanel();
		FlowLayout flowLayout_9 = (FlowLayout) panel_28.getLayout();
		flowLayout_9.setAlignment(FlowLayout.LEFT);
		flowLayout_9.setVgap(7);
		panel_20.add(panel_28, BorderLayout.NORTH);

		JLabel lblNewLabel_23 = new JLabel("请输入要查找的姓名： ");
		lblNewLabel_23.setFont(new Font("宋体", Font.PLAIN, 14));
		panel_28.add(lblNewLabel_23);

		textField_13 = new JTextField();
		panel_28.add(textField_13);
		textField_13.setColumns(26);

		JLabel lblNewLabel_24 = new JLabel(" ");
		panel_28.add(lblNewLabel_24);

		JButton btnNewButton_8 = new JButton("查  找");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = textField_13.getText();
				table_11.setModel(new DefaultTableModel(fillStaffTable(StaffNameDao.displayStaff(item)), staffColumns));
			}
		});
		btnNewButton_8.setFont(new Font("宋体", Font.PLAIN, 13));
		panel_28.add(btnNewButton_8);

		JScrollPane scrollPane_11 = new JScrollPane();
		panel_20.add(scrollPane_11, BorderLayout.CENTER);

		table_11 = new JTable();
		table_11.addMouseListener(new MouseAdapter() {
			private StaffUpdateFrame suf;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (staffUp) {
					suf.dispose();
				}
				int sel = table_11.getSelectedRow();
				suf = new StaffUpdateFrame(table_11.getValueAt(sel, 0), table_11.getValueAt(sel, 1),
						table_11.getValueAt(sel, 2), table_11.getValueAt(sel, 4));
				suf.setVisible(true);
				staffUp = true;
			}
		});
		table_11.setModel(new DefaultTableModel(new Object[][] {}, staffColumns));
		scrollPane_11.setViewportView(table_11);

		JPanel panel_21 = new JPanel();
		tabbedPane_2.addTab("增加员工", null, panel_21, null);
		panel_21.setLayout(new BorderLayout(0, 0));

		JPanel panel_42 = new JPanel();
		panel_42.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		FlowLayout flowLayout_16 = (FlowLayout) panel_42.getLayout();
		flowLayout_16.setVgap(10);
		panel_21.add(panel_42, BorderLayout.SOUTH);

		JButton btnNewButton_16 = new JButton("添  加");
		btnNewButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = 0;
				String depid = "0";
				String[] dno = new String[RegisterDao.displayDepartmentName().size()];
				for (DepartmentDomain dd : RegisterDao.displayDepartmentName()) {
					dno[i] = dd.getId();
					i++;
				}
				if (comboBox_1.getSelectedIndex() != 0)
					depid = dno[comboBox_1.getSelectedIndex() - 1];
				createStaff(textField_25.getText(), new String(textField_26.getPassword()), textField_27.getText(),
						textField_28.getText(), String.valueOf(comboBox.getSelectedItem()), depid);
			}
		});
		panel_42.add(btnNewButton_16);

		JLabel lblNewLabel_42 = new JLabel("           ");
		panel_42.add(lblNewLabel_42);

		JButton btnNewButton_17 = new JButton("重  置");
		btnNewButton_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		panel_42.add(btnNewButton_17);

		JPanel panel_43 = new JPanel();
		panel_21.add(panel_43, BorderLayout.CENTER);
		panel_43.setLayout(new GridLayout(3, 2, 0, 0));

		JPanel panel_44 = new JPanel();
		panel_43.add(panel_44);
		panel_44.setLayout(null);

		JLabel lblNewLabel_43 = new JLabel("编号");
		lblNewLabel_43.setBounds(40, 38, 84, 16);
		lblNewLabel_43.setFont(new Font("宋体", Font.PLAIN, 14));
		panel_44.add(lblNewLabel_43);

		textField_25 = new JTextField();
		textField_25.setBounds(135, 33, 122, 27);
		panel_44.add(textField_25);
		textField_25.setColumns(10);

		JPanel panel_45 = new JPanel();
		panel_43.add(panel_45);
		panel_45.setLayout(null);

		JLabel lblNewLabel_44 = new JLabel("密码");
		lblNewLabel_44.setBounds(40, 38, 84, 16);
		lblNewLabel_44.setFont(new Font("宋体", Font.PLAIN, 14));
		panel_45.add(lblNewLabel_44);

		textField_26 = new JPasswordField();
		textField_26.setBounds(135, 33, 122, 27);
		panel_45.add(textField_26);
		textField_26.setColumns(10);

		JPanel panel_46 = new JPanel();
		panel_43.add(panel_46);
		panel_46.setLayout(null);

		JLabel lblNewLabel_45 = new JLabel("姓名");
		lblNewLabel_45.setBounds(40, 38, 84, 16);
		lblNewLabel_45.setFont(new Font("宋体", Font.PLAIN, 14));
		panel_46.add(lblNewLabel_45);

		textField_27 = new JTextField();
		textField_27.setBounds(135, 33, 122, 27);
		panel_46.add(textField_27);
		textField_27.setColumns(10);

		JPanel panel_47 = new JPanel();
		panel_43.add(panel_47);
		panel_47.setLayout(null);

		JLabel lblNewLabel_46 = new JLabel("手机号码");
		lblNewLabel_46.setBounds(40, 38, 84, 16);
		lblNewLabel_46.setFont(new Font("宋体", Font.PLAIN, 14));
		panel_47.add(lblNewLabel_46);

		textField_28 = new JTextField();
		textField_28.setBounds(135, 33, 122, 27);
		panel_47.add(textField_28);
		textField_28.setColumns(10);

		JPanel panel_48 = new JPanel();
		panel_43.add(panel_48);
		panel_48.setLayout(null);

		JLabel lblNewLabel_47 = new JLabel("是否为管理员");
		lblNewLabel_47.setBounds(40, 38, 84, 16);
		lblNewLabel_47.setFont(new Font("宋体", Font.PLAIN, 14));
		panel_48.add(lblNewLabel_47);

		comboBox = new JComboBox<Object>();
		comboBox.setBounds(135, 33, 122, 27);
		comboBox.addItem("否");
		comboBox.addItem("是");
		panel_48.add(comboBox);

		JPanel panel_49 = new JPanel();
		panel_43.add(panel_49);
		panel_49.setLayout(null);

		JLabel lblNewLabel_48 = new JLabel("部门");
		lblNewLabel_48.setBounds(40, 38, 84, 16);
		lblNewLabel_48.setFont(new Font("宋体", Font.PLAIN, 14));
		panel_49.add(lblNewLabel_48);

		comboBox_1 = new JComboBox<Object>();
		comboBox_1.setBounds(135, 33, 122, 27);
		comboBox_1.addItem("请选择部门");
		int i = 0;
		String[] dno = new String[RegisterDao.displayDepartmentName().size()];
		for (DepartmentDomain dd : RegisterDao.displayDepartmentName()) {
			comboBox_1.addItem(dd.getName());
			dno[i] = dd.getId();
			i++;
		}
		panel_49.add(comboBox_1);

		JPanel panel_22 = new JPanel();
		tabbedPane_2.addTab("删除员工", null, panel_22, null);
		panel_22.setLayout(new BorderLayout(0, 0));

		JPanel panel_31 = new JPanel();
		FlowLayout flowLayout_12 = (FlowLayout) panel_31.getLayout();
		flowLayout_12.setAlignment(FlowLayout.LEFT);
		flowLayout_12.setVgap(7);
		panel_22.add(panel_31, BorderLayout.NORTH);

		JLabel lblNewLabel_29 = new JLabel("请输入要查找的姓名： ");
		lblNewLabel_29.setFont(new Font("宋体", Font.PLAIN, 14));
		panel_31.add(lblNewLabel_29);

		textField_16 = new JTextField();
		panel_31.add(textField_16);
		textField_16.setColumns(26);

		JLabel lblNewLabel_30 = new JLabel(" ");
		panel_31.add(lblNewLabel_30);

		JButton btnNewButton_11 = new JButton("查  找");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = textField_16.getText();
				table_14.setModel(new DefaultTableModel(fillStaffTable(StaffNameDao.displayStaff(item)), staffColumns));
			}
		});
		btnNewButton_11.setFont(new Font("宋体", Font.PLAIN, 13));
		panel_31.add(btnNewButton_11);

		JScrollPane scrollPane_14 = new JScrollPane();
		panel_22.add(scrollPane_14, BorderLayout.CENTER);

		table_14 = new JTable();
		table_14.setModel(new DefaultTableModel(new Object[][] {}, staffColumns));
		table_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Delete(table_14.getValueAt(table_14.getSelectedRow(), 0), user, 1);
			}
		});
		scrollPane_14.setViewportView(table_14);

		JPanel panel_23 = new JPanel();
		tabbedPane_2.addTab("设置管理员", null, panel_23, null);
		panel_23.setLayout(new BorderLayout(0, 0));

		JPanel panel_33 = new JPanel();
		FlowLayout flowLayout_14 = (FlowLayout) panel_33.getLayout();
		flowLayout_14.setAlignment(FlowLayout.LEFT);
		flowLayout_14.setVgap(7);
		panel_23.add(panel_33, BorderLayout.NORTH);

		JLabel lblNewLabel_33 = new JLabel("请输入要查找的姓名： ");
		lblNewLabel_33.setFont(new Font("宋体", Font.PLAIN, 14));
		panel_33.add(lblNewLabel_33);

		textField_18 = new JTextField();
		panel_33.add(textField_18);
		textField_18.setColumns(26);

		JLabel lblNewLabel_34 = new JLabel(" ");
		panel_33.add(lblNewLabel_34);

		JButton btnNewButton_13 = new JButton("查  找");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = textField_18.getText();
				table_16.setModel(new DefaultTableModel(fillStaffTable(StaffNameDao.displayStaff(item)), staffColumns));
			}
		});
		panel_33.add(btnNewButton_13);

		JScrollPane scrollPane_16 = new JScrollPane();
		panel_23.add(scrollPane_16, BorderLayout.CENTER);

		table_16 = new JTable();
		table_16.setModel(new DefaultTableModel(new Object[][] {}, staffColumns));
		table_16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setManager(table_16.getValueAt(table_16.getSelectedRow(), 0));
			}
		});
		scrollPane_16.setViewportView(table_16);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tabbedPane.getSelectedIndex() == 0) {
					table.setModel(
							new DefaultTableModel(fillEquipTable(AllEquipmentDao.displayAllEquipment()), equipColumns));
				}
				if (tabbedPane.getSelectedIndex() == 6) {
					clear();
				}
			}
		});
		tabbedPane_1.addTab("关于设备", null, tabbedPane, null);

		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("总览", null, scrollPane, null);

		table = new JTable();
		table.setModel(new DefaultTableModel(fillEquipTable(AllEquipmentDao.displayAllEquipment()), equipColumns));
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
				table_1.setModel(
						new DefaultTableModel(fillEquipTable(EquipmentNameDao.displayEquipment(item)), equipColumns));
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 13));
		panel_1.add(btnNewButton);

		JScrollPane scrollPane_1 = new JScrollPane();
		panel_2.add(scrollPane_1, BorderLayout.CENTER);

		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(new Object[][] {}, equipColumns));
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
					table_4.setModel(new DefaultTableModel(new Object[][] {}, equipColumns));
				} else {
					table_4.setModel(new DefaultTableModel(fillEquipTable(data), equipColumns));
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
		table_4.setModel(new DefaultTableModel(new Object[][] {}, equipColumns));
		scrollPane_4.setViewportView(table_4);

		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("按位置查找", null, panel_4, null);
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
				table_2.setModel(
						new DefaultTableModel(fillEquipTable(EquipmentLocDao.displayEquipment(item)), equipColumns));
			}
		});

		JLabel lblNewLabel_6 = new JLabel(" ");
		panel_6.add(lblNewLabel_6);
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 13));
		panel_6.add(btnNewButton_1);

		JScrollPane scrollPane_2 = new JScrollPane();
		panel_4.add(scrollPane_2, BorderLayout.CENTER);

		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(new Object[][] {}, equipColumns));
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
				table_3.setModel(
						new DefaultTableModel(fillEquipTable(EquipmentManaDao.displayEquipment(item)), equipColumns));
			}
		});

		JLabel lblNewLabel_5 = new JLabel(" ");
		panel_7.add(lblNewLabel_5);
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 13));
		panel_7.add(btnNewButton_2);

		JScrollPane scrollPane_3 = new JScrollPane();
		panel_5.add(scrollPane_3, BorderLayout.CENTER);

		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(new Object[][] {}, equipColumns));
		scrollPane_3.setViewportView(table_3);

		JPanel panel_10 = new JPanel();
		tabbedPane.addTab("修改信息", null, panel_10, null);
		panel_10.setLayout(new BorderLayout(0, 0));

		JPanel panel_27 = new JPanel();
		FlowLayout flowLayout_8 = (FlowLayout) panel_27.getLayout();
		flowLayout_8.setVgap(7);
		flowLayout_8.setAlignment(FlowLayout.LEFT);
		panel_10.add(panel_27, BorderLayout.NORTH);

		JLabel lblNewLabel_21 = new JLabel("请输入要查找的名称： ");
		lblNewLabel_21.setFont(new Font("宋体", Font.PLAIN, 14));
		panel_27.add(lblNewLabel_21);

		textField_12 = new JTextField();
		panel_27.add(textField_12);
		textField_12.setColumns(26);

		JLabel lblNewLabel_22 = new JLabel(" ");
		panel_27.add(lblNewLabel_22);

		JButton btnNewButton_7 = new JButton("查  找");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = textField_12.getText();
				table_10.setModel(
						new DefaultTableModel(fillEquipTable(EquipmentNameDao.displayEquipment(item)), equipColumns));
			}
		});
		panel_27.add(btnNewButton_7);

		JScrollPane scrollPane_10 = new JScrollPane();
		panel_10.add(scrollPane_10, BorderLayout.CENTER);

		table_10 = new JTable();
		table_10.addMouseListener(new MouseAdapter() {
			private EquipUpdateFrame euf;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (equipUp) {
					euf.dispose();
				}
				int sel = table_10.getSelectedRow();
				euf = new EquipUpdateFrame(table_10.getValueAt(sel, 0), table_10.getValueAt(sel, 1),
						table_10.getValueAt(sel, 2), table_10.getValueAt(sel, 3), table_10.getValueAt(sel, 4),
						table_10.getValueAt(sel, 5), table_10.getValueAt(sel, 6));
				euf.setVisible(true);
				equipUp = true;
			}
		});
		table_10.setModel(new DefaultTableModel(new Object[][] {}, equipColumns));
		scrollPane_10.setViewportView(table_10);

		JPanel panel_11 = new JPanel();
		tabbedPane.addTab("增加设备", null, panel_11, null);
		panel_11.setLayout(new BorderLayout(0, 0));

		JPanel panel_34 = new JPanel();
		panel_11.add(panel_34, BorderLayout.CENTER);
		panel_34.setLayout(new GridLayout(3, 2, 0, 0));

		JPanel panel_36 = new JPanel();
		panel_34.add(panel_36);
		panel_36.setLayout(null);

		JLabel lblNewLabel_35 = new JLabel("名称");
		lblNewLabel_35.setBounds(47, 38, 70, 16);
		lblNewLabel_35.setFont(new Font("宋体", Font.PLAIN, 14));
		panel_36.add(lblNewLabel_35);

		textField_19 = new JTextField();
		textField_19.setBounds(127, 33, 122, 27);
		panel_36.add(textField_19);
		textField_19.setColumns(10);

		JPanel panel_37 = new JPanel();
		panel_34.add(panel_37);
		panel_37.setLayout(null);

		JLabel lblNewLabel_36 = new JLabel("规格");
		lblNewLabel_36.setBounds(47, 38, 70, 16);
		lblNewLabel_36.setFont(new Font("宋体", Font.PLAIN, 14));
		panel_37.add(lblNewLabel_36);

		textField_20 = new JTextField();
		textField_20.setBounds(127, 33, 122, 27);
		panel_37.add(textField_20);
		textField_20.setColumns(10);

		JPanel panel_38 = new JPanel();
		panel_34.add(panel_38);
		panel_38.setLayout(null);

		JLabel lblNewLabel_37 = new JLabel("价格");
		lblNewLabel_37.setBounds(47, 38, 70, 16);
		lblNewLabel_37.setFont(new Font("宋体", Font.PLAIN, 14));
		panel_38.add(lblNewLabel_37);

		textField_21 = new JTextField();
		textField_21.setBounds(127, 33, 122, 27);
		panel_38.add(textField_21);
		textField_21.setColumns(10);

		JPanel panel_39 = new JPanel();
		panel_34.add(panel_39);
		panel_39.setLayout(null);

		JLabel lblNewLabel_38 = new JLabel("购入日期");
		lblNewLabel_38.setBounds(47, 38, 70, 16);
		lblNewLabel_38.setFont(new Font("宋体", Font.PLAIN, 14));
		panel_39.add(lblNewLabel_38);

		textField_22 = new JTextField();
		textField_22.setToolTipText("6位数字");
		textField_22.setBounds(127, 33, 122, 27);
		panel_39.add(textField_22);
		textField_22.setColumns(10);

		JPanel panel_40 = new JPanel();
		panel_40.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_34.add(panel_40);
		panel_40.setLayout(null);

		JLabel lblNewLabel_39 = new JLabel("存放位置");
		lblNewLabel_39.setBounds(47, 38, 70, 16);
		lblNewLabel_39.setFont(new Font("宋体", Font.PLAIN, 14));
		panel_40.add(lblNewLabel_39);

		textField_23 = new JTextField();
		textField_23.setBounds(127, 33, 122, 27);
		panel_40.add(textField_23);
		textField_23.setColumns(10);

		JPanel panel_41 = new JPanel();
		panel_41.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_34.add(panel_41);
		panel_41.setLayout(null);

		JLabel lblNewLabel_40 = new JLabel("设备负责人");
		lblNewLabel_40.setBounds(47, 38, 70, 16);
		lblNewLabel_40.setFont(new Font("宋体", Font.PLAIN, 14));
		panel_41.add(lblNewLabel_40);

		textField_24 = new JTextField();
		textField_24.setBounds(127, 33, 122, 27);
		panel_41.add(textField_24);
		textField_24.setColumns(10);

		JPanel panel_35 = new JPanel();
		FlowLayout flowLayout_15 = (FlowLayout) panel_35.getLayout();
		flowLayout_15.setVgap(10);
		panel_11.add(panel_35, BorderLayout.SOUTH);

		JButton btnNewButton_14 = new JButton("添  加");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createEquip(textField_19.getText(), textField_20.getText(), textField_21.getText(),
						textField_22.getText(), textField_23.getText(), textField_24.getText());
			}
		});
		panel_35.add(btnNewButton_14);

		JLabel lblNewLabel_41 = new JLabel("           ");
		panel_35.add(lblNewLabel_41);

		JButton btnNewButton_15 = new JButton("重  置");
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		panel_35.add(btnNewButton_15);

		JPanel panel_12 = new JPanel();
		tabbedPane.addTab("删除设备", null, panel_12, null);
		panel_12.setLayout(new BorderLayout(0, 0));

		JPanel panel_30 = new JPanel();
		FlowLayout flowLayout_11 = (FlowLayout) panel_30.getLayout();
		flowLayout_11.setAlignment(FlowLayout.LEFT);
		flowLayout_11.setVgap(7);
		panel_12.add(panel_30, BorderLayout.NORTH);

		JLabel lblNewLabel_27 = new JLabel("请输入要查找的名称： ");
		lblNewLabel_27.setFont(new Font("宋体", Font.PLAIN, 14));
		panel_30.add(lblNewLabel_27);

		textField_15 = new JTextField();
		panel_30.add(textField_15);
		textField_15.setColumns(26);

		JLabel lblNewLabel_28 = new JLabel(" ");
		panel_30.add(lblNewLabel_28);

		JButton btnNewButton_10 = new JButton("查  找");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = textField_15.getText();
				table_13.setModel(
						new DefaultTableModel(fillEquipTable(EquipmentNameDao.displayEquipment(item)), equipColumns));
			}
		});
		panel_30.add(btnNewButton_10);

		JScrollPane scrollPane_13 = new JScrollPane();
		panel_12.add(scrollPane_13, BorderLayout.CENTER);

		table_13 = new JTable();
		table_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Delete(table_13.getValueAt(table_13.getSelectedRow(), 0), user, 2);
			}
		});
		table_13.setModel(new DefaultTableModel(new Object[][] {}, equipColumns));
		scrollPane_13.setViewportView(table_13);

		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(1);
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("管理员" + user + "，请选择您需要的功能");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		panel.add(lblNewLabel);
	}

	public String[][] fillDepTable(ArrayList<DepartmentDomain> al) {
		int cnt = al.size();
		int i = 0;
		String[][] data = new String[cnt][3];
		for (DepartmentDomain dd : al) {
			data[i][0] = dd.getId();
			data[i][1] = dd.getName();
			data[i][2] = dd.getManager();
			i++;
		}
		return data;
	}

	public String[][] fillStaffTable(ArrayList<StaffDomain> al) {
		int cnt = al.size();
		int i = 0;
		String[][] data = new String[cnt][5];
		for (StaffDomain sd : al) {
			data[i][0] = sd.getId();
			data[i][1] = sd.getName();
			data[i][2] = sd.getTel();
			data[i][3] = String.valueOf(sd.isIsmanager());
			data[i][4] = sd.getDepid();
			i++;
		}
		return data;
	}

	public String[][] fillEquipTable(ArrayList<EquipmentDomain> al) {
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

	public void createDep(String id, String name, String manager) {
		Object[] options = { "确定", "取消" };
		int sel = JOptionPane.showOptionDialog(null, "真的要添加吗？", "确定？", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if (sel == JOptionPane.YES_OPTION) {
			if (id.isEmpty() || name.isEmpty() || manager.isEmpty()) {
				JOptionPane.showMessageDialog(null, "添加信息不完整！", "提示", JOptionPane.INFORMATION_MESSAGE);
			} else {
				if (CreateDao.createDep(id, name, manager) != 0) {
					JOptionPane.showMessageDialog(null, "添加成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
				}

			}
		}
	}

	public void createStaff(String id, String password, String name, String tel, String isMana, String depid) {
		Object[] options = { "确定", "取消" };
		int sel = JOptionPane.showOptionDialog(null, "真的要添加吗？", "确定？", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if (sel == JOptionPane.YES_OPTION) {
			if (id.isEmpty() || password.isEmpty() || name.isEmpty() || tel.isEmpty()) {
				JOptionPane.showMessageDialog(null, "添加信息不完整！", "提示", JOptionPane.INFORMATION_MESSAGE);
			} else {
				if (RegisterDao.notExisting(id)) {
					if (password.length() >= 8 && password.length() <= 20) {
						if (tel.length() == 11) {
							if (depid != "0") {
								if (CreateDao.createStaff(id, password, name, tel, isMana, depid) != 0) {
									JOptionPane.showMessageDialog(null, "添加成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
								}
							} else {
								JOptionPane.showMessageDialog(null, "您还没有选择部门！", "提示", JOptionPane.INFORMATION_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null, "手机号码不符合要求！", "提示", JOptionPane.INFORMATION_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "密码长度不符合要求！", "提示", JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "该用户已存在！", "提示", JOptionPane.INFORMATION_MESSAGE);
					clear();
				}
			}
		}
	}

	public void createEquip(String name, String spec, String price, String date, String loc, String manager) {
		Object[] options = { "确定", "取消" };
		int sel = JOptionPane.showOptionDialog(null, "真的要添加吗？", "确定？", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if (sel == JOptionPane.YES_OPTION) {
			if (name.isEmpty() || spec.isEmpty() || price.isEmpty() || date.isEmpty() || loc.isEmpty()
					|| manager.isEmpty()) {
				JOptionPane.showMessageDialog(null, "添加信息不完整！", "提示", JOptionPane.INFORMATION_MESSAGE);
			} else {
				if (date.length() == 6) {
					if (CreateDao.createEquip(name, spec, price, date, loc, manager) != 0) {
						JOptionPane.showMessageDialog(null, "添加成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "日期格式错误！", "提示", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}

	public void Delete(Object id, String user, int tableSel) {
		Object[] options = { "确定", "取消" };
		int sel = JOptionPane.showOptionDialog(null, "真的要删除吗？", "确定？", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if (sel == JOptionPane.YES_OPTION) {
			if (tableSel == 0) {
				if (DeleteDao.DepDel(String.valueOf(id)) != 0) {
					JOptionPane.showMessageDialog(null, "删除成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			if (tableSel == 1) {
				if(!id.equals(user)) {
					if (DeleteDao.StaffDel(String.valueOf(id)) != 0) {
						JOptionPane.showMessageDialog(null, "删除成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "管理员不能删除自己！", "提示", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			if (tableSel == 2) {
				if (DeleteDao.EquipDel(String.valueOf(id)) != 0) {
					JOptionPane.showMessageDialog(null, "删除成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}

	public void setManager(Object id) {
		Object[] options = { "确定", "取消" };
		int sel = JOptionPane.showOptionDialog(null, "真的要设置吗？", "确定？", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if (sel == JOptionPane.YES_OPTION) {
			if (UpdateDao.managerUpdate(String.valueOf(id)) != 0) {
				JOptionPane.showMessageDialog(null, "设置管理员成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public void clear() {
		textField_19.setText("");
		textField_20.setText("");
		textField_21.setText("");
		textField_22.setText("");
		textField_23.setText("");
		textField_24.setText("");
		textField_25.setText("");
		textField_26.setText("");
		textField_27.setText("");
		textField_28.setText("");
		textField_29.setText("");
		textField_30.setText("");
		textField_31.setText("");
		comboBox.setSelectedIndex(0);
		comboBox_1.setSelectedIndex(0);
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
