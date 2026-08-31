import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = reader.nextInt();

        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();

        int num;
        for (int i = 0; i < n; i++) {
            num = reader.nextInt();
            if (num % 2 == 0)
                even.add(num);
            else
                odd.add(num);
        }

        even.sort(Comparator.reverseOrder());
        odd.sort(Comparator.reverseOrder());

        int evenLen = even.size();
        int oddLen = odd.size();

        int diff;
        int sum = 0;
        if (evenLen > oddLen) {
            diff = evenLen - oddLen - 1;

            if (diff >= 1) {
                for (int j = evenLen - 1; j >= evenLen - diff; j--) {
                    sum += even.get(j);
                }
            } else {
                sum = 0;
            }
        } else {
            diff = oddLen - evenLen - 1;
            if (diff >= 1) {
                for (int j = oddLen - 1; j >= oddLen - diff; j--) {
                    sum += odd.get(j);
                }
            } else {
                sum = 0;
            }
        }

        System.out.println(sum);
    }
}