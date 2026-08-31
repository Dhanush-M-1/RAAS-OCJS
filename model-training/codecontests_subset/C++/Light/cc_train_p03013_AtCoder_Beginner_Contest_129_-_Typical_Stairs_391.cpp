#include<bits/stdc++.h>
#define mod 1000000007
using namespace std;
int main(){
	int n,m;
	cin>>n>>m;
	unordered_map<int,int>arr;
	for(int i=0;i<m;i++){
		int temp;
		cin>>temp;
		arr[temp]++;
	}
	vector<int>dp(n+1,0);
	dp[0]=1;
	if(arr.find(1)==arr.end())
		dp[1]=1;
	for(int i=2;i<=n;i++){
		if(arr.find(i)==arr.end()){
			dp[i]=(dp[i-1]+dp[i-2])%mod;
		}
	}
	cout<<dp[n];
	return 0;
}