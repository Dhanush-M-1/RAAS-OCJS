import java.util.Scanner;

/**
 * Created by yuu on 24/3/17.
 */
public class Problem385A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int days = sc.nextInt();
        int borrowCost = sc.nextInt();
        int[] costs = new int[days];
        int max = 0;
        costs[0] = sc.nextInt();
        for (int i = 1; i < days; i++){
            costs[i] =  sc.nextInt();
            int profit = costs[i-1] - costs[i] - borrowCost;
            if (profit > max){
                max = profit;
            }
        }
        System.out.println(max);
    }
}
