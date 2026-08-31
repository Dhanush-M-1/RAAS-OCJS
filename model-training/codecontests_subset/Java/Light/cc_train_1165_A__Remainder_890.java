import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by 竹韵澜 on 2019/5/21.
 * 1165A
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        String num_pre = sc.next();
        String num_str = num_pre.substring(n - x, n);
        BigInteger bnum = new BigInteger("10");
        bnum = bnum.pow(x).add(bnum.pow(y));
        String bnum_str_pre = bnum.toString();
        String bnum_str = bnum_str_pre.substring(1,bnum_str_pre.length());

        int ans = 0;
        /*
        if (num_str.length() > bnum_str.length()){
            int a = num_str.length();
            int b = bnum_str.length();
            while (a>0){
                if (b>0){
                    if (num_str.charAt(a)!=bnum_str.charAt(b))
                        ans++;
                }else if (num_str.charAt(a)=='1')
                    ans++;
                a--;
                b--;
            }
        }
        */


            int a = num_str.length();
            int b = bnum_str.length();
            while (b>0){
                if (a>0){
                    if (num_str.charAt(a-1)!=bnum_str.charAt(b-1))
                        ans++;
                }else if (num_str.charAt(b)=='1')
                    ans++;
                a--;
                b--;
            }
        

        System.out.println(ans);
    }
}
