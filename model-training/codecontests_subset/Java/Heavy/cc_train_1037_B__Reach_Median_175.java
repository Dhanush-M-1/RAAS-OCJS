//package Contest507;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main507B {
    public static Scanner enter = new Scanner(System.in);
    public static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int n=enter.nextInt();
        int s=enter.nextInt();
        int[] mass=new int[n];
        for (int i = 0; i <n ; i++) mass[i]=enter.nextInt();
        Arrays.sort(mass);
        long ans=0;
        for (int i = 0; i <n ; i++) {
            if(i==n/2){
                ans+=Math.abs(mass[i]-s);
            }
            else if(i<n/2){
                if(mass[i]>s) ans+=Math.abs(mass[i]-s);
            }
            else{
                if(mass[i]<s) ans+=Math.abs(mass[i]-s);
            }
        }
        out.println(ans);
        out.close();
    }
}
