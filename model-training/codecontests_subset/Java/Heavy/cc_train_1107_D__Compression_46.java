import java.io.*;

public class compression{
	
	public static void main (String [] args) throws Exception {
	    BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	    int N = Integer.parseInt(f.readLine());
	    
	    int[][] pSum = new int[N+1][N+1];
	    for(int i=0;i<N;i++){
            String str = f.readLine();
            int ct =0;
            for(char x : str.toCharArray()){
                int z = Integer.parseInt(x+"",16);
                for(int j=3;j>=0;j--){
                    pSum[i+1][ct+1]=(z&(1<<j))>0 ? 1: 0;
                    ct++;
                }
            }
        }
	    
	    for(int i = 1; i < N+1; i++) {
	    	for(int j = 2; j < N+1; j++) {
	    		pSum[i][j] = pSum[i][j-1] + pSum[i][j];
	    	}
	    }
	    for(int i = 1; i < N+1; i++) {
	    	for(int j = 2; j < N+1; j++) {
	    		pSum[j][i] = pSum[j-1][i] + pSum[j][i];
	    	}
	    }
	    
	    //for(int[] each: pSum)
	    //	System.out.println(Arrays.toString(each));
	    	    
	    for(int i = N; i >= 2; i--) {
	    	if(N % i == 0) {
		    	if(solve(pSum, i)) {
		    		out.println(i);
		    		out.close();
		    		System.exit(0);
		    	}
	    	}
	    }
	    out.println(1);
	    out.close();
	    f.close();
	}
	
	static boolean solve(int[][] pSum, int div) {
		for(int i = div; i < pSum.length; i+= div) {
			for(int j = div; j < pSum.length; j+= div) {
				int X = pSum[i][j] - pSum[i-div][j] - pSum[i][j-div] + pSum[i-div][j-div];
				if(X != 0 && X != div * div)
					return false;
			}
		}
		return true;
	}
	
}