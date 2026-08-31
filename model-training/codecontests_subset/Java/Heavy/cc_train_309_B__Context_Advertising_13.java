import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class B {	
	BufferedReader reader;
    StringTokenizer tokenizer;
    PrintWriter out;
        
	public void solve() throws IOException {				
		int N = nextInt();
		int R = nextInt();
		int C = nextInt();
		int[] a = new int[N];
		String[] s = reader.readLine().split(" ");
		for(int i = 0; i < N; i++)
			a[i] = s[i].length();
		
		int max_bit = 20;
		int[][] can = new int[max_bit+1][N];
		int size = 0;
		int end = 0;
		for(int i = 0; i < N; i++){
			if(i > 0) size = size - a[i-1] - 1;
			while( end < N && size + a[end] <= C){
				size = size + a[end] + 1;
				end++;
			}
			can[0][i] = end - i;
		}
		
		for(int r = 0; r < max_bit; r++){
			for(int i = 0; i < N; i++){
				if( i+can[r][i] == N ) 
					can[r+1][i] = can[r][i]; 
				else 
					can[r+1][i] = can[r][i] + can[r][ i+can[r][i] ];
			}
		}
		
		int best = -1;
		int best_start = -1;
		for(int i = 0; i < N; i++){
			int cur = i;
			int score = 0;
			for(int b = max_bit; b >= 0; b--){
				if( (R >> b & 1) == 1){
					score += can[b][cur];
					cur += can[b][cur];
					
					if(cur >= N) break;
				}
			}			
			if( score > best ){
				best = score;
				best_start = i;
			}
		}
		
		int r_count = 0;
		while( best_start < N && r_count++ < R && can[0][best_start] > 0){
			for(int i = 0; i < can[0][best_start]; i++){
				out.print( s[best_start+i]);				
				if( i < can[0][best_start]-1) out.print(" ");
			}		
			out.println();
			best_start = best_start + can[0][best_start];
		}
		
		
//		out.println("can: ");
//		for(int i = 0; i < N; i++){
//			out.println( i + ": " + can[max_bit-1][i]);
//		}
		
//		for(int i = 0; i < N; i++)
//			a[i] = s[i].length();
//		int[] cum = new int[N];
//		
//		cum[0] = a[0];
//		for(int i = 1; i < N; i++)
//			cum[i] = cum[i-1] + a[i] + 1;
//		
//		int[] until = new int[N];		
//		for(int i = 0; i < N; i++){
//			int left = i;
//			int right = N-1;
//			while( left < right ){
//				int mid = (left + right) /2;
//				if( !isOK(cum, i, mid, C) )
//					right = mid;
//				else
//					left = mid+1;
//			}
//			if( !isOK(cum, i, left, C) )
//				left--;		
//						
//			if( left < i ) until[i] = -1;
//			else until[i] = left;
//		}
//		
//		out.println("debug until: ");
//		for(int i = 0; i < N; i++)
//			out.println( i + ": " + (until[i]-i+1) );
//		
//		ArrayList<Integer> effectiveN = new ArrayList<Integer>();
//		int start = 0;
//		int end = 0;		
//		while( end < N ){
//			if( until[start] == until[end] ){
//				end++;
//			}
//			else{
//				if( until[start] != -1)
//					effectiveN.add( start );
//				start = end;
//			}
//		}
//		if( until[start] != -1)
//			effectiveN.add( start );
//		
////		out.println("debug effective N: ");
////		for(int i = 0; i < effectiveN.size(); i++)
////			out.println( effectiveN.get(i) );
//		
//		int length = effectiveN.size();
//		int[] new_next = new int[length];
//		int[] new_size = new int[length];
//		int cur_effective_index = length-1;
//		int cur_effective = effectiveN.get(cur_effective_index);
//		new_next[length-1] = -1;
//		new_size[length-1] = until[ cur_effective ] - cur_effective + 1;		
//		for(int i = length-2; i >= 0; i--){
//			int cur = effectiveN.get(i);
//			while( effectiveN.get(cur_effective_index) > until[cur]+1  ){
//				cur_effective_index--;
//			}
//			if( cur_effective_index == i ){
//				new_next[i] = -1;
//				new_size[i] = until[cur] - cur + 1;
//			}
//			else{
//				new_next[i] = cur_effective_index;
//				
//				if( effectiveN.get(cur_effective_index) == until[cur]+1 )
//					new_size[i] = until[cur] - cur + 1;
//				else
//					new_size[i] = effectiveN.get(cur_effective_index) - cur + 1;
//			}
//		}
//		
////		out.println("debug newsize: ");
////		for(int i = 0; i < length; i++)
////			out.println( i + "("+ effectiveN.get(i) + ")" + ": " + new_size[i] );
////		
////		out.println("debug next: ");
////		for(int i = 0; i < length; i++)
////			out.println( i + "("+ effectiveN.get(i) + ")" + ": " + new_next[i] );
//		
//		int ans = -1;
//		int ans_start = -1;
//		int[][] dp = new int[R+1][length];
//		for(int r = 0; r < R; r++){
//			for(int n = 0; n < length; n++){
//				
//				if( new_next[n] != -1){
//					int increase = effectiveN.get(new_next[n]) - effectiveN.get(n);
//					if( dp[r][n] + increase > dp[r+1][new_next[n]] ){
//						dp[r+1][new_next[n]] = dp[r][n] + increase;
//					}					
//				}
//				
//				int tmp_ans = dp[r][n] +  (until[effectiveN.get(n)] - effectiveN.get(n) + 1);				
//				if( tmp_ans > ans){
//					ans = tmp_ans;
//					ans_start = n;
//					
////					out.println("ans: " + r + ", " + ans_start + ", " + effectiveN.get(ans_start) + ", " + ans);
//				}
//			}
//		}
//		
//		
//		int r_count = 1;
//		while( r_count < R){						
//			int search = ans_start;
//			while( search > 0 && new_next[search-1] >= ans_start )
//				search--;
//			if( new_next[search] != ans_start ) break;			
//			ans_start = search;
//			r_count++;
//		}
//		
//		r_count = 0;
//		while( r_count < R){
//			int l = effectiveN.get(ans_start);
//			int r = until[l];
//			if( new_next[ans_start] != -1 && r_count < R-1)
//				r = effectiveN.get( new_next[ans_start] )-1;
//						
//			for(int i = l; i <= r; i++){
//				out.print( s[i]);
//				if( i < r ) out.print(" ");
//			}
//			out.println();
//			r_count++;
//			
//			if(new_next[ans_start] == -1) break;
//			ans_start = new_next[ans_start];
//		}
//		
//		for(int i = 0; i < length; i++){
//			out.println( i + ": " + prev[i] );
//		}		
//		out.println(" debug ans: " +  ans + ", " + ans_start);
		
		
//		int[] mapping = new int[N];
//		Arrays.fill(mapping, -1);
//		for(int i = 0; i < effectiveN.size(); i++)
//			mapping[ effectiveN.get(i) ] = i;
		
//		int[] size = new int[ ];
//		int[] mapnext = new int[N];
//		int cur_effective = effectiveN.get(0);
//		for(int i = 0; i < N; i++){
//			if( next[i] >)
//		}
//		
//		int cur_effective_next = -1;
//
//		int cur_effective = effectiveN.size() ;
//		for(int i = N-1; i >= 0; i--){
//			if( mapping[ next[i] ] != -1 )
//				cur_effective = mapping[i];
//			
//			
//			if( next[i] == -1 ) {
//				mapnext[i] = effectiveN.size();  // imaginary 
//				continue;
//			}
//		}
//		
//		for(int i = 0; i < N; i++){
//			if( next[i] == -1 ) {
//				mapnext[i] = effectiveN.size();  // imaginary 
//				continue;
//			}
//			
//			if( mapping[ next[i] ] != -1 )
//				cur_effective_next = mapping[ next[i] ];
//			mapnext[i] = cur_effective_next;			
//		}
//					
//		out.println("debug mapping: ");
//		for(int i = 0; i < N; i++)
//			out.println( i + ": " + mapping[i] );
//		
//		out.println("debug mapnext: ");
//		for(int i = 0; i < N; i++)
//			out.println( i + ": " + mapnext[i] );
//		
//		if(true) return;
//		
//		int ans = 0;
//		int ans_n = -1;
//		int[][] dp = new int[R+1][ effectiveN.size()+1 ];
//		for(int r = 0; r < R; r++){
//						
//			for(int nn = 0; nn < effectiveN.size(); nn++){
//				int n = effectiveN.get(nn);
//				dp[r+1][ mapnext[n] ] = Math.max( dp[r+1][ mapnext[n] ], dp[r][nn] + size[n] );
//				
////				out.println("debug ans: " + next[n] + ", " + n + ", " + mapping[next[n]] );
//				
//				if( dp[r+1][ mapnext[n] ] > ans ){
//					ans = dp[r+1][ mapnext[n] ];
//					ans_n = n;
//				}			
//			}
//			
////			out.println("row: " + r);
////			for(int nn = 0; nn < effectiveN.size(); nn++){
////				int n = effectiveN.get(nn);
////				out.println( n + ": " + dp[r+1][nn] );
////			}
//			
//		}
		
//		out.println(" debug ans: " +  ans + ", " + ans_n);
		
		
//		int[] dp = new int[N];
//		for(int i = 0; i < N; i++){
//			dp[ until[i]+1 ] = Math.max( dp[ until[i]+1 ], dp[i] + until[i]-i+1 ); 
//		}

//		for(int i = 0; i < N; i++)			
//			out.println(until[i]);
	}
	
	public boolean isOK(int[] cum, int start, int end, int len){
		int need = cum[end];
		if( start > 0) need = need - cum[start-1] - 1;
		if( need <= len ) return true;		
		return false;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new B().run();
	}
	
	public void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
            out = new PrintWriter(System.out);
            solve();
            reader.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

}
