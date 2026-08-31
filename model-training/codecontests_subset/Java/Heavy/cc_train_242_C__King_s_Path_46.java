import java.io.*;
import java.util.*;
public class CFkinspath {
 
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		cell s=new cell(sc.nextInt(),sc.nextInt());
		cell e=new cell(sc.nextInt(),sc.nextInt());
		int n=sc.nextInt();
        TreeSet <cell> c=new TreeSet();
        TreeMap <cell,Integer> v=new TreeMap();
        int []dc= {-1,-1,0,1,1,1,0,-1};
        int []dr= {0,-1,-1,-1,0,1,1,1};
        for(int i=0;i<n;i++) {
        	int r=sc.nextInt(); int c1=sc.nextInt(); int c2=sc.nextInt();
        	for(int j=c1;j<=c2;j++) {
        		c.add(new cell(r,j));
        		v.put(new cell(r,j),-1);
        	}
        }
        Queue <cell> q=new LinkedList();
        q.add(s);
        v.put(s, 0);
        while(!q.isEmpty()) {
        	cell cur=q.remove();
        	for(int i=0;i<8;i++) {
        		int a= dc[i]+cur.y; int b=dr[i]+cur.x;
        		cell ne=new cell(b,a);
        		if(c.contains(ne)) {
        			if(v.get(ne)==-1) {
        				q.add(ne);
        				v.put(ne,v.get(cur)+1);
        			}
        		}
        	}
        }System.out.println(v.get(e));
	}
	 static class cell implements Comparable<cell> {
		 int x;
		 int y;
		 cell(int i,int v){
			 x=i;
			 y=v;
		 }
		 public String toString() {
			 return this.x+" "+this.y; 
		 }
		 public int compareTo(cell q) {
			if(x!=q.x) 
			 return this.x-q.x;
			return y-q.y;
			}
	 }
	static	class Scanner{
        StringTokenizer st;
        BufferedReader br;
        public Scanner(InputStream system) {br = new BufferedReader(new InputStreamReader(system));}
        public Scanner(String file) throws Exception {br = new BufferedReader(new FileReader(file));}
        public String next() throws IOException
        {
            while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
        public String nextLine()throws IOException{return br.readLine();}
        public int nextInt() throws IOException {return Integer.parseInt(next());}
        public double nextDouble() throws IOException {return Double.parseDouble(next());}
        public char nextChar()throws IOException{return next().charAt(0);}
        public Long nextLong()throws IOException{return Long.parseLong(next());}
        public boolean ready() throws IOException{return br.ready();}
        public void waitForInput() throws InterruptedException {Thread.sleep(3000);}
    }
}