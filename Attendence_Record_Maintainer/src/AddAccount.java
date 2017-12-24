import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;


public class AddAccount extends JFrame implements ActionListener  {
	JLabel uJLabel,pJLabel,cpJLabel;
	JButton b;
	JTextField uJTextField;
	JPasswordField cpJTextField,pJTextField;
	public AddAccount() {
		// TODO Auto-generated constructor stub
		/*addWindowListener(new WindowAdapter(){  
            public void windowClosing(WindowEvent e) {  
                dispose();  
            }  
        });  */   
		
		b=new JButton("Add");
		b.setBounds(120, 200, 70, 45);
		b.addActionListener(this);
		add(b);
		
		uJLabel=new JLabel("Username");
		uJLabel.setBounds(50, 50, 110, 25);
		uJTextField=new JTextField(20);
		uJTextField.setBounds(190, 50, 90, 25);
		
		pJLabel=new JLabel("Password");
		pJLabel.setBounds(50, 100, 110, 25);
		pJTextField=new JPasswordField(20);
		pJTextField.setBounds(190, 100, 90, 25);
		//pJTextField.setEchoChar('*');
		
		cpJLabel=new JLabel("confirm Password");
		cpJLabel.setBounds(50, 150, 130, 25);
		cpJTextField=new JPasswordField(20);
		cpJTextField.setBounds(190, 150, 90, 25);
		//cpJTextField.setEchoChar('*');
		
		add(uJLabel);
		add(uJTextField);
		add(pJLabel);
		add(pJTextField);
		add(cpJLabel);
		add(cpJTextField);
		
		setSize(500,400);
		setLayout(null);
		setVisible(true);
		
		
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String un,pass,conPass;
		char []str1;
		char []str2;
		un=uJTextField.getText();
		str1=pJTextField.getPassword();
		str2=cpJTextField.getPassword();
		pass=new String(str1);
		conPass=new String(str2);
		try{  
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Nikhil");  
			  
			//step3 create the statement object  
			Statement stmt=con.createStatement();  
			  
			//step4 execute query  
			ResultSet rs;
			rs=stmt.executeQuery("select username from login_detail where username='"+un+"'");
			
			if(rs.next())
			{
				//dispose();
				//open dialog box and show username already exists.
				System.out.println("username already exists");
				JOptionPane.showMessageDialog(getComponent(0), "This username already exists Try with another username");
				con.close();
				return;
				
			}
			
			if(pass.equals(conPass))
			{
				if(un.equals("")||pass.equals("")){JOptionPane.showMessageDialog(getComponent(0),"username or password is empty");}
				else
				{
				rs=stmt.executeQuery("insert into login_detail values('"+un+"','"+pass+"')");
				//open dialog box and show that user successfully added .
				System.out.println("successfully added");
				JOptionPane.showMessageDialog(getComponent(0), "user "+un+" is successfully added");
				dispose();
				}
				
			}
			else
			{
				//dispose();
				//open dialog box and show that password does not match.
				System.out.println("password does not match");
				JOptionPane.showMessageDialog(getComponent(0), "Password does not match");
				
			}
			
						

			con.close();  
			  
			}catch(Exception e1){ System.out.println(e1);}		
	}

}
