/**
*Defines how operands and operations are dealt.
*
*@version 1.3
*@release 20/11/2016
*/
import java.util.Stack;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Random;

public class Operations
{
	Stack<Integer> NumberStack = new Stack<>();
	ArrayList<Integer> operandStore = new ArrayList<>();
	int stackHeight = 0;
	
	public Operations()
	{
	}
	
	/**
	*Method. Stacks integers.
	*
	*@param num
	*	Integer to be stacked.
	*/
	public void stackNum(int num)
	{
		if(stackHeightCheck() == true)//Stack no higher than 23
		{
			System.out.println("Stack overflow.");
		}
		else
		{
			NumberStack.push(num);
			stackHeight++;
		}
	}
	
	/**
	*Method. Check status of stack.
	*
	*/
	public boolean checkEmpty()
	{
		return NumberStack.empty();
	}
	
	/**
	*Method. Clears the stack.
	*
	*/
	public void clearStack()
	{
		NumberStack.pop();
	}
	
	/**
	*Method. Checks stack height.
	*
	*Returns true if at max height.
	*/
	public boolean stackHeightCheck()
	{
		if(stackHeight == 23)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	*Mutator. Stores current operands so they can be
	* more easily mainpulated in operations.
	*/
	public void storeOperands()
	{
		int i = 0;
		while(i != 2)
		{
			int num1 = NumberStack.pop();
			operandStore.add(num1);		
			i++;	
		}
	}
	
	/**
	*Method. Checks if there are two operands
	* for an operation to be performed on.
	* 
	*Returns true if there isn't.
	*/
	public boolean checkStackUnderflow()
	{
		if(stackHeight < 2)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	*Method. Gives the correct value to overflowing integers.
	*
	*@param check
	*	Number being checked, defined in later mutators.
	*/
	public int minOrmax(long check)
	{
		if(check > 0)
		{
			return Integer.MAX_VALUE;
		}
		else
		{
			return Integer.MIN_VALUE;
		}
	}
	
	/**
	*Accessor. 
	*
	*@return
	*	returns the number at top of the stack.
	*/
	public int result()
	{
		return NumberStack.peek();
	}
	
	/**
	*Mutator. Adds the two integers at the top of the stack.
	*	Pushes the result back onto the stack.
	*/
	public void addition()
	{
		if(checkStackUnderflow() == true)
		{
			System.out.println("Stack underflow.");
		}
		else
		{
			storeOperands();
			long check = (long)operandStore.get(0) + (long)operandStore.get(1);
			if(check < Integer.MAX_VALUE && check > Integer.MIN_VALUE)//check for integer overflow
			{
				NumberStack.push(operandStore.get(0) + operandStore.get(1));
				operandStore.clear();
				stackHeight--;
			}
			else
			{
				NumberStack.push(minOrmax(check));
				operandStore.clear();
				stackHeight--;
			}
		}
	}
	
	/**
	*Mutator. Subtracts the top integer from the stack by the one below it.
	*	Pushes the result back onto the stack.
	*/
	public void subtraction()
	{
		if(checkStackUnderflow() == true)
		{
			System.out.println("Stack underflow.");
		}
		else
		{
			storeOperands();
			long check = -((long)operandStore.get(0) - (long)operandStore.get(1));
			if(check < Integer.MAX_VALUE && check > Integer.MIN_VALUE)//check for integer overflow
			{
				NumberStack.push(-(operandStore.get(0) - operandStore.get(1)));
				operandStore.clear();
				stackHeight--;
			}
			else
			{
				NumberStack.push(minOrmax(check));
				operandStore.clear();
				stackHeight--;
			}
		}
	}
	
	/**
	*Mutator. Multiplies the two integers at the top of the stack.
	*	Pushes the result back onto the stack.
	*/
	public void multiplication()
	{
		if(checkStackUnderflow() == true)
		{
			System.out.println("Stack underflow.");
		}
		else
		{
			storeOperands();
			long check = (long)operandStore.get(0) * (long)operandStore.get(1);
			if(check < Integer.MAX_VALUE && check > Integer.MIN_VALUE)//check for integer overflow
			{
				NumberStack.push(operandStore.get(0) * operandStore.get(1));
				operandStore.clear();
				stackHeight--;
			}
			else
			{
				NumberStack.push(minOrmax(check));
				operandStore.clear();
				stackHeight--;
			}
		}
	}
	
	/**
	*Mutator. Divides the top integer from the stack into the one below it.
	*	Pushes the result back onto the stack.
	*/
	public void division()
	{	
		if(checkStackUnderflow() == true)
		{
			System.out.println("Stack underflow.");
		}
		else
		{
			storeOperands();
			if(operandStore.get(0) == 0) //Divide by zero check
			{
				System.out.println("Divide by 0.");
				NumberStack.push(operandStore.get(1));
				NumberStack.push(operandStore.get(0));
				operandStore.clear();
			}
			else
			{
				long check = (long)operandStore.get(1) / (long)operandStore.get(0);
				if(check < Integer.MAX_VALUE && check > Integer.MIN_VALUE)//check for integer overflow
				{
					NumberStack.push(operandStore.get(1) / operandStore.get(0));
					operandStore.clear();
					stackHeight--;
				}
				else
				{
					NumberStack.push(minOrmax(check));
					operandStore.clear();
					stackHeight--;
				}
			}
		}
	}
	
	/**
	*Mutator. Divides the top integer from the stack into the one below it.
	*	Pushes the remainder of the result back onto the stack.
	*/
	public void modulus()
	{	
		if(checkStackUnderflow() == true)
		{
			System.out.println("Stack underflow.");
		}
		else
		{
			storeOperands();
			if(operandStore.get(0) == 0)//divide by zero check
			{
				System.out.println("Divide by 0.");
				NumberStack.push(operandStore.get(1));
				NumberStack.push(operandStore.get(0));
				operandStore.clear();
			}
			else
			{
				long check = (long)operandStore.get(1) % (long)operandStore.get(0);
				if(check < Integer.MAX_VALUE && check > Integer.MIN_VALUE)//check for integer overflow
				{
					NumberStack.push(operandStore.get(1) % operandStore.get(0));
					operandStore.clear();
					stackHeight--;
				}
				else
				{
					NumberStack.push(minOrmax(check));
					operandStore.clear();
					stackHeight--;
				}
			}
		}
	}
	
	/**
	*Mutator. Raises the second to top integer of the stack to the power of the top integer.
	*	Pushes the result back onto the stack.
	*/
	public void power()
	{	
		if(checkStackUnderflow() == true)
		{
			System.out.println("Stack underflow.");
		}
		else
		{
			storeOperands();
			if(operandStore.get(0) < 0)//check for negative power
			{
				System.out.println("Negative power.");
				NumberStack.push(operandStore.get(1));
				NumberStack.push(operandStore.get(0));
				operandStore.clear();
			}
			else
			{
				long check =  (long)Math.pow(operandStore.get(1) , operandStore.get(0));
				if(check < Integer.MAX_VALUE && check > Integer.MIN_VALUE)//check for integer overflow
				{
					NumberStack.push((int)Math.pow(operandStore.get(1) , operandStore.get(0)));
					operandStore.clear();
					stackHeight--;
				}
				else
				{
					NumberStack.push(minOrmax(check));
					operandStore.clear();
					stackHeight--;
				}
			}
		}
	}
	
	/**
	*Method. Prints the contents of the stack in order bottom to top.
	*	
	*Stack stored first so that it can be printed in correct order.
	*/
	public void dInput()
	{
		ArrayList<Integer> storeNum = new ArrayList<>();
		int i = 0;
		while(i != stackHeight)
		{
			int num1 = NumberStack.pop();
			storeNum.add(num1);		
			i++;	
		}
		i = (stackHeight - 1);
		
		while(i >= 0)
		{
			System.out.println(storeNum.get(i));
			NumberStack.push(storeNum.get(i));
			i--;
		}
	}
	
	/**
	*Mutator. Generates a random integer between min and max value.
	*	Pushes the result back onto the stack.
	* srpn.lcpu generates the same numbers every run time. 
	* This can be achieved by placing a seed in Random(seed)
	*/
	public void rInput()
	{
		Random rand = new Random();
		long randNum = rand.nextLong();
		NumberStack.push((int)randNum);
		stackHeight++;
	}
	
	/*
	*Mutator. Manipulates the inputted integer into an octal number.
	*	Pushes the result back onto the stack.
	*
	*@param numberInput
	*	Integer being converted.
	*/
	public void octal(String numberInput)
	{
		int power = (numberInput.length() - 2);
		int numOfLoops = (numberInput.length() - 1);
		boolean negative = false;
		int result = 0;
		String newInput = numberInput;
		
		/**
		*check if number contains digits 8 or 9 as not octal digits.
		*If found number being converted is only up to the point where an 
		*8 or 9 is found.
		*/
		for(int position = 0; position != numOfLoops + 1; position++)
		{
			if(Integer.valueOf(numberInput.substring(position,position+1)) == 8 || Integer.valueOf(numberInput.substring(position,position+1)) == 9)
			{
				newInput = numberInput.substring(0,position);
				power = (newInput.length() - 2);
				numOfLoops = (newInput.length() - 1);
				position = numOfLoops;
			}
		}
		
		//conversion of number to octal
		if(numOfLoops == 0)
		{
			stackNum(0);
		}
		else
		{
			for(int position = 0; position != numOfLoops; position++)
			{
				if("-".equals(newInput.substring(position,position+1)))
				{
					negative = true;
					power = power - 1;
				}
				else
				{
					double octalConvert = Math.pow(8, power);
					int decimalValue = (int)octalConvert * Integer.valueOf(newInput.substring(position+1,position+2));
					result = result + decimalValue;
					power = power - 1;
				}
			
				if(position == numOfLoops - 1)
				{
					if(negative == true)
					{
						stackNum(result * (-1));
					}	
					else
					{
						stackNum(result);
					}
				}
			}
		}
	}
}