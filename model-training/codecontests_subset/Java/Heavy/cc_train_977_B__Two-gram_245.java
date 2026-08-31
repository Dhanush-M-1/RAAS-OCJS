import java.io.*;
import java.util.*;

public class div_3_479_b {
	public static void main(String args[]){
		FScanner in = new FScanner();
		PrintWriter out = new PrintWriter(System.out);
		//int t = in.nextInt();
		//while(t-->0) { }
		HashMap<String,Integer> map=new HashMap<>();
		int n=in.nextInt();
		String s=in.next();
		for(int i=0;i<s.length()-1;i++)
			{String s1=s.substring(i,i+2);
            if(map.containsKey(s1))
            	map.put(s1,map.get(s1)+1);
            else
            	map.put(s1,1);
			}
			String s2="";int max=0;
			for(String i:map.keySet())
			{
				if(map.get(i)>max)
				{
					max=map.get(i);
					s2=i;
				}
			}
			out.println(s2);

		out.close();
	}

    static class FScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sb = new StringTokenizer("");
 
		String next(){
			while(!sb.hasMoreTokens()){
				try{
					sb = new StringTokenizer(br.readLine());
				} catch(IOException e){ }
			}
			return sb.nextToken();
		}
		String nextLine(){
			try{ return br.readLine(); } 
			catch(IOException e) { } return "";
		}
 
		int nextInt(){
			return Integer.parseInt(next());
		}
 
		long nextLong() {
			return Long.parseLong(next());
		}
 
		int[] readArray(int n) {
			int a[] = new int[n];
			for(int i=0;i<n;i++) a[i] = nextInt();
			return a;
		}
 
		float nextFloat(){
		return Float.parseFloat(next());
		}
		
		double nextDouble(){
		return Double.parseDouble(next());
		}
	}
}
	