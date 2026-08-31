#include<stdio.h>

int selectionsort(int a[],int n){
	int i,j,minj,s,c=0;
	for(i=0;i<=n-1;i++){
		minj=i;
		for(j=i;j<=n-1;j++){
			if(a[j]<a[minj]){
				minj=j;
			}
		}
		s=a[i];
		a[i]=a[minj];
		a[minj]=s;
		if(i!=minj) c++;
	}
	return c;
}

int main()
{
	int i,n,a[100],c;
	scanf("%d",&n);
	for(i=0;i<n;i++){
		scanf("%d",&a[i]);
	}
	c=selectionsort(a,n);
	
	for(i=0;i<n;i++){
		if(i>0) printf(" ");
		printf("%d",a[i]);
	}
	printf("\n%d\n",c);
	return 0;
}