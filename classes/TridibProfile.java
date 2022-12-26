package classes;
import java.lang.*;
import interfaces.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TridibProfile implements ActionListener, ITridibProfile
{
	
	private JButton previous0;
	private JLabel picture;
	private JFrame frame;
	
	private String f;
	public TridibProfile(String user)
	{
		f=user;
		
		frame = new JFrame("TRIDIB SARKAR");
		
		ImageIcon framelogo = new ImageIcon("icons/framelogo.jpg");
		ImageIcon tridib = new ImageIcon("icons/TridibProfile.png");
		ImageIcon previousImage = new ImageIcon("icons/previous.png");
		
		
		previous0 = new JButton ("Back");
		previous0.setFont(new Font("Calibri Light (Headings)", Font.BOLD, 15));
		previous0.setBounds(30, 15, 100, 30);
		previous0.setFocusable(false);
		previous0.setBackground(Color.LIGHT_GRAY);
		previous0.setCursor(new Cursor(Cursor.HAND_CURSOR));
		previous0.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		previous0.addActionListener(this);
		previous0.setIcon(previousImage);
		frame.add(previous0);
		
		
		picture = new JLabel(tridib);
		picture.setBounds(30, 15, 580, 630);
		frame.add(picture);
		
		
		frame.setIconImage(framelogo.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650,700);
		frame.getContentPane().setBackground(Color.white);
		frame.setLayout (null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	public static void main(String[] args)
	{
		new AzminurProfile("Tridib");
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource()==previous0)
		{
			new Home(f);
			frame.setVisible(false);
		}
		
	}

}
