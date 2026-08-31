#include <bits/stdc++.h>
using namespace std;
int n,m,ans,man;
int a[55],b[55],c[55],d[55];
int main(){
	cin>>n>>m;
	for(int i=1;i<=n;i++)cin>>a[i]>>b[i];
	for(int i=1;i<=m;i++)cin>>c[i]>>d[i];
	
	for(int i=1;i<=n;i++){
		int man=999999999;
		int ans=0;
		for(int j=1;j<=m;j++){
			if(man>abs(a[i]-c[j])+abs(b[i]-d[j])){
				man=abs(a[i]-c[j])+abs(b[i]-d[j]);
				ans=j;
			}
		}
		cout<<ans<<endl;
	}
}