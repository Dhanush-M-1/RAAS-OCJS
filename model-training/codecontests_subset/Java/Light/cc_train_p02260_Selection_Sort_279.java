import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int a[] = new int[N];
        for(int i=0;i<=N-1;i++){
            a[i] = sc.nextInt();
        }
        int count = 0;
        for(int i=0;i<N-1;i++){
            int minj = i;
            for (int j=i+1;j<N;j++){
                if (a[minj] > a[j]) {
                    minj = j;
                }
            }
            if(i == minj) {
                continue;
            }
            int tmp = a[i];
            a[i] = a[minj];
            a[minj] = tmp;
            count++;
        }
        for(int i=0;i<N-1;i++){
            System.out.printf("%d ",a[i]);
        }
        System.out.printf("%d",a[N-1]);
        System.out.printf("\n%d\n",count);
    }
}
