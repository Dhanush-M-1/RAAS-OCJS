/*
 * Author Ayub Subhaniya
 * Institute DA-IICT
 */
 
import java.io.*;
import java.math.*;
import java.util.*;
 
public class JuneLong{
	
	InputStream in;
	PrintWriter out;
	
	void solve() {
		int n=ni();
		int m=ni();
		int w[]=na(n);
		int seq[]=na(m);
		long weight=0;
		Stack<Integer> s=new Stack<Integer>();
		boolean include[]=new boolean[n];
		for (int i=0;i<m;i++)
		{
			if (!include[seq[i]-1])
				{
					s.push(seq[i]);
					include[seq[i]-1]=true;
				}
		}
		Queue<Integer> q=new LinkedList<Integer>();
		while (!s.isEmpty())
			q.add(s.pop());
		while (!q.isEmpty())
			s.push(q.poll());
		Stack<Integer> tmp=new Stack<Integer>();
		for (int i=1;i<m;i++)
		{
			//tr(s);
			long sum=0;
			while (!s.isEmpty()&&s.peek()!=seq[i])
			{
				int item=s.pop();
				tmp.push(item);
				sum+=(long)w[item-1];
			}
			if (s.isEmpty())
			{
				while (!tmp.isEmpty())
					s.push(tmp.pop());
				s.push(seq[i]);
			}
			else
			{
				weight+=sum;
				s.pop();
				while (!tmp.isEmpty())
					s.push(tmp.pop());
				s.push(seq[i]);
			}
			//tr(s);
			//tr(weight);
		}
		out.println(weight);
	}
	
	class Merge {

		void sort(int inputArr[]) {
			int length = inputArr.length;
			doMergeSort(inputArr, 0, length - 1);
		}

		void doMergeSort(int[] arr, int lowerIndex, int higherIndex) {
			if (lowerIndex < higherIndex) {
				int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
				doMergeSort(arr, lowerIndex, middle);
				doMergeSort(arr, middle + 1, higherIndex);
				mergeParts(arr, lowerIndex, middle, higherIndex);
			}
		}

		void mergeParts(int[] array, int lowerIndex, int middle, int higherIndex) {
			int[] temp = new int[higherIndex - lowerIndex + 1];
			for (int i = lowerIndex; i <= higherIndex; i++) {
				temp[i - lowerIndex] = array[i];
			}
			int i = lowerIndex;
			int j = middle + 1;
			int k = lowerIndex;
			while (i <= middle && j <= higherIndex) {
				if (temp[i - lowerIndex] < temp[j - lowerIndex]) {
					array[k] = temp[i - lowerIndex];
					i++;
				} else {
					array[k] = temp[j - lowerIndex];
					j++;
				}
				k++;
			}
			while (i <= middle) {
				array[k] = temp[i - lowerIndex];
				k++;
				i++;
			}
			while (j <= higherIndex) {
				array[k] = temp[j - lowerIndex];
				k++;
				j++;
			}
		}

	}
	
	
	void run() throws Exception {
		String INPUT = "C:/Users/ayubs/Desktop/input.txt";
		in = oj ? System.in : new FileInputStream(INPUT);
		out = new PrintWriter(System.out);
		
			long s = System.currentTimeMillis();
			solve();
			out.flush();
			tr(System.currentTimeMillis() - s + "ms");
	}
	public static void main(String[] args) throws Exception {
		new JuneLong().run();
	}
	
	private byte[] inbuf = new byte[1024];
	public int lenbuf = 0, ptrbuf = 0;
	
	private int readByte() {
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = in.read(inbuf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}
	
	private boolean inSpaceChar(int c) {
		return !(c >= 33 && c <= 126);
	}
	
	private int skip() {
		int b;
		while ((b = readByte()) != -1 && inSpaceChar(b))
			;
		return b;
	}
	
	private double nd() {
		return Double.parseDouble(ns());
	}
	
	private char nc() {
		return (char) skip();
	}
	
	private String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(inSpaceChar(b))) { // when nextLine, (inSpaceChar(b) && b != ' ')
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}
	
	private char[] ns(int n) {
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n && !(inSpaceChar(b))) {
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}
	
	private char[][] nm(int n, int m) {
		char[][] map = new char[n][];
		for (int i = 0; i < n; i++)
			map[i] = ns(m);
		return map;
	}
	
	private int[] na(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = ni();
		return a;
	}
	
	private int ni() {
		int num = 0, b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
	
	private long nl() {
		long num = 0;
		int b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
	
	private boolean oj = System.getProperty("ONLINE_JUDGE") != null;
	
	private void tr(Object... o) {
		if (!oj)
			System.out.println(Arrays.deepToString(o));
	}
	
} 