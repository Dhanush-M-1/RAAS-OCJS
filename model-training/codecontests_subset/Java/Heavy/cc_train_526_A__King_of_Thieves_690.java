import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        char[] maze = sc.nextLine().toCharArray();
        boolean flag = false;
        lop: for (int i = 0; i < maze.length; i++) {
            for (int j = 1; j < maze.length; j++) {
                int c = 0;
                for (int k = 0; i + k < maze.length; k += j) {
                    if (maze[i + k] == '.')
                        break;
                    c++;
                }
                if (c >= 5) {
                    flag = true;
                    break lop;
                }
            }
        }
        System.out.println(flag ? "yes" : "no");
    }
}
