import java.util.Scanner;

//time:: 17:02~17:29 18:10~18:20

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n=sc.nextInt();
			if(n==0) break;
			String gomi=sc.nextLine();
			String[] line = new String[n];
			for(int i=0;i<n;++i){
				line[i]=sc.nextLine();
			}
			for(int i=0;i<n-3;++i){
				boolean flag=true;
				int count=line[i].length(),num=0,j=i;
				while(flag){
					if(num==5){
						System.out.println(i+1);
						i=n;
						break;
					}else if(((num==0||num==2)&&5<count)||((num!=0&&num!=2)&&7<count)){
						flag=false;
					}else if(((num==0||num==2)&&5==count)||((num!=0&&num!=2)&&7==count)){
						count=0;
						num++;
					}else{
						j++;
						count+=line[j].length();
					}
				}
			}
		}
	}
}
