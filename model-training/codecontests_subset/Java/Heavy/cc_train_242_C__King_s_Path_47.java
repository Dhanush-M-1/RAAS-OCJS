
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Collection;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Ziklon
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }
}

class TaskC {

    int dx[]={0,0,1,-1,1,-1,1,-1};
    int dy[]={1,-1,0,0,1,-1,-1,1};
    int R=1000000000;
    class Nodo {
        int x,y;
        public Nodo(int a, int b){
            x=a;y=b;
        }



        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Nodo nodo = (Nodo) o;
            if (x != nodo.x) return false;
            if (y != nodo.y) return false;
            return true;
        }
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }




    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int xs,ys,xe,ye,N,r,a,b;
        xs=in.nextInt();
        ys=in.nextInt();
        xe=in.nextInt();
        ye=in.nextInt();
        N=in.nextInt();

        HashMap<Nodo,Integer> vis=new HashMap<Nodo, Integer>();

        ArrayList<Nodo> list=new ArrayList<Nodo>();
        HashSet<Nodo> tree=new HashSet<Nodo>();
        for(int i=0;i<N;i++){
            r=in.nextInt();
            a=in.nextInt();
            b=in.nextInt();
            for(int j=a;j<=b;j++)
                tree.add(new Nodo(r,j));
        }

        Queue<Nodo> Q=new LinkedList<Nodo>();
        Q.add(new Nodo(xs,ys));
        vis.put(new Nodo(xs,ys),0);
        int ans=-1;
        while(!Q.isEmpty()){
            Nodo cur=Q.poll();
            int cost=vis.get(cur);
            if(cur.x==xe && cur.y==ye){
                ans=cost;
                break;
            }
            for(int i=0;i<8;i++){
                int X=cur.x+dx[i];
                int Y=cur.y+dy[i];
                if(Math.min(X,Y)>=1 && Math.max(X,Y)<=R){
                    Nodo tmp=new Nodo(X,Y);
                    if(tree.contains(tmp) && !vis.containsKey(tmp)){
                        vis.put(tmp,cost+1);
                        Q.add(tmp);
                    }
                }
            }
        }
        out.println(ans);
    }
}

class InputReader {

    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }
    public int nextInt() {
        return Integer.parseInt(next());
    }

}

