import java.util.Scanner;

public class source {
    public static void main(String[] args) {
        int n;
        try (Scanner s = new Scanner(System.in)) {
            n = s.nextInt();
        }
        String s = Integer.toHexString(n).toUpperCase();
        int k = 0;
        for (char c : s.toCharArray()) {
            switch (c) {
                case '0':
                case '4':
                case '6':
                case '9':
                case 'A':
                case 'D':
                    k++;
                    break;
                case '8':
                case 'B':
                    k += 2;
                    break;
            }
        }
        System.out.println(k);
    }
}