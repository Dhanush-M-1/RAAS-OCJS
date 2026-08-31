import java.math.*;
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> p = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(n%i==0) p.add(i);
        }
        int[][] map = new int[n][n];
        for(int i=0;i<n;i++){
            String in = br.readLine();
            for(int j=0;j<in.length();j++){
                int v = hexToDec(in.charAt(j));
                int cnt = 3;
                while(v>0){
                    map[i][j*4+cnt--] = v%2;
                    v/=2;
                }
            }
        }
        sum = new int[n+1][n+1];
        for(int i=0;i<n;i++){
            int pre = 0 ;
            for(int j=0;j<n;j++){
                pre += map[i][j];
                sum[i+1][j+1] = pre + sum[i][j+1];
            }
        }
        for(int pp=p.size()-1;pp>=0;pp--){
            boolean flag  =true;
            int mid = pp;
            for(int i=1;i<=n && flag;i+=p.get(mid)){
                for(int j=1;j<=n;j += p.get(mid)){
                    int s = getSum(i,j,i+p.get(mid)-1,j+p.get(mid)-1);
                    if(!(s == 0 || s == p.get(mid)*p.get(mid))){
                        flag = false;
                        break;
                    }
                }
            }
            if(flag) {
                System.out.println(p.get(pp));
                return;
            }
        }
    }
    static int[][] sum;
    public static int getSum(int i,int j,int ii,int jj){
        return sum[ii][jj] + sum[i-1][j-1] - sum[i-1][jj] - sum[ii][j-1];
    }
    public static int hexToDec(char c){
        if(c<='9' && c>='0') return c-'0';
        else{
            return c-'A'+10;
        }
    }
}