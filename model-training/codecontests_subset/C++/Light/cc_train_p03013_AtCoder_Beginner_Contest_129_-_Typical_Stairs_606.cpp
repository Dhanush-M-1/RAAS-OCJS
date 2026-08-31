#include<bits/stdc++.h>
using namespace std;
int n,m,t,a[100005];
bool able[100005];
int main(){
	cin>>n>>m;
	for(int i=1;i<=m;i++){
		cin>>t;
		able[t+1]=1;
	}
	n++;
	a[1]=1;
	for(int i=2;i<=n;i++){
		if(able[i]){
			continue;
		}
		a[i]=((long long)(a[i-1])+a[i-2])%1000000007;
	}
	cout<<a[n];
	return 0;
}