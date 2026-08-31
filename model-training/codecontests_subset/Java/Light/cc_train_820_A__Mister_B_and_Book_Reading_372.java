import java.io.*;
import java.util.*;

public class SDS {
    public static void main(String[] args) throws Exception{      
      
    //   Scanner sc=new Scanner(System.in);
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // PrintWriter out = new PrintWriter(System.out);
        
        String sizes[] = br.readLine().trim().split(" ");
		   int c = Integer.parseInt(sizes[0]);
		   int v0 = Integer.parseInt(sizes[1]);
		    int v1 = Integer.parseInt(sizes[2]);
		     int a = Integer.parseInt(sizes[3]);
		      int l = Integer.parseInt(sizes[4]);
		      
		      if(c==v0){
		          System.out.println(1);
		          
		      }
		  
		      else{
		          int res=v0;
		          int days=1;
		          int speed=0;
		         while(res<c){
		             speed= v0 + a*days;
		             speed=Math.min(speed, v1);
		             res=res + speed - l;
		             days+=1;
		         }
		       System.out.println(days);
		  }
    }
}

