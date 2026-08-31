#include<iostream>
#include<set>
using namespace std;
int n,m,x,i;
set<int>s;
int dp[100010];
int main(){
	ios::sync_with_stdio(false);
	cin.tie(0);
	cin>>n>>m;
	for(i=0;i<m;++i){
		cin>>x;
		s.insert(x);
	}
	dp[0]=1;
	for(int i=1;i<=n;++i){
		if(s.find(i)!=s.end())
			continue;
		for(int j=i-1;j>=i-2;--j)
			dp[i]+=dp[j];
		dp[i]%=1000000007;
	}
	cout<<dp[n];
	return 0;
}