
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by sky on 15/6/18.
 * www.github.com/aakashjaiswal1
 * aakashjaiswal@hotmail.co.in
 * aakashjaiswal.in@gmail.com
 * people die if they are killed
 */
public class ea2 {
    public static void main(String[] args) {
        in = new FastReader();
       // System.out.println(fast_Multiply(3,9));
        int n=ni();
        int m=ni();
        int k=ni();
        long min=Long.MAX_VALUE;
        int[] arr=new int[n+1];
        for (int i=0;i<m;++i){
            int ele=ni();
            arr[ele+1]=arr[ele]-1;
        }

        l1:
        for (int i=1;i<=k;i++){
            int cost=ni();
            int count=0;
            int last_post=-1;
            int light=0;
            while (light<n){
                int next_tower=light+arr[light+1];
                if (next_tower<=last_post){
                    continue l1;
                }
                last_post=next_tower;
                light=last_post+i;
                ++count;
            }
            min=Math.min(min,(long)count*(long)cost);
        }
        if (min==Long.MAX_VALUE)
            min=-1;
        System.out.println(min);
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
    static final long MOD = (long)1e9+7;
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
