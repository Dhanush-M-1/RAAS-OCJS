import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import static java.lang.System.out;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;




public class JavaApplication79 {
 

    
    public static void main(String[] args) throws java.lang.Exception {
                Reader.init(System.in);

int n=Reader.nextInt(),k=Reader.nextInt();
int ar[]=new int[n+1];
boolean b=false;
int count=0,index=0,i=0;
        for ( i = 1; i <= n; i++) {
            ar[i]=Reader.nextInt();
            count+=i;
            if(count>=k){index=i;count=count-i;i++;break;}
            
        }
        
        for (int j =i ; j < n; j++) 
        ar[j]=Reader.nextInt();
        
        for (int j = 1; j <= index; j++) {
                                                       count++;

           if (count==k){System.out.println(ar[j]);break;}


                
            
        }
            
        
         
     
        
    }}
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;
    static void init(InputStream input) {
        reader = new BufferedReader(new InputStreamReader(input));
        tokenizer = new StringTokenizer("");
    }
    static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    } 
    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    } 
    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    } 
}