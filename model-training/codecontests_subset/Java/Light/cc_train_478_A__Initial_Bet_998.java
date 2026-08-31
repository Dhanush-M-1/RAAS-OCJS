import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = 0;
        for (int i = 0; i < 5; i++) {
            s += in.nextInt();
        }
        if(s==0) System.out.print("-1");
        else if (s % 5 == 0) {
            System.out.print(s / 5);
        } else {
            System.out.print("-1");
        }
    }
}