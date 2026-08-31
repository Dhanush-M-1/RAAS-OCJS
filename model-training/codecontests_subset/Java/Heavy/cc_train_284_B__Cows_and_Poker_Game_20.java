import java.util.*;

public class cow_poker {

	public static void main(String args[])
	{
		long a=0, i=0, f=0;
		long n;
		long count=0;
		//char[] str;
		
		Scanner s = new Scanner(System.in);
		n = s.nextLong();
		String str = s.next();
		//n = s.nextLong();
		//String str = s.nextLine();
		for(int it=0;it<n;it++)
		{
			
			switch(str.charAt(it))
			{
				case 'A':
					a++;
					break;
				case 'F':
					f++;
					break;
				case 'I':
					i++;
					break;
				default: break;
			}
		}
		for(int it=0;it<n;it++)
		{
			switch(str.charAt(it))
			{
				case 'A':
					if(a+f-1==n-1)
						count++;
					break;
				case 'F':
					
					break;
				case 'I':
					if(a+f==n-1)
						count++;
					break;
			}
		}
		System.out.println(count);
	}
}
