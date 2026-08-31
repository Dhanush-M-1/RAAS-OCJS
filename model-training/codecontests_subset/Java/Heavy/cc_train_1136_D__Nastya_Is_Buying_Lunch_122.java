import java.io.*;
import  java.util.*;
import static java.lang.System.in;

public class Main{
    //static int n,m,D,count;
    //static ArrayList<Integer>[] graph;
    //static int[] id;
    public static void main(String[] args)throws IOException{
        //Scanner sc = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String[] buf = reader.readLine().split(" ");
        int n = Integer.parseInt(buf[0]), m = Integer.parseInt(buf[1]);
        buf = reader.readLine().split(" ");
        int[] a = new int[n];
        for(int i=0;i<n;i++) a[i] = Integer.parseInt(buf[i]);
        HashSet<Integer>[] whenFront = new HashSet[n+1];
        for(int i=0;i<=n;i++) whenFront[i] = new HashSet<>();
        for(int i=0;i<m;i++){
            buf = reader.readLine().split(" ");
            int u = Integer.parseInt(buf[0]), v = Integer.parseInt(buf[1]);
            whenFront[u].add(v);
        }
        ArrayList<Integer> block = new ArrayList<>();
        int target = a[n-1],ans = 0;
        for(int i=n-2;i>=0;i--){
            int cur = a[i];
            if(block.size()>whenFront[cur].size()||!whenFront[cur].contains(target)){
                block.add(cur);
                continue;
            }
            int cnt = block.size();
            for(int w:block){
                if(whenFront[cur].contains(w)) cnt--;
            }
            if(cnt==0) ans++;
            else block.add(cur);
        }
        System.out.println(ans);
    }
}
