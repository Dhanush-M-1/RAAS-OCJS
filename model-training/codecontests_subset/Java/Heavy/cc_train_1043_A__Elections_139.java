
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nStudents = sc.nextInt();
        int k = 0;
        int elodreip = 0;
        int[] votes = new int[nStudents];

        for (int i = 0; i < nStudents; i++) {
            int number = sc.nextInt();
            elodreip += number;
            votes[i] = number;

            if (number > k)
                k = number;
        }
        int sum = 0;
        while (sum <= elodreip) {
            for (int i = 0; i < votes.length; i++) {
                sum += k - votes[i];
            }

            if (sum <= elodreip) {
                sum = 0;
                k++;
            }
        }

        System.out.println(k == 0 ? 1 : k);
    }
}