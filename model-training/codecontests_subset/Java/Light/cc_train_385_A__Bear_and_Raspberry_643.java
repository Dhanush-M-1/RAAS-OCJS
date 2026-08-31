import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split("\\s");
        int n = Integer.parseInt(s[0]);
        int c = Integer.parseInt(s[1]);
        s = br.readLine().split("\\s");
        int[] arr = new int[s.length];
        for(int i=0;i<arr.length;++i) arr[i] = Integer.parseInt(s[i]);
        System.out.println(solve(arr,n,c));
    }
    
    private static int solve(int[] arr,int n,int c){
        int max_p = 0;
        
        for(int i=0;i<arr.length-1;++i){
            max_p = Math.max(max_p,arr[i] - arr[i+1] - c);
        }
        
        return max_p;
    }
}