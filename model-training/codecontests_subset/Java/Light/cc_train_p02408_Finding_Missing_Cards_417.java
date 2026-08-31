import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        int i,j,m,n;
        char c;
        char s[]=new char[]{'S','H','C','D'};
        int cards[][]=new int[4][13];
        n=input.nextInt();
        for(i=0;i<n;i++){
            c=input.next().charAt(0);
            m=input.nextInt();
            for(j=0;j<4;j++)
                if(s[j]==c){
                    cards[j][m-1]=1;
                }
            }
        for(i=0;i<4;i++){
        for(j=0;j<13;j++){
            if(cards[i][j]==0)
                System.out.printf("%c %d\n",s[i],j+1);
        }
    }    
    }
}
