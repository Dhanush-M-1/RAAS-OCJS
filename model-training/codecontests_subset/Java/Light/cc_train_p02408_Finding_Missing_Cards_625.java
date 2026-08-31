import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x,no,ma=0;
		int n=sc.nextInt();
		int[] rauzu=new int[53];
		for(x=1;x<=n;x++){
			String mark=sc.next();
			no = sc.nextInt();
			if(mark.equals("S")){ma=0;
		}else if(mark.equals("H")){ma=13;
		}else if(mark.equals("C")){ma=26;}
		else {ma=39;}
		rauzu[no+ma]=1;
		}
		for(x=1;x<=52;x++){
			if(rauzu[x]!=1){
				if(x<=13){System.out.println("S "+x);}
				else if(x<=26){System.out.println("H "+(x-13));}
				else if(x<=39){System.out.println("C "+(x-26));}
				else if(x<=53){System.out.println("D "+(x-39));}
			}
		}
		}
}