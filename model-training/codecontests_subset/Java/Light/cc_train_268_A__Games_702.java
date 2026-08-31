import java.util.*;
import java.io.*;

public class solution{
        public static boolean helloStr(String str){
            
            return false;
        }
        public static void main( String args[] ) throws IOException{
        
        // System.setIn(new FileInputStream(new File("input.txt")));
        // System.setOut(new PrintStream(new File("output.txt")));

        Scanner sc = new Scanner(System.in);
        //int t=sc.nextInt();
        //while(t-->0){
            int n=sc.nextInt();
            int[] h=new int[n];
            int[] a=new int[n];
            for(int i=0;i<n;i++){
                h[i]=sc.nextInt();
                a[i]=sc.nextInt();
            }
            int count=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(h[i]==a[j])
                        count++;
                }
            }
            System.out.println(count);
            
        //}
        sc.close();
    }
}



