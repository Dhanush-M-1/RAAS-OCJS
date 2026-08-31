import java.util.Scanner;

public class  Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int cnt=0;

        for (int i=0;i<n;i++){
            int p=sc.nextInt();
            int c=Math.min(p-1,1000000-p);
            cnt= Math.max(cnt,c);
        }
        System.out.println(cnt);
    }
}