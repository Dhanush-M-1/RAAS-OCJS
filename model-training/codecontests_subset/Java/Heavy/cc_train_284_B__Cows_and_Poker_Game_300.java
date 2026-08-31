import java.util.Scanner;

public class cowsAndPoker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        int A=0;int I=0;
        for (int i = 0; i < n; i++) 
        {
            
            if(str.charAt(i) == 'I')
                I++;
            if(str.charAt(i) == 'A')
                A++;
        }
        if(I>1)
        {
            System.out.println("0");
        }
        else if(I==1)
        {
            System.out.println("1");
        }
        else if(I==0)
        System.out.println(A);
    }
}