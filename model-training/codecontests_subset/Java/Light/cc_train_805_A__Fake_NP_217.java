import java.util.Scanner;

/**
 * Created by wbin on 2017/5/9.
 */
public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int a = cin.nextInt();
            int b = cin.nextInt();
            if(a==b)
                System.out.println(a);
            else 
                System.out.println(2);
        }
    }
}