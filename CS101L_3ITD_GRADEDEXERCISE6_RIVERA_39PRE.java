import java.util.*;  
import java.io.*;

public class CS101L_3ITD_GRADEDEXERCISE6_RIVERA_39PRE
{  
	public static void main(String[] args)
       {  
			String input; 
			while(true)
			{
				System.out.println("Enter the prefix expression");  
				input = getString();  
				if(input.equals(""))  
					break;
				Evaluation e = new Evaluation();  
				System.out.println("Reversed: "+ input); 
				System.out.println("Result: "+ e.calculate(input));  
		    }
       }  
       public static String getString()
       {  
         Scanner b = new Scanner(System.in);  
         String s = b.nextLine();  
		 String rev = new StringBuffer(s).reverse().toString();
         return rev; 
       }  
}
class Evaluation
{  
    public int calculate(String s)  
	{  
		int n,r=0;  
        n = s.length();  
        Stack a = new Stack(n);  
        for(int i = 0; i < n; i++)  
        {  
          char ch = s.charAt(i);  
          if(ch >='0'&& ch <= '9')  
            a.push((ch-'0'));  
          else
		  {  
            int x = a.pop();  
            int y = a.pop();  
            switch(ch)  
			{  
				case '+':
				  r = x + y;  
                  break;  
               case '-':
			      r = x - y;  
                  break;  
               case '*':
			      r = x * y;  
                  break;  
               case '/':
			      r = x / y;  
                  break;  
               default:
			      r = 0;  
            }  
			a.push(r);  
		  }  
		}  
        r = a.pop();  
        return(r);  
    } 
}
class Stack 
{
	private int top;
	private int[] stack;
     
	Stack(int capacity) 
	{
		stack = new int[capacity];
		top = -1;
	}
     
	public void push(int value) 
	{
		top++;
		stack[top] = value;
    }
	
	public int peek() 
	{
        return stack[top];
    }
	
    public int pop() 
	{
		return stack[top--];
    }
}	