import java.util.*;
import java.io.*;
//import java.lang.*;

public class Task{
public static long gcd(long a,long b){
	if(b==0){return a;}
	return gcd(b,a%b);
}

public static void main(String[] args) throws IOException{
       Scanner s=new Scanner(System.in);
       BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
       StringBuilder sb=new StringBuilder();
       long n=s.nextLong();
       int k=(int)Math.sqrt(n)+1;int c=0;
      	long x=1,y=n;
       for(int i=1;i<=k;i++){
       	if(n%(long)i==0){
       		if(gcd((long)i,n/i)==1&&Math.max(x,y)>Math.max((long)i,n/i)){
       			x=i;y=n/i;
       		}
       	}
       }
      
       	   	out.write(x+" "+y+" ");
       	     out.flush();   
       }
       }
       	
       
       
       
       	
       
       
       	
       
       
  
