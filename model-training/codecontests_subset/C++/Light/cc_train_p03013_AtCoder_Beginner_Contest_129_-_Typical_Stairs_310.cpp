#include<bits/stdc++.h>
using namespace std;

#define mod 1000000007

int main() {

	int n,k,x; cin>>n>>k;
	vector<int>dp(n+1,0);
	set<int>sy;
    dp[0]=1;
	for(int i=0;i<k;i++) {
		cin>>x; sy.insert(x);
	}
    if(!sy.count(1)) dp[1]=1;
        for(int i=2;i<=n;i++) {
            if(!sy.count(i))  dp[i]=((dp[i-1]%mod)+(dp[i-2]%mod))%mod;
        }
    cout<<dp[n]<<endl;
	return 0;
}