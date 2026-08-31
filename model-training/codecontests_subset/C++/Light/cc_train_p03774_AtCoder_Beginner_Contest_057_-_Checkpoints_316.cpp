#include<bits/stdc++.h>
using namespace std;
int main(){
	int n,m,a[51],b[51],c[51],d[51],i,j,minv=1e9,minn;
	cin>>n>>m;
	for(i=1;i<=n;i++)
		cin>>a[i]>>b[i];
	for(i=1;i<=m;i++)
		cin>>c[i]>>d[i];
	for(i=1;i<=n;i++){
		minv=1e9;
		for(j=1;j<=m;j++)
			if(abs(c[j]-a[i])+abs(d[j]-b[i])<minv){
				minv=abs(c[j]-a[i])+abs(d[j]-b[i]);
				minn=j;
			}
		cout<<minn<<endl;
	}
	return 0;
} 