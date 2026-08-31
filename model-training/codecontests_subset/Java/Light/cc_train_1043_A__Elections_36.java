//package Contest519;

import java.io.PrintWriter;
import java.util.Scanner;

public class mainA {
    public static Scanner enter = new Scanner(System.in);
    public static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) {
        int n=enter.nextInt();
        int ans=0;
        int max=0;
        for (int i = 0; i <n ; i++) {
            int tmp=enter.nextInt();
            ans+=tmp;
            max=Math.max(tmp,max);
        }
        //System.out.println(ans);
        ans=Math.max((2*ans/n)+1,max);
        out.println(ans);
        out.close();
    }
}
