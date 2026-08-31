import java.util.*;

public class MainClass {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int r1 = in.nextInt(), r2 = in.nextInt(), c1 = in.nextInt(), 
            c2 = in.nextInt(), d1 = in.nextInt(), d2 = in.nextInt();
        int x1, x2, x3, x0;
        x0 = (d1 - r2 + c1);
        x1 = (d2 - r2 + c2);
        x2 = (d2 - r1 + c1);
        x3 = (d1 - r1 + c2);
        if (x0!=x1 && x0!=x2 && x0!=x3 && x1!=x2 && x1!=x3 && x2!=x3
            && x0%2 == 0 && x1%2 == 0 && x2%2 == 0 & x3%2 == 0
            && x0>0 && x0<20 && x1>0 && x1<20 && x2>0 && x2<20 && x3>0 && x3<20)
        {
            System.out.println(x0/2+" "+x1/2);
            System.out.println(x2/2+" "+x3/2);
        }
        else System.out.println("-1");
    }
}