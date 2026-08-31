import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Kstring {
	
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader fr = new FastReader();
		int n = fr.nextInt();
		String input = fr.next();
		int alp[] = new int[26];
		char s[] = input.toCharArray();
		
			 if(s.length%n!=0)
			{
				System.out.println(-1);
				return;
			}
	
	        for(int i=0;i<s.length;i++)
	        {
	            alp[s[i]-97]++;
	 
	        }
	 
	 
	 
	        for(int i=0;i<alp.length;i++)
	        {
	           if(alp[i]%n!=0)
	           {
	               System.out.println(-1);
	               return;
	           }
	 
	        }
	 
	        StringBuilder sb=new StringBuilder();
	        for(int i=0;i<alp.length;i++)
	        {
	 
	            for(int j=0;j<alp[i]/n;j++)
	            	sb.append((char)(i+97));
	 
	        }
	 
	        for(int i=0;i<n;i++)
	        System.out.print(sb.toString());
	}

}
