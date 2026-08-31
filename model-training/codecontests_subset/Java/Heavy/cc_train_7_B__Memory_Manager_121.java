import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		s.nextLine();
		int segname = 1;
		int []a = new int[m];

		for(int t = 0;t<n;t++){
		    String in = s.nextLine();
		    String cmds[] = in.split(" ");
		    if(cmds.length==1){
		        int ind = 0;
		        for(int j = 0;j<m;j++){
		            if(a[j]!=0){
		                a[ind++] = a[j];
		                if(ind-1!=j) a[j] = 0;
		            }
		        }
		    }else{
		        int number = Integer.parseInt(cmds[1]);
		        if(cmds[0].equals("alloc")){
		            boolean q = true;
                    for (int i = 0; i < m; i++) {
                        if (a[i] == 0) {
                            boolean p = true;
                            for (int j = i; j < i + number; j++) {
                                if (j == m || a[j] != 0) {
                                    p = false;
                                    break;
                                }
                            }
                            if (p) {
                                for (int j = i; j < number + i; j++) {
                                    a[j] = segname;
                                }
                                System.out.println(segname++);
                                q = false;
                                break;
                            }
                        }
                    }
		            if(q) System.out.println("NULL");
		          
		        }else{
		            boolean flag = true;
		            for(int k = 0;k<m;k++){
		                if(a[k]==number){
		                    int j = k;
		                    while(j<m && a[j]==number){
		                        a[j] = 0;
		                        j++;
		                    }
		                    flag = false;
		                }
		            }
		            if(flag || number<=0) System.out.println("ILLEGAL_ERASE_ARGUMENT");
		        }
		    }
		}
	}
}