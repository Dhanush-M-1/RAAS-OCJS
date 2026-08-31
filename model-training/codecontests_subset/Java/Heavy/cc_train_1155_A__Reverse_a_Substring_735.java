import java.util.*;
import java.lang.*;
import java.io.*;

public class SUBS {
    public static void main(String[] Args){
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        scan.nextLine();
        String s=scan.nextLine();
        StringBuilder build=new StringBuilder(s);
        boolean flag=false;
        for (int i = 1; i <n ; i++) {
            if(build.charAt(i)<build.charAt(i-1)){
//                char ch=build.charAt(i-1);
//                build.setCharAt(i-1,build.charAt(i));
//                build.setCharAt(i,ch);
                System.out.println("YES");
                System.out.println((i)+" "+(i+1));
                flag=true;
                break;
            }
        }
        if(!flag){
            System.out.println("NO");
        }
    }
}