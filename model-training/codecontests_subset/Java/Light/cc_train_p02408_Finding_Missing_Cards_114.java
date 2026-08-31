import java.util.Scanner;

class Main {
    public static void main(String [] args){
    	Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String gara = "SHCD";
        int [][] card = new int[4][13];
        
        for(int i = 0; i < n; i++){
        	
            char inputgara = sc.next().charAt(0);
            int  cardnum = sc.nextInt();
            
            card[gara.indexOf(inputgara)][cardnum - 1] = 1;// 1???????????? 0??????????????????
            
        }
        
        for(int i = 0 ; i < 4 ; i++ ){
        	for(int j = 0 ; j < 13 ; j++ ){
        		if(card[i][j] != 1){
        			System.out.println( gara.charAt(i) + " " + (j+1));
        		}
        	}
        		
        }
           
            
    }
}