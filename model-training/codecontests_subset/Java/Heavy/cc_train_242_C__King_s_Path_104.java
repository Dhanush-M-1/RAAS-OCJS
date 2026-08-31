import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {

    static int N;
    static Map<Point, Boolean> V;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x0 = sc.nextInt(), y0 = sc.nextInt(), x1 = sc.nextInt(), y1 = sc.nextInt();
        
        int n = sc.nextInt(), r, a, b;
        //Set<Point> P = new HashSet<>(100001);
        V = new HashMap<>(100001);
        int ind = 0;
        for (int i = 0; i < n; i++) {
            r = sc.nextInt();
            a = sc.nextInt();
            b = sc.nextInt();
            for (int j = a; j <= b; j++) {
                Point p = new Point(r,j,0);
                if(!V.containsKey(p))
                    V.put(p,false);
            }
        }
        
        Queue<Point> q = new LinkedList<Point>();
        Point p0 = new Point(x0,y0,0);
        q.add(p0);
        V.put(p0,true);
        
        int res = -1;
        boolean found=false;
        int[] X = {-1,-1,-1, 0,0, 1, 1, 1};
        int[] Y = {-1, 0, 1,-1,1,-1, 0, 1};
        int i,j;
        while(!q.isEmpty() && !found) {
            //System.out.println(q.size());
            Point p = q.poll();
            //System.out.println(p.x+" "+p.y);
            
            for (int k = 0; k < X.length; k++) {
                i = p.x + X[k];
                j = p.y + Y[k];
                Point next = new Point(i,j,p.d+1);
                //System.out.println(k+" "+next.x+" "+next.y+" "+V.get(next));    
                Boolean vis = V.get(next);
                if(vis!=null && !vis) {
                    if(i==x1 && j==y1) {
                        res = p.d+1;
                        found = true;
                        break;
                    }
                    V.put(next,true);
                    q.add(next);
                }
            }
        }
        
        System.out.println(res);
    }

}

class Point implements Comparable{
    int x,y,d;
    Point(int x, int y, int d){
        this.x = x;
        this.y=y;
        this.d=d;
    }   
    
    @Override
    public int compareTo(Object obj) {
        Point p = (Point) obj;
        if(this.x > p.x || (this.x == p.x && this.y > p.y))
            return 1;
        if(this.x < p.x || (this.x == p.x && this.y < p.y))
            return -1;
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        Point p = (Point) obj;
        boolean r = this.x == p.x && this.y == p.y;
        return r;
    }
    
    @Override
    public int hashCode() {
        return 2*this.x*10+this.y; // constant
    }
}
