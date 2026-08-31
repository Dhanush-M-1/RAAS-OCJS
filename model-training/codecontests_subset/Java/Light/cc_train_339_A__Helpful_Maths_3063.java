import java.util.Arrays;
import java.util.Scanner;

public class HelpfulMaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        String[] monsoon = str.split("\\+");

        Arrays.sort(monsoon);
        for (int i = 0; i < monsoon.length; i++) {
            System.out.print(monsoon[i]);
            if(i!= monsoon.length-1) {
                System.out.print("+");
            }
        }

    }
}
