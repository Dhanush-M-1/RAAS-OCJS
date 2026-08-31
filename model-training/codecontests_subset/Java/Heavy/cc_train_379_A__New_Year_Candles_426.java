import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class IDontKnow {
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
        static class Gdc{
            static int gdc(int x, int y){
                if(x%y==0){
                    return y;
                }else{
                    return gdc(y, x%y);
                }
            }
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            /*
            int simonScor = in.nextInt();
            int antisimonScor = in.nextInt();
            int countRock = in.nextInt();
            for(int turn = 0; true; turn=(turn==0 ? 1 : 0)){
                int needed = (turn==0 ? simonScor : antisimonScor);
                if(countRock<needed){
                    if(turn==0){
                        out.println(1);
                    }else{
                        out.println(0);
                    }
                    return;
                }
                countRock-= Gdc.gdc(countRock, simonScor);

            }
            */
            int a = in.nextInt();
            int b = in.nextInt();
            int answer = a;
            int extra = 0;
            do{
                a+=extra;
                extra=a%b;
                a/=b;
                answer+=a;
            }while(a+extra>=b);
            out.println(answer);
        }

    }
    static class InputReader {
        BufferedReader br;
        StringTokenizer st;
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
        public int nextInt()  {
            return Integer.parseInt(next());
        }
        public long nextLong(){
            return Long.parseLong(next());
        }
        public Double nextDouble(){
            return Double.parseDouble(next());
        }
        public Byte nextByte() {
            return Byte.parseByte(next());
        }
       // public Character nextChar() {return next().charAt(0);}
        public void newFile() {
            try {
                FileWriter write = new FileWriter(file);
                write.write(1);
                write.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
