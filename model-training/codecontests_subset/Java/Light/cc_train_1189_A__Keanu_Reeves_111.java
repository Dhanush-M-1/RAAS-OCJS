import java.util.*;
import java.io.*;
import java.math.*;
public class Solution{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        char[] c = s.toCharArray();
        int[] a = new int[2];
        for(int i=0;i<n;i++){
            a[(int)(c[i]-'0')]++;
        }
        if(a[0]==a[1]){
            System.out.println("2");
            System.out.println(s.substring(0,1)+" "+s.substring(1,n));
        }else{
            System.out.println("1");
            System.out.println(s);
        }
    }
}

