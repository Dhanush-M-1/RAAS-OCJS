import java.util.*;
import java.math.*;
import java.io.*;

public class B{
	static class FastReader { 
	    BufferedReader br; 
	    StringTokenizer st; 

	    public FastReader(){ 
	        br = new BufferedReader(new
	                 InputStreamReader(System.in)); 
	    } 

	    String next(){ 
	        while (st == null || !st.hasMoreElements()){ 
	            try{ 
	                st = new StringTokenizer(br.readLine()); 
	            }catch (IOException  e){ 
	                e.printStackTrace(); 
	            } 
	        } 
	        return st.nextToken(); 
	    } 

	    int nextInt(){ 
	        return Integer.parseInt(next()); 
	    } 

	    long nextLong(){ 
	        return Long.parseLong(next()); 
	    } 

	    double nextDouble(){ 
	        return Double.parseDouble(next()); 
	    } 

	    String nextLine(){ 
	        String str = ""; 
	        try{ 
	            str = br.readLine(); 
	        }catch (IOException e){ 
	            e.printStackTrace(); 
	        } 
	        return str; 
	    } 
	}

	public static void main(String[] args){
		FastReader in = new FastReader(); 
		int t = in.nextInt();
		for(int q = 0; q < t; q++){
			int n = in.nextInt();
			char[][] ch = new char[n][n];
			for(int i = 0; i < n; i++){
				String s = in.next();
				ch[i] = s.toCharArray();
			}

			char a = ch[0][1];
			char b = ch[1][0];
			char c = ch[n - 1][n - 2];
			char d = ch[n - 2][n - 1];


			if(a == b && a == c && a == d){
				System.out.println("2");
				System.out.println("1 2\n2 1");
			}else if(a == b && a == c){
				System.out.println("1");
				System.out.println((n)+ " " + (n - 1));
			}else if(a == b && a == d){
				System.out.println("1");
				System.out.println((n - 1)+ " " + (n));
			}else if(a == b && c == d){
				System.out.println("0");
			}else if(c == d && c == b){
				System.out.println("1");
				System.out.println("2 1");
			}else if(c == d && c == a){
				System.out.println("1");
				System.out.println("1 2");
			}else if(a == c){
				System.out.println("2");
				System.out.println("2 1");
				System.out.println((n) + " " + (n - 1));
			}else if(a == d){
				System.out.println("2");
				System.out.println("2 1");
				System.out.println((n - 1) + " " + (n));
			}
		}
	}

}


