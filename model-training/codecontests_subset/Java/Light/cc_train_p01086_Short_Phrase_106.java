import java.util.Scanner;

public class Main {
	static int[] num;
	static int set;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true){
			set=scan.nextInt();
			if(set==0) break;
			String gomi = scan.nextLine();
			String[] data = new String[set];
			num=new int[set];
			for(int i=0;i<set;++i){
				data[i]=scan.nextLine();
				num[i]=data[i].length();
			}
			for(int i=0;i<set;++i){
				int flag=0,sum=0,j=i;
				while(true){
					if(i<set){
						sum+=num[j];
						if(flag==0||flag==2){
							if(sum==5){
								sum=0;
								flag+=1;
							} else if(sum<5){
							} else {
								break;
							}
						} else {
							if(sum==7){
								sum=0;
								flag+=1;
							} else if(sum<7){
							} else {
								break;
							}
						}
						j++;
					} else {
						break;
					}
					if(flag==5){
						System.out.println(i+1);
						i=set;
						break;
					}
				}
			}
		}
	}
}

