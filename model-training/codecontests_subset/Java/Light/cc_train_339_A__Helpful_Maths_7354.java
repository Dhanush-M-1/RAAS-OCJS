import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.RecursiveAction;
 
public class assighnment {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int l = 0;
        String input = s.next();
        ArrayList<Integer> array = new ArrayList<Integer>();
        for(int i = 0; i < input.length(); i++)
        {
            if(input.charAt(i) == '1')
            {
                array.add(1);
            }
            else if(input.charAt(i) == '2')
            {
                array.add(2);
            }
            else if(input.charAt(i) == '3')
            {
                array.add(3);
            }
        }
        int[] array2 = new int[array.size()];
        for(int i = 0; i < array.size(); i++)
        {
            array2[i] = array.get(i);
        }
        int x = 0;
        for(int i = 0; i < array2.length; i++)
        {
            for(int j = 1; j < array2.length; j++)
            {
                if(array2[j - 1] > array2[j])
                {
                    x = array2[j - 1];
                    array2[j - 1] = array2[j];
                    array2[j] = x;
                }
            }
        }
        for(int i = 0; i < array2.length - 1; i++)
        {
            System.out.print(array2[i]);
            System.out.print('+');
        }
        System.out.print(array2[array2.length - 1]);
 
 
    }
}
 