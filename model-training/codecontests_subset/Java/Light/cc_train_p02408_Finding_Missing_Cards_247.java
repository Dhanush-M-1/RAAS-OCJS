import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[][] cards = new boolean[4][13];
        char[] row = new char[] {'S','H','C','D'};
        for(int i=0; i<n; i++){
            String m = sc.next();
            int t = sc.nextInt();
            switch(m){
                case "S": cards[0][t-1] = true; break; 
                case "H": cards[1][t-1] = true; break;
                case "C": cards[2][t-1] = true; break;
                case "D": cards[3][t-1] = true; break;
            }
        }
        for(int i=0; i<4; i++){
            for(int j=0; j<13; j++){
                if(!cards[i][j]) System.out.println(row[i] +" "+ (j+1));
            }
        }
    }
}
