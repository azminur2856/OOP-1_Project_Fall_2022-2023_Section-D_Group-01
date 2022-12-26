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

public class ForgotPassword2 implements ActionListener, IForgotPassword2
{
    private JFrame frame;
    private JLabel phone;
    private JTextField phoneField;
    private JLabel hintphn;
    private JButton next2;
    private JButton exitButton;
    private JButton backButton;
    private Container c;
    private ImageIcon forgotUser;
    private Cursor cursor;
    protected static boolean loginFlag;

    int totalLines;

    public ForgotPassword2()
	{
        frame = new JFrame();
        frame.setBounds(50, 50, 850, 550);
        frame.setTitle("Reset Password");
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

        JLabel forget = new JLabel("Verify User");
        forget.setBounds(365, 0, 200, 50);
        Font forgetFont = new Font("Times New Roman", Font.PLAIN, 22);
        forget.setFont(forgetFont);
        forget.setForeground(Color.white);
        frame.add(forget);

        forgotUser = new ImageIcon("icons/forgot_user2.png");
        JLabel imgLabel = new JLabel(forgotUser);
        imgLabel.setBounds(0, 115, forgotUser.getIconWidth(), forgotUser.getIconHeight());
        frame.add(imgLabel);

        phone = new JLabel("Email ID :");
        phone.setBounds(385, 230, 180, 50);
        Font phoneFont = new Font("Verdana", Font.PLAIN, 18);
        phone.setFont(phoneFont);
        phone.setForeground(Color.white);
        phone.setVisible(true);
        frame.add(phone);

        phoneField = new JTextField();
        phoneField.setBounds(510, 242, 180, 30);
        Font phoneFieldFont = new Font("Times New Roman", Font.BOLD, 18);
        phoneField.setFont(phoneFieldFont);
        phoneField.setOpaque(false);
        phoneField.setForeground(new Color(219, 226, 233));
        phoneField.setBorder(BorderFactory.createEmptyBorder());
        Border redBorder1 = BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(179, 63, 64));
        phoneField.setBorder(redBorder1);
        phoneField.setVisible(true);
        frame.add(phoneField);

        ImageIcon fnext = new ImageIcon("icons/fnext.png");
        next2 = new JButton(fnext);
        next2.setBounds(652, 278, 45, 45);
        next2.setBackground(new Color(0, 0, 0, 0));
        next2.setOpaque(false);
        next2.setBorder(BorderFactory.createEmptyBorder());
        next2.setCursor(cursor);
        next2.setVisible(true);
        frame.add(next2);

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

        try
		{
            File userfile = new File(".\\data\\.user_data.txt");
            int k = ((ForgotPassword.deleteLine) + 2);
            String line1 = Files.readAllLines(Paths.get(".\\data\\.user_data.txt")).get(k);
            String line2 = "";
            // for (int j = 16; j < line1.length(); j++) {
            line2 = line2 + line1.charAt(8);
            line2 = line2 + line1.charAt(9);
            line2 = line2 + line1.charAt(10);
            // }

            hintphn = new JLabel("Hint : " + line2+"***@***.com");
            hintphn.setBounds(510, 210, 200, 30);
            hintphn.setForeground(new Color(245, 242, 208, 150));
            Font hintphnFont = new Font("Verdana", Font.BOLD, 14);
            hintphn.setFont(hintphnFont);
            hintphn.setVisible(true);
            frame.add(hintphn);

        } 
		
		catch (Exception e)
		{
            System.out.println(e);
        }

        next2.addActionListener(this);
        backButton.addActionListener(this);
        exitButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
	{

        String user = "Email : " + phoneField.getText();
        String user1 = phoneField.getText();
        boolean userEmpty = user1.isEmpty();
        boolean yes = false;
        boolean yes2 = false;
        if (e.getSource() == next2)
		{

            try 
			{
                File userfile = new File(".\\data\\.user_data.txt");

                if (userEmpty == true)
				{

                    showMessageDialog(null, "Enter Email Address", "Error", JOptionPane.WARNING_MESSAGE);

                } 
				
				else if (userEmpty == false) 
				{

                    int n = ((ForgotPassword.deleteLine) + 2);
                    BufferedReader readFile = new BufferedReader(new FileReader(".\\data\\.user_data.txt"));
                    String line = Files.readAllLines(Paths.get(".\\data\\.user_data.txt")).get(n);
                    if (line.equals(user)) 
					{
                        yes = true;

                    } 
					
					else
					{
                        yes = false;
                    }

                    if (yes == false)
					{
                        showMessageDialog(null, "Email not found!", "Error", JOptionPane.WARNING_MESSAGE);
                    }

					else 
					{
                        frame.setVisible(false);
                        new ForgotPassword3();
                    }
                    readFile.close();

                }

            } 
			
			catch (Exception ex) 
			{
                showMessageDialog(null, "Email not found!", "Error", JOptionPane.WARNING_MESSAGE);

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
            new ForgotPassword();
			frame.setVisible(false);
        }
    }
}
