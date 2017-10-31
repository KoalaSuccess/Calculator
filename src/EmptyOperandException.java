/**
 * Program: EmptyOperandException.java
 * Purpose: 
 * Coder  : Kenton Dang, 0798640
 * Date   : Apr 3, 2017
 */

public class EmptyOperandException extends Exception{
	
	public EmptyOperandException() {
		super ("Your operand is empty.\nThis operation cannot be performed.");
	}

}
