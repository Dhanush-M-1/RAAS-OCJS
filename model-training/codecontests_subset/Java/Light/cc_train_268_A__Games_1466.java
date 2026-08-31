import java.util.*;

public class test{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), sum = 0;
        int[][] freq = new int[101][2];

        for (int i = 0; i < n; ++i){
            freq[in.nextInt()][0]++;
            freq[in.nextInt()][1]++;
        }

        for (int i = 0; i < freq.length; ++i){
            sum += freq[i][0] * freq[i][1];
        }

        System.out.println(sum);
    }
}