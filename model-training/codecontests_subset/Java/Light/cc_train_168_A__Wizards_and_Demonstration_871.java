import java.util.Scanner;
 
    public class Test{
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            int n = input.nextInt();
            int x = input.nextInt();
            int y = input.nextInt();
            int clones = (n*y + 99) / 100 - x;
            if (clones < 0){
                clones = 0;
            }
            System.out.println(clones);
        }
    }