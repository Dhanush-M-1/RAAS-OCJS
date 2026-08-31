import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int bAmount = sc.nextInt();
        int gAmount = sc.nextInt();
        int[] genres = new int[gAmount];
        for (int i = 0; i < bAmount; i++) {
            ++genres[sc.nextInt() - 1];
        }
        sc.close();
        long result = 0;
        for (int i = 0; i < gAmount - 1; i++) {
            bAmount = bAmount - genres[i];
            result = result + genres[i] * bAmount;
        }
        System.out.println(result);
    }
}
