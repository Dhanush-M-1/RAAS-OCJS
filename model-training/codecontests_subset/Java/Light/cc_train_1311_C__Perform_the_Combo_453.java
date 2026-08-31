import java.io.*;
import java.util.*;
 
 
public class CodeForce {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
    int t=Integer.parseInt(br.readLine());
    while(t-->0){
        String[] ss=br.readLine().split(" ");
        int n=Integer.parseInt(ss[0]);
        int m=Integer.parseInt(ss[1]);
        String str=br.readLine();
        String[] s1=br.readLine().split(" ");
        int[] p=new int[m];
        long[] arr=new long[n];
        for(int i=0;i<m;i++){
            p[i]=Integer.parseInt(s1[i]);
            arr[p[i]-1]=arr[p[i]-1]+1;
        }
        long c=0,val=0;
        for(int i=n-1;i>=0;i--){
            
            if(arr[i]!=0){
                arr[i]=arr[i]+val;
                val=arr[i];
                //c++;
                
            }
            else
                arr[i]=val;
            
            arr[i]++;
        }
        long[] ans=new long[26];
        /*for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
        */
        for(int i=0;i<n;i++){
            //System.out.println(str.charAt(i)-'a'+"  "+str.charAt(i)+"  "+arr[i]);
            ans[str.charAt(i)-'a']=ans[str.charAt(i)-'a']+arr[i];
        }
        for(int i=0;i<26;i++)
            System.out.print(ans[i]+" ");
        System.out.println("");
        
    }
   
    }}