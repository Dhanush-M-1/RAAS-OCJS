import java.io.*;
import java.util.*;

/**
 *
 * @author Андрей
 */
public class Cry 
{
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException 
    {
        Scanner reader = new Scanner(System.in);
        int n = Integer.parseInt(reader.nextLine());
        int[] mass = new int[n];
        int sum = 0, max = 0;
        
        for (int i = 0; i < n; i++){
            mass[i] = reader.nextInt();
            if (max < mass[i]) max = mass[i];
            sum += mass[i];
        }
        
        while ((max * n - sum) <= sum){
            max++;
        }
        System.out.println(max);
    }
}