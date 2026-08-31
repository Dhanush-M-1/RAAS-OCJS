import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[][] bool = new boolean[4][13];
        char[] c = new char[]{'S', 'H', 'C', 'D'};
        for(int i = 0; i < n; i++){
            String str = sc.next();
            int index = sc.nextInt();
            if(str.contains("S")){
                bool[0][index - 1] = true;
            }else if(str.contains("H")){
                bool[1][index - 1] = true;
            }else if(str.contains("C")){
                bool[2][index - 1] = true;
            }else if(str.contains("D")){
                bool[3][index - 1] = true;
            }
        }
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 13; j++){
                if(bool[i][j] == false){
                    System.out.println(c[i] + " " + (j + 1));
                }
            }
        }
    }
}
