#include <bits/stdc++.h>
using namespace std;

long long n, m, t, a[100005], dp[100005];
int main(){
    cin >> n >> m;
    for(int i = 0; i < m; i++){ cin >> t; a[t] = 1; }
    dp[0] = 1;
    for(int i = 1; i <= n; i++){
        if(!a[i]){
            if(i-2 >= 0) dp[i] += dp[i-2];
            dp[i] += dp[i-1];
        }
        dp[i] %= 1000000007LL;
    }
    cout << dp[n];
}
