import java.util.Scanner;

public class gram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int k=0;String  ans=" ";
        for(int i=0 ; i<n-1 ;i++)
        {
            int y=0;
            for(int j=0 ; j<n-1 ; j++)
            {
                if(s.substring(i,i+2).equals(s.substring(j,j+2)))y++;
            }
            if(y>k)
            {
                ans=s.substring(i,i+2);
                k=y;
            }
        }
        System.out.println(ans);
    }
}