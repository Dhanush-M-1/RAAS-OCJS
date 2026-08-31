import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class test{ 
	public static class MyScanner {
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
	      
	      void nextArrayInt(int[] array,int n){
	    	  
	    	  try {
				st = new StringTokenizer(br.readLine());
	    	  } catch (IOException e) { }
	    	  
	    	  for(int a=0;a<n;a++){
	    		  array[a] = Integer.parseInt((st.nextToken()));
	    	  }
	    	  
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
	
    public static void main(String[] args) { 
    	MyScanner sc = new MyScanner();
    	int n = sc.nextInt(),dlina = sc.nextInt();
    	int max = 10001;
    	int temp = 0;
    	for(int a=0;a<n;a++){
    		temp = sc.nextInt();
    		if(dlina%temp==0){
    			if(dlina/temp<max){
    				//System.out.println(dlina);
    				max = dlina/temp;
    				//System.out.println(dlina);
    			}
    		}
    	}
    	System.out.println(/*"answ="+*/max);
    }
    
}