import java.io.*;
import java.util.*;

public class naloga1{
    static BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
    // static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) throws Exception{
        int a=Integer.parseInt(in.readLine());
        int b=Integer.parseInt(in.readLine());
        int middle=(a+b)/2;
        int d1=Math.abs(a-middle);
        int d2=Math.abs(middle-b);
        int zmatral=(d1*(d1+1))/2+(d2*(d2+1))/2;
        System.out.println(zmatral);
    }
}
