import java.util.*;

/**
 * B
 */
public class Main {
    public static void main(String[] args) {
        
    Scanner sc  = new Scanner(System.in);
    
    int n = sc.nextInt();
    int min_j, count=0;
    int array[] = new int[n];

    for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
    }

    sc.close();

    for(int i=0; i<=n-1; i++) {

        min_j = i;

        for(int j=i; j<=n-1; j++) {

            if(array[j] < array[min_j]) {

                min_j = j;

            }
        }

        if(i != min_j) {

            int tmp = array[i];
            array[i] = array[min_j];
            array[min_j] = tmp;
            count++;

        }

    }

    for(int i=0; i<n; i++) {

        System.out.print(array[i]);
        if(i != n-1) {
            System.out.print(" ");
        }
    }

        System.out.println("\n" + count);

    }
}
