
import java.util.*;
import java.io.*;
//harish reddy anumula
public class CodeForces{
    public static void main (String[] args)throws java.lang.Exception{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
        String[] z = br.readLine().split(" ");
        int r1 = Integer.parseInt(z[0]);
        int r2 = Integer.parseInt(z[1]);
        z = br.readLine().split(" ");
        int c1 = Integer.parseInt(z[0]);
        int c2 = Integer.parseInt(z[1]);
        z = br.readLine().split(" ");
        int d1 = Integer.parseInt(z[0]);
        int d2 = Integer.parseInt(z[1]);
        boolean ans = true;
        int a = (d1+r1-c2)/2;
        int b = (c2+d2-r2)/2;
        int c = (r2+d2-c2)/2;
        int d = (c2+d1-r1)/2;
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(a);set.add(b);set.add(c);set.add(d);
        int si = set.size();

        if(a<1 || b<1 || c<1 || d<1 || si!=4 || a>9 || b>9 || c>9 || d>9){
            ans = false;
        }
        else if(c1+c2 != d1+d2 || c1+c2!=r1+r2  || d1+d2!=r1+r2){
            ans = false;
        }
        if(ans) {
            pw.printf("%d %d\n", a, b);
            pw.printf("%d %d\n", c, d);
        }
        else{
            pw.println(-1);
        }
        pw.close();
    }
}