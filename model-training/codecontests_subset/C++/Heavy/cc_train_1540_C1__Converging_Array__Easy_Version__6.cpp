#include<bits/stdc++.h>
using namespace std;

#define int  long long  
#define rep(i,a,b)    for(int i=a;i<b;i++)
#define repn(i,a,b)   for(int i=a;i>=b;i--)
#define ff first
#define ss second
#define lb lower_bound
#define ub upper_bound
#define pii pair<int,int>
#define vi vector<int>
#define vl vector<long long>
#define vs vector<string>
#define vii vector<pii>
#define vvi vector<vector<int>>
#define vvii vector<vector<pair<int,int>>> 
#define pb push_back
#define ppb pop_back
#define pf push_front
#define ppf pop_front
#define sz(x) (int)x.size()
#define all(v) (v).begin(), (v).end()   
#define ret(x) return cout<<x,0;
#define rety return cout<<"YES",0;
#define retn return cout<<"NO",0;
#define fl fflush(stdout)   
#define hell 1000000007
#define hell2 998244353 
#define pi 3.14159265358979323846

int solve(){
	
	int n;
    cin>>n;
    int c[n];
    rep(i,0,n)cin>>c[i];
    int b[n-1];
    rep(i,0,n-1)cin>>b[i];
    int q,x;
    cin>>q>>x;
    
    // int dp[10005]={0};
    vi dp(100005,0);
    rep(i,0,c[0]+1)dp[i]=1;
    if(x>10005){
    	cout<<0;
    	return 0;
    }
    rep(i,0,x)dp[i]=0;
    
    int cur=x,temp=x;
    
    rep(i,1,n){
    	vi sum=dp;
    	rep(i,1,10005)sum[i]=(sum[i]+sum[i-1])%hell;
    	rep(j,0,10005){
    		int k=j-c[i]-1;
    		dp[j]=sum[j];
    		if(k>=0)dp[j]=(dp[j]-sum[k])%hell;
    		dp[j]%=hell;
    	}
    	temp=(temp+b[i-1])%hell;
    	cur=(cur+temp)%hell;
    	if(cur>10002){
    	    cout<<0;
    	    return 0;
    	}
    	cur=min(cur,10002LL);
    	
    	rep(j,0,cur)dp[j]=0;

    }

    int ans=0;
    rep(i,0,10005)ans=(ans+dp[i])%hell;
    if(ans<0)ans+=hell;
    cout<<ans;

    // rep(i,0,100)cout<<dp[i]<<" ";

	return 0;	

}

signed main(){

	#ifndef ONLINE_JUDGE
    freopen("input.txt", "r" , stdin);
    freopen("output.txt", "w", stdout);
    #endif

    ios_base::sync_with_stdio(false);cin.tie(0);cout.tie(0);
 	
    int t=1;
    // cin>>t;
    while(t--){
    	solve(),
    	cout<<"\n";
    }

	return 0;
}

