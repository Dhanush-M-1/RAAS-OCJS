import java.util.*;

public class TestNBeans {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
	Integer n = sc.nextInt();
        Integer c = sc.nextInt();
        Integer[] a = new Integer[n];
        Integer best = 0;
        for (Integer i = 0; i < n; ++i) {
            a[i] = sc.nextInt();
        }
        for (Integer i = 1; i < n; ++i) {
            best = Math.max(best, a[i-1] - c - a[i]);
        }		
	System.out.println(best);
    }
    
}
