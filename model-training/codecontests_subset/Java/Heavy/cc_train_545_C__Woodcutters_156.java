import java.util.*;

public class HelloWorld{

     public static void main(String []args){
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        int[] treePos = new int[n];
        int[] treeHeight = new int[n];
        int[] diffArr = new int[n + 1];
        int treesCut = 0;
        for (int i = 0; i < n; i++) {
            String[] query = s.nextLine().split(" ");
            treePos[i] = Integer.parseInt(query[0]);
            treeHeight[i] = Integer.parseInt(query[1]);
            diffArr[i + 1] = -1;
        }
        treesCut++;
        if (treePos.length > 1) {
            diffArr[0] = treePos[1] - treePos[0];   
        } else {
            diffArr[0] = treePos[0];
        }
        for (int j = 1; j < treePos.length; j++) {
            if(j != treePos.length - 1) {
                int posDiffLeft, posDiffRight;
                if (diffArr[j - 1] != -1) {
                    posDiffLeft = diffArr[j - 1];
                } else {
                    posDiffLeft = treePos[j] - treePos[j-1];
                }
                if (diffArr[j] != -1) {
                    posDiffRight = diffArr[j];
                } else {
                    posDiffRight = treePos[j + 1] - treePos[j];
                }
                if (treeHeight[j] < posDiffLeft) {
                    treesCut++;
                    diffArr[j - 1] = posDiffLeft - treeHeight[j];
                } else if (treeHeight[j] < posDiffRight) {
                    treesCut++;
                    diffArr[j] = posDiffRight - treeHeight[j];
                } else {
                    diffArr[j - 1] = 0;
                }   
            } else {
                treesCut++;
            }
        }
        System.out.println(treesCut);
     }
}