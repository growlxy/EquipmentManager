package zqu.eqms.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.MatteBorder;

import zqu.eqms.dao.UpdateDao;

public class EquipUpdateFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EquipUpdateFrame frame = new EquipUpdateFrame(null, null, null, null, null, null, null);
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
	public EquipUpdateFrame(Object id, Object name, Object spec, Object price, Object date, Object loc, Object manager) {
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
		setTitle("修改信息");
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((d.width-408)/2, (d.height-202)/2, 408, 202);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(3, 2, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("名称");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 20, 70, 19);
		panel_2.add(lblNewLabel);
		
		textField = new JTextField(String.valueOf(name));
		textField.setBounds(90, 14, 98, 28);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("规格");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 20, 70, 19);
		panel_3.add(lblNewLabel_1);
		
		textField_1 = new JTextField(String.valueOf(spec));
		textField_1.setBounds(90, 14, 98, 28);
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("价格");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 20, 70, 19);
		panel_4.add(lblNewLabel_2);
		
		textField_2 = new JTextField(String.valueOf(price));
		textField_2.setBounds(90, 14, 98, 28);
		panel_4.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("购入日期");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 20, 70, 19);
		panel_5.add(lblNewLabel_3);

		textField_3 = new JTextField(String.valueOf(date));
		textField_3.setBounds(90, 14, 98, 28);
		panel_5.add(textField_3);
		textField_3.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("存放位置");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 20, 70, 19);
		panel_6.add(lblNewLabel_4);
		
		textField_4 = new JTextField(String.valueOf(loc));
		textField_4.setBounds(90, 14, 98, 28);
		panel_6.add(textField_4);
		textField_4.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("设备负责人");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(10, 20, 70, 19);
		panel_7.add(lblNewLabel_5);
		
		textField_5 = new JTextField(String.valueOf(manager));
		textField_5.setBounds(90, 14, 98, 28);
		panel_7.add(textField_5);
		textField_5.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setVgap(10);
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("更新");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = {"确定", "取消"};
				int sel = JOptionPane.showOptionDialog(null, "确定要修改吗？", "确定？", JOptionPane.YES_NO_OPTION, 
						JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				if(sel == JOptionPane.YES_OPTION) {
					Update(String.valueOf(id), textField.getText(), textField_1.getText(), textField_2.getText(), 
							textField_3.getText(), textField_4.getText(), textField_5.getText());
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
	
	public void Update(String id, String name, String spec, String price, String date, String loc, String manager) {
		if(name.equals("")||spec.equals("")||price.equals("")||date.equals("")||loc.equals("")||manager.equals("")) {
			JOptionPane.showMessageDialog(null, "信息不完整！", "提示", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			if(date.length()>=6) {
				if(UpdateDao.EquipUpdate(id, name, spec, price, date, loc, manager)!=0) {
					JOptionPane.showMessageDialog(null, "修改成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "日期格式错误！", "提示", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}
