import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;

public class LogIn extends JFrame implements ActionListener{
	JLabel uJLabel,pJLabel;
	JTextField uJTextField;
	JPasswordField jPasswordField;
	JButton b;
	public LogIn() {
		// TODO Auto-generated constructor stub
		
		
		
		b=new JButton("LogIn");
		b.setBounds(100, 180, 80, 45);
		b.addActionListener(this);
		uJLabel=new JLabel("Username");
		uJLabel.setBounds(50, 50, 110, 25);
		uJTextField=new JTextField(20);
		uJTextField.setBounds(190, 50, 90, 25);
		
		pJLabel=new JLabel("Password");
		pJLabel.setBounds(50, 100, 110, 25);
		jPasswordField=new JPasswordField(20);
		jPasswordField=new JPasswordField(20);
		jPasswordField.setBounds(190, 100, 90, 25);
		//pJTextField.setEchoChar('*');
		
		add(b);
		add(uJLabel);
		add(uJTextField);
		add(pJLabel);
		add(jPasswordField);
		
		setSize(500,400);
		setLayout(null);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String un;
		char str[];
		un=uJTextField.getText();
		str=jPasswordField.getPassword();
		String pass=new String(str);
		
		try{  
		    //step1 load the driver class  
		    Class.forName("oracle.jdbc.driver.OracleDriver");  
		      
		    //step2 create  the connection object  
		    Connection con=DriverManager.getConnection(  
		    "jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","Nikhil");  
		      
		    //step3 create the statement object  
		    Statement stmt=con.createStatement();  
		      
		    //step4 execute query  
		    ResultSet rs;
		    rs=stmt.executeQuery("select * from login_detail where username='"+un+"'and password='"+pass+"'");
		   if(rs.next())
		   {
			   System.out.println("successful");
			   dispose();
			   //open dialog box and show login successful
		   }
		   else
		   {
			   System.out.println("Login fail- username or password incorrect");
			   dispose();
		   }
		      
		    
		    
		    /*rs=stmt.executeQuery("select * from abcde"); 
		    while(rs.next())  
		        System.out.println(rs.getString(1));*/
		    
		    //step5 close the connection object  
		   
		    con.close();  
		      
		    }catch(Exception e1){ System.out.println(e1);} 
		
	}

}
