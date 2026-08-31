import java.io.*;
import java.util.*;
public class P1374E1
{
	public static void main(String[] args) throws IOException
	{
		Reader ob = new Reader();
		
		int n=ob.nextInt();
		int k=ob.nextInt();
		
		int[] t=new int[n];
		int[] a=new int[n];
		int[] b=new int[n];
		
		for(int i=0;i<n;i++) {
			t[i]=ob.nextInt();
			a[i]=ob.nextInt();
			b[i]=ob.nextInt();
		}
		
		int ans=0;
		ArrayList<Integer> both=new ArrayList<>();
		ArrayList<Integer> ae=new ArrayList<>();
		ArrayList<Integer> be=new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			if(a[i]==1&&b[i]==1) {
				both.add(t[i]);
			}else if(a[i]==1&&b[i]==0) {
				ae.add(t[i]);
			}else if(a[i]==0&&b[i]==1) {
				be.add(t[i]);
			}
		}
		Collections.sort(both);
		Collections.sort(be);
		Collections.sort(ae);
		if(both.size()+Math.min(ae.size(), be.size())<k) {
			System.out.println(-1);
		}else {
			int count=0;
			int st=0;
			for(int i=0;i<Math.min(ae.size(), be.size());i++) {
				if(count==k) {
					break;
				}else {
					
					if(st<both.size()) {
						if(both.get(st)>ae.get(i)+be.get(i)) {
							ans=ans+ae.get(i)+be.get(i);
							count++;
							
						}else {
							ans=ans+both.get(st);
							st++;
							i--;
							count++;
						}
					}else {
						ans=ans+ae.get(i)+be.get(i);
						count++;
					}
					
				}
				
			}
			
			while(count<k) {
				count++;
				ans=ans+both.get(st);
				st++;
				
			}
			System.out.println(ans);
	    }
	}
	static class Reader 
	{ 
		final private int BUFFER_SIZE = 1 << 16; 
		private DataInputStream din; 
		private byte[] buffer; 
		private int bufferPointer, bytesRead; 

		public Reader() 
		{ 
			din = new DataInputStream(System.in); 
			buffer = new byte[BUFFER_SIZE]; 
			bufferPointer = bytesRead = 0; 
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
			do { 
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

			do { 
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

		public void close() throws IOException 
		{ 
			if (din == null) 
				return; 
			din.close(); 
		} 
	}
}