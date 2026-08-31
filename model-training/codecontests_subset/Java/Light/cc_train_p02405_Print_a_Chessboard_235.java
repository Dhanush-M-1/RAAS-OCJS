public class Main {


		public static void main(String[] args) {
		java.util.Scanner scan = new java.util.Scanner(System.in);
		int h, w, i, t;
		
while(true){
		h = scan.nextInt();
		w = scan.nextInt();
		
		if(h == 0 && w == 0){
				break;
			}
		if(1 <= h && h <= 300 && 1 <= w && w <= 300){
			for(i = 1; i <= h ; i++){
			for(t = 1; t <= w ; t++){
				if(t % 2 != 0 && i % 2 != 0 || t % 2 == 0 && i % 2 == 0){
				System.out.print("#");
				}else{
					
					System.out.print(".");
				}
			}System.out.println("");
			
			}System.out.println("");
		
		
		}
		
		}
		}
}	