/**
*Completes neccessay checks on the users inputs.
*
*@version 1.3
*@release 20/11/2016
*/
import java.util.ArrayList;

public class InputChecking
{
	ArrayList<String> inputStore = new ArrayList<>();
	String numberInput = "";
	boolean check, nextCharInt;
	String orginalInput = "";

	public InputChecking()
	{
	}
	
	/**
	*Mutator. Stores input as invdivdual characters in an array
	*
	*@param userInput
	*	String the use has input.
	*/
	public void storeChars(String userInput)
	{
		orginalInput = userInput;
		for(int j = 0;j != userInput.length(); j++)
		{
			String nextChar = userInput.substring(j,j+1);
			inputStore.add(nextChar);	
		}	
	}
	
	/**
	*Method. Clears store of characters for a new set.
	*
	*/
	public void clearChars()
	{
		inputStore.clear();
	}
	
	/**
	*Accessor.
	*
	*@param i
	*	Current postion.
	*
	*@return
	*	Returns current char at positon i in string.
	*/
	public String currentChar(int i)
	{
		return inputStore.get(i);
	}
	
	/**
	*Accessor.
	*
	*@params i , j
	*	Target postions in string
	*
	*@return
	*	Returns character at particular positon in string.
	*/
	public String targetChar(int i, int j)
	{
		return numberInput.substring(i,j);
	}
	
	/**
	*Accessor.
	*
	*@return
	*	Returns the integer which will inputted.
	*/
	public String numberToInput()
	{
		return numberInput;
	}
	
	/**
	*Mutator. Clears the integer value.
	*
	*/
	public void clearNumberInput()
	{
		numberInput = "";
	}
	
	/**
	*Method. Checks if current charcter is an integer.
	*
	*@param i
	*	Current postion.
	*
	*@return
	*	Returns true if an integer
	*/
	public boolean isCharInt(int i)
	{
		try
		{
			int intCheck = Integer.valueOf(inputStore.get(i));//Tries to store integer value of character in the string.
			numberInput = numberInput + inputStore.get(i);
			return true;
		} 
		catch(NumberFormatException e)
		{
			return false;
		}	
	}
	
	/**
	*Method. Checks if next charcter is an integer if it isn't the last character.
	*
	*@param i
	*	Current postion.
	*
	*@return
	*	Returns true if an integer
	*/
	public boolean isNextIntChar(int i, String userInput)
	{
		if(i != userInput.length() - 1)
		{
			try
			{
				int nextCharCheck = Integer.valueOf(inputStore.get(i+1));//Tries to store integer value of character in the string
				return true;
			} 
			catch(NumberFormatException b)
			{
				return false;
			}
		}
		else
		{
			return false;
		}				
	}
	
	/**
	*Method. Checks is current "-" means subtract or if it means an
	* integer is negative. It is negative if current char is "-" and 
	* next char is an integer.
	*
	*@param i
	*	Current postion.
	*
	*@return
	*	Returns true if an integer is negative.
	*/
	public boolean isIntNegative(int i, String userInput)
	{
		if("-".equals(inputStore.get(i)) && isNextIntChar(i, userInput) == true)
		{
			numberInput = numberInput + inputStore.get(i);
			return true;
		}
		else
		{
			return false;
		}
	}

}