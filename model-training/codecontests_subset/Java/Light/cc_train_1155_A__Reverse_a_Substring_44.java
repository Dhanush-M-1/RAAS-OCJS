

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class codeforces {
	
	
	public static void main(String args[]) 
	{
      
		Scanner in = new Scanner(System.in);
		int n= in.nextInt();
		String s = in.next();
		
		
		int i=0,j=0;
		boolean status = false;
		
		
		for(i=0;i<n-1;i++)
			
		{
			if(s.charAt(i)>s.charAt(i+1))
			{
				status=true;
				break;
			}
				
		}
		if(status==false){
			System.out.println("NO");
		}
		else
		{
			System.out.println("YES");
			System.out.println((i+1)+" "+(i+2));
		}
		
	}
	
}
