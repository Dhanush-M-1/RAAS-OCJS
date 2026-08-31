import java.util.*;

public class Main{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int m=sc.nextInt();
        int a[]=new int[n];
        int b[]=new int[n];
        int c[]=new int[m];
        int d[]=new int[m];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
            b[i]=sc.nextInt();
        }
        for(int i=0;i<m;i++){
            c[i]=sc.nextInt();
            d[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            int min=Math.abs(a[i]-c[0])+Math.abs(b[i]-d[0]);
            int ans=1;
            for(int j=1;j<m;j++){
                int len=Math.abs(a[i]-c[j])+Math.abs(b[i]-d[j]);
                if(min>len){
                    ans=j+1;
                    min=len;
                }
            }
            System.out.println(ans);
        }


    }
}
