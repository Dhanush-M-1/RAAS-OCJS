import java.util.Scanner;

class Main{
	public static void main(String[] aegs) {
		Scanner sc=new Scanner(System.in);
		int kosu=0;
		while(true) {
			kosu=sc.nextInt();
			if(kosu==0) {
				System.exit(0);
			}
			String[] ko=new String[kosu];
			int[] mjs=new int[kosu];
			for(int i=0; i<kosu; i++) {
				ko[i]=sc.next();
				mjs[i]=ko[i].length();
			}

			boolean[] tanka= {false,false,false,false,false};
			int[] tnkmjs= {5,12,17,24,31};
			int sum=0;
			boolean pf=true;
			boolean end=false;

			for(int start=0; start<kosu; start++) {
				pf=false;
				sum=0;
				for(int j=start; j<kosu; j++) {
					if(end==true) {
						break;
					}
					sum+=mjs[j];
					for(int i=0; i<5; i++) {
						if(sum==tnkmjs[i]) {
							tanka[i]=true;
						}
					}
					if(sum>31) {
						for(int k=0; k<5; k++) {
							tanka[k]=false;
						}
						break;
					}
					if(sum==31) {
						pf=true;
						for(int i=0; i<5; i++) {
							if(tanka[i]==false) {
								pf=false;
							}
						}
						if(pf==true) {
							System.out.println(start+1);
							end=true;
							break;
						}
						else if(pf==false) {
							for(int k=0; k<5; k++) {
								tanka[k]=false;
							}
							break;
						}
					}
				}
			}
		}
	}
}
