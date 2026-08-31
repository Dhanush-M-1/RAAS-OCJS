#include<stdio.h>
int main()
{
	int n,a[100],i,j,c;
	while(scanf("%d",&n),n)
	{
		for(i=0; i<n; ++i) scanf("%d",&a[i]);
		for(c=i=0; i<n; ++i) for(j=1; j<n; ++j) if(a[j-1]>a[j]) a[j-1]^=a[j],a[j]^=a[j-1],a[j-1]^=a[j],++c;
		printf("%d\n",c);
	}
	return 0;
}