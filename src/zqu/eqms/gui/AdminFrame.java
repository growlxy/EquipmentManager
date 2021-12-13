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
import zqu.eqms.dao.DeleteDao;
import zqu.eqms.dao.DepNameDao;
import zqu.eqms.dao.EquipmentDateDao;
import zqu.eqms.dao.EquipmentLocDao;
import zqu.eqms.dao.EquipmentManaDao;
import zqu.eqms.dao.EquipmentNameDao;
import zqu.eqms.dao.StaffDepDao;
import zqu.eqms.dao.StaffNameDao;
import zqu.eqms.dao.StaffTelDao;
import zqu.eqms.domain.DepartmentDomain;
import zqu.eqms.domain.EquipmentDomain;
import zqu.eqms.domain.StaffDomain;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	private String[] depColumns = {"编号", "名称", "部门主管"};
	private String[] staffColumns = {"编号", "姓名", "联络电话", "是否为管理员", "部门"};
	private String[] equipColumns = {"编号", "名称", "规格", "价格", "购入日期", "存放位置", "设备负责人"};
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
        }catch(Exception e) {
        	e.printStackTrace();
        }
		
		setTitle("管理员界面");
		setResizable(false);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((d.width-606)/2, (d.height-445)/2, 606, 445);
		
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
				if(tabbedPane_3.getSelectedIndex()==0) {
					table_5.setModel(new DefaultTableModel(
							fillDepTable(AllDepartmentDao.displayAllDepartment()),
							depColumns
					));
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
		table_5.setModel(new DefaultTableModel(
			fillDepTable(AllDepartmentDao.displayAllDepartment()),
			depColumns
		));
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
				table_12.setModel(new DefaultTableModel(
						fillDepTable(DepNameDao.displayDepartment(item)),
						depColumns
				));
			}
		});
		btnNewButton_9.setFont(new Font("宋体", Font.PLAIN, 13));
		panel_29.add(btnNewButton_9);
		
		JScrollPane scrollPane_12 = new JScrollPane();
		panel_13.add(scrollPane_12, BorderLayout.CENTER);

		table_12 = new JTable();
		table_12.setModel(new DefaultTableModel(
			new Object[][] {},
			depColumns
		));
		table_12.addMouseListener(new MouseAdapter() {
			private DepUpdateFrame duf;

			@Override
			public void mouseClicked(MouseEvent e) {
				if(depUp) { duf.dispose();}
				int sel = table_12.getSelectedRow();
				duf = new DepUpdateFrame(table_12.getValueAt(sel, 0), table_12.getValueAt(sel, 1), table_12.getValueAt(sel, 2));
				duf.setVisible(true);
				depUp = true;
			}
		});
		scrollPane_12.setViewportView(table_12);
//		TODO
		JPanel panel_14 = new JPanel();
		tabbedPane_3.addTab("增加部门", null, panel_14, null);
		
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
				table_15.setModel(new DefaultTableModel(
						fillDepTable(DepNameDao.displayDepartment(item)),
						depColumns
				));
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
				Delete(table_15.getValueAt(table_15.getSelectedRow(), 0), 0);
			}
		});
		table_15.setModel(new DefaultTableModel(
			new Object[][] {},
			depColumns
		));
		scrollPane_15.setViewportView(table_15);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tabbedPane_2.getSelectedIndex()==0) {
					table_6.setModel(new DefaultTableModel(
							fillStaffTable(AllStaffDao.displayAllStaff()),
							staffColumns
					));
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
		table_6.setModel(new DefaultTableModel(
			fillStaffTable(AllStaffDao.displayAllStaff()),
			staffColumns
		));
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
				table_7.setModel(new DefaultTableModel(
						fillStaffTable(StaffNameDao.displayStaff(item)),
						staffColumns
				));
			}
		});
		btnNewButton_4.setFont(new Font("宋体", Font.PLAIN, 13));
		panel_24.add(btnNewButton_4);
		
		JScrollPane scrollPane_7 = new JScrollPane();
		panel_17.add(scrollPane_7, BorderLayout.CENTER);
		
		table_7 = new JTable();
		table_7.setModel(new DefaultTableModel(
			new Object[][] {},
			staffColumns
		));
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
				table_8.setModel(new DefaultTableModel(
						fillStaffTable(StaffTelDao.displayStaff(item)),
						staffColumns
				));
			}
		});
		btnNewButton_5.setFont(new Font("宋体", Font.PLAIN, 13));
		panel_25.add(btnNewButton_5);
		
		JScrollPane scrollPane_8 = new JScrollPane();
		panel_18.add(scrollPane_8, BorderLayout.CENTER);
		
		table_8 = new JTable();
		table_8.setModel(new DefaultTableModel(
			new Object[][] {},
			staffColumns
		));
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
				table_9.setModel(new DefaultTableModel(
						fillStaffTable(StaffDepDao.displayStaff(item)),
						staffColumns
				));
			}
		});
		btnNewButton_6.setFont(new Font("宋体", Font.PLAIN, 13));
		panel_26.add(btnNewButton_6);
		
		JScrollPane scrollPane_9 = new JScrollPane();
		panel_19.add(scrollPane_9, BorderLayout.CENTER);
		
		table_9 = new JTable();
		table_9.setModel(new DefaultTableModel(
			new Object[][] {},
			staffColumns
		));
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
				table_11.setModel(new DefaultTableModel(
						fillStaffTable(StaffNameDao.displayStaff(item)),
						staffColumns
				));
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
				if(staffUp) { suf.dispose();}
				int sel = table_11.getSelectedRow();
				suf = new StaffUpdateFrame(table_11.getValueAt(sel, 0), table_11.getValueAt(sel, 1), table_11.getValueAt(sel, 2), table_11.getValueAt(sel, 4));
				suf.setVisible(true);
				staffUp = true;
			}
		});
		table_11.setModel(new DefaultTableModel(
			new Object[][] {},
			staffColumns
		));
		scrollPane_11.setViewportView(table_11);
//		TODO
		JPanel panel_21 = new JPanel();
		tabbedPane_2.addTab("增加员工", null, panel_21, null);
		
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
				table_14.setModel(new DefaultTableModel(
						fillStaffTable(StaffNameDao.displayStaff(item)),
						staffColumns
				));
			}
		});
		btnNewButton_11.setFont(new Font("宋体", Font.PLAIN, 13));
		panel_31.add(btnNewButton_11);
		
		JScrollPane scrollPane_14 = new JScrollPane();
		panel_22.add(scrollPane_14, BorderLayout.CENTER);
		
		table_14 = new JTable();
		table_14.setModel(new DefaultTableModel(
			new Object[][] {},
			staffColumns
		));
		table_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Delete(table_14.getValueAt(table_14.getSelectedRow(), 0), 1);
			}
		});
		scrollPane_14.setViewportView(table_14);
		
		JPanel panel_23 = new JPanel();
		tabbedPane_2.addTab("设置管理员", null, panel_23, null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table.setModel(new DefaultTableModel(
						fillEquipTable(AllEquipmentDao.displayAllEquipment()),
						equipColumns
				));
			}
		});
		tabbedPane_1.addTab("关于设备", null, tabbedPane, null);
	
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("总览", null, scrollPane, null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			fillEquipTable(AllEquipmentDao.displayAllEquipment()),
			equipColumns
		));
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
				table_1.setModel(new DefaultTableModel(
						fillEquipTable(EquipmentNameDao.displayEquipment(item)),
						equipColumns
				));
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 13));
		panel_1.add(btnNewButton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_2.add(scrollPane_1, BorderLayout.CENTER);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {},
			equipColumns
		));
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
				ArrayList<EquipmentDomain> data = cheakDate(beginDateYear, beginDateMonth, beginDateDay,
						lastDateYear, lastDateMonth, lastDateDay);
				if(data == null) {
					table_4.setModel(new DefaultTableModel(
							new Object[][] {},
							equipColumns
					));
				}
				else {
					table_4.setModel(new DefaultTableModel(
							fillEquipTable(data),
							equipColumns
					));
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
		table_4.setModel(new DefaultTableModel(
			new Object[][] {},
			equipColumns
		));
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
				table_2.setModel(new DefaultTableModel(
						fillEquipTable(EquipmentLocDao.displayEquipment(item)),
						equipColumns
				));
			}
		});
		
		JLabel lblNewLabel_6 = new JLabel(" ");
		panel_6.add(lblNewLabel_6);
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 13));
		panel_6.add(btnNewButton_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel_4.add(scrollPane_2, BorderLayout.CENTER);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {},
			equipColumns
		));
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
				table_3.setModel(new DefaultTableModel(
						fillEquipTable(EquipmentManaDao.displayEquipment(item)),
						equipColumns
				));
			}
		});
		
		JLabel lblNewLabel_5 = new JLabel(" ");
		panel_7.add(lblNewLabel_5);
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 13));
		panel_7.add(btnNewButton_2);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		panel_5.add(scrollPane_3, BorderLayout.CENTER);
		
		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(
			new Object[][] {},
			equipColumns
		));
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
				table_10.setModel(new DefaultTableModel(
						fillEquipTable(EquipmentNameDao.displayEquipment(item)),
						equipColumns
				));
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
				if(equipUp) { euf.dispose();}
				int sel = table_10.getSelectedRow();
				euf = new EquipUpdateFrame(table_10.getValueAt(sel, 0), table_10.getValueAt(sel, 1), table_10.getValueAt(sel, 2), table_10.getValueAt(sel, 3),
						table_10.getValueAt(sel, 4), table_10.getValueAt(sel, 5), table_10.getValueAt(sel, 6));
				euf.setVisible(true);
				equipUp = true;
			}
		});
		table_10.setModel(new DefaultTableModel(
			new Object[][] {},
			equipColumns
		));
		scrollPane_10.setViewportView(table_10);
//		TODO
		JPanel panel_11 = new JPanel();
		tabbedPane.addTab("增加设备", null, panel_11, null);
		
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
				table_13.setModel(new DefaultTableModel(
						fillEquipTable(EquipmentNameDao.displayEquipment(item)),
						equipColumns
				));
			}
		});
		panel_30.add(btnNewButton_10);
		
		JScrollPane scrollPane_13 = new JScrollPane();
		panel_12.add(scrollPane_13, BorderLayout.CENTER);
		
		table_13 = new JTable();
		table_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Delete(table_13.getValueAt(table_13.getSelectedRow(), 0), 2);
			}
		});
		table_13.setModel(new DefaultTableModel(
			new Object[][] {},
			equipColumns
		));
		scrollPane_13.setViewportView(table_13);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(1);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("管理员"+user+"，请选择您需要的功能");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		panel.add(lblNewLabel);
	}

	public String[][] fillDepTable(ArrayList<DepartmentDomain> al){
		int cnt = al.size();
		int i = 0;
		String[][] data = new String[cnt][3];
		for(DepartmentDomain dd : al) {
			data[i][0] = dd.getId();
			data[i][1] = dd.getName();
			data[i][2] = dd.getManager();
			i++;
		}
		return data;
	}
	
	public String[][] fillStaffTable(ArrayList<StaffDomain> al){
		int cnt = al.size();
		int i = 0;
		String[][] data = new String[cnt][5];
		for(StaffDomain sd : al) {
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
		for(EquipmentDomain ed : al) {
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
	
	public ArrayList<EquipmentDomain> cheakDate(String beginDateYear, String beginDateMonth, String beginDateDay, String lastDateYear, String lastDateMonth, String lastDateDay){
		String beginDate = beginDateYear+beginDateMonth+beginDateDay;
		String lastDate = lastDateYear+lastDateMonth+lastDateDay;
		ArrayList<EquipmentDomain> al = null;
		if(beginDateYear.length()==4&&beginDateMonth.length()==2&&beginDateDay.length()==2&&
				lastDateYear.length()==4&&lastDateMonth.length()==2&&lastDateDay.length()==2) {
			al = EquipmentDateDao.displayEquipment(beginDate, lastDate);
		}
		else {
			JOptionPane.showMessageDialog(null, "您输入的信息不正确！", "提示", JOptionPane.INFORMATION_MESSAGE);
		}
		return al;
	}
	
	protected void Delete(Object id, int tableSel) {
		Object[] options = {"确定", "取消"};
		int sel = JOptionPane.showOptionDialog(null, "真的要删除吗？", "确定？", JOptionPane.YES_NO_OPTION, 
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if(sel == JOptionPane.YES_OPTION) {
			if(tableSel==0) {
				if(DeleteDao.DepDel(String.valueOf(id))!=0) {
					JOptionPane.showMessageDialog(null, "删除成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			if(tableSel==1) {
				if(DeleteDao.StaffDel(String.valueOf(id))!=0) {
					JOptionPane.showMessageDialog(null, "删除成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			if(tableSel==2) {
				if(DeleteDao.EquipDel(String.valueOf(id))!=0) {
					JOptionPane.showMessageDialog(null, "删除成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
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
