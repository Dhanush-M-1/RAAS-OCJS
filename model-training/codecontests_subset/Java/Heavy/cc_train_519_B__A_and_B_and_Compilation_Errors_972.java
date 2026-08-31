import java.io.*;
import java.util.*;

public class Main {
    public static void main(String [] args){
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Integer readFromFile=new Integer(1);
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }
    static class TaskD {
        final int MAX = 100_005;
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int sum1 = 0;
            for(int i=0; i<n; i++){
                sum1^=in.nextInt();
            }
            int sum2 = 0;
            for(int i=0; i<n-1; i++){
                int a = in.nextInt();
                sum1^=a;
                sum2^=a;
            }
            out.println(sum1);
            for(int i=0; i<n-2; i++){
                sum2^=in.nextInt();
            }
            out.println(sum2);
        }
    }
    static class InputReader {
        BufferedReader br;
        StringTokenizer st;
        String st1;
        File file = new File("text.txt");
        public InputReader(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
            st = null;
        }
        public InputReader(int i) {
            try {
                br  = new BufferedReader(
                        new InputStreamReader(new FileInputStream(file)));
            } catch (FileNotFoundException e1) {
                System.out.println("File is not find");
            }
            st = null;
        }
        public String next(){
            while (st==null || !st.hasMoreTokens()){
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }
        public String nextLine(){
            try {
                st1 = new String(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return st1;
        }
        public int nextInt()  {return Integer.parseInt(next());}
        public long nextLong(){
            return Long.parseLong(next());
        }
        public Double nextDouble(){
            return Double.parseDouble(next());
        }
        public Byte nextByte() {
            return Byte.parseByte(next());
        }
        private int idx;
        public Character nextChar() {
            if(st1==null) {
                st1 = next();
                idx = 0;
            }
            if(idx!=(st1.length())-1){
                return st1.charAt(idx++);
            }else{
                char  c= st1.charAt(idx);
                st1 = null;
                return c;
            }
        }
        public void newFile() {
            try {
                FileWriter write = new FileWriter(file);
                write.write("something for cheaking");
                write.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}