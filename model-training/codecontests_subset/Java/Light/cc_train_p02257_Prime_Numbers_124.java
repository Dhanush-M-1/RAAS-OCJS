import java.util.Scanner;

public class Main {
    private static Scanner sc=new Scanner(System.in);
    public static void main(String[] args){
        int n=sc.nextInt();
        int[] a=new int[n];
        int notprime=0;
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
            for(int j=2;j<=Math.sqrt(a[i]);j++){
                if(a[i]%j==0){
                    notprime++;
                    break;
                }
            }
        }
        System.out.println(n-notprime);
    }
}