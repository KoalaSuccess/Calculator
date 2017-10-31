/**
 * Program: GUICalculator
 * Purpose: GUI for the calculator class. Complete with custom buttons and whatnot
 * Coder  : Kenton Dang, 0798640
 * Date   : April 3, 2017
 */

// Imports
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.*;

public class GUICalculator extends JFrame {

	//Declare everything
	private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnAdd, btnMin, btnDiv, btnMul, btnEquals, btnDot;
	private JButton btnBackspace, btnClear, btnNeg, btnSq, btnSqrt, btnPercent, btnEmpty1, btnEmpty2;
	private static JTextArea display;
	private JPanel bottomPanel;
	private Font myFont;
	private static Calculator calc;
	private final String START = "0";
	private JEditorPane display2;
	private boolean decimalPressed = false;
	private boolean percentPressed = false;
	private boolean negPressed = false;
	private JPanel errorPanel = new JPanel();
	private JMenu menuBar;
	
	
	public GUICalculator () {

		//Call super for panel
		super("Calculator");
		calc = new Calculator();

		//Create font, set display stuff
		myFont = new Font(Font.SANS_SERIF, Font.PLAIN, 22);
		display = new JTextArea();
		display.setEditable(false);
		display.setBackground(Color.WHITE);
		display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		display.setText(START);
		display.setFont(new Font("Consolas", Font.PLAIN, 22));

		buildBottomPanel();
		
		add(display, BorderLayout.NORTH);
		add(bottomPanel, BorderLayout.CENTER);

		//Set size of calculator, non resizable
		setSize(300, 365);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		display.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 1)));

		
	}//end of guicalculator

	//Method that builds all of the buttons
	private void buildBottomPanel() {

		bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(6,4));
		
		//Declare empty buttons for sake of spacing
		btnEmpty1 = new JButton(" ");
		btnEmpty1.setBackground(Color.WHITE);
		btnEmpty2 = new JButton(" ");
		btnEmpty2.setBackground(Color.WHITE);
		
		//		Number Buttons		//
		//instantiate all the number buttons, font, background etc
		btn1 = new JButton("1");
		btn1.setBackground(Color.WHITE);
		btn1.setFont(myFont);
		btn2 = new JButton("2");
		btn2.setBackground(Color.WHITE);
		btn2.setFont(myFont);
		btn3 = new JButton("3");
		btn3.setBackground(Color.WHITE);
		btn3.setFont(myFont);
		btn4 = new JButton("4");
		btn4.setBackground(Color.WHITE);
		btn4.setFont(myFont);
		btn5 = new JButton("5");
		btn5.setBackground(Color.WHITE);
		btn5.setFont(myFont);
		btn6 = new JButton("6");
		btn6.setBackground(Color.WHITE);
		btn6.setFont(myFont);
		btn7 = new JButton("7");
		btn7.setBackground(Color.WHITE);
		btn7.setFont(myFont);
		btn8 = new JButton("8");
		btn8.setBackground(Color.WHITE);
		btn8.setFont(myFont);
		btn9 = new JButton("9");
		btn9.setBackground(Color.WHITE);
		btn9.setFont(myFont);
		btn0 = new JButton("0");
		btn0.setBackground(Color.WHITE);
		btn0.setFont(myFont);
		//		Number Buttons		//
		
		
		
		//		Operator Buttons	//
		// Instantiate all the operator buttons, set font
		btnDot = new JButton(".");
		btnDot.setBackground(Color.WHITE);
		btnDot.setFont(myFont);
		
		btnAdd = new JButton("+");
		btnAdd.setBackground(Color.WHITE);
		btnAdd.setFont(myFont);
		
		btnMin = new JButton("-");
		btnMin.setBackground(Color.WHITE);
		btnMin.setFont(myFont);
		
		btnDiv = new JButton("/");
		btnDiv.setBackground(Color.WHITE);
		btnDiv.setFont(myFont);
		
		btnMul = new JButton("x");
		btnMul.setBackground(Color.WHITE);
		btnMul.setFont(myFont);
		
		btnEquals = new JButton("=");
		btnEquals.setBackground(Color.WHITE);
		btnEquals.setFont(myFont);
		
		btnPercent = new JButton("%");
		btnPercent.setBackground(Color.WHITE);
		btnPercent.setFont(myFont);
		
		btnClear = new JButton("C");
		btnClear.setBackground(Color.WHITE);
		btnClear.setFont(myFont);
		
		btnNeg = new JButton("+/-");
		btnNeg.setBackground(Color.WHITE);
		btnNeg.setFont(myFont);
		
		btnSq = new JButton("x^2");
		btnSq.setBackground(Color.WHITE);
		btnSq.setFont(myFont);
		
		btnSqrt = new JButton("Sqrt");
		btnSqrt.setBackground(Color.WHITE);
		btnSqrt.setFont(myFont);
		
		btnBackspace = new JButton("DEL");
		btnBackspace.setBackground(Color.WHITE);
		btnBackspace.setFont(myFont);
		//		Operator Buttons		//
		
		
		//**************BUTTON ACTION LISTENERS*******************//
		
		//Action listeners for each number button
		btn0.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				if (display.getText().matches(START))
				{
					display.setText("");
					display.append(Integer.toString(0));
				}
				else
					display.append(Integer.toString(0));
			}

		}
		);

		btn1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {

				if (display.getText().matches(START))
				{
					display.setText("");
					display.append(Integer.toString(1));
				}
				else
					display.append(Integer.toString(1));

			}
		}
		);
		
		btn2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {

				if (display.getText().matches(START))
				{
					display.setText("");
					display.append(Integer.toString(2));
				}
				else
					display.append(Integer.toString(2));

			}
		}
		);
		
		btn3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {

				if (display.getText().matches(START))
				{
					display.setText("");
					display.append(Integer.toString(3));
				}
				else
					display.append(Integer.toString(3));

			}
		}
		);
		
		btn4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {

				if (display.getText().matches(START))
				{
					display.setText("");
					display.append(Integer.toString(4));
				}
				else
					display.append(Integer.toString(4));

			}
		}
		);
		
		btn5.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {

				if (display.getText().matches(START))
				{
					display.setText("");
					display.append(Integer.toString(5));
				}
				else
					display.append(Integer.toString(5));

			}
		}
		);
		
		btn6.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {

				if (display.getText().matches(START))
				{
					display.setText("");
					display.append(Integer.toString(6));
				}
				else
					display.append(Integer.toString(6));

			}
		}
		);
		
		btn7.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {

				if (display.getText().matches(START))
				{
					display.setText("");
					display.append(Integer.toString(7));
				}
				else
					display.append(Integer.toString(7));

			}
		}
		);
		
		btn8.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {

				if (display.getText().matches(START))
				{
					display.setText("");
					display.append(Integer.toString(8));
				}
				else
					display.append(Integer.toString(8));

			}
		}
		);
		
		btn9.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {

				if (display.getText().matches(START))
				{
					display.setText("");
					display.append(Integer.toString(9));
				}
				else
					display.append(Integer.toString(9));
			}
		}
		);
		
		btnClear.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				display.setText(START);
				decimalPressed = false;
				percentPressed = false;
				negPressed = false;
				calc.clear();
			}
		});
		
		
		//Action listeners for each operator button
		btnAdd.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				try {
					calc.buildOperand(display.getText());
					calc.buildExpression("+");
					display.setText("");
				} catch (LongOperandException | ArithmeticException | EmptyOperandException e) {
					e.printStackTrace();
				}
			}
		});
		
		btnMin.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				try {
					calc.buildOperand(display.getText());
					calc.buildExpression("-");
					display.setText("");
				} catch (LongOperandException | ArithmeticException | EmptyOperandException e) {
					JOptionPane.showMessageDialog(errorPanel, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		btnMul.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				try {
					calc.buildOperand(display.getText());
					calc.buildExpression("*");
					display.setText("");
				} catch (LongOperandException | ArithmeticException | EmptyOperandException e) {
					JOptionPane.showMessageDialog(errorPanel, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		btnDiv.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				try {
					calc.buildOperand(display.getText());
					calc.buildExpression("/");
					display.setText("");
				} catch (LongOperandException | ArithmeticException | EmptyOperandException e) {
					JOptionPane.showMessageDialog(errorPanel, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		btnDot.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				if (decimalPressed == false){
					String temp = "";
					temp = display.getText() + ".";
					display.setText(temp);
				}

				decimalPressed = true;
			}
		});

		btnPercent.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) {
				if (percentPressed == false){
					try {
						display.setText(calc.findPercentage(display.getText()));
					} catch (EmptyOperandException e) {
						JOptionPane.showMessageDialog(errorPanel, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}

				percentPressed = true;
			}
		});

		btnSq.addActionListener(new ActionListener ()
		{		
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					display.setText(calc.findSquared(display.getText()));
				} catch (EmptyOperandException e) {
					JOptionPane.showMessageDialog(errorPanel, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		});
		
		btnSqrt.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {

				try {
					display.setText(calc.findSquareRoot(display.getText()));
				} catch (EmptyOperandException e) {
					JOptionPane.showMessageDialog(errorPanel, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		btnNeg.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) {
				String temp = "";
				
				if (negPressed == false)
				{
					display.append("-");
					negPressed = true;
				}
				else 
				{
					temp = display.getText().substring(0, display.getText().length()-1);
					display.setText(temp);
					negPressed = false;
				}
			}
		});
		
		btnBackspace.addActionListener(new ActionListener()
				{
				public void actionPerformed(ActionEvent arg0) {
					try {
						display.setText(calc.backspace(display.getText()));
					} catch (EmptyOperandException e) {
						JOptionPane.showMessageDialog(errorPanel, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				});
		
		
		btnEquals.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) {
				try {
					calc.buildOperand(display.getText());
					display.setText(Double.toString(calc.calculate()));
					
					for (int i = 0; i < calc.list.size(); i++)
					{
						System.out.println(i + " i = " + calc.list.get(i));
					}
				} catch (LongOperandException e) {
					JOptionPane.showMessageDialog(errorPanel, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} catch (EmptyOperandException e) {
					JOptionPane.showMessageDialog(errorPanel, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		//**************** BUTTON ACTION LISTENERS ********************//
		
		//Add everything to bottompanel
		bottomPanel.add(btnClear);
		bottomPanel.add(btnBackspace);
		bottomPanel.add(btnPercent);
		bottomPanel.add(btnNeg);
		bottomPanel.add(btnSq);
		bottomPanel.add(btnSqrt);
		bottomPanel.add(btnEmpty1);
		bottomPanel.add(btnDiv);
		bottomPanel.add(btn7);
		bottomPanel.add(btn8);
		bottomPanel.add(btn9);
		bottomPanel.add(btnMul);
		bottomPanel.add(btn4);
		bottomPanel.add(btn5);
		bottomPanel.add(btn6);
		bottomPanel.add(btnMin);
		bottomPanel.add(btn1);
		bottomPanel.add(btn2);
		bottomPanel.add(btn3);
		bottomPanel.add(btnAdd);
		bottomPanel.add(btnEmpty2);
		bottomPanel.add(btn0);
		bottomPanel.add(btnDot);
		bottomPanel.add(btnEquals);

	}//end of buildBottomPanel

	private static void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		setLookAndFeel();
		
		JMenuItem convert, help, file, exit, howTo, about, convertToHex, convertToBin, convertToOct;
		
		JMenuBar menuBar = new JMenuBar();
		
		file = new JMenu("File");
		help = new JMenu("Help");
		convert = new JMenu("Convert");
		
		exit = new JMenuItem ("Exit");
		convertToBin = new JMenuItem("Convert to Binary");
		convertToOct = new JMenuItem("Convert to Octal");
		convertToHex = new JMenuItem("Convert to Hexadecimal");
		howTo = new JMenuItem("How to..");
		about = new JMenuItem("About...");
		
		/////************* ACTION LISTENERS **********////
		
		//Action listeners for menu items
		exit.addActionListener(new ActionListener () 
		{
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(null, "Closing. Use me again, I'm lonely.", "Peace out homeslice", JOptionPane.CLOSED_OPTION);
				System.exit(0);
			}
		});
		
		howTo.addActionListener(new ActionListener ()
		{
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(null, "Simple calculator.\n"
						+ "Click in number. Click desired operation. Click = button.\n"
						+ "Get an answer", "How to use a calculator" ,JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		about.addActionListener(new ActionListener () 
		{
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(null, "Made by Kenton Dang.\nApril 11, 2017"
						, "About...", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		convertToHex.addActionListener(new ActionListener ()
		{
			public void actionPerformed(ActionEvent e)
			{
				display.setText("0x" + calc.convertHex(display.getText()));
			}
		});
		
		convertToOct.addActionListener(new ActionListener ()
		{
			public void actionPerformed(ActionEvent e)
			{
				display.setText(calc.convertOct(display.getText()));
			}
		});
		
		//Add menuitems to menu
		menuBar.add(file);
		menuBar.add(convert);
		menuBar.add(help);
		file.add(exit);
		convert.add(convertToBin);
		convert.add(convertToOct);
		convert.add(convertToHex);
		help.add(howTo);
		help.add(about);
		
		//create calculator object
		GUICalculator calculator = new GUICalculator();
		calculator.setJMenuBar(menuBar);
		
	}
	
}