// Why do we fall ? So we can learn to pick ourselves up.
import java.math.BigInteger;
import java.util.*;
public class solve {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long p = sc.nextLong();
        long w = sc.nextLong();
        long d = sc.nextLong();
        int k = 0;
        for(int y=0; y<w; y++){
            if(p-y*d>=0 && ((p-y*d)%w == 0 && (p-y*d)/w+y <= n)){
                long x = (p-y*d)/w;
                long z = n-x-y;
                System.out.println(x+" "+y+" "+z);
                k = 1;
                break;
            }
        }
        if(k==0){
            System.out.println(-1);
        }
        }
    }
