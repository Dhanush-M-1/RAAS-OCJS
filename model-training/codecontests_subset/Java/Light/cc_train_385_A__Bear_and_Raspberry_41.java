import java.util.Scanner;

public class BearAndRaspberry {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), c = in.nextInt();
        int maxProfit = 0;
        int lastNumber = 0;
        for (int i=0;i<n;i++) {
            int thisNumber = in.nextInt();
            if (i > 0) {
                int profit = lastNumber-thisNumber-c;
                if (profit > maxProfit) maxProfit = profit;
            }
            lastNumber = thisNumber;
        }
        in.close();
        System.out.println(maxProfit);
    }

}
