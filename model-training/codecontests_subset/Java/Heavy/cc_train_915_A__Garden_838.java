import java.io.*;
import java.util.*;
public class GardenCF {
 public static void main(String[] args)throws IOException {
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      StringTokenizer stw = new StringTokenizer(br.readLine());
      int Q=1000;
      while(stw.hasMoreTokens()){
    	  int min=0 ;
    	  int z = Integer.parseInt(stw.nextToken());
    	  if(y%z==0){
    		   min=y/z;
    	  if(min<Q){
    		  Q=min;
    	  }
    	  }
      }
      System.out.println(Q);
	 
}
}
