import java.util.*;
public class bolmmmmm {

	public static void main(String[] args) {
		try {
			Scanner sc=new Scanner(System.in);
			int t=sc.nextInt();
			while(t-->0) {
				int n=sc.nextInt();
				int m=sc.nextInt();
				ArrayList<Integer>list1=new ArrayList<>();
				ArrayList<Integer>list2=new ArrayList<>();
				for(int i=0;i<n;i++) {
					list1.add(sc.nextInt());
				}
				for(int i=0;i<m;i++) {
					list2.add(sc.nextInt());
				}
				boolean k=false;
				if(list2.size()>list1.size()) {
					for(int i=0;i<list2.size();i++) {
						if(list1.contains(list2.get(i))==true)
						{
							
							System.out.println("YES");
							System.out.println(1+" "+list2.get(i));
							k=true;
							break;
						}
					}
				}
				else {
					for(int i=0;i<list1.size();i++) {
						if(list2.contains(list1.get(i))==true)
						{
							
							System.out.println("YES");
							System.out.println(1+" "+list1.get(i));
							k=true;
							break;
						}
					}
				}
				if(k==false) {
					System.out.println("NO");
				}
			}
			
		}catch(Exception e) {
			
		}
	}

}