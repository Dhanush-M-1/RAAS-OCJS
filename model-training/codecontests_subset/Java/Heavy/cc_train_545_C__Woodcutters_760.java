import java.util.Scanner;

public class Woodcutters {
    //545C
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] positions = new int[n];
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            positions[i] = sc.nextInt();
            heights[i] = sc.nextInt();
                    
        }
            
        int start = positions[0];
        int ans = 1;
        for (int i = 1; i < n; i++) {
            if (positions[i] - heights[i] > start) {

                start = positions[i];
                ans++;
            } else if (i != n - 1 && positions[i] + heights[i] < positions[i + 1]){
                start = positions[i] + heights[i];
                ans++;
            } else if (i == n - 1) {
                ans++;
            } else {
                start = positions[i];
            }
        }

        System.out.println(ans);
    }


    }


