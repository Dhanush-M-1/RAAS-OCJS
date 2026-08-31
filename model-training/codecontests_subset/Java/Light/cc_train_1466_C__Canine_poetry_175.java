import java.util.Scanner;

public class main9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int p = 0; p < t; p++) {

            String s = sc.next();
            char[] arr = new char[s.length()];
            for (int i = 0; i < s.length(); i++) {
                arr[i] = s.charAt(i);
            }
            if (s.length() == 1)
                System.out.println(0);
            else {
                int count = 0;
                int r = 123;
                for (int i = 0; i < s.length() - 2; i++) {
                    if(r>150)
                        r=123;

                    if (arr[i] == arr[i + 1]) {
                        arr[i + 1] = (char) ++r;
                        count++;
                    }
                    if (arr[i] == arr[i + 2]) {
                        arr[i + 2] = (char) ++r;
                        count++;
                    }
                }
                if (arr[s.length() - 2] == arr[s.length() - 1]) {
                    count++;
                }
                System.out.println(count);
            }
        }
    }
}
