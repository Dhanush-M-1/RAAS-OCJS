import java.util.*;
class Main
{
  public static void main(String Args[])
  {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int A[] = new int[n];
    int B[] = new int[n];
    int C[] = new int[n-1];
    for(int i = 0;i<n;i++)
      A[i] = in.nextInt();
    for(int i = 0;i<n;i++)
      B[i] = in.nextInt();
    for(int i = 0;i<n-1;i++)
      C[i] = in.nextInt();
    int sum = 0;
    int last = 0;
    for(int i = 0;i<n;i++)
    {
      int a = A[i]-1;
      if(i!=0)
      {
        sum += B[a];
        if(a-last==1)
          sum+= C[last];
        last = a;
      }
      else{
        sum += B[a];
        last = a;
      }
    }
     System.out.println(sum);
  }
}