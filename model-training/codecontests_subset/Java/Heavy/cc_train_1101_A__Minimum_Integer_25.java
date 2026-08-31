//  package CF;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ecf {
    public static void main(String[] args) {
        in = new FastReader();
        int q=ni();
        while (q-->0){
            int l=ni();
            int r=ni();
            int d=ni();
            long p;
            {
                int min = (int) ((double) r / (double) d);
                long ans = min * d;
                if (ans <= r) {
                    min++;
                    ans = min * d;
                }
                p=ans;
            }

            {
                int min = (int) ((double) l / (double) d);
                long ans = min * d;
                if (ans >= l) {
                    min--;
                    ans = min * d;
                }
                if (ans>0){
                    p=Math.min(p,ans);
                }
                if (d<l){
                    p=d;
                }
            }


            System.out.println(p);
        }
    }
    public static long binarySearch(long low, long high) {
        while (high - low > 1) {
            long mid = (high - low)/2 + low;
            //System.out.println(mid);
            if (works(mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return (works(low) ? low : high);
    }
    private static String toString(List<Integer> list) {
        StringBuilder result = new StringBuilder();
        for(int x : list) {
            result.append(x + " ");
        }
        return result.toString();
    }
    //     static long ncr(int n,int r)
//     {
//         if(n<0 || r<0 || n<r)
//             return 0;
//         return nCr[n][r];
//     }
    public static void sortbyColumn(int arr[][], int col)
    {
        //this method is taken from geeks for geeks
        // Using built-in sort function Arrays.sort
        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            // Compare values according to columns
            public int compare(final int[] entry1,
                               final int[] entry2) {

                // To sort in descending order revert
                // the '>' Operator
                if (entry1[col] > entry2[col])
                    return 1;
                else
                    return -1;
            }
        });  // End of function call sort().
    }

    private static Set<Integer> getPrime(int value) {

        Set<Integer> set = new HashSet<>();
        for (int i = 2;i * i <= value;i ++) {
            if (value % i == 0) {
                while (value % i == 0) {
                    value /= i;
                }
                set.add(i);
            }
        }
        if (value > 1) {
            set.add(value);
        }
        return set;

    }
    static class Graph{
        ArrayList<Integer> al_array[];
        int nodes;
        Graph(int no){
            this.nodes=no;
            this.al_array=new ArrayList[no];
            for (int i=0;i<no;i++){
                al_array[i]=new ArrayList<>();
            }
        }
        void addDir(int i,int j){
            this.al_array[i].add(j);
        }
        void addUndir(int i,int j){
            this.al_array[i].add(j);
            this.al_array[j].add(i);
        }
        Graph compliment(){
            Graph com=new Graph(this.nodes);
            for (int i=0;i<this.nodes;i++){
                ArrayList<Integer> al=this.al_array[i];
                for (int j=0;j<al.size();j++){
                    int node=al.get(j);
                    com.addDir(node,i);
                }
            }
            return com;
        }

    }
    static void  printLN2DArray(int[][] arr){
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static long fast_exp_with_mod(long base, long exp) {
        long MOD=1000000000+7;
        long res=1;
        while(exp>0) {
            if(exp%2==1) res=(res*base)%MOD;
            base=(base*base)%MOD;
            exp/=2;
        }
        return res%MOD;
    }
    public static long gcd(long a, long b)
    {
        if (a == 0)
            return b;
        return gcd(b%a, a);
    }
    static class my_no{
        long num;
        long denom;

        @Override
        public String toString() {
            if (denom<0){
                this.num=-this.num;
                this.denom=-this.denom;
            }
            if (num==0)return "0";
            return (num+"/"+denom);
        }

        my_no(int no){
            this.num=no;
            this.denom=1;
        }
        my_no(long num,long denom){
            this.num=num;
            this.denom=denom;
        }

        my_no multiply(my_no obj){
            long num1=obj.num;
            long denom1=obj.denom;
            long n=num1*num;
            long d=denom1*denom;
            long gcd=gcd(n,d);
            n/=gcd;
            d/=gcd;
            return new my_no(n,d);

        }
//        my_no multiply(my_no obj){
//            long num1=obj.num;
//            long denom1=obj.denom;
//            long num2=this.num;
//            long denom2=this.denom;
//
//        }

        my_no multiply(int no){
            long n=num*no;
            long d=denom;
            long gcd=gcd(n,d);
            n/=gcd;
            d/=gcd;
            return new my_no(n,d);

        }
    }

    static void memset(int[][] arr,int val){
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                arr[i][j]=val;
            }
        }
    }
    static void memset(int[] arr,int val){
        for (int i=0;i<arr.length;i++){
            arr[i]=val;
        }
    }


    static void memset(long[][] arr,long val){
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                arr[i][j]=val;
            }
        }
    }
    static void memset(long[] arr,long val){
        for (int i=0;i<arr.length;i++){
            arr[i]=val;
        }
    }
    static private boolean works(long test){
        return true;
    }


    static void reverse(char[] arr ,int i,int j){
        if (i==j)
            return;
        while (i<j){
            char temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            ++i;
            --j;
        }
    }
    static int[]  takeIntegerArrayInput(int no){
        int[] arr=new int[no];
        for (int i=0;i<no;++i){
            arr[i]=ni();
        }
        return arr;
    }
    static long fast_Multiply(long no , long pow){
        long result=1;
        while (pow>0){
            if ((pow&1)==1){
                result=result*no;
            }
            no=no*no;
            pow>>=1;
        }
        return result;
    }

    static long[]  takeLongArrayInput(int no){
        long[] arr=new long[no];
        for (int i=0;i<no;++i){
            arr[i]=ni();
        }
        return arr;
    }
    static final long MOD = (long)20011;
    static FastReader in;


    static void p(Object o){
        System.out.print(o);
    }

    static void pn(Object o){
        System.out.println(o);
    }

    static String n(){
        return in.next();
    }

    static String nln(){
        return in.nextLine();
    }

    static int ni(){
        return Integer.parseInt(in.next());
    }

    static int[] ia(int N){
        int[] a = new int[N];
        for(int i = 0; i<N; i++)a[i] = ni();
        return a;
    }

    static long[] la(int N){
        long[] a = new long[N];
        for(int i = 0; i<N; i++)a[i] = nl();
        return a;
    }

    static long nl(){
        return Long.parseLong(in.next());
    }

    static double nd(){
        return Double.parseDouble(in.next());
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while (st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine(){
            String str = "";
            try{
                str = br.readLine();
            }catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
    static void println(String[] arr){
        for (int i=0;i<arr.length;++i){
            System.out.println(arr[i]);
        }
    }

}
