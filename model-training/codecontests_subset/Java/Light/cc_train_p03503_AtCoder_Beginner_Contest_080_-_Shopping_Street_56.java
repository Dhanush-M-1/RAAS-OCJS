import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        Reader r = new Reader();    
        int N = r.i();
        int[][] F = new int[N][];
        for(int i = 0; i < N; i++)
            F[i] = r.ii();
        int[][] P = new int[N][];
        for(int i = 0; i < N; i++)
            P[i] = r.ii();
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < 1024; i++){
            int prf = 0;               
            for(int j = 0; j < N; j++){
                int c = 0;
                for(int k = 0; k < 10; k++)
                    if(F[j][k]*bin(i, k) == 1)
                        c++;
                prf += P[j][c];
            }
            if(max < prf)
                max = prf;
        }
        println(max);
    }
    static void print(Object o){
        System.out.print(o.toString());
    }
    static void println(Object o){
        System.out.println(o.toString());
    }
    static int Int(String s){
        return Integer.parseInt(s);
    }
    static long Long(String s){
        return Long.parseLong(s);
    }
    static int bin(int n, int right){
        int temp = n >> right;
        return temp%2;
    }
    static class Reader extends BufferedReader{
        Reader(){
            super(new InputStreamReader(System.in));
        }
        String s() throws IOException{
            return readLine();
        }
        String[] ss() throws IOException{
            return s().split(" ");
        }
        int i() throws IOException{
            return Int(s());
        }
        int[] ii() throws IOException{
            String[] ss = ss();
            int size = ss.length;
            int[] ii = new int[size];
            for(int j = 0; j < size; j++) ii[j] = Int(ss[j]);
            return ii;
        }
        long l() throws IOException{
            return Long(s());
        }
        long[] ll() throws IOException{
            String[] ss = ss();
            int size = ss.length;
            long[] ll = new long[size];
            for(int j = 0; j < size; j++) ll[j] = Long(ss[j]);            
            return ll;
        }
    }
}
