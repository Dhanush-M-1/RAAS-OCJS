import java.util.*;
import java.math.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

     //--------------->>>>IF YOU ARE HERE FOR QUICKSORT HACK THEN SORRY NO HACK FOR YOU<<<-------------------

public class a{ 
     static int[] count,count1,count2;
     static Node[] nodes;
     static int[] arr;
     static int[] dp;
     static char[] ch,ch1;
     static int[] darr,farr;
     static Character[][] mat,mat1;
     static long x,h;
     static long maxl;
     static double dec;
     static String s;
     static long minl;
     static int mx = (int)1e9+5;
     static long mod = 998244353l;
     // static int minl = -1;
     // static long n;
     static int n,n1,n2;
     static long a;
     static long b;
     static long c;
     static long d;
     static long y,z;
     static int m;
     static long k;
     static String[] str,str1;
     static Set<Long> set,set1,set2;
     static List<Integer> list1,list2,list3;
     static LinkedList<Node> ll;
     static Map<String,String> map;
     static StringBuilder sb,sb1,sb2;
     static int[] dx = {0,-1,0,1};
     static int[] dy = {-1,0,1,0};

     // public static void solve(){

     //    FastScanner sc = new FastScanner();

     //    long n = sc.nextLong();
     //    long m = sc.nextLong();

     //    for(int i = 0 ; i < m ; i++){

     //        long x = sc.nextLong();
     //        long y = sc.nextLong();

     //        long ans = 0;
     //        if(n%2 == 0){
     //            ans = (y+1)/2 + (n/2) * (x-1);
     //        }
     //        else{

     //            if(x%2 == 1){
     //                ans = (x-1)/2 * n + (y+1)/2;
     //            }
     //            else{
     //                ans = (x-2)/2 * n + (n+1)/2 + (y+1)/2 - (y%2);
     //            }
     //        }

     //        if((x+y)%2 != 0)
     //            ans += ((n*n + 1)/2);

     //        System.out.println(ans);

     //    }

        
     // }

     //--------------->>>>IF YOU ARE HERE FOR QUICKSORT HACK THEN SORRY NO HACK FOR YOU<<<-------------------


     public static void solve(){

        sb = new StringBuilder();
        int count = 0;
        if(mat[0][1] == '1' && mat[1][0] == '1'){
            if(mat[n-2][n-1] == '1'){
                count += 1;
                sb.append((n-1) + " " + n+"\n");
            }
            if(mat[n-1][n-2] == '1'){
                count += 1;
                sb.append((n) + " " + (n-1)+"\n");
            }
            System.out.println(count);
            System.out.print(sb);
            return;
        }

        if(mat[0][1] == '0' && mat[1][0] == '0'){
            if(mat[n-2][n-1] == '0'){
                count += 1;
                sb.append((n-1) + " " + n+"\n");
            }
            if(mat[n-1][n-2] == '0'){
                count += 1;
                sb.append((n) + " " + (n-1)+"\n");
            }
            System.out.println(count);
            System.out.print(sb);
            return;
        }

        if(mat[n-1][n-2] != mat[n-2][n-1]){
            count += 1;
            sb.append((n-1) + " " + n+"\n");
        }

        if(mat[0][1] == mat[n-1][n-2]){
            count += 1;
            sb.append((1) + " " + "2"+"\n");
        }
        if(mat[1][0] == mat[n-1][n-2]){
            count += 1;
            sb.append((2) + " " + "1"+"\n");
        }

        System.out.println(count);
        System.out.print(sb);

     }

     public static void main(String[] args) {

            FastScanner sc = new FastScanner();
            // Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            // int t = 1;
            // int l = 1;
            while(t > 0){
                
                // n = sc.nextInt();
                // n = sc.nextLong();
                // a = sc.nextLong();
                // b = sc.nextLong();
                // c = sc.nextLong();
                // d = sc.nextLong();

                // x = sc.nextLong();
                // y = sc.nextLong();
                
                // n = sc.nextLong();
                n = sc.nextInt();
                // n1 = sc.nextInt();

                // m = sc.nextInt();

                // k = sc.nextLong();
                // s = sc.next();

                // ch = sc.next().toCharArray();
                // ch1 = sc.next().toCharArray();

                // arr = new int[n];
                // for(int i = 0 ; i < n ; i++){
                //     arr[i] = sc.nextInt();
                // }
                // m = n;
                // darr = new int[m];
                // for(int i = 0; i < m ; i++){
                //     darr[i] = sc.nextInt();
                // }

                // farr = new int[n];
                // for(int i = 0; i < n ; i++){
                //     farr[i] = sc.nextInt();
                // }

                mat = new Character[n][n];
                for(int i = 0 ; i < n ; i++){
                    String s = sc.next();
                    for(int j = 0 ; j < n ; j++){
                        mat[i][j] = s.charAt(j);
                    }
                }
                // str = new String[n];
                // for(int i = 0 ; i < n ; i++)
                //     str[i] = sc.next();

                // nodes = new Node[n];
                // for(int i = 0 ; i < n ;i++)
                //     nodes[i] = new Node(sc.nextInt(),sc.nextInt());

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

    public static boolean isPrime(long n) { 
    // Corner cases 
        if (n <= 1)  
            return false; 

        if (n <= 3)  
            return true; 
      
        // This is checked so that we can skip  
        // middle five numbers in below loop 
        if (n%2 == 0 || n%3 == 0) 
            return false; 
      
        for (int i=5; i*i<=n; i=i+6) 
            if (n%i == 0 || n%(i+2) == 0) 
               return false; 
      
        return true; 
    } 

     public static long gcd(long a,long b){

        if(b%a == 0){
            return a;
        }
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