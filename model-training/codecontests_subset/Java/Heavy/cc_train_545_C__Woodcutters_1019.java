
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class knapsack {
	static int pos[];
	static int h[];
	static int n;
	static int memo[][];
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
	    pos=new int[n];
	    h=new int [n];
	    for(int i=0;i<n;i++) {
	    	pos[i]=sc.nextInt();
	    	h[i]=sc.nextInt();
	    }
	    memo=new int[(int)1e5+1][5];
	    for(int i=0;i<memo.length;i++) {
	    	Arrays.fill(memo[i], -1);
	    }
	    System.out.println(dp(0,0));
	}
	static int dp(int idx,int state) {// state 1 stay    2 left      3 right
		if(idx>=n)return 0;
		if(memo[idx][state]!=-1)return memo[idx][state];
		int stay=dp(idx+1,1);
		int left;
		if(state==0||((state==1||state==2)&&pos[idx]-pos[idx-1]>h[idx])||(state==3&&pos[idx]-pos[idx-1]-h[idx-1]-h[idx]>0)) {
			left=1+dp(idx+1,2);
		}
		
		else {
			left=-(int)1e9;
		}
		int right=0;
		if((idx<n-1&&pos[idx]+h[idx]<pos[idx+1])||idx==n-1) {
			right=1+dp(idx+1,3);
		}
		else {
			right=-(int)1e9;
		}
		return memo[idx][state]= Math.max(stay, Math.max(left, right));
		
	}
	
	
	static class Scanner {

        BufferedReader br;
        StringTokenizer st;

        Scanner(InputStream system) {
            br = new BufferedReader(new InputStreamReader(system));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }


	}

}

