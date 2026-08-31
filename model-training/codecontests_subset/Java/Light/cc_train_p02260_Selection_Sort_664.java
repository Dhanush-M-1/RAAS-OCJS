import java.util.Scanner;

public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int N=sc.nextInt();
    int array[]=new int[N];
    int count=0;
    for(int i=0;i<N;i++) array[i]=sc.nextInt();
    for(int i=0;i<N;i++){
      int minj=i;
      for(int j=i;j<N;j++){
        if(array[j]<array[minj]) minj=j;
      }
      if(i!=minj){
        int c=array[i];
        array[i]=array[minj];
        array[minj]=c;
        count+=1;
      }
    }
    for(int i=0;i<N-1;i++) System.out.print(array[i]+" ");
    System.out.println(array[N-1]+"\n"+count);
    sc.close();
  }
}
