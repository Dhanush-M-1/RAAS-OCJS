import java.util.*;
import java.io.*;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args)throws IOException{
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        if(s.equals("keyence")){
            System.out.println("YES");
            return;
        }
        int n = s.length();
        boolean ans=false;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                String cur = s.substring(0,i)+s.substring(j+1,n);
                ans |= cur.equals("keyence");
            }
        }
        String res = ans?"YES":"NO";
        System.out.println(res);
    }
}
