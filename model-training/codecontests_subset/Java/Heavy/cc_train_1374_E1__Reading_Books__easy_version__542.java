import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
public class Main {
	public static void main(String[] args) {
		FastScanner sc=new FastScanner();
		PrintWriter out=new PrintWriter(System.out);
		
		    int n = sc.nextInt();
		    int k = sc.nextInt();
		    //String str = sc.nextInt();
    		int []arr = new int[n];
    		List<Integer> a1 = new ArrayList<>();
    		List<Integer> b1 = new ArrayList<>();
    		List<Integer> common = new ArrayList<>();
    		for(int i=0;i<n;i++){
    		    arr[i] = sc.nextInt();
    		    int a = sc.nextInt();
    		    int b = sc.nextInt();
    		    if(a==1 && b==0) a1.add(arr[i]);
    		    else if(b==1 && a==0) b1.add(arr[i]);
    		    else if(a==1 && b==1) common.add(arr[i]);
    		}
    		
    		Collections.sort(a1);
    		Collections.sort(b1);
    		for(int i=0; i<Math.min(a1.size(), b1.size()); i++)
    		{
    		    common.add(a1.get(i) + b1.get(i));
    		}
    		Collections.sort(common);
    		long ans=0;
    		if(common.size() < k){
    		    System.out.println(-1);
    		}
    		else{
    		    for(int i=0;i<k;i++)
    		       ans += common.get(i);
    		    System.out.println(ans);      
    		}
		    
		out.close();
	}
	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;
 
		public FastScanner() {
			try	{
				br = new BufferedReader(new InputStreamReader(System.in));
				st = new StringTokenizer(br.readLine());
			} catch (Exception e){e.printStackTrace();}
		}
 
		public String next() {
			if (st.hasMoreTokens())	return st.nextToken();
			try {st = new StringTokenizer(br.readLine());}
			catch (Exception e) {e.printStackTrace();}
			return st.nextToken();
		}
 
		public int nextInt() {return Integer.parseInt(next());}
 
		public long nextLong() {return Long.parseLong(next());}
 
		public double nextDouble() {return Double.parseDouble(next());}
 
		public String nextLine() {
			String line = "";
			if(st.hasMoreTokens()) line = st.nextToken();
			else try {return br.readLine();}catch(IOException e){e.printStackTrace();}
			while(st.hasMoreTokens()) line += " "+st.nextToken();
			return line;
		}
	}
}


















