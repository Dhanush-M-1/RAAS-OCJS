import java.io.BufferedReader;
	import java.io.InputStreamReader;
	import java.io.PrintWriter;
	import java.math.BigInteger;


	public class Round388div22bulb2016 implements Runnable{

		BufferedReader c;
		PrintWriter pout;
		static long mod = 1000000007;

		public void run() {
			try {
				c = new BufferedReader(new InputStreamReader(System.in));
				pout = new PrintWriter(System.out, true);

				solve();
				pout.close();

			} catch (Exception e) {

				pout.close();
				e.printStackTrace();
				System.exit(1);

			}
		}

		public static void main(String[] args) throws Exception {
			new Thread(new Round388div22bulb2016()).start();
		}

		void solve() throws Exception {

			String s[] = c.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int m = Integer.parseInt(s[1]);
			boolean check[] = new boolean[m+1];
			while(n-->0){
				s = c.readLine().split(" ");
				boolean first = true;
				for(String input:s){
					if(!first)
					check[Integer.parseInt(input)]=true;
					else
						first = false;
				}
			}
			boolean flag = true;
			for(int i=1;i<=m;i++){
				if(!check[i]){
					flag = false;
					break;
				}
			}
			if(flag)
				pout.println("YES");
			else
				pout.println("NO");
		}
	}


