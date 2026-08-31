import java.util.*;
import java.lang.*;
import java.io.*;
public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
		//Reader sc=new Reader();
		PrintWriter out=new PrintWriter(System.out);
		int t=Integer.parseInt(sc.readLine());
		//int t=sc.nextInt();
		while(t-->0){
		      int n=Integer.parseInt(sc.readLine());
		      String[] s=new String[n];
		      for(int i=0;i<n;i++)s[i]=sc.readLine();
		      if(s[0].charAt(1)==s[1].charAt(0)){
		            int count=0;
		            char ch=s[0].charAt(1);
		            StringBuilder sb=new StringBuilder();
		            if(s[n-1].charAt(n-2)==ch){
		                  count++;
		                  sb.append(n+" "+(n-1)+"\n");
		            }if(s[n-2].charAt(n-1)==ch){
		                  count++;
		                  sb.append(n-1+" "+n+"\n");
		            }out.println(count);
		            if(count!=0)
		            out.print(sb);
		      }else{
		            if(s[n-1].charAt(n-2)==s[n-2].charAt(n-1)){
		                  char ch=s[n-1].charAt(n-2);
		                  int count=0;
		                  StringBuilder sb=new StringBuilder();
		                  if(s[0].charAt(1)==ch){
		                        count++;
		                        sb.append(1+" "+2+"\n");
		                  }if(s[1].charAt(0)==ch){
		                        count++;
		                        sb.append(2+" "+1+"\n");
		                  }out.println(count);
		                  if(count!=0)
		                  out.print(sb);
		            }else{
		                  char ch=s[0].charAt(1);
		                  int count=0;
		                  StringBuilder sb=new StringBuilder();
		                  sb.append(2+" "+1+"\n");
		                  if(s[n-1].charAt(n-2)==ch){
		                        sb.append(n+" "+(n-1)+"\n");
		                  }else{
		                        sb.append(n-1+" "+n+"\n");
		                  }out.println("2");
		                  out.print(sb);
		            }
		      }
		}
		out.flush();
	}
}class Reader 
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
			byte[] buf = new byte[(int)1e8]; // line length 
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

