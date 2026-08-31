import java.util.*;
public class me {
    public static void main(String args[]) {
       Scanner br=new Scanner(System.in);
       int n=br.nextInt();
       int k=br.nextInt();
       int ans=1000;
       for(int i=0;i<n;i++)
       {
           int num=br.nextInt();
           if(k%num==0)
          { //ans=k/num;
           ans=Math.min(ans,k/num);
          }
       }System.out.println(ans);
}
} 