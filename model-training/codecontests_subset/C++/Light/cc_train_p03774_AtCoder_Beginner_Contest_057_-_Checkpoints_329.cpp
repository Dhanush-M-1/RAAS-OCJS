#include<bits/stdc++.h>
int n,m;
int ax[55],ay[55],bx[55],by[55];
int main(){
	scanf("%d%d",&n,&m);
	for(int i=1; i<=n; i++)
		scanf("%d%d",&ax[i],&ay[i]);
	for(int j=1; j<=m; j++)
		scanf("%d%d",&bx[j],&by[j]);
	for(int i=1; i<=n; i++){
		int bes = 1000000000, id = -1;
		for(int j=1; j<=m; j++){
			int now = labs(bx[j]-ax[i]) + labs(by[j]-ay[i]);
			if(now < bes){
				bes = now;
				id = j;
			}
		}
		printf("%d\n",id);
	}
	return 0;
}