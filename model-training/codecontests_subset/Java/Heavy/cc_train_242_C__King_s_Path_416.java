import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(in, out);
        out.close();
    }
}

class TaskC {
    public static class PointDist{
        Point p;
        int steps;
        public PointDist(Point p, int steps) {
            super();
            this.p = p;
            this.steps = steps;
        }
    }
    public void solve(InputReader in, PrintWriter out) {
        int x0 = in.nextInt();
        int y0 = in.nextInt();
        Point xy0 = new Point(x0, y0);
        int x1 = in.nextInt();
        int y1 = in.nextInt();
        Point xy1 = new Point(x1, y1);
        int n = in.nextInt();
        HashSet<Point> points = new HashSet<Point>();
        int r, a, b;
        for(int i=0; i<n; i++){
            r = in.nextInt();
            a = in.nextInt();
            b = in.nextInt();
            while(a<=b){
                points.add(new Point(r, a));
                a++;
            }
        }
        LinkedList<PointDist> queue = new LinkedList<PointDist>();
        queue.add(new PointDist(xy0, 0));
        Point p, np;
        while(!queue.isEmpty()){
            PointDist pz = queue.remove();
            p = pz.p;
            for(int dx=-1; dx<2; dx++){
                for(int dy=-1; dy<2; dy++){
                    if(dx == 0 && dy == 0)
                        continue;
                    np = new Point(((int)p.getX())+dx, ((int)p.getY())+dy);
                    if(np.equals(xy1)){
                        out.println(1+pz.steps);
                        return;
                    }
                    if(points.contains(np)){
                        queue.add(new PointDist(np, pz.steps + 1));
                        points.remove(np);
                    }
                }
            }
        }
        out.println(-1);
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
    
    public int nextInts(){
        //return map(lambda x: Integer.parseInt(x), in.readLine().trim().split("[ ]+"));
        return 1;
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

}