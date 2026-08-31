
import java.util.*;
import java.io.*;
public class  B676B{
	
	static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        private FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

	 int[] nextIntArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
	}

	int[] nextIntArrayOne(int n) {
				int[] a = new int[n+1];
				for (int i = 1; i < n+1; i++)
					a[i] = nextInt();
				return a;
	}

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
    	FastReader s = new FastReader();
    	StringBuilder str = new StringBuilder();

		int t = s.nextInt();
		
		while(t-- >0) {
			int n = s.nextInt();
			char arr[][] = new char[n][n];
			
			for(int i = 0; i < n; i++) {
				arr[i] = s.nextLine().toCharArray(); 
			}
			
			if(arr[0][1] == arr[1][0]) {
				
				
				char cur = arr[0][1];
				int count = 0;
				StringBuilder sub = new StringBuilder();
				if(arr[n - 1][n - 2] == cur) {
					count++;
					sub.append((n) + " " + (n - 1) + "\n");
				}
				
				if(arr[n - 2][n - 1] == cur) {
					count++;
					sub.append((n - 1) + " " + (n) + "\n");
				}
				
				str.append(count +"\n");
				str.append(sub);
				
				
			}else {
				int zero = 0, one = 0;
				
				if(arr[0][1] == '0') {
					zero++;
				}else one++;
				
				if(arr[1][0] == '0') {
					zero++;
				}else one ++;
				
				if(arr[n - 1][n - 2] == '0') {
					zero++;
				}else one++;
						
				if(arr[n - 2][n - 1] == '0') {
					zero++;
				}else one ++;	
				
				if(zero == one) {
					str.append(2+"\n");
					
					if(arr[0][1] == '0') {
						str.append(1 + " " + 2 +"\n");
					}
					if(arr[1][0] == '0') {
						str.append(2 + " " + 1 +"\n");
					}
					
					if(arr[n - 1][n - 2] == '1') {
						str.append(n + " " + (n - 1) +"\n");
					}
							
					if(arr[n - 2][n - 1] == '1') {
						str.append((n - 1) + " " + n +"\n");
					}
					
					
				}else if(zero > one) {
					
					str.append(1+"\n");
					
					if(arr[0][1] == '0') {
						str.append(1 + " " + 2 +"\n");
					}
					if(arr[1][0] == '0') {
						str.append(2 + " " + 1 +"\n");
					}
					
					
					
				}else {
					str.append(1+"\n");
					
					if(arr[0][1] == '1') {
						str.append(1 + " " + 2 +"\n");
					}
					
					if(arr[1][0] == '1') {
						str.append(2 + " " + 1 +"\n");
					}
					
				}
				
			}
			
		}
		System.out.println(str);
     }



	

}

