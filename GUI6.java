package GUI2;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI6 implements ActionListener {
	private static JButton ebutton;
	private static JButton debutton;
	private static JTextField inputText1;
	private static JTextField inputText2;
	private static JLabel outputLabel;

	public static void main(String args[]) {
		JFrame frame = new JFrame();
		frame.setSize(2100, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Caesar Cipher");

		JPanel panel = new JPanel();
		panel.setLayout(null);
		Color s1 = new Color(0, 0, 0);
		panel.setBackground(s1);

		JLabel imgLabel = new JLabel(new ImageIcon("D:\\PROJECT JAVA\\J1.jpg"));
		imgLabel.setBounds(390, 10, 728, 410);
		panel.add(imgLabel);

		JLabel piclabel = new JLabel("CAESAR CIPHER");
		Color s2 = new Color(255, 250, 250);
		piclabel.setForeground(s2);
		piclabel.setBounds(350, 440, 1000, 100);
		piclabel.setFont(new Font("Times New Roman", Font.BOLD, 100));
		panel.add(piclabel);

		ebutton = new JButton("ENCRYPT");
		ebutton.setBounds(500, 680, 190, 50);
		ebutton.setBackground(s2);
		ebutton.setForeground(s1);
		ebutton.addActionListener(new GUI6());
		ebutton.setFont(new Font("Times New Roman", Font.BOLD, 30));
		ebutton.setVisible(true);
		panel.add(ebutton);

		debutton = new JButton("DECRYPT");
		debutton.setBounds(800, 680, 190, 50);
		debutton.setBackground(s2);
		debutton.setForeground(s1);
		debutton.addActionListener(new GUI6());
		debutton.setFont(new Font("Times New Roman", Font.BOLD, 30));
		debutton.setVisible(true);
		panel.add(debutton);

		JLabel inputLabel = new JLabel("Enter text:");
		inputLabel.setBounds(350, 520, 1000, 100);
		inputLabel.setForeground(s2);
		inputLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panel.add(inputLabel);

		JLabel keyLabel = new JLabel("Enter the key:");
		keyLabel.setBounds(350, 580, 1000, 100);
		keyLabel.setForeground(s2);
		keyLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panel.add(keyLabel);

		inputText1 = new JTextField();
		inputText1.setBounds(600, 555, 500, 30);
		inputText1.setBackground(s2);
		panel.add(inputText1);

		inputText2 = new JTextField();
		inputText2.setBounds(600, 615, 500, 30);
		inputText2.setBackground(s2);
		panel.add(inputText2);

		outputLabel = new JLabel();
		outputLabel.setBounds(600, 700, 1000, 100);
		outputLabel.setForeground(s2);
		outputLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panel.add(outputLabel);

		frame.add(panel);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == ebutton) {
			String input = inputText1.getText();
			String key1 = inputText2.getText();
			int key = Integer.parseInt(key1);
			int length = input.length();
			String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			String lowercase = "abcdefghijklmnopqrstuvwxyz";
			String special = "!#$%&'()*+,-./:;<=>?@[]^_`{|}~";
			String numbers = "0123456789";
			System.out.print("The encrypted Text is: ");
			for (int i = 0; i < length; i++) 
			{
				for (int j = 0; j < 26; j++) 
				{
					if (j < special.length() && input.charAt(i) == special.charAt(j)) 
					{
						System.out.print(special.charAt(j)); // print special characters as it is

					} 
					else if (j < numbers.length() && input.charAt(i) == numbers.charAt(j))
					{
						System.out.print(numbers.charAt(j)); // print numbers as it is
					} 
					else if (input.charAt(i) == lowercase.charAt(j)) 
					{
						System.out.print(lowercase.charAt((j + key) % 26));
					} 
					else if (input.charAt(i) == uppercase.charAt(j))
					{
						System.out.print(uppercase.charAt((j + key) % 26));
					}
				}
			}
			System.out.println();

		} else if (e.getSource() == debutton) {

			String input = inputText1.getText();
			String key1 = inputText2.getText();
			int key = Integer.parseInt(key1);
			key = (-1)*key;
			int length = input.length();
			String upper_letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			String lower_letters = "abcdefghijklmnopqrstuvwxyz";
			String special_char = "!#$%&'()*+,-./:;<=>?@[]^_`{|}~";
			String numbers = "0123456789";
			System.out.print("Your new Text is: ");
			for (int i = 0; i < length; i++) 
			{
				for (int j = 0; j < 26; j++) 
				{
					if (j < special_char.length() && input.charAt(i) == special_char.charAt(j))
					{
						System.out.print(special_char.charAt(j)); // printing the special characters as it is
					} 
					else if (j < numbers.length() && input.charAt(i) == numbers.charAt(j)) 
					{
						System.out.print(numbers.charAt(j)); // printing the numbers as it is
					} 
					else if (input.charAt(i) == lower_letters.charAt(j))
					{
						System.out.print(lower_letters.charAt((j + key) % 26));
					} 
					else if (input.charAt(i) == upper_letters.charAt(j)) 
					{
						System.out.print(upper_letters.charAt((j + key) % 26));
					}
				}
				
			}
			System.out.println();
		}
	}

}
