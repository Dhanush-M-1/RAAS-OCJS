#include<bits/stdc++.h>
using namespace std;
int main(){
	int T;
	cin>>T;
	while(T--){
		int n;cin>>n;
		vector<int>tag(n),s(n);
		vector<long long>dp(n);
		for(auto& i:tag)cin>>i;
		for(auto& i:s)cin>>i;
		for(int i=n-1;i>=0;i--){
			for(int j=0;j<i;j++){
				if(tag[i]==tag[j])continue;
				long long dpi=dp[i],dpj=dp[j];
				int p=abs(s[i]-s[j]);
				dp[i]=max(dpi,dpj+p);
				dp[j]=max(dpj,dpi+p);
			}
		}
		cout<<*max_element(dp.begin(),dp.end())<<'\n';
	}
} 