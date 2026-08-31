// Why do we fall ? So we can learn to pick ourselves up.
import java.util.*;
public class solve {
    static int mod = 1000000007;
    static int mod1 = 998244353;
    public static void  main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] p = new int[n];
            ArrayList<Integer> ans = new ArrayList<>();
            for(int i=0; i<n; i++) {
                p[i] = sc.nextInt();
            }
            int cc = 1;
            for(int i=1; i<n; i++){
                if(p[i] == p[i-1]){
                    cc++;
                }else{
                    ans.add(cc);
                    cc = 1;
                }
            }
            ans.add(cc);
            int bb = -1, ss = 0, req = n/2;
            for(int i=0; i<ans.size(); i++){
                if(ss+ans.get(i)<=req){
                    ss += ans.get(i);
                }else{
                    bb = i;
                    break;
                }
            }
            int g = ans.get(0),s=0,b=0;
            for(int i=1; i<bb; i++){
                if(s <= g){
                    s += ans.get(i);
                }else {
                    b += ans.get(i);
                }
            }
            if(g+s+b <= req && g<s && g<b){
                System.out.println(g+" "+s+" "+b);
            }else {
                System.out.println("0 0 0");
            }
        }
    }
}