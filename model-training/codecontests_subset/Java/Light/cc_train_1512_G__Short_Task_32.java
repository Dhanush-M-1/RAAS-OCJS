import java.util.*;

public class Solve{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
          int n=10000001;
            int[] ar=new int[n];
            for(int i=1;i<n;i++){
                ar[i]=-1;
            }
            ar[1]=1;
            for(int i=2;i*i<n;i++){
                int p=i;
                if(ar[i]==-1){
                    ar[i]=i;
                    for(int j=i*i;j<n;j+=p){
                       if(ar[j]==-1){
                           ar[j]=i;
                       }
                    }
                }
            }
            int[] s=new int[n];
            s[1]=1;
            for(int i=2;i<n;i++){
                if(ar[i]==-1){
                    ar[i]=i;
                    s[i]=i+1;
                }
                else{
                    int j=i;
                    s[i]=1;
                    while(j%ar[i]==0){
                        j/=ar[i];
                        s[i]=s[i]*ar[i]+1;
                    }
                    s[i]*=s[j];
                }
            }
            int[] ans=new int[n];
            Arrays.fill(ans,-1);
            for(int i=n-1;i>0;i--){
                if(s[i]<n)ans[s[i]]=i;
            }
            
        while(t-->0){
            int c=sc.nextInt();
            
             System.out.println(ans[c]);
            
        }
    }
}