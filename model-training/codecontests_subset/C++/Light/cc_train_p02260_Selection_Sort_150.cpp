#include<cstdio>
int main(){
	int n=0,a[125],count=0,mini=0;
	scanf("%d", &n);
	for(int i=0;i<n;i++){
		scanf("%d", &a[i]);
	}
	for(int i=0;i<n-1;i++){
		mini=i ;
		for(int j=i;j<n;j++)
			if(a[j]<a[mini])mini=j;
				if(i!=mini){
				int b=a[i];
				a[i]=a[mini];
				a[mini]=b;
				count++;	
			}
		}
    
	for(int i=0;i<n;i++){
		if(i)printf(" ");
		printf("%d",a[i]);
	}
	printf("\n%d\n",count);
	return 0;
} 