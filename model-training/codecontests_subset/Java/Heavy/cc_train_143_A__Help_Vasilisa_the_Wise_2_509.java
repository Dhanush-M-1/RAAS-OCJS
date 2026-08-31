import java.util.*;

public class Helpvasilisathewise2{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int r1 = scn.nextInt();
        int r2 = scn.nextInt();
        int c1 = scn.nextInt();
        int c2 = scn.nextInt();
        int d1 = scn.nextInt();
        int d2 = scn.nextInt();
        int flag = 0;
        for(int i = 1; i < r1 && i < 10; i++){
            int a = i;
            int b = r1 - i;
            int c = c1 - a;
            int d = c2 - b;
            if(c == 0 || c == 10 || d== 0 || d == 10)
                continue;
            if(a == b || a == c || a == d || b == c || b == d || c == d)
                continue;
            if(a + d != d1)
                continue;
            if(b + c != d2)
                continue;
            if(c + d != r2)
                continue;
            System.out.println(a + " " + b);
            System.out.println(c + " " + d);
            flag++;
            break;
        }
        if(flag == 0)
            System.out.println(-1);
    }
}