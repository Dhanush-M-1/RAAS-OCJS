import java.util.*;
public class pr{
     public static void main(String[] Args){
          Scanner sc = new Scanner(System.in);
          int T = sc.nextInt();
          for(int p =0; p<T; p++){
                 String s = sc.nextLine();
                 sc.nextLine();
                 int k = sc.nextInt();
                 int n = sc.nextInt();
                 int m = sc.nextInt();
                 int na[] = new int[n];
                 int ma[] = new int[m];
                 for(int i =0; i<n; i++){
                      na[i] = sc.nextInt();
                 }for(int i =0; i<m; i++){
                      ma[i] = sc.nextInt();
                 }
                 
                 int ans[] = new int[n+m];
                 int safe =0;
                 int a = 0;
                 int b =0;
                 for(int i =0; i<n+m; i++){
                      if(a<n  &&  na[a] ==0){
                           ans[i] = 0;
                           a++;
                           k++;
                      }else if(a<n  &&  na[a] <= k){
                           ans[i] = na[a];
                           a++;
                      }else if(b<m  &&  ma[b] ==0){
                           ans[i] =0;
                           b++;
                           k++;
                      }else if(b<m  &&  ma[b] <=k){
                           ans[i] = ma[b];
                           b++;
                      }else{
                           System.out.println("-1");
                           safe = -1;
                           break;
                      }
                 }if(safe == -1){
                     continue;    
                 }
                 for(int i =0; i<n+m; i++){
                      System.out.print(ans[i]+" ");
                 }System.out.println();
     }
         
     }
         
     
}

