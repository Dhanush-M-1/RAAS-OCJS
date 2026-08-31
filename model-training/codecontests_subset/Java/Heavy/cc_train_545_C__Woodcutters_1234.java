// #include <bits/stdc++.h>
// using namespace std;
// typedef long long ll;
import java.util.Scanner;

public class woodCutter {
    

    
    public static void main(String[] args){
        
        
        long l=0,ans=0;
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        long tree[]=new long[n];
        long height[]=new long[n];
        for(int j=0;j<n;j++){
            
            tree[j]=input.nextLong();
            height[j]=input.nextLong();
    //        System.out.println(tree[j]+" "+height[j]);
        }
        for(int i=0;i<n-1;i++){
            
            long a=tree[i];
            long b=height[i];
            long c=tree[i+1];
            if(i==0){
                l=a;
                ans=ans+1;
            }else{
                if(a-b>l)
                {
                    l=a;
                    ans=ans+1;
                }else if(a+b<c){
                    l=a+b;
                    ans=ans+1;
                }else{
                    l=a;
                }
            }
            
            
        }
        
        
        ans=ans+1;
        System.out.println(ans);
        input.close();
    } 
}

    