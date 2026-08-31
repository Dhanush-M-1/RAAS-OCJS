#include <bits/stdc++.h>
using namespace std;
#define ll long long
#define  ff first
#define  ss second
#define sz(a) (ll)a.size()
#define lli long long int
#define pb push_back
#define pf push_front
#define fast ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL) ;
#define M 1000000007
#define pi 3.1415926535
//nck use fermit theorem mod inverse a-1%p=(a pow p-2)%p
//vector<ll> g[]
//vector<bool> vis()
//set lower bound set_name.lower_boubnd(key)

 ll dp[10][200001];

 int main(){

    fast;
     ll t;
     cin>>t;
    
     
     for(int i=0;i<10;i++){
     	dp[i][0]=1;
	 }
     
     for(int i=1;i<=200000;i++){
     
     	for(int j=0;j<9;j++){
     		dp[j][i]=dp[j+1][i-1]%M;
		 }
		 dp[9][i]=(dp[0][i-1]+dp[1][i-1])%M;
	 }
     
    
     while(t--){
     	
     	ll n,m;
     	string s;
     	cin>>s>>m;
     
     	ll ans=0;
     	for(auto x:s){
     		ans+=dp[x-'0'][m];
     		ans=ans%M;
		 }

cout<<ans<<"\n";

     }
     return 0;
 }



