import java.util.Scanner;

public class RunForYourPrize {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfPrizes = scanner.nextInt();
        int prize;

        int prize0 = 1;
        int prize1 = 1000000;

        for (int i = 0; i < numOfPrizes; i++) {
            prize = scanner.nextInt();

            if (prize <= 500000) {

                prize0 = (prize > prize0) ? prize: prize0;

            } else {

                prize1 = (prize < prize1) ? prize: prize1;

            }

        }

        prize1 = 1000000 - prize1;
        prize0 = prize0 - 1;
        System.out.println(Math.max(prize0, prize1));

    }
}