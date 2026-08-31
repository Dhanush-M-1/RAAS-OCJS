import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        boolean[][] array = new boolean[4][13];


        for (int i=0; i<n; i++) {
            String s = sc.next();
            switch (s.charAt(0)) {
                case 'S':array[0][sc.nextInt()-1] = true; break;
                case 'H':array[1][sc.nextInt()-1] = true; break;
                case 'C':array[2][sc.nextInt()-1] = true; break;
                case 'D':array[3][sc.nextInt()-1] = true; break;
            }
        }
        char[] c = {'S','H','C','D'};
        for (int i=0; i<4; i++) {
            for (int j=0; j<13; j++) {
                if (!array[i][j]) {
                    System.out.println(c[i]+" "+(j+1));
                }
            }
        }
    }
}
