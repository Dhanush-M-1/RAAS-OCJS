import java.io.*;
import java.util.*;

public class codeforces{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        ArrayList<Integer> ar = new ArrayList<>();

        for(int i = 0; i < s.length(); i = i+2){
            ar.add(Integer.parseInt(String.valueOf(s.charAt(i))));
        }

        Collections.sort(ar);

        int i = 0;
        for(i = 0; i < ar.size()-1; i++)
            System.out.print(ar.get(i) + "+");

   System.out.println(ar.get(i));    
   
    }
}
