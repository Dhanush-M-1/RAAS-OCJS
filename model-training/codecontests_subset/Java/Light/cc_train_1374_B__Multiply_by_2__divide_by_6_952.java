import java.util.*;

public class col
{
    public static void main(String[] args)
    {
       	Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
	    while(t-->0)
	    {
	        int n = sc.nextInt();
	        int c2 =0,c3 =0;
	        while(n%2 == 0)
	        {
	            n /=2;
	            c2++;
	        }
	        while(n%3 == 0)
	        {
	            n /=3;
	            c3++;
	        }
	        if(n==1 && c2 <= c3)
	        {
	           System.out.println((2*c3)- c2); 
	        }
	        else
	        {
	            System.out.println(-1);
	        }
	        
	    }

    }
}