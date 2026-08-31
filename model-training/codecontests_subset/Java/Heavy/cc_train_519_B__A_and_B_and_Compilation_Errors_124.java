import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class A_and_B_and_Compilation_Errors {
    static class RealScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) {
        RealScanner sc = new RealScanner();
        long n = sc.nextLong();
       // List<Long> l1 = new ArrayList<>();
        int sum1=0,sum2=0,sum3=0;
        for (long i = 0; i < n; i++) {
            long a = sc.nextLong();
           // l1.add(a);
            sum1+=a;
        }
       // List<Long> l2 = new ArrayList<>();
//        List<Long> local2 = new ArrayList<>();
        for (long i = 0; i < n - 1; i++) {
            long a = sc.nextLong();
            //l2.add(a);
            sum2+=a;
           // local2.add(a);
        }
        //List<Long> l3 = new ArrayList<>();
        for (long i = 0; i < n - 2; i++) {
            long a=sc.nextLong();
            //l3.add(a);
            sum3+=a;
        }
        System.out.println(sum1-sum2);
        System.out.println(sum2-sum3);
//        for (long i = 0; i < l1.size(); i++) {
//            if (l2.contains(l1.get((int) i))) {
//                l2.remove(new Long(l1.get((int) i)));
//            } else {
//                System.out.println(l1.get((int) i));
//                break;
//            }
//        }
//        for (long i = 0; i < local2.size(); i++) {
//            if (l3.contains(local2.get((int) i))) {
//                l3.remove(new Long(local2.get((int) i)));
//            } else {
//                System.out.println(local2.get((int) i));
//                break;
//            }
//        }

    }
}
