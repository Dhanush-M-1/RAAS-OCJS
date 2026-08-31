import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        int dis = a - b;
        int tiredness = 2 * (dis / 2) * (dis / 2 + 1) / 2;
        if (dis % 2 != 0)
            tiredness += dis / 2 + 1;
        System.out.println(tiredness);
    }
}
