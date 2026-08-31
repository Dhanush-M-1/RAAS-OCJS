#include <bits/stdc++.h>
using namespace std;

#define fi first
#define se second
#define mp make_pair
#define pb push_back
#define eb emplace_back
typedef long long ll;
typedef pair<int, int> pi;

int n;
const int maxn = 105;

int c[maxn], b[maxn];

ll dp[maxn][maxn * maxn];
const int mod = 1e9 + 7;

void add(ll &a, ll b){
    a += b;
    if(a >= mod)
        a -= mod;
}

int main(){
    ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    cin >> n;
    ll S = 0;
    c[0] = 0;
    for(int i = 1;i <= n;i++){
        cin >> c[i];
        S += c[i];
    }
    b[0] = 0;
    for(int i = 1;i < n;i++){
        cin >> b[i];
    }
    dp[0][0] = 1;
    int Q;
    cin >> Q;
    ll x;
    cin >> x;
    ll B = 0;
    ll B2 = 0;
    for(int i = 0;i < n;i++){
        B += b[i];
        B2 += B;
        for(int j = 0;j <= S;j++){
            ll sum = x * (i + 1) + B2;
            ll lb = max(0LL, sum - j);
            for(int k = lb;k <= c[i+1] and k + j <= S;k++){
                add(dp[i+1][k + j], dp[i][j]);
            } 
        } 
    }
    ll ans = 0;
    for(int j = 0;j <= S;j++){
        add(ans, dp[n][j]);
    }
    cout << ans << endl;
    return 0;
}
