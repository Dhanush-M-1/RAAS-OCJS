import java.util.*;
import java.io.*;
public class a615
{
		public static void main(String ar[])throws IOException
		{
				Scanner ob=new Scanner(System.in);
				int n=ob.nextInt();
				int m=ob.nextInt();
				boolean arr[]=new boolean[m];
				for(int i=0;i<n;i++)
				{
						int x=ob.nextInt();
						for(int j=0;j<x;j++)
						{
								int y=ob.nextInt();
								if(arr[y-1]==false) arr[y-1]=true;
						}
				}
				for(int i=0;i<m;i++)
				{
						if(arr[i]==false)
						{
							
								System.out.println("NO");
						//		System.out.println(i);
								System.exit(0);
						}
				}
				System.out.println("YES");
		}
}
