import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class A615Bulbs {
      public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int m=s.nextInt();
		String str="";
		int t=0,l=0;
        ArrayList<Integer> lh1=new ArrayList<Integer>();
		int[] a2=new int[m];
		for(int i=1;i<=m;i++)
		{
			lh1.add(i);
		
		}
		
	     ArrayList<Integer> lh2=new ArrayList<Integer>();
		
		
		while(n-->0)
		{
			int k=s.nextInt();
			while(k-->0)
			{
				lh2.add(s.nextInt());
			}
		    
			
			
		}
		if(lh2.containsAll(lh1))
		{
		 System.out.println("YES");
		}
		else
		{
			System.out.println("NO");
		}
	}
}
