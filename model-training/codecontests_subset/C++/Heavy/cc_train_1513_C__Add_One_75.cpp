#include<bits/stdc++.h>
using namespace std;
#define ll long long
#define f(i,a,n) for(ll i=a ;i<n ;i++)
#define fr(i,a,n) for(ll i=n-1;i>=a;i--)
#define pb push_back
#define read(a,n) for(ll i=0 ;i<n ;i++)cin>>a[i]
#define F first
#define S second
#define endl "\n"

bool pali(string s)
{
    for(ll i=0 ;i<s.size()/2 ;i++)
    if(s[i]!=s[s.size()-i-1])
    return false;

    return true;
}

void no(){
	cout<<-1<<endl;
}

void yes(){
	cout<<"YES\n";
}
ll mod=1000000007;
///////////////////////////////////////////////////////////////////

ll dp[10][200005]={0};

ll solve(int n ,int m)
{
	if(m<10-n)
	return 1;
	
	if(dp[n][m]!=0)
	return dp[n][m]%mod;

	else{
		dp[n][m]=((solve(1,m-(10-n))%mod)+(solve(0,m-(10-n)))%mod)%mod;
		return dp[n][m];
	}	
}

int size(int n)
{
	int ans=0;
	while(n>0)
	{
		ans++;
		n/=10;
	}
	return ans;
}

int main()
{
	ios::sync_with_stdio(0);
    cin.tie(0);
    ll t = 1; 
    cin>>t;
    while(t--){
    	int n,m;
    	cin>>n>>m;
    	ll ans=0;
    	while(n>0)
    	{
    		ans+=(solve(n%10,m)%mod);
    		ans%=mod;
    		n/=10;
		}
    	cout<<ans<<endl;
	}
    return 0;
}
