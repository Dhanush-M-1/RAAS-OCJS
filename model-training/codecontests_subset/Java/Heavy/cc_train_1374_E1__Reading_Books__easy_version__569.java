import java.util.*;
import java.io.*;
public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int tt=0;tt<1;tt++) {
            String[] str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int k = Integer.parseInt(str[1]);
            ArrayList<Integer> a = new ArrayList<>();
            ArrayList<Integer> b = new ArrayList<>();
            ArrayList<Integer> c = new ArrayList<>();
            for(int i=0;i<n;i++) {
                str = br.readLine().split(" ");
                int t = Integer.parseInt(str[0]);
                int x = Integer.parseInt(str[1]);
                int y = Integer.parseInt(str[2]);
                if(x==1 && y==1) {
                    c.add(t);
                } else if(x==1) {
                    a.add(t);
                } else if(y==1) {
                    b.add(t);
                }
            }
            if((a.size()+c.size())<k)
            {
                System.out.println(-1);
                continue;
            }
            if((b.size()+c.size())<k)
            {
                System.out.println(-1);
                continue;
            }
            Collections.sort(a);
            Collections.sort(b);
            Collections.sort(c);
            int ans = 0;
            int astart = 0;
            int cstart = 0;
            while(k>=1) {
                int op1 = Integer.MAX_VALUE;
                int op2 = Integer.MAX_VALUE;
                if(astart<a.size() && astart<b.size()) {
                    op1 = a.get(astart) + b.get(astart);
                }
                if(cstart<c.size()) {
                    op2 = c.get(cstart);
                }
                if(op1<op2) {
                    ans = ans + op1;
                    astart++;
                } else {
                    ans = ans + op2;
                    cstart++;
                }
                k--;
            }
            System.out.println(ans);
        }
    }
}