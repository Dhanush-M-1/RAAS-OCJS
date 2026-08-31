import java.util.*;
public class MyClass {
    public static void main(String args[]) {
        Scanner kbd = new Scanner(System.in);
        long ax = kbd.nextLong();
        long ay = kbd.nextLong();
        long bx = kbd.nextLong();
        long by = kbd.nextLong();
        long cx = kbd.nextLong();
        long cy = kbd.nextLong();
        
        long dx=bx-ax;
        long dy=by-ay;
        long ex=cx-ax;
        long ey=cy-ay;
        long fx=cx-bx;
        long fy=cy-by;
        
        if (dx*ey==ex*dy){
            System.out.println("NO");
            System.exit(0);
        }
        if  (dx*dx+dy*dy!=fx*fx+fy*fy){
             System.out.println("NO");
            System.exit(0);
        }
        System.out.println("YES");
    }
}
