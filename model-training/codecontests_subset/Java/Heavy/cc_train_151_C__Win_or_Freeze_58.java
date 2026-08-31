import java.io.*; 
import java.util.*; 
  
public class C107 
{    
    public void solve() throws IOException  
    { 
      long q = nextLong();
      long[] div = new long[2];
      int root = (int) Math.sqrt(q);
      for (int i = 2; i <= root; i++) {
        if (q % i == 0) {
          if (div[0] == 0) {
            div[0] = i;
          } else {
            div[1] = i;
            break;
          }
        }
      }
      
      if (q == div[0] * div[0] * div[0]) {
        System.out.println(1);
        System.out.println(div[0] * div[0]);
      } else if (div[0] == 0) {
        System.out.println(1);
        System.out.println(0);
      } else if (div[1] == 0) {
        System.out.println(2);
      } else {
        System.out.println(1);
        System.out.println((div[1] % div[0] == 0) ? div[1] : div[0] * div[1]);
      }
    } 
  
    public BufferedReader br; 
    public StringTokenizer st; 
    public PrintWriter out; 
  
    public String nextToken() throws IOException { 
        while(st == null || !st.hasMoreTokens()) { 
            st = new StringTokenizer(br.readLine()); 
        } 
  
        return st.nextToken(); 
    } 
      
    public String nextLine() throws IOException { 
        return br.readLine(); 
    } 
  
    public int nextInt() throws IOException { 
        return Integer.parseInt(nextToken()); 
    } 
  
    public long nextLong() throws  IOException { 
        return Long.parseLong(nextToken()); 
    } 
  
    public double nextDouble() throws IOException { 
        return Double.parseDouble(nextToken()); 
    } 
  
    public void run() throws IOException  
    {    
        boolean oj = System.getProperty("ONLINE_JUDGE") != null; 
        oj = true; 
        br = new BufferedReader( new InputStreamReader( oj ? System.in : new FileInputStream("input.txt"))); 
        out = new PrintWriter( oj ? System.out : new FileOutputStream("output.txt")); 
        solve(); 
        out.close(); 
    } 
  
    public static void main(String[] args) throws IOException  
    { 
        new C107().run(); 
    } 
} 