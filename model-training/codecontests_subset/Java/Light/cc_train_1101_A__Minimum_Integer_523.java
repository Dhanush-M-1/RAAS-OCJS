import java.util.Scanner;
public class ayhbl 
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int l,r,d;
		loop :for(int i=0;i<n;i++)
		{
			l=in.nextInt();
			r=in.nextInt();
			d=in.nextInt();
			if(d<l||d>r)
				System.out.println(d);
			else
			{
				int x=(r/d+1)*d;
				System.out.println(x);
			}
				
		}
	}

}
