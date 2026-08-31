#include<bits/stdc++.h>
using namespace std;
#define DONTSYNC ios_base::sync_with_stdio(false);   cin.tie(NULL); cout.tie(NULL) //dont use stdio with iostream functions //input and output are out of order now!
#define TEST unsigned long long T; cin>>T; while(T--)  //loop over each testcase
#define endl "\n"
#define fori(a,start,end) for(int a=start;a<end;a++)
#define forll(a,start,end) for(long long a=start;a<end;a++)
#define forull(a,start,end) for(unsigned long long a=start;a<end;a++)
#define fi first
#define se second
typedef long long     ll;
typedef long double   ld;
typedef pair<int,int> pii;
typedef pair<ll,ll>   pll;
typedef vector<int>   vi;
typedef vector<ll>    vl;
typedef vector<pii>   vii;
typedef vector<pll>   vll;
typedef vector<vi>    vvi;
typedef vector<vl>    vvl;
const double PI = acos(-1);
int mod=1e9+7;
void solve(vl &dp){
    /* code */
    ll res=0;
    ll n; int m; cin>>n>>m;
    while(n){
        int d=n%10;
        n/=10;
        res=(1+res+dp[d+m])%mod;
    }
    cout<<res<<endl;
}

int main()
{
    DONTSYNC;
    int MX=2e5+20;
    vl dp(MX,0); dp[10]=1;
    fori(i,0,MX){
        if(dp[i] && i+9<MX){
            dp[i+9]=(dp[i+9]+dp[i])%mod;
        }
        if(dp[i] && i+10<MX){
            dp[i+10]=(dp[i+10]+dp[i])%mod;
        }
        if(i){
            dp[i]=(dp[i]+dp[i-1])%mod;
        }
    }
    TEST
    solve(dp);
    return 0;
}
