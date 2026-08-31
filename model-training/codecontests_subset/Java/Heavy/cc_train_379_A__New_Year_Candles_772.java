import java.io.*;
import java.util.*;
import java.*;
import java.math.BigInteger;
import java.util.Random;
 
import javax.naming.BinaryRefAddr;
import java.io.*;
import java.util.*;
import java.lang.*;
 
 
 
public class zad {
private static BufferedReader in;
private static StringTokenizer tok;
private static PrintWriter out;
final static boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") !=null;
 
public static void init() throws FileNotFoundException{
if(ONLINE_JUDGE){
in = new BufferedReader(new InputStreamReader(System.in));
out = new PrintWriter(System.out);
}
else{
in = new BufferedReader(new FileReader("input.txt"));
out = new PrintWriter("out.txt");
}
}
 
private static String readString() throws IOException {
while (tok == null || !tok.hasMoreTokens()) {
tok = new StringTokenizer(in.readLine());
}
return tok.nextToken();
}
 
private static int readInt() throws IOException {
return Integer.parseInt(readString());
}
private static double readDouble() throws IOException {
return Double.parseDouble(readString());
}
private static long readLong() throws IOException {
return Long.parseLong(readString());
}
private static float readFloat() throws IOException{
    return Float.parseFloat(readString());
}
 
 

static int gcd(int a, int b) {
    while (b != 0) {
            int r = a % b; 
           
            a = b;
            b = r;
    }
 
    return a;
}
 

 
public static void Solve() throws IOException{
    int a=readInt();
    int b = readInt();
    int k=0;
    int i=0;
    while(a>0){
        a--;
        i++;
        k++;
        if(k==b){
            k=0;
            a++;
        }
    }
    out.println(i);
}
    
    
 
public static void main(String[] args) throws IOException {
init();
Solve();
 
 
in.close();
out.close();
}
}