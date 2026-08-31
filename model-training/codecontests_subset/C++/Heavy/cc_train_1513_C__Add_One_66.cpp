#include <iostream>
#include <bits/stdc++.h>
using namespace std;

#define MOD 1000000007
#define fr(i,n) for(int i=0;i<n;i++)
#define fr1(i,k,n) for(int i=k;i<n;i++)
#define foreach(i,arr) for(auto i: arr)
#define sort_inc(a) sort(a.begin(),a.end())
#define sort_dec(a) sort(a.begin(),a.end(),greater<>())
#define exists(a,val) find(a.begin(),a.end(),val)!=a.end()

typedef long long ll;
typedef unsigned long long ull;

template <typename T> T mod(T a){ a %= MOD; if (a<0) a += MOD; return a; }
template <typename T> T add(T a, T b){ return mod(a+b); }
template <typename T> T mul(T a, T b){ return (a * 1ll * b) % MOD; }
template <typename T> T binPow(T a, T b){ T res = 1; while (b>0){ if (b&1) res = mul<T>(res, a); a = mul<T>(a,a); b >>= 1; } return res; }

const int N = 2*1e5 + 5;
int dp[10][N];

void solve(){
    int n,m;
    cin>>n>>m;

    vector<int> a(10);
    int n1=n;
    while(n1){
        a[n1%10]++;
        n1 /= 10;
    }
    
    int res = 0;
    for (int i=0;i<10;i++){
        res = add(res, mul(dp[i][m], a[i]));
    }
    cout<<res<<"\n";
}

int main(int argc, const char * argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    for (int i=0;i<10;i++) dp[i][0] = 1;
    
    for (int i=1;i<N;i++){
        for (int j=0;j<=8;j++){
            dp[j][i] = dp[j+1][i-1];
        }
        dp[9][i] = add(dp[0][i-1],dp[1][i-1]);
    }
    
    
    int t=1;
    cin>>t;
    for (int i=0;i<t;i++){
        solve();
    }
    
    return 0;
}
