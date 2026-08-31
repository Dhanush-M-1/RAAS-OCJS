import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
 public static void main(String args[])
 {
   try{ 
     BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(System.in));
    // Scanner scanner =new Scanner(System.in);
    // Set<Integer> set = new HashSet<Integer>();
     String str=bufferedreader.readLine();
     String num[] = str.split("\\+");
     Arrays.sort(num);
     System.out.print(num[0]);
     for(int i = 1;i<num.length;i++)
         System.out.print("+" + num[i]);
   } // End Of Try Block
    catch(IOException e) {}
 } // End Of Main Block
}