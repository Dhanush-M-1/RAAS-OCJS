import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int amount = s.nextInt();
        if (amount >= 1 && amount <= 100000){
            int[] id = new int[amount];
            int k = s.nextInt();
              if (k >= 1 && k <= 2* Math.pow(10,9)){

                  for (int i = 0;i < amount; i++){
                      int b = s.nextInt();
                       if (b >= 1 && b <= Math.pow(10,9)){
                      id[i] = b;
                       }
                  }


                  for (int i = 1; i <= amount; i++){
                      if ( k - i >0){
                          k = k - i;
                      }else {
                          System.out.print(id[k-1]);
                          break;
                      }
                  }
              }
        }
    }
}
