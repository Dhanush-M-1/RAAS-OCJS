import java.util.Random;
import java.util.*;
import java.util.Scanner;

public class Main {

	  
	  public static String binary = "";
	  //System.out.println(ans);
	  public static int gcd(int a,int b){
		if(a == 0)
			return b;
		return gcd(b % a, a);
	  }
	  
	  private static void Binaryform(int number) {
        int remainder;
        if (number <= 1) {
            binary += number;
            return;
        }
        remainder = number %2; 
        Binaryform(number >> 1);
        binary += remainder +"";
      }
	  
	  public static void print(Object o){
		System.out.print(o +" ");
	  }
	  
	  public static void println(Object o){
		System.out.println(o);
	  }

	  public  static class Point{
			  public int x = 0;
			  public int y = 0;
			  
			  Point (int x , int y){
				  this.x = x;
				  this.y = y;
				  }
			  	
			}			
		
		public static int isSquare(Point p1, Point p2,Point p3,Point p4){
			double dx = 0, dy = 0;
			double dd [] = new double [6];
			Point [] pp = new Point[4];
			pp[0]=p1; pp[1]=p2; pp[2]=p3; pp[3]=p4;
			int ii = 0; int jj = 0; int kk = 0; int nn = 0;
			
			for(ii = 0; ii < 3; ii++){
				for(jj = ii + 1; jj < 4; jj++){
					dx = pp[ii].x - pp[jj].x;
					dy = pp[ii].y - pp[jj].y;
					dd[kk] = dx*dx + dy*dy;
					if(dd[kk] == 0) return 0;
					if(kk > 1){
						for(nn = 0; nn < kk - 1; nn++){
							if (!( (2*dd[nn] == dd[kk] ) || (dd[nn] == dd[kk]) || (2*dd[kk] == dd[nn] )) ) 
								return 0;
						}
					}
					kk += 1;
				}
			}
			return 1;
		}
	  
	  /*
	   4
		2 3 4 9
		1 3
	   */
      public static void main(String arg[]){
		Scanner scan = new Scanner(System.in);
		int k = scan.nextInt();
		String s = scan.next();
		int [] alfabet = new int [100];
		for(int i = 0; i < s.length(); i++){
			alfabet[Math.abs('a' - s.charAt(i))] += 1;
		}
		
		boolean flag = true;
		StringBuilder unit = new StringBuilder();
		for(int i = 0; i < 100; i++){
			if(alfabet[i] != 0){
				if(alfabet[i] % k == 0){
					for(int j = 0; j < alfabet[i] / k; j++)
						unit.append((char)('a'+i));
				}
				else flag = false;
			}
			
		}
		if(flag){
			String u = unit.toString();
			StringBuilder ans = new StringBuilder();
			for(int i = 0; i < k; i++)
				ans.append(u);
			System.out.println(ans.toString());
		}
		else System.out.println(-1);
	  }
		

} 

