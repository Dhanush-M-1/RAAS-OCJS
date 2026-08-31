import java.util.*;
public class Solution{
    public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int n= sc.nextInt();
    int h[]=new int[n];
    int o[]=new int[n];
    int ans=0;
    for(int i=0;i<n;i++){
        h[i]=sc.nextInt();
        o[i]=sc.nextInt();
    }
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(h[i]==o[j]){
                ans++;
            }
        }
    }
    System.out.print(ans);
    }
}