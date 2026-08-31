import java.io.*;
import java.util.*;

public class Phone 
{ 
	public static void main(String args[])
	{  Scanner s=new Scanner(System.in);
	   int n=s.nextInt();
	   String str=s.next();
	   int c=0;
	   while(true)
	   {
	   	if(11 <=n )
	   	 { if(str.contains("8"))
	   		{
	   			str=str.replaceFirst("8","");
	   			n=n-11;
	   			c++;
	   		}
	   		else
	   			break;
	   	}
	   		
	   	else
	   		break;
	   }
	   System.out.println(c);
	}
}