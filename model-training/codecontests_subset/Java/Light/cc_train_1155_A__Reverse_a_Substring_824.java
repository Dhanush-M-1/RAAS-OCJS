//package ContestEd63;

import java.io.PrintWriter;
import java.util.Scanner;

public class mainC {
    public static Scanner enter = new Scanner(System.in);
    public static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) {
        int n=enter.nextInt();
        String s=enter.next();
        for (int i = 1; i <s.length() ; i++) {
            if(s.charAt(i)-s.charAt(i-1)<0){
                System.out.println("YES");
                System.out.println((i)+" "+(i+1));
                return;
            }
        }
        System.out.println("NO");
    }
}
