import java.io.PrintWriter;
import java.io.InputStream;
import java.io.IOException;
import java.util.*;
public class div372Dx
{
	InputReader reader;
	PrintWriter ob;
	int n,m,L,u[],v[],w[],source,dest;
	long cost[][];
	long dist1[],dist2[];
	boolean vis1[],vis2[];
	ArrayList<Integer> gr[];
	public static void main(String[] args) throws IOException {
		new div372Dx().run();
	}
	void run() throws IOException {
		reader = new InputReader(System.in);
		ob=new PrintWriter(System.out);
		solve();
		ob.flush();
	}
	@SuppressWarnings("unchecked")
	void solve() throws IOException {
		n=reader.readInt();
		m=reader.readInt();
		L=reader.readInt();
		source=reader.readInt();
		dest=reader.readInt();
		cost=new long[n][n];
		u=new int[m];
		v=new int[m];
		w=new int[m];
		gr=new ArrayList[n];
		for (int i=0; i<n ; i++ ) {
			gr[i]=new ArrayList<Integer>();
		}
		for (int i=0; i<m ; i++ ) {
			u[i]=reader.readInt();
			v[i]=reader.readInt();
			w[i]=reader.readInt();
			gr[u[i]].add(v[i]);
			gr[v[i]].add(u[i]);
			cost[u[i]][v[i]]=(w[i]==0)?-1:w[i];
			cost[v[i]][u[i]]=(w[i]==0)?-1:w[i];
		}
		dijkstra(dest,source);
		/*for (int i=0; i<n ; i++ ) {
			ob.println("dijkstra "+i+" "+dist1[i]);
		}*/
		dijkstraS(source,dest);
		/*for (int i=0; i<n ; i++ ) {
			ob.println("dijkstra2 "+i+" "+dist2[i]);
		}*/
		if(dist2[dest]!=L) {
			ob.println("NO");
		}
		else {
			ob.println("YES");
			for (int i=0; i<m ; i++ ) {
			    if(cost[u[i]][v[i]]==-1)
				ob.println(u[i]+" "+v[i]+" 1000000000000");
				else
				ob.println(u[i]+" "+v[i]+" "+cost[u[i]][v[i]]);
			}
		}
	}

	void dijkstraS(int source,int dest) {
		TreeSet<Template> pq=new TreeSet<Template>(new Comparator<Template>(){
			public int compare(Template x, Template y) {
				if(x.p!=y.p)
				return Long.compare(x.p,y.p);
				else
				return x.i-y.i;
			}
		});
		dist2=new long[n];
		Arrays.fill(dist2,Long.MAX_VALUE);
		dist2[source]=0;
		vis2=new boolean[n];
		Template start=new Template();
		start.i=source;
		start.p=0;
		pq.add(start);
		while(!pq.isEmpty()) {
			Template polled=pq.first();
			pq.remove(polled);
			int ele=polled.i;
			long p=polled.p;
			vis2[ele]=true;
			for(int x : gr[ele]) {
				if(!vis2[x]) {
					long weight=(cost[ele][x]==-1)?Math.max(1,L-p-dist1[x]):cost[ele][x];
					if(p+weight<=dist2[x]) {
						cost[ele][x]=weight;
						cost[x][ele]=weight;
						dist2[x]=p+weight;
						Template next=new Template();
						next.i=x;
						next.p=dist2[x];
						pq.add(next);
					}
				}
			}		
		}
	}
	
	void dijkstra(int source,int dest) {
		TreeSet<Template> pq=new TreeSet<Template>(new Comparator<Template>(){
			public int compare(Template x, Template y) {
				if(x.p!=y.p)
				return Long.compare(x.p,y.p);
				else
				return x.i-y.i;
			}
		});
		dist1=new long[n];
		Arrays.fill(dist1,Long.MAX_VALUE);
		dist1[source]=0;
		vis1=new boolean[n];
		Template start=new Template();
		start.i=source;
		start.p=0;
		pq.add(start);
		while(pq.isEmpty()==false) {
			Template polled=pq.first();
			pq.remove(polled);
			int ele=polled.i;
			long p=polled.p;
			vis1[ele]=true;
			for(int x : gr[ele]) {
				if(!vis1[x]) {
					long weight=(cost[ele][x]==-1)?1:cost[ele][x];
					if(p+weight<=dist1[x]) {
						dist1[x]=p+weight;
						Template next=new Template();
						next.i=x;
						next.p=dist1[x];
						pq.add(next);
					}
				}
			}		
		}
	}

  final class InputReader {
        private final InputStream stream;
        private final byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
 
        public InputReader(InputStream stream) {
            this.stream = stream;
        }
 
        private int read() throws IOException {
            if (curChar >= numChars) {
                curChar = 0;
                numChars = stream.read(buf);
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }
 
        public final int readInt() throws IOException {
            return (int)readLong();
        }
 
        public final long readLong() throws IOException {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
                if (c == -1) throw new IOException();
            }
            boolean negative = false;
            if (c == '-') {
                negative = true;
                c = read();
            }
            long res = 0;
            do {
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return negative ? -res : res;
        }
 
        public final int[] readIntArray(int size) throws IOException {
            int[] array = new int[size];
            for (int i=0; i<size; i++) {
                array[i] = readInt();
            }
            return array;
        }
 
        public final long[] readLongArray(int size) throws IOException {
            long[] array = new long[size];
            for (int i=0; i<size; i++) {
                array[i] = readLong();
            }
            return array;
        }
 
        public final String readString() throws IOException {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.append((char)c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }
 
        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }
}
 class Template {
	int i;
	long p;
}