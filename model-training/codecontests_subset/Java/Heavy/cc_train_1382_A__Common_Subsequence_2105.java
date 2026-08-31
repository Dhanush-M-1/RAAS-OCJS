

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int[] a=new int[1005];
            boolean flag=false;
            int ans=0;
            for (int i = 0; i <n ; i++) {
                int x=sc.nextInt();
                a[x]=1;
            }
            for (int i = 0; i <m ; i++) {
                int x1=sc.nextInt();
                if (a[x1]==1){
                    flag=true;
                    ans=x1;
                }
            }
            if (flag){
                System.out.println("YES");
                System.out.println(1+" "+ans);
            }else{
                System.out.println("NO");
            }

        }
    }
}
