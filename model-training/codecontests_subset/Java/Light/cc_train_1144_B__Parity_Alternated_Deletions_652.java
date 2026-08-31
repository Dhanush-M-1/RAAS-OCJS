import java.io.*;
import java.util.*;
public class Main
	{
		public static void main(String args[])
			{
				Scanner sc=new Scanner(System.in);
				int n=sc.nextInt();
				int a[]=new int[n];
				for(int i=0;i<n;i++)
					a[i]=sc.nextInt();
				ArrayList<Integer> e=new ArrayList<>();
				ArrayList<Integer> o=new ArrayList<>();
				for(int i=0;i<n;i++)
					if(a[i]%2==0)
						e.add(a[i]);
					else
						o.add(a[i]);
				int ee=e.size();
				int oo=o.size();
				if(ee==oo|| oo-ee==-1 || oo-ee==1)
					System.out.println(0);
				else
					{
						Collections.sort(e,Collections.reverseOrder());
						Collections.sort(o,Collections.reverseOrder());
						int s=0;
						if(ee>oo)
							{
								for(int i=oo+1;i<ee;i++)
									s=s+e.get(i);
							}
						else
							{
								for(int i=ee+1;i<oo;i++)
									s=s+o.get(i);
							}
						System.out.println(s);
					}				
			}
	}	
