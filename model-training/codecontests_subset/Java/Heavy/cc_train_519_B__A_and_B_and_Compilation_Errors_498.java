import java.io.*;
import java.util.*;

public class BMain {
    String noResultMessage = "NoResult";
    Parser in = new Parser();
    PrintWriter out;

    long sum(long[] ar){
        long s = 0;
        for(long l : ar){
            s+= l;
        }
        return s;
    }

    public void solve() {
        int n = in.nextInteger();
        long a[] = in.nextLongs(n);
        long b[] = in.nextLongs(n - 1);
        long c[] = in.nextLongs(n - 2);

        out.println(sum(a) - sum(b));
        out.println(sum(b) - sum(c));
    }

    static public class Parser{
        Scanner scanner;

        public Parser() {
            scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);
        }

        public Parser(String str) {
            scanner = new Scanner(str).useLocale(Locale.ENGLISH);
        }

        long nextLong(){
            return scanner.nextLong();
        }

        int nextInteger(){
            return scanner.nextInt();
        }

        double nextDouble(){
            return scanner.nextDouble();
        }

        String nextLine(){
            return scanner.nextLine();
        }

        String next(){
            return scanner.next();
        }

        int[] nextIntegers(int count){
            int[] result = new int[count];
            for(int i = 0; i < count; ++i){
                result[i] = nextInteger();
            }
            return result;
        }

        long[] nextLongs(int count){
            long[] result = new long[count];
            for(int i = 0; i < count; ++i){
                result[i] = nextLong();
            }
            return result;
        }

        int[][] nextIntegers(int fields, int count){
            int[][] result = new int[fields][count];
            for(int c = 0; c < count; ++c){
                for(int i = 0; i < fields; ++i){
                    result[i][c] = nextInteger();
                }
            }
            return result;
        }
    }

    void noResult(){
        throw new NoResultException();
    }

    void noResult(String str){
        throw new NoResultException(str);
    }

    void run(){
        try{
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            out = new PrintWriter(System.out);
            solve();
            out.close();
            System.out.print(outStream.toString());
        } catch (NoResultException exc){
            System.out.print(null == exc.response ? noResultMessage : exc.response);
        }
    }

    public static void main(String[] args) {
        new BMain().run();
    }

    public static class NoResultException extends RuntimeException{
        private String response;

        public NoResultException(String response) {
            this.response = response;
        }

        public NoResultException() {
        }
    }
}
