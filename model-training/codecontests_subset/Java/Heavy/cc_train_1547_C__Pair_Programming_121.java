import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;


public class Main {
    static int i, j, k, n, m, t, y, x, sum = 0;
    static long mod = 1000000007;
    static FastScanner fs = new FastScanner();
    static PrintWriter out = new PrintWriter(System.out);
    static String str;
    static long ans;

    public static void main(String[] args) {
        t = fs.nextInt();

        while (t-- > 0) {

            k = fs.nextInt();
            n = fs.nextInt();
            m = fs.nextInt();

            List<Integer> ans  = new ArrayList<>();

            int[] arr1 = new int[n];
            int[] arr2 = new int[m];

            for(i=0;i<n;i++){
                arr1[i]=fs.nextInt();
            }
            for(i=0;i<m;i++){
                arr2[i]=fs.nextInt();
            }
            boolean isP = true;

            i=0;
            j=0;
            while(i!=n && j!=m){

                if(arr1[i]==0){
                    ans.add(0);
                    i++;
                    k++;
                }
                else if (arr2[j]==0){
                    ans.add(0);
                    j++;
                    k++;
                }

                else{
                    if( arr1[i]<arr2[j]){
                        if(arr1[i]>k){
                            isP = false;
                            break;
                        }
                        else{
                            ans.add(arr1[i++]);
                        }
                    }
                    else{
                        if(arr2[j]>k){
                            isP = false;
                            break;
                        }
                        else{
                            ans.add(arr2[j++]);
                        }
                    }
                }
            }

            if(i<n){
                for(i=i;i<n;i++) {
                    if (arr1[i] == 0)
                        k++;
                    if (arr1[i] > k)
                        isP = false;
                    ans.add(arr1[i]);
                }
            }
            else
            {
                for(j=j;j<m;j++) {
                    if(arr2[j]==0)
                        k++;
                    if(arr2[j]>k)
                        isP = false;
                    ans.add(arr2[j]);
                }
            }


            if(isP) {
                for (i = 0; i < ans.size(); i++) {
                    out.print(ans.get(i) + " ");
                }
            }
            else
                out.print(-1);
            out.println();

        }
        out.close();
    }

    static long gcd(long a, long b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static void ruffleSort(int[] a) {
        //ruffle
        int n = a.length;
        Random r = new Random();
        for (int i = 0; i < a.length; i++) {
            int oi = r.nextInt(n), temp = a[i];
            a[i] = a[oi];
            a[oi] = temp;
        }

        //then sort
        Arrays.sort(a);
    }

    static void ruffleSort(long[] a) {
        //ruffle
        int n = a.length;
        Random r = new Random();
        for (int i = 0; i < a.length; i++) {
            int oi = r.nextInt(n);
            long temp = a[i];
            a[i] = a[oi];
            a[oi] = temp;
        }

        Arrays.sort(a);
    }

    static class FastScanner {
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

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    static class Pair {
        long first, second;

        public Pair(long first, long second) {
            this.first = first;
            this.second = second;

        }
        //@Override
       /* public int compareTo(Pair o) {
            return Long.compare(first-second, o.first-o.second);
        }
        */
    }


}