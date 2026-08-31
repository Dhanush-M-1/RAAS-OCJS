import java.io.*;
import java.util.StringTokenizer;

class Main {
	public static void main(String args[]) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String buf;

		try {
			int c[] = {0,0};
			while ((buf = br.readLine())!=null) {
				StringTokenizer st = new StringTokenizer(buf,",");
				int l[] = new int[3];
				for (int i=0;i<3;i++) l[i] = Integer.parseInt(st.nextToken());
	
				if (Math.pow(l[0],2)+Math.pow(l[1],2)==Math.pow(l[2],2)) c[0]++;
				if (l[0]==l[1]) c[1]++;
			}
			System.out.println(c[0]);
			System.out.println(c[1]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}