#include<bits/stdc++.h>
using namespace std;
#define int long long
const int max_n = 200005, mod = 1000000007;
int p[max_n];
signed main() {

    for (int i = 0; i < 9; i ++)p[i] = 2;
    p[9] = 3;
    for (int i = 10; i < max_n; i ++) {
        p[i] = (p[i - 9] + p[i - 10]) % mod;
    }
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    while (t --) {
        int n, m;
        cin >> n >> m;
        int ans = 0;
        while (n > 0) {
            int x = n % 10;
            ans += ((m + x < 10) ? 1 : p[m + x - 10]);
            ans %= mod;
            n /= 10;
        }
        cout << ans << "\n";  
    }
    return 0;
}
