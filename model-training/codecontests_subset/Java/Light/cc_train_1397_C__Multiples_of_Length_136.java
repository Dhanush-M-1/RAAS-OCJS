import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Harry on 7/4/20.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        long n = scanner.nextLong();
        long[] nums = new long[(int)n];
        for(int i=0; i<n; i++){
            nums[i] = scanner.nextLong();
        }
        System.out.println("1 1");
        System.out.println(-nums[0]);
        nums[0] = 0l;
        if(n-1>0){
            System.out.println("2 "+n);
            for(int i=1; i<n; i++){
                System.out.print(nums[i]*(n-1)+" ");
                nums[i] *= n;
            }
            System.out.println();
        }
        else{
            System.out.println("1 1");
            System.out.println(0);
        }
        System.out.println("1 "+n);
        for(long num : nums){
            System.out.print(-num+" ");
        }
    }
}
