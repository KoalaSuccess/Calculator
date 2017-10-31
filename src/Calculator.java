import java.util.*;

/**
 * Program: Calculator.java
 * Purpose: Creates a calculator class. A GUI class will be used to instantiate 
 * the calculator and buttons themselves
 * Coder  : Kenton Dang, 0798640
 * Date   : Mar 30, 2017
 */

public class Calculator {

	//Instance fields
	String operand;
	String operator;
	boolean decimalPressed;
	ArrayList<String> list;
	
	
	public Calculator() {
		this.operand = "";
		this.operator = "";
		this.decimalPressed = false;
		list = new ArrayList<String>();
	}
	
	public String getOperand() {
		return operand;
	}//end of getOperand

	public String getOperator() {
		return operator;
	}//end of getOperator
	
	public void setOperand(String operand) {
		this.operand = operand;
	}//end of setOperand

	public void setOperator(String operator) {
		this.operator = operator;
	}//end of setOperator

	public boolean isDecimalPressed() {
		return decimalPressed;
	}//end of isDecimal

	public void setDecimalPressed(boolean decimalPressed) {
		this.decimalPressed = decimalPressed;
	}//end of setDecimal
	
	// Clear everything, empty arraylist, empty current operand and operator
	public void clear(){
		this.operand = "";
		this.operator = "";
		this.decimalPressed = false;
		list.clear();
	}//end of clear

	//remove last entry from current operand
	public String backspace(String value) throws EmptyOperandException{
		if (value.isEmpty() || value.equals("0") || value.equals("0.0"))
		{
			EmptyOperandException e = new EmptyOperandException();
			throw e;
		}
		else 
		{
			String temp = value.substring(0, value.length()-1);
			return temp;			
		}
	}//end of backspace
	
	//convert current operand to a percentage
	public String findPercentage (String value) throws EmptyOperandException{
		
		if (Double.parseDouble(value) == 0 || Double.parseDouble(value) == 0.0 || value.isEmpty())
		{
			EmptyOperandException e = new EmptyOperandException();
			throw e;
		}
		else
		{
			double temp = Integer.parseInt(value);
			double percent = temp * 0.01;
			String output = Double.toString(percent);
			return output;
		}
		
	}//end of findPercentage

	//set number to pos or negative
	public String togglePlusMinus(boolean flag) throws EmptyOperandException{
		String temp = "";
		if (flag == false)
			temp = "-" + this.operand;
		else
			temp = this.operand.substring(1, this.operand.length());
		
		return temp;
	}//end of togglePlus
	
	//square the current number
	public String findSquared(String value) throws EmptyOperandException{
		
		if (Double.parseDouble(value) == 0 || value.isEmpty())
		{
			EmptyOperandException e = new EmptyOperandException();
			throw e;
		}
		else {
			double temp = Double.parseDouble(value);
			temp *= temp;
			String output = Double.toString(temp);
			return output;			
		}
		

	}//end of findSquared
	
	//squareroot the current number
	public String findSquareRoot(String value) throws EmptyOperandException{
		
		if (Double.parseDouble(value) == 0 || Double.parseDouble(value) == 0.0 || value.isEmpty())
		{
			throw new EmptyOperandException();
		}
		else
		{
			double square = Double.parseDouble(value);
			double temp = Math.sqrt(square);
			return Double.toString(temp);	
		}
		
	}//end of findSquare
	
	//Set current operand to this operand
	public void buildOperand(String value) throws LongOperandException{
		
		if (value.length() > 22)
			throw new LongOperandException(value);
		else
			this.operand += value;
		
	}//end of buildOperand
	
	//add operand and operator to list
	public void buildExpression(String value) throws EmptyOperandException, ArithmeticException{
		this.operator = value;
		
		if (value.isEmpty()){
			throw new EmptyOperandException();
		}
		else if (value.equals("/") && this.operand.equals(0))
		{
			throw new ArithmeticException();
		}
		else
		{
			list.add(this.operand);
			list.add(this.operator);
			this.operand = "";
			this.operator = "";
		}
			
	}//end of buildExpression
	
	//add operand to list, perform BEDMAS, good stuff happens
	public double calculate() throws EmptyOperandException{
		list.add(this.operand);
		Double temp = 0.0;
		
		do {
			for (int i = 0; i < list.size(); i++)
			{
				if (list.get(i) == "/")
				{
					temp = Double.parseDouble(list.get(i-1)) / Double.parseDouble(list.get(i+1));
					list.add(i-1, Double.toString(temp));
					list.remove(i);
					list.remove(i);
					list.remove(i);
				}
				else if (list.get(i) == "*")
				{
					temp = Double.parseDouble(list.get(i-1)) * Double.parseDouble(list.get(i+1));
					list.add(i-1, Double.toString(temp));
					list.remove(i);
					list.remove(i);
					list.remove(i);
				}
			}

			for (int i = 0; i < list.size(); i++)
			{
				if (list.get(i) == "+")
				{
					temp = Double.parseDouble(list.get(i-1)) + Double.parseDouble(list.get(i+1));
					list.add(i-1,Double.toString(temp));
					list.remove(i);
					list.remove(i);
					list.remove(i);
				}
				else if (list.get(i) == "-")
				{
					temp = Double.parseDouble(list.get(i-1)) - Double.parseDouble(list.get(i+1));
					list.add(i-1, Double.toString(temp));
					list.remove(i);
					list.remove(i);
					list.remove(i);
				}
			}
		} while (list.size() > 1);
		
		return temp;
	}//end of calculate
	
	//convert to hex or oct
	public String convertHex(String value){
		
		int temp = Integer.parseInt(value);
		return Integer.toHexString(temp);
		
	}//end of convertHex
	
	public String convertOct(String value){
		
		int temp = Integer.parseInt(value);
		return Integer.toOctalString(temp);
		
	}//end of convertOct
	
	public String convertBin(String value){
		return value;
	}//end of convertBin
	
	public String toString(){
		return "hey";
	}//end of toString
}
