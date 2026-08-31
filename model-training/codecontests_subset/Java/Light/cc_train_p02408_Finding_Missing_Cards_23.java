import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        char[] cardArray={'S','H','C','D'};
        int[][] card=new int[4][13];
        int num = sc.nextInt();
        for(int i=0;i<num;i++){
            char cards=sc.next().charAt(0);
            int number = sc.nextInt();
            if(cards=='S'){
                card[0][number-1]=1;
            }
            if(cards=='H'){
                card[1][number-1]=1;
            }
            if(cards=='C'){
                card[2][number-1]=1;
            }
            if(cards=='D'){
                card[3][number-1]=1;
            }
        }
        for(int i=0;i<4;i++){
            for(int j=0;j<13;j++){
                if(card[i][j]==0)
                System.out.printf("%c %d\n",cardArray[i],(j+1));
            }
        }
    }
}
