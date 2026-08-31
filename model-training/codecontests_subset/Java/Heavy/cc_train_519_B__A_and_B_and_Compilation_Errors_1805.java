import java.util.Scanner;

public class AandBandCompilationErrors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        //// cheat solution
        int bugs1 = 0;
        int bugs2 = 0;
        int bugs3 = 0;
        for (int i = 0; i < n; i++) {
            bugs1 += scanner.nextInt();
        }
        for (int i = 0; i < n-1; i++) {
            bugs2 += scanner.nextInt();
        }
        for (int i = 0; i < n-2; i++) {
            bugs3 += scanner.nextInt();
        }
        System.out.println(bugs1-bugs2);
        System.out.println(bugs2-bugs3);
        ///////// my solution
//        String[] bug1 = scanner.nextLine().split(" ");
//        String[] bug2 = scanner.nextLine().split(" ");
//        String[] bug3 = scanner.nextLine().split(" ");
//        Arrays.sort(bug1);
//        Arrays.sort(bug2);
//        Arrays.sort(bug3);
//        for (int i = 0; i < n; i++) {
//            if (i == n - 1) {
//                System.out.println(bug1[i]);
//                break;
//            }
//            if (!bug1[i].equals(bug2[i])) {
//                System.out.println(bug1[i]);
//                break;
//            }
//        }
//        for (int i = 0; i < n-1; i++) {
//            if (i == n - 2) {
//                System.out.println(bug2[i]);
//                break;
//            }
//            if (!bug2[i].equals(bug3[i])) {
//                System.out.println(bug2[i]);
//                break;
//            }
//        }
        ///////////////////////////////////////////////
        // Sllllloooow solution
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        ArrayList<Integer> arrayList2 = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            arrayList.add(scanner.nextInt());
//        }
//        for (int i = 0; i < n-1; i++) {
//            int number = scanner.nextInt();
//            arrayList2.add(number);
//            arrayList.remove((Object)number);
//        }
//        System.out.println(arrayList.get(0));
//        for (int i = 0; i < n-2; i++) {
//            int number = scanner.nextInt();
//            arrayList2.remove((Object)number);
//        }
//        System.out.println(arrayList2.get(0));
    }
}