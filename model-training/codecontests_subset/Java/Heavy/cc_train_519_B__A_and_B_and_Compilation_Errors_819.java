import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.math.BigInteger;

public class err {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));	
		int n = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine()," ");
        StringTokenizer sf = new StringTokenizer(bf.readLine()," ");
        StringTokenizer su = new StringTokenizer(bf.readLine()," ");
        
        BigInteger al = new BigInteger("0"); 
		 BigInteger ak = new BigInteger("0"); 
		 BigInteger au = new BigInteger("0");
		 BigInteger r = new BigInteger("0"); 
		 BigInteger rr = new BigInteger("0"); 
		 BigInteger rrr = new BigInteger("0");
        while(st.hasMoreTokens()){
        	 r=new BigInteger(st.nextToken());
        	 al = al.add(r);
        }
      
        while(sf.hasMoreTokens()){
        	rr=new BigInteger(sf.nextToken());
       	   ak = ak.add(rr);
         }
        while(su.hasMoreTokens()){
        	rrr=new BigInteger(su.nextToken());
       	    au = au.add(rrr);
         } 
        
	  
	  
	  System.out.println(al.subtract(ak));
	  System.out.print(ak.subtract(au));
	  
	 
	}	
}
