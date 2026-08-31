import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
public class B {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out,true);
		String s=sc.nextLine();
		String [] sa=s.split(" ");
		int n=Integer.parseInt(sa[sa.length-1]);
		int po=1,ne=0;
		for(int i=2;i<sa.length-1;i+=2){
			if(sa[i-1].charAt(0)=='+')
				po++;
			else
				ne++;
		}
		boolean ok=false;
		for(int i=po;i<=po*n;i++){
			int j=i-n;
			if(j>=ne && j<=ne*n){
				ok=true;
				pw.println("Possible");
				int rpo=po==0? 0 :i%po;
				int rne=ne==0? 0 :j%ne;
				for(int k=0;k<sa.length-1;k+=2){
					if(k==0 || sa[k-1].charAt(0)=='+'){
						if(rpo>0){
							sa[k]=""+(i/po+1);
							rpo--;
						}else
							sa[k]=""+i/po;
							
					}else{
						if(rne>0){
							sa[k]=""+(j/ne+1);
							rne--;
						}else
							sa[k]=""+j/ne;
					}
				}
				
				for(int k=0;k<sa.length;k++)
					if(k<sa.length-1)
						pw.print(sa[k]+" ");
					else
						pw.println(sa[k]);
				
				break;
			}
		}
		if(!ok)
			pw.println("Impossible");
		
		pw.flush();
		pw.close();
	}
	
	static class MyScanner {
	      BufferedReader br;
	      StringTokenizer st;
	 
	      public MyScanner() {
	         br = new BufferedReader(new InputStreamReader(System.in));
	      }
	 
	      String next() {
	          while (st == null || !st.hasMoreElements()) {
	              try {
	                  st = new StringTokenizer(br.readLine());
	              } catch (IOException e) {
	                  e.printStackTrace();
	              }
	          }
	          return st.nextToken();
	      }
	 
	      int nextInt() {
	          return Integer.parseInt(next());
	      }
	 
	      long nextLong() {
	          return Long.parseLong(next());
	      }
	 
	      double nextDouble() {
	          return Double.parseDouble(next());
	      }
	 
	      String nextLine(){
	          String str = "";
		  try {
		     str = br.readLine();
		  } catch (IOException e) {
		     e.printStackTrace();
		  }
		  return str;
	      }

	   }
}
