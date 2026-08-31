import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

       int t= nextInt();
       while(t-->0){
           int n= nextInt();
           int arr[]= readIntArray();
           if((arr[0]+arr[1])<=arr[n-1]){
               println("1 2 "+n);
           }else
               println(-1);
       }
    }


// *********************************************************************************************** //

    public static String readLine() throws IOException{
        return br.readLine();
    }
    public static String[] readStringArray()throws  IOException{
        return br.readLine().split(" ");
    }
    public static int[] readIntArray()throws IOException{
        return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
    public static long[] readLongArray() throws IOException{
        return Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
    }
    public static long nextLong()throws IOException{
        return Long.parseLong(br.readLine().trim());
    }
    public static int nextInt()throws IOException{
        return Integer.parseInt(br.readLine().trim());
    }

    public static void println(String out){
        System.out.println(out);
    }

    public static void println(int out){
        System.out.println(out);
    }

    public static void println(double out){
        System.out.print(out);
    }

    public static void print(String out){
        System.out.print(out);
    }

    public static void print(int out){
        System.out.print(out);
    }

    public static void print(double out){
        System.out.print(out);
    }

    public static void print(long out){
        System.out.print(out);
    }

    public static void println(long out){
        System.out.println(out);
    }
}
