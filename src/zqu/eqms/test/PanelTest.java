package zqu.eqms.test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

public class PanelTest extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelTest frame = new PanelTest();
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
	public PanelTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JFileChooser chooser = new JFileChooser();
		File f = new File("D:\\image\\1.png");
		Icon icon = chooser.getIcon(f);
		int scale = 5;

		BufferedImage bi = new BufferedImage(scale * icon.getIconWidth(), scale * icon.getIconHeight(),
				BufferedImage.TYPE_INT_ARGB);

		Graphics2D g = bi.createGraphics();
		g.scale(scale, scale);
		icon.paintIcon(null, g, 0, 0);
		g.dispose();
//		JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(bi)));
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(bi));
		lblNewLabel.setBounds(96, 59, 146, 85);
		panel.add(lblNewLabel);
	}

}
