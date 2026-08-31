#include<bits/stdc++.h>
using namespace std;
const int N = 5e3+100;
int tag[N];
typedef long long ll;
ll s[N];
ll dp[N],ans[N];
int main(){
	int t;
	scanf("%d",&t);
	while(t--){
		int n;
		scanf("%d",&n);
		for(int i = 1; i <= n; i++) scanf("%d",&tag[i]);
		for(int i = 1; i <= n; i++) scanf("%lld",&s[i]);
		memset(dp,0,sizeof(dp));
		memset(ans,0,sizeof(ans));
		for(int i = 1; i <= n; i++){
			memset(dp,0,sizeof(dp));
			for(int j = 1; j < i; j++){
				if(tag[i]!=tag[j])
					dp[j]=ans[j]+abs(s[i]-s[j]);
			}
			ll mx=dp[i];
			for(int j = i-1; j >= 1; j--){
				if(tag[i]!=tag[j])
				ans[j]=max(ans[j],mx+abs(s[i]-s[j]));
				mx=max(mx,dp[j]);
			}
			for(int j = 1; j <= n; j++) ans[i]=max(ans[i],dp[j]);
		}
		ll ret=0;
		for(int i = 1; i <= n; i++) ret=max(ret,ans[i]);
		printf("%lld\n",ret); 
	}
	return 0;
}