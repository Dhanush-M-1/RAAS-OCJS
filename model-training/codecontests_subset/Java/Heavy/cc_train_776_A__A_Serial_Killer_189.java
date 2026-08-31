 import java.io.*;
import java.util.*;
import javafx.util.Pair;
import javax.swing.*;
 



public class Codeforces {

 static PrintWriter pw=new PrintWriter(System.out);

 
 
 
    public static void main(String[] args) throws IOException {
      Reader.init(System.in);
      StringBuilder ans;
      String name1,name2;
      name1=Reader.next();
      name2=Reader.next();
      ans=new StringBuilder("");
      
      int n=Reader.nextInt();
      
      ans.append(name1+" "+name2+"\n");
      
        for (int i = 0; i < n; i++) {
            String newname1=Reader.next();
            String newname2=Reader.next();
            
            if(!newname1.equals(name1)&&!newname1.equals(name2))
            {
            if(!name1.equals(newname1)&&!name2.equals(newname2))
            name2=newname1;
            
            else name1=newname1;
            
            
            
            }
            else {
             if(!name1.equals(newname1)&&!name2.equals(newname2))
            name2=newname2;
            
            else name1=newname2;
            
            
            
            }
            ans.append(name1+" "+name2+"\n");
            
        }

        pw.println(ans);
        pw.close();
      }
}
 
 
class Reader {
 
        static BufferedReader reader;
        static StringTokenizer tokenizer;
 
        public static int pars(String x) {
            int num = 0;
            int i = 0;
            if (x.charAt(0) == '-') {
                i = 1;
            }
            for (; i < x.length(); i++) {
                num = num * 10 + (x.charAt(i) - '0');
            }
 
            if (x.charAt(0) == '-') {
                return -num;
            }
 
            return num;
        }
 
        static void init(InputStream input) {
            reader = new BufferedReader(
                    new InputStreamReader(input));
            tokenizer = new StringTokenizer("");
        }
 
        static void init(FileReader input) {
            reader = new BufferedReader(input);
            tokenizer = new StringTokenizer("");
        }
 
        static String next() throws IOException {
            while (!tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(
                        reader.readLine());
            }
            return tokenizer.nextToken();
        }
 
        static int nextInt() throws IOException {
            return pars(next());
        }
 
        static long nextLong() throws IOException {
            return Long.parseLong(next());
        }
 
        static double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    } 

class pair implements Comparable<pair>
	{
		long first, second;

     pair() {
    }
     
              
                 
                
		pair(long a, long b)
		{
			first= a;  second = b;
		}

   
		public int compareTo(pair q)
		{
			if(first<q.first)
      return 1;
      else if(first>q.first)
      return -1;
      if( second>q. second)
      return 1;
      else if( second<q. second)
        return -1;
      return 0;
		}	
	}