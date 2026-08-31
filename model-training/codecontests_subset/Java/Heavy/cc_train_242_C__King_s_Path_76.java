import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        MinionsAndVoting solver = new MinionsAndVoting();
       // int testCount = Integer.parseInt(in.next());
        //for (int i = 1; i <= testCount; i++)
            solver.solve(0, in, out);
        out.close();
    }
 
    static class MinionsAndVoting {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
       HashMap<pair,Integer> hm=new HashMap<>();
       int x0=in.ni(),y0=in.ni(),x1=in.ni(),y1=in.ni(),n=in.ni();
       int r=0,a=0,b=0,cnt=0;
       pair d=new pair(-1,-1);
       for(int i=0;i<n;++i)
       {
           r=in.ni();a=in.ni();b=in.ni();
           
          for(int j=a;j<=b;++j) 
          {
             d.x=r;d.y=j;
             if(!hm.containsKey(d))
             {
              hm.put(new pair(r,j),cnt);
              cnt++;
             }

          }
       }
       ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
   
       int vertex=hm.size();
       for(int i=0;i<vertex;++i)
       {
           graph.add(new ArrayList<Integer>());
       }
       int first=0,second=0;
      Set<pair> set=hm.keySet();
      pair dummy=new pair(-1,-1); 
      for(pair p:set)
      {
          first=p.x;second=p.y;
          for(int i=-1;i<2;++i)
          {
              for(int j=-1;j<2;++j)
              {
                dummy.x=first+i;
                dummy.y=second+j;
                  if(set.contains(dummy))
                    {
                        graph.get(hm.get(p)).add(hm.get(dummy));
                    }
                
              }
          }
              
      }
 
    dummy.x=x0;
    dummy.y=y0;
    int source=hm.get(dummy);
    dummy.x=x1;
    dummy.y=y1;
    int dest=hm.get(dummy);
 
    out.println(ShortPath(graph,source,dest));    
       
       
        
        }
  
 
  
 
        
    }
    static int ShortPath(ArrayList<ArrayList<Integer>> graph,int source,int dest)
    {
        PriorityQueue<pair> pq=new PriorityQueue<>();
        int size=graph.size();
        int[] cost=new int[size];
        Arrays.fill(cost,100000000);
        cost[source]=0;
        boolean vis[]=new boolean[size];
        
        pq.add(new pair(0,source));
        pair dummy;
        while(!pq.isEmpty())
        {
            dummy=pq.poll();
            vis[dummy.y]=true;
            if(dummy.y==dest)
            break;
            ArrayList<Integer> al=graph.get(dummy.y);
            for(int x:al)
            {
                if(vis[x]) continue;
                if(cost[dummy.y]+1<cost[x])
                {
                    cost[x]=cost[dummy.y]+1;
                    pq.add(new pair(cost[x],x));
                    
                }
                
            }
        }
        return cost[dest]==100000000?-1:cost[dest];
        
        
    }
 
    static class OutputWriter {
        private final PrintWriter writer;
 
        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }
 
        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }
 
        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }
 
        public void println(Object... objects) {
            print(objects);
            writer.println();
        }
 
        public void close() {
            writer.close();
        }
 
    }
 
    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;
 
        public InputReader(InputStream stream) {
            this.stream = stream;
        }
 
        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }
 
        public int ni() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
 
        public String next() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c)) {
                    res.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }
 
        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }
 
        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
 
        public int[] na(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; ++i) array[i] = ni();
            return array;
        }
 
        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
 
        }
 
    }
}
class pair implements Comparable<pair>{
    int x,y;
    pair(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
    public int hashCode()
    {
        return (x+" "+y).hashCode();
    }
    public boolean equals(Object o)
    {
        pair p=(pair)o;
        return (p.x==this.x&&p.y==this.y);
    }
    public String toString()
    {
        return "x:"+x+" y:"+y;
    }
    public int compareTo(pair p)
    {
        return (this.x-p.x);
    }
}
 
 