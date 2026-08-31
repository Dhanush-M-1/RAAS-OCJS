import java.util.*;
public class SHARP{
  public static void main(String args[]){
   Scanner sc = new Scanner(System.in);
   int t = sc.nextInt();
    while(t-->0){
      int n = sc.nextInt();
      int [] b = new int[n];
       int sum =0 , i;
      
      for( i=1;i<=n;i++){
         b[i-1]= sc.nextInt();
        if(b[i-1]<i-1){
            if(b[i-1]<n-i)
                sum--;
                break;
        }
         
      }
      int l =i;
       
      while(++i<=n){
           b[i-1]=sc.nextInt();
        if(b[i-1]<n-i)
          sum=sum-1;
        
      }
      if(l-1==n-l+1){
          if(b[l-2]==b[l-1] && b[l-1]==l-2){
              sum--;
          }
          
      }
      if(sum<0  )
         System.out.println("NO");
      else
         System.out.println("YES");
    }
  }
}