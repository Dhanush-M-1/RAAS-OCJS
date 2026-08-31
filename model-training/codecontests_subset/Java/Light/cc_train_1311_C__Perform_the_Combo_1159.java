import java.util.*;
 
public class Solution{
    public static void main(String []args){
    Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();
    for(int j=0;j<t;j++){
      int n=sc.nextInt();
      int m=sc.nextInt();
      String temp=sc.nextLine();
      String s=sc.nextLine();
      int alpha[]=new int[27];
      int h=0;
      if(n<=26)
      h=27;
      else
      h=n+1;
      int arr[][]=new int[h][2];
      for(int i=1;i<=m;i++){
        int x=sc.nextInt();
        if(x!=n)
        {
          arr[1][0]+=1;
          arr[x+1][0]-=1;
        }
        else{
          arr[1][0]+=1;
        }
      }
      for(int i=2;i<=n;i++){
        arr[i][0]+=arr[i-1][0];
      }
      for(int i=1;i<=n;i++){
        arr[i][0]+=1;
        arr[i][1]=(int)s.charAt(i-1)-96;
      }
      for(int i=1;i<=n;i++){
        alpha[arr[i][1]]+=arr[i][0];
      }
      for(int i=1;i<=26;i++){
        System.out.print(alpha[i]+" ");
      }
      System.out.println();
    }
  }
}