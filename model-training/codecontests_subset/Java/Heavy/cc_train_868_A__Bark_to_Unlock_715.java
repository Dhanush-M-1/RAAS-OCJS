import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A {
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		String pass = sc.nextLine();
		int num = sc.nextInt();
		String[] w = new String[num];
		for(int i = 0; i <w.length; i++ ) {
			w[i] = sc.nextLine();
		}
		/*Arrays.asList(w).forEach(k -> System.out.println(k + " "));
		System.out.println(w.length);
		System.out.println(w[num-1]);*/
		boolean is = false;
		for(int i = 0; i < num; i++) {
			if(w[i].contains(pass)) {
				is = true;
				break;
			}
			for(int j = 0; j < num; j++) {
				
				if(w[i].charAt(1) == pass.charAt(0) && w[j].charAt(0) == pass.charAt(1)) {
					is = true;
					break;
				}
			}
			if(is) {
				break;
			}
		}
		if(is) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
	
	static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt()
        {
            return Integer.parseInt(next());
        }
 
        long nextLong()
        {
            return Long.parseLong(next());
        }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}
