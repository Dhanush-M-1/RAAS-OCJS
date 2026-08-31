import java.util.Scanner;
class Main{
    public static void main(String[] args){
	int i,j,n,minj,temp,count=0,change=0;
	int array[] = new int[101];

	Scanner scan = new Scanner(System.in);
	n = scan.nextInt();

	for(i=0;i<n;i++){
	    array[i] = scan.nextInt();
	}

	for(i=0;i<n;i++){
	    minj=i;
	    for(j=i;j<n;j++){
		if(array[j] < array[minj]){
		    minj = j;
		}
	    }
	    if(i!=minj){
	    temp = array[i];
	    array[i] = array[minj];
	    array[minj] = temp;
	    count++;
	    }
	}
	for(i=0;i<n;i++){
	    if(i==n-1){System.out.println(array[i]+"\n"+count);}
	    else System.out.print(array[i]+" ");
	    }
    }
}

