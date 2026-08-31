import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        System.out.println(solve(N,str));
    }
    public static String solve(int k, String str) {
        int[] array = new int[26];
        for( int i = 0; i < str.length(); i++ ) {
            array[str.charAt(i) - 'a']++;
        }
        String ans = "";
        for( int i = 0; i < array.length; i++ ) {
            if( array[i] % k != 0 ) {
                return "-1";
            }else {
                for( int j = 0; j < array[i]/k; j++ ) {
                    ans = ans + (char)(i+'a');
                }
                //System.out.println(ans);
            }
        }
        
        String unit = ans;
        for( int i = 0; i < k-1; i++ ) {
            ans += unit;
        }
        return ans;
    
    }
}

