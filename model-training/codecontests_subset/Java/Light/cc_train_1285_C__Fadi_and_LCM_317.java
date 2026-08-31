import java.util.*;

public class Main {
    public static long x,z,b;
    public static long gcb(long a,long b){
        return a%b==0?b:gcb(b,a%b);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            long x=scanner.nextLong();
            long minn= (long) 1e13;
            minn=Math.min(minn,x);
            for (long i=2;i<=Math.sqrt(x);i++){
                if (x%i==0&&gcb(x/i,i)==1){
                    minn=Math.min(minn,x/i);
                }
            }
            System.out.println(x/minn+" "+minn);
        }
    }
}
 					     	 	  			  			 		