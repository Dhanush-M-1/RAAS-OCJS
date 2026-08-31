#include<cstdio>
#include<cstdlib>
int main(){
	int n,m;
	int a[50],b[50],c[50],d[50];
	scanf("%d %d",&n,&m);
	for(int i=0;i<n;i++) scanf("%d %d",a+i,b+i);
	for(int i=0;i<m;i++) scanf("%d %d",c+i,d+i);
	for(int i=0;i<n;i++){
		int ans,mi;
		for(int j=0;j<m;j++){
			int dist = abs(a[i]-c[j]) + abs(b[i]-d[j]);
			if(j==0||dist<mi){
				mi = dist;
				ans = j + 1;
			}
		}
		printf("%d\n",ans);
	}
}
