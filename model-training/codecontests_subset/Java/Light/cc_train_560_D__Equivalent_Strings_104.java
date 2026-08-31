
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ирина
 */
public class CodeForces {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String a, b;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        a = reader.readLine();
        b = reader.readLine();
        if (Equal(a, b))
            System.out.println("YES");
        else
            System.out.println("NO");
        
    }
    
    static boolean Equal(String a, String b) {
        if (a.equals(b))
            return true;
        if (a.length() % 2 == 0 && b.length() % 2 == 0) {
            String a1, a2, b1, b2;
            a1 = a.substring(0, a.length() / 2);
            a2 = a.substring(a.length() / 2, a.length());
            b1 = b.substring(0, b.length() / 2);
            b2 = b.substring(b.length() / 2, b.length());
            if (Equal(a1, b2) && Equal(a2, b1))
                return true;
            if (Equal(a1, b1) && Equal(a2, b2))  
                return true;
            
        }
        return false;
    }
    
}
