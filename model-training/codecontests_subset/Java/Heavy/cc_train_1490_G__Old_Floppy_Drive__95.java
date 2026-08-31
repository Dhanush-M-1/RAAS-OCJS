import java.io.*;
import java.util.*;

public class test2{
	static StringBuilder finalResult;

	static int binSearch(List<MyPair> list, long mod){
		int low=0, high=list.size()-1;
// 1 1 2 2 3
		if(list.size()<1 || mod<0)
			return -1;

		while(low < high){
			int mid = low + (high-low)/2;
			long valAtMid = list.get(mid).b;
			// if(valAtMid == mod){
			// 	return mid;
			// }
			// else 
			if(valAtMid >= mod){
				high = mid;
			}
			else{
				low = mid+1;
			}
		}

		if(list.get(low).b >= mod)
			return (int)list.get(low).a;
		else
			return -1;
	}

	static void solve(int n, int[] a, int[] x){
		long runningSum=0;
		List<MyPair> list=new ArrayList<>();
		long maxPref=0;
		for(int i=0; i<n; i++){
			runningSum += a[i];
			if(runningSum > 0){
				if(list.size()==0 || runningSum > list.get(list.size()-1).b){
					list.add(new MyPair(i,runningSum));
					maxPref = Math.max(maxPref, runningSum);
				}
			}
		}

		Collections.sort(list);

		long result[] = new long[x.length];
		for(int i=0; i<x.length; i++){
			int m = x[i];
			// if(runningSum < 1L){
			// 	int lb = binSearch(list, m);
			// 	result[i] = lb>=0 && list.get(lb).b >= m ? lb : -1;
			// }
			// else{
				long ans = 0;
				if(binSearch(list, m) != -1){
					ans += binSearch(list, m);
				}
				else if(runningSum>0){
					long fullSpin =  ((m-maxPref+runningSum-1)/runningSum);
					ans += fullSpin*n -1;
					long mod = m - fullSpin*(runningSum);
					if(mod != 0)
						ans += binSearch(list, mod) + 1;
				}
				else{
					ans=-1;
				}
				result[i] = ans;
			// }
		} 
		/*
		1
		2 2
		2 0
		1 2
		*/
		for(int i=0; i<x.length; i++)
			finalResult.append(result[i]+" ");
		finalResult.append("\n");
	}

    public static void main(String[] args) throws IOException{
        Reader sc = new Reader();
		int t = sc.nextInt();
		finalResult=new StringBuilder();

		// List<MyPair> list=new ArrayList<>();
		// list.add(new MyPair(1,1));
		// list.add(new MyPair(1,2));
		// list.add(new MyPair(1,2));
		// list.add(new MyPair(1,2));
		// list.add(new MyPair(1,3));

		// System.out.println(binSearch(list, 3));
        while(t-- > 0){
			int n=sc.nextInt();
			int m=sc.nextInt();
			int[] a=new int[n];
			int[] x=new int[m];
			for(int i=0; i<n; i++){
				a[i]=sc.nextInt();
			}
			for(int i=0; i<m; i++){
				x[i]=sc.nextInt();
			}
			solve(n, a, x);
		}
		System.out.println(finalResult);
	}

    static class Reader {
	    final private int BUFFER_SIZE = 1 << 16;
	    private DataInputStream din;
	    private byte[] buffer;
	    private int bufferPointer, bytesRead;

	    public Reader() {
	      din = new DataInputStream(System.in);
	      buffer = new byte[BUFFER_SIZE];
	      bufferPointer = bytesRead = 0;
	    }

	    public Reader(String file_name) throws IOException {
	      din = new DataInputStream(new FileInputStream(file_name));
	      buffer = new byte[BUFFER_SIZE];
	      bufferPointer = bytesRead = 0;
	    }

	    public String readLine() throws IOException {
	      byte[] buf = new byte[64];
	      int cnt = 0, c;
	      while ((c = read()) != -1) {
	        if (c == '\n') break;
	        buf[cnt++] = (byte) c;
	      }
	      return new String(buf, 0, cnt);
	    }

	    public int nextInt() throws IOException {
	      int ret = 0;
	      byte c = read();
	      while (c <= ' ') c = read();
	      boolean neg = (c == '-');
	      if (neg) c = read();
	      do {
	        ret = ret * 10 + c - '0';
	      } while ((c = read()) >= '0' && c <= '9');
	      if (neg) return -ret;
	      return ret;
	    }

	    public long nextLong() throws IOException {
	      long ret = 0;
	      byte c = read();
	      while (c <= ' ') c = read();
	      boolean neg = (c == '-');
	      if (neg) c = read();
	      do {
	        ret = ret * 10 + c - '0';
	      } while ((c = read()) >= '0' && c <= '9');
	      if (neg) return -ret;
	      return ret;
	    }

	    public double nextDouble() throws IOException {
	      double ret = 0, div = 1;
	      byte c = read();
	      while (c <= ' ') c = read();
	      boolean neg = (c == '-');
	      if (neg) c = read();
	      do {
	        ret = ret * 10 + c - '0';
	      } while ((c = read()) >= '0' && c <= '9');
	      if (c == '.')
	        while ((c = read()) >= '0' && c <= '9') ret += (c - '0') / (div *= 10);
	      if (neg) return -ret;
	      return ret;
	    }

	    private void fillBuffer() throws IOException {
	      bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
	      if (bytesRead == -1) buffer[0] = -1;
	    }

	    private byte read() throws IOException {
	      if (bufferPointer == bytesRead) fillBuffer();
	      return buffer[bufferPointer++];
	    }

	    public void close() throws IOException {
	      if (din == null) return;
	      din.close();
	    }
	  }
}

class Node{
	int data;
	Node left, right;

	Node(int data){
		this.data=data;
	}
	Node(){

	}
}

class MyPair implements Comparable<MyPair>{
	long a,b;
	MyPair(long a, long b){
		this.a=a;
		this.b=b;
	}
	@Override
	public int compareTo(MyPair p) {
		// if(a != p.a){
		// 	return a - p.a;
		// }
		// else{
		// 	return b - p.b;
		// }
		if(b > p.b){
			return 1;
		}
		else if(b == p.b){
			return 0;
		}
		else{
			return -1;
		}
	}
}