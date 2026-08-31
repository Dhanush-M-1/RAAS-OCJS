import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Cs {
    public static void main(String[] args) throws Exception{

//        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new
//                FileOutputStream(java.io.FileDescriptor.out), "ASCII"), 512);

        FastReader in = new FastReader();
        OutputStream outputStream = System.out;
        PrintWriter out = new PrintWriter(outputStream);


        int i,j,n,m,k,l,a,b;
        int[] arr = new int[2];


        n = in.nextInt();
        String s;
        s = in.nextLine();
        l = s.length();
        for (i=0;i<l; i++){
            if (s.charAt(i) == 'A'){
                arr[0] ++;
            }
            else if (s.charAt(i) == 'I'){
                arr[1] ++;
            }
        }

        if (arr[1] == 0){
            out.print(arr[0]);
        }
        else if (arr[1] == 1){
            out.print(1);
        }
        else
            out.print(0);
        out.flush();




//        long start = System.currentTimeMillis();
//        for (i = 0; i < 100000; i++) {
//            out.print("abcdefghijk ");
//            out.print(String.valueOf(i));
//            out.print('\n');
//        }
//        out.flush();
//        System.err.println("Loop time: " +
//                (System.currentTimeMillis() - start));


//        for (i = 0; i < 1000000; i++) {
//            System.out.print("lkjhglkjh");
//            System.out.print(String.valueOf(i));
//            System.out.println();
//        }
//        System.out.println("Loop time " + (System.currentTimeMillis() - start));
        // 13480

        out.flush();

    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}
