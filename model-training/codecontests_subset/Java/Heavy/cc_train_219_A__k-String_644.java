import java.util.*;
import java.io.*;
public class Main{
    public static void main(String args[]) {
        Scanner scan = new Scanner();
        int k = scan.nextInt();
        String s = scan.nextLine();
        Map<Character,Integer> map=new HashMap<>();
        for(char c : s.toCharArray())
        {
            if(!map.containsKey(c))
            map.put(c,1);
            else
            map.put(c,map.get(c)+1);
        }
        String s1 ="";
        boolean flag=true;
        for(Map.Entry<Character,Integer> entry : map.entrySet())
        {
            int n = (int)entry.getValue();
            char c = (char)entry.getKey();
            if(n%k!=0)
            {
                flag=false;
                break;
            }
            int m=n/k;
            while(m-->0)
            {
            s1+=""+c;
            }
        }
        if(flag)
        {
        while(k-->0)
        out.print(s1);
            
        }
        else
        out.println(-1);
        out.close();
    }
    	static	PrintWriter out=new PrintWriter(System.out);
	static class Scanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String nextLine() {
			while (!st.hasMoreTokens())
				try { 
                                        st=new StringTokenizer(br.readLine());				               
                                } catch (IOException e) {}
			return st.nextToken();
		}
		char nextChar() {
			char c = '$';
				try { 
                                        c = (char)br.read();			               
                                } catch (IOException e) {}
			return c;
		}		
		int nextInt() {
			return Integer.parseInt(nextLine());
		}
		double nextDouble() {
			return Double.parseDouble(nextLine());
		}
		long nextLong() {
			return Long.parseLong(nextLine());
		}
	}
}