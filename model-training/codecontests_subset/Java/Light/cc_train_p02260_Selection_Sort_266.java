import java.util.Scanner;

public class Main {
    private static Scanner sc=new Scanner(System.in);
    public static void main(String[] args){
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++) a[i]=sc.nextInt();
        int counter=0;
        for(int i=0;i<n;i++){
            int minj=i;
            for(int j=i;j<n;j++){
                if(a[j]<a[minj]) minj=j;
            }
            if(i!=minj) counter++;
            int t=a[i];
            a[i]=a[minj];
            a[minj]=t;
        }
        for(int i=0;i<=n-2;i++) System.out.printf("%d ",a[i]);
        System.out.println(a[n-1]);
        System.out.println(counter);
    }
}