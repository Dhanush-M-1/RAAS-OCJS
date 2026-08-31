import java.util.*;
public class Main{
   public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
                  sc.nextInt();
                  int[] arrayOfBooks = new int[sc.nextInt()];
                  int numWays = 0;
                  int newBook = 0;
                  while (sc.hasNextInt()){
                     newBook = sc.nextInt();
                     arrayOfBooks[newBook -1]++;
                     }
                  for (int i = 0;i < arrayOfBooks.length -1;i++){
                     for (int next = i+ 1;next < arrayOfBooks.length;next++){
                        numWays+= arrayOfBooks[i]*arrayOfBooks[next];
                        
                     }
                  }
                  System.out.print(numWays);

   }
}