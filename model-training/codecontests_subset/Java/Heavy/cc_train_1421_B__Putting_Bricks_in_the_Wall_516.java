import java.util.*;
public class q2 {
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int t=sc.nextInt();
        for(int z=0;z<t;z++){
            int n=sc.nextInt();
            String a[]=new String[n];
            for(int i=0;i<n;i++){
                a[i]=sc.next();
            }
            int sum=0;
            ArrayList<Integer>al=new ArrayList<>();
            if((a[0].charAt(1)==a[n-1].charAt(n-2))||(a[0].charAt(1)==a[n-2].charAt(n-1))||(a[1].charAt(0)==a[n-1].charAt(n-2))||(a[1].charAt(0)==a[n-2].charAt(n-1))){
                if(a[0].charAt(1)!=a[1].charAt(0)){
                    if(a[n-2].charAt(n-1)!=a[n-1].charAt(n-2)){
                        if(a[0].charAt(1)==a[n-2].charAt(n-1)){
                            sum+=2;
                            al.add(1);
                            al.add(2);
                            al.add(n);
                            al.add(n-1);
                        }
                        else if(a[0].charAt(1)==a[n-1].charAt(n-2)){
                            sum+=2;
                            al.add(2);
                            al.add(1);
                            al.add(n);
                            al.add(n-1);
                        }
                    }
                    else if(a[n-2].charAt(n-1)==a[n-1].charAt(n-2)){
                        if(a[1].charAt(0)==a[n-2].charAt(n-1)){
                            sum++;
                            al.add(2);
                            al.add(1);
                        }
                        else if(a[0].charAt(1)==a[n-2].charAt(n-1)){
                            sum++;
                            al.add(1);
                            al.add(2);
                        }
                    }
                }
                else if(a[0].charAt(1)==a[1].charAt(0)){
                    if(a[n-2].charAt(n-1)!=a[n-1].charAt(n-2)){
                        if(a[1].charAt(0)==a[n-2].charAt(n-1)){
                            sum++;
                            al.add(n-1);
                            al.add(n);
                        }
                        else if(a[1].charAt(0)==a[n-1].charAt(n-2)){
                            sum++;
                            al.add(n);
                            al.add(n-1);
                        }
                    }
                    else if(a[n-2].charAt(n-1)==a[n-1].charAt(n-2)){
                        if(a[0].charAt(1)==a[n-1].charAt(n-2)){
                            sum+=2;
                            al.add(1);
                            al.add(2);
                            al.add(2);
                            al.add(1);
                        }
                    }
                }
            }
            System.out.println(sum);
            if(sum==1)
                System.out.println(al.get(0)+" "+al.get(1));
            if(sum==2){
                System.out.println(al.get(0)+" "+al.get(1));
                System.out.println(al.get(2)+" "+al.get(3));
            }
        }
    }
}
