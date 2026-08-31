import java.util.*;

public class cf123b {
        public static void main(String[] args) {
                Scanner in = new Scanner(System.in);
                long a = in.nextInt()*2;
                long b = in.nextInt()*2;
                long x1 = in.nextInt();
                long y1 = in.nextInt();
                long x2 = in.nextInt();
                long y2 = in.nextInt();
                long x3 = (x1+y1)/a;
                long y3 = (x1-y1)/b;
                long x4 = (x2+y2)/a;
                long y4 = (x2-y2)/b;
                if(x1 + y1 < 0) x3--;
                if(x1 - y1 < 0) y3--;
                if(x2 + y2 < 0) x4--;
                if(x2 - y2 < 0) y4--;
                System.out.println(Math.max(Math.abs(x3-x4),Math.abs(y3-y4)));
        }
}