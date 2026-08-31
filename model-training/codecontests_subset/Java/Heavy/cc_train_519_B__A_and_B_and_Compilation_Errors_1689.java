import java.util.*;



public class S519B{
   public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
   
              int n=sc.nextInt();
              int[] a=new int[n];
              int[] a2=new int[n];
              int[] a3=new int[n];

              for(int i=0;i<n;i++){
              	a[i]=sc.nextInt();
              }
              for(int i=0;i<n-1;i++){
              	a2[i]=sc.nextInt();
              }
              for(int i=0;i<n-2;i++){
              	a3[i]=sc.nextInt();
              }
              
                int ans=0,ans1=0;

                a2[n-1]=Integer.MAX_VALUE;
                 a3[n-1]=Integer.MAX_VALUE;
                  a3[n-2]=Integer.MAX_VALUE;
                  Arrays.sort(a);
               Arrays.sort(a2);
                Arrays.sort(a3);


              for(int i=0;i<n;i++){
              	if(a[i]!=a2[i]){
              		ans=a[i];
              		break;
              	}
              }
               for(int i=0;i<n;i++){
              	if(a2[i]!=a3[i]){
              		ans1=a2[i];
              		break;
              	}
              }
              if(ans==Integer.MAX_VALUE){
              	System.out.println("0");
              }
              else{
              System.out.println(ans);}

              if(ans1==Integer.MAX_VALUE){
              	System.out.println("0");
              }
               else{ System.out.println(ans1);}

            }
        }