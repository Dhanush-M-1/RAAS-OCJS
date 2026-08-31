import java.io.*;
public class ArraySharpening {
	private static StreamTokenizer st;
	private static int nextInt() throws IOException{
		st.nextToken();
		return (int)st.nval;
	}
	public static void main(String[] args) throws IOException{
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int t = nextInt();
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		for(int x = 0; x < t; ++x) {
			int n = nextInt();
			boolean increase = true, ret = true;
			int last = 0, num = 0;
			for(int i = 0; i < n; ++i) {
				int a = nextInt();
				if(!ret)continue;
				if(increase) {
					if(a<num) {
						increase = false;
						num = last;
						if(num < n-i)ret = false;
						else num = Math.min(n-i, num);
					}
					else ++num;
				}
				if(!increase) {
					--num;
					if(a<num || num<0) ret = false;
				}
				last = a;
			}
			if(ret)pw.println("Yes");
			else pw.println("No");
		}
		pw.close();
	}

}
