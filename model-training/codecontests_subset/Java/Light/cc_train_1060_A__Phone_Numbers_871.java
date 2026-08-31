import java.util.*;


import java.io.*;
public class A {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		char[] s = br.readLine().toCharArray();
		int c8=0;
	  for(char c:s){
	    if(c=='8')++c8;
	  }
	  bw.write(Math.min(c8, n/11)+"");
		bw.flush();
	}
}
