import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author: zhaoqing
 * @date: 2018/9/9
 * @time: 下午9:37
 */
public class MinimumInteger1101A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  q=sc.nextInt();
        for(int i=0;i<q;i++){
            int  l=sc.nextInt();
            int  r=sc.nextInt();
            int  d=sc.nextInt();
            if((d>=l) && (d<=r)){
                System.out.println(d*(r/d+1));
            }else {
                System.out.println(d);
            }
        }

    }
}
