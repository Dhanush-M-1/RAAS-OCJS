import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D {
	
	public static class StarrySkyTree {
		private static final long M_INF = Long.MIN_VALUE / 2 + 1;
		private static final long DEFAULT = 0; // �P�ʌ�

		int n; long[] add; //add�͏�L�̐���𖞂���.

		public StarrySkyTree(int n_) {
			int n = 1;
			while(n < n_){ n *= 2;} this.n = n;
			add = new long[this.n * 2 - 1];
			for(int i = 0; i < this.n * 2 - 1 ; i++){ add[i] = DEFAULT; }
		}

		// [a, b) �� v �𑫂�
		public void add(long v, int a, int b){ add(v, a, b, 0, 0, this.n); }
		private void add(long v, int a, int b, int k, int l, int r){
			if(k == 0){ add[k] += v; } // �S�̂ɉ��Z���Ă���.
			if(a <= l && r <= b) { return; } // ���S�ɔ͈͓�
			if(r <= a || b <= l) { add[k] -= v; return; } // ���S�ɔ͈͊O
			// �͈͊O���܂� -> �񕪊����čċA
			add(v, a, b, k * 2 + 1, l, (l + r) / 2);
			add(v, a, b, k * 2 + 2, (l + r) / 2, r);
			// �ǂ��炩�� 0 �ɂȂ�悤��, �q���̍ő�l���q����������Đe�ɑ���.
			final long child_max = Math.max(add[k * 2 + 1], add[k * 2 + 2]);
			add[k * 2 + 1] -= child_max; add[k * 2 + 2] -= child_max;
			add[k] += child_max;
		}

		// [a, b) �͈̔͂ł̍ő�l�����߂�
		public long max(long a, long b){ return max(a, b, 0, 0, this.n); }
		private long max(long a, long b, int k, int l, int r){
			if(r <= a || b <= l){ return M_INF; } // �ȒP�̂��ߓK���ɏ������l��Ԃ�.
			if(a <= l && r <= b){ return add[k]; } // �q����add�� 0 ��I�ׂ�.

			final long left_max  = max(a, b, k * 2 + 1, l, (l + r) / 2);
			final long right_max = max(a, b, k * 2 + 2, (l + r) / 2, r);
			return Math.max(left_max, right_max) + add[k]; //
		}

		// [index] �ł̒l�����߂�
		public long value(int index){
			int k = index + this.n - 1;
			long value = add[k];
			while(k > 0){ k = (k - 1) / 2; value += add[k]; }
			return value;
		}
	}
	
	public static void main(String[] args) {
		try (final Scanner sc = new Scanner(System.in)) {
			final int n = sc.nextInt();
			final long d = sc.nextLong();
			
			long[] as = new long[n];
			for(int i = 0; i < n; i++){
				as[i] = sc.nextLong();
			}
			
			StarrySkyTree rmq = new StarrySkyTree(n);
			for(int i = 0; i < n; i++){ rmq.add(as[i], i, n); }
			
			int answer = 0;
			for(int i = 0; i < n; i++){
				final long curr_val = rmq.value(i);
				if(curr_val > d){
					System.out.println(-1);
					return;
				}
				if(as[i] != 0){ continue; }
				if(curr_val >= 0){ continue; }
				
				final long back_max = rmq.max(i, n);
				final long can_up = d - back_max;
				if(can_up < 0){
					System.out.println(-1);
					return;
				}
				
				final long curr_up = Math.min(d, curr_val + can_up) - curr_val;
				//System.out.println(i + " : " + back_max + " " + can_up + " " + curr_up + " : " + (curr_val + curr_up));
				
				if(curr_val + curr_up < 0){ 
					System.out.println(-1);
					return;
				}
				
				rmq.add(curr_up, i, n);
				answer++;
			}
			
			System.out.println(answer);
		}
	}
		
	public static class Scanner implements Closeable {
		private BufferedReader br;
		private StringTokenizer tok;

		public Scanner(InputStream is) {
			br = new BufferedReader(new InputStreamReader(is));
		}

		private void getLine() {
			try {
				while (!hasNext()) {
					tok = new StringTokenizer(br.readLine());
				}
			} catch (IOException e) { /* ignore */
			}
		}

		private boolean hasNext() {
			return tok != null && tok.hasMoreTokens();
		}

		public String next() {
			getLine();
			return tok.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
		
		public long nextLong() {
			return Long.parseLong(next());
		}

		public void close() {
			try {
				br.close();
			} catch (IOException e) { /* ignore */
			}
		}
	}
}
