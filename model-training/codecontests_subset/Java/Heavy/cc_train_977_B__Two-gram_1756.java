
            import java.util.*;


            public class CodeForce{
                public static void main(String[] args) {
                    Scanner in=new Scanner(System.in);
                    int n=in.nextInt();
                    String s=in.next();
                    char c[]=s.toCharArray();
                    String s_2="";
                    int max=0;
                    int counter=0;
                    for(int i=0;i<n-1;i++){
                    for(int j=0;j<n-1;j++){
                        if(c[i]==c[j] && c[i+1]==c[j+1])
                            counter++;
                    }
                    
                    if(max<counter){
                        max=counter;
                        s_2=String.valueOf(c[i])+String.valueOf(c[i+1]);
                    }
                    counter=0;
                    }
                    System.out.println(s_2);
            }          
            }






















