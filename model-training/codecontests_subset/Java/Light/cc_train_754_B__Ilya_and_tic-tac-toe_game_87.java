import java.util.Scanner;


public class B390 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		char[][] t = new char[4][4];
		
		for(int i=0;i<4;i++){
			String s = sc.next();
			for(int j=0;j<4;j++){				
				t[i][j] = s.charAt(j);
			}			
		}

		String ans = "NO";
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){				
				
				if(t[i][j]!='.')continue;
				
				t[i][j] = 'x';
				boolean b = check(t);
				if(b){
					ans = "YES";
					break;
				}
				t[i][j] = '.';
				
			}			
		}

		System.out.println(ans);
	}
	
	
	private static boolean check(char[][] t){
		
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){				
				
				if(t[i][j]!='x')continue;
				
				
				if((i+2)<4 && t[i+1][j]=='x' && t[i+2][j]=='x'){
					return true;
				}
				
				if((i+2)<4 && (j+2)<4 && t[i+1][j+1]=='x' && t[i+2][j+2]=='x'){
					return true;
				}
				
				
				
				if((i+2)<4 && (j-2)>=0 && t[i+1][j-1]=='x' && t[i+2][j-2]=='x'){
					return true;
				}
				

				if((j+2)<4 && t[i][j+1]=='x' && t[i][j+2]=='x'){
					return true;
				}
				
			}			
		}		
		
		return false;
		
		
	}

}
