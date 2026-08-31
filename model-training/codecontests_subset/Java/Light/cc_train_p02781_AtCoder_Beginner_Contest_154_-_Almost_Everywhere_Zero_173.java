import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char c[] = sc.next().toCharArray();
        int k = sc.nextInt();
        int digit = c.length;
        int[] keta = new int[digit];
        for(int i=0;i<c.length;i++)keta[i]=c[i]-'0';

        long[][] dp0 = new long[digit][k+1];//桁、0以外の個数
        long[][] dp1 = new long[digit][k+1];

        dp0[0][1]=0;
        for(int i=0;i<10;i++){
            if(i==0){
                dp0[0][0]=1;
            } else if(i<keta[0]){//100のときi<1
                dp0[0][1]++;
            } else if(i==keta[0]){
                dp1[0][1]=1;
            }
        }

        for(int i=1;i<digit;i++){
            dp0[i][0]=dp0[i-1][0];
            dp1[i][0]=0;
            for(int j=1;j<k+1;j++){
                dp0[i][j]=dp0[i-1][j]+dp0[i-1][j-1]*9;

                if(keta[i]!=0)dp0[i][j]+=dp1[i-1][j]+dp1[i-1][j-1]*(keta[i]-1);
                if(keta[i]==0){
                    dp1[i][j]=dp1[i-1][j];
                }else{
                    dp1[i][j]=dp1[i-1][j-1];
                }
            }
        }

        long ans = dp0[digit-1][k]+dp1[digit-1][k];
        System.out.println(ans);
/*
        for(int i=0;i<digit;i++){
            for(int j=0;j<k+1;j++) System.out.print(dp0[i][j]+" ");
            System.out.println();
        }
        System.out.println("---");
        for(int i=0;i<digit;i++){
            for(int j=0;j<k+1;j++) System.out.print(dp1[i][j]+" ");
            System.out.println();
        }
 */






    }

}


