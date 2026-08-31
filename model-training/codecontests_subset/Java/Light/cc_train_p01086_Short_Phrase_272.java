import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

public class Main {
	int N;
	int[] w,len = {5,7,5,7,7};

	public boolean dfs(int i,int k,int now){
		if(k == 5){
			return true;
		}

		if(now == len[k]){
			return dfs(i,k + 1,0);
		}

		if(i >= N)return false;
		if(now  < len[k]){
			return dfs(i + 1,k,now + w[i]);
		}else{
			return false;
		}
	}

	public void solve() {
		w = new int[40];
		while(true){
			N = nextInt();

			if(N == 0)break;
			for(int i = 0;i < N;i++){
				w[i] = next().length();
			}
			int ans = 0;
			for(int i = 0;i < N;i++){
				if(dfs(i,0,0)){
					ans = i + 1;
					break;
				}
			}
			out.println(ans);
		}
	}

    public static void main(String[] args) {
        out.flush();
        new Main().solve();
        out.close();
    }

    /* Input */
    private static final InputStream in = System.in;
    private static final PrintWriter out = new PrintWriter(System.out);
    private final byte[] buffer = new byte[2048];
    private int p = 0;
    private int buflen = 0;

    private boolean hasNextByte() {
        if (p < buflen)
            return true;
        p = 0;
        try {
            buflen = in.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (buflen <= 0)
            return false;
        return true;
    }

    public boolean hasNext() {
        while (hasNextByte() && !isPrint(buffer[p])) {
            p++;
        }
        return hasNextByte();
    }

    private boolean isPrint(int ch) {
        if (ch >= '!' && ch <= '~')
            return true;
        return false;
    }

    private int nextByte() {
        if (!hasNextByte())
            return -1;
        return buffer[p++];
    }

    public String next() {
        if (!hasNext())
            throw new NoSuchElementException();
        StringBuilder sb = new StringBuilder();
        int b = -1;
        while (isPrint((b = nextByte()))) {
            sb.appendCodePoint(b);
        }
        return sb.toString();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }
}