import java.util.Scanner;

/**
     *
     * @author abutair
     */
    public class Training {
static int r1,r2,c1,c2,d1,d2;
        public static void main(String[] args) {
 

         Scanner sc = new Scanner(System.in);
   r1=sc.nextInt();r2=sc.nextInt();c1=sc.nextInt();c2=sc.nextInt();d1=sc.nextInt();d2=sc.nextInt();
 
for(int x1=1;x1<10;x1++)
{
	for(int x2=1;x2<10;x2++)
	{
		
		if(x1==x2)
			continue;
		for(int x3=1;x3<10;x3++)
		{
			
			if(x1==x3||x2==x3)
				continue;
			for(int x4=1;x4<10;x4++)
			{
				if(x4==x1||x4==x2||x4==x3)
					continue;
				
			if(check(x1,x2,x3,x4))
			{
				System.out.println(x1+" "+x2);
				System.out.println(x3+" "+x4);
				System.exit(0);
				
			}
				
				
			}
			
			
			
		}		
		
	}
 
 
}
 
System.out.println(-1);

        } // end Main

public static boolean check(int x1,int x2,int x3,int x4){
	
	
return ((x1+x2)==r1&&(x3+x4)==r2&&(x1+x3)==c1&&(x2+x4)==c2&&(x1+x4)==d1&&(x2+x3)==d2);
 
}

        
        
    
  
    } // end Class
