import java.util.*;
public class HelloWorld {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        
        int n = sc.nextInt();
        sc.nextLine();
        
        String str = sc.nextLine();
        int flag = 0;
        int index = -1;
        for(int i = 0;i<str.length()-1;i++)
        {
            if(str.charAt(i)>str.charAt(i+1))
            {
                flag = 1;
                index = i+1;
                break;
            }
        }
        
        if(flag == 1)
        {
            System.out.println("YES");
            System.out.println(index+" "+(index+1));
        }
        else
            System.out.println("NO");
    }
}