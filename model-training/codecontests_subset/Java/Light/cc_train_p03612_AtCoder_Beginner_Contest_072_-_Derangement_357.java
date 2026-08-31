import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] perm = new int[n + 1];
        int steps = 0;

        for (int i = 1; i < perm.length; i++) perm[i] = scanner.nextInt();
        if (perm[1] == 1){
            swap(perm, 1, 2);
            steps++;
        }
        for (int i = 2; i < perm.length; i++) {
//            System.out.println(Arrays.toString(perm));
            if (i <= perm.length - 2 && perm[i] == i && perm[i + 1] == (i + 1)){
                swap(perm, i, i + 1);
                steps++;
            }
            else if (perm[i] == i){
                swap(perm, i, i - 1);
                steps++;
            }
        }

        System.out.println(steps);
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
