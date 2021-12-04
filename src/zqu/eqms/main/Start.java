package zqu.eqms.main;

import java.awt.EventQueue;

import zqu.eqms.gui.LoginFrame;

public class Start {
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
}
