package classes;
import java.lang.*;
import interfaces.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUp implements ActionListener, ISignUp{

	private JFrame frame;
	private JLabel label1;
	private JLabel userName;
	private JLabel userPass;
	private JLabel confirmUserPass;
	private JLabel email;
	private JTextField tfUName;
	private JPasswordField pfUPass;
	private JPasswordField cpfUPass;
	private JTextField tfemail;
	private JButton signUpButton1;
	private JButton exitButton;
	private JButton previous0;
	
	public SignUp()
	{
		//frame
		frame = new JFrame("Sign Up");
		
		//icon
		ImageIcon framelogo = new ImageIcon("icons/framelogo.jpg");
		ImageIcon signupImage = new ImageIcon("icons/signup.png");
		ImageIcon userNameImage = new ImageIcon("icons/username.png");
		ImageIcon UserPassImage = new ImageIcon("icons/userpass.png");
		ImageIcon EmailImage = new ImageIcon("icons/email.png");
		ImageIcon previousImage = new ImageIcon("icons/previous.png");
		ImageIcon exitImage = new ImageIcon("icons/exiticon.png");
		
		//background
		Image background = new ImageIcon("icons/main2.jpg").getImage().getScaledInstance(800, 550, Image.SCALE_AREA_AVERAGING);
		frame.setContentPane(new ImagePanel(background));
		
		//message
		label1 = new JLabel("Enter Your Information Below");
		label1.setForeground(Color.black);
		label1.setFont(new Font("Imprint MT Shadow",Font.PLAIN,25));
		label1.setBounds(230, 0, 400, 80);
		frame.add(label1);
		
		
		userName = new JLabel("Username:* ");
		userName.setBounds(240, 140, 110, 30);
		userName.setFont(new Font("Calibri",Font.BOLD,16));
		userName.setIcon(userNameImage);
		userName.setForeground(Color.decode("#000000"));
		frame.add(userName);
		
		
		userPass = new JLabel("Password:* ");
		userPass.setBounds(240, 180, 110, 30);
		userPass.setFont(new Font("Calibri",Font.BOLD,16));
		userPass.setIcon(UserPassImage);
		userPass.setForeground(Color.decode("#000000"));
		frame.add(userPass);
		
		
		confirmUserPass = new JLabel("Confirm Password:* ");
		confirmUserPass.setBounds(240, 220, 180, 30);
		confirmUserPass.setFont(new Font("Calibri",Font.BOLD,16));
		confirmUserPass.setForeground(Color.decode("#000000"));
		confirmUserPass.setIcon(UserPassImage);
		frame.add(confirmUserPass);
		
		email = new JLabel("Email:* ");
		email.setBounds(240, 260, 100, 30);
		email.setFont(new Font("Calibri",Font.BOLD,16));
		email.setForeground(Color.decode("#000000"));
		email.setIcon(EmailImage);
		frame.add(email);
		
		
		tfUName = new JTextField();
		tfUName.setBounds(400, 140, 140, 23);
		tfUName.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
		tfUName.setToolTipText("Enter your name here");
		frame.add(tfUName);
		
		
		pfUPass = new JPasswordField();
		pfUPass.setBounds(400, 180, 140, 23);
		pfUPass.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
		pfUPass.setEchoChar('*');
		pfUPass.setToolTipText("Enter your password here");
		frame.add(pfUPass);
		
		
		cpfUPass = new JPasswordField();
		cpfUPass.setBounds(400, 220, 140, 23);
		cpfUPass.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
		cpfUPass.setEchoChar('*');
		cpfUPass.setToolTipText("Re-write your password here");
		frame.add(cpfUPass);
		
		
	    tfemail = new JTextField();
		tfemail.setBounds(400, 260, 140, 23);
		tfemail.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
		tfemail.setToolTipText("Your Email Adress?");
		frame.add(tfemail);
		
		
		previous0 = new JButton ("Back");
		previous0.setBounds(420, 380, 80, 30);
		previous0.setFocusable(false);
		previous0.setBackground(Color.LIGHT_GRAY);
		previous0.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		previous0.addActionListener(this);
		previous0.setCursor(new Cursor(Cursor.HAND_CURSOR));
		previous0.setIcon(previousImage);
		frame.add(previous0);
		
		
		signUpButton1 = new JButton("Submit");
		signUpButton1.setBounds(300, 380, 80, 30);
		signUpButton1.setFocusable(false);
		signUpButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		signUpButton1.setBackground(Color.LIGHT_GRAY);
		signUpButton1.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		signUpButton1.setIcon(signupImage);
		signUpButton1.addActionListener(this);
		frame.add(signUpButton1);
		
		
		exitButton = new JButton("Exit");
		exitButton.setBounds(360, 440, 80, 30);
		exitButton.setFocusable(false);
		exitButton.setBackground(Color.LIGHT_GRAY);
		exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		exitButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		exitButton.setIcon(exitImage);
		exitButton.addActionListener(this);
		frame.add(exitButton);
		
		//frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 550);
		frame.setIconImage(framelogo.getImage());
		frame.setResizable(false);
		frame.setLayout (null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	/*public static void main(String[] args)
	{
		new SignUp();
	}*/
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource()==previous0)
		{
			new Login();
			frame.setVisible(false);
		}
		
		else if(e.getSource()==exitButton)
		{
			int a = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Exit Confirmation", 0);
			if(a==0)
			{
				System.exit(0);
			}
		}
		
		else if(e.getSource()==signUpButton1)
		{
			String username = tfUName.getText();
			String pass = pfUPass.getText();
			String confirmPass = cpfUPass.getText();
			String sEmail = tfemail.getText();
			
			if (username.isEmpty()==false && pass.isEmpty()==false && sEmail.isEmpty()==false && sEmail.isEmpty()==false)
			{
				if (confirmPass.equals(pass)) 
				{
					try {
                    	File file = new File("data\\.user_data.txt");
                    	if (!file.exists())
						{
                        	file.createNewFile();
                    	}
                    	FileWriter fw = new FileWriter(file, true);
                    	BufferedWriter bw = new BufferedWriter(fw);
                    	PrintWriter pw = new PrintWriter(bw);

                    	LocalDateTime myDateObj = LocalDateTime.now();
                    	DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm a, dd/MM/yyyy");

                    	String timeAndDate = myDateObj.format(myFormatObj);

                    	pw.println("User Name : " + username);
                    	pw.println("Password : " + pass);
                    	pw.println("Email : " + sEmail);
                    	pw.println("Time & Date : " + timeAndDate);
                    	pw.println("==================================================");
                    	pw.println("==~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~==");
                    	pw.println("==================================================");
                    	pw.close();
                    	
                    	JOptionPane.showMessageDialog(null, "New User Created Successfully!", "User created",JOptionPane.INFORMATION_MESSAGE);
						//frame.setVisible(false);
						//new Login();
                    	tfUName.setText(null);
                    	pfUPass.setText(null);
                    	cpfUPass.setText(null);
                    	tfemail.setText(null);
					}
					
					catch (Exception ex)
					{
						System.out.print(ex);
						JOptionPane.showMessageDialog(null,"Something Went Wrong.");
					}
				}
				else 
				{
					JOptionPane.showMessageDialog(null,"Password didn't match.");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Please enter valid information in all fields.");
			}
			
		}
		
	}
	
}
