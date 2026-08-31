import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int c = 0;

        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        for(int i=0;i<n-1;i++){
            int min = i;
            for(int j=i+1;j<n;j++){
                if(a[j]<a[min]){
                    min = j;
                } 
            }
            if(a[i]>a[min]){
                int b = a[i];
                a[i] = a[min];
                a[min] = b;
                c++;
            }
        }
        for(int i=0;i<n;i++){
            if(i==n-1) System.out.println(a[i]);
            else System.out.print(a[i]+" ");
        }
        System.out.println(c);
        sc.close();
    }
}
