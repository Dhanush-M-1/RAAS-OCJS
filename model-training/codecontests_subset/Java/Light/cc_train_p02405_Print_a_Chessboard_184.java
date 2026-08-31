import java.util.Scanner;
class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
    int H;
    int W;

		while(true){
			H = scanner.nextInt();
			W = scanner.nextInt();
			if(H==0 && W==0){
				    break;
      }
			for (int i=0;i<H;i++) {
				for (int j=0;j<W;j++) {
					if((i+j)%2==0){
						System.out.print("#");
					}else{
						System.out.print(".");
          }
				}
				System.out.print("\n");
			}
			System.out.print("\n");
		 }

	  }
}
