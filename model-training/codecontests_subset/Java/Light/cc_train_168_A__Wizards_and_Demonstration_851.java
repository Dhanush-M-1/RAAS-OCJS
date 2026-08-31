import java.util.Scanner;

public class A168 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int X = input.nextInt();
        int Y = input.nextInt();
        int pupets = 0;
        while (100*(X+pupets) < N*Y) pupets++;
        System.out.println(pupets);
    }

}
