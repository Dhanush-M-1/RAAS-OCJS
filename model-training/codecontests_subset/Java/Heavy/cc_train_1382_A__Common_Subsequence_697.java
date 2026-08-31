import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       // BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            String[] str=br.readLine().split(" ");
            int m=Integer.parseInt(str[0]);
            int n=Integer.parseInt(str[1]);
            String[] str1=br.readLine().split(" ");
            String[] str2=br.readLine().split(" ");
            int[] ar=new int[m];
            int[] ar1=new int[n];
            for(int i=0;i<m;i++){
                ar[i]=Integer.parseInt(str1[i]);
            }
            for(int i=0;i<n;i++){
                ar1[i]=Integer.parseInt(str2[i]);
            }
            boolean flag=true;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(ar[i]==ar1[j]){
                        System.out.println("YES");
                        System.out.println(1+" "+ar[i]);
                        flag=false;
                        break;
                    }
                }
                if(flag==false) break;
            }
            if(flag==true) System.out.println("NO");
            
        }
        
    }
}