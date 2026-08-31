import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.NoSuchElementException;
 
public class Main {
	private static FastScanner sc = new FastScanner();
	
	public static void main(String[] args) {
		int N = sc.nextInt();
		int M = sc.nextInt();
		long[] x = new long[N];
		for(int i=0; i<N; i++) {
			x[i] = Long.MIN_VALUE;
		}
		ArrayList<ArrayList<Info>> mainlist = new ArrayList<>();
		for(int i=0; i<N; i++) {
			mainlist.add(new ArrayList<>());
		}
		for(int i=0; i<M; i++) {
			Info info = new Info();
			info.L = sc.nextInt() - 1;
			info.R = sc.nextInt() - 1;
			info.D = sc.nextLong();
			mainlist.get(info.L).add(info);
			mainlist.get(info.R).add(info);
		}
		boolean[] checked = new boolean[N];
		ArrayDeque<Integer> que = new ArrayDeque<>();
		for(int i=0; i<N; i++) {
			if(checked[i]) continue;
			x[i] = 0;
			que.add(i);
			
			while(!que.isEmpty()) {
				int s = que.poll();
				if(checked[s]) continue;
				checked[s] = true;
				for(Info info : mainlist.get(s)) {
					if(x[info.L] == Long.MIN_VALUE && x[info.R] != Long.MIN_VALUE) {
						x[info.L] = x[info.R] - info.D;
						if(!checked[info.L]) que.add(info.L);
					} else if(x[info.R] == Long.MIN_VALUE && x[info.L] != Long.MIN_VALUE) {
						x[info.R] = x[info.L] + info.D;
						if(!checked[info.R]) que.add(info.R);
					} else if(x[info.R] != Long.MIN_VALUE && x[info.L] != Long.MIN_VALUE) {
						if(x[info.L] + info.D != x[info.R]) {
							System.out.println("No");
							return;
						}
					} else {
						System.out.println("No");
						return;
					}
				}
			}
		}	
		System.out.println("Yes");
	}
	
	static class Info {
		int L;
		int R;
		long D;
	}
	
	static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1024];
        private int ptr = 0;
        private int buflen = 0;
        private boolean hasNextByte() {
            if(ptr < buflen) {
                return true;
            } else {
                ptr = 0;
                try {
                    buflen = in.read(buffer);
                } catch(IOException e) {
                    e.printStackTrace();
                }
                if(buflen <= 0) {
                    return false;
                }
            }
            return true;
        }
        private int readByte() { if (hasNextByte()) return buffer[ptr++]; else return -1;}
        private static boolean isPrintableChar(int c) { return 33 <= c && c <= 126;}
        private void skipUnprintable() { while(hasNextByte() && !isPrintableChar(buffer[ptr])) ptr++;}
        public boolean hasNext() { skipUnprintable(); return hasNextByte();}
        public String next() {
            if (!hasNext()) throw new NoSuchElementException();
            StringBuilder sb = new StringBuilder();
            int b = readByte();
            while(isPrintableChar(b)) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }
        public long nextLong() {
            return Long.parseLong(next());
        }
        public int nextInt(){
            return Integer.parseInt(next());
        }
        public double nextDouble(){
            return Double.parseDouble(next());
        }
    }
}
