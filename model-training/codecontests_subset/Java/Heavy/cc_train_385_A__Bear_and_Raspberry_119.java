import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int c = input.nextInt();
        int result, ans = 0;
        int[] x = new int[n];
        for(int i = 0; i < n; i++)
            x[i] = input.nextInt();
        int sell,buy;
        for(int i = 0; i < n - 1; i++){
            sell = x[i];
            buy = x[i + 1];
            if(sell - buy - c > 0){
                result = sell - buy - c;
                if(result > ans)
                    ans = result;
            }
        }
        System.out.println(ans);
    }
}
