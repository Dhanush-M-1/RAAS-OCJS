import java.util.Scanner;
public class multiplicationTable {
    public static void main(String[] args) {
        Integer.toString(3, 4); //to convert bases
        Scanner in = new Scanner(System.in);
        int tableSize = in.nextInt();
        in.nextLine();


        for (int i = 1; i < tableSize; i++) {
            for (int j = 1; j < tableSize; j++) {
                System.out.print(Integer.toString(i*j, tableSize) + " ");
            }
            System.out.println(" ");
        }


    }
}
