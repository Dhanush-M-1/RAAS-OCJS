import java.io.*;
import java.util.*;

public class D {
    static int trunc_div (int a, int b) {
	if (a<0) return -((-a)/b)-1; else return a/b;
    }
    public static void main(String[] args) throws Exception {
	int a, b, x1, y1, x2, y2;
	Scanner sc = new Scanner(System.in);
	a = sc.nextInt();
	b = sc.nextInt();
	x1 = sc.nextInt();
	y1 = sc.nextInt();
	x2 = sc.nextInt();
	y2 = sc.nextInt();
	int ablocks = Math.abs(trunc_div (x1+y1,2*a) - trunc_div(x2+y2,2*a));
	int bblocks = Math.abs(trunc_div (x1-y1,2*b) - trunc_div(x2-y2,2*b));
	System.out.println(Math.max(ablocks,bblocks));
    }
}
