#include <bits/stdc++.h>
using namespace std;

int a[50],b[50],c[50],d[50];
int n,m;

int main(){
	cin >> n >> m;

	for(int i=0;i<n;++i)cin>>a[i]>>b[i];
	for(int i=0;i<m;++i)cin>>c[i]>>d[i];
	
	for(int i=0;i<n;++i){
		int ans=0,min=1e9;
		for(int j=0;j<m;++j){
			if(abs(a[i]-c[j])+abs(b[i]-d[j])<min){
				ans=j+1;
				min=abs(a[i]-c[j])+abs(b[i]-d[j]);
			}
		}
		cout << ans << endl;
	}
	return 0;
}