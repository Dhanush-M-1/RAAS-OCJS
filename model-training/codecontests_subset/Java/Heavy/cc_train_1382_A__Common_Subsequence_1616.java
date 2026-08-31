import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Ideone
{
 static class FastReader { 
		BufferedReader br; 
		StringTokenizer st; 
 
		public FastReader() 
		{ 
			br = new BufferedReader(new
					InputStreamReader(System.in)); 
		} 
 
		String next() 
		{ 
			while (st == null || !st.hasMoreElements()) 
			{ 
				try
				{ 
					st = new StringTokenizer(br.readLine()); 
				} 
				catch (IOException  e) 
				{ 
					e.printStackTrace(); 
				} 
			} 
			return st.nextToken(); 
		} 
 
		int nextInt() 
		{ 
			return Integer.parseInt(next()); 
		} 
 
		long nextLong() 
		{ 
			return Long.parseLong(next()); 
		} 
 
		double nextDouble() 
		{ 
			return Double.parseDouble(next()); 
		} 
 
		String nextLine() 
		{ 
			String str = ""; 
			try
			{ 
				str = br.readLine(); 
			} 
			catch (IOException e) 
			{ 
				e.printStackTrace(); 
			} 
			return str; 
		} 
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
	 FastReader sc = new FastReader();
		int t=sc.nextInt();
  	while(t-->0){
		 int n=sc.nextInt();
		 int m=sc.nextInt();
		 ArrayList<Integer> al=new ArrayList<>();
		 for(int i=0;i<n;i++){
		   al.add(sc.nextInt());
		 }
		 ArrayList<Integer> al1=new ArrayList<>();
		 for(int i=0;i<m;i++){
		   al1.add(sc.nextInt());
		 }
		 int i=0;
		 for( i=0;i<m;i++){
		   int k=al1.get(i);
		   if(al.contains(k)){
		     System.out.println("YES");
		     System.out.println("1 "+k);
		     break;
		   }
		 }
		 if(i==m) System.out.println("NO");
		}
	}
}