package lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
	private static JTextField textField;
	private static int temp, num1, num2;
	private static String sign;
	private static String lastBtnPressed = "action";
	private static boolean dividingByZero = false;
	private static boolean solved = true;

	public static void createAndShowGUI() {

		// tworzymy action listener
		ActionListener myActionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pressedBtnLabel = e.getActionCommand();

				System.out.println("Button = " + pressedBtnLabel);

				switch (pressedBtnLabel) {
					case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" -> numberBtnPressed(pressedBtnLabel);
					case "+", "-", "*", "/" -> signBtnPressed(pressedBtnLabel);
					case "=" -> equalsBtnPressed();
					case "C" -> clean();
					default -> System.out.println("Unknown button");
				}
			}
		};

		JFrame jf = new JFrame("Calculator");
		JPanel jp = new JPanel();

		// generowanie przycisków funkcyjnych
		JButton equalsBtn, addBtn, subtractBtn, multiBtn, divisionBtn, clearBtn;
		equalsBtn   = new JButton("=");
		addBtn      = new JButton("+");
		subtractBtn = new JButton("-");
		multiBtn    = new JButton("*");
		divisionBtn = new JButton("/");
		clearBtn    = new JButton("C");

		// dodawanie action listenerow do kazdego przycisku
		equalsBtn.addActionListener(myActionListener);
		addBtn.addActionListener(myActionListener);
		subtractBtn.addActionListener(myActionListener);
		multiBtn.addActionListener(myActionListener);
		divisionBtn.addActionListener(myActionListener);
		clearBtn.addActionListener(myActionListener);

		// generowanie przycisków z cyframi
		JButton[] numBtns = new JButton[10]; // lista z przyciskami numerycznymi
		for(int i = 0; i < numBtns.length; i++) {
			numBtns[i] = new JButton(String.valueOf(i)); // etykieta przycisku
			numBtns[i].addActionListener(myActionListener);
			numBtns[i].setFocusable(false);
		}

		// wrzucenie wszystkiego w pane
		jp.setBounds(5,50,300,200);
		jp.setLayout(new GridLayout(5,4,10,5));
		jp.add(addBtn);      jp.add(numBtns[1]); jp.add(numBtns[2]); jp.add(numBtns[3]);
		jp.add(subtractBtn); jp.add(numBtns[4]); jp.add(numBtns[5]); jp.add(numBtns[6]);
		jp.add(multiBtn);    jp.add(numBtns[7]); jp.add(numBtns[8]); jp.add(numBtns[9]);
		jp.add(equalsBtn);   jp.add(divisionBtn); jp.add(clearBtn); jp.add(numBtns[0]);

		// ustawienia text field
		textField = new JTextField();
		textField.setBounds(5, 5, 300, 30);
		textField.setFont(new Font("Arial", Font.BOLD,16));
		textField.setHorizontalAlignment(JTextField.RIGHT);
		textField.setEditable(false);
		textField.setText("0");

		// ustawienia okna
		jf.setResizable(false);
		jf.setLayout(null);
		jf.setSize(326, 255);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// dodanie wszystkiego do okna
		jf.add(textField);
		jf.add(jp);
		jf.setVisible(true);
	}

	public static void numberBtnPressed(String pressed) {
		if (dividingByZero) {
			return;
		}

		if (lastBtnPressed.equals("action") || textField.getText().startsWith("0")) {
			textField.setText("");
		}

		if (lastBtnPressed.equals("equal")) {
			textField.setText("");
			sign = null;
		}

		// dodajemy wcisniety numer do pola tekstowego
		textField.setText(textField.getText().concat(pressed));

		// ustawiamy ostatni wcisniety przycisk na numerek
		lastBtnPressed = "number";
	}

	private static void signBtnPressed(String pressedBtn) {
		if (dividingByZero) {
			return;
		}

		if (lastBtnPressed.equals("action")) {
			sign = pressedBtn;
			solved = false;
			return;
		}

		if (!solved) {
			equalsBtnPressed();
			solved = true;
		}

		num2 = Integer.parseInt(textField.getText());
		sign = pressedBtn;
		solved = false;
		lastBtnPressed = "action";
	}

	private static void equalsBtnPressed() {
		if (dividingByZero) {
			return;
		}

		if (sign == null) {
			solved = true;
			lastBtnPressed = "action";

			// jesli pole tekstowe jest puste
			if (!textField.getText().isEmpty()) {
				// ustawiamy numer2 na wartosc z pola testowego
				num2 = Integer.parseInt(textField.getText());
			}

			return;
		}

		if (lastBtnPressed.equals("equal")) {
			num2 = temp;
		} else if (lastBtnPressed.equals("action")) {
//			temp = num1;
			num1 = Integer.parseInt(textField.getText());
		}

		System.out.println("LBP = " + lastBtnPressed);
		System.out.println("temp = " + temp);

		int result = 0;
		switch (sign) {
			case "+" -> result = num2 + num1;
			case "-" -> result = num2 - num1;
			case "*" -> result = num2 * num1;
			case "/" -> {
				if (num1 == 0) {
					clean();
					textField.setText("ERROR: DIVISION BY ZERO");
					dividingByZero = true;
					return;
				}
				result = num2 / num1;
			}
		}
		textField.setText(String.valueOf(result));
		lastBtnPressed = "equal";
		solved = true;
	}

	public static void clean() {
		textField.setText("0");
		num1 = 0;
		num2 = 0;

		sign = null;
		lastBtnPressed = "action";
		dividingByZero = false;
	}

	public static void main(String[] args) { javax.swing.SwingUtilities.invokeLater(Calculator::createAndShowGUI); }
}
