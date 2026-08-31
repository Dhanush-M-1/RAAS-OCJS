import java.util.Scanner;
public class Forsolving {
    public static void main(String[] args) {
        Scanner enter = new Scanner (System.in);
        int k = enter.nextInt(), fornow = 0, count[] = new int [26];
        String s = enter.next();
        String result = "";
        for(int i = 0, len = s.length() ; i < len ; i++)
            count[s.charAt(i)-97]++;
        
        for(int i = 0 ; i < 26 ; i++)
            if(count[i] % k != 0)
            {
                System.out.println(-1);
                System.exit(0);
            }
        
        for(int i = 0 ; i < 26 ; i++)
            if(count[i] != 0)
            {
                for(int j = 0 ; j < count[i]/k ; j++)
                {
                    result += (char)(97+i);
                }
            }
        for(int i = 0 ; i < k ; i++)
            System.out.print(result);
        
    }
}
