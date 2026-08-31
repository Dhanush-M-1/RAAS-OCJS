import java.util.Scanner;

public class P044B {

    public static void main(String[] args) {
        Scanner inScanner = new Scanner(System.in);
        int n = inScanner.nextInt();
        int a = inScanner.nextInt();
        int b = inScanner.nextInt();
        int c = inScanner.nextInt();
        long possibilities = 0;
        for (int testA = 0; testA <= a; testA += 2) {
            for (int testC = 0; testC <= c; testC++) {
                int requiredB = n - testA / 2 - 2 * testC;
                if(requiredB >=0 && requiredB <= b)
                    possibilities++;
            }
        }
        System.out.println(possibilities);
    }
}
