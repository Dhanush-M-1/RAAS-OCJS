import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int[] foo = {1, 1, 1, 2, 1, 2, 1, 5, 2, 2, 1, 5, 1, 2, 1, 14, 1, 5, 1, 5, 2, 2, 1, 15, 2, 2, 5, 4, 1, 4, 1, 51};
        Scanner scan = new Scanner(System.in);
        int num= scan.nextInt();
        num=num-1;
        System.out.println(foo[num]);
    }
}