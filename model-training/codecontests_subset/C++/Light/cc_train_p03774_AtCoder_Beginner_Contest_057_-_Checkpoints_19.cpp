#include <bits/stdc++.h>
 
using namespace std;

int N,M;
int a[55],b[55],c[55],d[55];
int ans[55];
const int INF=1000000007;

int main(){

cin>>N>>M;

for(int i=0; i<N; i++) scanf("%d %d",&a[i],&b[i]);
for(int i=0; i<M; i++) scanf("%d %d",&c[i],&d[i]);

for(int i=0; i<N; i++){
	int Min=INF; int p;
	for(int j=0; j<M; j++){
		int mh=abs(a[i]-c[j])+abs(b[i]-d[j]);
		if(mh<Min){
			Min=mh; p=j+1;
		}
	}
	ans[i]=p;
}

for(int i=0; i<N; i++) printf("%d\n",ans[i]);

return 0;
 
}