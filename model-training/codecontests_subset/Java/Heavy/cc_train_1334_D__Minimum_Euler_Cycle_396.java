/*
     D    A    R    K    L      _                 _         O    R    D    D    A
         K                    / |                 | \        L    O    R         D
        A         R         _ / |                 | \ _       K    L         O    R
  D         A    R    K     _ / |         _       | \ _        L    O    R    D    D
      R    K    L       _ / _   |       _ | \\    |   _ \       O    R    D    D
     R         K        _ / _   |       _ | \ \   |   _ \        L    O    R
    D    A    R     _ / _ / |   /     /         \ \   | \ _ \ _        K    L    O
   D    D           _ / _ / |   /     /          \ \   | \ _ \ _             A
       K        _ / _ /     | /     /     _       \ \ |     \ _ \ _      L    O    R
 D    A        _ / _ /      | /     /     _       \ \ |      \ _ \ _      R         K
            _ / _ /         | |     |   |   \ (O) / | |         \ _ \ _         O
    D      _ / _ /          | |     |   |    \   /  | |          \ _ \ _         D
   A      / _ /     |   |   | \     |   \ _   \|/   / |   |   |     \ _ \
  K      / _ /      |   |   | \     |   \ _    V    / |   |   |      \ _ \         L
        / /         |   |   |   \ _ /       \ _ _ /   |   |   |         \ \
       / /          |   |   |                         |   | | |          \ \
      / /       |   | | \     \       ROWECHEN      /     / | |   |       \ \
     / /    _ _ |   | | \     \        ZHONG        /     / | |   | _ _    \ \
    / / _ /   \ | | | |   \ / \ \                 / / \ /   | | | | /   \ _ \ \
   / / _ /    \ | | | |       \ \                 / /       | | | | /    \ _ \ \
  / / /         \ \ \ \ /       /                 \       \ / / / /         \ \ \
 \ / /          \ \ \ \ /       /                 \       \ / / / /          \ \ /
  \|/             \|/         |         |         |           \|/             \|/
  L         O     \|/         |         |   |     |           \|/        R    D
 A    R    K    L             / _ |     |   | _     \      O    R    D    D    A    R
     L    O         R         / _ |     |   | _     \       D    D         A    R
    L    O    R    D        / / / _     | _ | | \ _   \      D    A    R         K
   O    R    D              / / / _ |   | _ | | \ _   \       D    A    R    K    L
  R    D    D    A    R     | / / | | / | | \ / | | \ |        K    L    O    R    D
 A         R         K      | / / | | / | | \ / | | \ |              L    O         R
     D    A         R         /   \ / | | | / | | / \ /     K    L         O    R
         D    D         A     /   \ / | | | / | | / \/            R    K    L    O
             R         D    D     / | / \ |   \ /        A    R    K    L    O    R
       D    A    R    K    L      / | / \ |    \/              O    R    D    D
 R    K    L    O    R    D       \ /     |      D    A    R         K    L    O    R
          D    A    R             \/      |            K    L    O    R    D    D

*/
//TEMPLATE V2
	import java.io.*;
	import java.util.*;
	import java.math.*;

    public class Main {
    //Solution goes below: ------------------------------------
    public static void solution() throws IOException{
        int T = nextInt();
        for(int test=0;test<T;test++){
            long n = nextLong();
            long l = nextLong()-1;
            long r = nextLong();
            boolean end = false;
            long total = n*n-n+1;
            if(r==total){
                r--;
                end = true;
            }
            for(long level=1;level<n;level++){
                long len = 2*(n-level);
                for(long i=l;i<Math.min(len,r);i++){
                    /*print(len);
                    print(" ");
                    print(i);
                    print(" ");
                    print(l);
                    print(" ");
                    print(r);
                    print(" ");
                    print(level);
                    print(" ");*/
                    if(i%2==0){
                        print(level);
                    }else{
                        print(i/2+1+level);
                    }
                    print(" ");//println(" ");
                }
                l = Math.max(l-len,0);
                r = Math.max(r-len,0);
            }
            if(end){
                println("1 ");
            }else{
                println();
            }
        }
    }

    //Solution goes above: ------------------------------------
    public static final String IN_FILE = "";
    public static final String OUT_FILE = "";
    //-------------------- ------------------------------------
    //IO
    public static BufferedReader br;
    public static StringTokenizer st;
    public static BufferedWriter bw;
    public static void main(String[] args) throws IOException{
        if(IN_FILE==""){
            br = new BufferedReader(new InputStreamReader(System.in));
        }else{
            try {
                br = new BufferedReader(new FileReader(IN_FILE));
            } catch (FileNotFoundException e) {
                br = new BufferedReader(new InputStreamReader(System.in));
            }
        }
        if (OUT_FILE==""){
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }else{
            try {
                bw = new BufferedWriter (new FileWriter(OUT_FILE) );
            } catch (FileNotFoundException e) {
                bw = new BufferedWriter(new OutputStreamWriter(System.out));
            }
        }
        solution();
        bw.close();//Flushes too.
    }

    public static String nextToken() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    public static String nextLine() {
        st = null;
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int nextInt() {
        return Integer.parseInt(nextToken());
    }

    public static long nextLong() {
        return Long.parseLong(nextToken());
    }

    public static double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    public static void println(Object s) throws IOException{
        bw.write(s.toString()+"\n");
    }

    public static void println() throws IOException{
        bw.newLine();
    }

    public static void print(Object s) throws IOException{
        bw.write(s.toString());
    }
    public static void flush() throws IOException{//Useful for debug
        bw.flush();
    }
    //Other
    public static class Arr<T> extends ArrayList<T> {} //I hate typing ArrayList
}