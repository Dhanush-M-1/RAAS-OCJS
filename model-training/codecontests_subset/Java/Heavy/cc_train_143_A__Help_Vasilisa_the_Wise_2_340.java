import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int r1= in.nextInt();
        int r2= in.nextInt();
        int c1= in.nextInt();
        int c2= in.nextInt();
        int d1= in.nextInt();
        int d2= in.nextInt();
        boolean flag = false;
        int a1 = -1, a2 = -1, a3 = -1, a4 = -1;
        for (int i = 1; i < 10; i++) {
            a1 = i;
            if(r1 - a1 <= 9 && r1 - a1 >= 1)
                a2 = r1 - a1;
            else
                continue;
            if(c1 - a1 <= 9 && c1 - a1 >= 1)
                a3 = c1 - a1;
            else
                continue;
            if(r2 - a3 <= 9 && r2 - a3 >= 1)
                a4 = r2 - a3;
            else
                continue;
            
            if(a1 + a2 == r1 && a3 + a4 == r2 && a1 + a3 == c1 && a2 + a4 == c2 && a1 + a4 == d1 && a2 + a3 == d2){
                if(a1 == a2 || a1 == a3 || a1 == a4 || a2 == a3 || a2 == a4 || a3 == a4)
                    continue;
                flag = true;
                break;
            }
        }
        if (flag){
            System.out.println(a1 + " " + a2);
            System.out.println(a3 + " " + a4);
        }
        else
            System.out.println(-1);
    }
}
