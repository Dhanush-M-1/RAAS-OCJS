import java.util.Scanner;

public class NewYearCandles {
    static int burnTime = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
//        while (true) {
            int newCandles = input.nextInt();
            int makeANewOne = input.nextInt();
            burnCandles(newCandles, 0, makeANewOne);
            System.out.println(burnTime);
//        }
    }

    static void burnCandles(int newCandles, int oldCandles, int makeANewOne) {
        burnTime += newCandles;
        oldCandles += newCandles;
        newCandles = oldCandles / makeANewOne;
        oldCandles = oldCandles % makeANewOne;
        if (newCandles > 0) {
            burnCandles(newCandles, oldCandles, makeANewOne);
        }
    }
}
