#include<stdio.h>
#include<string.h>

int ele[1000000],i,j,n,c,t;

int main(){
	while(0<=scanf("%d",&n)){
		if(n==0)break;
		c=0;
		
		for(i=0;i<n;i++){
			scanf("%d",&ele[i]);
		}
		
		
		for(i=0;i<n;i++){
			for(j=0;j<n-1;j++){
				if(ele[j]>ele[j+1]){
					++c;
					t=ele[j];
					ele[j]=ele[j+1];
					ele[j+1]=t;
				}
			}
		}
		
		printf("%d\n",c);
	}
	return 0;
}