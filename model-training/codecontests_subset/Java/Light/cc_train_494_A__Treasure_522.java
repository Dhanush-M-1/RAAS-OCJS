import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class C {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] a = s.toCharArray();
        int f = 0;
        int k = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == '(') {
                f++;
            } else if (a[i] == ')') {
                f--;
            } else {
                k++;
            }
            if (f < 0) {
                System.out.println(-1);
                return;
            }
        }
        if (f == 0) {
            System.out.println(-1);
            return;
        }
        int f1 = f;
        f = 0;
        List<Integer> res = new LinkedList<Integer>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == '(') {
                f++;
            } else if (a[i] == ')') {
                f--;
            } else {
                k--;
                res.add(k == 0 ? f1 : 1);
                f = f - (k == 0 ? f1 : 1);
                f1--;
            }
            if (f < 0) {
                System.out.println(-1);
                return;
            }
        }
        if (f != 0) {
            System.out.println(-1);
            return;
        }
        for (int n : res) {
            System.out.println(n);
        }
    }
    
   
}