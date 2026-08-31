import java.util.Scanner;
public class Main {

    public static void main (String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int[] arr=new int[N];
        int sum=0;
        int a=0;
        int b=0;
        for (int i=0;i<N;i++) {
            arr[i] = in.nextInt();
            if (arr[i]==100)
                a=a+1;
            else
                b=b+1;
        }

        if (b == 0) {
            if (a%2==0)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        else if(a==0){
                if(b%2==0)
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
            else if(a%2==0)
                    System.out.println("YES");
                 else
                    System.out.println("NO");
        
        
        
        }
}