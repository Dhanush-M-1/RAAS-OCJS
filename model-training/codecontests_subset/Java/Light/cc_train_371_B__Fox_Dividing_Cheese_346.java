import java.util.*;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int a = input.nextInt(), b = input.nextInt();
        if (a==b){
            System.out.println("0");
            return;
        }
        int[] a_counter = new int[3];
        int[] b_counter = new int[3];
        while (true) {
            if (a % 2 == 0) {
                a_counter[0]++;
                a /= 2;
            } else if (a % 3 == 0) {
                a_counter[1]++;
                a /= 3;
            } else if (a % 5 == 0) {
                a_counter[2]++;
                a /= 5;
            } else {
                break;
            }
        }
        while (true) {
            if (b % 2 == 0) {
                b_counter[0]++;
                b /= 2;
            } else if (b % 3 == 0) {
                b_counter[1]++;
                b /= 3;
            } else if (b % 5 == 0) {
                b_counter[2]++;
                b /= 5;
            } else {
                break;
            }
        }
        System.out.println((a==b)?Math.abs(b_counter[0]-a_counter[0])+Math.abs(b_counter[1]-a_counter[1])+Math.abs(b_counter[2]-a_counter[2]):-1);

    }
}
