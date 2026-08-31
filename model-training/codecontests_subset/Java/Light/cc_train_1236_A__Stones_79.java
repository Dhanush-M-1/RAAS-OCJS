import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int i = 0;i < testCases;i++){
            int numStones = 0;
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            while (true) {
                if (b > 0 && c >= 2) {
                    numStones += 3;
                    b--;
                    c -= 2;
                } else if (a > 0 && b >= 2) {
                    numStones += 3;
                    a--;
                    b -= 2;
                }
                else
                    break;
            }
            System.out.println(numStones);
        }
    }
}