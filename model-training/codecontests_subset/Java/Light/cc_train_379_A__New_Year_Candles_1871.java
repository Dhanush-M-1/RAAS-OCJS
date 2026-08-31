import java.math.BigInteger;
import java.util.*;
public class ass {
        public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int a=in.nextInt();
        int b=in.nextInt();
        int sum=0;
        int t=a;
        for(int i=0;i<100;i++){
            sum+=t/b;
            t=t/b+t%b;
            }
        System.out.print(sum+a);
        }
        }