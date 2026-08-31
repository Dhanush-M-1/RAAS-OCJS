import java.util.Scanner;

public class Main {


    public  long gcd(long a,long b){
        return b==0?a:gcd(b,a%b);
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        long y = (long) Math.sqrt(x);
        for(;y>1;y--){
            if(x%y==0&&(y!=x/y)){
                long p = x/y;
                long q = y;
                q = main.gcd(p,q);
                if(q!=1)continue;
                System.out.println(y+" "+x/y);
                return;
            }
        }
        System.out.println(1+" "+x);
    }
}
							  	  		  	 		    	  		 	