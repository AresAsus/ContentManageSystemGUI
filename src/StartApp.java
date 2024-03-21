import java.awt.EventQueue;

public class StartApp extends JFrame {
	public StartApp() {
		
	}
	
	public static void main(String[] args) {
//		System.out.println("Hello World");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					StartApp frame = new StartApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

}
