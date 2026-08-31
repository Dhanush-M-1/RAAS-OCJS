import java.util.*;
public class Main 
{
	public static void main(String[]args)
	{
		Scanner in=new Scanner(System.in);
		int n,i,j,k;
		String s;
		int c=1;
		n=in.nextInt();
		s=in.next();
		for(i=0;i<n-1;i++)
		{
			j=(int)s.charAt(i);
			k=(int)s.charAt(i+1);
			if(j<=k)
				c=1;
			else
			{
				c=0;
				System.out.println("YES");
				System.out.println((i+1)+" "+(i+2));
				break;
			}
		}
		if(c==1)
			System.out.println("NO");
	}

}
	  			 	 					 	  		 										