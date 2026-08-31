import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.SplittableRandom;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String in = scan.nextLine();
        in = in.replace("+", "");

        String[] main = in.split("");

        ArrayList<Integer> inter = new ArrayList<>();

        for (int i = 0; i < main.length; i++) {
            inter.add(Integer.valueOf(main[i]));
        }

        Integer[] sort = new Integer[inter.size()];

        for (int i = 0; i < inter.size(); i++) {
            sort[i] = inter.get(i);
        }

        Arrays.sort(sort);

        for (int i = 0; i < sort.length; i++) {
            System.out.print(sort[i]);
            if (i != sort.length - 1) {
                System.out.print("+");
            }

        }




    }
}