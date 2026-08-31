import java.util.*;
public class Main{
    public static void main(String [] args){
        Scanner s = new Scanner(System.in);
        int t=s.nextInt();
        int i,j;
        while(t-->0){
            int p=0;
            int  n=s.nextInt();
            int m=s.nextInt();
            int a[] = new int[n];
            int b[] = new int[m];
            for (i=0;i<n;i++)
                a[i]=s.nextInt();
            for (i=0;i<m;i++)
                b[i]=s.nextInt();
            sid:
            for (i=0;i<n;i++){
                for (j=0;j<m;j++){
                    if(a[i]==b[j]){
                        p=1;
                        break sid;
                    }
                }
            }
            if (p==1){
                System.out.println("YES");
                System.out.println(1+" "+a[i]);    
            }
            else
                System.out.println("NO");
            
        }
    }
}