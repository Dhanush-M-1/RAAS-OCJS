import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Mikle
 * Date: 05.03.15
 * Time: 20:31
 * To change this template use File | Settings | File Templates.
 */
public class CompileErrors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr1[] = new int[N];
       // int temp[] = new int[N];
        int arr2[] = new int[N-1];
        int arr3[] = new int[N-2];
        int i, j, found1=0, found2=0;
        int x=0, y=0, sum1=0, sum2=0, sum3=0;
        for(i=0;i<N;i++)
        {
            arr1[i]=sc.nextInt();
            sum1+=arr1[i];
        }
        for (i=0;i<N-1;i++)
        {
            arr2[i]=sc.nextInt();
         sum2+=arr2[i];
        }
        for(i=0;i<N-2;i++)
        {
            arr3[i]=sc.nextInt();
            sum3+=arr3[i];
        }


         System.out.println(sum1-sum2);
        System.out.println(sum2-sum3);
    }

}
