import java.util.*;
import java.io.*;

public class File {
    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));



		// Both
		// 7 9 10
		
		// Alice
		// 6
		
		// Bob
		// 




		int n = sc.nextInt();
		int k = sc.nextInt();
		
		List<Long> both = new ArrayList();
		List<Long> alice = new ArrayList();
		List<Long> bob = new ArrayList();			
		
		
		// Sort by order of time, increasing order:
		// Sort all books both like
		// Sort all books alice likes 
		// Sort all books bob likes
		// 3 pointers.
		// If double book is faster than individual books, read double.
		
		for (int i = 0; i < n; i++) {
			long t = sc.nextLong();
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if (a == 1 && b == 1) {
				both.add(t);
			}
			else if (a == 1 && b == 0) {
				alice.add(t);
			}
			else if (a == 0 && b == 1) {
				bob.add(t);
			}
		}
		
		
		boolean isPossible = true;
		
		if ((both.size() + alice.size() < k) || (both.size() + bob.size() < k)) {
			isPossible = false;
		}
		
		
		if (isPossible) {
			Collections.sort(both);
			Collections.sort(alice);
			Collections.sort(bob);
			
			long total = 0;
			int kAlice = k;
			int kBob = k;
			
			int bothIndex = 0;
			int aliceIndex = 0;
			int bobIndex = 0;
			
			
			while (kAlice > 0 && kBob > 0 && (aliceIndex < alice.size() || bobIndex < bob.size() || bothIndex < both.size())) {
				long bothTime = bothIndex < both.size() ? both.get(bothIndex) : Long.MAX_VALUE;
				long singleTime = (aliceIndex < alice.size() && bobIndex < bob.size()) ? alice.get(aliceIndex) + bob.get(bobIndex) : Long.MAX_VALUE;
				
				if (bothTime < singleTime) {
					total += bothTime;
					kAlice--;
					kBob--;
					bothIndex++;
				}
				else {
					total += singleTime;
					kAlice--;
					kBob--;
					aliceIndex++;
					bobIndex++;
				}
			}
			
			while (kAlice > 0) {
				if (bothIndex == both.size()) {
					total += alice.get(aliceIndex++);
				}
				else if (aliceIndex == alice.size()) {
					total += both.get(bothIndex++);
					kBob--;
				}
				else {
					if (both.get(bothIndex) < alice.get(aliceIndex)) {
						total += both.get(bothIndex++);				
						kBob--;
					}
					else {
						total += alice.get(aliceIndex++);
					}
				}
				
				kAlice--;
			}
			while (kBob > 0) {
				if (bothIndex == both.size()) {
					total += bob.get(bobIndex++);
				}
				else if (bobIndex == bob.size()) {
					total += both.get(bothIndex++);
					kAlice--;
				}
				else {
					if (both.get(bothIndex) < bob.get(bobIndex)) {
						total += both.get(bothIndex++);
						kAlice--;
					}
					else {
						total += bob.get(bobIndex++);
					}
				}
				
				kBob--;
			}
			
			
			out.println(total);
		}
		else {
			out.println(-1);
		}
		
		
		
		
		
		
		
		
		out.close();
	}
}











	