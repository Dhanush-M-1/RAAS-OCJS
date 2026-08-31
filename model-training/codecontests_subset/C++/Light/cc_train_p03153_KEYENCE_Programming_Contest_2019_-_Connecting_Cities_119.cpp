#include<cstdio>
int dpL[200005],dpR[200005],n,D,a[200005];
long long ans;
int Min(int x,int y){return x>y?y:x;}
int main()
{
	scanf("%d%d",&n,&D);
	for(int i=0;i<n;i++)
	scanf("%d",a+i),ans+=a[i]+D;
	ans-=D;
	dpR[0]=a[0];
	for(int i=1;i<n;i++)
	dpR[i]=Min(dpR[i-1]+D,a[i]);
	dpL[n-1]=a[n-1];
	for(int i=n-2;i>=0;i--)
	dpL[i]=Min(dpL[i+1]+D,a[i]);
	for(int i=1;i<n-1;i++)
	ans+=Min(dpL[i],dpR[i]);
	printf("%lld\n",ans);
	return 0;
} 