#include<iostream>
#include<vector>
#include<queue>
#include<cstring>
#include<cmath>
#include<map>
#include<stack>
#include<cstdio>
#include<algorithm>
using namespace std;
typedef long long ll;
const int inf = 0x3f3f3f3f;
#define mp make_pair
#define pb push_back
#define fi first
#define se second
#define fast ios::sync_with_stdio(false), cin.tie(0), cout.tie(0)
const int mod = 1e9 + 7;
ll t, n, m;
int dp[200500];
int main(){
    fast;
    for (int i = 0; i < 9;i++){
        dp[i] = 2;
    }
    dp[9] = 3;
    for (int i = 10; i < 200005;i++){
        dp[i] = (dp[i - 9] + dp[i - 10]) % mod;
    }
    cin >> t;
    while(t--){
        cin >> n >> m;
        ll ans = 0;
        while(n>0){
            int x = n % 10;
            ans += ((m + x < 10) ? 1 : dp[m + x - 10]);
            ans %= mod;
            n /= 10;
        }
        cout << ans << "\n";
    }
    return 0;
}