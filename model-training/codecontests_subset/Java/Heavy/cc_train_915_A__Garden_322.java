// Working program with FastReader
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
import java.lang.Math;
import java.io.*;

public class Main {
/********************************************************************************/
static class FastReader {
BufferedReader br; StringTokenizer st;
public FastReader(){br = new BufferedReader(new InputStreamReader(System.in));}
String next() { while (st == null || !st.hasMoreElements()){
try { st = new StringTokenizer(br.readLine());}
catch (IOException e) { e.printStackTrace();}}
return st.nextToken();} int nextInt(){ return Integer.parseInt(next());}
long nextLong() { return Long.parseLong(next());}
float nextFloat(){return Float.parseFloat(next());}
double nextDouble() { return Double.parseDouble(next());}
String nextLine() { String str = ""; try { str = br.readLine();}
catch (IOException e) { e.printStackTrace(); } return str;}
}
/*******************************************************************************/
public static void main(String[] args) {
FastReader sc = new FastReader();
int n = sc.nextInt();
int k = sc.nextInt();
int[] arr = new int[n];
for(int i = 0;i<n;i++){
    arr[i] = sc.nextInt();
}
Arrays.sort(arr);
int divisor = 0;
for(int i = 0;i<n;i++){
    if(k%arr[i]==0){
        divisor = arr[i];
    }
}
System.out.println(k/divisor);
}
}
