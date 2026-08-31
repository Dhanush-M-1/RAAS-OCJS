import java.util.*;

public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rectangleCnt = 0;
        int lozengeCnt = 0;
        
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            String[] data = input.split(",");
            int side1 = Integer.parseInt(data[0]);
            int side2 = Integer.parseInt(data[1]);
            int diagonal = Integer.parseInt(data[2]);
            
            if (side1*side1+side2*side2 == diagonal*diagonal) {
                rectangleCnt++;
            } else if (side1 == side2) {
                lozengeCnt++;
            }
        }
        System.out.println(rectangleCnt);
        System.out.println(lozengeCnt);
    }   
}