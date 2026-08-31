import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String args[]) {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String buf;

	try {
	    while (!(buf = br.readLine()).equals("-1 -1 -1")) {
		StringTokenizer st = new StringTokenizer(buf);
		int h = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int residual = 120*60-(h*3600+m*60+s);
		System.out.printf("%02d:%02d:%02d%n",residual/3600,(residual%3600)/60,residual%60);
		residual *= 3;
		System.out.printf("%02d:%02d:%02d%n",residual/3600,(residual%3600)/60,residual%60);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}