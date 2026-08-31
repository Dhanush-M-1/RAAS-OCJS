import java.util.*;
import java.io.*;
import java.math.*;
 
public class B
{
    static class Coord{
        int x, y;
        public Coord(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static boolean isValid(int x, int y, int n, boolean visited[][], 
        char arr[][], char req){
        return (x <= n && y <= n && x >= 1 && y >= 1 && !visited[x][y] && arr[x][y] == req);
    }

    static boolean bfs1(char arr[][], int n){
        boolean visited[][] = new boolean[n + 1][n + 1];
        Coord c = new Coord(1, 1);
        visited[1][1] = true;
        Queue<Coord> q = new LinkedList<>();  q.add(c);

        while(!q.isEmpty()){
            c = q.poll();
            int x = c.x, y = c.y, nx = 0, ny = 0;

            for(int i = 0; i < 4; i++){
                nx = x + dx[i]; ny = y + dy[i]; 
                if(nx == n && ny == n)
                    return true;

                if(isValid(nx, ny, n, visited, arr, '1')){ 
                    Coord nc = new Coord(nx, ny);
                    q.add(nc); 
                    visited[nx][ny] = true;
                }
            }
        }

        return false;
    }

    static boolean bfs0(char arr[][], int n){
        boolean visited[][] = new boolean[n + 1][n + 1];
        Coord c = new Coord(1, 1);
        visited[1][1] = true;
        Queue<Coord> q = new LinkedList<>();  q.add(c);

        while(!q.isEmpty()){
            c = q.poll();
            int x = c.x, y = c.y, nx = 0, ny = 0;

            for(int i = 0; i < 4; i++){
                nx = x + dx[i]; ny = y + dy[i];
                if(nx == n && ny == n)
                    return true;

                if(isValid(nx, ny, n, visited, arr, '0')){
                    q.add(new Coord(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }

        return false;
    }

    static void print_res(char a[][], char b[][], int n){
        String res = "";
        int cnt = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(a[i][j] != b[i][j]){
                    cnt++;
                    res += i + " " + j + "\n";
                }
            }
        }

        p(cnt + "\n" + res);
    }

    public static void process(int test_number)throws IOException
    {
        int n = ni();
        char grid[][] = new char[n + 1][], aux[][] = new char[n + 1][n + 1];
        for(int i = 1; i <= n; i++){
            grid[i] = ("#"+nln()).toCharArray();

            for(int j = 1; j <= n; j++)
                aux[i][j] = grid[i][j];
        } 

        grid[n - 1][n] = '0'; grid[n][n - 1] = '0';
        if(!bfs1(grid, n) && !bfs0(grid, n)){
            print_res(grid, aux,n);
            return ;
        }

        for(int i = 0; i <= 3; i++){
            int mask = i;
            char bit1 = Integer.toString((int)(mask & 1)).charAt(0); 

            mask /= 2;
            char bit2 =  Integer.toString((int)(mask & 1)).charAt(0); 

            //trace(bit1, bit2);
            
            grid[1][2] = bit1; grid[2][1] = bit2;
            if(!bfs1(grid, n) && !bfs0(grid, n)){
                print_res(grid, aux, n);
                return ;
            }
            grid[1][2] = aux[1][2]; grid[2][1] = aux[2][1];

            grid[1][2] = bit1; grid[n][n - 1] = bit2;
            if(!bfs1(grid, n) && !bfs0(grid, n)){
                print_res(grid, aux, n);
                return ;
            }
            grid[1][2] = aux[1][2]; grid[n][n - 1] = aux[n][n - 1];

            grid[1][2] = bit1; grid[n - 1][n] = bit2;
            if(!bfs1(grid, n) && !bfs0(grid, n)){
                print_res(grid, aux, n);
                return ;
            }
            grid[1][2] = aux[1][2]; grid[n - 1][n] = aux[n - 1][n];

            grid[2][1] = bit1; grid[n][n - 1] = bit2;
            if(!bfs1(grid, n) && !bfs0(grid, n)){
                print_res(grid, aux, n);
                return ;
            }
            grid[2][1] = aux[2][1]; grid[n][n - 1] = aux[n][n - 1];

            grid[2][1] = bit1; grid[n - 1][n] = bit2;
            if(!bfs1(grid, n) && !bfs0(grid, n)){
                print_res(grid, aux, n);
                return ;
            }
            grid[2][1] = aux[2][1]; grid[n - 1][n] = aux[n - 1][n];

            grid[n][n - 1] = bit1; grid[n - 1][n] = bit2;
            if(!bfs1(grid, n) && !bfs0(grid, n)){
                print_res(grid, aux, n);
                return ;
            }
            grid[n][n - 1] = aux[n][n - 1]; grid[n - 1][n] = aux[n - 1][n];
        }
    }
    
    static int dx[] = {1, 0, -1 , 0}, dy[] = {0, 1, 0, -1};
    static final long mod = (long)1e9+7l;
    
    static FastReader sc;
    static PrintWriter out;
    public static void main(String[]args)throws IOException
    {
        out = new PrintWriter(System.out);
        sc = new FastReader();
 
        long s = System.currentTimeMillis();
        int t = 1;
        t = ni();
        for(int i = 1; i <= t; i++)
            process(i);
 
        out.flush();
        System.err.println(System.currentTimeMillis()-s+"ms");
    }

    static void trace(Object... o){ System.err.println(Arrays.deepToString(o)); };
    static void pn(Object o){ out.println(o); }
    static void p(Object o){ out.print(o); }
    static int ni()throws IOException{ return Integer.parseInt(sc.next()); }
    static long nl()throws IOException{ return Long.parseLong(sc.next()); }
    static double nd()throws IOException{ return Double.parseDouble(sc.next()); }
    static String nln()throws IOException{ return sc.nextLine(); }
    static long gcd(long a, long b)throws IOException{ return (b==0)?a:gcd(b,a%b);}
    static int gcd(int a, int b)throws IOException{ return (b==0)?a:gcd(b,a%b); }
    static int bit(long n)throws IOException{ return (n==0)?0:(1+bit(n&(n-1))); }
    
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 
    } 
}
