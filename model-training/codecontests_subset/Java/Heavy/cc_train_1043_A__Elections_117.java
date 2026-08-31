import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int quantity = scn.nextInt();

        int eloSum = 0;
        int minK = 0;

        for (int i = 0; i < quantity; i++) {
            int buf = scn.nextInt();
            eloSum += buf;
            if (buf > minK) {
                minK = buf;
            }
        }
        scn.close();

        int k = minK;
        while (true) {
            if ((quantity * k) - eloSum > eloSum) {
                System.out.print(k);
                break;
            } else {
                k++;
            }
        }
    }
}