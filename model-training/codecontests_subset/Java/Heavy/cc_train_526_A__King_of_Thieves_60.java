import java.util.Scanner;


public class A {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int n=Integer.parseInt(sc.nextLine());
		char line[]=sc.nextLine().toCharArray();
		
		int max=n/4;		
		boolean found=false;		
		int paso=1;
		int count=0;
		int j=0;
		
		for(paso=1;paso<=max && found==false;paso++){
			for(int i=0;i<paso && found==false;i++){
				j=i;
				count=0;
				while(j<n && count<5){
					if(line[j]=='*'){
						count++;
					}else{
						count=0;
					}
					j=j+paso;
				}
				if(count>=5){
					System.out.println("yes");
					found=true;
				}
			}			
		}
		
		if(!found){
			System.out.println("no");
		}
	}
}