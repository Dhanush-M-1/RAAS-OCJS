
import java.util.Scanner;


public class kString {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner (System.in);
        
        int k = input.nextInt();
        String s = input.next();
        
        int [] array = new int [27];
        
        for(int i = 0 ; i < s.length() ; i++)
            array[s.charAt(i) - 'a' + 1]++;
        
        boolean b = true;
        
        for(int i = 1 ; i <= 26 ; i++)
            if(array[i] % k != 0)
            {
                b = false;
                break;
            }
        
        
        if(!b)
            System.out.println("-1");
        else
        {
            String ans = "";
        
            for(int i = 1 ; i <= 26 ; i++)
            {
                if(array[i] != 0)
                {
                    for(int j = 0 ; j < array[i]/k ; j++)
                        ans += (char)(i+96);
                }
            }

            for(int i = 0 ; i < k ; i++)
                System.out.print(ans);
            
            System.out.println();
        }
        
    }
    
}
