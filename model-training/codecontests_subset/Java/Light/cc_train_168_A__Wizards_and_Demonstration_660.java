import java.util.Scanner;
public class problem168A {
    public void run() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        in.close();
        int need = n * y;
        need = need % 100 == 0 ? need / 100 : need / 100 + 1;
        System.out.println(need - x > 0 ? need - x : 0);
    }
    public static void main(String[] args) {
        new problem168A().run();
    }
}