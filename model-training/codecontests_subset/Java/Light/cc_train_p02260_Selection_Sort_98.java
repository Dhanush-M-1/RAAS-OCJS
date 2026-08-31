import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int flag=1,sum=0;
        int N=sc.nextInt();
        int[] A=new int[N];
        for(int i=0;i<N;i++)A[i]=sc.nextInt(); 
        for(int i=0;i<N;i++){
            int min=i,data;
            for(int j=i;j<N;j++){
                if(A[j]<A[min])min=j;
            }
            if(i!=min){
                sum++;
                data=A[i];
                A[i]=A[min];
                A[min]=data;
            }
        }
        for(int i=0;i<N;i++){
            if(i!=N-1)System.out.printf(A[i]+" ");
            else System.out.println(A[i]);
        }
        System.out.println(sum);
    } 
}
