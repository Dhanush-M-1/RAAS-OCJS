import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner inp = new Scanner(System.in);
        int a = inp.nextInt();
        int b = inp.nextInt();
        int c = inp.nextInt();
        boolean flag = false;
        if ((a + b) == c) flag = true;
        if ((a + c) == b) flag = true;
        if ((b + c) == a) flag = true;
        System.out.println(flag ? "Yes" : "No");
    }
}
