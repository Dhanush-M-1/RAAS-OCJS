import java.util.Scanner;


public class SerialKiller {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		String[] initial=s.nextLine().split("\\s+");
		int n=Integer.parseInt(s.nextLine());
		
		System.out.println(initial[0]+" "+initial[1]);
		
		for(int i=0;i<n;i++){
			String[] potential=s.nextLine().split("\\s+");
			if(initial[0].equals(potential[0])){
				initial[0]=potential[1];
			}else if(initial[0].equals(potential[1])){
				initial[0]=potential[0];
			}
			if(initial[1].equals(potential[0])){
				initial[1]=potential[1];
			}else if(initial[1].equals(potential[1])){
				initial[1]=potential[0];
			}
			System.out.println(initial[0]+" "+initial[1]);
		}
	}

}
