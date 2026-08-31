#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int n;
ll moder = 1000000007;
ll dp[100005];
ll f(int curr){
	if(curr>n) return 0;
	ll&ret = dp[curr];
	if(~ret) return ret;
	ret = 0;
	ret+=f(curr+1)+f(curr+2);
	return ret%=moder;
}
int main(){
	memset(dp,-1,sizeof(dp));
	int m;
	cin>>n>>m;
	dp[n] = 1;
	while(m--){
		int a;
		cin>>a;
		dp[a] = 0;
	}
	cout<<f(0);
}