import java.util.HashSet;
import java.util.Scanner;

public class Bulbs {

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		int n=scan.nextInt();
		int m=scan.nextInt();
		HashSet h1=new HashSet();
		for(int i=0;i<m;i++)
		{
			h1.add(i+1);
		}
		HashSet h2=new HashSet();
		while(n-->0)
		{
			int p=scan.nextInt();
			int[] a=new int[p];
			for(int i=0;i<p;i++)
			{
				a[i]=scan.nextInt();
				h2.add(a[i]);
			}
			
		}
		if(h2.containsAll(h1)) System.out.println("Yes");
		else System.out.println("NO");
		
		
	}

}
