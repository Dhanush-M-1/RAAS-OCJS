import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
        public static void main(String args[]) {
                Scanner sc = new Scanner(System.in);
                int n, m;
                n = sc.nextInt();
                m = sc.nextInt();
                boolean [] tag = new boolean [m + 1];
                for(int i = 0; i <= m; i ++) tag[i] = false;
                int cnt = 0;
                while( n > 0 ) {
                        n --;
                        int c;
                        c = sc.nextInt();
                        int x;
                        while( c > 0 ) {
                                c --;
                                x = sc.nextInt();
                                if( tag[x] == false )
                                        cnt ++;
                                tag[x] = true;
                        }
                }
                if( cnt == m )
                        System.out.println("YES");
                else
                        System.out.println("NO");
        }
}