#include<cstdio>
#include<functional>
#include<algorithm>
using namespace std;
void func(int);

int main(void)
{
	int n,i,j,a[100],minj,cnt;
	scanf("%d",&n);
	for(i=0;i<n;i++)	scanf("%d",&a[i]);
	cnt=0;
	for(i=0;i<n;i++)	{
		minj=i;
		for(j=i;j<n;j++)	{
			if(a[j]<a[minj])	minj=j;
		}
		if(i!=minj)	{
			swap(a[i],a[minj]);
			cnt++;
		}
	}
	printf("%d",a[0]);
	for(i=1;i<n;i++)	printf(" %d",a[i]);
	printf("\n");
	printf("%d\n",cnt);
	return 0;
}
