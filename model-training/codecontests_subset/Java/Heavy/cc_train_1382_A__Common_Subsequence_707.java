import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int t=Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++){
            String str[]=br.readLine().split(" ");
            int n=Integer.parseInt(str[0]);
            int m=Integer.parseInt(str[1]);
            String str1[]=br.readLine().split(" ");
            String str2[]=br.readLine().split(" ");
            HashSet<Integer> hs=new HashSet<Integer>();
            for(int j=0;j<n;j++)
                hs.add(Integer.parseInt(str1[j]));
            int j=0;
            for(;j<m;j++){
                if(hs.contains(Integer.parseInt(str2[j]))){
                    bw.write("YES\n1 "+str2[j]+"\n");
                    break;
                }
            }
            if(j==m)
                bw.write("NO\n");
        }
        bw.flush();
    }
}