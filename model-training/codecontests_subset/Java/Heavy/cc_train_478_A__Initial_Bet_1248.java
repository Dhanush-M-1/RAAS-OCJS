import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author таня
 */
public class KF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
A jk = new A();
    }
}

class A{
 PrintWriter out = new PrintWriter(System.out);
    Scanner in = new Scanner(System.in);
    int ar[]= new int[5];
    A(){
        int s=0;
    for(int i=0;i<5;i++){
        ar[i]=in.nextInt();
    s+=ar[i];
    }
    Arrays.sort(ar);
    if(s%5==0){
        if(s==0){
         out.print(-1);
   out.flush();
   return;
        }
 out.print(s/5);
        }
    else{
    out.print(-1);
    }
    out.flush();
    }
    boolean test(int ans){
        int ost=0;
        if(ans>ar[0])
        {
        return false;
        } else{ 
            ost=ar[0]-ans;
            ar[0]=ans;
            if(ost<0){return false;}
        for(int i=1;i<5;i++){
    if(ar[i]>=ans){
    ost+=ar[i]-ans;
    ar[i]=ans;
    }else{
    ost-=(ans-ar[i]);
    if(ost<0){
    return false;
    }
    }
    }
        }
        return true;
    }
}