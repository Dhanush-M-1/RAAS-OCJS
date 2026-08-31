// No sorceries shall previal. //         
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class InVoker { 	
    public static void main(String args[]) {
    		
    	Scanner inp=new Scanner(System.in);
    	PrintWriter out= new PrintWriter(System.out);
    	
    	int t=inp.nextInt();
    	while(t-->0) {
    		int a=inp.nextInt();
    		int b=inp.nextInt();
    		int c=inp.nextInt();
    		int gg= Math.min(c/2, b);
    		b-=gg;
    		gg+=Math.min(b/2, a);
    		out.println(gg*3);
    	}
    	
    	inp.close();
    	out.close();
    }    		
}