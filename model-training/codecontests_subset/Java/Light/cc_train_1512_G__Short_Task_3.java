

import java.util.Scanner;

public class SumOfFactors {
    public static void main(String[] args){
        Scanner console=new Scanner(System.in);
        int t = Integer.parseInt(console.nextLine());
        final int N= (int) (1e7);
        int[] pf=new int[N+100];
        long[] s=new long[N+100];
        int[] result=new int[N+100];
        for(int i=1;i<=N;i++){
            pf[i]=-1;
        }
        pf[1]=1;
        for(int i=2;i*i<=N;i++){
            if(pf[i]==-1){
                pf[i]=i;
                for(int j=i*i;j<=N;j+=i){
                    if(pf[j]==-1){
                        pf[j]=i;
                    }
                }
            }
        }
        s[1]=1;
        for(int i=2;i<=N;i++){
            if(pf[i]==-1){
                pf[i]=i;
                s[i]=1+i;
            }else{
                int j=i;
                s[i]=1;
                while (j%pf[i]==0){
                    j/=pf[i];
                    s[i]=s[i]*pf[i]+1;
                }
                s[i]*=s[j];
            }
        }

        for(int i=1;i<=N;i++){
            result[i]=-1;
        }

        for(int i=N;i>0;i--){
            if(s[i]<=N){
                result[(int) s[i]]= i;
            }
        }


        while (t-->0){
            int c=Integer.parseInt(console.nextLine());
            System.out.println(result[c]);
        }
    }
}
