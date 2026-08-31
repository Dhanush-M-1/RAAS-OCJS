import java.util.Scanner;

public class Main{
    public static void swap(int[] A, int a, int b){
        int s = A[a];
        A[a] = A[b];
        A[b] = s;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        int[] a = new int[n];
        /*input*/
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }
        /*sort*/
        for(int i=0; i<n-1; i++){
            int min = i;
            for(int j=i+1; j<n; j++) {
                if(a[j]<a[min]) min=j;
            }
            if(i != min){
                swap(a, i, min);
                cnt++;
            }

        }
        /*output*/
        for(int i=0; i<n-1; i++) System.out.printf("%d ", a[i]);
        System.out.println(a[n-1]);
        System.out.println(cnt);
    }
}

