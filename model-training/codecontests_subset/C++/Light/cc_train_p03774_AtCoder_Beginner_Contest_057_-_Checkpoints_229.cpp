#include<bits/stdc++.h>
using namespace std;
int a[1021],b[1021],c[1021],d[1021],ans;
int main(){
	int n,m;
	cin>>n>>m;
	for(int i=1;i<=n;i++){
		cin>>a[i]>>b[i];
	}
	for(int i=1;i<=m;i++){
		cin>>c[i]>>d[i];
	}
	for(int i=1;i<=n;i++){
		int sum=1e9;
		for(int j=1;j<=m;j++){
			if(abs(c[j]-a[i])+abs(d[j]-b[i])<sum){
				sum=abs(c[j]-a[i])+abs(d[j]-b[i]);
				ans=j;
			}
		}
		cout<<ans<<endl;
	}
	return 0;
}