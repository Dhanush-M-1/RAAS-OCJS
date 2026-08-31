import java.util.Scanner;
public class CodeForces17 {
    public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();
      int arr[][]=new int[n][2];
      int count=0;
      int a=0;
      for(int i=0;i<n;i++){
          for(int j=0;j<2;j++){
              arr[i][j]=sc.nextInt();
          }
               }
      for(int i=0;i<n;i++){
          for(int j=i;j<n-1;j++){
              if(arr[i][a]==arr[j+1][a+1])
                  count++;
          }
          for(int b=i-1;b>=0;b--){
              if(arr[i][a]==arr[b][a+1])
                  count++;
          }
           }
        System.out.println(count);
    }  
}
