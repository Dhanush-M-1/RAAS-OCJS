    import java.util.Scanner;
    public class Test{
    public static void main(String args[]){
    Scanner in=new Scanner(System.in);
    int n=in.nextInt();
    int A[]=new int[n];
    int B[]=new int[n];
    for(int i=0;i<n;i++){
    A[i]=in.nextInt();
    B[i]=in.nextInt();
    }
    int count=0;
    for(int i=0;i<n;i++){
    for(int j=0;j<n;j++){
    if(B[i]==A[j]){
    count++;
    }
    }
    }
    System.out.println(count);
    }
     
    }