import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        int count = 0;
        for(int i=0;i<n;i++){
            int min = i;
            for(int j=i;j<n;j++){
                if(a[j]<a[min]){
                    min = j;
                }
            }
            if(i != min){
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
                count++;
            }
        }
        System.out.print(a[0]);
        for(int i=1;i<n;i++){
            System.out.printf(" %d",a[i]);
        }
        System.out.println();
        System.out.println(count);
    }
}
