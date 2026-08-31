import java.io.*;
import java.util.*;

public class second {
	public static void main(String[] args) throws IOException {
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(rd.readLine());
		x0 = Integer.parseInt(st.nextToken());
		y0 = Integer.parseInt(st.nextToken());
		x1 = Integer.parseInt(st.nextToken());
		y1 = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(rd.readLine());
		R = new int[N];
		A = new int[N];
		B = new int[N];
		for(int i=0; i<N; i++){
			st = new StringTokenizer(rd.readLine());
			R[i] = Integer.parseInt(st.nextToken());
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
			for(int y=A[i]; y<=B[i]; y++){
				set.add(tolong(R[i], y));
			}
		}
		Queue<Integer> Qx = new LinkedList<Integer>(), Qy = new LinkedList<Integer>(), QCnt = new LinkedList<Integer>();
		HashSet<Long> been = new HashSet<Long>();
		been.add(tolong(x0, y0));
		Qx.add(x0); Qy.add(y0); QCnt.add(0);
		while(!Qx.isEmpty()){
			int x = Qx.poll(), y = Qy.poll(), cnt = QCnt.poll();
			for(int i=0; i<8; i++){
				int x2 = x+dx[i], y2 = y+dy[i];
				if(x1==x2 && y1==y2){
					pw.println(1+cnt);
					pw.flush();
					return;
				}
				long l1 = tolong(x2, y2);
				if(set.contains(l1) && !been.contains(l1)){
					been.add(l1);
					Qx.add(x2);
					Qy.add(y2);
					QCnt.add(1+cnt);
				}
			}
		}
		pw.println(-1);
		pw.flush();
	}
	
	
	
	static long tolong(int x, int y){
		return BIG*x+y;
	}
	
	static final long BIG = 1000000003;
	
	static HashSet<Long> set = new HashSet<Long>();
	
	static int[] dx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1}, 
			  	 dy = new int[]{1, -1, 0, -1, 1, 0, -1, 1};
	
	static int x0, y0, x1, y1;
	
	static int[] R, A, B;
	
	static int N;
	
}