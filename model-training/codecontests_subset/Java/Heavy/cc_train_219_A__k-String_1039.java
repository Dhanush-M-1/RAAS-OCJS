import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthSeparatorUI;

/*07:05:45PM

 String x =sc.next();
 char inp [] = x.toCharArray();
 SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm");
 SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");
 Date date = parseFormat.parse(x.substring(0, 5)+" "+x.substring(8, 10));
 System.out.println(displayFormat.format(date)+":"+x.substring(6, 8));
 */










public class Main {
	static ArrayList<Pair> adjList[];
	static int R , C , Ix , Iy;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int k =sc.nextInt();
		char inp [] = sc.next().toCharArray();
		int arr  [] = new int[26];
		for(int i =0 ; i< inp.length ; i++)
			arr[(int)(inp[i]-'a')]++;
		
		boolean ok =true;
		for(int i =0 ; i < 26 ;++i)
			if(arr[i]%k!=0){ok=false ; break;}
		
		if(!ok){System.out.println(-1);return;}
		
		for(int i = 0; i < k ; i++)
			for(int j =0 ;j < 26 ; j++)
				if(arr[j]!=0)
				{
					for(int l =0 ; l <arr[j]/k ; l++)
					System.out.print((char)(j+'a'));
				}
	}
}











class Triple 
{
	long x, y , z;
	public Triple(long a , long b , long c)
	{
		x= a; y=b;z=c;
	}
}

class Pair implements Comparable<Pair> {
	public int x, y;

	Pair(int a, int b) {
		x = a;
		y = b;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return x == ((Pair) (obj)).x && y == ((Pair) obj).y;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 6 * x + 8 * y;
	}

	@Override
	public int compareTo(Pair o) {
		// TODO Auto-generated method stub
		return x * o.y - y * o.x;
	}

}

class Scanner {
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream s) {
		br = new BufferedReader(new InputStreamReader(s));
	}

	public String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}

	public int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	public long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	public String nextLine() throws IOException {
		return br.readLine();
	}

	public double nextDouble() throws IOException {
		String x = next();
		StringBuilder sb = new StringBuilder("0");
		double res = 0, f = 1;
		boolean dec = false, neg = false;
		int start = 0;
		if (x.charAt(0) == '-') {
			neg = true;
			start++;
		}
		for (int i = start; i < x.length(); i++)
			if (x.charAt(i) == '.') {
				res = Long.parseLong(sb.toString());
				sb = new StringBuilder("0");
				dec = true;
			} else {
				sb.append(x.charAt(i));
				if (dec)
					f *= 10;
			}
		res += Long.parseLong(sb.toString()) / f;
		return res * (neg ? -1 : 1);
	}

	public boolean ready() throws IOException {
		return br.ready();
	}

}