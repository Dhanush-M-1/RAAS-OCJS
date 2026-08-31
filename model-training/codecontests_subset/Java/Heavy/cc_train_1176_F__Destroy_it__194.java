import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class Program {
    
    private static PrintWriter out;
    
    private static <T> void mprintln(T ... ar){
        for(T i: ar) out.print(i + " ");
        out.println();
    }
    
    public static void main(String[] args) throws FileNotFoundException{

        // Input from file
        // File inputFile = new File("JavaFile.txt");
        // File outputFile = new File("JavaOutputFile.txt");
        // FileReader fileReader = new FileReader(inputFile);
        // Here it ends

        MyScanner sc = new MyScanner();
        // MyScanner sc = new MyScanner(fileReader);

        out = new PrintWriter(new BufferedOutputStream(System.out)); // Output to console
        // out = new PrintWriter(new PrintStream(outputFile)); // Output to file

        getAns(sc);

        out.close(); 
    }
    
//  Global Variables  
    
    private static void getAns(MyScanner sc){
        int n = sc.ni();
        long[][] dp = new long[n][10];
        final long MIN = (long) -1e17;
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], MIN);

        for(int i = 0; i < n; i++){
            int k = sc.ni();
            ArrayList<int[]> temp = new ArrayList();
            for(int j = 0; j < k; j++) temp.add(new int[]{sc.ni(), sc.ni()});
            Collections.sort(temp, (int[] a, int[] b) -> b[1] - a[1]);
            int[] count = new int[4];
            ArrayList<int[]> list = new ArrayList();

            for(int j = 0; j < k; j++){
                int cur = temp.get(j)[0];
                ++count[cur];
                int cap = (cur == 1? 3: 1);
                if(count[cur] <= cap) list.add(temp.get(j));
            }
            
//            list.forEach(k1 -> out.println(Arrays.toString(k1)));
            
            dp[i][0] = 0;
            if(i == 0){
                long cur = getOneLargest(list, 0);
                dp[0][1] = cur;

                cur = getTwoLargest(list, 0);
                if(cur != -1) dp[0][2] = cur;

                cur = getThreeLargest(list, 0);
                if(cur != -1) dp[0][3] = cur;
            }else{
                for(int j = 0; j < 10; j++) dp[i][j] = dp[i - 1][j];
                
                for(int j = 0; j < 10; j++){
                    long cur = getOneLargest(list, j);
                    int idx = (j + 1) % 10;
                    dp[i][idx] = Math.max(dp[i][idx], dp[i - 1][j] + cur);
                }
                
                for(int j = 0; j < 10; j++){
                    long cur = getTwoLargest(list, j);
                    if(cur == -1) continue;
                    int idx = (j + 2) % 10;
                    dp[i][idx] = Math.max(dp[i][idx], dp[i - 1][j] + cur);
                }
                
                for(int j = 0; j < 10; j++){
                    long cur = getThreeLargest(list, j);
                    if(cur == -1) continue;
                    int idx = (j + 3) % 10;
                    dp[i][idx] = Math.max(dp[i][idx], dp[i - 1][j] + cur);
                }
            }
            
//            out.println(Arrays.toString(dp[i]));
        }
        
        long ans = 0;
        for(int i = 0; i < 10; i++) ans = Math.max(ans, dp[n - 1][i]);
        
        out.println(ans);
    }

    private static long getOneLargest(ArrayList<int[]> list, int cur) {
        long mul = 1;
        if(cur + 1 >= 10) mul = 2;
        return list.get(0)[1] * mul;
    }

    private static long getTwoLargest(ArrayList<int[]> list, int k) {
        long ans = 0, count = 0;
        boolean first = false;
        if(k + 2 >= 10) first = true;
        for(int[] cur: list){
            if(cur[0] == 3) continue;
            ++count;
            if(first){
                first = false;
                ans = ans + cur[1];
            }
            ans = ans + cur[1];
            if(count == 2) return ans;
        }
        
        return -1;
    }

    private static long getThreeLargest(ArrayList<int[]> list, int k) {
        long ans = 0, count = 0, mul = 1;
        boolean first = false;
        if(k + 3 >= 10) first = true;
        for(int[] cur: list){
            if(cur[0] >= 2) continue;
            ++count;
            if(first){
                first = false;
                ans = ans + cur[1];
            }
            ans = ans + cur[1];
            if(count == 3) return ans;
        }
        
        return -1;
    }
    
    static class MyScanner{
        BufferedReader br;
	StringTokenizer st;

	MyScanner(FileReader fileReader){
            br = new BufferedReader(fileReader);
	}

	MyScanner(){
            br = new BufferedReader(new InputStreamReader(System.in));
	}

	String nn(){
            while(st == null || !st.hasMoreElements()){
		try{
                    st = new StringTokenizer(br.readLine());
		}catch(IOException e){
                    e.printStackTrace();
		}
            }
            return st.nextToken();
	}
        
        String nextLine(){
            String ans = "";
            try {
                ans = br.readLine();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return ans;
        }

	char nc(){
            return nn().charAt(0);
	}

	int ni(){
            return Integer.parseInt(nn());
	}

	long nl(){
            return Long.parseLong(nn());
	}

	double nd(){
            return Double.parseDouble(nn());
	}

	int[] niArr0(int n){
            int[] ar = new int[n];
            for(int i = 0; i < n; i++) ar[i] = ni();
            return ar;
	}

        int[] niArr1(int n){
            int[] ar = new int[n + 1];
            for(int i = 1; i <= n; i++) ar[i] = ni();
            return ar;
	}

        long[] nlArr0(int n){
            long[] ar = new long[n];
            for(int i = 0; i < n; i++) ar[i] = nl();
            return ar;
        }

        long[] nlArr1(int n){
            long[] ar = new long[n + 1];
            for(int i = 1; i <= n; i++) ar[i] = nl();
            return ar;
        }
    }
}