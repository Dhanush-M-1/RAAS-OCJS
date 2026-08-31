

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class Main {

    
    
    public static void main(String[] args) throws NumberFormatException, IOException
    {
        
        Scanner sc = new Scanner(System.in);
    
        int k = sc.nextInt();
        
        String s = sc.next();
        
        int[] c = new int[26];
        
        for(int i = 0; i < s.length(); i++)
            c[s.charAt(i)-'a']++;
        
        if(possible(c, k))
        {
            StringBuilder p = new StringBuilder();
            for(int i = 0; i < 26; i++)
                for(int j = 0; j < c[i] / k; j++)
                    p.append((char)(i+'a'));
            for(int i = 0; i < k; i++)
                System.out.print(p);
            System.out.println();
        }
        else
            System.out.println(-1);
        
    }
    
    static boolean possible(int[] c, int k)
    {
        for(int i = 0; i < 26; i++)
            if(c[i]%k != 0)
                return false;
        return true;
            
    }


}
