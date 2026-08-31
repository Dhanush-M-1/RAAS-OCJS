import java.util.Scanner;

public class p572D {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for (int i=0;i<n-1;i++){
            int p=sc.nextInt()-1;
            int q=sc.nextInt()-1;
            a[p]++;
            a[q]++;
        }
        for (int i=0;i<n;i++){
            if (a[i]==2){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}