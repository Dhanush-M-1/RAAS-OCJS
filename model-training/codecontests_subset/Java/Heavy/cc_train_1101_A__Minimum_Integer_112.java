

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


public class Question {

    static int[] sum_arr;
    static LinkedList[] nArr;
    static boolean[] visited;
    static int[] a;


    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        int n = Reader.nextInt();
        for (int i = 0 ; i < n ; i++){
            int l = Reader.nextInt();
            int r = Reader.nextInt();
            int d = Reader.nextInt();

            if (d < l ){
                System.out.println(d);
            }
            else{
                System.out.println((r-(r%d))+d);
            }
        }







    }

    public void replace(char[] arr,char a, char b , int num){

    }

    public static void dfs(int i,int sum ){
        System.out.println(i);
        visited[i] = true;
        System.out.println("Sum" + sum);
        int prev = i;
        if (sum_arr[i]!=-1) {
            a[i] = sum_arr[i] - sum;
            System.out.println("a[i]" + i);
            sum+=a[i];
        }
        else{
            a[i] = 0;
        }

        if (a[i]<0){
            System.out.println(-1);
            System.exit(0);
        }


        for (int j = 0 ; j < nArr[i].size(); j++){
            int num = (int)nArr[i].get(j);
            if (num!=0 && !visited[num]){
                dfs(num,sum);
            }
        }
    }


}



class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            ///TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                    reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }
}
