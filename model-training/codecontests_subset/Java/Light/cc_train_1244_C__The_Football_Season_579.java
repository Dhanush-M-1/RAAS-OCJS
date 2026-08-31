// No sorceries shall previal. //         
import java.util.Scanner;
import java.io.PrintWriter;

public class InVoker { 	
    public static void main(String args[]) {
    		
    	Scanner inp=new Scanner(System.in);
    	PrintWriter out= new PrintWriter(System.out);
    	
    	long n=inp.nextLong();
    	long p=inp.nextLong();
    	long w=inp.nextLong();
    	long d=inp.nextLong();
    	long i=0;
    	for(;i<100001;i++) {
    		if(p>=i*d && (p-(i*d))%w==0 && (p-(i*d))/w<=n-i) {
    			out.println((p-(i*d))/w +" "+i+" "+ (n-(p-(i*d))/w-i));
    			break;
    		}
    	}
    	if(i==100001)
    		out.println("-1");
    	
    	inp.close();
    	out.close();
    }    		
}