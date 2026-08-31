import java.util.*;
import java.io.*;
public class div572{
	
	static class Reader
	{
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;
		BufferedReader br;
		public Reader()
		{
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
			br = new BufferedReader(new InputStreamReader(System.in));
		}
 
		public Reader(String file_name) throws IOException
		{
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}
 
		public String readLine() throws IOException
		{
			byte[] buf = new byte[64]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1)
			{
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}
		
		
		
 
		public int nextInt() throws IOException
		{
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do
			{
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
 
			if (neg)
				return -ret;
			return ret;
		}
 
		public long nextLong() throws IOException
		{
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do
			{
				ret = ret * 10 + c - '0';
			}
			while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}
 
		public double nextDouble() throws IOException
		{
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
 
			do
			{
				ret = ret * 10 + c - '0';
			}
			while ((c = read()) >= '0' && c <= '9');
 
			if (c == '.')
			{
				while ((c = read()) >= '0' && c <= '9')
				{
					ret += (c - '0') / (div *= 10);
				}
			}
 
			if (neg)
				return -ret;
			return ret;
		}
 
		private void fillBuffer() throws IOException
		{
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}
 
		private byte read() throws IOException
		{
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}
		StringTokenizer st;
		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception r) {
					r.printStackTrace();
				}
			}
			return st.nextToken();
		}
 
 
		public void close() throws IOException
		{
			if (din == null)
				return;
			din.close();
		}
	}
	public static void main(String s[]) throws IOException{
		Reader sc = new Reader();
		int n = sc.nextInt();
		ArrayList<Integer> l1 = new ArrayList<>();
		ArrayList<Integer> l2 = new ArrayList<>();
		for(int i=0;i<n-1;i++){
			l1.add(sc.nextInt());
			l2.add(sc.nextInt());
		}
		HashMap<Integer,ArrayList<Integer>> tree = create(l1,l2);
		ArrayList<Integer> keys = new ArrayList<>(tree.keySet());
		for(int i=0;i<keys.size();i++){
			if(tree.get(keys.get(i)).size()==2){
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
	
	static int count=0;
	public static void bfs(int n, HashMap<Integer,ArrayList<Integer>> hm, int node){
		
		HashMap<Integer,Integer> visited = new HashMap<>();
		visited.put(node,0);
		LinkedList<Integer> ll =  new LinkedList<>();
		ll.addLast(node);
		
		while(ll.size()!=0){
			int val = ll.removeFirst();
			ArrayList<Integer> keys = hm.get(val);
			for(int i=0;i<keys.size();i++){
				if(!visited.containsKey(keys.get(i))){
					ll.addLast(keys.get(i));
					System.out.println(val+" "+keys.get(i));
					visited.put(keys.get(i),0);
					count++;
					if(count==n-1)
						return;
				}
			}
		}
		
	}
	
	
	public static HashMap<Integer,ArrayList<Integer>> create(ArrayList<Integer> l1, ArrayList<Integer> l2){
		HashMap<Integer,ArrayList<Integer>> hm = new HashMap<>();
		
		for(int i=0;i<l1.size();i++){
			int val1 = l1.get(i);
			int val2 = l2.get(i);
			
			if(!hm.containsKey(val1)){
				ArrayList<Integer> temp = new ArrayList<>();
				temp.add(val2);
				hm.put(val1,temp);
			}else if(hm.containsKey(val1)){
				ArrayList<Integer> temp = hm.get(val1);
				temp.add(val2);
				hm.put(val1,temp);
			}
			
			
			if(!hm.containsKey(val2)){
				ArrayList<Integer> temp = new ArrayList<>();
				temp.add(val1);
				hm.put(val2,temp);
			}else if(hm.containsKey(val2)){
				ArrayList<Integer> temp = hm.get(val2);
				temp.add(val1);
				hm.put(val2,temp);
			}
		}
		return hm;
	}
 
}