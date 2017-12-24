import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindow extends JFrame implements ActionListener{
	JButton b1,b2; 
	public MainWindow() {
		// TODO Auto-generated constructor stub
		
		/*addWindowListener(new WindowAdapter(){  
            public void windowClosing(WindowEvent e) {  
                dispose();  
            } 
        })*/
		b1=new JButton("Add Account");
		b2=new JButton("LogIn");
		b1.setBounds(100, 100, 150, 50);
		b1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AddAccount();
			}
		});
		
		b2.setBounds(100, 200, 150, 50);
		b2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new LogIn();
				
			}
		});
		
		add(b1);
		add(b2);
		
		setSize(600, 500);
		setLayout(null);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
