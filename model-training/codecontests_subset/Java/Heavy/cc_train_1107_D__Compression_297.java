import java.util.*;
import java.io.*;
public class A{
    public static void main(String[] args) throws  Throwable{
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        int n = sc.nextInt();
        ArrayList<Integer> primeFactors = new ArrayList<Integer>();
        ArrayList<Integer> primeFactorsPower = new ArrayList<Integer>();
        
        ArrayList<Integer> primes = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        boolean[] composite = new boolean[n+1];
        for(int i=2;i<=n;i++){
            if(!composite[i]){
                primes.add(i);
                for(int j=i;j<=n;j+=i){
                    composite[j] = true;
                }
            }
        }
        int nn = n;
        for(int p : primes){
            if(nn % p == 0){
                int cnt = 0;
                while(nn % p == 0){
                    nn/=p;
                    cnt++;
                }
                primeFactors.add(p);
                primeFactorsPower.add(cnt);
           }
        }
        // System.out.println(primes);
        arr = new int[n][n/4];
        for(int i=0;i<n;i++){
            String s = sc.next();
            for(int j=0;j<n/4;j++){
                int x = s.charAt(j);
                if(x >= 'A' && x <= 'Z')
                    x = s.charAt(j) - 'A' + 10;
                else
                    x = s.charAt(j) - '0';
                arr[i][j] = x;
            }
            // for(int j=0;j<n;j++){
            //     System.out.print(get(i,j));
            // }
            // System.out.println();
        }
        // System.out.println(divs);
        int res = 1;
        for(int d=primeFactors.size() - 1;d>=0;d--){
            int element = primeFactors.get(d);
            int num = element;
            int contribution = 1;
            outer :for(int pow = 1;pow <= primeFactorsPower.get(d);pow++){
                int x = num;
                for(int i=0;i<n/x;i++)
                    for(int j=0;j<n/x;j++){
                        int rep = get(i*x, j*x);
                        for(int ii = 0;ii < x;ii++)
                            for(int jj=0;jj < x;jj++){
                                if(rep != get(i*x+ii,j*x+jj)){
                                    continue outer;
                                }
                            }
                    }
                contribution = num;
                num*=element;
            }
            res*=contribution;
        }
        System.out.println(res);



    }

    static int[][] arr;

    static int get(int i, int j){
        int x = arr[i][(j/4)] & (1<< (3 - (j%4)));
        return x == 0 ? 0 : 1;
    }

    static class Scanner {
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
			return Double.parseDouble(next());
		}

		public boolean ready() throws IOException {
			return br.ready();
		}
	}
}