import java.util.Scanner;

public class ProblemA_Chess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int currentWoner, currentSpect = 3;

        for (int i = 0; i < n; i++) {
            currentWoner= scanner.nextInt();
            scanner.nextLine();
            if (currentWoner == currentSpect) {
                System.out.println("NO");
                return;
            }
            if (currentSpect == 3){
                if (currentWoner == 1){
                    currentSpect = 2;
                } else currentSpect = 1;
            } else if (currentSpect == 2){
                if (currentWoner == 1){
                    currentSpect = 3;
                } else currentSpect = 1;
            } else {
                if (currentWoner == 2){
                    currentSpect = 3;
                } else currentSpect = 2;
            }

//            if (currentWoner == 1 && currentSpect == 3){
//                currentSpect = 2;
//            } else if (currentWoner == 1 && currentSpect == 2){
//                currentSpect = 3;
//            } else if (currentWoner == 2 && currentSpect == 1){
//                currentSpect = 3;
//            } else if (currentWoner == 2 && currentSpect == 3){
//                currentSpect = 1;
//            } else if ()
        }
        System.out.println("YES");
    }
}
