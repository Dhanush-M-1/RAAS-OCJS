#include<cstdio>
#include<cmath>
using namespace std;
int main(void)
{
	int n,m,i,j,t;
	int a[51],b[51],c[51],d[51];
	int dist[51][51];
	scanf("%d %d",&n,&m);
	for(i=0;i<n;i++)
		scanf("%d %d",&a[i],&b[i]);
	for(i=0;i<m;i++)
		scanf("%d %d",&c[i],&d[i]);
	for(i=0;i<n;i++){
		for(j=0;j<m;j++){
			dist[i][j]=abs(a[i]-c[j])+abs(b[i]-d[j]);
		}
		t=0;
		for(j=1;j<m;j++){
			if(dist[i][j]<dist[i][t])t=j;
		}
		printf("%d\n",t+1);
	}
	return 0;
}
			