import java.util.*;

public class Main{
	public static void main(String args[]){
	Scanner in = new Scanner(System.in);
	int r1=in.nextInt(),r2=in.nextInt();
	int c1=in.nextInt(),c2=in.nextInt();
	int d1=in.nextInt(),d2=in.nextInt();
	int i,j,l,m;
	for(i=1;i<10;i++){
		for(j=1;j<10;j++){
			for(l=1;l<10;l++){
				for(m=1;m<10;m++){
				if(((i!=j)&&(i!=l))&&(((i!=m)&&(j!=l))&&((j!=m)&&(l!=m)))){
					boolean d11=false,d22=false,c11=false,c22=false,r11=false,r22=false;
					if((i+l)==c1)
					c11=true;
					if((j+m)==c2)
					c22=true;
					if((i+j)==r1)
					r11=true;
					if((m+l)==r2)
					r22=true;
					if((i+m)==d1)
					d11=true;
					if((j+l)==d2)
					d22=true;
					if((c11&&c22)&&((r11&&r22)&&(d11&&d22))){
						System.out.println(i+" "+j);
						System.out.println(l+" "+m);
						System.exit(0);
					}
				}
				}
				}
				}
				}
				System.out.println("-1");

	}
}