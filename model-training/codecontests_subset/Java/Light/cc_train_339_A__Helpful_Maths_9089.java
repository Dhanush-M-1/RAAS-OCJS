import java.util.Scanner;
public class helpful_maths{
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		String eq = s.next();
		String[] num = eq.split("\\+");
		String nwnum = "";
		String tmp = "";
		for(int i = 0; i < num.length-1; i++){
			for(int k = i+1; k < num.length; k++){
				if(Integer.parseInt(num[i]) > Integer.parseInt(num[k])){
					tmp = num[i];
					num[i] = num[k];
					num[k] = tmp; 
				}
			}
		}
		for(int i = 0; i < num.length; i++){
			nwnum += num[i];
			if(i<num.length-1)
				nwnum += "+";
		}
		System.out.println(nwnum);
	}
}