import java.util.Scanner;
class Main{
    public static void main(String[] av){
	Scanner sc=new Scanner(System.in);
	while(true){
	int H=sc.nextInt();
	int W=sc.nextInt();
	if(H==0&&W==0) break;
        int k=0;
	for(int i=0;i<H;i++){
	    for(int j=0;j<W;j++){
		if(j==0){
		    if(i%2==0){
			System.out.print("#");k=1;
		    } else{
			System.out.print(".");k=0;
		    }
		}else	if(k%2!=0){
		System.out.print("#");
		}else{
		    System.out.print(".");
		}
		k++;
	    }
	    System.out.println();
	    
	}
	 System.out.println();
	}
    
    }
}
