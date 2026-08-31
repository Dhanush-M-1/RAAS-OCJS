import java.util.Scanner;

/**
 * Created by Kevin Wang on 10/11/2016.
 */
public class codePractice6 {
    public static  void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tree = sc.nextInt();
        int[] cord = new int[tree];
        int[] h = new int[tree];
        int result = 2;
        if (tree < 3)
            System.out.println(tree);
        else {
            for (int i = 0; i < tree; i++) {
                cord[i] = sc.nextInt();
                h[i] = sc.nextInt();
            }
            boolean[] down = new boolean[tree-1];
                for (int i = 0; i < tree-2; i++) {
                    if (!down[i] && cord[i+1] - cord[i] > h[i+1]) {
                        result++;
                        down[i] = true;
                    } else if (down[i] && cord[i+1] - cord[i] > h[i] + h[i+1]) {
                        result++;
                    }else if(!down[i+1]&& cord[i+2] - cord[i+1] > h[i +1]){
                        result++;
                        down[i+1] = true;
                    }else if(down[i+1] && cord[i+2] - cord[i+1] > h[i+1] + h[i+2])
                        result++;
                }
            System.out.println(result);
        }
    }
}
