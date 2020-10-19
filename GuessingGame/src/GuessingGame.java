import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class GuessingGame extends JFrame {
	private JTextField txtInput; // text field for the user's guess
	private JLabel lblDirections2Result; // label for too high/too low output
	private int theNumber; //the number we're trying to guess
	private int numberOfPlayerGuesses = 1;
	
	public void checkGuess() { // method/function to check too high or too low
		//get the user's guess
		String guessText = txtInput.getText();
		String message = "";
		
		try {
			// check the guess for too high/too low
			int guess = Integer.parseInt(guessText);
			//too high
			if (guess > theNumber) {
				message = guess + " was too high. Try again.";
				lblDirections2Result.setText(message);
				numberOfPlayerGuesses += 1;
			} else if (guess < theNumber) {
				message = guess + " was too low. Try again.";
				lblDirections2Result.setText(message);
				numberOfPlayerGuesses += 1;
			} else {
				message = guess + " was right! You used " + numberOfPlayerGuesses + " guesses. Let's play again!";
				lblDirections2Result.setText(message);
				newGame();
			}
		}
		catch(Exception e) {
			lblDirections2Result.setText("Enter a whole number between 1 and 100.");
		}
		
		txtInput.requestFocus();
		txtInput.selectAll();
		
		
	}
	public void newGame() {//create a new random number 1...100
		theNumber = (int)(Math.random()* 100 + 1);
		
	}
	
	public GuessingGame() {
		getContentPane().setBackground(new Color(204, 153, 255));
		getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Victor's Hi Lo Guessing Game");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitle.setBounds(12, 13, 318, 25);
		getContentPane().add(lblTitle);
		
		JButton btnGuess = new JButton("Guess");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkGuess();
			}
		});
		btnGuess.setBounds(105, 102, 97, 25);
		getContentPane().add(btnGuess);
		
		lblDirections2Result = new JLabel("Enter a number above and click Guess");
		lblDirections2Result.setVerticalAlignment(SwingConstants.TOP);
		lblDirections2Result.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDirections2Result.setBounds(12, 155, 494, 66);
		getContentPane().add(lblDirections2Result);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 153, 255));
		panel.setBounds(12, 58, 429, 31);
		getContentPane().add(panel);
		
		JLabel lblDirections = new JLabel("Guess a number between 1 and 100:");
		lblDirections.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblDirections);
		
		txtInput = new JTextField();
		txtInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkGuess();
			}
		});
		panel.add(txtInput);
		txtInput.setColumns(10);
	}
	public static void main(String[] args) {
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(430, 330));
		theGame.setVisible(true);
		
	}
}
