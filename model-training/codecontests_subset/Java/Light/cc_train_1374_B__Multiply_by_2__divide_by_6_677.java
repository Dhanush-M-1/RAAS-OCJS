
import java.util.Scanner;

public class Mul_div {
	public static int  get_power(int n,int a) {
		int max=(int)((Math.log(n)/Math.log(a))+1);
		for(int i=max;i>=0;i--) {
			int curr=(int)Math.pow(a, i);
			if(n%curr==0 ) {
				return i;
			}
		}
		return 0;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        
        for(int i=0;i<t;i++) {
        	
        	int n=s.nextInt();

        	
        	
        	int  a= get_power(n, 3);
        	int    b= get_power(n, 2);
           int curr=(int)Math.pow(3, a);
           curr=curr*(int)Math.pow(2, b);
           if(n==curr && a>=b ) {
        	 System.out.println(2*((int)a)-(int)b);
           }
           else {
        	   System.out.println(-1);;
           }
        }
        	
            
	}

}
