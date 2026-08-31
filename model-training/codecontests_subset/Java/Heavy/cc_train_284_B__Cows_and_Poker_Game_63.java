
import java.io.*;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) throws IOException {
    
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int a = 0, i = 0;
        
        String line = sc.next();
        for(int k = 0; k < n; k++)
            if(line.charAt(k) == 'I')
                i++;
            else
                if(line.charAt(k) == 'A')
                    a++;
        if(i > 1)
            System.out.println(0);
        else
            if(i == 1)
                System.out.println(1);
            else
                System.out.println(a);
        
    }
    
    
    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s){  br = new BufferedReader(new InputStreamReader(s));}

        public String next() throws IOException 
        {
            while (st == null || !st.hasMoreTokens()) 
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {return Integer.parseInt(next());}
        
        public long nextLong() throws IOException {return Long.parseLong(next());}

        public String nextLine() throws IOException {return br.readLine();}

        public boolean ready() throws IOException {return br.ready();}


    }
}
