

import java.util.Scanner;

public class AAAA {

		public static void main(String args[])
		{
			Scanner scan=new Scanner(System.in);
			int n=scan.nextInt();
			for(int i=0;i<n;i++)
			{
				int l=scan.nextInt();
				int r=scan.nextInt();
				int d=scan.nextInt();
				
				if(d==l || d>r || (d>=l && d<=r))
				{
					
					int gg=r/d;
					System.out.println(d*(gg+1));
					
				}else if(d<l){
				//searching form the left
					System.out.println(d);
				}
				
				
			}
		}
}
