import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Main {
    static Scanner in = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    
    public static void main(String[] args) {
        int n = in.nextInt();
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int number = in.nextInt();
            if (number % 2 == 0) {
                even.add(number);
            } else {
                odd.add(number);
            }
        }

        if (Math.abs(even.size() - odd.size()) <= 1) {
            out.println(0);
        } else {
            int counter = Math.abs(even.size() - odd.size()) - 1;
            int sum = 0;
            if (even.size() > odd.size()) {
                Collections.sort(even);
                while (counter > 0) {
                    sum += even.get(counter - 1);
                    counter--;
                }
            }
            if (odd.size() > even.size()) {
                Collections.sort(odd);
                while (counter > 0) {
                    sum += odd.get(counter - 1);
                    counter--;
                }
            }
            out.println(sum);
        }

        in.close();
        out.close();
    }
}