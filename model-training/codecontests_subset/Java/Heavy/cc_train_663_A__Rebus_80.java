
/**
 * @author kunal05
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		final long start = System.currentTimeMillis();		
		new Task1().solve(in, out);
		@SuppressWarnings("unused")
		final long duration = System.currentTimeMillis()-start;
		out.close();
	}

	static class Task1{
		static final int PLUS	= -1000001;
		static final int MINUS	= -1000002;
		static final int SPACE	= -1000003;
		boolean positive;
		public void solve(InputReader in, PrintWriter out){
			String s = in.nextLine();
			positive = true;
			ArrayList<Integer> answer = new ArrayList<Integer>();

			int pos=0, neg=0, ii=0, last_pos_pve =0, last_pos_nve = -1;

			while(s.charAt(ii) != '='){
				if(s.charAt(ii) == '?'){
					answer.add(1);
					if(positive){
						pos++;
						last_pos_pve = ii;
					} else {
						neg++;
						last_pos_nve = ii;
					}
				} else if (s.charAt(ii) == '+') {
					positive = true;
					answer.add(PLUS);
				} else if (s.charAt(ii) == '-') {
					positive = false;
					answer.add(MINUS);
				} else {
					answer.add(SPACE);
				}
				ii++;
			}
			Integer n = Integer.parseInt(s.substring(ii+2));
			
			if(!check(pos, neg, n)){
				out.println("Impossible");
				return;
			}

			int balance=0, quo=0, rem=0, it, offset = 0;
			

			// cases possible
			/**
			 * Important point : Should not print zero.. so if balance == 0.. must be set to something
			 * Use offset
			*/
			if (pos <= n || (neg > (pos-n))) {
				/*	- Then we need to balance positives.
					- i.e., set all neg to 1 (effectively -1) and sum of negatives will be neg
						quo = (neg + n)/pos;
						remaining balance = (neg + n)%pos;
					- Set all pos to quo
					- Traverse for all positive numbers and increment each by 1 till balance != 0
				*/
				balance = n+neg;
				quo = balance/pos;
				balance = balance%pos;
				
				positive = true;
				for (int i=0; i<answer.size(); i++) {
					it = answer.get(i);
					if (it == SPACE) {
						continue;
					} else if (it == MINUS) {
						positive = false;
						continue;
					} else if (it == PLUS) {
						positive = true;
						continue;
					} else {
						if (positive) {
							answer.set(i, quo);
						} else {
							answer.set(i, 1);
						}
					}
				}

				positive = true;
				for(int i=0; i<answer.size(); i++){
					if(balance == 0){
						break;
					}
					it = answer.get(i);
					if (it == PLUS) {
						positive = true;
					} else if (it == MINUS) {
						positive = false;
					} else if (it == SPACE) {
						//
					} else{
						if(positive){
							answer.set(i, quo+1);
							balance--; 
						}
					}
				}
			} else if (pos>n) {
				//System.out.println(" I am here");
				/*	- Then we need to balance negatives but all negative should be atleast 1
					- i.e., set all pos to 1 (effectively +1) and sum of positives will be pos
						quo = (pos + n)/neg;
						rem = (pos + n)%neg;
					- Set all neg to quo
					- Traverse for all negative numbers and increment each by 1 til balance != 0
				*/
				balance = pos-n;
				quo = balance/neg;
				balance = balance%neg;
				
				positive = true;
				for (int i=0; i<answer.size(); i++) {
					it = answer.get(i);
					if (it == SPACE) {
						continue;
					} else if (it == MINUS) {
						positive = false;
						continue;
					} else if (it == PLUS) {
						positive = true;
						continue;
					} else {
						if (positive) {
							answer.set(i, 1);
						} else {
							answer.set(i, quo);
						}
					}
				}

				positive = true;
				for(int i=0; i<answer.size(); i++){
					if(balance == 0){
						break;
					}
					it = answer.get(i);
					if (it == PLUS) {
						positive = true;
					} else if (it == MINUS) {
						positive = false;
					} else if (it == SPACE) {
						//
					} else{
						if(!positive){
							answer.set(i, quo+1);
							balance--; 
						}
					}
				}
			} 

			// printing the result
			out.println("Possible");
			for(int i=0; i<answer.size(); i++){
				it = answer.get(i);
				if (it == PLUS) {
					out.print("+");
				} else if(it == MINUS) {
					out.print("-");
				} else if(it == SPACE) {
					out.print(" ");
				} else {
					out.print(it);
				}
			}
			out.println("= "+n);

		}

		static boolean check(int positive_count, int negative_count, int n){
			int min = positive_count - negative_count*n;
			int max = positive_count*n - negative_count;
			return (n<=max) && (n>=min);
		}
	}
	
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;
		
		public InputReader() {
			reader = new BufferedReader(new InputStreamReader(System.in));
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
			String s=null;
			try{
				s = reader.readLine();
			} catch(IOException e){
				throw new RuntimeException(e);
			}
			return s;
        }
		
		public String nextParagraph() {
			String line=null;
			String ans = "";
			try{
				while ((line = reader.readLine()) != null) {
				ans += line;
				}
			} catch(IOException e){
				throw new RuntimeException(e);
			}
			return ans;
		}
		
	}
}