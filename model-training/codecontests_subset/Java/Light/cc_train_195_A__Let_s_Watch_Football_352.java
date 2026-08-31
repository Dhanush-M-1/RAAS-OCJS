import java.util.Scanner;

    public class Test {
            public static void main(String args[]){
            	Scanner input = new Scanner(System.in);
                   	int a = input.nextInt();
                   	int b = input.nextInt();
                   	int c = input.nextInt();
                    System.out.println(maximum(a,b,c));
            }
            
          public static int maximum(int a,int b,int c){
        	  int count = 0;
        	  while(true){
        		  int st = b*count;
        		  int re = a*c-st;
        		  while(true){
        			  re -= b;
        			  if(re < 0)return count;
        			  st += b;
        			  st -= a;
        			  if(st < 0)break;
        		  }
        		  count++;
        	  }
          }

        

    }