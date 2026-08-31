import java.util.Scanner;

public class H {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=1;i<n;i++){
            for(int j=1;j<n;j++){
                int tmp=i*j;
                System.out.print(Integer.toString(tmp, n)+" ");
            }
            System.out.println();
        }
    }
}
