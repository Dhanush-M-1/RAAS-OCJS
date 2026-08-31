import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Harry on 4/10/20.
 */
public class test {
    public static void main(String[] args){
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int T = scanner.nextInt();
        for(int t=0; t<T; t++){
            long n = scanner.nextLong();
            long l = scanner.nextLong();
            long r = scanner.nextLong();
            long step = (n-1)*2;
            long sum = 0;
            while(l>sum){
                sum += step;
                if(l>sum){
                    if(step>2){
                        step -= 2;
                    }
                    else{
                        step = 1;
                    }
                }
            }
            long index = l-(sum-step);
            long count = 0;
            while(count<=(r-l)){
                long node = n - step/2;
                if(node==n){
                    System.out.print(1+" ");
                }
                else{
                    if(index%2==1){
                        System.out.print(node+" ");
                    }
                    else{
                        System.out.print((index/2+node)+" ");
                    }
                }
                index++;
                if(index>step){
                    if(step>2){
                        step-=2;
                    }
                    else{
                        step=1;
                    }
                    index = 1;
                }
                count++;
            }
            System.out.println();
        }
    }
}
