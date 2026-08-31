import java.io.PrintWriter;
import java.util.Scanner;

public class T495C {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		PrintWriter out=new PrintWriter(System.out);
		char[] c=in.next().toCharArray();
		in.close();
		int i,left,leftCnt,rightCnt,sharp,sharpCnt,n=c.length;
		
		leftCnt=0;
		rightCnt=0;
		sharpCnt=0;
		for(i=0;i<n;i++)
			if(c[i]=='#')
				sharpCnt++;
			else if(c[i]=='(')
				leftCnt++;
			else if(c[i]==')')
				rightCnt++;
		
		if(leftCnt<=rightCnt)
			out.println(-1);
		else{
			int[] res=new int[sharpCnt];
			left=0;
			sharp=0;
			for(i=0;i<n;i++){
				if(c[i]=='('){
					left++;
				}else if(c[i]==')'){
					if(left==0){
						out.println(-1);
						out.flush();
						return;
					}
					left--;
				}else if(c[i]=='#'){
					if(left==0){
						out.println(-1);
						out.flush();
						return;
					}
					sharp++;
					if(sharp<sharpCnt){
						res[sharp-1]=1;
						left--;
					}else{
						res[sharp-1]=leftCnt-rightCnt-(sharpCnt-1);
						left-=res[sharp-1];
						if(left<0){
							out.println(-1);
							out.flush();
							return;
						}
					}
				}
			}
			for(int e:res)
				out.println(e);
		}
		out.flush();
	}

}
