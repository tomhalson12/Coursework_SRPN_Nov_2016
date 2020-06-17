/*
*SRPN Calculator
*
*@version 1.3
*@release 20/11/2016
*@See Operations.java, InputChecking.java
*/
import java.util.Scanner;
import java.util.ArrayList;

public class SRPN
{
	
	public static void main(String args[])
	{
		
		Scanner input = new Scanner(System.in);
		Operations ops = new Operations();
		InputChecking InCheck = new InputChecking();
		String userInput = input.nextLine();
		
		while(true)
		{
			
			for(int i = 0;i != userInput.length(); i++)
			{
				
				InCheck.clearChars();
				InCheck.storeChars(userInput);
				
				if(!"#".equals(InCheck.currentChar(i)))//Misses all operations if #
				{
					
					// Peforms an operation if not an integer
					if(InCheck.isCharInt(i) == false && InCheck.isIntNegative(i, userInput) == false)
					{
						
						if("+".equals(InCheck.currentChar(i)))
						{
							ops.addition();
						}
						else if("-".equals(InCheck.currentChar(i)))
						{
							ops.subtraction();
						}
						else if("*".equals(InCheck.currentChar(i)))
						{
							ops.multiplication();
						}
						else if("/".equals(InCheck.currentChar(i)))
						{
							ops.division();
						}
						else if("%".equals(InCheck.currentChar(i)))
						{
							ops.modulus();
						}
						else if("^".equals(InCheck.currentChar(i)))
						{
							ops.power();
						}
						else if("=".equals(InCheck.currentChar(i)))
						{
							if(ops.checkEmpty() == true)
							{
								System.out.println("Stack empty.");
							}
							else
							{
								System.out.println(ops.result());
							}
						}
						else if("d".equals(InCheck.currentChar(i)))
						{
							ops.dInput();
						}
						else if("r".equals(InCheck.currentChar(i)))
						{
							ops.rInput();
						}
						else if(" ".equals(InCheck.currentChar(i)))
						{}
						else
						{
							System.out.println("Unrecognised operator or operand \"" + InCheck.currentChar(i) + "\".");
						}
						
					}
					else
					{
						
						if(InCheck.isNextIntChar(i, userInput) == false)//Deals with intget inputs
						{
							
							if("0".equals(InCheck.targetChar(0,1)))//Octal input
							{
								ops.octal(InCheck.numberToInput());
								InCheck.clearNumberInput();
							}
							else if("-".equals(InCheck.targetChar(0,1)) && "0".equals(InCheck.targetChar(1,2)))//Negative Octal
							{
								ops.octal(InCheck.numberToInput());
								InCheck.clearNumberInput();
							}
							else{
								ops.stackNum(Integer.valueOf(InCheck.numberToInput()));//Decimal Input
								InCheck.clearNumberInput();
							}
							
						}	
						
					}
					
				}
				
				else
				{
					i = userInput.length() - 1;
				}
				
			}
			
			InCheck.clearNumberInput();
			userInput = input.nextLine();
			
		}
	}
}