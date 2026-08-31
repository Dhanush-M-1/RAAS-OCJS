import java.io.*;
import java.util.*;
public class Test{
    static final int p = 1000000007;
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n==1){System.out.print("NO"); return;}
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[2];
        while(n-->0)a[Integer.parseInt(st.nextToken())/100-1]++;
        if((a[0]%2==0&&a[1]%2==1&&a[0]!=0)||(a[0]%2==0&&a[1]%2==0))System.out.print("YES");
        else System.out.print("NO");
    }
}

