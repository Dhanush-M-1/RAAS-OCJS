import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String str = s.next();
        String res = null;
        int count = 0;

        for (int i = 0; i < str.length() - 1; i++) {
            String sub = str.substring(i, i + 2);
            int x = 0;

            for (int j = 0; j < str.length() - 1; j++) {
                if(str.substring(j, j + 2).equals(sub)) x++;
            }
            if(x > count)
            {
                count = x;
                res = str.substring(i, i + 2);
            }
        }
        System.out.println(res);
    }
}