import java.util.*;
import java.io.*;
 
public class Main {
	public static void main(String args[]) {new Main().run();}
	
	Scanner in = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	void run(){
	    work();
	    out.flush();
	}
	long mod=998244353L;
	void work() {
	    int n=in.nextInt();
	    Long[] A=new Long[n];
	    for(int i=0;i<n;i++)A[i]=in.nextLong();
        Arrays.sort(A); 
        long ret=0;
	    long[] rec=new long[11];
	    for(int b=1,k=0,base=1;b<=10;b++,base*=10){
	         while(k<n&&A[k]/base<10&&A[k]/base>0){
	             rec[b]++;
	             k++;
	         }
	    }
	    
	    long[] sum=new long[11];
	    for(int b=1;b<=9;b++)sum[b]=sum[b-1]+rec[b];
	    for(int i=0;i<n;i++){
	        long base=1;
	        long m=0;
	        for(int b=1;b<=10;base*=10,b++){
	            long num=(A[i]/base)%10;
	            m=m+rec[b-1]*base;
	            m%=mod;
	            ret+=((m*base)%mod)*num*2;
	            ret%=mod;
	           // if(i==2) System.out.println(m+",,,"+b+",,,"+ret);
	        }
	    }
	   // for(long a:sum)System.out.println(a);
	   //System.out.println(ret);
	    for(int i=0;i<n;i++){
	        long base=1;
	        for(int b=1;b<=10;base*=10,b++){
	            long num=(A[i]/base)%10;
	            long r=n-sum[b-1]; 
	            
	            ret+=r*((base*base)%mod)*num*11;
	           // System.out.println(num+"..."+base+",,,"+ret);
	            ret%=mod;
	        }
	    }
	    out.println(ret);
	}
}