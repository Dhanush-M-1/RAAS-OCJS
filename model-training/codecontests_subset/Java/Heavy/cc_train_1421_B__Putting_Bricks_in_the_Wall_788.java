import java.util.ArrayList;
import java.util.Scanner;

public class C676 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner obj=new Scanner(System.in);
		int t=obj.nextInt();
		while(t-->0)
		{
			int n=obj.nextInt();
			char[][] arr=new char[n][n];
			int sa=0,sb=0,fa=0,fb=0;
			for(int i=0;i<n;i++)
			{
				String s=obj.next();
				for(int j=0;j<n;j++)
				{
					arr[i][j]=s.charAt(j);
				}
			}
			
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					if(i==0&&j==1)
					{
						sa=arr[i][j];
					}
					if(i==1&&j==0)
					{
						sb=arr[i][j];
					}
					if(i==n-1&&j==n-2)
					{
						fa=arr[i][j];
					}
					if(i==n-2&&j==n-1)
					{
						fb=arr[i][j];
					}
				}
			}
			if (sa==sb){
                if (fa==fb){
                    if (fa!=sa){
                        System.out.println(0);
                    } else {
                        System.out.println(2);
                        System.out.println((n)+" "+(n-1));
                        System.out.println((n-1)+" "+(n));
                    }
                } else {
                    if (fa==sa){
                        System.out.println(1);
                        System.out.println((n)+" "+(n-1));
                    } else {
                        System.out.println(1);
                        System.out.println((n-1)+" "+(n));
                    }
                }
            } else {
                if (fa==fb){
                    if (fa==sa){
                        System.out.println(1);
                        System.out.println((1)+" "+(2));
                    } else {
                        System.out.println(1);
                        System.out.println((2)+" "+(1));
                    }
                } else {
                    if (fa==sa){
                        System.out.println(2);
                        System.out.println((2)+" "+(1));
                        System.out.println((n)+" "+(n-1));
                    } else {
                        System.out.println(2);
                        System.out.println((1)+" "+(2));
                        System.out.println((n)+" "+(n-1));
                    }
                }
            }

			
		}

	}

}
