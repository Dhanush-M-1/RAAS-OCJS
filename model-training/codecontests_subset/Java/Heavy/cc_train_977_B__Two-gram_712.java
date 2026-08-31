import java.util.*;
import java.io.*;

// 
public class Codeforces {
	public static void main(String[] args) {
		FastReader r = new FastReader();
		int len = r.ri();
		String word = r.string();
		Map<String, int[]> map = new HashMap<>();
		int max = 0;
		String maxStr = null;
		for(int i = 0; i<len-1; i++) {
			String sub = word.substring(i, i+2);
			if(map.containsKey(sub)) {
				map.get(sub)[0]++;
				if(map.get(sub)[0] > max) {
					max = map.get(sub)[0];
					maxStr = sub;
				}
			} else {
				map.put(sub, new int[] { 1 });
				if(maxStr == null) {
					maxStr = sub;
					max = 1;
				}
					
			}
		}
		print(maxStr);		
	}

	public static void rolling(int[] arr) {
		if (arr.length < 2)
			return;
		for (int i = 1; i < arr.length; i++)
			arr[i] += arr[i - 1];
	}

	public static void reverse(int[] arr) {
		for (int i = 0; i < arr.length / 2; i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = temp;
		}
	}

	public static void print(String s) {
		System.out.println(s);
	}

	public static void print(long s) {
		System.out.println(s);
	}

	public static void print(int s) {
		System.out.println(s);
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		int ri() {
			return Integer.parseInt(string());
		}

		long rl() {
			return Long.parseLong(string());
		}

		double rd() {
			return Double.parseDouble(string());
		}

		String string() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

		String[] rsa() {
			return string().split(" ");
		}

		int[] ria() {
			String[] s = rsa();
			int[] arr = new int[s.length];
			for (int i = 0; i < arr.length; i++)
				arr[i] = Integer.parseInt(s[i]);
			return arr;
		}

		long[] rla() {
			String[] s = rsa();
			long[] arr = new long[s.length];
			for (int i = 0; i < arr.length; i++)
				arr[i] = Long.parseLong(s[i]);
			return arr;
		}

		char[] rca() {
			String s = string();
			char[] arr = new char[s.length()];
			for (int i = 0; i < arr.length; i++)
				arr[i] = s.charAt(i);
			return arr;
		}

		int[] riaml(int m) {
			int[] arr = new int[m];
			for (int i = 0; i < arr.length; i++)
				arr[i] = Integer.parseInt(string());
			return arr;
		}

		long[] rlaml(int m) {
			long[] arr = new long[m];
			for (int i = 0; i < arr.length; i++)
				arr[i] = Long.parseLong(string());
			return arr;
		}
	}
}

class MyNode {
	public int val;
	public boolean visited;
	public MyNode(int v) { val=v; }
}
