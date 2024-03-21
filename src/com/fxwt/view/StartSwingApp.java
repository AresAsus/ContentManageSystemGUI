package com.fxwt.view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class StartSwingApp extends JFrame {
	public StartSwingApp() {}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				try {
					System.out.println(" ----- Starting the management system ------ ");
					Font font = new Font("华文楷体",Font.PLAIN,15);
					UIManager.put("Button.font", font); 
					UIManager.put("Menu.font", font);
					UIManager.put("MenuItem.font", font);
					UIManager.put("MenuItemUI.font", font);
					
					LoginView newView = new LoginView();
					newView.creatJf();
					System.out.println(" -----  Ending the management system  ------ ");
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
