
import java.util.*;

public class aaa {
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in); 
		while(input.hasNext())
		{
			int n,m;
			n=input.nextInt();
			m=input.nextInt();
			boolean [] F=new boolean[m];
			for(int i=0;i<n;i++)
			{
				int nb=input.nextInt();
				for(int j=0;j<nb;j++)
				{
					int k=input.nextInt();
					F[k-1]=true;
				}
			}
			int e;
			for(e=0;e<m;e++)
			{
				if(!F[e])
					break;
			}
			if(e==m)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
	
}