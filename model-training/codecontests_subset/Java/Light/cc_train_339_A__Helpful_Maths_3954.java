import java.util.*;
import java.io.*;
 
public class Main
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for (int i = 0; i < s1.length(); i += 2)
        {
            list.add((int) s1.charAt(i) - '0');
        }
        
        Collections.sort(list);
        System.out.print(list.get(0));
        
        for (int i = 1; i < list.size(); i++)
        {
            System.out.print("+" + list.get(i));
        }
    }
}