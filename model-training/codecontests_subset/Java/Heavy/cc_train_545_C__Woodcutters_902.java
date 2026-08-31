import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class c {
    static class Escanner{
        BufferedReader in;
        StringTokenizer st;
        Escanner()throws Throwable{
            in = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }
        int nextInt() throws Throwable{
            if(st.hasMoreTokens()) return Integer.parseInt(st.nextToken());
            st = new StringTokenizer(in.readLine());
            return nextInt();
        }
        double nextDouble() throws Throwable{
            if(st.hasMoreTokens()) return Double.parseDouble(st.nextToken());
            st = new StringTokenizer(in.readLine());
            return nextDouble();
        }
        String nextStr() throws Throwable{
            if(st.hasMoreTokens()) return st.nextToken();
            st = new StringTokenizer(in.readLine());
            return nextStr();
            
        }
    }
    public static void main(String[] args) throws Throwable {
        Escanner sc = new Escanner();
        int n = sc.nextInt();
        tree[] trees = new tree[n];
        for(int i=0;i<n;i++)
            trees[i] = new tree(sc.nextInt(), sc.nextInt());
        int ans;
        if(n==1)
            ans=1;
        else
            ans=2;
        trees[0].s=1;
        trees[n-1].s=2;
        for(int i=1;i<n-1;i++){
            tree t = trees[i];
            int leftx;
            if(trees[i-1].s==2)
                leftx = trees[i-1].x+trees[i-1].h;
            else
                leftx=trees[i-1].x;
            int rightx = trees[i+1].x;
            if(t.x-t.h>leftx){
                ans++;
                trees[i].s = 1;
                continue;
            }
            if(t.x+t.h<rightx){
                ans++;
                trees[i].s = 2;
                continue;
            }
                
        }
        System.out.println(ans);
    }
}
class tree{
    int s,x,h;
    public tree(int a,int b){
        x=a;
        h=b;
        s=0;
    }
}
