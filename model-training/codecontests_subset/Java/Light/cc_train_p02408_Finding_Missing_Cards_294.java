import java.util.Scanner;

class Main{
    public static void main(String[] args){
    	int cards[][] = new int[4][13];
        int n;
        
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		
		for(int i = 0;i < n;i++){
			String kind = scanner.next();
			int num     = scanner.nextInt();
			
			if(kind.equals("S")){
				cards[0][num-1] = num;
			}
			else if(kind.equals("H")){
				cards[1][num-1] = num;
			}
			else if(kind.equals("C")){
				cards[2][num-1] = num;
			}
			else{
				cards[3][num-1] = num;
			}
		} 
		
		for(int i = 0;i < 4;i++){
			for(int j = 0;j < 13;j++){
				if(cards[i][j] == 0){
					if(i == 0){
						System.out.println("S "+(j+1));
					}
					else if(i == 1){
						System.out.println("H "+(j+1));
					}
					else if(i == 2){
						System.out.println("C "+(j+1));
					}
					else{
						System.out.println("D "+(j+1));
					}
					
				}
			}	
		}
    	scanner.close();
    }
}