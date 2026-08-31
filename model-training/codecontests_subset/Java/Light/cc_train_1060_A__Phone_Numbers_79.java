
import java.util.Scanner;

public class Main {
    private static Scanner get = new Scanner(System.in);
    public static void main(String[] args) {
        int n = get.nextInt();
        String entrance = get.next();
        int m = n/11;
        int j = 0;
        for (int i = 0; i < (n); i++) {
            if (entrance.charAt(i) == '8')
                j++;
        }
        if(m <= j)
            System.out.println(m);
        else
            System.out.println(j);

    }
}
