import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int T = in.nextInt();
        for (int i=0;i<T;i++) {
        	int N = in.nextInt();
        	int[] K = new int[N];
        	int[] L = new int[N];
        	int[] R = new int[N];
        	long ans = 0L;
        	ArrayList<HashSet<Integer>> list_l = new ArrayList<HashSet<Integer>>();
        	ArrayList<HashSet<Integer>> list_r = new ArrayList<HashSet<Integer>>();
        	for (int j=0;j<N;j++) {
        		HashSet<Integer> add_l = new HashSet<Integer>();
        		HashSet<Integer> add_r = new HashSet<Integer>();
        		list_l.add(add_l);
        		list_r.add(add_r);
        	}
        	for (int j=0;j<N;j++) {
        		K[j] = in.nextInt();
        		L[j] = in.nextInt();
        		R[j] = in.nextInt();
        		// ans += Math.min(L[j], R[j]);
        		if (L[j]>=R[j]) {
        			list_l.get(K[j]-1).add(j);
        			ans += L[j];
        		} else {
        			list_r.get(K[j]-1).add(j);
        			ans += R[j];
        		}
        	}
        	PriorityQueue<int[]> pq_l = new PriorityQueue<int[]>((o1, o2)->Integer.compare(o1[0], o2[0]));
        	for (int j=0;j<N;j++) {
        		for (Integer tmp : list_l.get(j)) {
        			int[] add = {L[tmp]-R[tmp]};
        			pq_l.add(add);
        		}
        		while (pq_l.size()>j+1) {
        			ans -= pq_l.poll()[0];
        		}
        	}
        	PriorityQueue<int[]> pq_r = new PriorityQueue<int[]>((o1, o2)->Integer.compare(o1[0], o2[0]));
        	for (int j=N-1;j>=0;j--) {
        		for (Integer tmp : list_r.get(j)) {
        			int[] add = {R[tmp]-L[tmp]};
        			pq_r.add(add);
        		}
        		while (pq_r.size()>(N-1)-j) {
        			ans -= pq_r.poll()[0];
        		}
        	}
        	out.println(ans);
        }

		out.close();
	}

	static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
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

    }
}
