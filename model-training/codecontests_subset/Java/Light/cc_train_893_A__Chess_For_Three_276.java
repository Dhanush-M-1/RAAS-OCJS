import java.util.Scanner;
public class Codeforces 
{
    public static void main(String[] args) 
    {
      Scanner scan=new Scanner(System.in);  
      int n=scan.nextInt();
      int[] arr=new int[n];
      int[] brr=new int[3];
      brr[0]=1;
      brr[1]=2;
      brr[2]=3;
      for(int i=0;i<n;i++)
      {
          arr[i]=scan.nextInt();
      }
 
        for(int i=0;i<n;i++)
        {
           if(arr[i]==brr[0])
           {
               int temp=brr[1];
               brr[1]=brr[2];
               brr[2]=temp;
           }
           else if(arr[i]==brr[1])
           {
               int temp=brr[0];
               brr[0]=brr[2];
               brr[2]=temp;
           }
           else
           {
               System.out.print("NO");
               System.exit(0);
           }
        }
        System.out.print("YES");
      
    }
}

