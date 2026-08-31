import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.HashSet;
public class KingsPath{
    static Set<String> vis;
    static Set<String> a;
    static int l = 1000000001;
    static int dx[] = {1,-1,0,0,1,1,-1,-1},
             dy[] = {0,0,1,-1,1,-1,1,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        a = new HashSet<String>();
        int x,y,x1,y1;
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(input.readLine());
        while(n-->0){
            int i,j1,j2;
            st = new StringTokenizer(input.readLine());
            i = Integer.parseInt(st.nextToken());
            j1 = Integer.parseInt(st.nextToken());
            j2 = Integer.parseInt(st.nextToken());
            for(int k=j1; k<=j2; k++)
                a.add(i+" "+k);
        }
        System.out.println(bfs(x,y,x1,y1));
    }
    public static int bfs(int x,int y,int x1,int y1){
        vis = new HashSet<String>();

        Queue<Node> q=new LinkedList<Node>();
        q.add(new Node(x,y,0));
        vis.add(x+" "+y);
        while(!q.isEmpty()){
            Node n = q.poll();
            if(n.x==x1 && n.y==y1)return n.t;
            for(int i=0; i<8; i++){
                int xx = n.x + dx[i];
                int yy = n.y + dy[i];
                 if(xx>=1 && yy>=1 && xx<l && yy<l &&!vis.contains(xx+" "+yy)&&a.contains(xx+" "+yy)){
                     vis.add(xx+" "+yy);
                     q.add(new Node(xx,yy,n.t+1));
                 }
             }
         }
         return -1;
     }

}
class Node{
    int x,y;
    int t ;
    Node(int xx,int yy,int tt){
        x = xx;y=yy;
        t = tt;
    }
}