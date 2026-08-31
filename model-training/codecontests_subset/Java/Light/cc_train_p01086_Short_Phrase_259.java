import java.util.Scanner;

public class Main {
	static int n;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true){
		n = scan.nextInt();
		if(n==0){
			break;
		}
		String mu = scan.nextLine();
		String[] word = new String[n];
		int mozi[] = new int[n];
		for(int i=0;i<n;++i){
			word[i]=scan.nextLine();
			mozi[i]=word[i].length();
		}
		int hit=0;
		for(int i=0;i<n;++i){
			int result = cut1(mozi,i);
			if(result!=-1&&result<n-3){
				result = cut2(mozi,result);
				if(result!=-1&&result<n-2){
					result = cut1(mozi,result);
					if(result!=-1&&result<n-1){
						result = cut2(mozi,result);
						if(result!=-1&&result<n){
							result = cut2(mozi,result);
							if(result!=-1){
								hit = i+1;
								break;
							}
						}
					}
				}
			}
		}
		System.out.println(hit);
		}
	}
	
	public static int cut1(int[] mozi, int num){
		int d=mozi[num];
		if(d==5){
			return num+1;
		}
		for(int i=num+1;i<n;++i){
			d+=mozi[i];
			if(d==5){
				return i+1;
			} else if(d>5){
				break;
			}
		}
		return -1;
	}
	public static int cut2(int[] mozi, int num){
		int d=mozi[num];
		if(d==7){
			return num+1;
		}
		for(int i=num+1;i<n;++i){
			d+=mozi[i];
			if(d==7){
				return i+1;
			} else if(d>7){
				break;
			}
		}
		return -1;
	}
}