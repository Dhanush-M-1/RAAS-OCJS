import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

/*

*/

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        String str=br.readLine();
        int count=0;
        for(int i=0;i<n;i++){
            if(str.charAt(i)=='8'){
                count++;
            }
        }
        int ans=0;
        while (count>0&&n>=11){
            n-=11;
            count--;
            ans++;
        }
        pw.println(ans);
        pw.close();

    }
}