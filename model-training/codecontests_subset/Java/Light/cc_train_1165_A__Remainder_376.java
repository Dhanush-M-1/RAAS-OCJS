//package bag;

import java.io.*;
import java.lang.reflect.Array;
import java.text.MessageFormat;
import java.util.*;

/**
 * Created by Enzo Cotter on 2019/4/30.
 */
public class Main {
    public static void main(String []args){
        Scanner input=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int  n=input.nextInt();
        int  x=input.nextInt();
        int  y=input.nextInt();
        String s="";
        s=input.next();
        int cnt=0;
        for(int i=n-x;i<n;i++) {
            if (i == n - y - 1) {
                if (s.charAt(i) != '1') {
                    cnt++;
                }
            }else if(s.charAt(i)=='1')cnt++;
        }
        System.out.print(cnt);
    }
}
