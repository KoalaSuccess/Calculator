/**
 * Program: LongOperandException.java
 * Purpose: 
 * Coder  : Kenton Dang, 0798640
 * Date   : Apr 3, 2017
 */

public class LongOperandException extends Exception{

	private String operand;
	
	/**
	 * 
	 */
	public LongOperandException(String operand) {
		super ("Your operand is too long!");
		this.operand = operand;
	}
	
	public String getOperand()
	{
		return "hello";
	}

}
