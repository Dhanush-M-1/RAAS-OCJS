
import java.io.*;
import java.util.*;

public class b
{
    public static void print(String str,long val){
        System.out.println(str+"  "+val);
    }

    public long gcd(long a, long b) {
        if (b==0L) return a;
        return gcd(b,a%b);
    }

    public static void debug(long[][] arr){
        int len = arr.length;
        for(int i=0;i<len;i++){
            System.out.println(Arrays.toString(arr[i]));
        }
    }
    public static void debug(int[][] arr){
        int len = arr.length;
        for(int i=0;i<len;i++){
            System.out.println(Arrays.toString(arr[i]));
        }
    }
    public static void debug(String[] arr){
        int len = arr.length;
        for(int i=0;i<len;i++){
            System.out.println(arr[i]);
        }
    }

    public static void print(int[] arr){
        int len = arr.length;
        for(int i=0;i<len;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.print('\n');
    }

    public static void print(Object[] arr){
        int len = arr.length;
        for(int i=0;i<len;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.print('\n');
    }
    public static void print(String[] arr){
        int len = arr.length;
        for(int i=0;i<len;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.print('\n');
    }
    public static void print(long[] arr){
        int len = arr.length;
        for(int i=0;i<len;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.print('\n');
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
        public FastReader(String path) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(path));
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

    static void sort(long[] arr){
        Long[] temp = new Long[arr.length];
        for(int i=0;i<arr.length;i++){
            temp[i] = arr[i];
        }
        Arrays.sort(temp);
        for(int i=0;i<arr.length;i++){
            arr[i] = temp[i];
        }
    }


    public static void main(String[] args)
    {
        FastReader s=new FastReader();
        int t = s.nextInt();
        for(int tt=0;tt<t;tt++){
            int n = s.nextInt();
            char[][] grid = new char[n][n];
            for(int i=0;i<n;i++){
                String str = s.nextLine();
                grid[i] = str.toCharArray();
            }
            char a = grid[0][1];
            char b = grid[1][0];
            char c = grid[n-1][n-2];
            char d = grid[n-2][n-1];

            if(a==b){
                if(c==d){
                    if(a==c){
                        System.out.println(2);
                        System.out.println(n+" "+(n-1));
                        System.out.println((n-1)+" "+(n));
                    }
                    else {
                        System.out.println(0);
                    }
                }
                else {
                    System.out.println(1);
                    if(a==c){
                        System.out.println(n+" "+(n-1));
                    }
                    else {
                        System.out.println(n-1+" "+n);
                    }
                }
            }
            else {
                if(c==d){
                    System.out.println(1);
                    if(a==c){
                        System.out.println(1+" "+2);
                    }
                    else {
                        System.out.println(2+" "+1);
                    }
                }
                else {
                    System.out.println(2);
                    if(a==c){
                        System.out.println(1+" "+2);
                        System.out.println((n-1)+" "+n);
                    }
                    if(a==d){
                        System.out.println(1+" "+2);
                        System.out.println(n+" "+(n-1));
                    }
                }
            }

        }


    }

    static class pair{
        int x;
        int y;
        pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    static boolean ispath(int n,char[][] grid){
        Queue<pair> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];
        char[][] temp_grid = grid.clone();
        grid[0][0] = '0';
        grid[n-1][n-1] ='0';
        queue.add(new pair(0,0));
        //first only zeros
        while (!queue.isEmpty()){
            pair p = queue.poll();
            int x = p.x;
            int y = p.y;
            if(x==n-1 && y==n-1){
                return  true;
            }
            visited[x][y] = true;
            int[] xx = {-1,1,0,0};
            int[] yy = {0,0,-1,1,};
            for(int i=0;i<4;i++){
                int new_x = x+xx[i];
                int new_y = y+yy[i];
                if(new_x<0 || new_x>=n || new_y<0 ||new_y>=n){
                    continue;
                }
                if(!visited[new_x][new_y] && grid[new_x][new_y]=='0'){
                    queue.add(new pair(new_x,new_y));
                }
            }
        }
        grid = temp_grid.clone();
        grid[0][0]  ='1';
        grid[n-1][n-1] = '1';
        visited = new boolean[n][n];
        queue = new ArrayDeque<pair>();
        queue.add(new pair(0,0));
        //ones
        while (!queue.isEmpty()){
            pair p = queue.poll();
            int x = p.x;
            int y = p.y;
            if(x==n-1 && y==n-1){
                return  true;
            }
            visited[x][y] = true;
            int[] xx = {-1,1,0,0};
            int[] yy = {0,0,-1,1,};
            for(int i=0;i<4;i++){
                int new_x = x+xx[i];
                int new_y = y+yy[i];
                if(new_x<0 || new_x>=n || new_y<0 ||new_y>=n){
                    continue;
                }
                if(!visited[new_x][new_y] && grid[new_x][new_y]=='1'){
                    queue.add(new pair(new_x,new_y));
                }
            }
        }
        return  false;
    }







//    OutputStream out = new BufferedOutputStream( System.out );
//        for(int i=1;i<n;i++){
//              out.write((arr[i]+" ").getBytes());
//         }
//        out.flush();
//  long start_time = System.currentTimeMillis();
//  long end_time = System.currentTimeMillis();
//  System.out.println((end_time - start_time) + "ms");



}
