import java.util.Scanner;

public class test2 {
	static long divide(long num)
	{
		if(num<3)
			return -1;
		
		if(num%2==0)
			return 2;
		else
			for(long i=3;i<=(long)Math.sqrt(num);i+=2)
				if(num%i==0)
					return i;
		
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner sc=new  Scanner(System.in);
		long q=sc.nextLong();
		
		long div1=divide(q);
		if(div1==-1)
		{
			System.out.println(1);
			System.out.println(0);
		}
		else
		{
			long div2=q/div1;
			
			long div21=divide(div2);
			
			if(div21==-1)
			{
				System.out.println(2);
			}
			else
			{
				System.out.println(1);
				System.out.println(div1*div21);
			}
		}
		
		
	}
}

