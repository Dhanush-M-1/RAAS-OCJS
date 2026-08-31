#include<cstdio>
#include<cstring>
int a[51],b[51],c[51],d[51],ans[51],min[51];
int abs(int x) {return x>0?x:-x;}
int main()
{
	int n,m;
	scanf("%d%d",&n,&m);
	for(int i=1;i<=n;i++) scanf("%d%d",&a[i],&b[i]);
	for(int i=1;i<=m;i++) scanf("%d%d",&c[i],&d[i]);
	memset(min,0x3f,sizeof(min));
	for(int i=1;i<=n;i++)
	for(int j=1;j<=m;j++)
	{
		int s=abs(a[i]-c[j])+abs(b[i]-d[j]);
		if(s<min[i]) {min[i]=s;ans[i]=j;}
	}
	for(int i=1;i<=n;i++)
	printf("%d\n",ans[i]);
	return 0;
}