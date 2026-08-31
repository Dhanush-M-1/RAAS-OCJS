
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int inputs = scanner.nextInt();
        for (int i = 0 ; i < inputs ; i++){
          int length = scanner.nextInt();
          int[] response = new int[length];
          int[] permutation = new int[length];
          for (int j = 0 ; j < length ; j ++){
            permutation[j] = scanner.nextInt();
          }
          process(permutation, 0, length, response, 0);
          printArray(response);
        }
        scanner.close();
    }

    private static void process(int[] permutation, int from, int to, int[] response, int depth){
      if (from != to){
        int index = getIndex(permutation, from, to);
        response[index]= depth;
        process(permutation, from, index, response, depth + 1);
        if (index + 1 < to){
          process(permutation, index + 1, to, response, depth + 1);
        }
      }
    }


    private static int getIndex(int[] permutation, int from, int to){
      int index = from;
      for (int i = from ; i < to ; i ++){
        if (permutation[i] > permutation[index]){
          index = i;
        }
      }
      return index;
    }

    private static void printArray(int[] array){
      for (int i = 0 ; i < array.length ; i ++){
        System.out.print(array[i] + " ");
      }
      System.out.print('\n');
    }
}
