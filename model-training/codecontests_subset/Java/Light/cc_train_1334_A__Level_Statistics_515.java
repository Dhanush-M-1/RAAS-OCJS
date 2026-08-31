import java.util.*;
public class stats {
    public static void main(String[] args) {
        Scanner iangay = new Scanner(System.in);
        int tc = iangay.nextInt();
        for (int i = 0; i < tc; i++) {
            int peeks = iangay.nextInt();
            int prevPlays = -1; int prevClears = -1; boolean good = true;
            for (int j = 0; j < peeks; j++) {
                int plays = iangay.nextInt(); int clears = iangay.nextInt();
                if (prevClears > clears || prevPlays > plays || plays < clears || plays - prevPlays < clears - prevClears) { good = false; }
                else { prevClears = clears; prevPlays = plays; }
            }
            if (good) { System.out.println("YES"); }
            else { System.out.println("NO"); }
        }
    }
}