import java.util.*;
public class Main{
 public static void main(String[] args){
   Scanner sc = new Scanner(System.in);
   int N = sc.nextInt();
   int[] a = new int[N];
   for(int i=0;i<N;i++) a[i] = sc.nextInt();
   int ans =0;
   int count = 0;
   for(int i =0;i<N;i++)
   {
     if(a[i]==i+1)
     {
       count++;
     }
     else
     {
       if(count%2==0) ans += count/2;
       else ans += count/2 +1;
       count=0;
     }
   }
   if(count%2==0) ans += count/2;
   else ans += count/2 +1;
   System.out.println(ans);
 }
}