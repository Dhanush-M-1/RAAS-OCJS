import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rebus {

	//Chua Hoan Thanh
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String ls[] = s.split(" ");
		int cong=1,tru=0;
		
		for (int i=1;i<ls.length - 2;i+=2){
			if (ls[i].equals("+")) cong++;
			else if (ls[i].equals("-")) tru++;
		}
		int n = Integer.parseInt(ls[ls.length-1]);
		int fc = 0;
		int ft = n;
		
		List<Integer> lc = new ArrayList<Integer>();
		List<Integer> lt = new ArrayList<Integer>();
		
		while (cong>0 || tru>0){
			int maxc=cong*n +fc;
			int minc=cong +fc;
			int avr2c = (maxc+minc);
			int maxt=tru*n + ft;
			int mint=tru+ft;
			int avr2t = (maxt+mint);
			
			if (maxc<mint || maxt<minc) {
				System.out.println("Impossible");
				return;
			}
			
			if (cong>=tru){
				int d = avr2t - avr2c;
				int ac = d + (n + 1);
				if (ac>2*n) ac = 2*n;
				if (ac<2) ac = 2;
				lc.add(ac/2);
				fc+=ac/2;
				cong--;
			}else{
				int d = avr2c - avr2t;

				int ac = d + (n + 1);
				if (ac>2*n) ac = 2*n;
				if (ac<2) ac = 2;

				lt.add(ac/2);
				ft+=ac/2;
				tru--;

			}
		}
		System.out.println("Possible");
		System.out.print(lc.get(cong)+ " ");
		cong++;
		for (int i=1;i<ls.length - 2;i+=2){
			if (ls[i].equals("+")) {
				System.out.print("+ ");
				System.out.print(lc.get(cong)+ " ");
				cong++;
			}
			else if (ls[i].equals("-")) {
				System.out.print("- ");
				System.out.print(lt.get(tru)+ " ");
				tru++;
			}
		}
		System.out.print("= "+n);
	}

}
