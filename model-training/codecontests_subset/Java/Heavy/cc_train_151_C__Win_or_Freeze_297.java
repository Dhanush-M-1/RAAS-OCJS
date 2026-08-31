import java.io.*;
import java.math.BigInteger;
import java.util.*;
		
public class Main {

		private BufferedReader input;
		private PrintWriter output;
		private StringTokenizer stoken;
		
		String fin = "input";
		String fout = "output";
		

		private void solve() throws IOException {
			
			/*
			int n = nextInt();
			int k = nextInt();
			int l = nextInt();
			
			int drink = k * l;
			
			int c = nextInt();
			int d = nextInt();
			
			int lime = c*d;
			
			int p = nextInt();

			int nl = nextInt();
			int np = nextInt();
			
			int res = Math.min(drink/nl, lime);
			res  = Math.min(res, p/np);
			
			res = res / n;
			
			output.print(res);
			*/
			
			
			/*
			int n = nextInt();
			
			ArrayList<String> res1 = new ArrayList<String>();
			int max1 = 0;
			ArrayList<String> res2 = new ArrayList<String>();
			int max2 = 0;
			ArrayList<String> res3 = new ArrayList<String>();
			int max3 = 0;
			
			for (int i=0; i<n; i++) {
				int k = nextInt();
				String name = nextToken();
				
				int a1 = 0;
				int a2 = 0;
				int a3 = 0;
				for (int j=0; j<k; j++) {
					String number = nextToken();
					number = number.replaceAll("-", "");
					boolean key1 = true;
					boolean key2 = true;
					for (int ii=1; ii<number.length(); ii++) {
						if ( number.charAt(ii) != number.charAt(ii-1) ) key1 = false;
						if ( number.charAt(ii) >= number.charAt(ii-1) ) key2 = false;
					}
					if (key1) {
						a1++;
					} else if (key2) {
						a2++;
					} else {
						a3++;
					}
				}
				
				
				if (a1 > max1) {
					max1 = a1;
					res1 = new ArrayList<String>();
					res1.add(name);
				} else if (a1 == max1) res1.add(name);
				
				if (a2 > max2) {
					max2 = a2;
					res2 = new ArrayList<String>();
					res2.add(name);
				} else if (a2 == max2) res2.add(name);
				
				if (a3 > max3) {
					max3 = a3;
					res3 = new ArrayList<String>();
					res3.add(name);
				} else if (a3 == max3) res3.add(name);
			}
			
			output.print("If you want to call a taxi, you should call: ");
			for (int i = 0; i<res1.size()-1; i++) {
				output.print(res1.get(i) + ", ");
			}
			output.print(res1.get(res1.size()-1) + ".");
			output.println();
			
			output.print("If you want to order a pizza, you should call: ");
			for (int i = 0; i<res2.size()-1; i++) {
				output.print(res2.get(i) + ", ");
			}
			output.print(res2.get(res2.size()-1) + ".");
			output.println();

			
			output.print("If you want to go to a cafe with a wonderful girl, you should call: ");
			for (int i = 0; i<res3.size()-1; i++) {
				output.print(res3.get(i) + ", ");
			}
			output.print(res3.get(res3.size()-1) + ".");
			*/
			
			/*
			ArrayList<Integer> prost = new ArrayList<Integer>();
			prost.add(2);
			for (int i=3; i<1000; i=i+2) {
				boolean isProst = true;
				for (int j=0; j<prost.size(); j++) {
					if (i % prost.get(j) == 0) {
						isProst = false;
						break;
					}
				}
				if (isProst) prost.add(i);
			}
			*/
			
			/*
			for (int j=2; j<100; j++) {
				int nn = j;
				int sqrt = (int) (Math.sqrt(nn)) + 1;
				
				output.print(j + ": ");
				for (int i=2; i<=sqrt; i++) {
					if (nn % i == 0) output.print(i + " ");
				}
				output.println();
			}
			
			
			output.println("===========================");
			*/

			
			long n = nextLong();
			//int n = 12;

//for (int ii=2; ii<100; ii++) {
//	n = ii;

			ArrayList<Integer> del = new ArrayList<Integer>();
			int sqrtN = (int) (Math.sqrt(n)) + 1;
			//sqrtN = (int) (n / 2);
			for (int i=2; i<=sqrtN; i++) {
				if (n % i == 0) del.add(i);
			}
			
			if (del.size() > 0 && n != 2) {
				int a = del.get(0);
				boolean find = false;
				int k = 0;
				for (int i=0; i<del.size(); i++) { 
					k = (int) a * del.get(i);
					if ( del.indexOf(k) > 0 || (n % k == 0 && n != k) ) {
						find = true;
						break;
					}
				}
				
				if (!find) {
					output.println("2");
				} else {
					output.println("1");
					output.println(k);
				}
			} else {
				output.println("1");
				output.println("0");
			}
			
//	output.println("--------------");
//}			
			
			

		}

		

		Main() throws IOException {
				//input = new BufferedReader(new InputStreamReader(System.in));
				//output = new PrintWriter(System.out);

				//input = new BufferedReader(new FileReader(fin + ".txt"));
				//output = new PrintWriter(new FileWriter(fout + ".txt"));
			

				//input = new BufferedReader(new FileReader(fin + ".txt"));
				input = new BufferedReader(new InputStreamReader(System.in));
				output = new PrintWriter(System.out);
				
				
				solve();

				
				input.close();
				output.flush();
				output.close();
		}

		
		int nextInt() {
				return Integer.parseInt(nextToken());
		}

		
		long nextLong() {
				return Long.parseLong(nextToken());
		}

		double nextFloat() {
				return Float.parseFloat(nextToken());
		}

		double nextDouble() {
				return Double.parseDouble(nextToken());
		}
		

		String nextToken() {
				while ((stoken == null) || (!stoken.hasMoreTokens())) {
						try {
								String line = input.readLine();
								stoken = new StringTokenizer(line);
						} catch (IOException e) {
								e.printStackTrace();
						}
				}
				return stoken.nextToken();
		}
		

    
		public static void main(String[] args) throws IOException {
				new Main();
		}

}

