import java.util.Scanner;

public class Main
{  
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        char[] pass = sc.nextLine().toCharArray();
        int n = sc.nextInt(); 
        boolean case1 = false, case2 = false;
        char[] key = new char[2];
        
        for (int i = 0; i < n; ++i){
            key = sc.next().toCharArray();
            if ((key[0] == pass[0]) && (key[1] == pass[1])){
                System.out.println("YES");
                return;
            } 
            if ((key[0] == pass[1]) && (key[1] == pass[0])){
                System.out.println("YES");
                return;
            }
            if (key[1] == pass[0]){
                case1 = true;
            }
            if (key[0] == pass[1]){
                case2 = true;
            }
            if (case1 && case2){
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}