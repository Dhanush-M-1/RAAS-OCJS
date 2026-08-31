import java.util.Scanner;
class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int bs[]=new int [n];
		int a=0,b=0,c=0;
		a=sc.nextInt();
		b=sc.nextInt();
		c=sc.nextInt();
		for(int i=0 ; i<n ; i++){
			bs[i]=sc.nextInt();
        }
		for(int i = 0; i<n;i++){
            for(int j=0;j<n;j++){
                if(bs[i]<bs[j]){
                    int work = bs[i];
                    bs[i] = bs[j];
                    bs[j] = work;
                }
            }
        }
		int max=c/a;
		int sum=0;
		for (int i=n-1; i>=0; i--) {
            sum += bs[i];
            max = Math.max(max, (c + sum) / (a + b * (n - i)));
        }
        System.out.println(max);
	}
}