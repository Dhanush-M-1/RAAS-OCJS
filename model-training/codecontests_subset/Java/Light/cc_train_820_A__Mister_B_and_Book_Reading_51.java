import java.util.*;
import java.io.*;

 /*Please dont change class name, Dcoder 
 and class must not be public*/

 //Compiler version JDK 1.8


 public class Dcoder
 { 
 	static BufferedReader br;
 	static BufferedWriter bw;
 	
	public static void main(String args[]) throws IOException
 	{ 
       br = new BufferedReader(new InputStreamReader(System.in));
       bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
		run();
		
		bw.close();
		br.close();
 	}
 	
 	static void run() throws IOException{
 		int a[]= gia();
 		int c = a[0];
 		int v = a[1];
 		int w = a[2];
 		int ac = a[3];
 		int l = a[4];
 		
 		int d=0;
 		int p=0, x=0;
 		while (d <c) {
 			p = v+x*ac;
 			if (p>= w)
 				p=w;
 			
 			if (x >= 1)
 				p-=l;
 				
 			x++;
 			d+=p;
 		}
 		
 		bw.write(x+"\n");
 	}
 	
 	
 	static int gi(String s){
 		return Integer.parseInt(s);
 	}
 	
 	static int gi() throws IOException{
 		return Integer.parseInt(br.readLine());
 	}
 	
 	static int[] gia() throws IOException{
 		String[] str = br.readLine().split(" ");
 		int[] a = new int[str.length];
 		
 		for (int i=0; i<str.length; i++)
 			a[i] = gi(str[i]);
 		return a;
 	}
 }
    
    
    