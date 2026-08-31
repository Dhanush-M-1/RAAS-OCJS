#include<bits/stdc++.h>
using namespace std;
int main() {
	int N,M;
	cin>>N>>M;
	vector<int> a(N+1);
	for(int i=0;i<M;i++){
		int j;
		cin>>j;
		a[j]++;
	}
	vector<long long> dp(N+1);
	dp[0]=1;
	for(int i=0;i<N;i++) {
		for(int j=i+1;j<=min(i+2,N);j++){
			if(a[j]==0) {
				dp[j]+=dp[i];
				dp[j]%=1000000007;
			}
		}
	}
	long long ans=dp[N];
	cout<<ans<<endl;
	return 0;
}