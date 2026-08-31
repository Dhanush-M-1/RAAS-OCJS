import java.io.BufferedReader;
import java.io.InputStreamReader;


public class _268A {
	
	public static BufferedReader in;
	public static int N, count;
	public static int[][] uni;
	
	public static void main(String[] args) throws Exception {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		uni = new int[N][2];
		String[] line;
		for (int i = 0; i < N; i++) {
			
			line = in.readLine().split(" ");
			uni[i][0] = Integer.parseInt(line[0]);
			uni[i][1] = Integer.parseInt(line[1]);
			
		}
		
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) {
				
				if (i == j)
					continue;
				
				if (uni[i][0] == uni[j][1])
					count++;
				
			}
		
		System.out.println(count);
		
		in.close();
		System.exit(0);
		
	}

}
