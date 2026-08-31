import java.util.Scanner;
 
class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        int a[] = new int[n];
        int c[] = new int[n-1];
        int point = 0;

        for(int i = 0;i < n;i++){
            a[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            int b = sc.nextInt();
            point += b;
        }
        for(int i = 0; i < n-1; i++){
            c[i] = sc.nextInt();
        }
        for(int i = 1; i < n;i++){
            if(a[i] - 1 == a[i-1])
                point += c[a[i-1]-1];
        }
        System.out.println(point);
    }
}