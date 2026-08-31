import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String [] commandLineArgument){
        Scanner input = new Scanner(System.in);
        long tc = input.nextLong();
        while(tc > 0){
            --tc;
            int n = input.nextInt() , m = input.nextInt();
            String s = input.next();
            int [] p = new int[m];
            long [] suffixSum = new long[n];
            Arrays.fill(suffixSum , 0);
            suffixSum[n - 1] = 1;
            for(int i = 0; i < m; ++i){
                p[i] = input.nextInt();
                --p[i];
                suffixSum[p[i]]++;
            }
            for(int i = n - 2; i >= 0; --i){
                suffixSum[i] += suffixSum[i + 1];
            }
            long characters[] = new long[26];
            for(int i = 0; i < n; ++i){
                char ch = s.charAt(i);
                characters[ch - 'a'] += suffixSum[i];
            }
            for(var x : characters){
                System.out.print(x + " ");
            }
            System.out.println();
        }
        input.close();
    }
}
