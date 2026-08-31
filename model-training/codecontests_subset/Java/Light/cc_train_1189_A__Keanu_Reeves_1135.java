import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.PrintWriter;
public class TestClass1 {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String s1="";
        int n1=0;
        int n0=0;
        
        for(int i=0;i<l;i++){
            if(s.charAt(i)=='0')
                n0++;
            else
                n1++;
        }
        if(n0==n1){
            System.out.println("2");
            System.out.println(s.charAt(0)+" "+s.substring(1));
        }else{
            System.out.println("1");
            System.out.println(s);
        }
       
    }    

}
class input{
    static void intArr(String[] s, int[] a){
        for(int i=0;i<s.length;i++)
            a[i]=Integer.parseInt(s[i]);
    }

    static void longArr(String[] s, long[] a){
        for(int i=0;i<s.length;i++)
            a[i]=Long.parseLong(s[i]);
    }
}
