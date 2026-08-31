import java.util.Scanner;

class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        String patterm = "SHCD";

        int cards[][] = new int[4][13];

        int lost_num = 52-n;

        for(int i=0;i<n;i++){
            String c = sc.next();
            int num = sc.nextInt();
            sc.nextLine();

            cards[patterm.indexOf(c)][num-1] = 1;
        }
        for(int i=0;i<cards.length;i++){
            for(int j=0;j<cards[0].length;j++){
                if(cards[i][j] == 0){
                    System.out.println(patterm.charAt(i)+" "+(j+1));
                    lost_num--;
                }
                if(lost_num == 0) break;
            }
        }
    }
}
