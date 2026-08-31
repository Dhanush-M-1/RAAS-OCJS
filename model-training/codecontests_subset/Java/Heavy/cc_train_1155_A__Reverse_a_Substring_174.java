import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a{ 
     static long[] count,count1;
     static long[] arr;
     static char[] ch,ch1;
     static long[] darr;
     static long[][] mat,mat1;
     static int x;
     static long maxl;
     static double dec;
     static String s;
     static long minl;
     static int mx = (int)1e6;
     static long mod = 998244353l;
     // static int minl = -1;
     // static long n;
     static int n,n1,n2;
     static long a,g;
     static long b;
     static long c;
     static long d;
     static int y,z;
     static int m;
     static long k;
     static int q;
     static String[] str,str1;
     static Set<Long> set,set1;
     static List<Integer> list;
     static Map<String,Integer> map;
     static StringBuilder sb;

     public static void solve(){

       int maxl = 27;
       maxl = ch[0] - 'a'; 
       int index = 1;

       for(int i = 1 ; i < n ; i++){
            if((ch[i]-'a') < maxl){
                System.out.println("YES");
                System.out.println((index) + " "+ (i+1));
                return;
            }
            if(maxl < (ch[i]-'a')){
                maxl = ch[i] - 'a';
                index = i+1;
            }
       }

       System.out.println("NO");


     }

     public static void main(String[] args) {

            FastScanner sc = new FastScanner();
            // Scanner sc = new Scanner(System.in);
            // int t = sc.nextInt();
            int t = 1;
            while(t > 0){
                
                // x = sc.nextLong();
                // y = sc.nextLong();
                // z = sc.nextLong();
                
                // a = sc.nextLong();
                // b = sc.nextLong();
                // c = sc.nextLong();
                // d = sc.nextLong();
                // n = sc.nextLong();
                n = sc.nextInt();
                // y = sc.nextInt();
                // x = sc.nextInt();
                
                // a = sc.nextLong();
                // x = sc.nextLong();
                // b = sc.nextLong();
                
                // y = sc.nextLong();
                // n1 = sc.nextInt();
                // n = sc.nextLong();

                // k = sc.nextLong();
                
                ch = sc.next().toCharArray();
                // ch1 = sc.next().toCharArray();

                // m = sc.nextInt();
                // k = sc.nextLong();
                 
                // arr = new long[n];
                // for(int i = 0; i < n ; i++){
                //     arr[i] = sc.nextLong();
                // }

                // n1 = sc.nextInt();
                //  darr = new long[n1];
                //  for(int i = 0; i < n1 ; i++){
                //      darr[i] = sc.nextLong();
                //  }

                // mat = new long[n][m];

                // for(int i = 0 ; i < n ; i++){
                //     for(int j = 0 ; j < m ; j++){
                //         mat[i][j] = sc.nextLong();
                //     }
                // }
                // str = new String[n];
                // for(int i = 0 ; i < n ; i++)
                //     str[i] = sc.next();

                // System.out.println(solve()?"YES":"NO");
                 solve();       
                 // System.out.println(solve());

                 t -= 1;
            }

     }

    public static int log(long n){

         if(n == 0 || n == 1)
             return 0;

         if(n == 2)
             return 1;

         double num = Math.log(n);
         double den = Math.log(2);

         if(den == 0)
             return 0;

         return (int)(num/den);
     }

     public static long gcd(long a,long b){

        if(b%a == 0)
            return a;

        return gcd(b%a,a);

     }

     // public static void swap(int i,int j){
     //     long temp = arr[j];
     //     arr[j] = arr[i];
     //     arr[i] = temp;
     // } 

    static final Random random=new Random();
    
    static void ruffleSort(long[] a) {
        int n=a.length;//shuffle, then sort 
        for (int i=0; i<n; i++) {
            int oi=random.nextInt(n);
            long temp=a[oi];
            a[oi]=a[i]; a[i]=temp;
        }
        Arrays.sort(a);
    }

    static class Node{
        int first;
        int second;
        Node(int f,int s){
            this.first = f;
            this.second = s;
        }
    }

     static class FastScanner {

                BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st=new StringTokenizer("");
                String next() {
                        while (!st.hasMoreTokens())
                                try {
                                        st=new StringTokenizer(br.readLine());
                                } catch (IOException e) {
                                        e.printStackTrace();
                                }
                        return st.nextToken();
                }
                
                int nextInt() {
                        return Integer.parseInt(next());
                }
                int[] readArray(int n) {
                        int[] a=new int[n];
                        for (int i=0; i<n; i++) a[i]=nextInt();
                        return a;
                }
                long nextLong() {
                        return Long.parseLong(next());
                }
        }

}