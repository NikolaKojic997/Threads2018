package gui;

import java.awt.EventQueue;

import test.Test;

public class GuiControler {
	
	public static ThreadsGui mainWindow;
	public static Test threadSistem;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					threadSistem = new Test();
					GuiControler.mainWindow = new ThreadsGui();
					GuiControler.mainWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public static void testSingInThreads() {
		
		threadSistem.testSingInThreads(mainWindow.getTextPane());
		
	}
	
	public static void stopTheTreads() {
		threadSistem.stopTheTreads();
	}
	
	
	

}
