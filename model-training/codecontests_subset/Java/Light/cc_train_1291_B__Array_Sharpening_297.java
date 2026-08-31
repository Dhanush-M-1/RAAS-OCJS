
import java.util.*;
import java.lang.*;
import java.util.Arrays;


public class geek {


    public static void main(String[] args) {
        try {
            Scanner s = new Scanner(System.in);

            StringBuffer sb=new StringBuffer();
            int t=s.nextInt();

            while (t-->0){
              int n=s.nextInt();
              int a[]=new int[n];
              for(int i=0;i<n;i++){
                  a[i]=s.nextInt();

              }
              int left=-1,right=n;
              boolean flag=true;
             for(int i=0;i<n;i++){
                 if(a[i]<i){
                     break;
                 }
                 left=i;
             }
             for(int i=n-1;i>=0;i--){
                 if(a[i]<(n-i-1)){
                     break;
                 }
                 right=i;
             }
             if(right<=left){
                 sb.append("Yes\n");
             }else sb.append("No\n");
            }

            System.out.println(sb);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}