/**
 * Created by IntelliJ IDEA.
 * User: shakhov
 * Date: 15.06.2011
 * Time: 15:22:46
 * To change this template use File | Settings | File Templates.
 */

//6
//86 402 133 524 405 610   6 4 1

import java.io.*;
import java.util.*;

public class CodeForces {
	double eps = 0.00001;

	public void solve() throws IOException {
		int t = nextInt();
		int m = nextInt();

		Memory mem = new Memory(m);
		for (int i = 0; i < t; i++) {
			String s = nextToken();
			if (s.equals("defragment")) {
				mem.defragment();
			} else if (s.equals("alloc")) {
				int n = nextInt();
				out.println(mem.alloc(n));
			} else {
				int n = nextInt();
				String rs = mem.erase(n);
				if (!rs.isEmpty()) {
					out.println(rs);
				}
			}
		}

	}

	private class Memory {
		private int mem;
		private int counter = 1;
		private int arr[];
		SortedSet<Integer> set = new TreeSet<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		public Memory(int m) {
			this.mem = m;
			arr = new int[m];
		}

		public String alloc(int n) {
			if (set.isEmpty()) {
				if (n <= mem) {
					set.add(0);
					map.put(counter, 0);
					arr[0] = n;
				} else {
					return "NULL";
				}
			} else {
				Integer[] tarr = set.toArray(new Integer[0]);
				boolean isAllocate = false;
				for (int i = 0, l = tarr.length; i < l; i++) {
					if (i == 0) {
						if (tarr[0] >= n) {
							set.add(0);
							map.put(counter, 0);
							arr[0] = n;
							isAllocate = true;
							break;
						}
					} else {
						if (tarr[i] - tarr[i - 1] - arr[tarr[i - 1]] >= n) {
							set.add(tarr[i - 1] + arr[tarr[i - 1]]);
							map.put(counter, tarr[i - 1] + arr[tarr[i - 1]]);
							arr[tarr[i - 1] + arr[tarr[i - 1]]] = n;
							isAllocate = true;
							break;
						}
					}
					if (i == l - 1) {
						if (mem - tarr[i] - arr[tarr[i]] >= n) {
							set.add(tarr[i] + arr[tarr[i]]);
							map.put(counter, tarr[i] + arr[tarr[i]]);
							arr[tarr[i] + arr[tarr[i]]] = n;
							isAllocate = true;
							break;
						}
					}
				}
				if (!isAllocate)
					return "NULL";
			}
			return (counter++) + "";
		}

		public String erase(int n) {
			if (map.containsKey(n)) {
				set.remove(map.get(n));
				arr[map.get(n)] = 0;
				map.remove(n);
				return "";
			} else {
				return "ILLEGAL_ERASE_ARGUMENT";
			}

		}

		public void defragment() {
			int st=0;
			SortedSet<Integer> newset = new TreeSet<Integer>();
			for (Integer a : set) {					
					newset.add(st);
					arr[st]=arr[a];
					if(st!=a){arr[a]=0;}
					for(Integer c:map.keySet()){
						if(map.get(c)==a){
							map.remove(c);
							map.put(c, st);
							break;
						}
					}
					st+=arr[st];				
			}
			this.set=newset;
		}
	}



	private BufferedReader reader;
	private StringTokenizer tokenizer;
	private String separator;
	public PrintWriter out;

	public static void main(String[] args) throws IOException {
		// new CodeForces().run(new FileReader("input.txt"), new
		// FileWriter("output.txt"));
		new CodeForces().run(new InputStreamReader(System.in), new OutputStreamWriter(System.out));
	}

	public void run(Reader reader, Writer writer) {
		try {
			this.reader = new BufferedReader(reader);
			out = new PrintWriter(writer);
			tokenizer = new StringTokenizer("");
			separator = System.getProperty("line.separator");
			separator = Character.toString(separator.charAt(separator.length() - 1));
			long t1 = System.currentTimeMillis();
			solve();
			out.flush();
			reader.close();
			writer.close();
			long t2 = System.currentTimeMillis();
			System.err.println("Time = " + (t2 - t1));
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	String nextToken() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

}