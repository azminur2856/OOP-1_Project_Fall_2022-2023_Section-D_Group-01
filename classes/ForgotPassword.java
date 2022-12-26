package classes;
import java.lang.*;
import interfaces.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.io.*;
import java.nio.file.*;
import classes.*;


public class ForgotPassword implements ActionListener, IForgotPassword
{
    private JFrame frame;
    private JLabel username;
    private JTextField userField;
    private JButton next;
    private JButton exitButton;
    private JButton backButton;
    private Container c;
    private ImageIcon forgotUser;
    private Cursor cursor;
    protected static boolean loginFlag;
    protected static int deleteLine;

    public ForgotPassword()
	{
		
        frame = new JFrame();
        frame.setBounds(50, 50, 850, 550);
        frame.setTitle("Find User");
		frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
        c = frame.getContentPane();
        c.setBackground(Color.decode("#000000"));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("icons/framelogo.jpg");
        frame.setIconImage(icon.getImage());
        frame.setLocationRelativeTo(null);

        cursor = new Cursor(Cursor.HAND_CURSOR);

        forgotUser = new ImageIcon("icons/forgot_user.png");
        JLabel imgLabel = new JLabel(forgotUser);
        imgLabel.setBounds(0, 100, forgotUser.getIconWidth(), forgotUser.getIconHeight());
        frame.add(imgLabel);

        JLabel forget = new JLabel("Search User");
        forget.setBounds(365, 0, 200, 50);
        Font forgetFont = new Font("Times New Roman", Font.PLAIN, 22);
        forget.setFont(forgetFont);
        forget.setForeground(Color.white);
        frame.add(forget);

        username = new JLabel("User Name :");
        username.setBounds(385, 230, 180, 50);
        Font usernameFont = new Font("Verdana", Font.PLAIN, 18);
        username.setVisible(true);
        username.setFont(usernameFont);
        username.setForeground(Color.white);
        frame.add(username);

		
        userField = new JTextField();
        userField.setBounds(510, 242, 180, 30);
        Font userfieldFont = new Font("Times New Roman", Font.BOLD, 18);
        userField.setFont(userfieldFont);
        userField.setVisible(true);
        userField.setOpaque(false);
        userField.setForeground(new Color(219, 226, 233));
        userField.setBorder(BorderFactory.createEmptyBorder());
        Border redBorder = BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(179, 63, 64));
        userField.setBorder(redBorder);
        frame.add(userField);

        ImageIcon fnext = new ImageIcon("icons/fnext.png");
        next = new JButton(fnext);
        next.setBounds(652, 278, 45, 45);
        next.setBackground(new Color(0, 0, 0, 0));
        next.setOpaque(false);
        next.setBorder(BorderFactory.createEmptyBorder());
		next.setCursor(cursor);
        next.setVisible(true);
        frame.add(next);

        ImageIcon exit = new ImageIcon("icons/exiticon1.png");
        exitButton = new JButton(exit);
        exitButton.setBounds(770, 450, exit.getIconWidth(), exit.getIconHeight());
        exitButton.setBackground(Color.black);
        exitButton.setOpaque(false);
        exitButton.setBorder(BorderFactory.createEmptyBorder());
		exitButton.setCursor(cursor);
        frame.add(exitButton);

        ImageIcon backimg = new ImageIcon("icons/backicon2.png");
        backButton = new JButton(backimg);
        backButton.setBounds(15, 450, backimg.getIconWidth(), backimg.getIconHeight());
        backButton.setBackground(Color.black);
        backButton.setOpaque(false);
        backButton.setBorder(BorderFactory.createEmptyBorder());
		backButton.setCursor(cursor);
        frame.add(backButton);

        next.addActionListener(this);
        backButton.addActionListener(this);
        exitButton.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) 
	{
        String user = "User Name : " + userField.getText();
        String user1 = userField.getText();
        boolean userEmpty = user1.isEmpty();
        boolean yes = false;
        int totalLines = 0;

        if (e.getSource() == next)
		{
            try
			{
                File userfile = new File(".\\data\\.user_data.txt");
                if (userfile.exists()) {
                    BufferedReader readFile = new BufferedReader(new FileReader(".\\data\\.user_data.txt"));

                    while (readFile.readLine() != null)
					{
                        totalLines++;
                    }
                    readFile.close();
                }

                if (userEmpty == true)
				{
                    showMessageDialog(null, "Enter User Name", "Error", JOptionPane.WARNING_MESSAGE);
                    yes = false;
                }
				
				else
				{

                    for (int i = 0; i < totalLines; i++)
					{

                        String line = Files.readAllLines(Paths.get(".\\data\\.user_data.txt")).get(i);
                        if (line.equals(user))
						{
                            deleteLine = i;
                            yes = true;
                            break;

                        }
                    }
                    if (yes == true)
					{
                        frame.setVisible(false);
                        new ForgotPassword2();
                    }
					else
					{
                        showMessageDialog(null, "Username not found", "Error", JOptionPane.WARNING_MESSAGE);
                    }

                }

            } 
			
			catch (Exception ex)
			{

                showMessageDialog(null, "Username not found", "Error", JOptionPane.WARNING_MESSAGE);

            }

        } 
		
		else if (e.getSource() == exitButton)
		{
            int yesORno = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);

            if (yesORno == 0)
			{
                System.exit(1);
            }
        }
		
		
		else if (e.getSource() == backButton)
		{
            new Login();
			frame.setVisible(false);
        }
    }
}