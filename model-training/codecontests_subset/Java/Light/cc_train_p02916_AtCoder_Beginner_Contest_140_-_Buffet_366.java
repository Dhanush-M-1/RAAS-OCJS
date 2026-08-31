import java.util.Scanner;
public class Main
{
  public static void main(String[] args)
  {
    Scanner sc=new Scanner(System.in);
    int N=sc.nextInt();
    N++;
    int A[]=new int[N];
    int B[]=new int[N];
    int C[]=new int[N-1];
    for (int i=1;i<N;i++)
      A[i]=sc.nextInt();
    for (int i=1;i<N;i++)
      B[i]=sc.nextInt();
    
    for (int i=1;i<N-1;i++)
      C[i]=sc.nextInt();
    
    int sat=0;
    int prev=-1;
    for (int i=1;i<N;i++)
    {
      if ((prev+1)==A[i])
        sat+=B[A[i]]+C[A[i]-1];
      
      else
        sat+=B[A[i]];
      prev=A[i];
      
    }
    System.out.println(sat);
  }
}