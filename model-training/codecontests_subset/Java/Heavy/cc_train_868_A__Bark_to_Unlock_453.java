import java.util.*;

public class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String pass = sc.next();
        int n = sc.nextInt();
        String[] arr = new String[n];
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
            if (arr[i].equals(pass)) {
                flag = true;
            }
        }
        for (int i = 0; i < n && !flag; i++) {
            for (int j = 0; j < n && !flag; j++) {
                String X = arr[i] + arr[j];
                if (X.indexOf(pass) != -1) {
                    flag = true;
                }
            }
        }
        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
