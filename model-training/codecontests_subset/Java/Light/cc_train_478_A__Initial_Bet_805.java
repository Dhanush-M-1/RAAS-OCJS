import java.util.*;
import java.lang.*;
 
public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);double sum=0;byte c;byte i;
		for( i=0;i<5;++i){
			c=sc.nextByte();
			if(c>=0)
				sum+=c;
			else
				break;
		}
           double n = sum/5;
           if(sum<=0 || i!=5)
        	   System.out.println(-1);
           else
        	   System.out.println(n==(int)n?(int)n:-1);
	}
}