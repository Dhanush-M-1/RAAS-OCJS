import java.util.Scanner;
class Main{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int rect = 0;
		int dia = 0;
		while(scan.hasNext()){
			String[] str = (scan.nextLine()).split(",");
			int[] a = new int[3];
			for(int i = 0;i < 3;i++){
				a[i] = Integer.parseInt(str[i]);
			}
			if(a[0] == a[1]){
				dia++;
			}
			if(a[0]*a[0]+a[1]*a[1] == a[2]*a[2]){
				rect++;
			}
		}
		System.out.println(rect + "\n" + dia);
	}
}