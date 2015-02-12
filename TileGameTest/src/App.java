import java.awt.EventQueue;
import javax.swing.JFrame;


public class App extends JFrame{
	private static final long serialVersionUID = 0;

	public App(){
		initUI();
	}
	
	public void initUI(){
		add(new Board());
		setSize(250,200);
		setTitle("App");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){
			@Override
			public void run(){
				App app = new App();
				app.setVisible(true);
			}
		});
	}
}
