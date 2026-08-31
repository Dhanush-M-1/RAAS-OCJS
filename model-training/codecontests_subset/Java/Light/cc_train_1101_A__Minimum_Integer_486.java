import java.util.Scanner;

public  class Input {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int q= input.nextInt();
        while (q>0)
        {
            int a=input.nextInt();
            int b=input.nextInt();
            int c=input.nextInt();

            int ans;

            a--;
            if(a>=c) ans=c;
            else
            {
                b++;
                int mod=b%c;
              if(mod>0)  b+=(c-mod);
                ans=b;
            }

            System.out.println(ans);

            q--;
        }
    }
}