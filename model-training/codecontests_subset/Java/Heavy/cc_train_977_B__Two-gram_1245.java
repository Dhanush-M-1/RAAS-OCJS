import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Two_gram {
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
        RealScanner sc=new RealScanner();
        int n=sc.nextInt();
        String s=sc.next();
        int max=0,count=0;
        String tech="";
        List<String> l1=new ArrayList<>();
        List<Integer> l2=new ArrayList<>();
        for (int i=0;i<n-1;i++){
            String myS=s.substring(i,i+2);
            for (int m=0;m<n-1;m++){
                if (s.substring(m,m+2).equals(myS)){
                    count++;
                }
            }
//            Pattern pattern = Pattern.compile(myS);
//            Matcher matcher = pattern.matcher(s);
//            while (matcher.find()){
//                count++;
//            }
//            for (int m=0;m<)
//            max=Math.max(count,max);
            l1.add(myS);
            l2.add(count);
            count=0;
        }
       // System.out.println(l1);
      // System.out.println(l2);
      int maxVal= Collections.max(l2);
        for (int i=0;i<l2.size();i++){
            if (maxVal==l2.get(i)){
                System.out.println(l1.get(i));
                break;
            }
        }
    }
}
