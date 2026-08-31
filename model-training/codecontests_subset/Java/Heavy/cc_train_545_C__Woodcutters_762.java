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
int tests = nextInt();
int[][]trees = new int[tests][2];
for(int i =0;i<tests; i++){
  trees[i][0] = nextInt();
  trees[i][1] = nextInt();
}
int occupied = Integer.MIN_VALUE;
int total = 0;
for(int i=0; i<tests-1;i++){
  int[] t = trees[i];
  int[] next = trees[i+1];
  //println(t[0]);
  //println(t[1]);
  //println(occupied);
  if(t[0]-t[1]>occupied){
    occupied = t[0];
    total++;
  }else{
    if(t[0]+t[1]<next[0]){
      occupied = t[0]+t[1];
      total++;
    }
  }
  occupied = Math.max(occupied, t[0]);
}
println(total+1);
    }

//Solution goes above: ------------------------------------
	public static final String IN_FILE = "in.txt";
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
				// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
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