import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double basePrice = sc.nextInt();
        double toppingPrice = sc.nextInt();
        int baseCalory = sc.nextInt();
        int[] calories = new int[n];
        for (int i = 0; i < n; i++) {
            calories[i] = - sc.nextInt();
        }
        Arrays.sort(calories);
        double ans = baseCalory / basePrice;
        for (int i = 0; i < n; i++) {
            if (ans < (baseCalory - calories[i]) / (basePrice + toppingPrice)) {
                baseCalory -= calories[i];
                basePrice += toppingPrice;
                ans = baseCalory / basePrice;
            } else {
                break;
            }
        }
        System.out.println((int)ans);
    }
}

