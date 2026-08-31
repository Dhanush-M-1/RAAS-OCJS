import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;


public class HelpVasilisaTheWise2 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
		String s=r.readLine();
		String[] sp=s.split("[ ]+");
		int r1=new Integer(sp[0]);
		int r2=new Integer(sp[1]);
		s=r.readLine();
		sp=s.split("[ ]+");
		int c1=new Integer(sp[0]);
		int c2=new Integer(sp[1]);
		s=r.readLine();
		sp=s.split("[ ]+");
		int d1=new Integer(sp[0]);
		int d2=new Integer(sp[1]);
		for(int a=1;a<=9;a++){
			for(int b=1;b<=9;b++){
				for(int c=1;c<=9;c++){
					for(int d=1;d<=9;d++){
						HashSet<Integer> set=new HashSet<Integer>();
						set.add(a);
						set.add(b);
						set.add(c);
						set.add(d);
						if(set.size()==4){
							int rr1=a+b;
							int rr2=c+d;
							int cc1=a+c;
							int cc2=b+d;
							int dd1=a+d;
							int dd2=b+c;
							if(rr1==r1&&rr2==r2&&cc1==c1&&cc2==c2&&dd1==d1&&dd2==d2){
								System.out.println(a+" "+b);
								System.out.println(c+" "+d);
								return;
							}
						}
					}
				}
			}
		}
		System.out.println(-1);
	}
}
