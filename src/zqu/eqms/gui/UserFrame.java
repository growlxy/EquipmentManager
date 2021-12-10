package zqu.eqms.gui;

import java.awt.BorderLayout;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import zqu.eqms.domain.EquipmentDomain;
import zqu.eqms.dao.AllEquipment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class UserFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

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
//		TODO 居中界面
		setTitle("用户界面");
//		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 445);
		
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
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("关于作者");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "软件作者：罗启洋", "提示", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
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
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
	
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("总览", null, scrollPane, null);
		
		int cnt = AllEquipment.displayAllEquipment().size();
		int i = 0;
		String[][] data = new String[cnt][7];
		for(EquipmentDomain ed : AllEquipment.displayAllEquipment()) {
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
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, AllEquipment.displayAllEquipment().get(table.getSelectedRow()).getPic(), "提示", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		table.setModel(new DefaultTableModel(
			data,
			new String[] {"编号", "名字", "规格", "价格", "购入日期", "存放位置", "设备负责人"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("按名称查找", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("按日期查找", null, panel_3, null);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("按存放位置查找", null, panel_4, null);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("按部门查找", null, panel_5, null);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(10);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("用户"+user+"，请选择您要查找的对象");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton);
		
//		AllEquipment.displayAllEquipment().get(table.getSelectedRow()).getPic()
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setIcon(null);
		panel.add(lblNewLabel_1);
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
