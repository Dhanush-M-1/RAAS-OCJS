import java.util.Scanner;
/**
 * @(#)Q282c.java
 *
 *
 * @author 
 * @version 1.00 2014/12/17
 */

public class Q282c
{
	static String str;
	static int left;
	static int left2;
	static int last;
    public static void main( String[] args)
    {
        Scanner scan = new Scanner( System.in);
    	str = scan.next();
    	
    	for( int i = 0 ; i < str.length(); i++)
    	{
    		if(str.charAt(i) == '(')
    			left++;
    		else
    		{
    			left--;
    			if( str.charAt(i) == '#')
    				last = i;
    		}
    		if( left < 0)
    			break;
    	}
    	if( left < 0)
    		System.out.println( -1);
    	else
    	{
    		for( int i = 0 ; i < str.length() ; i++)
    		{
    			if( str.charAt(i) == '(')
    				left2++;
    			else if( i == last)
    			{
    				left2 += -left - 1;
    			}
    			else
    				left2--;
    			if( left2 < 0)
    				break;
    		}
    		if( left2 < 0)
    			System.out.println( -1);
    		else
    		{
    			for( int i = 0 ; i < last; i++)
    				if( str.charAt(i) == '#')
    					System.out.println( 1);
    			System.out.println( left + 1);
    		}
    	}
    }
}
