import java.util.*;
public class ch1{
	public static void main(String[]args)throws Exception
	{
		int n;
		Scanner reader=new Scanner(System.in);
		n=reader.nextInt();
		char[]a=new char[n];
		int i;
		String str=reader.next();
		boolean flag=false;
		for(i=0;i<n-1;++i)
		{
			if(str.charAt(i)>str.charAt(i+1))
			{
				flag=true;
				break;
			}
		}
		++i;
		if(flag)
			System.out.println("YES\n"+i+" "+(i+1));
		else
			System.out.println("NO");
			
	}
}
 			    					 	  	 	    	  	