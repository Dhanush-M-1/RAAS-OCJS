import java.util.Scanner;


public class Round123A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();

        for (int i=1; i<a*c; i++){
            if (a*c <= b*(i+c)) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(1000);
    }
}
