#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
char a[20];
ll dp[200020];
ll cnt1[10];
ll cnt2[10];
ll mod=1e9+7;
int main()
{
	cnt1[0]=1;
	for(int i=1;i<=9;i++){
		cnt1[i]=0;
	}
	dp[0]=1;
	for(int i=1;i<200020;i++){
		if(i%2==1){
			memset(cnt2,0,sizeof(cnt2));
		}else{
			memset(cnt1,0,sizeof(cnt1));
		}
		for(int j=0;j<9;j++){
			if(i%2==1){
				cnt2[j+1]=cnt1[j]%mod;
			}else{
				cnt1[j+1]=cnt2[j]%mod;
			}		
		}
		if(i%2==1){
			cnt2[0]=(cnt2[0]+cnt1[9])%mod;
			cnt2[1]=(cnt2[1]+cnt1[9])%mod;
		}else{
			cnt1[0]=(cnt1[0]+cnt2[9])%mod;
			cnt1[1]=(cnt1[1]+cnt2[9])%mod;
		}
		ll sum=0;
		for(int j=0;j<10;j++){
			if(i%2==1){
				sum=(sum+cnt2[j])%mod;
			}else{
				sum=(sum+cnt1[j])%mod;
			}	
		}
		dp[i]=sum%mod;
	}	
	ll t;
	scanf("%lld",&t);
	while(t--){
		ll n,m;
		memset(a,'\0',sizeof(a));
		scanf("%s%lld",a,&m);
		ll sum=0;
		for(int i=0;i<strlen(a);i++){
			sum=(sum%mod+dp[a[i]-'0'+m]%mod)%mod;
		}
		printf("%lld\n",sum);
	} 
 	return 0;
}

