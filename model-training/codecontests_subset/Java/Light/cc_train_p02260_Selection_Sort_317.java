import java.util.Scanner;
class Main{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    int N,X,C=0;
    int min,minN=0;
    int A[] = new int[100];

    N = scanner.nextInt();

    for(int i=0;i<N;i++){
      A[i] = scanner.nextInt();
    }

    for(int i=0;i<N;i++){
      min = A[i];
      for(int j=i;j<N;j++){
        if(min>A[j]){
          min = A[j];
          minN = j;
        }
      }
      if(min!=A[i]){
        X = A[minN];
        A[minN] = A[i];
        A[i] = X;
        C++;
      }
    }

    for(int i=0;i<N;i++){
      System.out.print(A[i]);
      if(i!=N-1){
        System.out.print(" ");
      }
    }
    System.out.print("\n");
    System.out.println(C);

  }
}
