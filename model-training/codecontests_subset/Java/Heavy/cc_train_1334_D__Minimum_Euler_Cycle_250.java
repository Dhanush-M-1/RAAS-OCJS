import java.io.*;
import java.util.*;

public class C {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while(T-- > 0) {
			int n = sc.nextInt();
			long[] ams = new long[n-1];
//			long[] acc = new long[n-1];
			ams[0] = n-1;
//			acc[0] = ams[0];
			for(int i = 1; i < n-1; i++) {
				ams[i] = ams[i-1]-1;
//				acc[i] = acc[i-1] + ams[i];
			}
//			System.out.println(Arrays.toString(acc));
			long L = sc.nextLong()-1;
			long Lev = L / 2; if(L % 2 == 1) Lev++;
			long Lod = L / 2;
			long R = sc.nextLong()-1;
			long N = n;
			boolean flag = false;
			if(R == N*(N-1)) {
				R--; flag = true;
			}
			long Rev = R / 2; 
			long Rod = R / 2; if(R % 2 == 0) Rod--;
			LinkedList<Integer> evs = new LinkedList<Integer>();
			LinkedList<Integer> ods = new LinkedList<Integer>();
			//evs
			for(int i = 0; i < n-1; i++) {
				if(Lev >= ams[i]) {
					Lev -= ams[i]; Rev -= ams[i];
				}
				else {
					for(; Lev < ams[i] && Lev <= Rev; Lev++) {
						evs.add(i);
					}
					Lev -= ams[i]; Rev -= ams[i];
				}
			}
			//ods
			for(int i = 0; i < n-1; i++) {
				if(Lod >= ams[i]) {
					Lod -= ams[i]; Rod -= ams[i];
				}
				else {
					for(; Lod < ams[i] && Lod <= Rod; Lod++) {
						ods.add((int)Lod+i+1);
					}
					Lod -= ams[i]; Rod -= ams[i];
				}
			}
			if(L % 2 == 0) {
				while(!evs.isEmpty()) {
					sb.append(evs.removeFirst()+1+" ");
					if(!ods.isEmpty()) {
						sb.append(ods.removeFirst()+1+" ");
					}
				}
			}
			else {
				while(!ods.isEmpty()) {
					sb.append(ods.removeFirst()+1+" ");
					if(!evs.isEmpty()) {
						sb.append(evs.removeFirst()+1+" ");
					}
				}
			}
			if(flag) sb.append(1+" ");
			sb.replace(sb.length()-1, sb.length(),"\n");
		}
		PrintWriter pw = new PrintWriter(System.out);
		pw.print(sb.toString());
		pw.flush();
	}
	
	static class FastScanner {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in), 32768);
            tokenizer = null;
        }
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
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
        public String nextLine() {
        	try {
        		return reader.readLine();
        	} catch(IOException e) {
        		throw new RuntimeException(e);
        	}
        }
    }

}
