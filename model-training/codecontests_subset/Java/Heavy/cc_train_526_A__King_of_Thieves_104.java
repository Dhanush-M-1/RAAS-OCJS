import java.io.*;
import java.util.*;
public class Main {
    public static void main(String args[]) {
        Cf526 hehe=new Cf526();
        hehe.solve();
    }
}

class Cf526 {
    void solve() {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        String str=in.next();
        boolean vis[]=new boolean[str.length()];
        Arrays.fill(vis, false);
        for(int i=0;i<str.length();i++) {
            if(str.charAt(i)=='*') {
                vis[i]=true;
            }
        }
        boolean flag=false;
        for(int i=0;i<str.length();i++) {
            for(int j=1;j*4+i<str.length();j++) {
                if(str.charAt(i)=='*'&&str.charAt(i+j)=='*'&&str.charAt(i+j*2)=='*'&&str.charAt(j*3+i)=='*'&&str.charAt(i+4*j)=='*') {
                    flag=true;
                }
            }
        }
        if(flag) System.out.println("yes");
        else System.out.println("no");
    }
}
