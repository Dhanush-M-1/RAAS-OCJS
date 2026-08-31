/*      MOHD SADIQ        */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
import java.util.ArrayList;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private  long longVal() throws IOException{
        return Long.parseLong(br.readLine().trim());
    }
    private  int intVal() throws IOException{
        return Integer.parseInt(br.readLine().trim());
    }
    private  double doubleVal() throws IOException{
        return Double.parseDouble(br.readLine().trim());
    }
    private  int[] intArr() throws IOException{
        String[] s = br.readLine().trim().split(" ");
        int n = s.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        return a;
    }
    private  long[] longArr() throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int n = s.length;
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(s[i]);
        }
        return a;
    }
    private  double[] doubleArr() throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int n = s.length;
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = Double.parseDouble(s[i]);
        }
        return a;
    }
    private String[] stringArr() throws IOException{
        String[] s = br.readLine().trim().split(" ");
        return s;
    }
    private  char[] charArr() throws IOException{
        return br.readLine().trim().toCharArray();
    }

    public static boolean[] sieve(int n){
        boolean[] primes = new boolean[n + 1];
        int i;
        Arrays.fill(primes,true);
        for(i = 2; i * i <= n; ++i) {
            if (primes[i]) {
                for(int p = i * i; p <= n; p += i) {
                    primes[p] = false;
                }
            }
        }
        return primes;
    }

    private static String solve() throws IOException {

        Main obj = new Main();
        int n = obj.intVal();
//        long[] xx = obj.longArr();
//        long l = xx[0],r = xx[1];
//        int[] a = obj.intArr();
        char[] c = obj.charArr();
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i=0;i<n-1;i++){
            String s = c[i]+""+c[i+1];
            if(hm.containsKey(s)){
                int k = hm.get(s)+1;
                hm.put(s,k);
            }
            else hm.put(s,1);
        }
        String s="";
        int max = 0;
        for(String i :hm.keySet()){
            if(hm.get(i)>max){
                max = hm.get(i);
                s = i;
            }
        }
        return  s+"";

    }

    public static void main(String[] args) throws IOException {
        Main ob = new Main();
//        primes = sieve()
//        int total_test_case = ob.intVal();
        int total_test_case = 1;
        StringBuffer ans = new StringBuffer();
        String k ;
        for(int test_case =0;test_case<total_test_case;test_case++){
            k = Main.solve();
//            System.out.println(k);
            ans.append(k+"\n");
        }
        System.out.print(ans);
    }
}