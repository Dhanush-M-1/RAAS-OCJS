import java.util.*;
import java.io.*;
public class code{
    
    public static void main(String[] args)throws IOException{
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for(int i=0;i<q;i++){
            long l = sc.nextLong();
            long r = sc.nextLong();
            long d = sc.nextLong();
            if(d<l||d>r) System.out.println(d);
            else{
                long s = d*(r/d+1);
                System.out.println(s);
            }
        }
    }
}