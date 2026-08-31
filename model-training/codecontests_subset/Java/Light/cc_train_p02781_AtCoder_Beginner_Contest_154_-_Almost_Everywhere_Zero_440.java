import java.util.Scanner;
public class Main
{
		public static int sum=0;
		public static int n,l;
		public static String str;
		public static char ch[]=new char[105];
		public static void dfs(int k,int nonzero,boolean beyond,int tot) {
			if(tot<=0)return ;
			if(nonzero==n) {
				sum+=tot;
				return ;
			}
			if(k<l-1)
			{
				if(ch[k]>'0')dfs(k+1,nonzero,false,tot);
				else dfs(k+1,nonzero,beyond,tot);
				if(ch[k]>'0')
				{
					dfs(k+1,nonzero+1,false,tot*(ch[k]-'0'-1));
					dfs(k+1,nonzero+1,beyond,tot);
				}
				dfs(k+1,nonzero+1,true,tot*(9-(ch[k]-'0')));
			}
			else {
				if(nonzero==n-1){
					if(beyond==false)sum+=tot*(ch[k]-'0');
					else sum+=tot*((ch[k]-'0')-1);
				}
			}
		}
        public static void main(String args[]) throws Exception
        {
                Scanner cin=new Scanner(System.in);
                str=cin.next();
                n=cin.nextInt();
                l=str.length();
                for(int i=0; i<l; ++i) {
                	ch[i]=str.charAt(l-i-1);
                }
                dfs(0,0,false,1);
                System.out.println(sum);
                cin.close();
        }
}