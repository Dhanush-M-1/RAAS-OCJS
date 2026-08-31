import java.util.*;
import java.io.*;
 
public class Solution{
    public static class pair{
        int x;
        int y;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line=br.readLine();
        String[] strs=line.trim().split(" ");
        int n=Integer.parseInt(strs[0]);
        int[] arr=new int[n];
        line=br.readLine();
        strs=line.trim().split(" ");
        long sum=0;
        int n2=0;
        int n1=0;
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(strs[i]);
            sum+=arr[i];
            if(arr[i]==100){
                n1++; 
            }else{
                n2++;
            }
        }
        if(sum%200==0){
            int v=n2%2;
            if(n1<2*v){
                System.out.println("NO");
            }else{
                if((n1-2*v)%2==0){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }else{
            System.out.println("NO");
        }
    }
    public static class Comp implements Comparator<pair>{
        @Override
        public int compare(pair a,pair b){
            return b.y-a.y;
        }
    }
    public static class Com implements Comparator<pair>{
        @Override
        public int compare(pair a,pair b){
            if(a.x!=b.x){
                return a.x-b.x; 
            }else{
                return a.y-b.y;
            }
        }
    }
    public static void pr(int v1,int v2){
        int v3=v1;
        int v4=v2;
        // System.out.println(v1+" "+v2);
        for(int i=2;i<=Math.min(v3,v4);i++){
            while(v1%i==0&&v2%i==0){
                v1/=i;
                v2/=i;
            }
        }
        System.out.println(v1+"/"+v2);
    }
    public static int lcm(int a,int b){
        int x=Math.max(a,b);
        int y=Math.min(a,b);
        long ans=x;
        while(ans%y!=0){
            ans+=x;
        }
        return (int)ans;
    }
    public static long fact(int n){
        long ans=1;
        for(int i=1;i<=n;i++){
            ans*=i;
        }
        return ans;
    }
}