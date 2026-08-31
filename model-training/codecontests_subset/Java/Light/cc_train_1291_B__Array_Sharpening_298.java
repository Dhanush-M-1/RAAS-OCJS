import java.util.Scanner;


public class ArraySharpening {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		while(T-- > 0)
		{
			int n=sc.nextInt();
			int fb=0;
			int lb=n-1;
			for(int i=0;i<n;i++)
			{
				int a=sc.nextInt();
				if(a<i)
				{
					lb=Math.min(lb,i-1);
				}
				if(a<n-i-1)
				{
					fb=i+1;
				}
			}
			if(lb >= fb)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}

}
