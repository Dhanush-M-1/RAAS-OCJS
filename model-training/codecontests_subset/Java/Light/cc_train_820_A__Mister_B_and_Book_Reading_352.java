import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();
        int v0 = scanner.nextInt();
        int v1 = scanner.nextInt();
        int a = scanner.nextInt();
        int l = scanner.nextInt();
        System.out.println(count(c, v0,v1,a,l));
    }

    private static int count(int c, int v0, int v1, int a, int l){
        int count = 0;
        int day = 0;
        while (c > 0) {
            count++;
            int result = Math.min(v0 + day * a, v1);
            c = c - result;
            if (c > 0) {
                day++;
                c +=l;
            }
        }
        return count;
    }
}