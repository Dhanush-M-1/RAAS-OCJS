import java.util.Scanner;
public class Mafia {
    
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       int[] arr=new int[n];
      long m=0,sum=0, res=0;
       for(int i=0;i<n;i++){
           arr[i]=sc.nextInt();
           sum+=arr[i];
          m=Math.max(arr[i], m);
       }
       
       res=sum/(n-1);
      while(res*(n-1)<sum)
          res++;
           System.out.println(Math.max(res, m));
       
    }
}
