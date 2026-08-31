import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.ArrayList; 
import java.util.List;
import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
public class HelloWorld {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int t;
		t=scanner.nextInt();
		//t=1;
		while(t-->0)
		{
			int l=scanner.nextInt();
			int z=scanner.nextInt();
			Set<Integer> a  = new HashSet<Integer>(); 
			Set<Integer> b  = new HashSet<Integer>();
			for(int i=0;i<l;i++)
			{
				int x=scanner.nextInt();
				a.add(x);
			}
			for(int i=0;i<z;i++)
			{
				int x=scanner.nextInt();
				b.add(x);
			}
			a.retainAll(b);
			if(a.size()!=0)
			{
				System.out.println("YES");
				System.out.println(1+" "+a.iterator().next());
			}
			else
			{
				System.out.println("NO");
			}
			
			
		}
		

	}

}
