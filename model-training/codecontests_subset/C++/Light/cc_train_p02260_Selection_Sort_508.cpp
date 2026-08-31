#include<cstdio>
#include<cmath>
int main(void){
	
	int i,j,n,c=0,m,b;
	scanf("%d",&n);
	int a[n];
	for(i=0;i<n;i++){
		scanf("%d",&a[i]);
	}
	
	for(i=0;i<n-1;i++){
		m=i;
		for(j=i+1;j<n;j++){
			if(a[m]>a[j]){
				m=j;
			}
		}
		if(a[i]>a[m]){
			c++;
			b=a[i];
			a[i]=a[m];
			a[m]=b;
		}
		
	}

	for(i=0;i<n-1;i++){
		printf("%d ",a[i]);
	}
	printf("%d\n",a[n-1]);
	printf("%d\n",c);
	return 0;
}