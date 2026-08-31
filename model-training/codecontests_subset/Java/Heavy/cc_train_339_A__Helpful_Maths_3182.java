import java.util.Scanner;

public class Problem {

    int a, b, n, sum, bufsum;
    String str;
    int[] ab = new int[3];

    public static void main(String[] args) {
        Problem prob = new Problem();
        prob.run();
    }

    public void run() {
        init();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '+')
                ab[str.codePointAt(i) - "1".codePointAt(0)]++;
        }
        String buf = "";
        int i = 0;
        while (i < 3) {
            if (ab[i] == 0) {
                i++;
                continue;
            }
            buf += (i+1) + "+";
            ab[i]--;
        }
        prntln(buf.substring(0, buf.length()-1));
    }

    public void init() {
        Scanner s = new Scanner(System.in);
        str = s.next();
    }

    public int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
    
    public void bubleStupidSort(int[] a) {
        int k = a.length;
        int b;
        for (int i = 0; i < k-1; i++) {
            for (int l = i+1; l < k; l++) {
                if (a[i] < a[l]) {
                    b = a[i];
                    a[i] = a[l];
                    a[l] = b;
                }
            }
        }
    }

    public void prnt(String i) {
        System.out.print(i);
    }

    public void prntln(String i) {
        System.out.println(i);
    }
}