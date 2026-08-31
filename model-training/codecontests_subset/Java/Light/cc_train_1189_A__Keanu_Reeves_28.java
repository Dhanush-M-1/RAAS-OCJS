
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class codeforces {
	
	public static boolean good(String s)
	{
		int i=0;
		int zero=0;
		int one=0;
		for(i=0;i<s.length();i++)
		{
			if(s.charAt(i)=='0')
				zero++;
			if(s.charAt(i)=='1')
				one++;
				
		}
		if(one!=zero)
			return true;
		
		else
			return false;
		
	}
	
	

    public static void main(String[] args)  
    {  
       Scanner in = new Scanner(System.in);
       int n= in.nextInt();
       String s= in.next();
    
       List<String> lt = new ArrayList<String>();
       int i=0;
       int j=0;
       int len=s.length();
       
       if(good(s))
       {
    	   System.out.println(1);
    	   System.out.println(s);
    	   System.exit(0);
       }
       
       for(i=0;i<s.length();i++)
       {
    	   String temp = s.substring(0,i+1);
    	   if(good(temp))
    	   {
    		   System.out.println(2);
    		   System.out.print(temp+" ");
    		   System.out.print(s.substring(i+1,s.length()));
    		   System.exit(0);
    	   }
       }
       
       
    }  
		
}

	


	




	 
