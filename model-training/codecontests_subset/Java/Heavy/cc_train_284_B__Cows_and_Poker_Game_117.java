import java.util.Scanner;


public class Codeforces {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) throws Exception
    {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        int n;
        String str;
        int a=0, b=0, c=0;
        int k = 0;
        n=scanner.nextInt();
        str = scanner.next();
        
        for(int i = 0; i<n; i++)
        {
            if(str.charAt(i) == 'A') a++;
            if(str.charAt(i) == 'F') b++;
            if(str.charAt(i) == 'I') c++;
        }
        
        if(c==1)
        {
            System.out.println(1);
            System.exit(0);
        }
        
        if(c>1)
        {
            System.out.println(0);
            System.exit(0);
        }
        else
        {
            System.out.println(a);
            System.exit(0);
        }
    }
}