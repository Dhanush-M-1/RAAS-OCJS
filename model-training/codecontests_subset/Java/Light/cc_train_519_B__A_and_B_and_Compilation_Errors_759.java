import java.util.*;
public class Compilation {

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
	
   long A=0;long B=0;long C=0;
     
		for(int i=0;i<n;i++)
		{
			long no=sc.nextLong();
			A+=no;
		}
		
		for(int i=0;i<n-1;i++)
		{
			long no=sc.nextLong();
			B+=no;
		}
		for(int i=0;i<n-2;i++)
		{
			long no=sc.nextLong();
			C+=no;
		}
		System.out.println(A-B);
		System.out.println(B-C);
       
	    	
		
		
	}

	
	}


