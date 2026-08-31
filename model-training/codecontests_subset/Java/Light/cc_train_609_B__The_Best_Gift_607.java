import java.util.Scanner;

public class CodeForces97 {
  public static void main(String argv[]) {
    Scanner scanner = new Scanner(System.in);
    
    int books = scanner.nextInt();
    int genres = scanner.nextInt();
    
    int[] array = new int[genres];
    
    for(int i = 0; i < books; i++) {
      int book = scanner.nextInt();
      array[book - 1]++;
    }
    
    long total = 0;
    
    for(int i = 0; i < genres; i++) {
      for(int j = i; j < genres; j++) {
        if(i != j) {
          total += array[i] * array[j];
        }
      }
    }
    
    System.out.print(total);
    
    scanner.close();
  }
}
