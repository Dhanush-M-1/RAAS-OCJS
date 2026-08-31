import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Vector;

import javax.print.attribute.standard.PrinterMessageFromOperator;

public class Main
{
    public static void main(String[] args) throws IOException 
    {
    	StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));		
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		while (in.nextToken() != StreamTokenizer.TT_EOF) 
		{
	        long num = (long)in.nval;
	        for(long num1 = (long)Math.sqrt(num) ; num1 >= 1; num1--)
	        {
	        	if(num % num1 == 0)
	        	{
	        		long num3 = num1;
	        		long num4 = num / num3;
	        		for(;num3 != 0;)
	        		{
	        			long temp = num3;
	        			num3 = num4 % num3;
	        			num4 = temp;
	        		}
    				if(num4 == 1)
    				{
    					out.println(num1 + " " + num / num1);
    					out.flush();
    					break;
    				}
	        	}
	        }
		}
    }
}
