#include <bits/stdc++.h>
using namespace std;

#define int long long   
#define pii pair<int,int>
#define int64 int64_t
#define IOS ios_base::sync_with_stdio(false);cin.tie(0);cout.tie(0);
#define ll long long 
#define pb push_back
#define str string
#define ri(x) int x;cin>>x;
#define rl(x) ll x; cin>>x;
#define rs(x) str x; cin>>x;
#define rd(x) d x; cin>>x;
#define w(x) cout<<x
#define vec(x) std::vector<x> 
#define nl '\n'
#define all(x) x.begin(),x.end() 
#define debug(x) for(auto y : x) {cout<<y<<" ";} cout<<nl;
#define PI 3.14159265358979323846264338327950L
#define rep(i,a,b) for(int i=a;i<b;i++)
#define per(i,n) for(int i=n-1;i>=0;i--)
#define vi vector<int>
const unsigned int M = 1000000007;
// int n,m,k,q;
const int mxN=2e5;
const int N = 100031;
bool bad = false;

// Target 4-problems
int dirs[5] =  {-1,0,1,0,-1};


bool dp[2][27];

bool dfs(string s,char lastv){
    int n = s.size();
    char first = s[0], last = s[n-1];
    bool ans;
    if(s.size()==1 && s[0]=='a')return true;
    if(s.size()==1)return false;
        char temp = lastv-1;  
        // cout<<temp<<nl;
    if(s[n-1]==lastv){
        ans = dfs(s.substr(0,n-1),temp);
    }else if(s[0]==lastv){
        ans = dfs(s.substr(1),temp);
    }else{
        return false;
    }
    return ans;
}

void solve(){
    int k, n,m; cin>>k>>n>>m;
    int tot = k;
    vi a(n),b(m); rep(i,0,n){
        cin>>a[i];
    }
    rep(i,0,m){
        cin>>b[i];
    }
    int i=0,j=0;
    // sort(all(a)); sort(all(b));
    // for(auto x: a){
    //     cout<<x<<" ";
    // }
    // cout<<nl;
    // for(auto x:b){
    //     cout<<x<<" ";
    // }
    // cout<<nl;
    vi ans;
    for(int l=0;l<n+m;l++){
        if(i<n && a[i]<=tot && a[i]!=0){
            // cout<<a[i]<<" ";
            ans.pb(a[i++]);
        }else if(j<m&&b[j]<=tot && b[j]!=0){
            ans.pb(b[j++]);
        }else if(i<n && a[i]==0){
            tot++; i++;
            ans.pb(0);
        }else if(j<m && b[j]==0){
            tot++; j++;
            ans.pb(0);
        }else {
            cout<<-1<<nl;
            return;
        }
    }
    for(auto x: ans){
        cout<<x<<" ";
    }
    cout<<nl;
}
signed main(){
	IOS;
    int t; cin>>t;
    // int t = 1;
    while(t--){
        solve();
    }
}


