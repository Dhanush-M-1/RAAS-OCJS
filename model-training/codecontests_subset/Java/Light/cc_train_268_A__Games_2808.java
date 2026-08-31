import java.util.*;
public class watermelon {
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		int sum=0;
		int n=Integer.parseInt(s.nextLine());
		String str="";
		int[][] a=new int[n][2];
		for(int i=0;i<n;i++)
		{
			str=s.nextLine();
			String st[]=str.split(" ");
			a[i][0]=Integer.parseInt(st[0]);
			a[i][1]=Integer.parseInt(st[1]);
		}
		for(int i=0;i<n;i++)
		{
			int x=a[i][0];
			for(int j=0;j<n;j++)
				if(x==a[j][1])
					++sum;
		}
		System.out.println(sum);
	}
}