#include <stdio.h>
#include <stdlib.h>
int main(void)
{
	int n,m,a[51],b[51],c[51],d[51],i,j,z;
	long long int x,y;
	scanf("%d%d",&n,&m);
	for(i=0; i<n; i++){
		scanf("%d%d",&a[i],&b[i]);
	}
	for(i=0; i<m; i++){
		scanf("%d%d",&c[i],&d[i]);
	}
	for(i=0; i<n; i++){
		y=10000000000000001;
		for(j=0; j<m; j++){
			x=abs(a[i]-c[j])+abs(b[i]-d[j]);
			if(y>x){
				y=x;
				z=j+1;
			}
		}
		printf("%d\n",z);
	}
	return 0;
}