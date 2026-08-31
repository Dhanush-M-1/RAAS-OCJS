
import java.util.*;
public class A {

    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        reader.nextLine();
        char[] lvl = reader.nextLine().toCharArray();

        boolean isFound = false;
        for(int i = 1; (i <= (n - 1)/4) && (!isFound); i++) {
            for(int j = 0; j < n - 4*i; j++) {
                if( (lvl[j] == '*') && (lvl[j+i] == '*') && (lvl[j+2*i] == '*') && (lvl[j+3*i] == '*') && (lvl[j+4*i] == '*') ) {
                    isFound = true;
                }
            }
        }

        if (isFound)
            System.out.println("yes");
        else
            System.out.println("no");
    }
}
